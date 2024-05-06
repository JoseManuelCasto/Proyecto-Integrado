/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.dao.UsuarioJpaController;
import modelo.entidades.Usuario;

/**
 *
 * @author casto
 */
public class ModeloLogin {
    public static Usuario validarUsuario(String correo, String contrasena){
        Usuario u = null;
        boolean encontrado = false;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FashionXpressPU");
        UsuarioJpaController ejc = new UsuarioJpaController(emf);
        List<Usuario> usuarios = ejc.findUsuarioEntities();
        
        for (int i = 0; i < usuarios.size() && !encontrado; i++) {
            Usuario actual = usuarios.get(i);
            if (actual.getCorreo_electronico().equals(correo)) {
                encontrado = true;
               if (actual.getContrasena().equals(contrasena)) {
                u = actual;
            } 
            }
        }
        emf.close();
        return u;
    }
}
