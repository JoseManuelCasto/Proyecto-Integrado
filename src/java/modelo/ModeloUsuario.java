/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import clases.Rol;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.dao.UsuarioJpaController;
import modelo.entidades.Usuario;

/**
 *
 * @author casto
 */
public class ModeloUsuario {
    public static List<Usuario> obtenerUsuarios() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FashionXpressPU");
        UsuarioJpaController ujc = new UsuarioJpaController(emf);
        List<Usuario> usuarios = ujc.findUsuarioEntities();
        emf.close();
        return usuarios;

    }

//    public static List<Usuario> obtenerSocios() {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FashionXpressPU");
//        UsuarioJpaController ujc = new UsuarioJpaController(emf);
//        List<Usuario> todosLosusuarios = ujc.findUsuarioEntities();
//        List<Usuario> socios = new ArrayList();
//
//        for (Usuario usuario : todosLosusuarios) {
//            if (usuario.getRol().equals(Rol.SOCIO)) {
//                socios.add(usuario);
//            }
//        }
//        emf.close();
//        return socios;
//
//    }

   

    public static void eliminarUsuario(Long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FashionXpressPU");
        UsuarioJpaController ujc = new UsuarioJpaController(emf);
        try {
            ujc.destroy(id);
            emf.close();
        } catch (Exception e) {
            System.out.println("Error en ModeloUsuario.java---------" + e.getMessage());
        }

    }

    public static void editarUsuario(String nombre, String apellidos, String email, String contrasena, Rol rol, Usuario u) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FashionXpressPU");
        UsuarioJpaController ujc = new UsuarioJpaController(emf);

        u.setNombre(nombre);
        u.setApellido(apellidos);
      
        u.setCorreo_electronico(email);
        u.setContrasena(contrasena);
        u.setRol(rol);
        try {
            ujc.edit(u);
            emf.close();
        } catch (Exception e) {
            System.out.println("Error en ModeloUsuario.java ---------" + e.getMessage());
        }

    }

    public static void anadirUsuario(String nombre, String apellidos, String email, String contrasena, Rol rol) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FashionXpressPU");
        UsuarioJpaController ujc = new UsuarioJpaController(emf);
        Usuario u = new Usuario();
        u.setNombre(nombre);
        u.setApellido(apellidos);
        u.setCorreo_electronico(email);
        u.setContrasena(contrasena);
        u.setRol(rol);
        try {
            ujc.create(u);
            emf.close();
        } catch (Exception e) {
            System.out.println("Error en ModeloUsuario.java ---------" + e.getMessage());
        }

    }

    public static Usuario obtenerUsuario(Long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FashionXpressPU");
        UsuarioJpaController ujc = new UsuarioJpaController(emf);
        Usuario u = ujc.findUsuario(id);
        emf.close();
        return u;

    }
     
}


