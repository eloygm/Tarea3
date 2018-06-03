/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupoc.prscouts;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
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
 * @author Jose Luis Ruiz
 */
@Entity
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column (nullable = false, unique=true)
    private String DNI;
    @Column (nullable = false)
    private String nombre;
    @Column (nullable = false)
    private String apellido1;
    @Column (nullable = false)
    private String apellido2;
    @Column (nullable = false)
    private String contrasena;
    @Column (nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha_nacimiento;
    @Column (nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha_alta;
    @Column (nullable = true)
    @Temporal(TemporalType.DATE)
    private Date fecha_baja;
    @Column (nullable = false)
    private boolean estado_perfil;
    @Column (nullable = false)
    @Enumerated (EnumType.STRING)
    private TipoUsuario tipoUsuario;
    @OneToMany 
    private List<Documentacion> documentos;
    @OneToMany
    private List<Comentario_evento> comentarios;
    @ManyToOne 
    private Seccion seccion;
    @OneToMany (mappedBy = "id_usuario")
    private List<Pago> pagos;
    @OneToMany (mappedBy = "id_usuario")
    private List<Asistentes_Evento> asistencias;

    

    
    public Usuario() {
    }

    public Usuario(String nombre, String apellido1, String apellido2, String contrasena, String DNI, Date fecha_nacimiento, Date fecha_alta) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.contrasena = contrasena;
        this.DNI = DNI;
        this.fecha_nacimiento = fecha_nacimiento;
        this.fecha_alta = fecha_alta;
    }

    public List<Pago> getPagos() {
        return pagos;
    }

    public void setPagos(List<Pago> pagos) {
        this.pagos = pagos;
    }

    public List<Asistentes_Evento> getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(List<Asistentes_Evento> asistencias) {
        this.asistencias = asistencias;
    }

    
    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

    

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public List<Comentario_evento> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario_evento> comentarios) {
        this.comentarios = comentarios;
    }

    

   
  

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Date getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(Date fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    public Date getFecha_baja() {
        return fecha_baja;
    }

    public void setFecha_baja(Date fecha_baja) {
        this.fecha_baja = fecha_baja;
    }

    public boolean isEstado_perfil() {
        return estado_perfil;
    }

    public void setEstado_perfil(boolean estado_perfil) {
        this.estado_perfil = estado_perfil;
    }
    
    public boolean getEstado_perfil() {
        return this.estado_perfil;
    }

    public List getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<Documentacion> documentos) {
        this.documentos = documentos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.DNI);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.DNI, other.DNI)) {
            return false;
        }
        return true;
    }
    
    

    @Override
    public String toString() {
        return "Usuario{" + "id=" + DNI + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", contrase\u00f1a=" + contrasena + ", DNI=" + DNI + ", fecha_nacimiento=" + fecha_nacimiento + ", fecha_alta=" + fecha_alta + ", fecha_baja=" + fecha_baja + ", estado_perfil=" + estado_perfil + ", documentos=" + documentos + '}';
    }
    
}
