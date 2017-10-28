/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.sevenyearsofplenty.control;

import byui.cit260.sevenyearsofplenty.model.Crops;
import byui.cit260.sevenyearsofplenty.model.Player;
import sevenyearsofplenty.SevenYearsOfPlenty;

/**
 *
 * @author ajlan
 */
public class GameControl {
    
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
        theCrops.setNewPeople(5);
        theCrops.setCropYield(3);
        theCrops.setNumberWhoDied(0);
        theCrops.setPharoahsShare(200);
        theCrops.setWheatInStore(2800);
        theCrops.setAcres(1000);
        theCrops.setHarvest(0);
        theCrops.setPlanted(1000);
        theCrops.setFed(0);

        SevenYearsOfPlenty.getGame().setCrops(theCrops);
    }
    
    public static void createPlayer(String playerName){
        SevenYearsOfPlenty.getPlayer().setName(playerName);
    }
}
