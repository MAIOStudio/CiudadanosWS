package entities;

import entities.Ciudadano;
import entities.Email;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-07-14T19:52:51")
@StaticMetamodel(Email.class)
public class Email_ { 

    public static volatile SingularAttribute<Email, String> tipo;
    public static volatile SingularAttribute<Email, Integer> idEmail;
    public static volatile SingularAttribute<Email, Integer> idCiudadano;
    public static volatile SingularAttribute<Email, Email> email;
    public static volatile SingularAttribute<Email, Ciudadano> ciudadano;

}