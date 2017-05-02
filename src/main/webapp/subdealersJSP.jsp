<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
<c:import url="include-headtag.jsp" />
</head>
<c:set var="title" value="Subdealers" />
<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#keywords').DataTable();
    } );
</script>

<!DOCTYPE html>

<body>

<%@ include file="include-navigation.jsp" %>
<div id="wrapper">
    <h1>Sortable Table of Subdealers</h1>

    <table id="keywords" class="row-border stripe hover compact" cellspacing="0" cellpadding="0">
        <thead>
        <tr>
            <th><span>Customer Number</span></th>
            <th><span>Customer Name</span></th>
            <th><span>Address</span></th>
            <th><span>Address</span></th>
            <th><span>City</span></th>
            <th><span>State</span></th>
            <th><span>Zip Code</span></th>
            <th><span>County</span></th>
            <th><span>Notes:</span></th>
        </tr>
        </thead>
        <tfoot>
        <tr>
            <th><span>Customer Number</span></th>
            <th><span>Customer Name</span></th>
            <th><span>Address</span></th>
            <th><span>Address</span></th>
            <th><span>City</span></th>
            <th><span>State</span></th>
            <th><span>Zip Code</span></th>
            <th><span>County</span></th>
            <th><span>Notes:</span></th>
        </tr>
        </tfoot>
        <tbody>
        <c:forEach items="${SearchResults}" var="subdealer">
            <tr>
                <td>${subdealer.customerNumber}</td>
                <td>${subdealer.customerName}</td>
                <td>${subdealer.sdAddress1}</td>
                <td>${subdealer.sdAddress2}</td>
                <td>${subdealer.sdCity}</td>
                <td>${subdealer.sdState}</td>
                <td>${subdealer.sdZipCode}</td>
                <td>${subdealer.sdCounty}</td>
                <td>${subdealer.subdealerNotes}</td>
 <!--           <td><a href="SubdealersMaint"${subdealer.subdealerId}>Admin</a></td>
 -->
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<%@ include file="include-footer.jsp" %>
</body>
</html>
