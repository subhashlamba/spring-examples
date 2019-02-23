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
<form name='f' action='/login?_s=${s}' method='POST'>
    User: <input type='text' name='username' value=''>
    Password: <input type='password' name='password'/>
    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
    <input name="submit" type="submit" value="Login"/>
</form>


<c:forEach items="${currentLoginUsers}" var="currentLoginUsers">
    <ul>
        <li> Switch To : <a href="loginSuccess?_s=${currentLoginUsers.key}"><c:out value="${currentLoginUsers.value}"/></a></li>
    </ul>
</c:forEach>

</body>
</html>