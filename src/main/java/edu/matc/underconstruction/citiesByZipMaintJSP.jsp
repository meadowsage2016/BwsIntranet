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
<c:import url="../../../../webapp/include-headtag.jsp" />
</head>
<body>
<header>
    <div id="strapline">
        <div id="welcome_slogan">
            <h3>Update Cities by Zip Code</h3>
        </div><!--close welcome_slogan-->
    </div><!--close strapline-->
</header>

<c:forEach items="${SearchResults}" var="city">



<form action="/CitiesByZipMaint" id="/CitiesByZip" method="POST" onsubmit="return ValidateForm(this);">

    <script type="text/javascript">
        function ValidateForm(frm) {
            if (frm.cityName.value == "") { alert('City Name is required.'); frm.cityName.focus(); return false; }
            if (frm.countyNumber.value == "") { alert('County Number is required.'); frm.countyNumber.focus(); return false; }
            if (frm.zipCode.value == "") { alert('Zip Code is required.'); frm.socialSecurityNumber.focus(); return false; }
            if (frm.salesmanNumber.value == "") { alert('Salesman Number.'); frm.department.focus(); return false; }
            return true; }
    </script>

    <table border="0" cellpadding="5" cellspacing="0">
        <tr>
            <td style="width: 50%">
                <label for="cityName"><b>City Name</b></label><br />
                <input name="cityName" type="text" value="${city.cityName}" maxlength="50" style="width: 260px" />
            </td>
        <tr>
            <td colspan="2">
                <label for="zipCode"><b>Zip Code</b></label><br />
                <input name="zipCode" type="text" value="${city.zipCode}" maxlength="5" style="width: 535px" />
            </td>
        </tr>
            <td style="width: 50%">
                <label for="countyNumber"><b>County Number</b></label><br />
                <input name="countyNumber" type="text" value="${city.countyNumber}" maxlength="2" style="width: 260px" />
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <label for="salesmanNumber"><b>Salesman Number</b></label><br />
                <input name="salesmanNumber" type="text" value="${city.salesmanNumber}" maxlength="2" style="width: 535px" />
            </td>
        </tr>
    </table>
    <input type="submit" value="Submit">
</form>
</c:forEach>
<h3><c:out value="${SuccessfulAdd}" /></h3>
</body>
</html>