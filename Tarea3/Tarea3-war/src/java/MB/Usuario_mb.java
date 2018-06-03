/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MB;

import EJB.AdminEJB;
import EJB.ScoutsException;
import grupoc.prscouts.*;
import static grupoc.prscouts.TipoUsuario.EDUCANDO;
import static grupoc.prscouts.TipoUsuario.SCOUT;
import static grupoc.prscouts.TipoUsuario.ADMINISTRADOR;
import java.io.File;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Cherico
 */
@Named(value = "usuario_mb")
@RequestScoped
public class Usuario_mb {

   
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String contrasena;
    private String DNI;
    private Date fecha_nacimiento;
    private File file;
    private String fileName;
    private Boolean estado;
    private String tipousuario;
    private Seccion seccion;
   
    @Inject
    private AdminEJB aejb;
    
    
    private List<TipoUsuario> list;
    
    private List<Usuario> users;
    
    public Usuario_mb() {
        //users=new ArrayList<Usuario>();
       
    }


   
    public void click() {
        PrimeFaces.current().ajax().update("form:display");
        PrimeFaces.current().executeScript("PF('dlg').show()");
    }
   
   
 
    public void crearUsuario() throws ScoutsException {
      
        FacesContext.getCurrentInstance().addMessage(null,
        new FacesMessage(nombre + " " + apellido1 + " registrado correctamente"));
        
        Usuario nuevo= new Usuario();
                
        nuevo.setDNI(DNI);
        nuevo.setNombre(nombre);
        nuevo.setApellido1(apellido1);
        nuevo.setApellido2(apellido2);
        nuevo.setContrasena(contrasena);
        nuevo.setEstado_perfil(false);
        nuevo.setTipoUsuario(EDUCANDO);
        nuevo.setFecha_alta(new Date());
        nuevo.setFecha_nacimiento(fecha_nacimiento);
        //nuevo.setTipoUsuario(tipousuario);
        
        aejb.crearUsuario(nuevo);
       //users.add(nuevo);       
       
    }
    
    public String crearUsuarioAd() throws ScoutsException {
      
        FacesContext.getCurrentInstance().addMessage(null,
        new FacesMessage(nombre + " " + apellido1 + " registrado correctamente"));
        
        Usuario nuevo= new Usuario();
                
        nuevo.setDNI(DNI);
        nuevo.setNombre(nombre);
        nuevo.setApellido1(apellido1);
        nuevo.setApellido2(apellido2);
        nuevo.setContrasena(contrasena);
        nuevo.setEstado_perfil(true);
        if(tipousuario.equalsIgnoreCase("ADMINISTRADOR")){
            nuevo.setTipoUsuario(ADMINISTRADOR);
        } else if(tipousuario.equalsIgnoreCase("EDUCANDO")){
            nuevo.setTipoUsuario(EDUCANDO);
        } else if(tipousuario.equalsIgnoreCase("SCOUT")){
            nuevo.setTipoUsuario(SCOUT);
        }
       
        nuevo.setFecha_alta(new Date());
        nuevo.setFecha_nacimiento(fecha_nacimiento);
        
        aejb.crearUsuario(nuevo);
       //users.add(nuevo);       
       return "admin_Usuarios.xhtml";
    }
    
    public String updateUsuario() throws ScoutsException{
        
      //ListIterator<Usuario> it = users.listIterator();
        
        Usuario update = aejb.searchUser(DNI);
        
        /*while(it.hasNext() || update!=null ){
            if(it.next().getId().equals(id_usuario)){
                update = it.next();
            }
        }*/

        //update.setDNI(DNI);
        update.setNombre(nombre);
        update.setApellido1(apellido1);
        update.setApellido2(apellido2);
        update.setContrasena(contrasena);
        //update.setEstado_perfil(estado);
        aejb.updateUsuario(update);
        FacesContext.getCurrentInstance().addMessage(null,
         new FacesMessage("Actualizado correctamente"));
        
        return "admin_Usuarios.xhtml?faces-redirect=true";
    }
    
    public String updateViUser(Usuario us){
        
        this.nombre=us.getNombre();
        this.apellido1=us.getApellido1();
        this.apellido2=us.getApellido2();
        this.contrasena=us.getContrasena();
        this.DNI=us.getDNI();
        this.fecha_nacimiento=us.getFecha_nacimiento();
        
        
        return "admin_UpdateUsuario.xhtml";
    }
    
    public String deleteUsuario(Usuario us) throws ScoutsException{
        
        //ListIterator<Usuario> it = users.listIterator();
        
         
         
        /*Boolean borrado = false;
        while(!borrado || it.hasNext() ){
            if(it.next().getId().equals(us.getId())){
                users.remove(it.next());
                borrado = true;
            }
        }*/
        aejb.deleteUsuario(us);
        
        return "admin_Usuarios.xhtml?face-redirect=true";
    }
    
    public String validarUser(Usuario us) throws ScoutsException{
        aejb.ValidarUsuario(us);
        
        return "admin_Usuarios.xhtml?face-redirect=true";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public List<Usuario> getUsers() {
        return aejb.getUsuario();
        //return users;
    }

    public void setUsers(List<Usuario> users) {
        this.users = users;
    }

    public String getTipousuario() {
        return tipousuario;
    }

    public void setTipousuario(String tipousuario) {
        this.tipousuario = tipousuario;
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }
    
}
