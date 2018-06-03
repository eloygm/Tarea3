/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupoc.prscouts;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author ala_j
 */
@Entity
public class Seccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column (nullable = false)
    private String nombre;
    @Column (nullable = false)
    private Integer Edad_Minima;
    @Column (nullable = false)
    private Integer Edad_Maxima;
    @Column (nullable = false)
    private Double cuota;
    //@Column (nullable = false)
    @OneToMany(mappedBy="seccion")
    @JoinColumn(name = "fk_evento", nullable = false)
    private List<Evento> evento;

    @OneToMany (mappedBy="seccion")
    @JoinColumn(name = "fk_usuario", nullable = false)
    private List<Usuario> usuario;

    public Seccion(String nombre, Integer Edad_Minima, Integer Edad_Maxima, Double cuota, List<Evento> evento, List<Usuario> usuario) {
        this.nombre = nombre;
        this.Edad_Minima = Edad_Minima;
        this.Edad_Maxima = Edad_Maxima;
        this.cuota = cuota;
        this.evento = evento;
        this.usuario = usuario;
    }



    public Seccion() {
    }
    
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad_Minima() {
        return Edad_Minima;
    }

    public void setEdad_Minima(int Edad_Minima) {
        this.Edad_Minima = Edad_Minima;
    }

    public int getEdad_Maxima() {
        return Edad_Maxima;
    }

    public void setEdad_Maxima(int Edad_Maxima) {
        this.Edad_Maxima = Edad_Maxima;
    }

    public Double getCuota() {
        return cuota;
    }

    public void setCuota(Double cuota) {
        this.cuota = cuota;
    }

    public List<Evento> getEvento() {
        return evento;
    }

    public void setEvento(List<Evento> evento) {
        this.evento = evento;
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
        if (!(object instanceof Seccion)) {
            return false;
        }
        Seccion other = (Seccion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Seccion{" + "id=" + id + ", nombre=" + nombre + ", Edad_Minima=" + Edad_Minima + ", Edad_Maxima=" + Edad_Maxima + ", cuota=" + cuota + ", evento=" + evento + ", usuario=" + usuario + '}';
    }


  
}
