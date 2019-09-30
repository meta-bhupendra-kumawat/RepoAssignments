<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Login Page</title>
</head>
<body>

   <h1>Login</h1>
   <form name='loginForm' action="/login" method = "post">
   <h4>${errorMsg}</h4>
      <table>
         <tr>
            <td>User:</td>
            <td><input type='text' name='username'></td>
         </tr>
         <tr>
            <td>Password:</td>
            <td><input type='password' name='password' /></td>
         </tr>
         <tr>
            <td><input name="submit" type="submit" value="submit" /></td>
         </tr>
      </table>
  </form>
</body>
</html>
