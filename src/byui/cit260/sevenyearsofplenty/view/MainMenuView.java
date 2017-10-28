/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.sevenyearsofplenty.view;

import static byui.cit260.sevenyearsofplenty.view.GameMenuView.manageCropsView;
import java.util.Scanner;

/**
 *
 * @author ajlan
 */
public class MainMenuView {
    
    private static final String MAIN_MENU = "\n\n\nMAIN MENU\n"
            + "1 - View the map\n"
            + "2 - View lists\n"
            + "3 - Move to a new location\n"
            + "4 - Manage crops\n"
            + "5 - Quit\n\n\n";
    
    private static final int MAX = 5;
    
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
            case 1: quit();
            break;
            case 2: quit();
            break;
            case 3: quit();
            break;
            case 4: manageCropsView();
            break;
            case 5: quit();
            break;
        }
    }
    
    private static void quit() {
        
    }
    
}
