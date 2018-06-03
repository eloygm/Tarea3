/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupoc.prscouts;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author Ana Tionoco
 */
@Entity
public class Comentario_evento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_comentario;

    @Column (nullable = false)
    private String Texto;
    @Column (nullable = false)
    @Temporal(TemporalType.DATE)
    private Date Fecha;
   /* @Column (nullable = false)
    @Temporal(Calendar)
    private Time hora;
    //Relaciones
    */
   // @Column (nullable = false)
    @ManyToOne
    @JoinColumn(name = "fk_usuario", nullable = false)
    private Usuario usuario;
    //@Column (nullable = false)
    @ManyToOne
    @JoinColumn(name = "fk_evento", nullable = false)
    private Evento evento;
    
    public Comentario_evento(){
        
    }
    
    public Comentario_evento(String Texto, Date Fecha, Usuario usuario, Evento evento) {
        this.Texto = Texto;
        this.Fecha = Fecha;
        this.usuario = usuario;
        this.evento = evento;
    }

    
    public Long getId() {
        return id_comentario;
    }

    public void setId(Long id) {
        this.id_comentario = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Evento getEvento() {
        return evento;
    }
    public String getTexto() {
        return Texto;
    }

    public void setTexto(String Texto) {
        this.Texto = Texto;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }
/*
    public Timestamp getHora() {
        return hora;
    }

    public void setHora(Timestamp hora) {
        this.hora = hora;
    }*/
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_comentario != null ? id_comentario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comentario_evento)) {
            return false;
        }
        Comentario_evento other = (Comentario_evento) object;
        if ((this.id_comentario == null && other.id_comentario != null) || (this.id_comentario != null && !this.id_comentario.equals(other.id_comentario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.pro_scouts.Comentario_evento[ id=" + id_comentario + " ]";
    }
}
