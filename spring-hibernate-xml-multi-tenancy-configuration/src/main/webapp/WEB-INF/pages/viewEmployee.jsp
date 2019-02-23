<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
    <h1>Employee List</h1>
    <table border="1">
        <tr>
            <th> Id
            <th> Name
        </tr>
	<c:forEach var="employee" items="${employees}">
        <tr>
            <td> <c:out value="${employee.employeeId}" />
            <td> <c:out value="${employee.employeeName}" />
        </tr>
    </c:forEach>
    </table>
</body>
</html>