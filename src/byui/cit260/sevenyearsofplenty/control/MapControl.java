/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.sevenyearsofplenty.control;

import byui.cit260.sevenyearsofplenty.model.Location;
import byui.cit260.sevenyearsofplenty.model.PlayerMap;

/**
 *
 * @author ajlane
 */
public class MapControl {
    
    public static void createLocations(PlayerMap map, int rows, int columns) {
        Location[][] locations = new Location[rows][columns];
        
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                locations[i][j] = new Location();
                locations[i][j].setRow(i);
                locations[i][j].setColumn(j);
                
            }
        }
        
        map.setLocation(locations);
    }
    
}
