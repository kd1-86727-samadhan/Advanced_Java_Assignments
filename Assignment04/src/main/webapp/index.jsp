<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h1>Login</h1>

	<form method="post" action="LoginJsp.jsp">
		Email: <input type="text" name="email"><br /><br /> 
		Password: <input type="password" name="password"><br /><br /> 
		<input type="submit" value="Sign In" />
	</form>
</body>
</html>