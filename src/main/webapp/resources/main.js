'use strict';

(function (){
    const elSend = document.querySelector("#send"); //송금국가
    const elReceive = document.querySelector("#receive"); //수취국가
    const elExrate = document.querySelector("#exrate"); //환율
    const elAmount = document.querySelector("#amount"); //송금금액
    const elRealtime = document.querySelector("#switch"); //실시간
    const elMessage = document.querySelector("#message"); //메시지 알림
    const btnSubmit = document.querySelector("#submit"); //제출 버튼
    let realtime = false;

    //수취국가 변경시 동작
    elReceive.addEventListener("change", ()=>{

        elExrate.value = elReceive.value
            + elReceive.querySelector(':checked').dataset.currency
            + "/"
            + elSend.dataset.currency;

        //환율정보 갱신여부
        if(realtime) {
            console.log("갱신");
        }else {
            console.log("비갱신");
        }

    });

    //실시간 버튼 클릭시 동작
    elRealtime.addEventListener("change", ()=>{
        realtime = elRealtime.checked;
    });

    //제출 버튼 클릭시 동작
    btnSubmit.addEventListener("click", ()=>{
        //수취금액 미입력 확인

        const exrate = elReceive.querySelector(':checked').value;
        const amount = elAmount.value;
        const receiveAmount = (exrate * amount).toLocaleString('ko-kr');
        const currency = elReceive.querySelector(':checked').dataset.currency;

        elMessage.innerHTML = `수취 금액은 ${receiveAmount} ${currency}입니다.`;
    });



    function changeReceiveCurrency (hi) {
        //.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
        Math.floor();
        hi.dataset.currency.toLocaleString('ko-kr');
    }

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

