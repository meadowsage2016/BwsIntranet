<<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <script type="text/javascript" src="../js/verifyDeleteEmployee.js"></script>
    <c:import url="../include-navigation.jsp" /></head>
<body>
<div class="container">
<form id="deleteEmployeeForm" >
    <fieldset>
        <legend>Delete Employee</legend>
        <div class="form-group">
            <label for="name">Employee to Remove</label>
            <input class="form-control" id="name" name="name" id="name" minlength="2" type="text" required>
        </div>
        <input type="button" id="deleteBtn" value="Submit">
    </fieldset>
</form>
<c:out value="${Message}"/>
</div>
</body>
</html>