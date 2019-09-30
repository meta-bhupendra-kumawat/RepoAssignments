<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
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
<%@ page import="dto.Employee" %>
<div>
<h1 align="center">Update Detail</h1>
	<form action="../../UpdateEmployeeDetailServlet" method="POST">
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
			 <input type="email" name="email" id="email" value="<%=employee.getEmail() %>" placeholder="Enter your email" required>
			</td>
		</tr>
		<tr>
			<td>
				<label>Password : </label>
			</td>
			<td>
			<input type="password" name="password" id="password" placeholder="Enter your password" value="<%=employee.getPassword() %>" pattern="[0-9]+" minlength="8" title="(should be minimum 8 character and should contain only number)" required>
				<label></label>
			</td>
		</tr>
		<tr>
			<td>
				<label>Contact Number : </label>
			</td>
			<td>
			<input type="text" name="contactnumber" id="contactnumber" placeholder="Enter your contact number" value="<%=employee.getPhoneNumber() %>" pattern="[0-9]+" minlength="8" title="(should be numeric only and minimum 8 numbers)" required>
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
				<input type="submit" value="Update">
			</td>
		</tr>
		<%
		session.removeAttribute("employeeDetail");
		} %>
	</table>
	</form>
</div>

</body>
</html>