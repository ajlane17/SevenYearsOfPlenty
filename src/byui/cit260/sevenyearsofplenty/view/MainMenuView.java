/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.sevenyearsofplenty.view;

import byui.cit260.sevenyearsofplenty.control.GameControl;
import java.io.BufferedReader;
import java.io.PrintWriter;
import sevenyearsofplenty.SevenYearsOfPlenty;

/**
 *
 * @author ajlans
 */
public class MainMenuView extends MenuView {

    protected static final PrintWriter console = SevenYearsOfPlenty.getOutFile();
    protected static final BufferedReader keyboard = SevenYearsOfPlenty.getInFile();

    public MainMenuView() {
        super("\n\n\nMAIN MENU\n"
                + "1 - Start a new game\n"
                + "2 - Load saved game\n"
                + "3 - Help\n"
                + "4 - Save game\n"
                + "5 - Quit\n\n\n", 5);
    }

    public void doAction(int option) {

        switch (option) {
            case 1:
                CropsView.displayStartProgramView();
                break;
            case 2:
                startSavedGame();
                break;
            case 3:
                HelpMenuView helpMenuView = new HelpMenuView();
                helpMenuView.display();
                break;
            case 4:
                saveGame();
                break;
            case 5:
                MainMenuView mainMenuView = new MainMenuView();
                mainMenuView.display();
                break;
        }
    }

    public static void onStartupView() {

        console.println("                       WELCOME TO PHARAOH'S COURT\n"
                + "You  have been summoned here to assume your  new  role as "
                + "Agricultural Overseer.\n"
                + "You  report  directly  to  Joseph, Pharaoh’s  Vizier. Your "
                + "responsibility  is to\n"
                + "gather  the grain  from  the harvest, provide enough  food "
                + "to the people so they\n"
                + "do not go  hungry, and reserve the  rest in Pharaoh’s "
                + "granary in preparation for\n"
                + "the prophesied famine that is to come in seven years.\n"
                + "\n"
                + "You  need to know  how to plant crops,  develop  land, feed "
                + "the people and store\n"
                + "the excess. If you fail to provide  enough food for  the "
                + "people, the people will\n"
                + "starve.  Some  people will die. Your  workforce will be "
                + "diminished, and you will\n"
                + "not have  enough workers to plant  and  harvest crops. "
                + "Pharaoh is not be pleased\n"
                + "with those who fail him. Those who fail are thrown in "
                + "prison. He's not very nice\n"
                + "to prisoners -- just ask the Royal Baker.\n"
                + "Oh, you can't because he's not around anymore. RIP.\n"
                + "\n");

        MainMenuView mainMenuView = new MainMenuView();
        mainMenuView.display();

    }

    private static void saveGame() {

        String filePath = null;
        console.println("\n\nEnter a file name for the saved game file:");

        try {
            filePath = keyboard.readLine();
            filePath = filePath.trim();
            GameControl.saveGame(filePath);
        } catch (Exception e) {
            ErrorView.display("saveGame", e.getMessage());
        }
    }

    private static void startSavedGame() {
        String filePath = null;
        console.println("\n\nEnter the file name for the saved game file:");

        try {
            filePath = keyboard.readLine();
            filePath = filePath.trim();
            GameControl.getSavedGame(filePath);
        } catch (Exception e) {
            ErrorView.display("saveGame", e.getMessage());
        }

        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }
}
