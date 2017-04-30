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
    <c:import url="include-navigation.jsp" />
    <script>
        $("#deleteCylOptForm").validate();
    </script>
</head>
<body>

<form class="cmxform" id="deleteCylOptForm" method="POST" action="CylinderOptionsDelete">
    <fieldset>
        <legend>Delete Cylinder Option</legend>
        <p>
            <label for="gasNumber">Gas Number to Remove</label>
            <input id="gasNumber" name="gasNumber" minlength="2" type="text" required>
        </p>
        <p>
            <input type="hidden" name="maintType" value="3">
        </p>
        <p>
            <input class="submit" type="submit" value="Submit">
        </p>
    </fieldset>
</form>

<form class="cmxform" id="deleteCylOptConfirmForm" method="POST" action="CylinderOptionsDelete">
    <fieldset>
        <p>
            <c:out value="${DeleteMessage}"/>
        </p>
        <p>
            <input type="hidden" name="verify" value="9">
        </p>
        <p>
            <c:out value="${SubmitButton}"/>
        </p>
    </fieldset>
</form>


</body>
</html>