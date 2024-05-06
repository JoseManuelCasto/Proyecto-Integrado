/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.dao.PrendaJpaController;
import modelo.dao.ProveedorJpaController;
import modelo.entidades.Prenda;
import modelo.entidades.Proveedor;

/**
 *
 * @author casto
 */
public class ModeloProveedor {

    public static List<Proveedor> obtenerProveedores() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FashionXpressPU");
        ProveedorJpaController pjc = new ProveedorJpaController(emf);
        List<Proveedor> proveedores = pjc.findProveedorEntities();
        emf.close();
        return proveedores;

    }

    public static void eliminarProveedor(Long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FashionXpressPU");
        ProveedorJpaController pjc = new ProveedorJpaController(emf);
        try {
            pjc.destroy(id);
            emf.close();
        } catch (Exception e) {
            System.out.println("Error en ModeloProveedor.java-----" + e.getMessage());
        }

    }

//Se podra editar proveedor?
    public static void editarProveedor(String nombre, String contacto, Proveedor p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FashionXpressPU");
        ProveedorJpaController pjc = new ProveedorJpaController(emf);

        p.setNombre(nombre);
        p.setContacto(contacto);

        try {
            pjc.edit(p);
            emf.close();
        } catch (Exception e) {
            System.out.println("Error en ModeloProveedor.java ---------" + e.getMessage());
        }

    }

    public static void anadirProveedor(String nombre, String contacto) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FashionXpressPU");
        ProveedorJpaController pjc = new ProveedorJpaController(emf);
        Proveedor p = new Proveedor();

        p.setNombre(nombre);
        p.setContacto(contacto);

        try {
            pjc.create(p);
            emf.close();
        } catch (Exception e) {
            System.out.println("Error en ModeloProveedor.java ---------" + e.getMessage());
        }

    }

    public static Proveedor obtenerProveedor(Long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FashionXpressPU");
        ProveedorJpaController pjc = new ProveedorJpaController(emf);
        Proveedor p = pjc.findProveedor(id);
        emf.close();
        return p;

    }
}
