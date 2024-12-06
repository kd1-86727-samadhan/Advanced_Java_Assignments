<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

</head>
<body>
	<h2>Register</h2>

	<jsp:useBean id="rg" class="com.sam.beans.RegisterBean" />

	<jsp:setProperty name="rg" property="*" />

	${rg.registerUser()}

	<c:choose>
		<c:when test="${rg.count==1}">
			<p>Registration Successful</p>
			<%-- <c:redirect url="index.jsp"></c:redirect> --%>
		</c:when>
		<c:otherwise>
			<h1>Registration Failed</h1>
		</c:otherwise>
	</c:choose>



</body>
</html>