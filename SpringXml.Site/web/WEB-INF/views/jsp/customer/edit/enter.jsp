<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: usr0200500
  Date: 16/03/17
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>入力画面</title>
</head>
<body>
<h1>入力画面</h1>
<form:form modelAttribute="editCustomer">
    <dl>
        <dt>名前</dt>
        <dd>
            <form:input path="name"/>
            <form:errors path="name"/>
        </dd>
        <dt>住所</dt>
        <dd>
            <form:input path="address"/>
            <form:errors path="address"/>
        </dd>
        <dt>Eメールアドレス</dt>
        <dd>
            <form:input path="emailAddress"/>
            <form:errors path="emailAddress"/>
            <form:errors path="ngEmail"/>
        </dd>
    </dl>
    <button type="submit" name="_event_proceed">
        次へ
    </button>
</form:form>
</body>
</html>
