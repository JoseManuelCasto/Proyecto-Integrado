/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.dao.ProveedorJpaController;
import modelo.dao.ValoracionJpaController;
import modelo.entidades.Prenda;
import modelo.entidades.Proveedor;
import modelo.entidades.Usuario;
import modelo.entidades.Valoracion;

/**
 *
 * @author casto
 */
public class ModeloValoracion {

    public static List<Valoracion> obtenerValoraciones() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FashionXpressPU");
        ValoracionJpaController vjc = new ValoracionJpaController(emf);
        List<Valoracion> valoraciones = vjc.findValoracionEntities();
        emf.close();
        return valoraciones;

    }

    public static void eliminarValoracion(Long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FashionXpressPU");
        ValoracionJpaController vjc = new ValoracionJpaController(emf);
        try {
            vjc.destroy(id);
            emf.close();
        } catch (Exception e) {
            System.out.println("Error en ModeloValoracion.java-----" + e.getMessage());
        }

    }

    public static void editarValoracion(String comentario, int clasificacion, Valoracion v) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FashionXpressPU");
        ValoracionJpaController vjc = new ValoracionJpaController(emf);

        v.setComentario(comentario);
        v.setClasificacion(clasificacion);

        try {
            vjc.edit(v);
            emf.close();
        } catch (Exception e) {
            System.out.println("Error en ModeloValoracion.java ---------" + e.getMessage());
        }

    }

    public static void anadirValoracion(Usuario u, Prenda p, String comentario, int clasificacion) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FashionXpressPU");
        ValoracionJpaController vjc = new ValoracionJpaController(emf);
        Valoracion v = new Valoracion();
        v.setUsuario(u);
        v.setPrenda(p);
        v.setComentario(comentario);
        v.setClasificacion(clasificacion);

        try {
            vjc.create(v);
            emf.close();
        } catch (Exception e) {
            System.out.println("Error en ModeloValoracion.java ---------" + e.getMessage());
        }

    }

    public static Valoracion obtenerValoracion(Long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FashionXpressPU");
        ValoracionJpaController vjc = new ValoracionJpaController(emf);
        Valoracion v = vjc.findValoracion(id);
        emf.close();
        return v;

    }
}
