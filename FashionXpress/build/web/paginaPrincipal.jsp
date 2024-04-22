<%-- 
    Document   : paginaPrincipal
    Created on : 20 abr 2024, 21:05:42
    Author     : casto
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>JSP Page</title>
    </head>
    <body>
       <h1>Listado de Prendas</h1>
    
    <!-- Comienza el bucle para recorrer la lista de prendas -->
    <c:forEach items="${prendas}" var="prenda">
        <div>
            <h2>${prenda.nombre}</h2>
            <p>ID: ${prenda.id}</p>
            <p>Proveedor: ${prenda.proveedor.nombre}</p>
            <p>Descripción: ${prenda.descripcion}</p>
            <p>Precio: ${prenda.precio}</p>
            <p>Imagen: <img src="${prenda.imagenPrenda}" alt="Imagen de la prenda"/></p>
            
            <!-- Agrega aquí cualquier otra información de la prenda que desees mostrar -->
        </div>
    </c:forEach>
</body>
</html>
