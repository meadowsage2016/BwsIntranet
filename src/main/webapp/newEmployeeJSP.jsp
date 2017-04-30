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
    <c:import url="include-navigation.jsp" />
    <script>
        $("#newEmpForm").validate();
    </script>
</head>
<body>

<form class="cmxform" id="newEmpForm" method="POST" action="employeeAdd">
    <fieldset>
        <legend>New Employee</legend>
        <p>
            <label for="firstName">First Name (required, at least 2 characters)</label>
            <input id="firstName" name="firstName" minlength="2" type="text" required>
        </p>
        <p>
            <label for="lastName">Last Name (required)</label>
            <input id="lastName" type="text" name="lastName" required>
        </p>
        <p>
            <label for="department">Department (required)</label>
            <input id="department" type="text" name="department" required>
        </p>
        <p>
            <label for="phoneExtension">Phone Extension</label>
            <input id="phoneExtension" type="text" minlength="3" maxlength="3" name="phoneExtension" required>
        </p>
        <p>
            <label for="cellPhone">Cell Phone</label>
            <input id="cellPhone" type="text" minlength="7" maxlength="10" PLACEHOLDER="6085551212" name="cellPhone" >
        </p>
        <p>
            <input type="hidden" name="maintType" value="1">
        </p>
        <p>
            <input class="submit" type="submit" value="Submit">
        </p>
    </fieldset>
</form>
<c:out value="${MaintResult}"/>

</c>
</body>
</html>
