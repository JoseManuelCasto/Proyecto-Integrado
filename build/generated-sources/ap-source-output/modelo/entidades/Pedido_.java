package modelo.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.entidades.Prenda;
import modelo.entidades.Usuario;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-05-04T21:47:38")
@StaticMetamodel(Pedido.class)
public class Pedido_ { 

    public static volatile SingularAttribute<Pedido, Date> fecha_pedido;
    public static volatile SingularAttribute<Pedido, Usuario> usuario;
    public static volatile SingularAttribute<Pedido, Boolean> pedidoRealizado;
    public static volatile SingularAttribute<Pedido, Long> id;
    public static volatile SingularAttribute<Pedido, String> direccion_entrega;
    public static volatile ListAttribute<Pedido, Prenda> prendas;

}