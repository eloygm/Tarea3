package grupoc.prscouts;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Eloy García
 */
@Entity
public class Documentacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_documento;
    //@Column (nullable = false)
    @ManyToOne
    @JoinColumn(name = "fk_usuario", nullable = false)
    private Usuario createdByUsuario;
    @Column (nullable = false)
    @Enumerated (EnumType.STRING)
    private EstadoDocumentacion estado;
    @Column (nullable = false)
    private String nombreFichero;
    @Column (nullable = false)
    @Enumerated (EnumType.STRING)
    private TiposDocumento tipo_Documentacion;
    @Column (nullable = false)
    @Temporal(TemporalType.DATE)
    private Date Fecha_subida;
    @Column (nullable = false)
    private Double Tam_byte;
    @Temporal(TemporalType.DATE)
    private Date Fecha_Validacion;
    private String Ruta;

    public Documentacion(Usuario createdByUsuario, EstadoDocumentacion estado, String nombreFichero, TiposDocumento tipo_Documentacion, Date Fecha_subida, Double Tam_byte, Date Fecha_Validacion, String Ruta) {
        this.createdByUsuario = createdByUsuario;
        this.estado = estado;
        this.nombreFichero = nombreFichero;
        this.tipo_Documentacion = tipo_Documentacion;
        this.Fecha_subida = Fecha_subida;
        this.Tam_byte = Tam_byte;
        this.Fecha_Validacion = Fecha_Validacion;
        this.Ruta = Ruta;
    }
    
    public Documentacion(){
        
    }
    
    public Long getId() {
        return id_documento;
    }

    public void setId(Long id) {
        this.id_documento = id;
    }

    public Usuario getCreatedByUsuario() {
        return createdByUsuario;
    }

    public void setCreatedByUsuario(Usuario createdByUsuario) {
        this.createdByUsuario = createdByUsuario;
    }

    public EstadoDocumentacion getEstado() {
        return estado;
    }

    public void setEstado(EstadoDocumentacion estado) {
        this.estado = estado;
    }

    public String getNombreFichero() {
        return nombreFichero;
    }

    public void setNombreFichero(String nombreFichero) {
        this.nombreFichero = nombreFichero;
    }

    public TiposDocumento getTipo_Documentacion() {
        return tipo_Documentacion;
    }

    public void setTipo_Documentacion(TiposDocumento tipo_Documentacion) {
        this.tipo_Documentacion = tipo_Documentacion;
    }

    public Date getFecha_subida() {
        return Fecha_subida;
    }

    public void setFecha_subida(Date Fecha_subida) {
        this.Fecha_subida = Fecha_subida;
    }

    public Double getTam_byte() {
        return Tam_byte;
    }

    public void setTam_byte(Double Tam_byte) {
        this.Tam_byte = Tam_byte;
    }

    public Date getFecha_Validacion() {
        return Fecha_Validacion;
    }

    public void setFecha_Validacion(Date Fecha_Validacion) {
        this.Fecha_Validacion = Fecha_Validacion;
    }

    public String getRuta() {
        return Ruta;
    }

    public void setRuta(String Ruta) {
        this.Ruta = Ruta;
    }

       

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_documento != null ? id_documento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documentacion)) {
            return false;
        }
        Documentacion other = (Documentacion) object;
        if ((this.id_documento == null && other.id_documento != null) || (this.id_documento != null && !this.id_documento.equals(other.id_documento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "scouts.Documentacion[ id=" + id_documento + " ]";
    }
    
}
