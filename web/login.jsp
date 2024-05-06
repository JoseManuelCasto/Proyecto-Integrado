<%-- 
    Document   : login
    Created on : 29 abr 2024, 13:10:49
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
        <h1>Login</h1>
        <form action="Login" method="post">
            <label for="correo">Correo Electrónico:</label>
            <input type="email" id="correo" name="correo" required><br><br>

            <label for="contrasena">Contraseña:</label>
            <input type="password" id="contrasena" name="contrasena" required><br><br>

            <input type="submit" value="Iniciar Sesion" name="iniciarSesion">
        </form>
        <a href="Registro">No tienes cuenta?</a>
    </body>
</html>
