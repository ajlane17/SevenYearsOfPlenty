/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.sevenyearsofplenty.view;

import byui.cit260.sevenyearsofplenty.control.GameControl;
import byui.cit260.sevenyearsofplenty.model.Game;
import java.util.Scanner;
import sevenyearsofplenty.SevenYearsOfPlenty;

/**
 *
 * @author ajlan
 */
public class StartMenuView {
    
    private static final String MAIN_MENU = "GAME MENU\n"
            + "1 - Start The Game\n"
            + "2 - Quit";
    
    private static final int MAX = 2;
    
    public static void displayGameMenu()
    {
       int option;
        do
        {
            System.out.println(MAIN_MENU);
            option = getMenuOption();
            doAction(option);
        }while(option != MAX);
    }
    
    private static int getMenuOption()
    {
        Scanner keyboard = new Scanner(System.in);
        
        int inputValue = 0;
        
        do
        {
          System.out.print("Please enter an option:");
          inputValue = keyboard.nextInt();
          if(inputValue < 1 || inputValue > MAX)
          {
              System.out.println("Error: invalid option.");
          }
        } while(inputValue < 1 || inputValue > MAX);
        
        return inputValue;
    }
    
    private static void doAction(int option) {
        
        switch(option) {
            case 1: startGame();
            break;
            case 2: quit();
            break;
        }
    }
    
    private static void startGame() {
        
        Game theGame = SevenYearsOfPlenty.getGame();
        GameControl.createCrops();
        
        System.out.println(theGame);
    }
    
    private static void quit() {
        
        System.out.println("Thanks for playing ... goodbye.");
    }
}
