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
    <c:import url="../include-headtag.jsp" />
    <c:import url="../include-navigation.jsp" />
</head>
<body>
<div class="container"></div>
<header>
    <div id="strapline">
        <div id="welcome_slogan">
            <h3>Update Cylinders By Gas Number</h3>
        </div><!--close welcome_slogan-->
    </div><!--close strapline-->
</header>

<c:forEach items="${UpdateResult}" var="cylinder">
<form class="myforms" id="updatCylOpts" action="/CylinderOptionsUpdate" method="POST">
    <legend>Update Cylinder Options by Gas Number</legend>
    <div class="form-group">
        <label for="gasNumber"><b>Gas Number</b></label><br />
        <input class="form-control" name="gasNumber" id="gasNumber" type="text" value="${cylinder.gasNumber}"  required/>
    </div>
    <div class="form-group">
        <label for="gasDescription"><b>Gas Description</b></label><br />
        <input class="form-control" name="gasDescription" id="gasDescription" type="text" value="${cylinder.gasDescription}"  required/>
    </div>
    <div class="form-group">
        <label for="cylinderCode"><b>Cylinder Code</b></label><br />
        <input class="form-control" name="cylinderCode" id="cylinderCode" type="text" value="${cylinder.cylinderCode}"  required/>
    </div>
    <div class="form-group">
        <label for="cylinderRent"><b>Cylinder Daily Rent</b></label><br />
        <input class="form-control" name="cylinderRent" id="cylinderRent" type="text" value="${cylinder.cylinderRent}" required/>
    </div>
    <div class="form-group">
        <label for="cylinderOnePPRent"><b>One Year PrePaid Rent</b></label><br />
        <input class="form-control" name="cylinderOnePPRent" id="cylinderOnePPRent" type="text" value="${cylinder.cylinderOnePPRent}"  required/>
    </div>
    <div class="form-group">
        <label for="cylinderFiveYearLease"><b>5 Year Lease</b></label><br />
        <input class="form-control" name="cylinderFiveYearLease"  id="cylinderFiveYearLease" type="text" value="${cylinder.cylinderFiveYearLease}" required/>
    </div>
    <div class="form-group">
        <label for="cylinderPurchase"><b>Cylinder Purchase Price (not Required)</b></label><br />
        <input class="form-control" name="cylinderPurchase" id="cylinderPurchase" type="text" value="${cylinder.cylinderPurchase}" />
        </div>
        <input type="submit" value="Submit">
    </form>
</c:forEach>
<div class="maintenanceMessage">
    <c:out value="${Message}"/>
</div>
</div>
</body>
</html>