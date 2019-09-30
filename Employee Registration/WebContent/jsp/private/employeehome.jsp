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
					<a href="../../RedirectToShowFriendsPage">Show Friends</a>
				</li>
				<li>
					<a href="../../ShowEmployeeDetailServlet">Refresh</a>
				</li>
			</ul>
		</div>
	</nav>
<%if(session.getAttribute("message")!= null){ %>
<h3 style="color: green" align="center"><%=session.getAttribute("message") %></h3>
<%session.removeAttribute("message");%>
<%} %>
<%if(session.getAttribute("error")!= null){ %>
<h3 style="color: red" align="center"><%=session.getAttribute("error") %></h3>
<%session.removeAttribute("error");%>
<%} %>
<div>
<h1 align="center">Home</h1>
	<table align="center">
		<%if(session.getAttribute("employeeDetail")!= null){
			Employee employee = (Employee) session.getAttribute("employeeDetail");
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
				<label>Password : </label>
			</td>
			<td>
				<label><%=employee.getPassword() %></label>
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
		<tr>
			<td colspan="2" align="center">
				<a href="../../RedirectToEditPage">Edit</a>
			</td>
		</tr>
		<%
		session.removeAttribute("employeeDetail");
		} %>
	</table>
</div>
</body>
</html>