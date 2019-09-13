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

	<div class="d-flex justify-content-center">
		<h2>Buy vehicle pass</h2>
	</div><br><br>
	<div class="container-fluid col-md-4" align="center">

		<table class="table">
			<thead>
				<tr>
					<th scope="col" align="center" class="col-md-4">Price List</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>Daily</td>
					<td></td>
				</tr>
				<tr>
					<td>Monthly</td>
					<td></td>
				</tr>
				<tr>
					<td>Yearly</td>
					<td></td>
				</tr>
			</tbody>
		</table>

		<div class="form-group row col-md-4 row">
			<div class="dropdown">
				Currency : <label> <select id="currency" name="currency"
					onchange="changeCurrency()">
						<option value="" selected>Select currency</option>
						<option value="USD">USD</option>
						<option value="INR">INR</option>
						<option value="JPY">JPY</option>
				</select>
				</label>
				<div id="showCharges"></div>
			</div>
		</div>
		
		<form:form action="" modelAttribute="pass">

			<div class="form-group row col-md-4">
				<form:label path="amount">Select a plan &emsp;&emsp;</form:label>
				<label><form:radiobutton path="amount" value="Daily"
						cssClass="" id="1" />&thinsp;Daily&emsp;</label> 
						<label><form:radiobutton
						path="amount" value="Monthly" cssClass="" id="2" />&thinsp;Monthly&emsp;</label>
						<label><form:radiobutton
						path="amount" value="Yearly" cssClass="" id="3" />&thinsp;Yearly&emsp;</label>
				<form:errors path="amount" cssClass="text-danger" />
			</div>
			<div class="d-flex justify-content-center">
				<button type="submit" class="btn btn-primary">Buy</button>
			</div>
		</form:form>
	</div>
	
</body>
</html>
