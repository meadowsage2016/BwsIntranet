<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 4/1/17
  Time: 8:55 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class=""weather>

    <h3><c:out value="${noRecordsFoundMessage}" /></h3>

    <h3>Madison Weather</h3>

    <p>
    ${ForecastResult.getWeather()}>
    ${ForecastResult.getObservationTime()}>
    ${ForecastResult.getTemperatureString()}
    ${ForecastResult.getFeelslikeString()}>
    ${ForecastResult.getHeatIndexString()}
    ${ForecastResult.getRelativeHumidity()}>
    ${ForecastResult.getWindString()}
    ${ForecastResult.getWindGustMph()}>
    ${ForecastResult.getWindchillF()}>
    ${ForecastResult.getVisibilityMi()}
    ${ForecastResult.getPrecipTodayString()}
    ${ForecastResult.getObservationLocation()}>

    <a href="${ForecastResult.getForecastUrl()}" target="_blank">Forecast</a>
    <a href="${ForecastResult.getHistoryUrl()}" target="_blank">History</a>
    </p>

    </div>
