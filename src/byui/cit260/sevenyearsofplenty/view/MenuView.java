/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.sevenyearsofplenty.view;

/**
 *
 * @author ajlan
 */
public class MenuView {
    
    public static void displaySomeMenu()
    {
       int option;
        do
        {
            System.out.println(THE_MENU);
            option = getUserInput();
            doAction(option);
        }while(option != MAX);
    }
    
    public static int getMenuOption()
    {
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
}
