/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladores.usuario;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.entidades.Pedido;

/**
 *
 * @author casto
 */
@WebServlet(name = "RealizarPedido", urlPatterns = {"/usuario/RealizarPedido"})
public class RealizarPedido extends HttpServlet {

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
        if (request.getParameter("pedir") != null) {
            String direccion = request.getParameter("direccionEntrega");
            Long idUsuario = Long.parseLong(request.getParameter("idUsuario"));
            Pedido p = modelo.ModeloPedido.obtenerCarritoUsuario(idUsuario);
            Date fechaActual = new Date();

            // Crear una instancia de Calendar
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(fechaActual);

            // Sumar 3 días a la fecha actual
            calendar.add(Calendar.DAY_OF_MONTH, 3);

            // Obtener la nueva fecha después de 3 días
            Date fechaEnTresDias = calendar.getTime();
            
            modelo.ModeloPedido.editarPedido(fechaEnTresDias,direccion  ,p);
        }
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
