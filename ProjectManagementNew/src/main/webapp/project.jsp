<%@page import="com.project"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Project Management</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.6.0.min.js"></script>
<script src="Components/project.js"></script>

</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-6">
				<h1>Project Management GadgetBadget</h1>
				<form id="formProject" name="formProject">
					Author Name: <input id="authorName" name="authorName" type="text"
						class="form-control form-control-sm"> <br> 
					Project Category:<input id="projectCategory" name="projectCategory" type="text"
						class="form-control form-control-sm"> <br> 
					Project Name: <input id="projectName" name="projectName" type="text"
						class="form-control form-control-sm"> <br> 
					Project Price: <input id="projectPrice" name="projectPrice" type="text"
						class="form-control form-control-sm"> <br> 
					Author Email: <input id="authorEmail" name="authorEmail" type="text"
						class="form-control form-control-sm"> <br>	
					Project Description: <input id="projectDesc" name="projectDesc" type="text"
						class="form-control form-control-sm"> <br>
					<input id="btnSave" name="btnSave" type="button" value="Save"
						class="btn btn-primary"> <input type="hidden"
						id="hidProjectIDSave" name="hidProjectIDSave" value="">
				</form>
				<div id="alertSuccess" class="alert alert-success"></div>
				<div id="alertError" class="alert alert-danger"></div>
				<br>
				<div id="divProjectGrid">
					<%
					project projectObj = new project();
					out.print(projectObj.viewProjects());
					%>
				</div>
			</div>
		</div>
	</div>
</body>
</html>