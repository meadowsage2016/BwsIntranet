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
<head>
<c:import url="include-headtag.jsp" />
</head>

<body>

<%@ include file="include-navigation.jsp" %>
<div class="container">

    <h2>Safety Data Sheets</h2>
    <ul>
        <li><a href="documents/acetyleneSDS.pdf">Acetylene</a></li>
        <li><a href="documents/Compressedoxygen.pdf">Oxygen-compressed</a></li>
    </ul>

    <h2>Sales Tax Forms</h2>
    <ul>
        <li><a href="documents/s-211.pdf">Wisconsin Sales an Use Tax </a></li>
    </ul>
</div>


<%@ include file="include-footer.jsp" %>
</body>
</html>
