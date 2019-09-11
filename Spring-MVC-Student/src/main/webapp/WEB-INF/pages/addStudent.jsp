<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Student</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
	<div class="d-flex justify-content-center">
		<h4 class="blockquote">Enter student detail</h4>
	</div>
	<br>
	<div align="center">
		<form:form action="/submit" modelAttribute="studentObject">

			<div class="form-group row col-md-4">
				<form:label path="firstName">First Name</form:label>
				<form:input path="firstName" cssClass="form-control"
					id="nameInputEmail1" placeholder="Enter First Name" />
				<form:errors path="firstName" cssClass="text-danger" />
			</div>
			<div class="form-group col-md-4 row">
				<form:label path="lastName">Last Name</form:label>
				<form:input path="lastName" cssClass="form-control"
					id="nameInputEmail1" placeholder="Enter Last Name" />
				<form:errors path="lastName" cssClass="text-danger" />
			</div>
			<div class="form-group col-md-4 row">
				<form:label path="fatherName">Father's Name</form:label>
				<form:input path="fatherName" cssClass="form-control"
					id="nameInputEmail1" placeholder="Enter Father's Name" />
				<form:errors path="fatherName" cssClass="text-danger" />
			</div>
			<div class="form-group col-md-4 row">
				<form:label path="email">Email address</form:label>
				<form:input type="email" path="email" cssClass="form-control"
					id="exampleInputEmail1" placeholder="Enter email" />
				<form:errors path="email" cssClass="text-danger" />
			</div>

			<div class="form-group row col-md-4 row">
				<form:label path="studentClass">Class</form:label>
				<form:input path="studentClass" cssClass="form-control"
					id="nameInputEmail1" placeholder="Enter Class" />
				<form:errors path="studentClass" cssClass="text-danger" />
			</div>
			<div class="form-group row col-md-4 row">
				<form:label path="age">Age</form:label>
				<form:input path="age" cssClass="form-control" id="nameInputEmail1"
					placeholder="Enter age" />
				<form:errors path="age" cssClass="text-danger" />
			</div>
			<div class="d-flex justify-content-center">
				<button type="submit" class="btn btn-primary">Submit</button>
			</div>
		</form:form>
	</div>
</body>
</html>