<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<c:import url="include-headtag.jsp" />

<body>

<%@ include file="include-navigation.jsp" %>

<div class="jumbotron">
    <div class="container text-center">
        <img src="images/bwsSign.jpg" alt="Badger Welding Sign" >
    </div>
</div>
<div class="container-fluid bg-3 text-center">
    <div class="row">
        <div class="col-sm-3">
        <form action="/EmployeeSearch" method="GET">
            <div class="form-group">
                <fieldset class="form-group">
                    <legend><h3>Employee Directory</h3></legend>
                        <label for="firstName">Search by First Name:</label>
                        <input class="form-control" type="text" id="firstName" name="searchEmployeeFirstName">
                    <div class="form-check form-check-inline">
                        <label class="form-check-label">
                            <input class="form-check-input" type="checkbox" id="inlineCheckbox1" name="showAllEmployees" value="1">Show All Employees
                        </label>
                    </div>
                    <input type="submit" name="Submit" />
                 </fieldset>
            </div>
        </form>
    </div>
        <div class="col-sm-3">
            <form action="/DeliveryRouteSearch" method="GET">
                <fieldset class="form-group">
                    <legend><h3>Deliver Routes</h3></legend>
                    <label for="searchCity">Search By City or Other Location</label>
                    <input class="form-control" id="searchCity" type="text" name="city"/>
                    <div class="form-check form-check-inline">
                        <label class="form-check-label">
                            <input class="form-check-input" name="selectDeliveryRouteType" type="checkbox" id="inlineCheckbox2" value="1">View All Delivery Routes:
                        </label>
                    </div>
                    <input type="submit" name="Submit" />
                </fieldset>
            </form>
        </div>
        <div class="col-sm-3">
            <form action="/SubdealerSearch" method="GET">
                <fieldset class="form-group">
                    <legend><h3>Subdealers</h3></legend>
                    <label for="county">Search By County</label>
                    <input class="form-control" id="county" type="text" name="county" />
                    <div class="form-check form-check-inline">
                        <label class="form-check-label">
                            <input class="form-check-input" type="checkbox" id="inlineCheckbox3" name="subdealerSearchType" value="1">View All Subdealers:
                        </label>
                    </div>
                    <input type="submit" name="Submit" />
                </fieldset>
            </form>
        </div>
        <div class="col-sm-3">
            <form action="/CylinderOptionsSearch" method="GET">
                <fieldset class="form-group">
                    <legend><h3>Cylinders Options: </h3></legend>
                    <label for="gasNumber">Search By Gas Number</label>
                    <input class="form-control" id="gasNumber" type="text" name="gasNumber"/>
                    <div class="form-check form-check-inline">
                        <label class="form-check-label">
                            <input class="form-check-input" type="checkbox" id="inlineCheckbox4" name="selectCylinderOptionsSearchType" value="1">View All Gases:
                        </label>
                    </div>
                    <input type="submit" name="Submit" />
                </fieldset>
            </form>
        </div>
    </div>
</div>
<div class="container-fluid bg-3 text-center">
    <div class="row">
        <div class="col-sm-3">
            <h3>Seven Day Forecast...</h3>
            <img src="images/sevenDayForecast.jpg" alt="Weather Forecast" >
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
