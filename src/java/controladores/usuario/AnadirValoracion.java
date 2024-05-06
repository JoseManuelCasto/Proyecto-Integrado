/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladores.usuario;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.entidades.Prenda;
import modelo.entidades.Usuario;

/**
 *
 * @author casto
 */
@WebServlet(name = "AnadirValoracion", urlPatterns = {"/usuario/AnadirValoracion"})
public class AnadirValoracion extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        Long idPrenda = Long.parseLong(request.getParameter("idPrenda"));

        String vista = "/FashionXpress/DetallesPrenda?idPrenda=" +idPrenda;

        if (request.getParameter("anadir") != null) {
            request.setAttribute("idPrenda", idPrenda);
            Prenda p = modelo.ModeloPrenda.obtenerPrenda(idPrenda);
            Long idUsuario = Long.parseLong(request.getParameter("idUsuario"));
            Usuario u = modelo.ModeloUsuario.obtenerUsuario(idUsuario);
            int clasificacion = Integer.parseInt(request.getParameter("clasificacion"));
            if (request.getParameter("comentario") != null) {
                String comentario = request.getParameter("comentario");
                modelo.ModeloValoracion.anadirValoracion(u, p, comentario, clasificacion);
            } else {
                modelo.ModeloValoracion.anadirValoracion(u, p, clasificacion);
            }
        }
        response.sendRedirect(vista);
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
