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
    <form class="myforms" id="deleteCylOptForm" action="/CylinderOptionsDelete" method="GET">
        <fieldset>
            <legend>Delete Cylinder Option</legend>
            <div class="form-group">
                <label for="gasNumber">Gas Number to Delete</label>
                <input class="form-control" id="gasNumber" name="gasNumber" id="gasNumber" minlength="2" type="text" required>
            </div>
            <input type="submit" id="delete" value="Submit">
        </fieldset>
    </form>
    <div class="maintenanceMessage">
    <c:out value="${Message}"/>
    </div>
</div>
</body>
</html>
