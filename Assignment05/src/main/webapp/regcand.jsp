<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Candidate</title>
</head>
<body>
	<h2>Register Candidate</h2>

	<jsp:useBean id="ancb" class="com.sam.beans.AddNewCandBean"></jsp:useBean>
	<jsp:setProperty name="ancb" property="*" />

	${ancb.addNewCandidate()}

	<c:choose>
		<c:when test="${ancb.count == 1}">
			<jsp:forward page="result.jsp">
			<jsp:param name="msg" value="Candidate Added Successfully." />
			</jsp:forward>
		</c:when>

		<c:otherwise>
			<jsp:forward page="result.jsp">
			<jsp:param name="msg" value="Candidate Registration Failed." />
			</jsp:forward>
		</c:otherwise>
	</c:choose>

</body>
</html>