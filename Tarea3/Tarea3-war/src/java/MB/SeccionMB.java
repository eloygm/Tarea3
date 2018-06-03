/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MB;

import EJB.AdminEJB;
import EJB.EventoEJB;
import EJB.ScoutsException;
import EJB.SeccionEJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import grupoc.prscouts.*;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author Francisco Gamez
 */
@Named(value = "seccionMB")
@RequestScoped
public class SeccionMB {

    @Inject
    private SeccionEJB seccionejb;
    @Inject
    private AdminEJB adminejb;
    
    private Seccion se;
    private String nombre;
    private Integer edad_minima;
    private Integer edad_maxima;
    private Double cuota;
    private List<Evento> listevento;
    private List<Usuario> listusuario;
    
    
    public SeccionMB() {
        listevento = new ArrayList<Evento>();
        listusuario = new ArrayList<Usuario>();
        
    }
    
    public void crearSeccion(){
        try {
            //Añade el comentario en la lista de comentarios
            //Hacer un ejb para guardar la lista de comentarios en la base de datos
            FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage(nombre + " creado correctamente"));
        
            se = new Seccion(nombre, edad_minima, edad_maxima, cuota,listevento, listusuario);
            adminejb.crearSeccion(se);
            
        } catch (Exception e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"ERROR: No se ha creado esa seccion puede que ya exista","");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
                    
    }
    
    
    public String editarSeccion(Seccion se){
        try {
            //Añade el comentario en la lista de comentarios
            //Hacer un ejb para guardar la lista de comentarios en la base de datos
           
            se.setNombre(nombre);
            se.setCuota(cuota);
            se.setEdad_Minima(edad_minima);
            se.setEdad_Maxima(edad_maxima);
            seccionejb.editarSeccion(se);
            
        } catch (Exception e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"ERROR: No se ha editado esa seccion puede que no exista","");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
           return "admin_Eventos.xhtml?faces-redirect=true";     
    }
    public String deleteSeccion(Seccion se) throws ScoutsException{
        
        
        adminejb.deleteSeccion(se);
        
        return "admin_Seccion.xhtml?face-redirect=true";
    }
    
    //GETTER Y SETTER

    public SeccionEJB getSeccionejb() {
        return seccionejb;
    }

    public void setSeccionejb(SeccionEJB seccionejb) {
        this.seccionejb = seccionejb;
    }

    public AdminEJB getAdminejb() {
        return adminejb;
    }

    public void setAdminejb(AdminEJB adminejb) {
        this.adminejb = adminejb;
    }

    public Seccion getSe() {
        return se;
    }

    public void setSe(Seccion se) {
        this.se = se;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad_minima() {
        return edad_minima;
    }

    public void setEdad_minima(Integer edad_minima) {
        this.edad_minima = edad_minima;
    }

    public Integer getEdad_maxima() {
        return edad_maxima;
    }

    public void setEdad_maxima(Integer edad_maxima) {
        this.edad_maxima = edad_maxima;
    }

    public Double getCuota() {
        return cuota;
    }

    public void setCuota(Double cuota) {
        this.cuota = cuota;
    }

    public List<Evento> getListevento() {
        return listevento;
    }
    

    public List<Seccion> getSecciones() {
        return adminejb.getSeccion();
        //return users;
    }
    
    public void setListevento(List<Evento> listevento) {
        this.listevento = listevento;
    }

    public List<Usuario> getListusuario() {
        return listusuario;
    }

    public void setListusuario(List<Usuario> listusuario) {
        this.listusuario = listusuario;
    }

   
    
    
}
