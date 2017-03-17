<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<c:import url="include-headtag.jsp" />

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
    <div class="row">

        <div class="col-sm-3" >
            <a  href="CitiesByZipSearch" class="searchLink"><h3>CITIES BY ZIPCODE</h3></a>
        </div>

    </div>
</div>
<div class="container-fluid bg-3 text-center">
    <div class="row">
        <div class="col-sm-3">
            <h3>Seven Day Forecast...</h3>
            <img src="images/sevenDayForecast.jpg" alt="Weather Forecast" >
                <form action="WundergroundApi" method="GET">
                    <fieldset class="form-group">
                        <legend><h5>Get Weather Forecast</h5></legend>
                        <div class="form-check form-check-inline">
                            <label class="form-check-label">
                                <input class="form-check-input" type="checkbox" id="inlineCheckbox5" name="getWeather" value="">
                            </label>
                        </div>
                        <input type="submit" name="Submit" />
                    </fieldset>
                </form>
        </div>
        <div class="col-sm-3">
            <h3>Breaking News...</h3>
            <img src="images/breakingNews.jpeg" alt="Breaking News" >
        </div>
        <div class="col-sm-3">
            <h3>Local News..</h3>
            <img src="images/localNews.jpeg" alt="Local News" >
        </div>
        <div class="col-sm-3">
            <h3>National News..</h3>
            <img src="images/National%20News.png" alt="National News" >
        </div>
    </div>
</div>
<br>


<br><br>

<%@ include file="include-footer.jsp" %>

</body>
</html>
