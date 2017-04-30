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
    <c:import url="include-headtag.jsp" />
    <script>
        $("#newRouteForm").validate();
    </script>
</head>
<body>

<form class="cmxform" id="newRouteForm" method="get" action="DeliveryRouteAdd">
    <fieldset>
        <legend>New Delivery Route</legend>
        <p>
            <label for="city">City or Business (required, at least 2 characters)</label>
            <input id="city" name="city" minlength="2" type="text" required>
        </p>
        <p>
            <label for="day">Delivery Day(required)</label>
            <input id="day" type="text" name="day" minlength="2" maxlength="10" required>
        </p>
        <p>
            <label for="frequency">Frequency (required)</label>
            <input id="frequency" type="text" minlength="2" maxlength="10" name="frequency" required>
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
<c:forEach items="${MaintResult}" var="route">
    <tr>
        <td>${route.deliveryCityOrBusiness}</td>
        <td>${route.deliveryDay}</td>
        <td>${route.deliveryFrequency}</td>
    </tr>
</c:forEach>
</body>
</html>
