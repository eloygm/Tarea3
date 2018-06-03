/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MB;

import EJB.AdminEJB;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import grupoc.prscouts.Evento;
import javax.annotation.ManagedBean;
import javax.faces.annotation.ManagedProperty;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
/**
 *
 * @author Eloy
 */
@ManagedBean
@ViewScoped
public class LoadNoticias implements Serializable{
    
    @Inject
    private AdminEJB aejb;
    
    private List<Evento> eventos;

    public List<Evento> getEventos() {
        setEventos(aejb.getEvent());
        
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }
    
    

    

    
    
    
    
}

