/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.sevenyearsofplenty.model;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Adrian, Dennis, Vanessa
 */
public class Game {
    
    // Define instance variables
    private Crops crops;

    private InventoryItem inventoryItem;

    private Player_map Player_map;

    private ArrayList<InventoryItem> inventoryItem = new ArrayList<InventoryItem>();

    
    public Game() {
    }
    

    public Crops getCrops() {
        return crops;
    }

    public void setCrops(Crops crops) {
        this.crops = crops;
    }

    public ArrayList<InventoryItem> getInventoryItem() {
        return inventoryItem;
    }

    public void setInventoryItem(ArrayList<InventoryItem> inventoryItem) {
        this.inventoryItem = inventoryItem;
    }
    

    public Player_map getPlayer_map() {
        return Player_map;
    }

    public void setPlayer_map(Player_map Player_map) {
        this.Player_map = Player_map;
    }
}
