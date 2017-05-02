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
<form class="cmxform" id="newUserForm" method="POST" action="UserAdd">
    <fieldset>
        <legend>New User</legend>
        <div class="form-group">
            <label for="userName">User Name (required, at least 2 characters)</label>
            <input class="form-control" id="userName" name="userName" minlength="2" type="text" required>
        </div>
        <div class="form-group">
            <label for="userPassword1">Password (required)</label>
            <input class="form-control" id="userPassword1" type="text" name="userPassword1" required>
        </div>
        <div class="form-group">
            <label for="userPassword2">Department (required)</label>
            <input class="form-control" id="userPassword2" type="text" name="userPassword2" required>
        </div>
        <div class="form-group">
            <input class="form-control" type="hidden" name="maintType" value="1">
        </div>
            <input class="submit" type="submit" value="Submit">
    </fieldset>
</form>
<c:out value="${MaintResult}"/>

</c>
</div>
</body>
</html>