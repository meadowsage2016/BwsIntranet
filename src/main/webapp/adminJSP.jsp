<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 3/16/17
  Time: 5:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<c:import url="include-headtag.jsp" />
    <c:import url="include-navigation.jsp"/>
</head>
<h1>Administrator Console</h1>

<form id="EmployeesTable" method="GET" action="EmployeesMaintServlet">


    <div class='container'>

        <fieldset class="form-group">

            <legend><h2>EMPLOYEES TABLE</h2></legend>
            <div id="EmpTableContainer" class="form-group">
                <div>
                    <label >ADD</label>
                    <input type="radio" class="form-check-input" name="maint" id="edt1" value="1">
                </div>
                <div >
                    <label >UPDATE</label>
                    <input type="radio" class="form-check-input" name="maint" id="edt2" value="2">
                </div>
                <div >
                    <label>DELETE</label>
                    <input type="radio" class="form-check-input" name="maint" id="edt3" value="3">
                </div>
                <input type="submit" value="Submit" id="EmployeesMaintBtn"/>
            </div>
        </fieldset>

    </div>

</form>

<form id="DeliveryRoutesTable" action="DeliveryRoutesMaintServlet" method="GET">

    <div class='container'>

        <fieldset class="form-group">
            <legend><h2>DELIVERY ROUTES TABLE</h2></legend>
            <div id="RoutesTablesContainer" class="form-group">

                <div >
                    <label >ADD</label>
                    <input type="radio" class="form-check-input" name="maint" id="rdt1" value="1">
                </div>
                <div ">
                    <label>UPDATE</label>
                    <input type="radio" class="form-check-input" name="maint" id="rdt2" value="2">
                </div>
                <div >
                    <label>DELETE</label>
                    <input type="radio" class="form-check-input" name="maint" id="rdt3" value="3">
                </div>
                <input type="submit" value="Submit" id="RoutesMaintBtn"/>
            </div>
        </fieldset>
    </div>
</form>
<form id="SubdealersTable" action="SubdealersMaint" method="GET">
    <div class='container'>
        <fieldset class="form-group">
            <legend><h2>SUB-DEALERS TABLE</h2></legend>
            <div id="SubdealersTableContainer" class="form-group">

                <div>
                    <label>ADD</label>
                    <input type="radio" class="form-check-input" name="maint" id="sdt1" value="1">
                </div>
                <div>
                    <label>UPDATE</label>
                    <input type="radio" class="form-check-input" name="maint" id="sdt2" value="2">
                </div>
                <div >
                    <label>DELETE</label>
                    <input type="radio" class="form-check-input" name="maint" id="sdt3" value="3">
                </div>
                <input type="submit" value="Submit" id="SubdealersMaintBtn"/>
            </div>
        </fieldset>

    </div>

</form>

<form id="CylinderOptionsTable" action="CylinderOptionsMaint" method="GET"">

    <div class='container'>

        <fieldset class="form-group">
            <legend><h2>CYLINDER OPTIONS TABLE</h2></legend>
            <div id="CylinderOptionsTablesContainer" class="form-group">

                <div>
                    <label>ADD</label>
                    <input type="radio" class="form-check-input" name="maint" id="cdt1" value="1">
                </div>
                <div>
                    <label>UPDATE</label>
                    <input type="radio" class="form-check-input" name="maint" id="cdt2" value="2">
                </div>
                <div>
                    <label>DELETE</label>
                    <input type="radio" class="form-check-input" name="maint" id="cdt3" value="3">
                </div>
                <input type="submit" value="Submit" id="CylOptMaintBtn"/>
            </div>
        </fieldset>

    </div>

</form>

<form id="UsersTable" action="UsersMaint" method="GET">

    <div class='container'>

        <fieldset class="form-group">
            <legend><h2>USERS TABLE</h2></legend>
            <div id="UsersTablesContainer" class="form-group">
                <div>
                    <label>View All Users</label>
                    <input type="radio" class="form-check-input" name="maint" id="zdt0" value="0">
                </div>
                <div>
                    <label>ADD</label>
                    <input type="radio" class="form-check-input" name="maint" id="zdt1" value="1">
                </div>
                <div>
                    <label>UPDATE</label>
                    <input type="radio" class="form-check-input" name="maint" id="zdt2" value="2">
                </div>
                <div>
                    <label>DELETE</label>
                    <input type="radio" class="form-check-input" name="maint" id="zdt3" value="3">
                </div>
            </div>
            <input type="submit" value="Submit" id="UsersMaintBtn"/>
        </fieldset>

    </div>

</form>
</body>
</html>
