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
    <c:import url="include-headtag.jsp" />
    <c:import url="include-navigation.jsp" />
    <script>
        $("#newSubdealerForm").validate();
    </script>
</head>
<body>

<form class="cmxform" id="newSubdealerForm" method="POST" action="SubdealersAdd">
    <fieldset>
        <legend>New Subdealer<legend>
        <p>
            <label for="customerNumber">Customer Number (required)</label>
            <input id="customerNumber" name="customerNumber" minlength="5" maxlength="5" type="text" required>
        </p>
        <p>
            <label for="customerName">Customer Name (required)</label>
            <input id="customerName" type="text" name="customerName" minlength="2" maxlength="40" required>
        </p>
        <p>
            <label for="sbAddress1">Address Field 1 (required)</label>
            <input id="sbAddress1" type="text" minlength="2" maxlength="40" name="sbAddress1" required>
        </p>
        <p>
            <label for="sdAddress2">Address Field 2 (optional)</label>
            <input id="sdAddress2" name="sdAddress2" maxlength="40" type="text">
        </p>
        <p>
            <label for="sdCity"> City (required)</label>
            <input id="sdCity" type="text" name="sdCity" minlength="2" maxlength="40" required>
        </p>
        <p>
            <label for="sdState">State (required)</label>
            <input id="sdState" type="text" minlength="2" maxlength="2" name="sdState" required>
        </p>
        <p>
            <label for="sdZipCode">Zip Code (required)</label>
            <input id="sdZipCode" type="text" minlength="2" maxlength="10" name="sdZipCode" required>
        </p>
        <p>
            <label for="subdealerNotes">Notes(optional)</label>
            <input id="subdealerNotes" type="text" maxlength="500" name="subdealerNotes" >
        </p>
        <p>
            <input type="hidden" name="maintType" value="1">
        </p>
        <p>
            <input class="submit" type="submit" value="Submit">
        </p>
    </fieldset>
</form>

<c:out value="${Message}"/>
<c:forEach items="${MaintResult}" var="sub">
    <tr>
        <td>${sub.customerNumber}</td>
        <td>${sub.customerName}</td>
        <td>${sub.sdAddress1}</td>
        <td>${sub.sdAddress2}</td>
        <td>${sub.sdCity}</td>
        <td>${sub.sdState}</td>
        <td>${sub.sdZipCode}</td>
        <td>${sub.sdCounty}</td>

    </tr>
</c:forEach>
</body>
</html>
