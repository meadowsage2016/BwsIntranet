<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="include-headtag.jsp" />
<c:set var="title" value="Delivery Routes" />
<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#keywords').DataTable();
    } );
</script>
<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 2/13/17
  Time: 6:38 PM
  To change this template use File | Settings | File Templates.
--%>

<!DOCTYPE html>
<c:import url="include-headtag.jsp" />

<body>

<%@ include file="include-navigation.jsp" %>

<h3><c:out value="${noRecordsFoundMessage}" /></h3>

<div id="wrapper">
    <h1>Sortable Table of Delivery Route</h1>

    <table id="keywords" class="row-border stripe hover compact" cellspacing="0" cellpadding="0">
        <thead>
        <tr>
            <th><span>City or Other Location</span></th>
            <th><span>Delivery Day</span></th>
            <th><span>Frequency</span></th>
        </tr>
        </thead>
        <tfoot>
        <tr>
            <th><span>City or Other Location</span></th>
            <th><span>Delivery Day</span></th>
            <th><span>Frequency</span></th>
        </tr>
        </tfoot>
        <tbody>
        <c:forEach items="${SearchResults}" var="route">
            <tr>
                <td>${route.deliveryCityOrBusiness}</td>
                <td>${route.deliveryDay}</td>
                <td>${route.deliveryFrequency}</td>
  <!--              <td><a href="DeliveryRouteMaint"${route.deliveryRouteId}>Admin</a></td>  -->

            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
<%@ include file="include-footer.jsp" %>

</body>
</html>