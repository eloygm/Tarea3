/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupoc.prscouts;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Martin Mazzola
 */
@Entity
public class Promesa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column (nullable = false)
    private String promesa;
    @Column (nullable = false)
    @Temporal (TemporalType.DATE)
    private Date fecha_promesa;
    @ManyToOne
    private Usuario usuario;

    public Promesa(String promesa, Date fecha_promesa, Usuario usuario) {
        this.promesa = promesa;
        this.fecha_promesa = fecha_promesa;
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
    public Promesa() {
    }    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPromesa() {
        return promesa;
    }

    public void setPromesa(String promesa) {
        this.promesa = promesa;
    }

    public Date getFecha_promesa() {
        return fecha_promesa;
    }

    public void setFecha_promesa(Date fecha_promesa) {
        this.fecha_promesa = fecha_promesa;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final Promesa other = (Promesa) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Promesa{" + "id=" + id + ", promesa=" + promesa + ", fecha_promesa=" + fecha_promesa + ", usuario=" + usuario + '}';
    }

    
}
