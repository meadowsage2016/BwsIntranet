<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 4/29/17
  Time: 2:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <c:import url="../include-headtag.jsp" />
    <c:import url="../include-navigation.jsp" />
    <script>
        function checkPass()
        {
            //Store the password field objects into variables ...
            var pass1 = document.getElementById('pass1');
            var pass2 = document.getElementById('pass2');
            //Store the Confimation Message Object ...
            var message = document.getElementById('confirmMessage');
            //Set the colors we will be using ...
            var goodColor = "#66cc66";
            var badColor = "#ff6666";
            //Compare the values in the password field
            //and the confirmation field
            if(pass1.value == pass2.value){
                //The passwords match.
                //Set the color to the good color and inform
                //the user that they have entered the correct password
                pass2.style.backgroundColor = goodColor;
                message.style.color = goodColor;
                message.innerHTML = "Passwords Match!"
            }else{
                //The passwords do not match.
                //Set the color to the bad color and
                //notify the user.
                pass2.style.backgroundColor = badColor;
                message.style.color = badColor;
                message.innerHTML = "Passwords Do Not Match!"
            }
        }
    </script>
</head>
<body>
<div class="container">
<form class="cmxform" id="newUserForm" method="POST" action="UserAdd">
    <fieldset>
        <legend>New User</legend>
        <div class="form-group">
            <label for="userName">User Name (required, at least 2 characters)</label>
            <input class="form-control" id="userName" name="userName" minlength="2" type="text" required>
        </div>

        <div class="form-group">
                <div class="fieldWrapper">
                    <label for="pass1">Password:</label>
                    <input name="pass1" id="pass1" type="password">
                </div>
                <div class="fieldWrapper">
                    <label for="pass2">Confirm Password:</label>
                    <input name="pass2" id="pass2" onkeyup="checkPass(); return false;" type="password">
                    <span id="confirmMessage" class="confirmMessage"></span>
                </div>
        </div>
            <input class="submit" type="submit" value="Submit">
    </fieldset>
</form>
<c:out value="${MaintResult}"/>

</c>
</div>
</body>
</html>