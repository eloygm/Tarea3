/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import grupoc.prscouts.Asistentes_Evento;
import grupoc.prscouts.Documentacion;
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
 * @author Martin
 */
@Stateless
@LocalBean
public class AdminEJB {

   @PersistenceContext
   private EntityManager em;
   
   public void ValidarUsuario(Usuario us){
       Usuario u = em.find(Usuario.class, us.getDNI());
       u.setEstado_perfil(true);
       em.merge(u);
   }
   
   //Search
   public Usuario searchUser(String dni) throws ScoutsException{
       Usuario u = em.find(Usuario.class, dni);
       if (u != null) {
            throw new ScoutsException("ERROR: El Usuario no existe.");
        }
       return u;
       
   }
   
   public Evento searchEvento(Evento ev) throws ScoutsException{
       Evento e = em.find(Evento.class, ev.getId());
       if (e != null) {
            throw new ScoutsException("ERROR: El Usuario no existe.");
        }
       return e;
       
   }
   
   //CREATE
   
   public void crearUsuario (Usuario usuario ) throws ScoutsException{
     Usuario u = em.find(Usuario.class, usuario.getDNI());
     if (u != null) {
            throw new ScoutsException("ERROR: Ese usuario ya existe");
        }
     em.persist(usuario);
    }
   
   public void crearEvento (Evento event) throws ScoutsException{
       Evento e = em.find(Evento.class, event.getId());
       
       if(e != null){
           throw new ScoutsException("ERROR: Ese evento ya existe");
       }
       em.persist(event);
   }
   
   public void crearDocumento (Documentacion doc ) throws ScoutsException{
     Documentacion d = em.find(Documentacion.class, doc.getId());
     if (d != null) {
            throw new ScoutsException("ERROR: Ese documento ya existe");
        }
     em.persist(doc);
    }
   
   public void crearSeccion (Seccion sec) throws ScoutsException{
       Seccion s = em.find(Seccion.class, sec.getId());
       if(s != null){
           throw new ScoutsException("ERROR: Esa seccion ya existe");
       }
       em.persist(sec);
   }
   
   //UPDATE
   
   public void updateUsuario(Usuario us){
       Usuario u = em.find(Usuario.class, us.getDNI());
       if(!u.equals(us)){
            u.setNombre(us.getNombre());
            u.setApellido1(us.getApellido1());
            u.setApellido2(us.getApellido2());
            u.setContrasena(us.getContrasena());
            u.setDNI(us.getDNI());
            u.setFecha_nacimiento(us.getFecha_nacimiento());
            //u.setEstado_perfil(us.getEstado_perfil());
            em.merge(u);
       }
       
   }
   
   public void updateEvento(Evento ev){
       Evento e = em.find(Evento.class, ev.getId());
       if(!e.equals(ev)){
           e.setSeccion(ev.getSeccion());
           e.setTitulo(ev.getTitulo());
           e.setDescripcion(ev.getDescripcion());
           e.setFechaInicio(ev.getFechaInicio());
           e.setFechaFin(ev.getFechaFin());
           e.setImagen(ev.getImagen());
           e.setTipoEvento(ev.getTipoEvento());
           
           em.merge(e);
       }
   }
   
   //LISTAS
   
   public List<Documentacion> getDocs(){
       //List<Documentacion> d = (List<Documentacion>) em.createQuery("Select d from Documentacion d ");
       List<Documentacion> d = em.createQuery("Select d from Documentacion d ").getResultList();
       
       return d;
   }
   
   public List<Usuario> getUsuario(){
       //List<Usuario> u = (List<Usuario>) em.createQuery("Select u from Usuario u ");
       List<Usuario> u = em.createQuery("SELECT u FROM Usuario u").getResultList();
       
       return u;
   }
   
   public List<Evento> getEvent(){
       //List<Evento> e = (List<Evento>) em.createQuery("Select e from Evento e");
       List<Evento> e = em.createQuery("Select e from Evento e").getResultList();
       return e;
   }
   
   public List<Seccion> getSeccion(){
       //List<Seccion> s = (List<Seccion>) em.createQuery("Select s from Seccion s");
       List<Seccion> s = em.createQuery("Select s from Seccion s").getResultList();
       return s;
   }
   
   
   //DELETE
   
   public void deleteEvento (Evento event) throws ScoutsException{
       Evento e = em.find(Evento.class, event.getId());
       
       if(e == null){
           throw new ScoutsException("ERROR: Ese evento no existe");
       }
       em.remove(event);
   }
   
   public void deleteUsuario (Usuario usuario ) throws ScoutsException{
     Usuario u = em.find(Usuario.class, usuario.getDNI());
     if (u == null) {
            throw new ScoutsException("ERROR: Ese usuario no existe");
        }
     em.remove(usuario);
    }
   
   public void deleteDocumento (Documentacion doc ) throws ScoutsException{
     Documentacion d = em.find(Documentacion.class, doc.getId());
     if (d == null) {
            throw new ScoutsException("ERROR: Ese usuario no existe");
        }
     em.remove(d);
    }
   
   public void deleteSeccion (Seccion sec) throws ScoutsException{
       Seccion s = em.find(Seccion.class, sec.getId());
       if(s == null){
           throw new ScoutsException("ERROR: Esa seccion no existe");
       }
       em.remove(sec);
   }
   
   
   
   //MOSTRAR LISTA DE ASISTENTES
   
   public List<Asistentes_Evento> getAsistentes(Evento e) throws ScoutsException{
       Evento ev1 = em.find(Evento.class, e.getId());
       if (e == null) {
            throw new ScoutsException("ERROR: Ese evento no existe");
        }
       return ev1.getAsistentes_evento();
       
       
     
   }
}
   
  
