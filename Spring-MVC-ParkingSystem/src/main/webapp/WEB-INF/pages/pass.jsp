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

<nav class="navbar navbar-default ">
    <div class="container-fluid ">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Parking System</a>
        </div>
        <div class="justify-content-end" style="float: right;">
            <ul class="nav navbar-nav " style="display: -webkit-inline-box;">
            	<%-- <li><a href="/profile" method="POST" style="margin: 10px;">Profile</a></li> --%>
                <li><a href="/logout" method="POST" style="margin: 10px;">Logout</a></li>
            </ul>
        </div>
    </div>
</nav>
				
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
			
			<tbody id="rates">
				<tr>
					<td>Daily</td>
					<td><span class="rate">${priceList.daily }</span> <span class="displayedCurrency">INR</span></td>
				</tr>
				<tr>
					<td>Monthly</td>
					<td><span class="rate">${priceList.monthly}</span> <span class="displayedCurrency">INR</span></td>
				</tr>
				<tr>
					<td>Yearly</td>
					<td><span class="rate">${priceList.yearly}</span> <span class="displayedCurrency">INR</span></td>
				</tr>
			</tbody>
		</table>

		<div class="form-group row col-md-4 row">
			<div class="dropdown">
				Currency : <label> <select id="currency" name="currency" onchange="changeCurrency()" >
						<option value="" disabled>Select currency</option>
						<option value="USD">USD</option>
						<option value="INR" selected>INR</option>
						<option value="JPY">JPY</option>
				</select>
				</label>
				<div id="type" style="display:none;">${priceList.type}</div>
			</div>
		</div>
		
		
		<form:form modelAttribute="pass" method="POST" action="/getPass">

			<div id=Cycle class="form-group row col-md-4">
				<form:label path="price">Select a plan &emsp;&emsp;</form:label>
				<label><form:radiobutton path="price" value="${priceList.daily }" class="price" checked />&thinsp;Daily&emsp;</label> 
				<label><form:radiobutton path="price" value="${priceList.monthly}" class="price" />&thinsp;Monthly&emsp;</label>
				<label><form:radiobutton path="price" value="${priceList.yearly}" class="price" />&thinsp;Yearly&emsp;</label>
				<form:errors path="price" cssClass="text-danger" />
			</div>
			<div class="d-flex justify-content-center">
				<button type="submit" class="btn btn-primary">Buy</button>
			</div>
			
		

		</form:form>
		
		
	</div>
	<script src="/js/main.js"> </script>
</body>
</html>
