package grupoc.prscouts;

import grupoc.prscouts.Asistentes_Evento;
import grupoc.prscouts.Comentario_evento;
import grupoc.prscouts.Documentacion;
import grupoc.prscouts.Pago;
import grupoc.prscouts.Seccion;
import grupoc.prscouts.TipoUsuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-03T23:39:24")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> apellido2;
    public static volatile SingularAttribute<Usuario, Boolean> estado_perfil;
    public static volatile SingularAttribute<Usuario, String> apellido1;
    public static volatile SingularAttribute<Usuario, Date> fecha_nacimiento;
    public static volatile SingularAttribute<Usuario, String> nombre;
    public static volatile ListAttribute<Usuario, Pago> pagos;
    public static volatile SingularAttribute<Usuario, Seccion> seccion;
    public static volatile ListAttribute<Usuario, Documentacion> documentos;
    public static volatile SingularAttribute<Usuario, Date> fecha_baja;
    public static volatile SingularAttribute<Usuario, Date> fecha_alta;
    public static volatile SingularAttribute<Usuario, String> contrasena;
    public static volatile SingularAttribute<Usuario, TipoUsuario> tipoUsuario;
    public static volatile ListAttribute<Usuario, Comentario_evento> comentarios;
    public static volatile SingularAttribute<Usuario, String> DNI;
    public static volatile ListAttribute<Usuario, Asistentes_Evento> asistencias;

}