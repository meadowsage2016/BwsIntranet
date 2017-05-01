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
    <c:import url="../include-navigation.jsp" />
</head>
<body>

<form id="updateSubdealersForm" action="/SubdealersUpdate" method="GET">
    <fieldset>
        <legend>Select Delivery Route to Update - Enter City or Business</legend>
        <p>
            <label for="customerNumber">Customer Number of Subdealer to Update</label>
            <input id="customerNumber" name="customerNumber" id="customerNumber" minlength="2" type="text" required>
        </p>
        <p>
            <input type="submit" id="update" value="Submit">
        </p>
    </fieldset>
</form>
<c:out value="${Message}"/>

</body>
</html>