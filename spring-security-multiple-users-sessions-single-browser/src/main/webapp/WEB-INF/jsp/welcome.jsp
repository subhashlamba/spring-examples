<%--
  Created by IntelliJ IDEA.
  User: Java Developer Zone
  Date: 18-03-2017
  Time: 07:34
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>spring security multiple users sessions in single browser</title>
</head>
<body>

Hi, ${currentLoginUser} (<a href="/logout?_s=${currentLoginUserKey}">Logout</a> )
<br/>
<br/>
<b> ${currentLoginUser}'s Hit Counter : </b>${sessionScope.hitCounter}
<hr>
<c:forEach items="${currentLoginUsers}" var="currentLoginUsers">
<ul>
    <li> Switch To : <a href="loginSuccess?_s=${currentLoginUsers.key}"><c:out value="${currentLoginUsers.value}"/></a>
    </li>
</ul>
</c:forEach>
<hr>
<br>
<a href="login?_s=1">Add Another Account</a>