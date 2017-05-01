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
    <c:import url="../include-navigation.jsp" />
</head>
<body>
<div class="container">
<form id="deleteDeliverRouteForm" >
    <fieldset>
        <legend>Delete Delivery Route</legend>
        <div class="form-group">
            <label for="city">City or Business to Remove</label>
            <input class="form-control" id="city" name="city" id="city" minlength="2" type="text" required>
        </div>
        <input type="button" id="deleteBtn" value="Submit">
    </fieldset>
</form>
<c:out value="${Message}"/>
</div>
</body>
</html>