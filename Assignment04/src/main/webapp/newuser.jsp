<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New user</title>
</head>
<body>
	<h1>Sign Up</h1>
	<form method="post" action="RegisterJsp.jsp">
		First Name: 
		<input type="text" name="firstName" /><br /><br />

		Last Name:
		<input type="text" name="lastName" /><br /><br />

		Email: 
		<input type="text" name="email" /><br /><br />

		Password:
		<input type="password" name="password" /><br /><br />

		Date:
		<input type="date" name="birthdate" /><br /><br />

		<input type="submit" name="Register" /><br /><br />
	</form>
</body>
</html>