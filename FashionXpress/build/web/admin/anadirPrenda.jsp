<%-- 
    Document   : anadirPrenda
    Created on : 22 abr 2024, 14:37:28
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
        <h1>Crear Nueva Prenda</h1>
        <form action="AnadirPrenda" method="post">
            <label for="nombre">Nombre:</label>
            <input type="text" id="nombre" name="nombre" required><br><br>

            <label for="descripcion">Descripción:</label><br>
            <textarea id="descripcion" name="descripcion" required></textarea><br><br>

            <label for="precio">Precio:</label>
            <input type="number" id="precio" name="precio" min="0" step="0.01" required><br><br>

            <label for="imagen">Imagen (URL):</label>
            <input type="text" id="imagen" name="imagen" required><br><br>

            <label for="tallas">Tallas disponibles:</label><br>
            <select id="tallas" name="tallas[]" multiple>
                <option value="XS">XS</option>
                <option value="S">S</option>
                <option value="M">M</option>
                <option value="L">L</option>
                <option value="XL">XL</option>
            </select><br><br>

            <label for="proveedor">Proveedor:</label><br>
            <select id="proveedor" name="proveedor" required>
                <c:forEach items="${proveedores}" var="proveedor">
                    <option value="${proveedor.id}">${proveedor.nombre}</option>
                </c:forEach>
            </select><br><br>
            
            <input type="submit" value="Guardar Prenda" name="anadir">
        </form>
    </body>
</html>
