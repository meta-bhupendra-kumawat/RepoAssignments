<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <li><a href="/logout" method="POST" style="margin: 10px;">Logout</a></li>
            </ul>
        </div>
    </div>
</nav>


<div class="d-flex justify-content-center"><h2>Profile</h2></div>
	<div align="center">

		
		<table>
			<thead>
				<tr>
					<td>Name</td>
					<td>Email</td>
					<td>Action</td>
					<td style="display:none;">
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${friendList}" var="friend" >
				<tr>
					<td>${friend.fullName }</td>
					<td>${friend.email }</td>
					<td >
						<form:form action="/showFriendProfile" modelAttribute="employeeFriend" method="POST">
							<form:input path="email" value="${friend.email}" type="hidden"/>
							<button type="submit" class="btn btn-primary">View profile</button>
						</form:form>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		
	</div>
</body>
</html>