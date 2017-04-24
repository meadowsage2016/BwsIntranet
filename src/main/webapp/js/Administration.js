/**
 * Created by student on 3/17/17.
 */
$(document).ready(function() {

    var updateButton = document.getElementById("updateBtn");
    updateButton.onclick = updateTableOption;

    var addButton = document.getElementById("addBtn");
    addButton.onclick = addTableOption;

    var deleteButton = document.getElementById("deleteBtn");

    deleteButton.onclick = deleteTableOption;

    console.log("Im in the doc ready");

})



function updateTableOption() {
    var updateOption = document.getElementsByName("dataTable").value;
    document.location.href = "/AdministratorMaintUpdate?table=updateOption";
}

function addTableOption() {
    var updateOption = document.getElementsByName("addDataTable").value;
    document.location.href = "/AdministratorMaintAdd?table=addOption";
}

function deleteTableOption() {
    var deleteOption = document.getElementsByName("deleteDataTable").value;
    document.location.href = "/AdministratorMaintDelete?table=deleteOption";
}