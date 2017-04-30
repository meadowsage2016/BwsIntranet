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
</head>
<h2>Administrator Console</h2>

<form id="EmployeesTable" method="POST" action="EmployeesMaintServlet">


    <div class='container'>

        <fieldset class="form-group">

            <legend><h2>EMPLOYEES TABLE</h2></legend>
            <div id="EmpTableContainer" class="form-group">
                <div class="radio-inline">
                    <label class="radio-inline">
                        <input type="radio" class="form-check-input" name="maint" id="edt1" value="1">
                        ADD
                    </label>
                </div>
                <div class="radio-inline">
                    <label class="radio-inline">
                        <input type="radio" class="form-check-input" name="maint" id="edt2" value="2">
                        UPDATE
                    </label>
                </div>
                <div class="radio-inline">
                    <label class="radio-inline">
                        <input type="radio" class="form-check-input" name="maint" id="edt3" value="3">
                        DELETE
                    </label>
                </div>
                <input type="submit" value="Submit" id="EmployeesMaintBtn"/>
            </div>
        </fieldset>

    </div>

</form>

<form id="DeliveryRoutesTable" action="DeliveryRouteMaintServlet" method="POST">

    <div class='container'>

        <fieldset class="form-group">
            <legend><h2>DELIVERY ROUTES TABLE</h2></legend>
            <div id="RoutesTablesContainer" class="form-group">

                <div class="radio-inline">
                    <label class="radio-inline">
                        <input type="radio" class="form-check-input" name="maint" id="rdt1" value="1">
                        ADD
                    </label>
                </div>
                <div class="radio-inline">
                    <label class="radio-inline">
                        <input type="radio" class="form-check-input" name="maint" id="rdt2" value="2">
                        UPDATE
                    </label>
                </div>
                <div class="radio-inline">
                    <label class="radio-inline">
                        <input type="radio" class="form-check-input" name="maint" id="rdt3" value="3">
                        DELETE
                    </label>
                </div>
                <input type="submit" value="Submit" id="RoutesMaintBtn"/>
            </div>
        </fieldset>
    </div>
</form>
<form id="SubdealersTable" action="subdealersMaint" method="POST">
    <div class='container'>
        <fieldset class="form-group">
            <legend><h2>SUB-DEALERS TABLE</h2></legend>
            <div id="SubdealersTableContainer" class="form-group">

                <div class="radio-inline">
                    <label class="radio-inline">
                        <input type="radio" class="form-check-input" name="maint" id="sdt1" value="1">
                        ADD
                    </label>
                </div>
                <div class="radio-inline">
                    <label class="radio-inline">
                        <input type="radio" class="form-check-input" name="maint" id="sdt2" value="2">
                        UPDATE
                    </label>
                </div>
                <div class="radio-inline">
                    <label class="radio-inline">
                        <input type="radio" class="form-check-input" name="maint" id="sdt3" value="3">
                        DELETE
                    </label>
                </div>
                <input type="submit" value="Submit" id="SubdealersMaintBtn"/>
            </div>
        </fieldset>

    </div>

</form>

<form id="CylinderOptionsTable" action="cylOptMaint" method=POST">

    <div class='container'>

        <fieldset class="form-group">
            <legend><h2>CYLINDER OPTIONS TABLE</h2></legend>
            <div id="CylinderOptionsTablesContainer" class="form-group">

                <div class="radio-inline">
                    <label class="radio-inline">
                        <input type="radio" class="form-check-input" name="maint" id="cdt1" value="1">
                        ADD
                    </label>
                </div>
                <div class="radio-inline">
                    <label class="radio-inline">
                        <input type="radio" class="form-check-input" name="maint" id="cdt2" value="2">
                        UPDATE
                    </label>
                </div>
                <div class="radio-inline">
                    <label class="radio-inline">
                        <input type="radio" class="form-check-input" name="maint" id="cdt3" value="3">
                        DELETE
                    </label>
                </div>
                <input type="submit" value="Submit" id="CylOptMaintBtn"/>
            </div>
        </fieldset>

    </div>

</form>

<form id="CitiesTable" action="citiesMaint" method="POST">

    <div class='container'>

        <fieldset class="form-group">
            <legend><h2>CITIES BY ZIP TABLE</h2></legend>
            <div id="CitiesTablesContainer" class="form-group">

                <div class="radio-inline">
                    <label class="radio-inline">
                        <input type="radio" class="form-check-input" name="maint" id="zdt1" value="1">
                        ADD
                    </label>
                </div>
                <div class="radio-inline">
                    <label class="radio-inline">
                        <input type="radio" class="form-check-input" name="maint" id="zdt2" value="2">
                        UPDATE
                    </label>
                </div>
                <div class="radio-inline">
                    <label class="radio-inline">
                        <input type="radio" class="form-check-input" name="maint" id="zdt3" value="3">
                        DELETE
                    </label>
                </div>
            </div>
            <input type="submit" value="Submit" id="CitiesMaintBtn"/>
        </fieldset>

    </div>

</form>

</body>
</html>
