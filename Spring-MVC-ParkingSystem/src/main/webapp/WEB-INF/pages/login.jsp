<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Parking System</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>

<div class="d-flex justify-content-center"><h2>User login</h2></div>
	<div class="" align="center"><br>
		<form:form modelAttribute="login" method="post">
		<h3>${loginError}</h3>
			<div class="form-group row col-md-4">
				<form:label path="email">Email</form:label>
				<form:input path="email" cssClass="form-control"
					id="nameInputEmail1" placeholder="Enter registered email" />
				<form:errors path="email" cssClass="text-danger" />
			</div>
			<div class="form-group row col-md-4">
				<form:label path="password">Password</form:label>
				<form:input type="password" path="password" cssClass="form-control"
					id="exampleInputEmail1" placeholder="Enter password" />
				<form:errors path="password" cssClass="text-danger" />
			</div>
			
			<div class="d-flex justify-content-center">
				<button type="submit" class="btn btn-primary">Login</button>
			</div><br>
		</form:form>
	</div><br>
	<div class="d-flex justify-content-center"> <h5>Don't have an account?   <a href="/employeeRegistration">Signup</a></h5></div>

</body>
</html>