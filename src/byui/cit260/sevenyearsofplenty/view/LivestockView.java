/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.sevenyearsofplenty.view;

import java.io.FileWriter;
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
        
        StringBuilder report = new StringBuilder();
        
        String rowFormat = "Animal: %-8s Count: %-3s\r\n";
        int feetOnTheGround = 0;
        String[] animal;
        int count = 0;
        int feet = 0;
        
        String header = "\n#############################\r\n"
                         + "#     Current Livestock     #\r\n"
                         + "#############################\r\n";
        
        report.append(header);
        
        for (Livestock livestock : Livestock.values()) {
            animal = livestock.getLivestockValue();
            count = Integer.parseInt(animal[1]);
            feet = Integer.parseInt(animal[2]);
            report.append(String.format(rowFormat, animal[0], animal[1]));
            feetOnTheGround = feetOnTheGround + (count * feet);
        }
        
        report.append(String.format("\r\nTotal feet on the ground: %d\r\n", feetOnTheGround));
        
        console.print(report);
        
        saveLivestockReport(report);
        
    }
    
    private static void saveLivestockReport(StringBuilder report) {
        
        try(PrintWriter livestockReport = new PrintWriter(new FileWriter("livestock.txt"), true)) {
            livestockReport.print(report);
        } catch (Exception e) {
            ErrorView.display("livestockView", e.getMessage());
        }
    }
}
