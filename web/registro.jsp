<%-- 
    Document   : registro
    Created on : 29 abr 2024, 13:12:34
    Author     : casto
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Crear Usuario</title>
    </head>
    <body>
        <h1>Crear Nuevo Usuario</h1>
        <form action="Registro" method="post">
            <label for="correo">Correo Electrónico:</label>
            <input type="email" id="correo" name="correo" required><br><br>

            <label for="nombre">Nombre:</label>
            <input type="text" id="nombre" name="nombre" required><br><br>

            <label for="apellido">Apellido:</label>
            <input type="text" id="apellido" name="apellido" required><br><br>

            <label for="contrasena">Contraseña:</label>
            <input type="password" id="contrasena" name="contrasena" required><br><br>

            <input type="submit" value="Crear Usuario" name="crear">
        </form>
        <a href="Login">Ya tienes cuenta?</a>
    </body>
</html>