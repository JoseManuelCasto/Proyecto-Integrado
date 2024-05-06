<%-- 
    Document   : carrito
    Created on : 4 may 2024, 21:38:44
    Author     : casto
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<c:set var="precioTotal" value="0" />
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <title>Detalles del Pedido</title>
    </head>
    <body>
        <c:if test="${not empty carrito}">
            <div>
                <p><strong>ID del Pedido:</strong> ${carrito.id}</p>
                <p><strong>Fecha del Pedido:</strong> ${carrito.fecha_pedido}</p>
                <p><strong>Dirección de Entrega:</strong> ${carrito.direccion_entrega}</p>
                <p><strong>ID del Usuario:</strong> ${carrito.usuario.id}</p>

                <h3>Prendas del carrito</h3>
                <ul>
                    <c:forEach var="prenda" items="${carrito.prendas}">
                        <c:set var="totalPrecio" value="${totalPrecio + prenda.precio}" />

                        <li>${prenda.nombre} - Tallas disponibles: 
                            <ul>
                                <c:forEach var="tallas" items="${prenda.tallas_disp}">
                                    <li>${tallas}</li>
                                    </c:forEach>
                            </ul>
                        </li>
                        <li>
                            <form action="EliminarPrendaCarrito" method="post">
                                <input type="text" name="idPrenda" value="${prenda.id}">
                                <input type="text" name="idUsuario" value="${carrito.usuario.id}">

                                <input type="submit" name="eliminar" value="eliminar INSERTA ICONITO BASURA">
                            </form>
                        </li>

                    </c:forEach>
                </ul>
            </div>
            <p>Total a pagar: ${totalPrecio}</p>

        </c:if>
        <c:if test="${empty carrito}">
            INSERTA ICONITO DE LA LUPA /carrito vacio

            Actualmente tu carrito esta vacio, EMPIEZA A LLENARLL

            <a href="/FashionXpress/PaginaPrincipal">Aqui</a>
        </c:if>
        <form action="RealizarPedido" method="POST">
            <label for="direccionEntrega">Dirección de Entrega:</label>
            <input type="text" id="direccionEntrega" name="direccionEntrega" required><br><br>

            <label for="numTarjeta">Número de Tarjeta:</label>
            <input type="text" id="numTarjeta" name="numTarjeta" pattern="[0-9]{16}" maxlength="16" required><br><br>

            <label for="fechaVencimiento">Fecha de Vencimiento (MM/YY):</label>
            <input type="text" id="fechaVencimiento" name="fechaVencimiento" pattern="(0[1-9]|1[0-2])\/[0-9]{2}" required><br><br>

            <label for="cvv">CVV:</label>
            <input type="text" id="cvv" name="cvv" pattern="[0-9]{3,4}" maxlength="4" required><br><br>
            <input type="hidden" name="idUsuario" value="${usuario.id}">
            <input type="submit" name="pedir" value="Realizar Pedido">
        </form>
        <h2>Historial de pedidos</h2>
        <c:if test="${not empty historial}">
            <c:forEach var="pedido" items="${historial}">
                <div>
                    <p><strong>ID del Pedido:</strong> ${pedido.id}</p>
                    <p><strong>Fecha del Pedido:</strong> ${pedido.fecha_pedido}</p>
                    <p><strong>Dirección de Entrega:</strong> ${pedido.direccion_entrega}</p>
                    <p><strong>ID del Usuario:</strong> ${pedido.usuario.id}</p>

                    <h3>Prendas del carrito</h3>
                    <ul>
                        <c:forEach var="prenda" items="${pedido.prendas}">
                            <li>${prenda.nombre} - Tallas disponibles: 
                                <ul>
                                    <c:forEach var="tallas" items="${prenda.tallas_disp}">
                                        <li>${tallas}</li>
                                        </c:forEach>
                                </ul>
                            </li>
                            <li>Imagen: <img src="${prenda.imagenPrenda}" alt="Imagen de la prenda" style="width: 50%"/></li>
                            </c:forEach>
                    </ul>
                </div>
            </c:forEach>

        </c:if>
        <c:if test="${empty historial}">
            INSERTA ICONITO DE LA LUPA /historial vacio

            Actualmente tu historial esta vacio, EMPIEZA A LLENARLL

            <a href="/FashionXpress/PaginaPrincipal">Aqui</a>
        </c:if>
    </body>
</html>