%--
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
                <h3>Delete Subdealer</h3>
            </div><!--close welcome_slogan-->
        </div><!--close strapline-->
    </header>

    <c:forEach items="${DeleteResult}" var="sub">
        <form id="deleteSubdealerForm" action="/SubdealersDelete" method="POST">
            <div class="form-group">
                <label for="customerNumber"><b>Customer Number</b></label><br />
                <input class="form-control" name="customerNumber" id="customerNumber" type="text" value="${sub.customerNumber}" readonly />
            </div>
            <div class="form-group">
                <label for="customerName"><b>Customer Name</b></label><br />
                <input class="form-control" name="customerName" id="customerName" type="text" value="${sub.customerName}" readonly />
            </div>
            <div class="form-group">
                <label for="sbAddress1"><b>Address 1</b></label><br />
                <input class="form-control" name="sbAddress1" id="sbAddress1" type="text" value="${sub.sdAddress1}" readonly />
            </div>
            <div class="form-group">
                <label for="sdAddress2"><b>Address 2</b></label><br />
                <input class="form-control" name="sdAddress2" id="sdAddress2" type="text" value="${sub.sdAddress2}" readonly />
            </div>
            <div class="form-group">
                <label for="city"><b>Cityt</b></label><br />
                <input class="form-control" name="city" id="city" type="text" value="${sub.sdCity}" readonly />
            </div>
            <div class="form-group">
                <label for="state"><b>State</b></label><br />
                <input class="form-control" name="state"  id="state" type="text" value="${sub.sdState}" readonly />
            </div>
            <div class="form-group">
                <label for="zipCode"><b>Zip Code</b></label><br />
                <input class="form-control" name="zipCode" id="zipCode" type="text" value="${sub.sdZipCode}" readonly />
            </div>
            <div class="form-group">
                <label for="county"><b>County</b></label><br />
                <input class="form-control" name="county" id="county" type="text" value="${sub.sdCounty}" readonly/>
            </div>
            <div class="form-group">
                <label for="notes"><b>Notes</b></label><br />
                <input class="form-control" name="notes"  id="notes" type="text" value="${sub.subdealerNotes}" readonly />
            </div>
            <input type="submit" value="Submit">
        </form>
    </c:forEach>
    <h3><c:out value="${Message}" /></h3>
</div>
</body>
</html>
