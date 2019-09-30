<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ page import="dto.Employee" %>
<%@ page import="java.util.List" %>
<nav>
		<div>
			<ul>
				<li>
					<a href="../../LogoutServlet">Logout</a>
				</li>
				<li>
					<a href="../../ShowEmployeeDetailServlet">Home</a>
				</li>
			</ul>
		</div>
	</nav>
	<h1 align="center">Friend List</h1>
	<br/>
	<div>
		<table align="center">
			<tr>
				<th>
					<label>Employee Id</label>
				</th>
				<th>
					<label>Employee Name</label>
				</th>
				<th>
					<label>Employee Email</label>
				</th>
				<th>
					<label>Go To Profile</label>
				</th>
			</tr>
			<% if(session.getAttribute("friendList")!= null){
			List<Employee> friendList = (List<Employee>) session.getAttribute("friendList");
			%>
			<% for(Employee employee : friendList){
				%>
				<tr>
					<td>
						<label><%=employee.getId() %></label>
					</td>
					<td>
						<label><%=employee.getName() %></label>
					</td>
					<td>
						<label><%=employee.getEmail() %></label>
					</td>
					<td>
						<form action="../../ShowFriendDetailServlet" method="POST">
							<input type="hidden" name="email" value="<%=employee.getEmail() %>">
							<input type="submit" value="Open Profile">
						</form>
					</td>
				</tr>
			<%} %>
			<%} %>
		</table>
	</div>
</body>
</html>