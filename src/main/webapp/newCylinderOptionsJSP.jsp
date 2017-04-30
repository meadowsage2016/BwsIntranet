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
    <c:import url="include-headtag.jsp" />
    <script>
        $("#newCylOptForm").validate();
    </script>
</head>
<body>

<form class="cmxform" id="newCylOptForm" method="POST" action="CylinderOptionsAdd">
    <fieldset>
        <legend>New Cylinder Option</legend>
        <p>
            <label for="gasNumber">Gas Number (required, at least 2 characters)</label>
            <input id="gasNumber" name="gasNumber" minlength="2" type="text" required>
        </p>
        <p>
            <label for="gasDescription">Gas Description (required)</label>
            <input id="gasDescription" type="text" name="gasDescription" minlength="2" maxlength="40" required>
        </p>
        <p>
            <label for="cylinderCode">cylinder Code (required)</label>
            <input id="cylinderCode" type="text" minlength="2" maxlength="10" name="cylinderCode" required>
        </p
        <p>
            <label for="cylinderRent">Daily Rent (required, at least 2 characters)</label>
            <input id="cylinderRent" name="cylinderRent" minlength="2" type="text" required>
        </p>
        <p>
            <label for="cylinderOnePPRent"> One Year Pre Paid PRent (required)</label>
            <input id="cylinderOnePPRent" type="text" name="cylinderOnePPRent" minlength="2" maxlength="40" required>
        </p>
        <p>
            <label for="cylinderFiveYearLease">Five Year Lease (required)</label>
            <input id="cylinderFiveYearLease" type="text" minlength="2" maxlength="10" name="cylinderFiveYearLease" required>
        </p>
        <p>
            <label for="cylinderPurchase">Purchase Price (optional)</label>
            <input id="cylinderPurchase" type="text" minlength="2" maxlength="10" name="cylinderPurchase">
        </p>
        <p>
            <input type="hidden" name="maintType" value="1">
        </p>
        <p>
            <input class="submit" type="submit" value="Submit">
        </p>
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
</body>
</html>