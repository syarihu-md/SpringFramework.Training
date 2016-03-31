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
    <title>更新完了</title>
</head>
<body>
<h2>更新完了</h2>
<dl>
    <dt>名前</dt>
    <dd><c:out value="${editCustomer.name}"/></dd>
    <dt>住所</dt>
    <dd><c:out value="${editCustomer.address}"/></dd>
    <dt>Eメールアドレス</dt>
    <dd><c:out value="${editCustomer.emailAddress}"/></dd>
</dl>
<c:url var="url" value="/customer"/>
<a href="${url}">戻る</a>
</body>
</html>
