'use strict';

(function (){
    const elUpdate = document.querySelector("#switch"); //환율 갱신
    const elSend = document.querySelector("#send"); //송금국가
    const elReceive = document.querySelector("#receive"); //수취국가
    const elExrate = document.querySelector("#exrate"); //환율
    const elAmount = document.querySelector("#amount"); //송금금액
    const elMessage = document.querySelector("#message"); //메시지 알림창
    const btnSubmit = document.querySelector("#submit"); //제출 버튼

    //수취국가 변경시 동작
    elReceive.addEventListener("change", ()=>{
        initElMessage(); //메세지 창 초기화

        //환율 정보 표시
        elExrate.value = elReceive.value
            + elReceive.querySelector(':checked').dataset.currency
            + "/"
            + elSend.dataset.currency;

    });

    //환율 갱신 버튼 클릭시 동작
    elUpdate.addEventListener("change", ()=>{
        initElMessage(); //메세지 창 초기화

        elUpdate.setAttribute('disabled','disabled');  //갱신 버튼 비활성화
        btnSubmit.setAttribute('disabled','disabled'); //제출 버튼 비활성화

        updateExrate();
    });

    //송금금액 변경시 동작
    elAmount.addEventListener("keyup", ()=>{
        initElMessage(); //메세지 창 초기화

        elAmount.value = elAmount.value.replace(/[^0-9]/gi,''); //숫자외 문자 제거
    });

    //제출 버튼 클릭시 동작
    btnSubmit.addEventListener("click", ()=>{
        //수취금액 정상여부 확인
        const amount = elAmount.value;
        if(amount < 0 || amount > 10000) { // 0 미만 또는 10,000 USD 초과 필터
            elMessage.style.color = 'red';
            elMessage.innerHTML = `송금액이 바르지 않습니다.`;
            return;
        }

        //환율 정보 확인
        const exrate = elReceive.querySelector(':checked').value;
        if(exrate < 0 || exrate === ''){
            elMessage.style.color = 'red';
            elMessage.innerHTML = `환율 정보를 확인할 수 없습니다.<br>잠시후 다시 시도해주세요.`;
            updateExrate();
            return;
        }

        const receiveAmount = (exrate * amount).toLocaleString('ko-kr');
        const currency = elReceive.querySelector(':checked').dataset.currency;

        elMessage.innerHTML = `수취 금액은 ${receiveAmount} ${currency} 입니다.`;
    });


    //환율 갱신
    function updateExrate(){
        ajax('exchange-rate',{method:'get',callback:(result)=>{cbkupdateExrate(result)},errorCallback:()=>{updateExrateFail()}});
    }

    function cbkupdateExrate(result){
        result = JSON.parse(result);
        console.log(result);

        if(result.success === true) {
            for (const [key, value] of Object.entries(result.quotes)) {
                console.log(`${key}: ${value}`);

                const currency = key.substring(3,6);
                console.log(currency);
                const exrate = value.toFixed(2);

                elReceive.querySelector(`[data-currency="${currency}"]`).value = exrate;
            }

            elMessage.innerHTML = `환율 갱신 완료!`;

        }else {
            elMessage.style.color = 'red';
            elMessage.innerHTML = `환율 갱신 실패!`;
        }

        elUpdate.checked = false;
        elUpdate.removeAttribute('disabled'); //갱신 버튼 활성화
        btnSubmit.removeAttribute('disabled'); //제출 버튼 활성화

    }

    function updateExrateFail(){
        elMessage.style.color = 'red';
        elMessage.innerHTML = `환율 갱신 실패!`;

        elUpdate.checked = false;
        elUpdate.removeAttribute('disabled'); //갱신 버튼 활성화
        btnSubmit.removeAttribute('disabled'); //제출 버튼 활성화
    }

    //메시지 알림창 초기화
    function initElMessage(){
        elMessage.style.color = 'black';
        elMessage.innerHTML = '';
    }

    //ajax 모듈
    function ajax(url = '',
                  {
                      data = {},
                      callback = (res) => console.log(res),
                      errorCallback = (res) => console.error(res),
                      method = 'post',
                      contentType = 'json'
                  } = {}) {

        if(contentType == "json") {
            contentType = "application/json; charset=utf-8";
            data = JSON.stringify(data);
        } else if (contentType == "multipart") {
            //do nothing
        } else {
            contentType = "application/x-www-form-urlencoded; charset=utf-8;";
            url = url + "?" + new URLSearchParams(Object.entries(data)).toString();
            data = null;
        }

        const xhr = new XMLHttpRequest();
        xhr.open(method, url, true);
        if(contentType != "multipart"){
            xhr.setRequestHeader('Content-Type', contentType);
        }
        xhr.send(data);

        xhr.onload = function () {
            if (xhr.status === 200 || xhr.status === 201) { // 통신 성공 시
                callback(xhr.response);
            } else { // 통신 실패 시
                errorCallback(xhr.status);
            }
        }

    }
})();