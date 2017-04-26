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
<c:import url="include-headtag.jsp" />
<body>
<h2>Administrator Console</h2>

<form id="TableSelectForm">
    <div class='container'>

        <fieldset class="form-group">
            <legend><h2>EMPLOYEES TABLE</h2></legend>
            <div id="EmpTableContainer" class="form-group">

                <div class="radio-inline">
                    <label class="radio-inline">
                        <input type="radio" class="form-check-input" name="maint" id="edt1" value="edt1">
                        ADD
                    </label>
                </div>
                <div class="radio-inline">
                    <label class="radio-inline">
                        <input type="radio" class="form-check-input" name="maint" id="edt2" value="edt2">
                        UPDATE
                    </label>
                </div>
                <div class="radio-inline">
                    <label class="radio-inline">
                        <input type="radio" class="form-check-input" name="maint" id="edt3" value="edt3">
                        DELETE
                    </label>
                </div>
                </div>
        </fieldset>
        <fieldset class="form-group">
            <legend><h2>DELIVERY ROUTES TABLE</h2></legend>
            <div id="RoutesTablesContainer" class="form-group">

                <div class="radio-inline">
                    <label class="radio-inline">
                        <input type="radio" class="form-check-input" name="maint" id="rdt1" value="rdt1">
                        ADD
                    </label>
                </div>
                <div class="radio-inline">
                    <label class="radio-inline">
                        <input type="radio" class="form-check-input" name="maint" id="rdt2" value="rdt2">
                        UPDATE
                    </label>
                </div>
                <div class="radio-inline">
                    <label class="radio-inline">
                        <input type="radio" class="form-check-input" name="maint" id="rdt3" value="rdt3">
                        DELETE
                    </label>
                </div>
            </div>
        </fieldset>
        <fieldset class="form-group">
            <legend><h2>SUB-DEALERS TABLE</h2></legend>
            <div id="SubdealersTableContainer" class="form-group">

                <div class="radio-inline">
                    <label class="radio-inline">
                        <input type="radio" class="form-check-input" name="maint" id="sdt1" value="sdt1">
                        ADD
                    </label>
                </div>
                <div class="radio-inline">
                    <label class="radio-inline">
                        <input type="radio" class="form-check-input" name="maint" id="sdt2" value="sdt2">
                        UPDATE
                    </label>
                </div>
                <div class="radio-inline">
                    <label class="radio-inline">
                        <input type="radio" class="form-check-input" name="maint" id="sdt3" value="sdt3">
                        DELETE
                    </label>
                </div>
            </div>
        </fieldset>
        <fieldset class="form-group">
            <legend><h2>CYLINDER OPTIONS TABLE</h2></legend>
            <div id="CylinderOptionsTablesContainer" class="form-group">

                <div class="radio-inline">
                    <label class="radio-inline">
                        <input type="radio" class="form-check-input" name="maint" id="cdt1" value="cdt1">
                        ADD
                    </label>
                </div>
                <div class="radio-inline">
                    <label class="radio-inline">
                        <input type="radio" class="form-check-input" name="maint" id="cdt2" value="cdt2">
                        UPDATE
                    </label>
                </div>
                <div class="radio-inline">
                    <label class="radio-inline">
                        <input type="radio" class="form-check-input" name="maint" id="cdt3" value="cdt3">
                        DELETE
                    </label>
                </div>
            </div>
        </fieldset>
        <fieldset class="form-group">
            <legend><h2>CITIES BY ZIP TABLE</h2></legend>
            <div id="CitiesTablesContainer" class="form-group">

                <div class="radio-inline">
                    <label class="radio-inline">
                        <input type="radio" class="form-check-input" name="maint" id="zdt1" value="zdt1">
                        ADD
                    </label>
                </div>
                <div class="radio-inline">
                    <label class="radio-inline">
                        <input type="radio" class="form-check-input" name="maint" id="zdt2" value="zdt2">
                        UPDATE
                    </label>
                </div>
                <div class="radio-inline">
                    <label class="radio-inline">
                        <input type="radio" class="form-check-input" name="maint" id="zdt3" value="zdt3">
                        DELETE
                    </label>
                </div>
            </div>
            <input type="button" value="Submit" id="MaintBtn"/>
        </fieldset>
    </div>
</form>
</body>
</html>
