package modelo.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.entidades.Prenda;
import modelo.entidades.Usuario;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-05-04T21:47:38")
@StaticMetamodel(Valoracion.class)
public class Valoracion_ { 

    public static volatile SingularAttribute<Valoracion, Usuario> usuario;
    public static volatile SingularAttribute<Valoracion, Long> id;
    public static volatile SingularAttribute<Valoracion, Integer> clasificacion;
    public static volatile SingularAttribute<Valoracion, Prenda> prenda;
    public static volatile SingularAttribute<Valoracion, String> comentario;

}