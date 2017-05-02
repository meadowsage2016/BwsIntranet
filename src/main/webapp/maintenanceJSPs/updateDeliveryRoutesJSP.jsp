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
<div class="container">
<header>
    <div id="strapline">
        <div id="welcome_slogan">
            <h3>Update Delivery Route by City or Business</h3>
        </div><!--close welcome_slogan-->
    </div><!--close strapline-->
</header>
<c:forEach items="${UpdateResult}" var="route">
    <form id="updatCylOpts" action="/DeliveryRoutesUpdate" method="POST">
        <div class="form-group">
                    <label for="city"><b>City or Business</b></label><br />
                    <input class="form-control" name="city" id="city" type="text" value="${route.deliveryCityOrBusiness}" required />
        </div>
        <div class="form-group">
                    <label for="day"><b>Delivery Day</b></label><br />
                    <input class="form-control" name="day" id="day" type="text" value="${route.deliveryDay}" required />
        </div>
        <div class="form-group">
                <label for="frequency"><b>Delivery Frequency (day or week, blue or pink)</b></label><br />
                <input class="form-control" name="frequency" id="frequency" type="text" value="${route.deliveryFrequency}" required />
        </div>
        <input type="submit" value="Submit">
    </form>
</c:forEach>
<h3><c:out value="${Message}" /></h3>
</div>
</body>
</html>