<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="../templates/navbar.jsp"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Editor de Productos</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>

<body>
	<div class="container-">

	<form:form class="form-group" method="POST" action="/producto/actualizar" modelAttribute="producto">
			<input type="hidden" name="_method" value="put">
			<form:input type="hidden" path="id"/> 
			
			<form:label path="nombreProducto">Nombre Producto: </form:label>
			<form:input type="text" path="nombreProducto" />
			<br>
			<form:label path="descripcionProducto">Descripcion Producto: </form:label>
			<form:input type="text" path="descripcionProducto" />
			<br>
			<br>
			<form:label path="precioProducto">Precio Producto: </form:label>
			<form:input type="text" path="precioProducto" />
			<br>
			<br>

			<input type="submit" value="Editar">

		</form:form>
	</div>
</body>
</html>