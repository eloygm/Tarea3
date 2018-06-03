package MB;



import EJB.ControlAutorizacionEJB;
import grupoc.prscouts.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author Eloy
 */
@Named(value = "controlAutorizacion")
@SessionScoped
public class ControlAutorizacion implements Serializable {

    private Usuario usuario;
    @Inject
    private ControlAutorizacionEJB ctrE;
    

    public synchronized void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public synchronized Usuario getUsuario() {
        return usuario;
    }

    public synchronized String home() {
       
        // Implementar el método
        // Devuelve la página Home dependiendo del rol del usuario
        // Si no hay usuario debe devolver la página de login
        // Si el usuario es el administrador debe devolver la página admin.xhtml
        // Si el usuario es un usuario normal debe devolver la página normal.xhtml
        String url = ctrE.comprobarRol(usuario);
        return url;
        /*if(getUsuario() instanceof Administrador){
            
           return "adminInicio.xhtml?faces-redirect=true";
            
        } else if(getUsuario() instanceof Usuario){
            return "indexl.xhtml?faces-redirect=true";
        } else if(getUsuario()==null){
            return null;
        } else {
            return null;
        }*/
    }
    
    public synchronized String logout()
    {
        // Destruye la sesión (y con ello, el ámbito de este bean)
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.getExternalContext().invalidateSession();
        usuario = null;
        return "index.xhtml?faces-redirect=true";
    }

    /**
     * Creates a new instance of ControlAutorizacion
     */
    public ControlAutorizacion() {
    }
}
