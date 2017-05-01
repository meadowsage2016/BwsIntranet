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
        $("#newCylOptForm").validate();
    </script>
</head>
<body>
<div class="container">
<form class="cmxform" id="newCylOptForm" method="POST" action="CylinderOptionsAdd">
    <fieldset>
        <legend>New Cylinder Option</legend>
        <div class="form-group">
            <label for="gasNumber">Gas Number (required)</label>
            <input class="form-control" id="gasNumber" name="gasNumber" minlength="2" type="text" required>
        </div>
        <div class="form-group">
            <label for="gasDescription">Gas Description (required)</label>
            <input class="form-control" id="gasDescription" type="text" name="gasDescription" minlength="2" maxlength="40" required>
        </div>
        <div class="form-group">
            <label for="cylinderCode">cylinder Code (required)</label>
            <input class="form-control" id="cylinderCode" type="text" minlength="2" maxlength="10" name="cylinderCode" required>
        </div>
        <div class="form-group">
            <label for="cylinderRent">Daily Rent (required)</label>
            <input class="form-control" id="cylinderRent" name="cylinderRent" minlength="2" type="text" required>
        </div>
        <div class="form-group">
            <label for="cylinderOnePPRent"> One Year Pre Paid PRent (required)</label>
            <input class="form-control" id="cylinderOnePPRent" type="text" name="cylinderOnePPRent" minlength="2" maxlength="40" required>
        </div>
        <div class="form-group">
            <label for="cylinderFiveYearLease">Five Year Lease (required)</label>
            <input class="form-control" id="cylinderFiveYearLease" type="text" minlength="2" maxlength="10" name="cylinderFiveYearLease" required>
        </div>
        <div class="form-group">
            <label for="cylinderPurchase">Purchase Price (optional)</label>
            <input class="form-control" id="cylinderPurchase" type="text" minlength="2" maxlength="10" name="cylinderPurchase">
        </div>
        <div class="form-group">
            <input class="form-control" type="hidden" name="maintType" value="1">
        </div>
            <input class="submit" type="submit" value="Submit">
    </fieldset>
</form>

<c:out value="${Message}"/>
<c:forEach items="${MaintResult}" var="cyl">
    <tr>
        <td>${cyl.gasNumber}</td>
        <td>${cyl.gasDescription}</td>
        <td>${cyl.cylinderCode}</td>
        <td>${cyl.cylinderRent}</td>
        <td>${cyl.cylinderOnePPRent}</td>
        <td>${cyl.cylinderFiveYearLease}</td>
        <td>${cyl.cylinderPurchase}</td>

    </tr>
</c:forEach>
</div>
</body>
</html>