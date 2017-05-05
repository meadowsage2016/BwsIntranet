<!DOCTYPE html>
<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 4/1/17
  Time: 8:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container weather">

    <h3><c:out value="${noRecordsFoundMessage}" /></h3>

    <h3>Madison Weather</h3>
    <table>

        <thead>
        <th class="getWeather">${ForecastResult.getWeather()}</th>
        <th class="temp">${ForecastResult.getTemperatureString()}</th>
        <th class="feelsLike">Feels like ${ForecastResult.getFeelslikeString()}</th>
        </thead>
        <tr>
            <td></td>
            <td class="windString">Wind:  ${ForecastResult.getWindString()}</td>
        </tr>
        <tr>
            <td class=misc">Visibility(miles): ${ForecastResult.getVisibilityMi()} </td>
        </tr>
        <tr>
            <td class="precip">Precip Today:  ${ForecastResult.getPrecipTodayString()}</td>
            <td class="humidity">Relative Humidity:  ${ForecastResult.getRelativeHumidity()}</td>
        </tr>
        <tr>
            <td class="time">${ForecastResult.getObservationTime()}</td>
        </tr>
        <tr>
            <td class="forecast"><a href="${ForecastResult.getForecastUrl()}" target="_blank">Forecast</a> </td>
            <td class="history"><a href="${ForecastResult.getHistoryUrl()}" target="_blank">History</a></td>
        </tr>
    </table>

</div>