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
<form class="myforms" id="newCylOptForm" name="newCylOptForm" method="POST" action="CylinderOptionsAdd">
    <fieldset>
        <legend>New Cylinder Option</legend>
        <div class="form-group">
            <label for="gasNumber">Gas Number (required)</label>
            <input class="form-control" id="gasNumber" name="gasNumber" type="text" required>
        </div>
        <div class="form-group">
            <label for="gasDescription">Gas Description (required)</label>
            <input class="form-control" id="gasDescription" type="text" name="gasDescription" required>
        </div>
        <div class="form-group">
            <label for="cylinderCode">cylinder Code (required)</label>
            <input class="form-control" id="cylinderCode" type="text" name="cylinderCode" required>
        </div>
        <div class="form-group">
            <label for="cylinderRent">Daily Rent (required)</label>
            <input class="form-control" id="cylinderRent" name="cylinderRent" type="text" required>
        </div>
        <div class="form-group">
            <label for="cylinderOnePPRent"> One Year Pre Paid PRent (required)</label>
            <input class="form-control" id="cylinderOnePPRent" type="text" name="cylinderOnePPRent" required>
        </div>
        <div class="form-group">
            <label for="cylinderFiveYearLease">Five Year Lease (required)</label>
            <input class="form-control" id="cylinderFiveYearLease" type="text" name="cylinderFiveYearLease" required>
        </div>
        <div class="form-group">
            <label for="cylinderPurchase">Purchase Price (enter .00 if not for sale)</label>
            <input class="form-control" id="cylinderPurchase" type="text" name="cylinderPurchase" required>
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