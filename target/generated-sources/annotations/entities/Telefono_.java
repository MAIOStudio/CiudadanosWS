package entities;

import entities.Ciudadano;
import entities.Telefono;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-07-14T19:52:51")
@StaticMetamodel(Telefono.class)
public class Telefono_ { 

    public static volatile SingularAttribute<Telefono, String> tipo;
    public static volatile SingularAttribute<Telefono, Integer> idTelefono;
    public static volatile SingularAttribute<Telefono, Integer> idCiudadano;
    public static volatile SingularAttribute<Telefono, Telefono> telefono;
    public static volatile SingularAttribute<Telefono, Ciudadano> ciudadano;

}