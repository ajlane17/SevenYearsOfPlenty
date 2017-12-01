/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sevenyearsofplenty;

import byui.cit260.sevenyearsofplenty.model.Game;
import byui.cit260.sevenyearsofplenty.model.Player;
import byui.cit260.sevenyearsofplenty.view.MainMenuView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aj
 */
public class SevenYearsOfPlenty {

    private static Game theGame = new Game();
    private static Player thePlayer = new Player();

    private static PrintWriter outFile = null;
    private static BufferedReader inFile = null;

    private static PrintWriter logFile = null;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            SevenYearsOfPlenty.inFile = 
                    new BufferedReader(new InputStreamReader(System.in));
            
            SevenYearsOfPlenty.outFile = new PrintWriter(System.out, true);

            String filePath = "log.txt";
            SevenYearsOfPlenty.logFile = new PrintWriter(filePath);
            
            MainMenuView.onStartupView();
            
            return;
        } catch (Throwable e) {
            System.out.println("exception: " + e.toString()
                    + "\nCause: " + e.getCause()
                    + "\nMessage: " + e.getMessage());
            e.printStackTrace();;
        } finally {
            try {
                if (SevenYearsOfPlenty.inFile != null)
                    SevenYearsOfPlenty.inFile.close();
                
                if (SevenYearsOfPlenty.outFile != null)
                    SevenYearsOfPlenty.outFile.close();
                
                if (SevenYearsOfPlenty.logFile != null)
                    SevenYearsOfPlenty.logFile.close();
            } catch (IOException ex) {
                System.out.println("Error closing files");
            }
            
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

    public static PrintWriter getOutFile() {
        return outFile;
    }

    public static void setOutFile(PrintWriter outFile) {
        SevenYearsOfPlenty.outFile = outFile;
    }

    public static BufferedReader getInFile() {
        return inFile;
    }

    public static void setInFile(BufferedReader inFile) {
        SevenYearsOfPlenty.inFile = inFile;
    }
    
    public static PrintWriter getLogFile() {
        return logFile;
    }
    
    public static void setLogFile(PrintWriter logFile) {
        SevenYearsOfPlenty.logFile = logFile;
    }

}
