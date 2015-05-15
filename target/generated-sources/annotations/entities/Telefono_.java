package entities;

import entities.Ciudadano;
import entities.TelefonoPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-05-14T21:35:42")
@StaticMetamodel(Telefono.class)
public class Telefono_ { 

    public static volatile SingularAttribute<Telefono, String> tipo;
    public static volatile SingularAttribute<Telefono, TelefonoPK> telefonoPK;
    public static volatile SingularAttribute<Telefono, String> telefono;
    public static volatile SingularAttribute<Telefono, Ciudadano> ciudadano;

}