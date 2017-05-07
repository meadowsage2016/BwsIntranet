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
    <script>
        $("#newEmpForm").validate();
    </script>
</head>
<body>
<div class="container">
<form class="cmxform" id="newEmpForm" method="POST" action="EmployeeAdd">
    <fieldset>
        <legend>New Employee</legend>
        <div class="form-group">
            <label for="firstName">First Name (required, at least 2 characters)</label>
            <input class="form-control" id="firstName" name="firstName" minlength="2" type="text" required>
        </div>
        <div class="form-group">
            <label for="lastName">Last Name (required)</label>
            <input class="form-control" id="lastName" type="text" name="lastName" required>
        </div>
        <div class="form-group">
            <label for="department">Department (required)</label>
            <input class="form-control" id="department" type="text" name="department" required>
        </div>
        <div class="form-group">
            <label for="phoneExtension">Phone Extension</label>
            <input class="form-control" id="phoneExtension" type="text" minlength="3" maxlength="3" name="phoneExtension" required>
        </div>
        <div class="form-group">
            <label for="cellPhone">Cell Phone</label>
            <input class="form-control" id="cellPhone" type="text" minlength="7" maxlength="10" PLACEHOLDER="6085551212" name="cellPhone" >
        </div>
        <div class="form-group">
            <label for="emailAddress">Email Address</label>
            <input class="form-control" id="emailAddress" type="text" minlength="2" maxlength="40"  name="emailAddress" required>
        </div>
        <div class="form-group">
            <input class="form-control" type="hidden" name="maintType" value="1">
        </div>
            <input class="submit" type="submit" value="Submit">
    </fieldset>
</form>
<c:out value="${Message}"/>

</c>
</c>
</div>
</body>
</html>
