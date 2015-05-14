package entities;

import entities.Ciudadano;
import entities.DireccionPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-05-14T11:52:15")
@StaticMetamodel(Direccion.class)
public class Direccion_ { 

    public static volatile SingularAttribute<Direccion, DireccionPK> direccionPK;
    public static volatile SingularAttribute<Direccion, String> tipo;
    public static volatile SingularAttribute<Direccion, String> numero;
    public static volatile SingularAttribute<Direccion, String> ciudad;
    public static volatile SingularAttribute<Direccion, String> calle;
    public static volatile SingularAttribute<Direccion, String> sector;
    public static volatile SingularAttribute<Direccion, Ciudadano> ciudadano;

}