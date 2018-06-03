/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupoc.prscouts;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;

/**
 *
 * @author Miguel Santos
 */
@Entity
public class Asistentes_Evento implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_asistente;
    //@Column (nullable = false)
    @ManyToOne
    @JoinColumn(name = "fk_id_usuario", nullable = false)
    private Usuario id_usuario;
    //@Column (nullable = false)
    @ManyToOne
    @JoinColumn(name = "fk_id_evento", nullable = false)
    private Evento id_evento;

    public Asistentes_Evento(Usuario id_usuario, Evento id_evento) {
        this.id_usuario = id_usuario;
        this.id_evento = id_evento;
    }

    public Asistentes_Evento(){
        
    }    
    
    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Evento getId_evento() {
        return id_evento;
    }

    public void setId_evento(Evento id_evento) {
        this.id_evento = id_evento;
    }

    
   
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.id_usuario);
        hash = 89 * hash + Objects.hashCode(this.id_evento);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Asistentes_Evento other = (Asistentes_Evento) obj;
        if (!Objects.equals(this.id_usuario, other.id_usuario)) {
            return false;
        }
        if (!Objects.equals(this.id_evento, other.id_evento)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Asistentes_Evento{" + "ID_usuario=" + id_usuario + ", ID_evento=" + id_evento + '}';
    }
    
    
}
