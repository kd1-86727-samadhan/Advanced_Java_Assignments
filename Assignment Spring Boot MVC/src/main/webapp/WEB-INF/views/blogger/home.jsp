<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Blogger Home Page</title>
</head>
<body>
	<h4>Welcome Blogger Page</h4>
	<%-- 	<h5>BlogPost - List ${requestScope.blogpost_list}</h5> --%>
	
	<h2>Welcome, ${sessionScope.user_details.firstName}</h2>
	<table border="1">
		<thead>
			<tr>
				<th>Id</th>
				<th>Title</th>
				<th>Description</th>
				<th>Last updated</th>
				<th>Action</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="b" items="${requestScope.blogpost_list}">
				<tr>
					<td>${b.id}</td>
					<td>${b.title}</td>
					<td>${b.description}</td>
					<td>${b.updatedOn}</td>
					<td><a href="update">Update</a></td>
					<td><a href="delete">Delete</a></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<p>
	<c:url var="logout" value="/logout"/>
		<a href="${logout}">Logout</a>
	</p>
	
</body>
</html>