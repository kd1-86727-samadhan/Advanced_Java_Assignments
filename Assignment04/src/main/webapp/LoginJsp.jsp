<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LoginJsp</title>
</head>
<body>
	<jsp:useBean id="lb" class="com.sam.beans.LoginBean" />
	<jsp:setProperty property="*" name="lb" />
	${lb.loginUser()}
	<c:choose>
		<c:when test="${lb.user!=null}">
			<h1>Login successful</h1>
		</c:when>
		<c:otherwise>
			<h1>Login failed</h1>
		</c:otherwise>
	</c:choose>

</body>
</html>

