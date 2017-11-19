/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.sevenyearsofplenty.view;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ajlan
 */
public class GameMenuView extends MenuView {
    
    public GameMenuView() {
        super("\n\n\nGAME MENU\n"
            + "1 - View the map\n"
            + "2 - View lists\n"
            + "3 - Move to a new location\n"
            + "4 - Manage crops\n"
            + "5 - Back to Main Menu\n\n\n", 5);
    }
        
    public void doAction(int option) {
        
        switch(option) {
            case 1: quit();
            break;
            case 2: quit();
            break;
            case 3: quit();
            break;
            case 4: {
            try {
                manageCropsView();
            } catch (InterruptedException ex) {
                Logger.getLogger(GameMenuView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            break;
            case 5:
                MainMenuView mainMenuView = new MainMenuView();
                mainMenuView.display();
            break;
        }
    }
    
    private static void quit() {
        
    }
    
    public static void manageCropsView () throws InterruptedException {
        CropsView.displayCropsReportView();
        CropsView.buyLandView();
        CropsView.sellLandView();
        CropsView.feedPeopleView();
        CropsView.plantCropsView();
        CropsView.harvestWheatView();
        CropsView.payPharoahView();
        CropsView.showStarvedView();
        CropsView.growPopulationView();
        CropsView.displayCropsReportView();
    }
}
