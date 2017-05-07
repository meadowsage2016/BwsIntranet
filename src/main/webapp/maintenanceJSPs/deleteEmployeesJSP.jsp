<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 3/17/17
  Time: 6:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <c:import url="../include-headtag.jsp" />
    <c:import url="../include-navigation.jsp" />
</head>
<body>
<div class="container">
    <header>
        <div id="strapline">
            <div id="welcome_slogan">
                <h3>Delete Employee</h3>
            </div><!--close welcome_slogan-->
        </div><!--close strapline-->
    </header>
    <c:forEach items="${DeleteResult}" var="emp">
        <form id="deleteEmployeeTable" action="EmployeeDelete" method="POST">
            <div class="form-group">
                <input type="hidden" name="employeeId" value="${emp.employeeId}">
            </div>
            <div class="form-group">
                <label for="firstName"><b>First Name</b></label><br />
                <input class="form-control" name="firstName" id="firstName" type="text" value="${emp.firstName}" readonly />
            </div>
            <div class="form-group">
                <label for="lastName"><b>Last Name</b></label><br />
                <input class="form-control" name="lastName" id="lastName" type="text" value="${emp.lastName}" readonly />
            </div>
            <div class="form-group">
                <label for="department"><b>Department</b></label><br />
                <input class="form-control" name="department" id="department" type="text" value="${emp.department}" readonly />
            </div>
            <div class="form-group">
                <label for="phoneExtension"><b>Phone Extension</b></label><br />
                <input class="form-control" name="phoneExtension" id="phoneExtension" type="text" value="${emp.phoneExtension}" readonly />
            </div>
            <div class="form-group">
                <label for="cellPhone"><b>Cell Phone</b></label><br />
                <input class="form-control" name="cellPhone" id="cellPhone" type="text" value="${emp.cellPhone}" readonly />
            </div>
            <div class="form-group">
                <label for="emailAddress"><b>Email Address</b></label><br />
                <input class="form-control" name="emailAddress" id="emailAddress" type="text" value="${emp.emailAddress}" readonly/>
            </div>
            <input type="submit" value="Verify Delete">
        </form>
    </c:forEach>
    <h3><c:out value="${Message}" /></h3>
</div>
</body>
</html>