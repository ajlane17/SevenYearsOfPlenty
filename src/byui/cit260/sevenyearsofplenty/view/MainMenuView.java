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
    
    public static void displayMainMenu()
    {
        boolean display = true;
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

    public static void onStartupView() {
        
        System.out.println("                        WELCOME TO PHARAOH'S COURT\n"
                + "You  have been summoned here to assume your  new  role as Agricultural Overseer.\n"
                + "You  report  directly  to  Joseph, Pharaoh’s  Vizier. Your responsibility  is to\n"
                + "gather  the grain  from  the harvest, provide enough  food to the people so they\n"
                + "do not go  hungry, and reserve the  rest in Pharaoh’s granary in preparation for\n"
                + "the prophesied famine that is to come in seven years.\n"
                + "\n"
                + "You  need to know  how to plant crops,  develop  land, feed the people and store\n"
                + "the excess. If you fail to provide  enough food for  the people, the people will\n"
                + "starve.  Some  people will die. Your  workforce will be diminished, and you will\n"
                + "not have  enough workers to plant  and  harvest crops. Pharaoh is not be pleased\n"
                + "with those who fail him. Those who fail are thrown in prison. He's not very nice\n"
                + "to prisoners -- just ask the Royal Baker.\n"
                + "Oh, you can't because he's not around anymore. RIP.\n"
                + "\n");
        
        displayMainMenu();
        
    }
}
