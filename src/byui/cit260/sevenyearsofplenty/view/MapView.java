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
        String rowFormat = "   %-4s |";
        
        for(int i =0; i < locations.length; i++) {
            // loop three times for each "row"
            for (int n = 0; n < 5; n++) {
                for(int j =0; j < locations[i].length; j++) {
                    // If the middle row, include symbol
                    if (n == 2) {
                        if (j == 0) {
                            System.out.print("|");
                        }
                        System.out.format(rowFormat, locations[i][j].getSymbol());
                        if (j == locations[i].length - 1) {
                            System.out.print("\n");                        
                        }
                    // if row 2 or 4, blank row
                    } else if (n == 1 || n == 3){
                        if (j == 0) {
                            System.out.print("|");
                        }
                        System.out.print("        |");
                        if (j == locations[i].length - 1) {
                            System.out.print("\n");
                        }
                    // draw the horizontal borders
                    } else if (n == 4 || (n == 0 && i == 0)){
                        if (j == 0) {
                            System.out.print("+");
                        }                        
                        System.out.print("--------+");
                        if (j == locations[i].length - 1) {
                            System.out.print("\n");
                        }
                    }
                }
            }
        }
        
        System.out.println("\nCurrent location: 1");
        // TODO: include the logic to get the current location
        
        // display locations
        for(Location[] location: locations) { 
            for(Location details: location) 
                System.out.format("\n%-2s: %s", details.getSymbol(), "Location Name"); 
        } 
    }
}
