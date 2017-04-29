<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
<c:import url="include-headtag.jsp" />
</head>
<c:set var="title" value="Delivery Routes" />
<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#keywords').DataTable();
    } );
</script>
<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 2/13/17
  Time: 6:38 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>

<body>
<%@ include file="include-navigation.jsp" %>
<h3><c:out value="${noRecordsFoundMessage}" /></h3>

<div id="wrapper">
    <h1>Sortable Table of Employees</h1>

    <table id="keywords" class="row-border stripe hover compact" cellspacing="0" cellpadding="0">
        <thead>
        <tr>
            <th><span>First Name</span></th>
            <th><span>Last Name</span></th>
            <th><span>Phone Extension</span></th>
            <th><span>Cell Phone</span></th>
            <th><span>Department</span></th>
        </tr>
        </thead>
        <tfoot>
        <tr>
            <th><span>First Name</span></th>
            <th><span>Last Name</span></th>
            <th><span>Phone Extension</span></th>
            <th><span>Cell Phone</span></th>
            <th><span>Department</span></th>
        </tr>
        </tfoot>
        <tbody>
        <c:forEach items="${SearchResults}" var="employee">
            <tr>
                <td>${employee.firstName}</td>
                <td>${employee.lastName}</td>
                <td>${employee.phoneExtension}</td>
                <td>${employee.cellPhone}</td>
                <td>${employee.department}</td>
<!--            <td><a href="EmployeesMaint"${employee.employeeId}>Admin</a></td>
-->
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@ include file="include-footer.jsp" %>
</body>
</html>