$(document).ready(function() {
if ($("#alertSuccess").text().trim() == "") {
$("#alertSuccess").hide();
}

 $("#alertError").hide();

});


// SAVE ============================================
$(document).on("click", "#btnSave", function(event) {
// Clear alerts---------------------
$("#alertSuccess").text("");
$("#alertSuccess").hide();
$("#alertError").text("");
$("#alertError").hide();
// Form validation-------------------
var status = validateProjectForm();
if (status != true) {
$("#alertError").text(status);
$("#alertError").show();
return;
}
// If valid------------------------
var type = ($("#hidProjectIDSave").val() == "") ? "POST" : "PUT";
$.ajax(
{
url: "projectAPI",
type: type,
data: $("#formProject").serialize(),
dataType: "text",
complete: function(response, status) {
onProjectSaveComplete(response.responseText, status);
}
});

});


function onProjectSaveComplete(response, status) {

 if (status == "success") {
var resultSet = JSON.parse(response);
if (resultSet.status.trim() == "success") {
$("#alertSuccess").text("Successfully saved.");
$("#alertSuccess").show();
$("#divProjectGrid").html(resultSet.data);
}

 else if (resultSet.status.trim() == "error") {
$("#alertError").text(resultSet.data);
$("#alertError").show();
}
} else if (status == "error") {
$("#alertError").text("Error while saving.");
$("#alertError").show();
} else {
$("#alertError").text("Unknown error while saving..");
$("#alertError").show();
}

 $("#hidProjectIDSave").val("");
$("#formProject")[0].reset();

}



// UPDATE==========================================
$(document).on("click", ".btnUpdate", function(event) {
$("#hidProjectIDSave").val($(this).closest("tr").find('#hidProjectIDUpdate').val());
$("#authorName").val($(this).closest("tr").find('td:eq(0)').text());
$("#projectCategory").val($(this).closest("tr").find('td:eq(1)').text());
$("#projectName").val($(this).closest("tr").find('td:eq(2)').text());
$("#projectPrice").val($(this).closest("tr").find('td:eq(3)').text());
$("#authorEmail").val($(this).closest("tr").find('td:eq(4)').text());
$("#projectDesc").val($(this).closest("tr").find('td:eq(5)').text());
});


// CLIENT-MODEL================================================================
function validateProjectForm() {
// Author Name
if ($("#authorName").val().trim() == "") {
return "Insert Author Name.";
}
// Category
if ($("#projectCategory").val().trim() == "") {
return "Insert Project Category.";
}

// Project Name
if ($("#projectName").val().trim() == "") {
return "Insert Project Name.";
}

// PRICE-------------------------------
if ($("#projectPrice").val().trim() == "") {
return "Insert Project Price.";

}



// is numerical value
var tmpPrice = $("#projectPrice").val().trim();
if (!$.isNumeric(tmpPrice)) {
return "Insert a numerical value for Project Price.";
}


 // convert to decimal price
$("#projectPrice").val(parseFloat(tmpPrice).toFixed(2));


// Email
if ($("#authorEmail").val().trim() == "") {
return "Insert Author Email.";
}

 // DESCRIPTION------------------------
if ($("#projectDesc").val().trim() == "") {
return "Insert Project Description.";
}
return true;
}




///REMOVE============================================
$(document).on("click", ".btnRemove", function(event) {
$.ajax(
{
url: "projectAPI",
type: "DELETE",
data: "projectID=" + $(this).data("projectid"),
dataType: "text",
complete: function(response, status) {
onProjectDeleteComplete(response.responseText, status);
}

});

});


function onProjectDeleteComplete(response, status) {

 if (status == "success") {
var resultSet = JSON.parse(response);
if (resultSet.status.trim() == "success") {
$("#alertSuccess").text("Successfully deleted.");
$("#alertSuccess").show();
$("#divProjectGrid").html(resultSet.data);
}

 else if (resultSet.status.trim() == "error") {
$("#alertError").text(resultSet.data);
$("#alertError").show();
}

 }

 else if (status == "error") {
$("#alertError").text("Error while deleting.");
$("#alertError").show();
}

 else {
$("#alertError").text("Unknown error while deleting..");
$("#alertError").show();

 }
}