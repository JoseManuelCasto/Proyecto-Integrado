/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladores.usuario;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.entidades.Pedido;
import modelo.entidades.Prenda;
import modelo.entidades.Usuario;

/**
 *
 * @author casto
 */
@WebServlet(name = "AnadirAlCarrito", urlPatterns = {"/usuario/AnadirAlCarrito"})
public class AnadirAlCarrito extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String vista = "/PaginaPrincipal";
        Long idPrenda = Long.parseLong(request.getParameter("prendaId"));
        Long idUsuario = Long.parseLong(request.getParameter("usuarioId"));
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        String talla = request.getParameter("talla");
        List<Prenda> prendas = new ArrayList();
        Prenda p = modelo.ModeloPrenda.obtenerPrenda(idPrenda);
        Usuario u = modelo.ModeloUsuario.obtenerUsuario(idUsuario);

//CORREGIR IMPORTANTE
        Date fecha = new Date();

        //Si el usuario ya tiene un carrito existente
        if (modelo.ModeloPedido.existePedidoNoRealizado(idUsuario)) {
            Pedido carritousu = modelo.ModeloPedido.obtenerCarritoUsuario(idUsuario);
            List<Prenda> listaPrendasCarrito = carritousu.getPrendas();
            for (int i = 0; i < cantidad; i++) {
                listaPrendasCarrito.add(p);
            }
            System.out.println("ha entrado if______________________________________");
            modelo.ModeloPedido.editarPedido(listaPrendasCarrito, carritousu);
            //Si el usuario NO tiene un carrito existente
        } else {
            for (int i = 0; i < cantidad; i++) {
                prendas.add(p);
            }
            System.out.println("ha entrado else______________________________________");

            modelo.ModeloPedido.anadirPedido(fecha, u, "no definida", prendas);

        }
        request.setAttribute(vista, this);
        response.sendRedirect("/FashionXpress" + vista);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
