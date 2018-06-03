package grupoc.prscouts;

import grupoc.prscouts.Evento;
import grupoc.prscouts.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-03T23:39:24")
@StaticMetamodel(Comentario_evento.class)
public class Comentario_evento_ { 

    public static volatile SingularAttribute<Comentario_evento, Evento> evento;
    public static volatile SingularAttribute<Comentario_evento, Date> Fecha;
    public static volatile SingularAttribute<Comentario_evento, Usuario> usuario;
    public static volatile SingularAttribute<Comentario_evento, Long> id_comentario;
    public static volatile SingularAttribute<Comentario_evento, String> Texto;

}