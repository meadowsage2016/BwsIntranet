<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
<c:import url="include-headtag.jsp" />
</head>
<body>

<%@ include file="include-navigation.jsp" %>

<div class="jumbotron">
    <div class="container text-center">
        <img src="images/bwsSign125.jpg" alt="Badger Welding Sign" >
    </div>
</div>
<div class="container-fluid bg-3 text-center">
    <div class="row">

        <div class="col-sm-3" >
            <a  href="EmployeeSearch" class="searchLink"><h3>EMPLOYEE DIRECTORY</h3></a>
        </div>

        <div class="col-sm-3" class="searchLink">
            <a  href="DeliveryRouteSearch" class="searchLink"><h3>DELIVERY ROUTES</h3></a>
        </div>

        <div class="col-sm-3" class="searchLink">
            <a  href="SubdealerSearch" class="searchLink"><h3>SUBDEALERS DIRECTORY</h3></a>
        </div>

        <div class="col-sm-3" class="searchLink">
            <a href="CylinderOptionsSearch" class="searchLink"><h3>CYLINDER LEASE/OWN OPTIONS</h3></a>
        </div>
    </div>
</div>
<div class="container-fluid bg-12" id="weather">
    <div class="row">
        <div class="col-sm-12">
            <c:import url="WundergroundApi" />
        </div>
    </div>
</div>
<div class="container-fluid bg-12">
    <div class="row">
        <div class="col-sm-12">
            <h3>Breaking News...</h3>
            <c:import url="NewsApi" />
        </div>
    </div>
</div>
<br>


<br><br>

<%@ include file="include-footer.jsp" %>

</body>
</html>