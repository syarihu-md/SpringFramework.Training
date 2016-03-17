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
    <title>顧客詳細画面</title>
</head>
<body>
<h2>顧客詳細画面</h2>
<dl>
    <dt>名前</dt>
    <dd><c:out value="${customer.name}"/></dd>
    <dt>住所</dt>
    <dd><c:out value="${customer.address}"/></dd>
    <dt>Eメールアドレス</dt>
    <dd><c:out value="${customer.emailAddress}"/></dd>
</dl>
<c:url value="/customer" var="url" />
<a href="${url}">一覧</a>
</body>
</html>
