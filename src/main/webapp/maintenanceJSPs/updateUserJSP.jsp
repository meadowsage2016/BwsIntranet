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
    <form id="updateUser" action="/UsersUpdate" method="POST">
        <div class="form-group">
                    <label for="userName"><b>User Name</b></label><br />
                    <input class="form-control" name="userName" id="userName" type="text" value="${user.user_name}" maxlength="40" style="width: 260px" />
        </div>
        <div class="form-group">
                    <label for="userPassword"><b>Delivery Day</b></label><br />
                    <input class="form-control" name="userPassword" id="userPassword" type="text" value="${user.user_pass}" maxlength="20" style="width: 535px" />
        </div>
        <input type="submit" value="Submit">
    </form>
</c:forEach>
<h3><c:out value="${Message}" /></h3>
</div>
</body>
</html>