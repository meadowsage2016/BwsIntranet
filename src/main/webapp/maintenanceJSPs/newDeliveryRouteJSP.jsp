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
        $("#newRouteForm").validate();
    </script>
</head>
<body>
<div class="container">
<form class="myforms" id="newRouteForm" method="POST" action="DeliveryRouteAdd">
    <fieldset>
        <legend>New Delivery Route</legend>
        <div class="form-group">
            <label for="city">City or Business (required, at least 2 characters)</label>
            <input class="form-control" id="city" name="city" minlength="2" type="text" required>
        </div>
        <div class="form-group">
            <label for="day">Delivery Day(required)</label>
            <input class="form-control" id="day" type="text" name="day" minlength="2" maxlength="10" required>
        </div>
        <div class="form-group">
            <label for="frequency">Frequency (required)</label>
            <input class="form-control"id="frequency" type="text" minlength="2" maxlength="10" name="frequency" required>
        </div>
        <div class="form-group">
            <input class="form-control" type="hidden" name="maintType" value="1">
        </div>
            <input class="submit" type="submit" value="Submit">
    </fieldset>
</form>
    <div class="maintenanceMessage">
        <c:out value="${Message}"/>
    </div>
</div>
</body>
</html>
