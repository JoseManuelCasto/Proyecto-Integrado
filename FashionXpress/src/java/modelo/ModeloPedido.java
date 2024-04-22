/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import clases.Rol;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.dao.PedidoJpaController;
import modelo.dao.UsuarioJpaController;
import modelo.entidades.Pedido;
import modelo.entidades.Prenda;
import modelo.entidades.Usuario;

/**
 *
 * @author casto
 */
public class ModeloPedido {
    
     public static List<Pedido> obtenerPedidos() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FashionXpressPU");
        PedidoJpaController pjc = new PedidoJpaController(emf);
        List<Pedido> pedidos = pjc.findPedidoEntities();
        emf.close();
        return pedidos;

    }

    public static void eliminarPedido(Long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FashionXpressPU");
        PedidoJpaController pjc = new PedidoJpaController(emf);
        try {
            pjc.destroy(id);
            emf.close();
        } catch (Exception e) {
            System.out.println("Error en ModeloPedido.java-----" + e.getMessage());
        }

    }
//editar pedido no puede editar el usuario del pedido, preguntar a amieva
    public static void editarPedido(Date fecha_pedido, String direccion_entrega, List<Prenda> prendas,  Pedido p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FashionXpressPU");
        PedidoJpaController pjc = new PedidoJpaController(emf);

        p.setFecha_pedido(fecha_pedido);

        p.setDireccion_entrega(direccion_entrega);
      
        p.setPrendas(prendas);

        try {
            pjc.edit(p);
            emf.close();
        } catch (Exception e) {
            System.out.println("Error en ModeloPedido.java ---------" + e.getMessage());
        }

    }

    public static void anadirPedido(Date fecha_pedido, Usuario u,String direccion_entrega, List<Prenda> prendas) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FashionXpressPU");
        PedidoJpaController pjc = new PedidoJpaController(emf);
        Pedido p = new Pedido();
        p.setFecha_pedido(fecha_pedido);

        p.setUsuario(u);
        
        p.setDireccion_entrega(direccion_entrega);
      
        p.setPrendas(prendas);
        try {
            pjc.create(p);
            emf.close();
        } catch (Exception e) {
            System.out.println("Error en ModeloPedido.java ---------" + e.getMessage());
        }

    }

    public static Pedido obtenerPedido(Long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FashionXpressPU");
        PedidoJpaController pjc = new PedidoJpaController(emf);
        Pedido p = pjc.findPedido(id);
        emf.close();
        return p;

    }
     
}
