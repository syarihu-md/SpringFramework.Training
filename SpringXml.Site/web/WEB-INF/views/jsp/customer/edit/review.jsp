<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: usr0200500
  Date: 16/03/17
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>確認画面</title>
</head>
<body>
<h2>確認画面</h2>
<form method="post">
    <dl>
        <dt>名前</dt>
        <dd><c:out value="${editCustomer.name}"/></dd>
        <dt>住所</dt>
        <dd><c:out value="${editCustomer.address}"/></dd>
        <dt>Eメールアドレス</dt>
        <dd><c:out value="${editCustomer.emailAddress}"/></dd>
    </dl>
    <button type="submit" name="_event_confirmed">更新</button>
    <button type="submit" name="_event_revise">再入力</button>
</form>
</body>
</html>
