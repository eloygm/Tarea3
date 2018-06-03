package grupoc.prscouts;

import grupoc.prscouts.EstadoPago;
import grupoc.prscouts.Evento;
import grupoc.prscouts.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-03T23:39:24")
@StaticMetamodel(Pago.class)
public class Pago_ { 

    public static volatile SingularAttribute<Pago, Date> h_emision;
    public static volatile SingularAttribute<Pago, Usuario> id_usuario;
    public static volatile SingularAttribute<Pago, Date> f_validacion;
    public static volatile SingularAttribute<Pago, Date> f_emision;
    public static volatile SingularAttribute<Pago, Evento> cod_evento;
    public static volatile SingularAttribute<Pago, Double> importe;
    public static volatile SingularAttribute<Pago, EstadoPago> estadoPago;
    public static volatile SingularAttribute<Pago, Long> id_pago;

}