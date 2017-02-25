<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 2/13/17
  Time: 6:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<c:import url="include-headtag.jsp" />

<body>

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

<%@ include file="include-navigation.jsp" %>



<%@ include file="include-footer.jsp" %>
</body>
</html>
