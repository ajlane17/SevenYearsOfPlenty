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
public class HelpMenuView extends MenuView {
    
    public HelpMenuView() {
    super("\n\n\nHELP MENU\n"
        + "1 - What are the goals of the game?\n"
        + "2 - Who is Joseph of Egypt?\n"
        + "3 - How do I view the map?\n"
        + "4 - How do I move to another location?\n"
        + "5 - How do I display a list of provisions and tools in the Pharoah's storehouse?\n"
        + "6 - Back to Main Menu\n\n\n", 6);
    }
   
    public void doAction(int option) {
        
        switch(option) {
            case 1: 
            break;
            case 2: helpJoseph();
            break;
            case 3: 
            break;
            case 4: 
            break;
            case 5:
            break;
            case 6:
                MainMenuView mainMenuView = new MainMenuView();
                mainMenuView.display();
            break;
        }
    }

    public static void helpJoseph() {
        System.out.println("Joseph help goes here");
    }
    
}
