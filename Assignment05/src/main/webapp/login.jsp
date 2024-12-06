<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="lb" class="com.sam.beans.LoginBean" scope="session" />

	<jsp:setProperty name="lb" property="*" />

	${lb.authenticate()}

	<c:choose>
		<c:when test="${lb.user!=null}">
			<c:choose>
				<c:when test="${lb.user.role=='admin'}">
					<c:redirect url="result.jsp"></c:redirect>
				</c:when>

				<c:otherwise>
					<c:redirect url="candlist.jsp"></c:redirect>
				</c:otherwise>
			</c:choose>
		</c:when>

		<c:otherwise>
			<h2>Login Failed</h2>
			<p>Invalid email or password.</p>
			<p>
				<a href="index.jsp">Login Again</a>
			</p>
		</c:otherwise>
	</c:choose>

</body>
</html>