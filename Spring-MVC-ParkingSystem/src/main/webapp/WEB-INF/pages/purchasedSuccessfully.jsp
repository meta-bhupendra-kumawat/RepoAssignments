<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Get pass</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>

<form:form  modelAttribute="employee" method="post" action="/logout">
<nav class="navbar navbar-default ">
    <div class="container-fluid ">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Parking System</a>
        </div>
        <div class="justify-content-end" style="float: right;">
            <ul class="nav navbar-nav ">
                <li><a href="/logout" method="POST">Logout</a></li>
            </ul>
        </div>
    </div>
</nav>
</form:form>
				
	<div class="d-flex justify-content-center">
		<h2>Pass Purchases for vehicle ${vehicleNumber}.</h2>
	</div>
	
</body>
</html>
