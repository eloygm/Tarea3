/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MB;

import EJB.GrupetesSessionBean;
import grupoc.prscouts.Evento;
import grupoc.prscouts.Seccion;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;
 
//@ManagedBean
@Named(value="calendarView")
@RequestScoped
public class CalendarView implements Serializable{  
    @Inject
    private GrupetesSessionBean grupetes;
    Seccion seccion;
    
    private static Date date1;
    private String nombre,link;
    private static final Datos[] data = new Datos[]{new Datos("Evento1 Google","Https://www.google.com"),
    new Datos("Evento2 Google","Https://www.google.com")};
    List<Evento> eventoss;
    
//Antiguamente en CalendarBean
        private static String grupo;

    public void seteandoGrupo(String s){
        grupo=s;
    }
    public String geteandoGrupo(){
        return grupo;
    }
    //--------------------------------------
    public void setSeccion(Seccion s){
        seccion=s;
    }
    public Seccion getSeccion(){
        return seccion;
    }
    public List<Evento> obtenerEventos(Seccion s) throws Exception{
        return grupetes.obtenerEventos(s);
    }
    
    public void setEventos(List<Evento> li){
        eventoss=li;
    }
    
    public Datos[] getData() {
        return data;
    }
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
 //--------------------------------------------------------------------------------------
    public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }

    public void click() {
        PrimeFaces.current().ajax().update("form:display");
        PrimeFaces.current().executeScript("PF('dlg').show()");
    }
    
    public void setDate1(Date date1) {
        this.date1 = date1;
    }
    
    public Date getDate1() throws ParseException {
        return date1;
    }
    public String fecha(Date d){
        SimpleDateFormat sdf = new SimpleDateFormat(
            "dd/MM/yyyy");
        if(d==null)return "nulisimo";
        return sdf.format(d);
    }

    public static class Datos {
        String nombre,link;
        public Datos(String n, String l) {
            nombre=n;
            link=l;
        }
        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }
    }
}

//Solo los scouters lo pueden modificar
//HAY QUE INCLUIR EN WEB.XML <context-param><param-name>javax.faces.DATETIMECONVERTER_DEFAULT_TIMEZONE_IS_SYSTEM_TIMEZONE</param-name><param-value>true</param-value></context-param>

