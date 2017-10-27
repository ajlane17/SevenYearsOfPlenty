/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.sevenyearsofplenty.view;

import byui.cit260.sevenyearsofplenty.model.Crops;
import byui.cit260.sevenyearsofplenty.model.Game;
import byui.cit260.sevenyearsofplenty.control.CropsControl;
import java.util.Scanner;
        

/**
 *
 * @author ajlan
 */
public class CropsView {
    
    // Create a Scanner object
    private static Scanner keyboard = new Scanner(System.in);
    
    // Get references to the Game object and the Crops object
    private static Game theGame = MyGameProject.getGame();
    private static Crops theCrop = MyGameProject.getCrops();

    public static void buyLandView()
    {
         int toBuy = 0;
         int price = CropsControl.calcLandCost();
         System.out.format("Land is selling for %d bushels per acre.%n",price);

         int wheat = theCrop.getWheatInStore(); 
         int population = theCrop.getPopulation();
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
        CropsControl.buyLand(price, toBuy, theCrop);
    }

}
