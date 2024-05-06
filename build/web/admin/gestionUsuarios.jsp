<%-- 
    Document   : gestionUsuarios
    Created on : 6 may 2024, 12:22:19
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
        
        <h1>Gestionar Prendas</h1>
            <a href="AnadirUsuario">Añadir Usuario</a>

        <table border="1">
            <thead>
                <tr>
                    <th>Nombre</th>
                    <th>opciones</th>

                </tr>
            </thead>
            <tbody>
            
            <c:forEach items="${usuarios}" var="usuario" >
                <form action="EditarUsuario">
                    <tr>
                        <td>${usuario.nombre}</td>
                        <td> 
                            <input type="submit" name="editar" value="Editar">
                            <input type="submit"  name="eliminar" value="Eliminar"> 
                            <input type="hidden" name="idUsuario" value="${usuario.id}"></td>
                    </tr>
                </form>
            </c:forEach>
        </tbody>

    </table>


<c:if test="${not empty mensaje && empty error}">
    <div style="color: green;"> <h2> ${mensaje}</h2></div>
</c:if>
<c:if test="${not empty error}">
    <div style="color: red;"> <h2> ${error}</h2></div>
</c:if>
</body>
</body>
</html>
