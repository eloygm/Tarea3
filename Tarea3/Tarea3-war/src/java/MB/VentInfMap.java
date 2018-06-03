/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MB;

import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;

  
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
  

@ViewScoped
public class VentInfMap implements Serializable {
      
    private MapModel simpleModel;
  
    private Marker marker;
  
    @PostConstruct
    public void init() {
        simpleModel = new DefaultMapModel();
          
        //Shared coordinates
        LatLng coord1 = new LatLng(36.697194, -4.459667);//"https://plus.google.com/photos/photo/102685774804189455856/6421432719869972322"
          
        //Icons and Data
        simpleModel.addOverlay(new Marker(coord1, "Grupo 39 Scout Santo Angel", "../datos/2017-05-18.jpg"));
        
        
        
    }
  
    public MapModel getSimpleModel() {
        return simpleModel;
    }
}