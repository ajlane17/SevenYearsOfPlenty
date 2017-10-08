/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sevenyearsofplenty;

import byui.cit260.sevenyearsofplenty.model.Player;
import byui.cit260.sevenyearsofplenty.model.Crops;
import byui.cit260.sevenyearsofplenty.model.Game;
import byui.cit260.sevenyearsofplenty.model.InventoryItem;
import byui.cit260.sevenyearsofplenty.model.Location;
import byui.cit260.sevenyearsofplenty.model.PlayerMap;
/**
 *
 * @author aj
 */
public class SevenYearsOfPlenty {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Create a Player object
        Player playerOne = new Player();
        
        playerOne.setName("Fred Flinstone");
        
        String playerOneName = playerOne.getName();
        
        System.out.println(playerOne.toString());
        
        // Create a Crop object
        Crops cropsOne = new Crops();
        
        cropsOne.setAcres(5);
        cropsOne.setNewPeople(1000);
        
        System.out.println(cropsOne.toString());
        
        // Create a game object
        Game gameOne = new Game();
        
        gameOne.setCrops(cropsOne);
        
        System.out.println(gameOne.toString());
        
        
        // Create a location object
        Location location = new Location();
        
        location.setColumn(5);
        location.setRow(5);
        System.out.println(location.toString());
        
        //create PlayerMap object
        PlayerMap mapOne = new PlayerMap();
        
        mapOne.setRowCount(1);
        mapOne.setLocation(location);
        System.out.println(mapOne.toString());
        
        // Create an InventoryItem object
        InventoryItem inventoryItem = new InventoryItem();
        
        inventoryItem.setQuantity(23);
        System.out.println(inventoryItem.toString());
        
    }
    
}
