/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Martin
 */

public class ScoutsException extends Exception{
    public ScoutsException() {
    }

    public ScoutsException(String msg) {
        super(msg);
    }
}
