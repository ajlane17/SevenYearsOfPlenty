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
 * @author ajlane
 */
public class ErrorView {
    
    private static final PrintWriter ERROR_VIEW = SevenYearsOfPlenty.getOutFile();
    private static final PrintWriter LOG_FILE = SevenYearsOfPlenty.getLogFile();
    
    public static void display(String className, String errorMessage) {
        
        ERROR_VIEW.println(
            "-------------------------------------------------------------------"
          + "\n- ERROR - " + errorMessage
          + "\n-------------------------------------------------------------------");
        
        LOG_FILE.println(className + " - " + errorMessage);
    }
}
