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

<nav class="navbar navbar-default ">
    <div class="container-fluid ">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Parking System</a>
        </div>
        <div class="justify-content-end" style="float: right;">
            <ul class="nav navbar-nav " style="display: -webkit-inline-box;">
            	<li><a href="/profile" method="POST" style="margin: 10px;">Profile</a></li>
            	<li><a href="/showFriends" method="POST" style="margin: 10px;">Friends</a></li>
                <li><a href="/logout" method="POST" style="margin: 10px;">Logout</a></li>
            </ul>
        </div>
    </div>
</nav>


<div class="d-flex justify-content-center"><h2>Profile</h2></div>
	<div align="center">
		<form:form  modelAttribute="friend" method="get" action="/">
			<div class="form-group row col-md-4">
				<form:label path="fullName" value="${employee.fullName}">Full Name</form:label>
				<form:input path="fullName" cssClass="form-control"
					id="1" placeholder="Enter Full Name" readonly="true"/>
				<form:errors path="fullName" cssClass="text-danger" />
			</div>
			<div class="form-group row col-md-4">
				<form:label path="gender">Gender &emsp;&emsp;</form:label>
				<form:input path="gender" cssClass="form-control"
					id="2" placeholder="Enter Contact" readonly="true"/>
				<form:errors path="gender" cssClass="text-danger" />
			</div>
			<div class="form-group col-md-4 row">
				<form:label path="email">Email address</form:label>
				<form:input type="email" path="email" cssClass="form-control"
					id="3" placeholder="Enter email" readonly="true"/>
				<form:errors path="email" cssClass="text-danger" />
			</div>

			<div class="form-group row col-md-4 row">
				<form:label path="contact">Contact</form:label>
				<form:input path="contact" cssClass="form-control"
					id="6" placeholder="Enter Contact" readonly="true"/>
				<form:errors path="contact" cssClass="text-danger" />
			</div>
			<div class="form-group row col-md-4 row">
				<form:label path="company">Company&emsp;&emsp;</form:label>
				<form:input path="company" cssClass="form-control"
					id="6" placeholder="Enter Contact" readonly="true" />
				<form:errors path="company" cssClass="text-danger" />
			</div>

		</form:form>
	</div>
</body>
</html>