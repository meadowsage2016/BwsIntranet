<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <c:import url="include-headtag.jsp" />
</head>
<c:set var="title" value="Users" />
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
    <h1>Sortable Table of Users</h1>

    <table id="keywords" class="row-border stripe hover compact" cellspacing="0" cellpadding="0">
        <thead>
        <tr>
            <th><span>User Id</span></th>
            <th><span>User Name</span></th>
            <th><span>User Password</span></th>
        </tr>
        </thead>
        <tfoot>
        <tr>
            <th><span>User Id</span></th>
            <th><span>User Name</span></th>
            <th><span>User Password</span></th>
        </tr>
        </tfoot>
        <tbody>
        <c:forEach items="${SearchResults}" var="user">
            <tr>
                <td>${user.user_id}</td>
                <td>${user.user_name}</td>
                <td>${user.user_pass}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
<%@ include file="include-footer.jsp" %>

</body>
</html>