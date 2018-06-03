package grupoc.prscouts;

import grupoc.prscouts.EstadoDocumentacion;
import grupoc.prscouts.TiposDocumento;
import grupoc.prscouts.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-03T23:39:24")
@StaticMetamodel(Documentacion.class)
public class Documentacion_ { 

    public static volatile SingularAttribute<Documentacion, Long> id_documento;
    public static volatile SingularAttribute<Documentacion, Usuario> createdByUsuario;
    public static volatile SingularAttribute<Documentacion, EstadoDocumentacion> estado;
    public static volatile SingularAttribute<Documentacion, String> nombreFichero;
    public static volatile SingularAttribute<Documentacion, Date> Fecha_subida;
    public static volatile SingularAttribute<Documentacion, String> Ruta;
    public static volatile SingularAttribute<Documentacion, TiposDocumento> tipo_Documentacion;
    public static volatile SingularAttribute<Documentacion, Date> Fecha_Validacion;
    public static volatile SingularAttribute<Documentacion, Double> Tam_byte;

}