/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladores.admin;

import static controladores.admin.AnadirPrenda.TAM_BUFFER;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import modelo.entidades.Prenda;
import modelo.entidades.Proveedor;

/**
 *
 * @author casto
 */
@WebServlet(name = "EditarPrenda", urlPatterns = {"/admin/EditarPrenda"})
@MultipartConfig

public class EditarPrenda extends HttpServlet {

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
        String vista = "/admin/editarPrenda.jsp";
        if (request.getParameter("editar") != null) {
            Long idPrenda = Long.parseLong(request.getParameter("idPrenda"));

            Prenda p = modelo.ModeloPrenda.obtenerPrenda(idPrenda);
            List<Proveedor> proveedores = modelo.ModeloProveedor.obtenerProveedores();
            request.setAttribute("prenda", p);
            request.setAttribute("proveedores", proveedores);

            getServletContext().getRequestDispatcher(vista).forward(request, response);
            return;
        }
        if (request.getParameter("actualizar") != null) {
            vista = "/admin/GestionPrendas";
            System.out.println("he entrado_____________________________________________________________");
            //`REGUNTAR SI EN PRENDA SE PUEDE EDITAR PROVEEDOR
            String nombre = request.getParameter("nombre");
            Double precio = Double.parseDouble(request.getParameter("precio"));
            String descripcion = request.getParameter("descripcion");
            int stock = Integer.parseInt(request.getParameter("stock"));
            Long idPrenda = Long.parseLong(request.getParameter("idPrenda"));
            Prenda p = modelo.ModeloPrenda.obtenerPrenda(idPrenda);

            //Empieza parte de subida de imagen
            Part parte = request.getPart("fichero");
            String nombreFichero = parte.getSubmittedFileName();
            InputStream entrada = parte.getInputStream();
            String ruta = getServletContext().getRealPath("/img/") + nombreFichero;
            FileOutputStream salida = new FileOutputStream(ruta);
            byte[] buffer = new byte[TAM_BUFFER];
            while (entrada.available() > 0) {
                int tam = entrada.read(buffer);
                salida.write(buffer, 0, tam);
            }
            salida.close();
            entrada.close();
            //Termina parte de subida de imagen

            String[] tallas = request.getParameterValues("tallas[]");

            modelo.ModeloPrenda.editarPrenda(nombre, tallas, descripcion, precio, "/FashionXpress/img/" + nombreFichero, stock, p);
            getServletContext().getRequestDispatcher(vista).forward(request, response);
            return;

        }
        if (request.getParameter("eliminar") != null) {
            vista = "/FashionXpress/admin/GestionPrendas";
            Long idPrenda = Long.parseLong(request.getParameter("idPrenda"));
            modelo.ModeloPrenda.eliminarPrenda(idPrenda);
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
