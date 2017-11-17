/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.sevenyearsofplenty.view;

import byui.cit260.sevenyearsofplenty.model.Game;
import sevenyearsofplenty.SevenYearsOfPlenty;

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
            case 1: mapView();
            break;
            case 2: quit();
            break;
            case 3: quit();
            break;
            case 4: manageCropsView();
            break;
            case 5:
                MainMenuView mainMenuView = new MainMenuView();
                mainMenuView.display();
            break;
        }
    }
    
    private static void quit() {
        
    }
    
    public static void manageCropsView () {
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
    
    public static void mapView() {
        
        MapView.displayMap();
        
    }
}
