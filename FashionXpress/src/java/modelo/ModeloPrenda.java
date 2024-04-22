/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.dao.PedidoJpaController;
import modelo.dao.PrendaJpaController;
import modelo.entidades.Pedido;
import modelo.entidades.Prenda;
import modelo.entidades.Proveedor;
import modelo.entidades.Usuario;

/**
 *
 * @author casto
 */
public class ModeloPrenda {

    public static List<Prenda> obtenerPrendas() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FashionXpressPU");
        PrendaJpaController pjc = new PrendaJpaController(emf);
        List<Prenda> prendas = pjc.findPrendaEntities();
        emf.close();
        return prendas;

    }

    public static void eliminarPrenda(Long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FashionXpressPU");
        PrendaJpaController pjc = new PrendaJpaController(emf);
        try {
            pjc.destroy(id);
            emf.close();
        } catch (Exception e) {
            System.out.println("Error en ModeloPrenda.java-----" + e.getMessage());
        }

    }

//Se podra editar proveedor?
    public static void editarPrenda(String nombre, Proveedor proveedor, List<String> tallas_disp, String descripcion, double precio, String imagenPrenda, Prenda p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FashionXpressPU");
        PrendaJpaController pjc = new PrendaJpaController(emf);

        p.setNombre(nombre);
        p.setProveedor(proveedor);
        p.setTallas_disp(tallas_disp);
        p.setDescripcion(descripcion);
        p.setPrecio(precio);
        p.setImagenPrenda(imagenPrenda);

        try {
            pjc.edit(p);
            emf.close();
        } catch (Exception e) {
            System.out.println("Error en ModeloPrenda.java ---------" + e.getMessage());
        }

    }

    public static void anadirPrenda(String nombre, Proveedor proveedor, String[] tallas_disp, String descripcion, double precio, String imagenPrenda) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FashionXpressPU");
        PrendaJpaController pjc = new PrendaJpaController(emf);
        List<String> tallas = new ArrayList();
        Prenda p = new Prenda();

        p.setNombre(nombre);
        p.setProveedor(proveedor);

        for (String talla : tallas_disp) {
            tallas.add(talla);
        }

        p.setTallas_disp(tallas);
        p.setDescripcion(descripcion);
        p.setPrecio(precio);
        p.setImagenPrenda(imagenPrenda);

        try {
            pjc.create(p);
            emf.close();
        } catch (Exception e) {
            System.out.println("Error en ModeloPrenda.java ---------" + e.getMessage());
        }

    }

    public static Prenda obtenerPrenda(Long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FashionXpressPU");
        PrendaJpaController pjc = new PrendaJpaController(emf);
        Prenda p = pjc.findPrenda(id);
        emf.close();
        return p;

    }
}
