/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.sevenyearsofplenty.view;

import java.lang.reflect.Array;
import java.io.PrintWriter;
import sevenyearsofplenty.SevenYearsOfPlenty;

/**
 *
 * @author ajlan
 */
public class LivestockView {
    
    protected static final PrintWriter console = SevenYearsOfPlenty.getOutFile();
    
    // Animals include name, count, and number of feet/hooves
    private static final String COWS_OBJ[] = {"Cows", "30", "4"};
    private static final String GOATS_OBJ[] = {"Goats", "15", "4"};
    private static final String SHEEP_OBJ[] = {"Sheep", "12", "4"};
    private static final String ALPACAS_OBJ[] = {"Alpacas", "5", "4"};
    private static final String CHICKENS_OBJ[] = {"Chickens", "7", "2"};
    
    enum Livestock {
        COWS(COWS_OBJ),
        GOATS(GOATS_OBJ),
        SHEEP(SHEEP_OBJ),
        ALPACAS(ALPACAS_OBJ),
        CHICKENS(CHICKENS_OBJ)
        ;
    
        private final String[] livestockValue;

        private Livestock(String[] livestockValue) {
            this.livestockValue = livestockValue;
        }
        
        public String[] getLivestockValue() {
            return this.livestockValue; 
        }
    }
    
    public static void showLivestockInventory() {
        
        String rowFormat = "\nAnimal: %-8s Count: %-3s";
        int feetOnTheGround = 0;
        String[] animal;
        int count = 0;
        int feet = 0;
        
        console.println("\n#############################\n"
                         + "#     Current Livestock     #\n"
                         + "#############################");
    
        for (Livestock livestock : Livestock.values()) {
            animal = livestock.getLivestockValue();
            count = Integer.parseInt(animal[1]);
            feet = Integer.parseInt(animal[2]);
            console.format(rowFormat, animal[0], animal[1]);
            feetOnTheGround = feetOnTheGround + (count * feet);
        }
        
        console.format("\nTotal feet on the ground: %d", feetOnTheGround);
    }
}
