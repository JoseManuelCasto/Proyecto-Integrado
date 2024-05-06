/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladores.admin;

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
import modelo.entidades.Proveedor;

/**
 *
 * @author casto
 */
@WebServlet(name = "anadirPrenda", urlPatterns = {"/admin/AnadirPrenda"})
@MultipartConfig
public class AnadirPrenda extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public static final int TAM_BUFFER = 4 * 1024;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String vista = "/admin/anadirPrenda.jsp";
        List<Proveedor> proveedores = modelo.ModeloProveedor.obtenerProveedores();
        request.setAttribute("proveedores", proveedores);
        if (request.getParameter("anadir") != null) {
            vista = "/PaginaPrincipal";
            String nombre = request.getParameter("nombre");
            String descripcion = request.getParameter("descripcion");
            double precio = Double.parseDouble(request.getParameter("precio"));
            
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
            
            //String imagen = request.getParameter("imagen");

            Long proveedorId = Long.parseLong(request.getParameter("proveedor"));

            Proveedor proveedor = modelo.ModeloProveedor.obtenerProveedor(proveedorId);

            String[] tallas = request.getParameterValues("tallas[]");

            int stock = Integer.parseInt(request.getParameter("stock"));
            String marca = request.getParameter("marca");
            modelo.ModeloPrenda.anadirPrenda(nombre, proveedor, tallas, descripcion, precio, "/FashionXpress/img/" + nombreFichero, stock, marca);
        response.sendRedirect("/FashionXpress"+vista);
        return;
        }
        getServletContext().getRequestDispatcher(vista).forward(request, response);

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
