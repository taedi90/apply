# apply
환율 계산 기능 구현

## 소개

스프링을 이용한 환율 계산 어플리케이션으로, USD에 대한 KRW, JPY, PHP 환율을 계산할 수 있습니다. 

![screenshot](https://user-images.githubusercontent.com/79442559/146489730-511a1a94-f1ad-4a68-84e3-c36162496d2b.png)

### 환경

- JAVA 8
- Spring Framework 5.2.6
- HTML, CSS, Javascript

## 구현 사항
- 최초 페이지가 로딩될 때 환율 정보를 조회하여 각 요소의 속성값으로 저장합니다.
- 오류로 인하여 환율 정보를 초기화하지 못했을 경우, submit 버튼 클릭 시점에 정보를 다시 요청합니다.
- 환율 갱신 버튼을 누르면 서버에서 환율 정보를 갱신하여 전달합니다.  
  갱신 중 submit 버튼은 비활성화되며, 처리가 완료되면 갱신 결과를 알림창에 나타냅니다.
  
## 사용 API
- [currencylayer](https://currencylayer.com/)

## 링크
- 문항 출처: [wirebarley](https://github.com/wirebarley/apply)
- 데모 페이지: [바로가기](https://web.taedi.net/apply)
