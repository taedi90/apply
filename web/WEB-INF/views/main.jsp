<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2021-12-16
  Time: 오후 3:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>환율 계산</title>
</head>
<body>
<form action="">
    <h1>환율 계산</h1>
    <p>송금국가: 미국(USD)</p>
    <label for="">수취국가: </label>
    <select name="" id="">
        <option value="">한국(KRW)</option>
        <option value="">일본(JPY)</option>
        <option value="">필리핀(PHP)</option>
    </select>
    <p>환율: --</p>
    <label for="">송금액: </label> <input type="text">USD

    <br>
    <button type="submit" style="padding:5px 20px;">Submit</button>
</form>
</body>
</html>
