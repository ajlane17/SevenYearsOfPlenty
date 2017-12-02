/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.sevenyearsofplenty.control;

import byui.cit260.sevenyearsofplenty.exceptions.MapControlException;
import byui.cit260.sevenyearsofplenty.model.Location;
import byui.cit260.sevenyearsofplenty.model.PlayerMap;
import java.io.PrintWriter;
import sevenyearsofplenty.SevenYearsOfPlenty;


/**
 *
 * @author ajlane
 */
public class MapControl {
    
    protected static final PrintWriter console = SevenYearsOfPlenty.getOutFile();

    private static String[][] locationInfo = {
        {"Pharoah's Court", "Could be the main menu"},
        {"Pharoah's Granary", "Provides inventory and supplies"},
        {"Wheat Field", "A beautiful wheat field"},
        {"Corn Field", "There is so much corn here"},
        {"Barley Field", "The barley crops look good"},
        {"Undeveloped Land", "Perhaps we could add more acres of grain here"},
        {"Desert", "There is not enough water to grow crops here"},
        {"Village", "This is where the people live. I wonder if they are "
            + "getting enough food"},
        {"Cattle Field", "It's good that the cattle has plenty of "
            + "grass to eat"},
        {"Stables", "The pharoah has many horses and donkeys"},
        {"Sheep and Goat Field", "It's good that the sheep and goats have"
            + " plenty of grass to eat"},
        {"Pig Sty", "The pig sty needs some cleaning. It's starting to "
            + "smell bad"},
        {"Tool Workshop", "We need to sharpen and repair our tools"},
        {"Nile River", "Be careful of the crocodiles"},
        {"Joseph's Office", "Could be the game menu"},
        {"Overseer's Office", "Could be the manage crops view"},
        {"Overseer's Home", "We have no time to rest until the harvest "
            + "is over"},
        {"Pyramids in Giza", "This is no time to site see"},
        {"King's Treasury", "Only Joseph and Pharoah are allowed"},
        {"Marshes", "Beautiful. Is a baby in a basket floating by?"},
        {"Library", "Could be the help menu"},
        {"Temple", "Receive extra help"},
        {"Jeweler's Shop", "Don't waste time buting jewelry"},
        {"Captain of the Military", "Can you take care of the bandits?"},
        {"Pest Control Office", "What about these rats?"}
    };

    public static void createLocations(PlayerMap map, int rows, int columns) {
        Location[][] locations = new Location[rows][columns];
        int symbol = 1;
        int n = 0;

        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                locations[i][j] = new Location();
                locations[i][j].setRow(i);
                locations[i][j].setColumn(j);
                locations[i][j].setName(locationInfo[n][0]);
                locations[i][j].setDescription(locationInfo[n][1]);
                locations[i][j].setSymbol(Integer.toString(symbol));
                symbol++;
                n++;
            }
        }

        map.setLocations(locations);
        map.setCurrLocationX(0);
        map.setCurrLocationY(0);
        map.setRowCount(rows);
        map.setColCount(columns);
    }

    public static void moveToLocation(PlayerMap map, int row, int column)
            throws MapControlException {
        int rowCount = map.getRowCount();
        int colCount = map.getColCount();

        if (row < 0 || row >= rowCount || column < 0 || column >= colCount) {
            throw new MapControlException("Can't move to location " + row + ","
                    + column + " becuase that location does not exist.");
        }

        map.setCurrLocationX(row);
        map.setCurrLocationY(column);
        Location[][] location = map.getLocations();
        String name = location[row][column].getName();
        String description = location[row][column].getDescription();
        console.format("\nLocation: %s", name);
        console.format("\nDescription: %s", description);
    }

}
