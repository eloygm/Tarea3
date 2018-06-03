package grupoc.prscouts;

import grupoc.prscouts.Evento;
import grupoc.prscouts.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-03T23:39:24")
@StaticMetamodel(Seccion.class)
public class Seccion_ { 

    public static volatile SingularAttribute<Seccion, Integer> Edad_Minima;
    public static volatile ListAttribute<Seccion, Evento> evento;
    public static volatile SingularAttribute<Seccion, Double> cuota;
    public static volatile SingularAttribute<Seccion, Integer> Edad_Maxima;
    public static volatile ListAttribute<Seccion, Usuario> usuario;
    public static volatile SingularAttribute<Seccion, Long> id;
    public static volatile SingularAttribute<Seccion, String> nombre;

}