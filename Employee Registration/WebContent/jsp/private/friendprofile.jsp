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
	
	<div>
	<h1 align="center">Friend Profile</h1>
	<table align="center">
		<%if(session.getAttribute("friendDetail")!= null){
			Employee employee = (Employee) session.getAttribute("friendDetail");
			%>
		<tr>
			<td>
				<label>Employee Id :</label>
			</td>
			<td>
				<label><%=employee.getId() %></label>
			</td>
		</tr>
		<tr>
			<td>
				<label>Name : </label>
			</td>
			<td>
				<label><%=employee.getName() %></label>
			</td>
		</tr>
		<tr>
			<td>
				<label>Gender : </label>
			</td>
			<td>
				<label><%=employee.getGender() %></label>
			</td>
		</tr>
		<tr>
			<td>
				<label>Email : </label>
			</td>
			<td>
				<label><%=employee.getEmail() %></label>
			</td>
		</tr>
		<tr>
			<td>
				<label>Contact Number : </label>
			</td>
			<td>
				<label><%=employee.getPhoneNumber() %></label>
			</td>
		</tr>
		<tr>
			<td>
				<label>Company : </label>
			</td>
			<td>
				<label><%=employee.getOrganization() %></label>
			</td>
		</tr>
		<%
		session.removeAttribute("friendDetail");
		} %>
	</table>
</div>
</body>
</html>