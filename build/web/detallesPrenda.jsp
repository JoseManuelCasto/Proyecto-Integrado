<%-- 
    Document   : detallesPrenda
    Created on : 29 abr 2024, 14:21:46
    Author     : casto
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>JSP Page</title>
        <style>
            img{
                width: 50%
            }
        </style>
    </head>
    <body>
        <c:if test="${not empty prenda}">hola</c:if>
        <c:if test="${ empty prenda}">adios</c:if>
            <!DOCTYPE html>
        <html>
            <head>
                <title>Detalles de la Prenda</title>
            </head>
            <body>
                <h1>Detalles de la Prenda</h1>
                <div>
                    <img src="${prenda.imagenPrenda}" alt="${prenda.nombre}" style="max-width: 200px; max-height: 200px;">
                <h2>${prenda.nombre}</h2>
                <p>Descripción: ${prenda.descripcion}</p>
                <p>Tallas Disponibles:</p>
                <form action="usuario/AnadirAlCarrito" method="post">

                    <ul>
                        <c:forEach items="${prenda.tallas_disp}" var="talla">
                            <li>
                                <input type="radio" name="talla" value="${talla}" required>
                                ${talla}

                            </li>
                        </c:forEach>
                    </ul>
                    <p>Precio: ${prenda.precio}</p>
            </div>

            <form action="usuario/AnadirAlCarrito" method="post">
                <input type="hidden" name="prendaId" value="${prenda.id}">
                <label for="cantidad">Cantidad:</label>
                <input type="number" id="cantidad" name="cantidad" value="1" min="1" required>
                <c:if test="${not empty usuario}">
                    <input type="hidden" name="usuarioId" value="${usuario.id}">

                    <input type="submit" value="Añadir al Carrito">
                </c:if>
                <c:if test="${empty usuario}">

                    <a href="Login">Logerase para añadir al carrito</a>
                </c:if>
            </form>
            <h2>Valoraciones</h2>
            <c:if test="${not empty valoraciones}">
                <c:forEach items="${valoraciones}" var="valoracion">
                    <div>
                        <p><strong>ID de la Valoración:</strong> ${valoracion.id}</p>
                        <p><strong>Clasificación:</strong> ${valoracion.clasificacion}</p>
                        <c:forEach begin="1" end="${valoracion.clasificacion}">
                            ⭐
                        </c:forEach>
                        <p><strong>Comentario:</strong> ${valoracion.comentario}</p>
                        <p><strong>ID de la Prenda:</strong> ${valoracion.prenda.id}</p>
                        <p><strong>ID del Usuario:</strong> ${valoracion.usuario.id}</p>

                        <form action="usuario/EditarValoracion">

                            <c:if test="${usuario.id == valoracion.usuario.id}">
                                <input type="hidden" name="idPrenda" value="${prenda.id}">
                                <input type="hidden" name="idValoracion" value="${valoracion.id}">

                                <input type="submit" name="editar" value="editar(PON ICONITO LAPIZ)">
                                <input type="submit" name="eliminar" value="eliminar(PON ICONITO basura)">

                            </c:if>
                        </form>
                    </div>
                </c:forEach>
            </c:if>
            <c:if test="${empty valoraciones}">
                <p>Se el primero en dejar una valoracion sobre esta prenda AQUI</p>
            </c:if>
            <c:if test="${not empty usuario}">
                <form action="usuario/AnadirValoracion" method="get">
                    <input type="hidden" id="prendaId" name="idPrenda" value="${prenda.id}" required><br><br>

                    <input type="hidden" id="usuarioId" name="idUsuario" value="${usuario.id}" required><br><br>

                    <label for="clasificacion">Clasificación:</label>
                    <input type="number" id="clasificacion" name="clasificacion" min="1" max="5" required><br><br>

                    <label for="comentario">Comentario:</label><br>
                    <textarea id="comentario" name="comentario" rows="4" cols="50"></textarea><br><br>

                    <input type="submit" value="Enviar" name="anadir">
                </form>
            </c:if>
            <c:if test="${empty usuario}">

                <a href="Login">Logerase Dejar una valoracion</a>
            </c:if>
            <h2>Otros Arituclos que pueden interesarte</h2>
            <div style="display: flex; flex-direction: row">


                <c:forEach items="${prendasRecomendadas}" var="prendaRecomendada">
                    <div style="margin:50px">
                        <a href="DetallesPrenda?id=${prendaRecomendada.id}">
                            <h2>${prendaRecomendada.nombre}</h2>

                            <p>Proveedor: ${prendaRecomendada.proveedor.nombre}</p>
                            <p>Descripción: ${prendaRecomendada.descripcion}</p>
                            <p>Precio: ${prendaRecomendada.precio} ? (temp)</p>
                            <p>Imagen: <img src="${prendaRecomendada.imagenPrenda}" alt="Imagen de la prenda"/></p>
                        </a>
                    </div>
                </c:forEach>
            </div>
        </body>
    </html>
</body>
</html>
