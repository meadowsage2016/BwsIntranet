<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:import url="include-headtag.jsp" />

<body>
<h3><c:out value="${noRecordsFoundMessage}" /></h3>

<div id="wrapper">
    <h1>Sortable Table of Employees</h1>

    <table id="keywords" cellspacing="0" cellpadding="0">
        <thead>
        <tr>
            <th><span>First Name</span></th>
            <th><span>Last Name</span></th>
            <th><span>Phone Extension</span></th>
            <th><span>Cell Phone</span></th>
            <th><span>Department</span></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${SearchResults}" var="employee">
            <tr>
                <td>${employee.firstName}</td>
                <td>${employee.lastName}</td>
                <td>${employee.phoneExtension}</td>
                <td>${employee.cellPhone}</td>
                <td>${employee.department}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@ include file="include-footer.jsp" %>
</body>
</html>