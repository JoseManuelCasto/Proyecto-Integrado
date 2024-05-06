package modelo.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.entidades.Proveedor;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-05-04T21:47:38")
@StaticMetamodel(Prenda.class)
public class Prenda_ { 

    public static volatile SingularAttribute<Prenda, String> descripcion;
    public static volatile SingularAttribute<Prenda, String> marca;
    public static volatile SingularAttribute<Prenda, Double> precio;
    public static volatile ListAttribute<Prenda, String> tallas_disp;
    public static volatile SingularAttribute<Prenda, Proveedor> proveedor;
    public static volatile SingularAttribute<Prenda, Long> id;
    public static volatile SingularAttribute<Prenda, String> imagenPrenda;
    public static volatile SingularAttribute<Prenda, Integer> stock;
    public static volatile SingularAttribute<Prenda, String> nombre;

}