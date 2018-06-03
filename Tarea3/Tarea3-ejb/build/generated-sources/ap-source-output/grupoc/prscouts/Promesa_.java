package grupoc.prscouts;

import grupoc.prscouts.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-03T23:39:24")
@StaticMetamodel(Promesa.class)
public class Promesa_ { 

    public static volatile SingularAttribute<Promesa, Date> fecha_promesa;
    public static volatile SingularAttribute<Promesa, String> promesa;
    public static volatile SingularAttribute<Promesa, Usuario> usuario;
    public static volatile SingularAttribute<Promesa, Long> id;

}