/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladores.admin;

import clases.Rol;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.entidades.Usuario;

/**
 *
 * @author casto
 */
@WebServlet(name = "EditarUsuario", urlPatterns = {"/admin/EditarUsuario"})
public class EditarUsuario extends HttpServlet {

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
        String vista = "/admin/editarUsuario.jsp";
        if (request.getParameter("editar") != null) {
            Long idUsuario = Long.parseLong(request.getParameter("idUsuario"));
            Usuario u = modelo.ModeloUsuario.obtenerUsuario(idUsuario);
            request.setAttribute("usuario", u);
            getServletContext().getRequestDispatcher(vista).forward(request, response);
            return;
        }
        if (request.getParameter("actualizar") != null) {
            vista = "/admin/GestionUsuarios";
            Long idUsuario = Long.parseLong(request.getParameter("idUsuario"));
            Usuario u = modelo.ModeloUsuario.obtenerUsuario(idUsuario);
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String email = request.getParameter("email");
            String contrasena = request.getParameter("contrasena");
            String rolString = request.getParameter("rol");
            Rol rol = Rol.valueOf(rolString);

            modelo.ModeloUsuario.editarUsuario(nombre, apellido, email, contrasena, rol, u);
            getServletContext().getRequestDispatcher(vista).forward(request, response);
            return;

        }
        if (request.getParameter("eliminar") != null) {
            vista = "/FashionXpress/admin/GestionUsuarios";
            Long idUsuario = Long.parseLong(request.getParameter("idUsuario"));
            modelo.ModeloUsuario.eliminarUsuario(idUsuario);
            response.sendRedirect(vista);
            return;
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
