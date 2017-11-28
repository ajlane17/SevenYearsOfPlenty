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
import java.util.Scanner;
import sevenyearsofplenty.SevenYearsOfPlenty;

/**
 *
 * @author ajlane
 */
public class MapView {

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
                            System.out.print("|");
                        }
                        System.out.format(rowFormat, locations[i][j].getRow(),
                                locations[i][j].getColumn());
                        if (j == locations[i].length - 1) {
                            System.out.print("\n");
                        }
                        // if row 2 or 4, blank row
                    } else if (n == 1 || n == 3) {
                        if (j == 0) {
                            System.out.print("|");
                        }
                        System.out.print("        |");
                        if (j == locations[i].length - 1) {
                            System.out.print("\n");
                        }
                        // draw the horizontal borders
                    } else if (n == 4 || (n == 0 && i == 0)) {
                        if (j == 0) {
                            System.out.print("+");
                        }
                        System.out.print("--------+");
                        if (j == locations[i].length - 1) {
                            System.out.print("\n");
                        }
                    }
                }
            }
        }

        // display locations
        for (Location[] location : locations) {
            for (Location details : location) {
                System.out.format("\n%d,%d: %s", details.getRow(),
                        details.getColumn(), details.getName());
            }
        }

        System.out.format("\n\nCurrent location: %d,%d", currentX, currentY);
        System.out.format("\nLocation Name: %s",
                locations[currentX][currentY].getName());
        System.out.format("\nLocation Description: %s",
                locations[currentX][currentY].getDescription());
    }

    public static void moveToLocation() {

        Scanner keyboard = new Scanner(System.in);
        Game theGame = SevenYearsOfPlenty.getGame();
        int xMax = theGame.getPlayerMap().getRowCount() - 1;
        int yMax = theGame.getPlayerMap().getColCount() - 1;
        int x = 0;
        int y = 0;
        boolean loop = true;

        do {
            System.out.print("Please enter X Coordinate: ");
            x = keyboard.nextInt();
            System.out.print("Please enter Y Coordinate: ");
            y = keyboard.nextInt();
            try {
                MapControl.moveToLocation(theGame.getPlayerMap(), x, y);
                loop = false;
            } catch (MapControlException me) {
                System.out.println(me.getMessage());
            }
        } while (loop);

    }
}
