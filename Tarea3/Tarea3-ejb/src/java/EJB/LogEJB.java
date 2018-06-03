/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

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
public class LogEJB {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext
    private EntityManager em;

    
    public Usuario ComprobarUsuario(Usuario u) throws UsuarioExcepcion, ContrasenaExcepcion, ValidacionExcepcion{
        Usuario us1 = em.find(Usuario.class, u.getDNI());
        
        if(us1 == null)
            throw new UsuarioExcepcion("ERROR: Usuario no encontrado.");
        else{
            if(!us1.getContrasena().equals(u.getContrasena())){
                throw new ContrasenaExcepcion("ERROR: Contrasena no coincide.");
            } else{
                if(!us1.isEstado_perfil()){
                    throw new ValidacionExcepcion("Error: La cuenta no esta validada. Contacte con el administrador.");
                } else
                    return us1;
            }
        }
            
        
    }

    
            
    
    
}
