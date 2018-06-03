/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import grupoc.prscouts.TipoUsuario;
import grupoc.prscouts.Usuario;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Eloy
 */
@Stateless
@LocalBean
public class ControlAutorizacionEJB {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext
    private EntityManager em;
    
public String comprobarRol(Usuario u){
        if(u.getTipoUsuario()==TipoUsuario.EDUCANDO||u.getTipoUsuario()==TipoUsuario.SCOUT){
            return "indexl.xhtml"; 
        } else if(u.getTipoUsuario()==TipoUsuario.ADMINISTRADOR){
            
            return "admin_Inicio.xhtml?faces-redirect=true";
        } else
            
            return null;
    }
    
    
}
