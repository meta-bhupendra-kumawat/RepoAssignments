<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%session.removeAttribute("email"); %>
<div>
	<h1 align="center">Login</h1>
	<br/>
	<form action="../LoginServlet" method="POST">
		<table align="center">
			<tr>
				<td>
					<lable>Email : </lable>
				</td>
				<td>
					<input type="email" name="email" id="email" placeholder="Enter email" required>
				</td>
			</tr>
			<tr>
				<td>
					<lable>Password : </lable>
				</td>
				<td>
					<input type="password" name="password" id="password" placeholder="Enter password" required>
				</td>
			</tr>
			<tr>
				<td align="center" colspan="2">
					<input type="submit" value="Login">
				</td>
			</tr>
			<%if(session.getAttribute("error") != null){ %>
			<tr>
				<td align="center">
				<label style="color: red"><%=session.getAttribute("error") %></label>
				</td>
			</tr>
			<%
				session.removeAttribute("error");
				} %>
			<%if(session.getAttribute("message") != null){ %>
			<tr>
				<td align="center">
				<label style="color: green"><%=session.getAttribute("message") %></label>
				</td>
			</tr>
			<%
				session.removeAttribute("message");
				} %>
		</table>
	</form>
</div>
</body>
</html>