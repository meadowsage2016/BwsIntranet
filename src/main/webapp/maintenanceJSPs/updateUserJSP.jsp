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
            <h3>Update User</h3>
        </div><!--close welcome_slogan-->
    </div><!--close strapline-->
</header>
<c:forEach items="${UpdateResult}" var="user">
    <form class="myforms" id="updateUser" action="/UserUpdate" method="POST">
        <div class="form-group">
                    <label for="userName"><b>User Name</b></label><br />
                    <input class="form-control" name="userName" id="userName" type="text" value="${user.user_name}" readonly/>
        </div>
        <div class="form-group">
                    <label for="userPassword"><b>Password</b></label><br />
                    <input class="form-control" name="userPassword" id="userPassword" type="text" value="${user.user_pass}" required/>
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