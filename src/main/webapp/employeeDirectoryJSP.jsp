<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 2/13/17
  Time: 6:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<c:import url="include-headtag.jsp" />

<body>

<%@ include file="include-navigation.jsp" %>

<div id="wrapper">
    <h1>Sortable Table of Search Queries</h1>

    <table id="keywords" cellspacing="0" cellpadding="0">
        <thead>
        <tr>
            <th><span>Keywords</span></th>
            <th><span>Impressions</span></th>
            <th><span>Clicks</span></th>
            <th><span>CTR</span></th>
            <th><span>Rank</span></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td class="lalign">silly tshirts</td>
            <td>6,000</td>
            <td>110</td>
            <td>1.8%</td>
            <td>22.2</td>
        </tr>
        <tr>
            <td class="lalign">desktop workspace photos</td>
            <td>2,200</td>
            <td>500</td>
            <td>22%</td>
            <td>8.9</td>
        </tr>
        <tr>
            <td class="lalign">arrested development quotes</td>
            <td>13,500</td>
            <td>900</td>
            <td>6.7%</td>
            <td>12.0</td>
        </tr>
        <tr>
            <td class="lalign">popular web series</td>
            <td>8,700</td>
            <td>350</td>
            <td>4%</td>
            <td>7.0</td>
        </tr>
        <tr>
            <td class="lalign">2013 webapps</td>
            <td>9,900</td>
            <td>460</td>
            <td>4.6%</td>
            <td>11.5</td>
        </tr>
        <tr>
            <td class="lalign">ring bananaphone</td>
            <td>10,500</td>
            <td>748</td>
            <td>7.1%</td>
            <td>17.3</td>
        </tr>
        </tbody>
    </table>
</div>
<%@ include file="include-footer.jsp" %>
<script type="text/javascript">
    $(function(){
        $('#keywords').tablesorter();
    });
</script>
</body>
</html>