/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sevenyearsofplenty;

import byui.cit260.sevenyearsofplenty.model.Game;
import byui.cit260.sevenyearsofplenty.model.Player;
import byui.cit260.sevenyearsofplenty.view.MainMenuView;
import java.util.logging.Level;

/**
 *
 * @author aj
 */
public class SevenYearsOfPlenty {
    
    private static Game theGame = new Game();
    private static Player thePlayer = new Player();

    private static printWriter outFile = null;
    private static bufferedReader inFile = null;

  
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            MainMenuView.onStartupView();
        } catch (Throwable te) {
            System.out.println(te.getMessage());
            te.printStackTrace();
            MainMenuView.onStartupView();          
        }
    }
    
       try {
        SevenYearsOfPlenty.inFile = new bufferedReader
        (new inputStreamReader(System.in));
        SevenYearsOfPlenty.outFile = new printWriter(System.out, true);
        
        StartProgramView startProgramView = new StartProgramView();
        startProgramView.display();
        return;
    } catch (throwable e) {
        System.out.println("exception: " +e.toString() +
                           "\nCause: " + e.getCause() +
                           "\nMessage: " + e.getMessage());
                    e.printStacktrace();;   
    } finally {
    
        try {
        SevenYearsOfPlenty.inFile.close();
        SevenYearsOfPlenty.outFile.close();
        } catch (IOException ex){
         Logger.getlogger(SevenYearsOfPlenty.class.getName()).log(Level.SEVERE);
        }
        }
        

    public static Game getGame() {
        return theGame;
    }

    public static void setGame(Game _theGame) {
        theGame = _theGame;
    }

    public static Player getPlayer() {
        return thePlayer;
    }

    public static void setPlayer(Player _thePlayer) {
        thePlayer = _thePlayer;
    }
    
    public static printWriter getOutFile() {
        return outFile;
    }

    public static void setOutFile(printWriter outFile) {
        SevenYearsOfPlenty.outFile = outFile;
    }
    
    public static bufferedReader getInFile() {
        return inFile;
    }
       
    public static void setInFile(bufferedReader inFile) {
        SevenYearsOfPlenty.inFile = inFile;
    }

 
}
