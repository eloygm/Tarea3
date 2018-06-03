package MB;

import EJB.ContrasenaExcepcion;
import EJB.LogEJB;
import EJB.UsuarioExcepcion;
import EJB.ValidacionExcepcion;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import grupoc.prscouts.Usuario;
import java.util.Date;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("Log")
@RequestScoped
public class Log {

    private Usuario usuario = new Usuario();
    private String id;
    private String contrasenia;
    
    private Date fecha = new Date();

    @Inject
    private LogEJB lejb;

    @Inject
    private ControlAutorizacion ctrl;

    public Log() {
        
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String autenticar() throws UsuarioExcepcion, ContrasenaExcepcion, ValidacionExcepcion {
        // Implementar este método
        try {
            usuario.setDNI(id);
            usuario.setContrasena(contrasenia);
            Usuario u = lejb.ComprobarUsuario(usuario);
            ctrl.setUsuario(u);
            return ctrl.home();
            
        }catch(UsuarioExcepcion ue){
            FacesMessage fm = new FacesMessage("La cuenta no existe");
            FacesContext.getCurrentInstance().addMessage("login:user", fm);
        }catch (ContrasenaExcepcion ce){
            FacesMessage fm = new FacesMessage("La contraseña no es correcta");
            FacesContext.getCurrentInstance().addMessage("login:pass", fm);
        } catch (ValidacionExcepcion ve){
            FacesMessage fm = new FacesMessage("La cuenta no esta validada, contacte con el administrador");
            FacesContext.getCurrentInstance().addMessage("login:validacion", fm);
        }
        return null;
    }
}
