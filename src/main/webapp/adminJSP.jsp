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
    <title>$Title$</title>
    <script src="js/Administration.js" charset="utf-8"></script>
</head>
<body>
<h2>Administrator Console</h2>
<form id="updateForm">
    <div class='container'>

        <fieldset class="form-group">
            <legend><h2>Select Table to UPDATE</h2></legend>
        <div id="updateTablesContainer" class="form-group">

        <div class="radio-inline">
            <label class="radio-inline">
                <input type="radio" class="form-check-input" name="dataTable" id="updateDataTable1" value="employee">
               Employees - Search Term:  Enter 'First Name Last Name'
            </label>
        </div>
        <div class="radio-inline">
            <label class="radio-inline">
                <input type="radio" class="form-check-input" name="dataTable" id="updateDataTable2" value="deliveryRoute">
                Delivery Routes - Search Term:  Enter 'City'
            </label>
        </div>
        <div class="radio-inline">
            <label class="radio-inline">
                <input type="radio" class="form-check-input" name="dataTable" id="updateDataTable3" value="cylinders">
                Cylinder Options - Search Term:  - Enter 'Gas Number'
            </label>
        </div>
        <div class="radio-inline">
            <label class="radio-inline">
                <input type="radio" class="form-check-input" name="dataTable" id="updateDataTable4" value="subdealers">
                Subdealers - Search Term: - Enter 'Customer Number'
            </label>
        </div>
        <div class="radio-inline">
            <label class="radio-inline">
                <input type="radio" class="form-check-input" name="dataTable" id="updateDataTable5" value="cities">
                Cities By ZipCode Search Term: - Enter 'Zip Code'-
            </label>
        </div>
        <div class="radio-inline">
            <label class="radio-inline">
                <input type="radio" class="form-check-input" name="dataTable" id="updateDataTable6" value="users">
                Users - Search Term: - Enter 'User Name'
            </label>
        </div>
            <div>
                <label for="searchTerm">
                   SEARCH TERM
                </label>
                <input type="text" id="searchTerm" name="searchTerm">
            </div>

        </div>
            <input type="button" value="Submit" id="updateBtn"/>
        </fieldset>
    </div>
</form>
<form id="addForm">
    <div class='container'>

        <fieldset class="form-group">
            <legend><h2>Select Table to ADD RECORD</h2></legend>
            <div id="AddTablesContainer" class="form-group">

                <div class="radio-inline">
                    <label class="radio-inline">
                        <input type="radio" class="form-check-input" name="addDataTable" id="addDataTable1" value="employee">
                        Employees
                    </label>
                </div>
                <div class="radio-inline">
                    <label class="radio-inline">
                        <input type="radio" class="form-check-input" name="addDataTable" id="addDataTable2" value="deliveryRoute">
                        Delivery Routes
                    </label>
                </div>
                <div class="radio-inline">
                    <label class="radio-inline">
                        <input type="radio" class="form-check-input" name="addDataTable" id="addDataTable3" value="cylinders">
                        Cylinder Options
                    </label>
                </div>
                <div class="radio-inline">
                    <label class="radio-inline">
                        <input type="radio" class="form-check-input" name="addDataTable" id="addDdtaTable4" value="subdealers">
                        Subdealers - Search Term: - Enter 'Customer Number'
                    </label>
                </div>
                <div class="radio-inline">
                    <label class="radio-inline">
                        <input type="radio" class="form-check-input" name="addDataTable" id="addDataTable5" value="cities">
                        Cities By ZipCode
                    </label>
                </div>
                <div class="radio-inline">
                    <label class="radio-inline">
                        <input type="radio" class="form-check-input" name="addDataTable" id="addDataTable6" value="users">
                        Users
                    </label>
                </div>
                </div>
            <input type="button" value="Submit" id="addBtn"/>
        </fieldset>
    </div>
</form>
<form id="deleteForm">
    <div class='container'>

        <fieldset class="form-group">
            <legend><h2>Select Table to DELETE RECORD</h2></legend>
            <div id="DeleteTablesContainer" class="form-group">

                <div class="radio-inline">
                    <label class="radio-inline">
                        <input type="radio" class="form-check-input" name="deleteDataTable" id="deleteDataTable1" value="employee">
                        Employees
                    </label>
                </div>
                <div class="radio-inline">
                    <label class="radio-inline">
                        <input type="radio" class="form-check-input" name="deleteDataTable" id="deleteDataTable2" value="deliveryRoute">
                        Delivery Routes
                    </label>
                </div>
                <div class="radio-inline">
                    <label class="radio-inline">
                        <input type="radio" class="form-check-input" name="deleteDataTable" id="deleteDataTable3" value="cylinders">
                        Cylinder Options
                    </label>
                </div>
                <div class="radio-inline">
                    <label class="radio-inline">
                        <input type="radio" class="form-check-input" name="deleteDataTable" id="deleteDataTable4" value="subdealers">
                        Subdealers - Search Term: - Enter 'Customer Number'
                    </label>
                </div>
                <div class="radio-inline">
                    <label class="radio-inline">
                        <input type="radio" class="form-check-input" name="deleteDataTable" id="deleteDataTable5" value="cities">
                        Cities By ZipCode
                    </label>
                </div>
                <div class="radio-inline">
                    <label class="radio-inline">
                        <input type="radio" class="form-check-input" name="deleteDataTable" id="deleteDataTable6" value="users">
                        Users
                    </label>
                </div>
            </div>
            <input type="button" value="Submit" id="deleteBtn"/>
        </fieldset>
    </div>
</form>
<script type="text/javascript">
    init();
</script>
</body>
</html>
