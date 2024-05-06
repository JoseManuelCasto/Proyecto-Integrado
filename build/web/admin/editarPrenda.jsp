<%-- 
    Document   : editarPrenda
    Created on : 6 may 2024, 9:51:35
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


        <h2>Editar Prenda</h2>

        <form action="EditarPrenda" method="POST" enctype="multipart/form-data">
            <input type="hidden" name="idPrenda" value="${prenda.id}" />

            <label for="nombre">Nombre:</label>
            <input type="text" id="nombre" name="nombre" value="${prenda.nombre}" required><br><br>

            <label for="precio">Precio:</label>
            <input type="number" id="precio" name="precio" value="${prenda.precio}" required><br><br>

            <label for="descripcion">Descripción:</label><br>
            <textarea id="descripcion" name="descripcion" rows="4" cols="50">${prenda.descripcion}</textarea><br><br>

            <label for="imagen">Imagen:</label>
            <input type="file" id="fichero" name="fichero" required><br><br>
            
            <label for="tallas">Tallas disponibles:</label><br>
            
            <select id="tallas" name="tallas[]" multiple>
                <option value="XS"<c:if test="${prenda.tallas_disp.contains('XS')}">selected</c:if>>XS</option>
                <option value="S"<c:if test="${prenda.tallas_disp.contains('S')}">selected</c:if>>S</option>
                <option value="M"<c:if test="${prenda.tallas_disp.contains('M')}">selected</c:if>>M</option>
                <option value="L"<c:if test="${prenda.tallas_disp.contains('L')}">selected</c:if>>L</option>
                <option value="XL"<c:if test="${prenda.tallas_disp.contains('XL')}">selected</c:if>>XL</option>
                </select><br><br>

                <label for="stock">Stock:</label>
                <input type="number" id="stock" name="stock" value="${prenda.stock}" required><br><br>

                <input type="submit" value="actualizar" name="actualizar">
        </form>
    </body>
</html>
