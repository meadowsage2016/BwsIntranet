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
