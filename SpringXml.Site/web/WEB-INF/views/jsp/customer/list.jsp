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
    <title>顧客一覧画面</title>
</head>
<body>
<h2>顧客一覧画面</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>名前</th>
        <th>住所</th>
        <th>Eメールアドレス</th>
        <td></td>
    </tr>
    <c:forEach items="${customers}" var="customer">
        <tr>
            <td><c:out value="${customer.id}"/></td>
            <td><c:out value="${customer.name}"/></td>
            <td><c:out value="${customer.address}"/></td>
            <td><c:out value="${customer.emailAddress}"/></td>
            <td>
                <c:url value="/customer/${customer.id}" var="url"/>
                <a href="${url}">詳細</a>
                <c:url value="/customer/${customer.id}/edit" var="url"/>
                <a href="${url}">編集</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
