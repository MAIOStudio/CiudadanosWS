package entities;

import entities.Ciudadano;
import entities.EmailPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-05-14T21:35:42")
@StaticMetamodel(Email.class)
public class Email_ { 

    public static volatile SingularAttribute<Email, String> tipo;
    public static volatile SingularAttribute<Email, EmailPK> emailPK;
    public static volatile SingularAttribute<Email, String> email;
    public static volatile SingularAttribute<Email, Ciudadano> ciudadano;

}