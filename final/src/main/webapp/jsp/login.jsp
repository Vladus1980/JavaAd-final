<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form name= "f" action="<c:url value='/j_spring_security_check' />" method="POST">
	<div>
		<div>
			<input type="text" name = "j_username" placeholder="Користувач">		
		</div>
		<div>
			<input type="password" name = "j_password" placeholder="Пароль">		
		</div>
		<div>
			<input type="submit" value="Ввійти">		
		</div>
		
		<c:if test="${param.error ne null}">
			<div>Не вірні логін або пароль</div>
		</c:if>
		
		<c:if test="${param.error ne null}">
			<div>Ви маєте вийти з облікового запису</div>
		</c:if>
		
	</div>
	
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

</form>

</body>
</html>