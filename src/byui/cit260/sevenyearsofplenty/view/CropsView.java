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
        GameMenuView gameMenuView = new GameMenuView();
        gameMenuView.display(); 

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
    }
    
    public static void sellLandView() {
         int toSell = 0;
         int price = CropsControl.calcLandCost();
                  
         int wheat = theGame.getCrops().getWheatInStore(); 
         int population = theGame.getCrops().getPopulation();
         int owned = theGame.getCrops().getAcres();
        do
        {
            System.out.print("\nHow many acres of land do you wish to sell? ");      
            toSell = keyboard.nextInt();
            
            if(toSell < 0)
            {
                System.out.println("I am sorry master, I cannot do this.");
                System.out.println("You cannot sell a negative amount of land.");
            }
            else if(toSell > owned)
            {
                System.out.println("I am sorry master, I cannot do this.");
                System.out.println("You don't have enough acres to sell.");
            }
            
        } while(toSell < 0 || toSell > owned) ;
        CropsControl.sellLand(price, toSell, theGame.getCrops());        
    }
    
    public static void feedPeopleView() {
        
    }
    
    public static void plantCropsView() {
        int bushelsToSpend = 0;
        int wheat = theGame.getCrops().getWheatInStore();
        int acres = theGame.getCrops().getAcres();
        
        System.out.println("REMINDER: Two acres can be planted per bushel.");
        
        do
        {
           System.out.print("\nHow many bushels would you like to use to plant? ");      
           bushelsToSpend = keyboard.nextInt();
           if(bushelsToSpend < 0)
           {
                System.out.println("I am sorry master, I cannot do this.");
                System.out.println("You cannot buy a negative amount of acres.");
            }
            else if (bushelsToSpend > wheat)
            {
                System.out.println("I am sorry master, I cannot do this.");
                System.out.println("You do not have enough wheat to buy this much land.");
            }
            else if (bushelsToSpend * 2 > acres)
            {
                System.out.println("I am sorry master, I cannot do this.");
                System.out.println("You cannot plant more acres than you have.");
            }
        } while(bushelsToSpend < 0 || bushelsToSpend > wheat || bushelsToSpend * 2 > acres);
        CropsControl.plantCrops(bushelsToSpend, theGame.getCrops());
        
    }
    
    public static void harvestWheatView() {
        
        System.out.println( "\n# THIS IS A REPORT OF THE HARVEST #");
        
        int rats = CropsControl.harvestCrops(theGame.getCrops());
        Crops theCropsObj = theGame.getCrops();
        int planted = theCropsObj.getPlanted();
        int cropYield = theCropsObj.getCropYield();
        int harvest = theCropsObj.getHarvest();
        
        
        System.out.format("You planted %2d acres and yielded %2d crops per acre.\n",
                planted, cropYield);
        System.out.format("Rates ate: %2d\n", rats);
        System.out.format("The harvest was: %2d\n\n", harvest);
    }
    
    public static void payPharoahView() {
        
        int pharoahsCut = CropsControl.payPharoah(theGame.getCrops());
        
        System.out.println("\n# PAYING PHAROAH #");
        System.out.println("The Pharoah is paid before the people are fed.");
        System.out.format("Pharoah took %2d bushels in taxes.\n\n", pharoahsCut);
        
    }


    public static void showStarvedView() {
        
    }
    
    public static void growPopulationView() {
        
    }
    
    public static void displayCropsReportView() {
        
        Crops theCrops = theGame.getCrops();
        
        System.out.println("###########################\n"
                         + "#       CROP REPORT       #\n"
                         + "###########################\n");
        System.out.format("YEAR: %2d\n", theCrops.getYear());
        System.out.format("POPULATION: %2d\n", theCrops.getPopulation());
        System.out.format("ACRES: %2d\n", theCrops.getAcres());
        System.out.format("CROP YIELD: %2d\n", theCrops.getCropYield());
        System.out.format("WHEAT IN STORE: %2d\n", theCrops.getWheatInStore());
        System.out.format("HARVEST: %2d\n", theCrops.getHarvest());
        System.out.format("PHAROAH'S SHARE: %2d\n", theCrops.getPharoahsShare());
        System.out.format("FED: %2d\n", theCrops.getFed());
        System.out.format("PLANTED: %2d\n", theCrops.getPlanted());
        System.out.format("STARVED PEOPLE: %2d\n", theCrops.getStarvedPeople());
    }

}
