/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupoc.prscouts;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Francisco Gámez
 */
@Entity
public class Evento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column (nullable = false)
    @Enumerated (EnumType.STRING)
    private TipoEvento tipoEvento;
    @Column (nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column (nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Column (nullable = false)
    private String Imagen;
    @Column (nullable = false)
    private String titulo;
    @Column (nullable = false)
    private String descripcion;
    
    @ManyToOne
    private Seccion seccion;
    @OneToMany (mappedBy="cod_evento")
    private List<Pago> createdByPago;
    @OneToMany (mappedBy="evento")
    private List<Comentario_evento> comentario_evento;
    @OneToMany(mappedBy = "id_evento")
    private List<Asistentes_Evento> asistentes_evento;

    public Evento(TipoEvento tipoEvento, Date fechaInicio, Date fechaFin, String Imagen, String titulo, String descripcion, Seccion seccion, List<Pago> createdByPago, List<Comentario_evento> comentario_evento, List<Asistentes_Evento> asistentes_evento) {
        this.tipoEvento = tipoEvento;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.Imagen = Imagen;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.seccion = seccion;
        this.createdByPago = createdByPago;
        this.comentario_evento = comentario_evento;
        this.asistentes_evento = asistentes_evento;
    }

    public Evento() {
    }
    
    
    
    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String Imagen) {
        this.Imagen = Imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

    public List<Pago> getCreatedByPago() {
        return createdByPago;
    }

    public void setCreatedByPago(List<Pago> createdByPago) {
        this.createdByPago = createdByPago;
    }

    public List<Comentario_evento> getComentario_Evento() {
        return comentario_evento;
    }

    public void setComentario_evento(List<Comentario_evento> comentario_Evento) {
        this.comentario_evento = comentario_evento;
    }

    public List<Asistentes_Evento> getAsistentes_evento() {
        return asistentes_evento;
    }

 
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evento)) {
            return false;
        }
        Evento other = (Evento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.pro_scouts.Evento[ id=" + id + " ]";
    }
    
}
