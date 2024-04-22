/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet_creacion;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.dao.PrendaJpaController;
import modelo.dao.ProveedorJpaController;
import modelo.entidades.Prenda;
import modelo.entidades.Proveedor;

/**
 *
 * @author casto
 */
@WebServlet(name = "creacion", urlPatterns = {"/creacion"})
public class creacion extends HttpServlet {

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
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FashionXpressPU");

        ProveedorJpaController proveedorjc = new ProveedorJpaController(emf);
        Proveedor proveedor1 = new Proveedor();
        proveedor1.setContacto("654730831");
        proveedor1.setId(Long.valueOf("1"));
        proveedor1.setNombre("Nike");

        PrendaJpaController prendajc = new PrendaJpaController(emf);
        Prenda prenda1 = new Prenda();
        prenda1.setNombre("airforce 1");
        prenda1.setImagenPrenda("https://encrypted-tbn1.gstatic.com/shopping?q=tbn:ANd9GcRL-3ArQJZ7fi1uayLZMyDSbgnXlKXJXsugxmLDDaufzH_W5YqW5pq8CLalJVAMKu3G1obay1hel4j-434sQg1Ae1TZZcTSy1O-_R-ULkk2UqyblYlZDAlvFw");
        prenda1.setDescripcion("zapatillas blancas");
        prenda1.setProveedor(proveedor1);
        prenda1.setPrecio(100.99);
        List<String> tallas_disp = new ArrayList();
        tallas_disp.add("XL");
        tallas_disp.add("S");
        prenda1.setTallas_disp(tallas_disp);

        try {

            proveedorjc.create(proveedor1);
            prendajc.create(prenda1);

        } catch (Exception ex) {
            System.out.println("___________________________error__________________--" + ex.getMessage());
        }
        emf.close();

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
