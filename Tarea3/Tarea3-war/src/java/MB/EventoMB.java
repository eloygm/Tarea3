/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MB;


import EJB.AdminEJB;
import EJB.EventoEJB;
import grupoc.prscouts.Evento;
import grupoc.prscouts.*;
import java.io.Serializable;
import java.util.Date;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;


/**
 *
 * @author Francisco Gamez
 */
@Named(value = "eventoMB")
@RequestScoped
public class EventoMB implements Serializable{

    /**
     * Creates a new instance of NewJSFManagedBean
     */
    private Evento ev;                  //OBJETO EVENTO
    private String comentario;          //COMENTARIO QUE SE ESCRIBE
    private Comentario_evento comen;
    java.util.Date fecha;
    private Usuario usuario;            //OBJETO USUARIO
    private String nombreE;             //TITULO DEL EVENTO
    private String descripcionE;        //DESCRIPCION DEL EVENTO
    private String fotoEv;              //FOTO DEL EVENTO
    private Asistentes_Evento asiEv;    //ASISTENTES A EVENTOS
    private List<Comentario_evento> comentarios; //Lista comentario
    
    @Inject
    private EventoEJB eventoejb;
    
    @Inject
    private AdminEJB aejb;
    
    @Inject
    private ControlAutorizacion ctrl;
   
    public EventoMB() {
        
        fecha = new Date(); //RECOGE LA FECHA DE HOY
        usuario = ctrl.getUsuario();
        
        
    }
    
    //GUARDAR EL COMENTARIO E IMPRIMIR
    public String guardarComentario(){
      
        //Guarda ese comentario en la lista de comentario de los eventos
        try {
            //Añade el comentario en la lista de comentarios
            //Hacer un ejb para guardar la lista de comentarios en la base de datos
            comen = new Comentario_evento(comentario, fecha, usuario, ev);
            eventoejb.guardarComentario(comen);
        } catch (Exception e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"No perteneces a este grupo tio","");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
           
        return null;
    }
    
    //MENSAJE DE AÑADIDO AL EVENTO
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    public void mensajeAñadido() {
        addMessage("PERFECTO", "Añadido al evento");
    }
     
    //PARA BUSCAR SI YA ESTA EN LA LISTA DEL EVENTO
    public boolean buscarListaUs(){
          
        try {
            return eventoejb.buscarAsistente(asiEv);
        } catch (Exception e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"No perteneces a este grupo tio","");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
          
        return false;
    }
    
    public List<Comentario_evento> obtenerComentarios(){
        return eventoejb.obtenerComentarios(ev);
    }
    
    public String listaGente(){
        
        //Guarda ese usuario como asistente al evento
        asiEv = new Asistentes_Evento(usuario, ev);
        eventoejb.guardaAsistentes(asiEv);
        return null;
    }
    
    //GETTER Y SETTER
    
    public Asistentes_Evento getAsiEv() {
        return asiEv;    
    }

    public void setAsiEv(Asistentes_Evento asiEv) {
        this.asiEv = asiEv;
    }

    public List<Comentario_evento> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario_evento> comentarios) {
        this.comentarios = comentarios;
    }

    public EventoEJB getEventoejb() {
        return eventoejb;
    }

    public void setEventoejb(EventoEJB eventoejb) {
        this.eventoejb = eventoejb;
    }

    public ControlAutorizacion getCtrl() {
        return ctrl;
    }

    
    public void setCtrl(ControlAutorizacion ctrl) {
        this.ctrl = ctrl;
    }

    public String getFotoEv() {
        return fotoEv;
    }

    public void setFotoEv(String fotoEv) {
        this.fotoEv = fotoEv;
    }
    
    
    public Evento getEv() {
        return ev;
    }

    public void setEv(Evento ev) {
        this.ev = ev;
        this.nombreE = ev.getTitulo();
        this.descripcionE = ev.getDescripcion();
        this.fotoEv = getFotoEv();
    }
    
      public String cargarEvento(Evento ev){
          setEv(ev);
          return "Evento.xhtml";
      }
    
    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Comentario_evento getComen() {
        return comen;
    }

    public void setComen(Comentario_evento comen) {
        this.comen = comen;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }
    
    public List<Evento> getLeventos(){
        return aejb.getEvent();
        
    }
    
}
