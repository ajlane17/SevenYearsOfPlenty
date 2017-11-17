/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.sevenyearsofplenty.view;

import byui.cit260.sevenyearsofplenty.model.Location;
import byui.cit260.sevenyearsofplenty.model.PlayerMap;

/**
 *
 * @author ajlane
 */
public class MapView {
    
    public static void displayMap (PlayerMap map) {
        
        Location[][] locations = map.getLocation();
        
        for(Location[] arr2: locations) {
            for(Location val: arr2)
                System.out.println(val);
        }
    }
    
}
