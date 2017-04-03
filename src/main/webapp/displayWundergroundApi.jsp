<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 4/1/17
  Time: 8:55 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<h3><c:out value="${noRecordsFoundMessage}" /></h3>

<div>
    <h3>Madison Weather</h3>
        ${ForecastResult.getNowcast()}>
        ${ForecastResult.getTempC()}>
        ${ForecastResult.getObservationEpoch()}>
        ${ForecastResult.getTempF()}>
        ${ForecastResult.getWindKph()}>
        ${ForecastResult.getWindMph()}>
        ${ForecastResult.getWindDegrees()}>
        ${ForecastResult.getTemperatureString()}>
        ${ForecastResult.getWeather()}>
        ${ForecastResult.getFeelslikeString()}>
        ${ForecastResult.getPrecipTodayMetric()}>
        ${ForecastResult.getPrecip1hrString()}>
        ${ForecastResult.getIconUrl()}>
        ${ForecastResult.getImage()}>
        ${ForecastResult.getStationId()}>
        ${ForecastResult.getLocalEpoch()}>
        ${ForecastResult.getLocalTzShort()}>
        ${ForecastResult.getWindDir()}>
        ${ForecastResult.getPrecip1hrMetric()}>
        ${ForecastResult.getPressureIn()}>
        ${ForecastResult.getLocalTzLong()}>
        ${ForecastResult.getWindGustMph()}>
        ${ForecastResult.getWindchillString()}>
        ${ForecastResult.getWindGustKph()}>
        ${ForecastResult.getWindString()}>
        ${ForecastResult.getLocalTimeRfc822()}>
        ${ForecastResult.getVisibilityKm()}>
        ${ForecastResult.getRelativeHumidity()}>
        ${ForecastResult.getPressureMb()}>
        ${ForecastResult.getObservationTimeRfc822()}>
        ${ForecastResult.getPrecip1hrIn()}>
        ${ForecastResult.getFeelslikeC()}>
        ${ForecastResult.getObservationTime()}>
        ${ForecastResult.getFeelslikeF()}>
        ${ForecastResult.getHistoryUrl()}>
        ${ForecastResult.getWindchillF()}>
        ${ForecastResult.getWindchillC()}>
        ${ForecastResult.getPrecipTodayString()}>
        ${ForecastResult.getIcon()}>
        ${ForecastResult.getPrecipTodayIn()}>
        ${ForecastResult.getSolarradiation()}>
        ${ForecastResult.getObservationLocation()}>
        ${ForecastResult.getDewpointF()}>
        ${ForecastResult.getDisplayLocation()}>
        ${ForecastResult.getDewpointString()}>
        ${ForecastResult.getPressureTrend()}>
        ${ForecastResult.getDewpointC()}>
        ${ForecastResult.getForecastUrl()}>
        ${ForecastResult.getLocalTzOffset()}>
        ${ForecastResult.getHeatIndexF()}>
        ${ForecastResult.getObUrl()}>
        ${ForecastResult.getHeatIndexString()}>
        ${ForecastResult.getVisibilityMi()}>
</div>
