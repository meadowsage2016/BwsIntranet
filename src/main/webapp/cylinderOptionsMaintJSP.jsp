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
<c:import url="include-headtag.jsp" />

<body>
<header>
    <div id="strapline">
        <div id="welcome_slogan">
            <h3>Update Cylinders By Gas Number</h3>
        </div><!--close welcome_slogan-->
    </div><!--close strapline-->
</header>

<c:forEach items="${SearchResults}" var="cylinder">



    <form action="/CylinderOptionsMaint" id="/CylindersByGasNumber" method="POST" onsubmit="return ValidateForm(this);">

        <script type="text/javascript">
            function ValidateForm(frm) {
                if (frm.gasNumber.value == "") { alert('Gas Number is required.'); frm.gasNumber.focus(); return false; }
                if (frm.gasDescription.value == "") { alert('Description is required.'); frm.gasDescription.focus(); return false; }
                if (frm.cylinderCode.value == "") { alert('Cylinder Code is required.'); frm.cylinderCode.focus(); return false; }
                if (frm.cylinderRent.value == "") { alert('Daily Rent Value is required'); frm.cylinderRent.focus(); return false; }
                if (frm.cylinderOnePPRent.value == "") { alert('One Year PrePaid Rent  Value is required.'); frm.cylinderOnePPRent.focus(); return false; }
                if (frm.cylinderFiveYearLease.value == "") { alert('Five Year Lease Value is required.'); frm.cylinderFiveYearLease.focus(); return false; }
                if (frm.cylinderPurchase.value == "") { alert('Cylinder Purchase Value is required'); frm.cylinderPurchase.focus(); return false; }
                return true; }
        </script>

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
<h3><c:out value="${SuccessfulAdd}" /></h3>
</body>
</html>