<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://matc.edu/tags" prefix="sh" %>
<c:import url="include-headtag.jsp" />
<c:set var="title" value="Cylinder Options" />
<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#keywords').DataTable();
    } );
</script>
<%--
  Created by IntelliJ IDEA.
  Sue Hundt  Date: 2/13/17
  Time: 6:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>

<body>

<%@ include file="include-navigation.jsp" %>
<div id="wrapper">
    <h1>Sortable Table of Cylinder Options</h1>

    <table id="keywords" cellspacing="0" cellpadding="0">
        <thead>
        <tr>
            <th><span>Gas Number</span></th>
            <th><span>Gas Code</span></th>
            <th><span>Gas Description</span></th>
            <th><span>Daily Rent</span></th>
            <th><span>1 Year PrePaid Rent</span></th>
            <th><span>5 Year Lease</span></th>
            <th><span>Purchase</span></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${SearchResults}" var="cylinder">
            <tr>
                <td>${cylinder.gasNumber}</td>
                <td>${cylinder.cylinderCode}</td>
                <td>${cylinder.gasDescription}</td>
                <td>${cylinder.cylinderRent}</td>
                <td>${cylinder.cylinderOnePPRent}</td>
                <td>${cylinder.cylinderFiveYearLease}</td>
                <td>${cylinder.cylinderPurchase}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div>
    <p><sh:SendEmailIfError /></p>
</div>

<%@ include file="include-footer.jsp" %>
</body>
</html>
