/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

/**
 *
 * @author Eloy
 */
public class UsuarioExcepcion extends Exception {

    public UsuarioExcepcion(String e) {
        super(e);
    }
    
    public UsuarioExcepcion(){
        super();
    }
    
}
