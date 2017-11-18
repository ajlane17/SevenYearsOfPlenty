/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.sevenyearsofplenty.view;

import java.lang.reflect.Array;

/**
 *
 * @author ajlan
 */
public class LivestockView {
    
    private static String cows[] = {"Cows", "30"};
    private static String goats[] = {"Goats", "15"};
    private static String sheep[] = {"Sheep", "12"};
    private static String alpacas[] = {"Alpacas", "5"};
    
    enum Livestock {
        COWS(cows),
        GOATS(goats),
        SHEEP(sheep),
        ALPACAS(alpacas)
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
        
        String rowFormat = "\nAnimal: %-10s Count: %-3s";
        
        System.out.println("\n#############################\n"
                         + "#     Current Livestock     #\n"
                         + "#############################\n");
    
        for (Livestock livestock : Livestock.values()) {
            System.out.format(rowFormat, livestock.getLivestockValue()[0], 
                    livestock.getLivestockValue()[1]);
        }
    }
}
