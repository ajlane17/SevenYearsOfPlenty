/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.sevenyearsofplenty.view;

import java.util.Scanner;

/**
 *
 * @author ajlan
 */
public class HelpMenuView {
    
    private static final String HELP_MENU = "\n\n\nHELP MENU\n"
            + "1 - What are the goals of the game?\n"
            + "2 - Who is Joseph of Egypt?\n"
            + "3 - How do I view the map?\n"
            + "4 - How do I move to another location?\n"
            + "5 - How do I display a list of provisions and tools in the Pharoah's storehouse?\n"
            + "6 - Back to Main Menu\n\n\n";
    
    private static final int MAX = 6;
        
    public static void displayMainMenu()
    {
    
        int option;
        
        do
        {
            System.out.println(HELP_MENU);
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
            case 1: 
            break;
            case 2: 
            break;
            case 3: 
            break;
            case 4: 
            break;
            case 5:
            break;
            case 6: MainMenuView.displayMainMenu();
            break;
        }
    }    
    
}
