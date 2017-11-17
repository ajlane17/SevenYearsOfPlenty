/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.sevenyearsofplenty.control;

import byui.cit260.sevenyearsofplenty.model.Crops;
import byui.cit260.sevenyearsofplenty.model.Game;
import byui.cit260.sevenyearsofplenty.model.Player;
import byui.cit260.sevenyearsofplenty.model.PlayerMap;
import byui.cit260.sevenyearsofplenty.control.MapControl;
import sevenyearsofplenty.SevenYearsOfPlenty;

/**
 *
 * @author ajlan
 */
public class GameControl {
    
    private static Player thePlayer = SevenYearsOfPlenty.getPlayer();
    private static Game theGame = SevenYearsOfPlenty.getGame();
    
   // The createCrops method
    // Purpose: to create a Crops object for the game
    // Parameters: none
    // Returns: none
    public static void createCrops()
    {
        Crops theCrops = new Crops();
        
        // initialize the data in the crops object     
        theCrops.setYear(0);
        theCrops.setPopulation(95);
        theCrops.setCropYield(3);
        theCrops.setPharoahsShare(200);
        theCrops.setWheatInStore(2800);
        theCrops.setAcres(1000);
        theCrops.setHarvest(0);
        theCrops.setPlanted(1000);
        theCrops.setFed(0);
        theCrops.setStarvedPeople(0);

        theGame.setCrops(theCrops);
    }
    
    public static void createPlayer(String playerName){
        thePlayer.setName(playerName);
    }
    
    public static void createPlayerMap(int rows, int columns) {
        
        PlayerMap thePlayerMap = new PlayerMap();
        thePlayerMap.setRowCount(rows);
        thePlayerMap.setColCount(columns);
        MapControl.createLocations(thePlayerMap, rows, columns);
        theGame.setPlayerMap(thePlayerMap);
    }
    
}
