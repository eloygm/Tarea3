package MB;

import EJB.AdminEJB;
import EJB.ScoutsException;
import grupoc.prscouts.Asistentes_Evento;
import grupoc.prscouts.Comentario_evento;
import grupoc.prscouts.Evento;
import grupoc.prscouts.Seccion;
import grupoc.prscouts.TipoEvento;
import java.io.File;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import org.primefaces.PrimeFaces;

/**
 *
 * @author ala_j
 */
@Named(value = "crearEvento_MB")
@SessionScoped
public class AdmEvento_MB implements Serializable {

    /**
     * Creates a new instance of CrearEvento_MB
     */
    private String titulo;
    private TipoEvento tipoevento;
    private String descripcion;
    private Seccion seccion;
    private Date fechaInicio;
    private Date fechaFin;
    private String imagen;
    private List<Comentario_evento> comentario_evento;
    private List<Asistentes_Evento> asistentes_evento;
            
    private Evento ev;
    
    @Inject
    private AdminEJB aejb;
    
    
    public String guardarEvento() throws ScoutsException{
        ev = new Evento();
                 
            ev.setTipoEvento(this.tipoevento);
            ev.setFechaInicio(this.fechaInicio);
            ev.setFechaFin(this.fechaFin);
            ev.setImagen(this.imagen);
            ev.setTitulo(this.titulo);
            ev.setDescripcion(this.descripcion);
            ev.setSeccion(this.seccion);
            ev.setComentario_evento(this.comentario_evento);
            //ev.setAsistentes_evento(this.asistentes_evento);
            
            aejb.crearEvento(ev);
        
            return "admin_Eventos.xhtml?face-redirect=true";
    }
    
    public String updateEvento() throws ScoutsException{
        ev = new Evento();
                 
            ev.setTipoEvento(this.tipoevento);
            ev.setFechaInicio(this.fechaInicio);
            ev.setFechaFin(this.fechaFin);
            ev.setImagen(this.imagen);
            ev.setTitulo(this.titulo);
            ev.setDescripcion(this.descripcion);
            ev.setSeccion(this.seccion);
            ev.setComentario_evento(this.comentario_evento);
            
        Evento update = aejb.searchEvento(ev);
        
        update.setSeccion(this.seccion);
        update.setTitulo(this.titulo);
        update.setDescripcion(this.descripcion);
        update.setFechaInicio(this.fechaInicio);
        update.setFechaFin(this.fechaFin);
        update.setImagen(this.imagen);
        update.setTipoEvento(this.tipoevento);
        
        aejb.updateEvento(update);
        
        return "admin_Eventos.xhtml?face-redirect=true";
    }

    public AdmEvento_MB() {
        //ev = new Evento(TipoEvento.PAGO, null, null, null, titulo, descripcion, null, null, null, null);
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

    public TipoEvento getTipoevento() {
        return tipoevento;
    }

    public void setTipoevento(TipoEvento tipoevento) {
        this.tipoevento = tipoevento;
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
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
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public List<Comentario_evento> getComentario_evento() {
        return comentario_evento;
    }

    public void setComentario_evento(List<Comentario_evento> comentario_evento) {
        this.comentario_evento = comentario_evento;
    }

    public List<Asistentes_Evento> getAsistentes_evento() {
        return asistentes_evento;
    }

    public void setAsistentes_evento(List<Asistentes_Evento> asistentes_evento) {
        this.asistentes_evento = asistentes_evento;
    }
    
    public Evento getEv() {
        return ev;
    }

    public void setEv(Evento ev) {
        this.ev = ev;
    }
    
    public List<Seccion> getSecciones(){
        return aejb.getSeccion();
    }



    
}

