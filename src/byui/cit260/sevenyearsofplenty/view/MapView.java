/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.sevenyearsofplenty.view;

import byui.cit260.sevenyearsofplenty.control.MapControl;
import byui.cit260.sevenyearsofplenty.exceptions.MapControlException;
import byui.cit260.sevenyearsofplenty.model.Game;
import byui.cit260.sevenyearsofplenty.model.Location;
import sevenyearsofplenty.SevenYearsOfPlenty;
import java.io.BufferedReader;
import java.io.PrintWriter;

/**
 *
 * @author ajlane
 */
public class MapView {
    
    protected static final BufferedReader keyboard = SevenYearsOfPlenty.getInFile();
    protected static final PrintWriter console = SevenYearsOfPlenty.getOutFile();


    public static void displayMap() {

        Game theGame = SevenYearsOfPlenty.getGame();

        Location[][] locations = theGame.getPlayerMap().getLocations();
        int currentX = theGame.getPlayerMap().getCurrLocationX();
        int currentY = theGame.getPlayerMap().getCurrLocationY();

        String rowFormat = "  %-2d,%-2d |";

        for (int i = 0; i < locations.length; i++) {
            // loop three times for each "row"
            for (int n = 0; n < 5; n++) {
                for (int j = 0; j < locations[i].length; j++) {
                    // If the middle row, include symbol
                    if (n == 2) {
                        if (j == 0) {
                            console.print("|");
                        }
                        console.format(rowFormat, locations[i][j].getRow(),
                                locations[i][j].getColumn());
                        if (j == locations[i].length - 1) {
                            console.print("\n");
                        }
                        // if row 2 or 4, blank row
                    } else if (n == 1 || n == 3) {
                        if (j == 0) {
                            console.print("|");
                        }
                        console.print("        |");
                        if (j == locations[i].length - 1) {
                            console.print("\n");
                        }
                        // draw the horizontal borders
                    } else if (n == 4 || (n == 0 && i == 0)) {
                        if (j == 0) {
                            console.print("+");
                        }
                        console.print("--------+");
                        if (j == locations[i].length - 1) {
                            console.print("\n");
                        }
                    }
                }
            }
        }

        // display locations
        for (Location[] location : locations) {
            for (Location details : location) {
                console.format("\n%d,%d: %s", details.getRow(),
                        details.getColumn(), details.getName());
            }
        }

        console.format("\n\nCurrent location: %d,%d", currentX, currentY);
        console.format("\nLocation Name: %s",
                locations[currentX][currentY].getName());
        console.format("\nLocation Description: %s",
                locations[currentX][currentY].getDescription());
    }

    public static void moveToLocation() {

        Game theGame = SevenYearsOfPlenty.getGame();
        int xMax = theGame.getPlayerMap().getRowCount() - 1;
        int yMax = theGame.getPlayerMap().getColCount() - 1;
        int x = 0;
        int y = 0;
        boolean loop = true;

        try {
            do {
                console.println("Please enter X Coordinate: ");
                x = Integer.parseInt(keyboard.readLine());;
                console.println("Please enter Y Coordinate: ");
                y = Integer.parseInt(keyboard.readLine());
                try {
                    MapControl.moveToLocation(theGame.getPlayerMap(), x, y);
                    loop = false;
                } catch (MapControlException me) {
                    ErrorView.display("ClassName",me.getMessage());
                }
            } while (loop);
        } catch (Exception e) {
            ErrorView.display("ClassName","Error reading input: " + e.getMessage());
        }

    }
}
