/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sevenyearsofplenty;

import byui.cit260.sevenyearsofplenty.model.Game;
import byui.cit260.sevenyearsofplenty.model.Player;
import byui.cit260.sevenyearsofplenty.view.MainMenuView;

/**
 *
 * @author aj
 */
public class SevenYearsOfPlenty {
    
    private static Game theGame = new Game();
    private static Player thePlayer = new Player();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MainMenuView.displayMainMenu();
    }
    public static Game getGame() {
        return theGame;
    }
    
    public static Player getPlayer() {
        return thePlayer;
    }
        
}
