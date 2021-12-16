<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2021-12-16
  Time: 오후 3:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="path" value="${pageContext.request.contextPath}"/>

<fmt:formatNumber value="${response.quotes.usdkrw}" pattern=".00" var="usdkrw"/>
<fmt:formatNumber value="${response.quotes.usdjpy}" pattern=".00" var="usdjpy"/>
<fmt:formatNumber value="${response.quotes.usdphp}" pattern=".00" var="usdphp"/>


<html>
<head>
    <title>환율 계산</title>
    <link rel="stylesheet" href="${path}/resources/main.css">
</head>
<body>

<div id="container">
    <div class="row">
        <h2>환율 계산</h2>
    </div>

    <div class="row switch_wrap">

        <div class="col_left">
            실시간 조회
        </div>
        <div class="col_right">
            <input type="checkbox" id="switch" hidden>
            <label for="switch" class="switch_label">
                <span class="onf_btn"></span>
            </label>
        </div>


    </div>

    <div class="row">
        <div class="col_left">
            <label for="send">송금국가: </label>
        </div>
        <div class="col_right">
            <input type="text" name="send" id="send" data-currency="USD" value="미국(USD)" disabled>
        </div>
    </div>

    <div class="row">
        <div class="col_left">
            <label for="receive">수취국가: </label>
        </div>
        <div class="col_right">
            <select name="receive" id="receive">
                <option value="${usdkrw}" data-currency="KRW" selected>한국(KRW)</option>
                <option value="${usdjpy}" data-currency="JPY">일본(JPY)</option>
                <option value="${usdphp}" data-currency="PHP">필리핀(PHP)</option>
            </select>
        </div>
    </div>

    <div class="row">
        <div class="col_left">
            <label for="exrate">환율: </label>
        </div>
        <div class="col_right">
            <input type="text" name="exrate" id="exrate" data-val="${usdkrw}" value="${usdkrw}KRW/USD" disabled>
        </div>
    </div>

    <!--  송금액  -->
    <div class="row">
        <div class="col_left">
            <label for="amount">송금금액: </label>
        </div>
        <div class="col_right">
            <input type="text" name="amount" id="amount">
        </div>
    </div>

    <!--  메시지 알림  -->
    <div class="row">
        <p id="message"></p>
    </div>

    <div class="row">
        <button id="submit" type="button">Submit</button>
    </div>
</div>





<script src="${path}/resources/main.js"></script>
</body>
</html>
