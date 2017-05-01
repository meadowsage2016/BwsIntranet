<<<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <script type="text/javascript" src="../js/verifyDeleteDeliveryRoute.js"></script>
    <c:import url="../include-navigation.jsp" />
</head>
<body>

<form id="deleteDeliverRouteForm" >
    <fieldset>
        <legend>Delete Delivery Route</legend>
        <p>
            <label for="city">City or Business to Remove</label>
            <input id="city" name="city" id="city" minlength="2" type="text" required>
        </p>
        <p>
            <input type="button" id="deleteBtn" value="Submit">
        </p>
    </fieldset>
</form>
<c:out value="${Message}"/>

</body>
</html>