<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home page</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

</head>
<body>
	<br>
	<div class="d-flex justify-content-center">
		<h4 class="blockquote">${message}</h4>
	</div>
	<br>
	<div class="d-flex justify-content-center">
		<p>
			<a href="/addStudent" class="text-info">Add Student</a>
		</p>
	</div>
	<div class="d-flex justify-content-center">
		<p>
			<a href="/showStudents" class="text-info">Show Students</a>
		</p>
	</div>
</body>
</html>