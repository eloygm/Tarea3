/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import grupoc.prscouts.*;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Francisco Gamez
 */
@Stateless
@LocalBean
public class SeccionEJB {
    
    @PersistenceContext
    private EntityManager em;

    
    public void editarSeccion(Seccion se) throws ScoutsException{
        Seccion se1 = em.find(Seccion.class, se.getNombre());
        
        if(se1 == null){
            throw new ScoutsException("ERROR: No existe esa seccion o introdujiste mal el nombre");
        }else{
            em.merge(se);
        }
    }
}
