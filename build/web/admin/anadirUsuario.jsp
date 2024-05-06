<%-- 
    Document   : anadirUsuario
    Created on : 6 may 2024, 12:54:12
    Author     : casto
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Editar Perfil</h2>
        <form action="AnadirUsuario" method="POST">

            <label for="nombre">Nombre:</label>
            <input type="text" id="nombre" name="nombre" required><br><br>

            <label for="apellido">Apellido:</label>
            <input type="text" id="apellido" name="apellido" required><br><br>

            <label for="email">Correo Electrónico:</label>
            <input type="email" id="email" name="email" required><br><br>

            <label for="contrasena">Contraseña:</label>
            <input type="password" id="contrasena" name="contrasena" required><br><br>

            <label for="rol">Rol:</label>
            <select id="rol" name="rol" required>
                <option value="ADMIN">Administrador</option>
                <option value="USUARIO">Usuario</option>
            </select><br><br>

            <input type="submit" value="anadir" name="anadir">
        </form>
    </body>
</html>
