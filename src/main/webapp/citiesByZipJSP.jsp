<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 3/16/17
  Time: 6:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://matc.edu/tags" prefix="sh" %>
<%@ taglib prefix="sh" uri="http://matc.edu/tags" %>
<c:import url="include-headtag.jsp" />
<c:set var="title" value="Delivery Routes" />
<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#keywords').DataTable();
    } );
</script>

<!DOCTYPE html>
<c:import url="include-headtag.jsp" />

<body>

<%@ include file="include-navigation.jsp" %>

<h3><c:out value="${noRecordsFoundMessage}" /></h3>

<div id="wrapper">
    <h1>Sortable Table of Cities by ZipCode</h1>

    <table id="keywords" cellspacing="0" cellpadding="0">
        <thead>
        <tr>
            <th><span>City</span></th>
            <th><span>ZipCode</span></th>
            <th><span>Salesman Number</span></th>
            <th><span>County Number</span></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${SearchResults}" var="city">
            <tr>
                <td>${city.cityName}</td>
                <td>${city.zipCode}</td>
                <td>${city.salesmanNumber}</td>
                <td>${city.countyNumber}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div>
        <p><sh:SendEmailIfError /></p>
    </div>
</div>
<%@ include file="include-footer.jsp" %>
<!--
<script type="text/javascript">
    $(function(){
        $('#keywords').tablesorter();
    });
</script>
-->
</body>
</html>