/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.sevenyearsofplenty.view;

import java.io.BufferedReader;
import java.io.PrintWriter;
import sevenyearsofplenty.SevenYearsOfPlenty;

/**
 *
 * @author ajlane
 */
public abstract class MenuView implements MenuViewInterface {
    
    protected String displayMessage;
    protected int max;
    
    protected final BufferedReader keyboard = SevenYearsOfPlenty.getInFile();
    protected final PrintWriter console = SevenYearsOfPlenty.getOutFile();
    
    public MenuView() {
        
    }
    
    public MenuView(String _message, int _max) {
        displayMessage = _message;
        max = _max;
    }
    
    @Override
    public void display() {
       boolean display = true;
        int option;
        do
        {
            console.println(this.displayMessage);
            option = this.getMenuOption();
            if (option != max) {
                this.doAction(option);
            } else {
                display = false;
            }
        }while(display);
    }
    @Override
    public int getMenuOption()
    {
        
        int inputValue = 0;
        
        try {       
            do
            {
              console.println("Please enter an option:");
              inputValue = Integer.parseInt(keyboard.readLine());
              if(inputValue < 1 || inputValue > max)
              {
                  console.println("Error: invalid option.");
              }
            } while(inputValue < 1 || inputValue > max);
        } catch (Exception e) {
            console.println("Error reading input: " + e.getMessage());
        }
        
        return inputValue;
    }
}
