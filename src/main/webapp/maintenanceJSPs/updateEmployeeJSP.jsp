<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 3/17/17
  Time: 6:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <c:import url="../include-headtag.jsp" />
</head>
<body>
<header>
    <div id="strapline">
        <div id="welcome_slogan">
            <h3>Update Employee</h3>
        </div><!--close welcome_slogan-->
    </div><!--close strapline-->
</header>
<c:forEach items="${UpdateResult}" var="emp">
    <form id="updatCylOpts" action="EmployeeUpdate" method="POST">
        <input type="hidden" name="employeeId" value="${emp.employeeId}">
        <table border="0" cellpadding="5" cellspacing="0">
            <tr>
                <td style="width: 50%">
                    <label for="firstName"><b>First Name</b></label><br />
                    <input name="firstName" id="firstName" type="text" value="${emp.firstName}" maxlength="40" style="width: 260px" />
                </td>
            <tr>
                <td colspan="2">
                    <label for="lastName"><b>Last Name</b></label><br />
                    <input name="lastName" id="lastName" type="text" value="${emp.lastName}" maxlength="20" style="width: 535px" />
                </td>
            </tr>
            <td style="width: 50%">
                <label for="department"><b>Department</b></label><br />
                <input name="department" id="department" type="text" value="${emp.department}" maxlength="20" style="width: 260px" />
            </td>
            </tr>
            <tr>
                <td style="width: 50%">
                    <label for="phoneExtension"><b>Phone Extension</b></label><br />
                    <input name="phoneExtension" id="phoneExtension" type="text" value="${emp.phoneExtension}" maxlength="40" style="width: 260px" />
                </td>
            <tr>
                <td colspan="2">
                    <label for="cellPhone"><b>Cell Phone</b></label><br />
                    <input name="cellPhone" id="cellPhone" type="text" value="${emp.cellPhone}" maxlength="20" style="width: 535px" />
                </td>
            </tr>
            <td style="width: 50%">
                <label for="emailAddress"><b>Email Address</b></label><br />
                <input name="emailAddress" id="emailAddress" type="text" value="${emp.emailAddress}" maxlength="60" style="width: 260px" />
            </td>
            </tr>
        </table>
        <input type="submit" value="Submit">
    </form>
</c:forEach>
<h3><c:out value="${Message}" /></h3>
</body>
</html>