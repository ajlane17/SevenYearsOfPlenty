/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.sevenyearsofplenty.view;

import byui.cit260.sevenyearsofplenty.model.Game;
import byui.cit260.sevenyearsofplenty.model.Location;
import sevenyearsofplenty.SevenYearsOfPlenty;

/**
 *
 * @author ajlane
 */
public class MapView {
    
    public static void displayMap () {
        
        Game theGame = SevenYearsOfPlenty.getGame();
        
        Location[][] locations = theGame.getPlayerMap().getLocation();
        
        for(Location[] arr2: locations) {
            for(Location val: arr2)
                System.out.println(val);
        }
    }
    
}
