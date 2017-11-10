/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.sevenyearsofplenty.view;

import java.util.Scanner;

/**
 *
 * @author ajlane
 */
public abstract class MenuView implements MenuViewInterface {
    
    protected String displayMessage;
    protected int max;
    
    public MenuView() {
        
    }
    
    public MenuView(String message, int max) {
        this.displayMessage = message;
        this.max = max;
    }
    
    @Override
    public void display() {
       boolean display = true;
        int option;
        do
        {
            System.out.println(displayMessage);
            option = getMenuOption();
            if (option != max) {
                doAction(option);
            } else {
                display = false;
            }
        }while(display);
    }
    @Override
    public int getMenuOption()
    {
        Scanner keyboard = new Scanner(System.in);
        
        int inputValue = 0;
        
        do
        {
          System.out.print("Please enter an option:");
          inputValue = keyboard.nextInt();
          if(inputValue < 1 || inputValue > max)
          {
              System.out.println("Error: invalid option.");
          }
        } while(inputValue < 1 || inputValue > max);
        
        return inputValue;
    }
}
