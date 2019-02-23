<%--
  Created by IntelliJ IDEA.
  User: Java Developer Zone
  Date: 18-03-2017
  Time: 07:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring security custom rolevoter example</title>
</head>
<body>
<H2>STAFF Can't Login on SUNDAY</H2>
<form name='f' action='/login' method='POST'>
    User: <input type='text' name='username' value=''>
    Password: <input type='password' name='password'/>
    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
    <input name="submit" type="submit" value="Login"/>
</form>
</body>
</html>