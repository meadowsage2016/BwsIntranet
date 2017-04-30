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
            <h3>Update Cylinders By Gas Number</h3>
        </div><!--close welcome_slogan-->
    </div><!--close strapline-->
</header>

<c:forEach items="${UpdateResult}" var="cylinder">
<form id="updatCylOpts" action="/CylinderOptionsUpdate" method="POST">
        <table border="0" cellpadding="5" cellspacing="0">
            <tr>
                <td style="width: 50%">
                    <label for="gasNumber"><b>Gas Number</b></label><br />
                    <input name="gasNumber" id="gasNumber" type="text" value="${cylinder.gasNumber}" maxlength="20" style="width: 260px" />
                </td>
            <tr>
                <td colspan="2">
                    <label for="gasDescription"><b>Gas Description</b></label><br />
                    <input name="gasDescription" id="gasDescription" type="text" value="${cylinder.gasDescription}" maxlength="40" style="width: 535px" />
                </td>
            </tr>
            <td style="width: 50%">
                <label for="cylinderCode"><b>Cylinder Code</b></label><br />
                <input name="cylinderCode" id="cylinderCode" type="text" value="${cylinder.cylinderCode}" maxlength="10" style="width: 260px" />
            </td>
            </tr>
            <tr>
                <td colspan="2">
                    <label for="cylinderRent"><b>Cylinder Daily Rent</b></label><br />
                    <input name="cylinderRent" id="cylinderRent" type="text" value="${cylinder.cylinderRent}" maxlength="10" style="width: 535px" />
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <label for="cylinderOnePPRent"><b>One Year PrePaid Rent</b></label><br />
                    <input name="cylinderOnePPRent" id="cylinderOnePPRent" type="text" value="${cylinder.cylinderOnePPRent}" maxlength="10" style="width: 535px" />
                </td>
            </tr>
            <td style="width: 50%">
                <label for="cylinderFiveYearLease"><b>5 Year Lease</b></label><br />
                <input name="cylinderFiveYearLease"  id="cylinderFiveYearLease" type="text" value="${cylinder.cylinderFiveYearLease}" maxlength="10" style="width: 260px" />
            </td>
            </tr>
            <tr>
                <td colspan="2">
                    <label for="cylinderPurchase"><b>Cylinder Daily Rent</b></label><br />
                    <input name="cylinderPurchase" id="cylinderPurchase" type="text" value="${cylinder.cylinderPurchase}" maxlength="10" style="width: 535px" />
                </td>
            </tr>
        </table>
        <input type="submit" value="Submit">
    </form>
</c:forEach>
<h3><c:out value="${Message}" /></h3>
</body>
</html>