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
                <h3>Delete User Verify</h3>
            </div><!--close welcome_slogan-->
        </div><!--close strapline-->
    </header>
    <c:forEach items="${DeleteResult}" var="user">
        <form class="myforms" id="deleteUser" action="/UserDelete" method="POST">
            <div class="form-group">
                <input class="form-control" name="userId" id="userId" type="hidden" value="${user.user_id}" />
            </div>
            <div class="form-group">
                <label for="userName"><b>User Name</b></label><br />
                <input class="form-control" name="userName" id="userName" type="text" value="${user.user_name}" readonly />
            </div>
            <input type="submit" value="Verify Delete">
        </form>
    </c:forEach>
    <div class="maintenanceMessage">
        <c:out value="${Message}"/>
    </div>
</div>
</body>
</html>