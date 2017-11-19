/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.sevenyearsofplenty.view;

/**
 *
 * @author vmarcos
 */
public class ToolsView {
     public static void displayTools () {
         String[] tools = {"1 - Shovel","2 - Hoe","3 - Rake","4 - Pruning shears",
        "5 - Almocafre","6 - Wheelbarrow","7 - Watering can"};
         
         
        System.out.println("##############################\n"
                         + "# WELCOME TO TOOL MAKER SHOP #\n"
                         + "##############################\n");
        int counter = 0;
        while(counter < tools.length){
            System.out.println(tools[counter]);
            counter++;
        }
         
     }
}


