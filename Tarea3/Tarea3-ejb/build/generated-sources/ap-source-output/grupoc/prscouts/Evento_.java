package grupoc.prscouts;

import grupoc.prscouts.Asistentes_Evento;
import grupoc.prscouts.Comentario_evento;
import grupoc.prscouts.Pago;
import grupoc.prscouts.Seccion;
import grupoc.prscouts.TipoEvento;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-03T23:39:24")
@StaticMetamodel(Evento.class)
public class Evento_ { 

    public static volatile SingularAttribute<Evento, String> descripcion;
    public static volatile SingularAttribute<Evento, Seccion> seccion;
    public static volatile ListAttribute<Evento, Comentario_evento> comentario_evento;
    public static volatile ListAttribute<Evento, Pago> createdByPago;
    public static volatile SingularAttribute<Evento, TipoEvento> tipoEvento;
    public static volatile SingularAttribute<Evento, Date> fechaInicio;
    public static volatile ListAttribute<Evento, Asistentes_Evento> asistentes_evento;
    public static volatile SingularAttribute<Evento, String> titulo;
    public static volatile SingularAttribute<Evento, Long> id;
    public static volatile SingularAttribute<Evento, String> Imagen;
    public static volatile SingularAttribute<Evento, Date> fechaFin;

}