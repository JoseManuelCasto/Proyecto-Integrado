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
        <style>
            img{
                width: 25%
            }
        </style>

    </head>
    <body>
        <h1>Listado de Prendas</h1>

        <c:if test="${empty usuario}">
            <a href="Login">Iniciar Sesion</a>
            <a href="Registro">Registrarse</a>
        </c:if>
        <c:if test="${usuario.rol eq 'ADMIN'}">
            <a href="admin/Menu">Gestionar(Mete iconito de llave inglesa)</a>
            <a href="CerrarSesion">Cerrar sesion (METER ICOINTO DE SALIR POR LA PUERTA)</a>

            <br>           
            <br>
        </c:if>
        <c:if test="${usuario.rol eq 'USUARIO' || usuario.rol eq 'ADMIN'}">
            <form action="usuario/Carrito" method="post">
                <input type="text" name="idUsuario" value="${usuario.id}">
                <input type="submit" value="ver carrito INSERTA ICONO CARRITO">
            </form>
            <a href="CerrarSesion">Cerrar sesion (METER ICOINTO DE SALIR POR LA PUERTA)</a>

        </c:if>
        <br>
        <c:if test="${ not empty usuario}">Nombre : ${usuario.nombre}</c:if>


        <c:forEach items="${prendas}" var="prenda">
            <div>
                <a href="DetallesPrenda?idPrenda=${prenda.id}">
                    <h2>${prenda.nombre}</h2>

                    <p>Proveedor: ${prenda.proveedor.nombre}</p>
                    <p>Descripción: ${prenda.descripcion}</p>
                    <p>Precio: ${prenda.precio} ? (temp)</p>
                    <p>Imagen: <img src="${prenda.imagenPrenda}" alt="Imagen de la prenda"/></p>
                </a>
            </div>
        </c:forEach>
    </body>
</html>
