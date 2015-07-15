package entities;

import entities.Direccion;
import entities.Email;
import entities.Telefono;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-07-14T19:52:51")
@StaticMetamodel(Ciudadano.class)
public class Ciudadano_ { 

    public static volatile SingularAttribute<Ciudadano, Date> fechaNacimiento;
    public static volatile ListAttribute<Ciudadano, Email> emailList;
    public static volatile SingularAttribute<Ciudadano, String> apellido;
    public static volatile ListAttribute<Ciudadano, Telefono> telefonoList;
    public static volatile SingularAttribute<Ciudadano, Integer> idCiudadano;
    public static volatile SingularAttribute<Ciudadano, String> sexo;
    public static volatile ListAttribute<Ciudadano, Direccion> direccionList;
    public static volatile SingularAttribute<Ciudadano, String> nombre;

}