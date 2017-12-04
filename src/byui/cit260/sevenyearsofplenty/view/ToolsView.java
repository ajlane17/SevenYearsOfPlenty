/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.sevenyearsofplenty.view;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import sevenyearsofplenty.SevenYearsOfPlenty;

/**
 *
 * @author vmarcos
 */
public class ToolsView {
    
    protected static final PrintWriter console = SevenYearsOfPlenty.getOutFile();
    
     public static void displayTools () {
         
         StringBuilder report = new StringBuilder();
         
        String rowFormat = "Tool: %-8s" ;
        int counter = 0;
              
         String[] tools = {"1 - Shovel","2 - Hoe","3 - Rake","4 - Pruning shears",
        "5 - Almocafre","6 - Wheelbarrow","7 - Watering can"};
         
                         
        String header = "##############################\n"
                         + "# WELCOME TO TOOL MAKER SHOP #\n"
                         + "##############################\n" ;
        report.append(header);            
       
        while(counter < tools.length){
            console.println(tools[counter]);
            counter++;
            saveToolsReport(report);
        }
        
        report.append(tools);
     }
     
     private static void saveToolsReport(StringBuilder report) {
        
        try(PrintWriter toolsReport = new PrintWriter(new FileWriter("tools.txt"), true)) {
            toolsReport.print(report);
        } catch (Exception e) {
            ErrorView.display("toolsView", e.getMessage());
        }
    }
}


