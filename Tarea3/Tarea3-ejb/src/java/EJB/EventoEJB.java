/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import grupoc.prscouts.*;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Francisco Gamez
 */
@Stateless
@LocalBean
public class EventoEJB {
    
    @PersistenceContext
    private EntityManager em;
    
    public void guardarComentario(Comentario_evento comen){
        //Si el usuario tiene la misma seccion que el evento al que comenta se guarda
        if(!comen.getEvento().getSeccion().equals(comen.getUsuario().getSeccion())){
            throw new RuntimeException("Error: Diferente seccion");
        }else{
            Evento ev = comen.getEvento();
            ev.getComentario_Evento().add(comen);
            em.merge(ev);
            em.persist(comen);
        }
        
    }
    
    public List<Comentario_evento> obtenerComentarios(Evento ev){
        Evento ev1 = em.find(Evento.class, ev.getId());
        if(ev1 ==  null){
            throw new RuntimeException("Error: No existe el evento");
        }
        //Devuelve la lista de los comentarios
        return ev1.getComentario_Evento();
        
    }
    
    public void guardaAsistentes (Asistentes_Evento asi){
        //Si el usuario tiene la misma seccion que el usuario se guarda
        if(asi.getId_evento().getSeccion().equals(asi.getId_usuario().getSeccion())){
            Evento ev = asi.getId_evento();
            ev.getAsistentes_evento().add(asi);
            em.merge(ev);
            em.persist(asi);
        }else{
            throw new RuntimeException("Error: Diferente seccion");
        }
    }
    
    public List<Asistentes_Evento> obtenerListaAsistentes(Evento ev){
        Evento ev1 = em.find(Evento.class, ev.getId());
        if(ev1 ==  null){
            throw new RuntimeException("Error: No existe el evento");
        }
        //Devuelve la lista de los asistentes del evento
        return ev1.getAsistentes_evento();
        
    }
    
    public Boolean buscarAsistente(Asistentes_Evento asi){
        boolean si = false;
        
        Asistentes_Evento asi1 = em.find(Asistentes_Evento.class, asi);
        if(asi1 == null){
            throw new RuntimeException("Error: No hay usuario con esa id");
        }else{
            si = true; //Ha encontrado a ese usuario
        }
       
        return si;
    }
}
