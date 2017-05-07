<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 4/29/17
  Time: 2:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <c:import url="../include-headtag.jsp" />
    <c:import url="../include-navigation.jsp" />
</head>
<body>
<div class="container">
<form id="updateEmployeeForm" action="/EmployeeUpdate" method="GET">
    <fieldset>
        <legend>Select Employee to Update</legend>
        <div class="form-group">
            <label for="emailAddress">Email Address of Employee to Update</label>
            <input class="form-control" id="emailAddress" name="emailAddress" id="emailAddress" minlength="2" type="text" required>
        </div>
            <input type="submit" id="update" value="Submit">
    </fieldset>
</form>
    <div class="maintenanceMessage">
        <c:out value="${Message}"/>
    </div>
</div>
</body>
</html>