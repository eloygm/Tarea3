/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import grupoc.prscouts.Evento;
import grupoc.prscouts.Seccion;
import grupoc.prscouts.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Asus
 */
@Stateless
@LocalBean
public class GrupetesSessionBean {

    @PersistenceContext
    private EntityManager em;
    
    public List<Evento> obtenerEventos(Seccion s) throws Exception {
        Seccion se= em.find(Seccion.class, s.getId());
        if(se==null){
            throw new RuntimeException("Sección no encontrada. En obtenerEventos, GrupetesSessionBean.java");
        }
        return se.getEvento();
    }
}
