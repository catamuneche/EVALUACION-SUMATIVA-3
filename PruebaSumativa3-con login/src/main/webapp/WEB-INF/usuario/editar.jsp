<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%-- <jsp:include page='template/nav.jsp'/> --%>
<%@ include file="../templates/navbar.jsp" %>
<!DOCTYPE html>
<html lang="en">
 
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>

	<h1>REGISTRO DE USUARIO</h1>
	
	<div class="container-">
		 <form:form method="post" action="/usuario/actualizar" modelAttribute="usuario">
			<form:input type="hidden" path="id"/>
	        <input type="hidden" name="_method" value="put"/>
		 
			<form:label path="nombre">Nombre: </form:label>
			<form:input type="text" path="nombre"/> 
			<br><br>
			<form:label path="apellido">Apellido: </form:label>
			<form:input type="text" path="apellido"/> 
			<br><br>
			<form:label path="email">Email: </form:label>
			<form:input type="email" path="email"/> 
			<br><br>
			<form:label path="password">Password: </form:label>
			<form:input type="password" path="password"/> 
			<br><br>
			<form:label path="passwordConfirmation">Repita su contraseña: </form:label>
			<form:input type="password" path="passwordConfirmation"/> 
			<br><br>
			
			<input style="background-color: orange; color:white" type="button" value="Limpiar">
			<input style="background-color: green; color:white" type="submit" value="Editar">
			
		</form:form>
		
	</div>
</body>
</html>