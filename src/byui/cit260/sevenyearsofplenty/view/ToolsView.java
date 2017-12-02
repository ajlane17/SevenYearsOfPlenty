/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.sevenyearsofplenty.view;

import java.io.PrintWriter;
import sevenyearsofplenty.SevenYearsOfPlenty;

/**
 *
 * @author vmarcos
 */
public class ToolsView {
    
    protected static final PrintWriter console = SevenYearsOfPlenty.getOutFile();
    
     public static void displayTools () {
         String[] tools = {"1 - Shovel","2 - Hoe","3 - Rake","4 - Pruning shears",
        "5 - Almocafre","6 - Wheelbarrow","7 - Watering can"};
         
         
        console.println("##############################\n"
                         + "# WELCOME TO TOOL MAKER SHOP #\n"
                         + "##############################\n");
        int counter = 0;
        while(counter < tools.length){
            console.println(tools[counter]);
            counter++;
        }
         
     }
}


