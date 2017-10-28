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
public class MainMenuView {
    
        private static final String MAIN_MENU = "\n\n\nMAIN MENU\n"
            + "1 - Start a new game\n"
            + "2 - Load saved game\n"
            + "3 - Help\n"
            + "4 - Save game\n"
            + "5 - Quit\n\n\n";
    
    private static final int MAX = 5;
    
    private static boolean display = true;
    
    public static void displayMainMenu()
    {
        int option;
        do
        {
            System.out.println(MAIN_MENU);
            option = getMenuOption();
            if (option != MAX) {
                doAction(option);
            } else {
                display = false;
            }
        }while(display);
       
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
            case 1: CropsView.displayStartProgramView();
            break;
            case 2: 
            break;
            case 3: HelpMenuView.displayMainMenu();
            break;
            case 4: 
            break;
            case 5: MainMenuView.displayMainMenu();
            break;
        }
    }    
}
