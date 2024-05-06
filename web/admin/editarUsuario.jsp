<%-- 
    Document   : editarUsuario
    Created on : 6 may 2024, 12:34:04
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
        <body>
    <h2>Editar Perfil</h2>
    <form action="EditarUsuario" method="POST">
        <input type="hidden" name="idUsuario" value="${usuario.id}">
        
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" value="${usuario.nombre}" required><br><br>
        
        <label for="apellido">Apellido:</label>
        <input type="text" id="apellido" name="apellido" value="${usuario.apellido}" required><br><br>
        
        <label for="email">Correo Electrónico:</label>
        <input type="email" id="email" name="email" value="${usuario.correo_electronico}" required><br><br>
        
        <label for="contrasena">Contraseña:</label>
        <input type="password" id="contrasena" name="contrasena" value="${usuario.contrasena}" required><br><br>
        
        <label for="rol">Rol:</label>
        <select id="rol" name="rol" required>
            <option value="ADMIN" <c:if test="${usuario.rol eq 'ADMIN'}">selected</c:if>>Administrador</option>
            <option value="USUARIO" <c:if test="${usuario.rol eq 'USUARIO'}">selected</c:if>>Usuario</option>
        </select><br><br>
        
        <input type="submit" value="Actualizar" name="actualizar">
    </form>
</body>
    </body>
</html>
