<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="../templates/navbar.jsp" %>

<!DOCTYPE html>
<html lang="en">
 
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Productos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
 
<body>
<h1>Productos</h1>
  <table class="table">
			<thead >
				<tr>
					<th>Nombre Producto</th>
					<th>Descripción Producto</th>
					<th>Precio Producto</th>
					<th>opciones</th>
				</tr>
			</thead>
			<c:forEach items="${listaCarrito}" var="lista">
				<tr>
					<td>${lista.getNombreProducto()}</td>
					<td>${lista.getDescripcionProducto()}</td>
					<td>${lista.getPrecioProducto()}</td>
					<td>
						<form action="/producto/eliminar" method="POST">
							<input type="Hidden" name="id" value="${lista.getId()}">
							<input type="submit" value="Eliminar">
						</form>
						<form action="/producto/editar" method="POST">
							<input type="Hidden" name="id" value="${lista.getId()}">
							<input type="submit" value="Editar">
						</form>
						<%-- <form action="/carrito/agregar" method="POST">
							<input type="Hidden" name="id" value="${lista.getId()}">
							<input type="submit" value="+carrito">
						</form> --%>
						
					</td>
				</tr>
			</c:forEach>
		</table> 
</body>
</html>