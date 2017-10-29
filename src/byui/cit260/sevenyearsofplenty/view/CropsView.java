/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.sevenyearsofplenty.view;

import byui.cit260.sevenyearsofplenty.control.CropsControl;
import byui.cit260.sevenyearsofplenty.control.GameControl;
import byui.cit260.sevenyearsofplenty.model.Crops;
import byui.cit260.sevenyearsofplenty.model.Game;
import java.util.Scanner;
import sevenyearsofplenty.SevenYearsOfPlenty;
        

/**
 *
 * @author ajlan
 */
public class CropsView {
    
    // Create a Scanner object
    private static Scanner keyboard = new Scanner(System.in);
    
    // Get references to the Game object and the Crops object
    private static Game theGame = SevenYearsOfPlenty.getGame();

    // The startProgramView method
    // Purpose: Start the game
    // Parameters: None
    // Returns: none
    public static void displayStartProgramView()
    {
        String playerName = getPlayersName();
        GameControl.createPlayer(playerName);

        GameControl.createCrops();

        System.out.println("\n\n\n\n");
        System.out.println(playerName + ", you have been appointed overseer for your");
        System.out.println("village. Tread carefully, if your people are not fed well");
        System.out.println("you may lose your head.");
        
        displayNextView();
    }
    
     public static void displayNextView()
    {
        GameMenuView.displayGameMenu(); 

        // control returns to this point when user exits main menu
        // goodbye message
        System.out.println("Goodbye ... thanks for playing.");
    }
    
    public static String getPlayersName()
    {
        String playerName = "";
        Scanner keyboard = new Scanner(System.in);
        do
        {
            System.out.print("Please enter your name: ");
            playerName = keyboard.nextLine();
            playerName = playerName.trim();
            if(playerName.length() < 2) // must have at least 2 characters
                System.out.println("Invalid input: name must be at least 2 characters");

        } while(playerName.length() < 2);  // must have at least 2 characters

        return playerName;
    }
    
    public static void displayCurrentStatus () {
        // TODO: Prettify the output
        System.out.println(theGame.getCrops());
    }
    
    public static void buyLandView()
    {
         int toBuy = 0;
         int price = CropsControl.calcLandCost();
         System.out.format("Land is selling for %d bushels per acre.%n",price);

         int wheat = theGame.getCrops().getWheatInStore(); 
         int population = theGame.getCrops().getPopulation();
        do
        {
           System.out.print("\nHow many acres of land do you wish to buy? ");      
           toBuy = keyboard.nextInt();
           if(toBuy < 0)
           {
                 System.out.println("I am sorry master, I cannot do this.");
                 System.out.println("You cannot buy a negative amount of land.");
            }
            else if(toBuy * price > wheat)
            {
                  System.out.println("I am sorry master, I cannot do this.");
                  System.out.println("You do not have enough wheat to buy this much land.");
             }
        } while(toBuy < 0 || toBuy * price > wheat);
        CropsControl.buyLand(price, toBuy, theGame.getCrops());
        displayCurrentStatus();
    }

}
