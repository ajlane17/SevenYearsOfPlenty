/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.sevenyearsofplenty.view;

import byui.cit260.sevenyearsofplenty.control.CropsControl;
import byui.cit260.sevenyearsofplenty.control.GameControl;
import byui.cit260.sevenyearsofplenty.exceptions.CropsControlException;
import byui.cit260.sevenyearsofplenty.model.Crops;
import byui.cit260.sevenyearsofplenty.model.Game;
import java.util.Random;
//import java.util.concurrent.TimeUnit;
import sevenyearsofplenty.SevenYearsOfPlenty;
import java.io.BufferedReader;
import java.io.PrintWriter;

/**
 *
 * @author ajlan
 */
public class CropsView {

    // Get references to the Game object and the Crops object
    private static Game theGame = SevenYearsOfPlenty.getGame();

protected static final BufferedReader keyboard = SevenYearsOfPlenty.getInFile();
protected static final PrintWriter console = SevenYearsOfPlenty.getOutFile();

    // The startProgramView method
    // Purpose: Start the game
    // Parameters: None
    // Returns: none
    public static void displayStartProgramView() {
        String playerName = getPlayersName();
        GameControl.createPlayer(playerName);
        GameControl.createCrops();
        GameControl.createPlayerMap(5, 5);
        
        console.println("\n\n\n\n");
        console.println(playerName + ", you have been appointed "
                + "overseer for your");
        console.println("village. Tread carefully, if your people are not "
                + "fed well");
        console.println("you may lose your head.");

        displayNextView();
    }

    public static void displayNextView() {
        GameMenuView gameMenuView = new GameMenuView();
        gameMenuView.display();

        // control returns to this point when user exits main menu
        // goodbye message
        console.println("Goodbye ... thanks for playing.");
    }

    public static String getPlayersName() {
        String playerName = null;
        try {
            do {
                console.println("Please enter your name: ");
                playerName = keyboard.readLine();
                playerName = playerName.trim();
                if (playerName.length() < 2) // must have at least 2 characters
                {
                    console.println("Invalid input: name must be at least "
                            + "2 characters");
                }

            } while (playerName.length() < 2);// must have at least 2 characters
        } catch (Exception e) {
            console.println("Error reading input: " + e.getMessage());
        }
        return playerName;
    }

    public static void buyLandView() {
        int toBuy = 0;
        int price = CropsControl.calcLandCost();
        console.format("Land is selling for %d bushels per acre.%n", price);

        int wheat = theGame.getCrops().getWheatInStore();
        int population = theGame.getCrops().getPopulation();

        try {
            do {
                console.println("\nHow many acres of land do you wish "
                        + "to buy? ");
                toBuy = Integer.parseInt(keyboard.readLine());
                if (toBuy < 0) {
                    console.println("I am sorry master, I cannot do this.");
                    console.println("You cannot buy a negative amount of "
                            + "land.");
                } else if (toBuy * price > wheat) {
                    console.println("I am sorry master, I cannot do this.");
                    console.println("You do not have enough wheat to buy this "
                            + "much land.");
                }
            } while (toBuy < 0 || toBuy * price > wheat);
        } catch (Exception e) {
            console.println("Error reading input: " + e.getMessage());
        }

        try {
            CropsControl.buyLand(price, toBuy, theGame.getCrops());
        } catch (CropsControlException e) {
            console.println("I am sorry master, I cannot do this.");
            console.println(e.getMessage());
        }
    }

    public static void sellLandView() {
        int toSell = 0;
        int price = CropsControl.calcLandCost();
        Game theGame = SevenYearsOfPlenty.getGame();
        boolean paramsNotOkay = false;
        int wheat = theGame.getCrops().getWheatInStore();
        int population = theGame.getCrops().getPopulation();
        int owned = theGame.getCrops().getAcres();

        try {
            do {
                console.println("\nHow many acres of land do you wish to "
                        + "sell? ");
                toSell = Integer.parseInt(keyboard.readLine());
                try {
                    CropsControl.sellLand(price, toSell, theGame.getCrops());
                } catch (CropsControlException e) {
                    console.println("I am sorry master, I cannot do this.");
                    console.println(e.getMessage());
                    paramsNotOkay = true;
                }
            } while (paramsNotOkay);
        } catch (Exception e) {
            console.println("Error reading input: " + e.getMessage());
        }

    }

    public static void feedPeopleView() throws InterruptedException {
        int reqNutrition = 20;
        int bushels = 0;
        int Population = theGame.getCrops().getPopulation();
                TimeUnit.SECONDS.sleep(1);
        console.println("\n\n# You must feed the People #\n\n");
                TimeUnit.SECONDS.sleep(1);
        console.println("Your attention is required, as "
                + "We must allocate rations for the People.");
                TimeUnit.SECONDS.sleep(1);
        console.println("You must decide how much You will feed the People."
        );
                TimeUnit.SECONDS.sleep(1);
        console.println("You should enter a whole number for the bushels that "
                + "will be distributed for the year.");
                TimeUnit.SECONDS.sleep(1);
        console.println("please enter Your decision : ");
        try {
            bushels = Integer.parseInt(keyboard.readLine());
        } catch (Exception e) {
            console.println("Error reading input: " + e.getMessage());
        }
        boolean exit = false;
        //TimeUnit.SECONDS.sleep(1);
        console.println("You have decided to feed " + bushels + " bushels to "
                + Population + " People for this year, \nenter 'y' if "
                + "You agree,"
                + " and 'n', if You would like to re-enter Your decision : "
                + "or 'make it so' for fun");

        try {
            do {
                String word = keyboard.readLine();
                word = word.trim();
                char letter = word.charAt(0);

                //TimeUnit.SECONDS.sleep(1);
                switch (letter) {
                    case 'y':
                        try {
                            CropsControl.feedPeople(reqNutrition, bushels, 
                                    theGame.getCrops());
                        } catch (CropsControlException e) {
                            console.println("I am sorry master, I cannot do "
                                    + "this.");
                            console.println(e.getMessage());
                        }

                        int testPopulation = theGame.getCrops().getPopulation();
                        console.println("the Population is : " + testPopulation 
                                + "after"
                                + "calling the feedPeople method.");
                        int theStarved = theGame.getCrops().getStarvedPeople();
                        int fedPeople = theGame.getCrops().getFed();
                        console.println("theStarved = " + theStarved);
                        console.println("fedPeople = " + fedPeople);
                        exit = true;
                        break;
                    case 'n':
                        console.println("please choose another amount\n");
                        console.println("You should enter a whole number of "
                                + "bushels "
                                + "to feed the People for this year.\n"
                                + "please enter the amount here: ");
                        break;
case 'm':
    console.println("You have made it so, far...\n"
+ "                  xxxXRRRMMMMMMMMMMMMMMMxxx,.\n"
+ "              xXXRRRRRXXXVVXVVXXXXXXXRRRRRMMMRx,\n"
+ "            xXRRXRVVVVVVVVVVVVVVVXXXXXRXXRRRMMMMMRx.\n"
+ "          xXRXXXVVVVVVVVVVVVVVVVXXXXVXXXXXXRRRRRMMMMMxx.\n"
+ "        xXRRXXVVVVVttVtVVVVVVVVVtVXVVVVXXXXXRRRRRRRMMMMMXx\n"
+ "      xXXRXXVVVVVtVttttttVtttttttttVXXXVXXXRXXRRRRRRRMMMMMMXx\n"
+ "     XRXRXVXXVVVVttVtttVttVttttttVVVVXXXXXXXXXRRRRRRRMMMMMMMMVx\n"
+ "    XRXXRXVXXVVVVtVtttttVtttttittVVVXXVXVXXXRXRRRRRMRRMMMMMMMMMX,\n"
+ "   XRRRMRXRXXXVVVXVVtttittttttttttVVVVXXVXXXXXXRRRRRMRMMMMMMMMMMM,\n"
+ "   XXXRRRRRXXXXXXVVtttttttttttttttttVtVXVXXXXXXXRRRRRMMMMMMMMMMMMM,\n"
+ "   XXXXRXRXRXXVXXVtVtVVttttttttttttVtttVXXXXXXXRRRRRMMMMMMMMMMMMMMMR\n"
+ "   VVXXXVRVVXVVXVVVtttititiitttttttttttVVXXXXXXRRRRRMRMMMMMMMMMMMMMMV\n"
+ "   VttVVVXRXVVXtVVVtttii|iiiiiiittttttttitXXXRRRRRRRRRRMMMMMMMMMMMMMM\n"
+ "   tiRVVXRVXVVVVVit|ii||iii|||||iiiiiitiitXXXXXXXXRRRRRRMMMMMMMMMMMMM\n"
+ "    +iVtXVttiiii|ii|+i+|||||i||||||||itiiitVXXVXXXRRRRRRRRMMMMMMRMMMX\n"
+ "    `+itV|++|tttt|i|+||=+i|i|iiii|iiiiiiiitiVtti+++++|itttRRRRRMVXVit\n"
+ "     +iXV+iVt+,tVit|+=i|||||iiiiitiiiiiiii|+| |it  ti+=++|+iVX RV  |t\n"
+ "     +iXtiXRXXi+Vt|i||+|++itititttttttti|iiiiitVtii:+++|+++iXRMMXXMR\n"
+ "     :iRtiXtiV||iVVt||||++ttittttttttttttttXXVXXRXRXXXtittt|iXRMMXRM\n"
+ "      :|t|iVtXV+=+Xtti+|++itiiititittttVttXXXXXXXRRRXVtVVtttttRRMMMM|\n"
+ "        +iiiitttt||i+++||+++|iiiiiiiiitVVVXXRXXXRRRRMXVVVVttVVVXRMMMV\n"
+ "         :itti|iVttt|+|++|++|||iiiiiiiittVVXRRRMMMMMMRVtitittiVXRRMMMV\n"
+ "           `i|iitVtXt+=||++++|++++|||+++iiiVVXVRXRRRV+=|tttttttiRRRMMM|\n"
+ "             i+++|+==++++++++++++++|||||||||itVVVViitt|+,,+,,=,+|itVX'\n"
+ "              |+++++.,||+|++++=+++++++|+|||||iitt||i||ii||||||itXt|\n"
+ "              t||+++,.=i+|+||+++++++++++++|i|ittiiii|iiitttttXVXRX|\n"
+ "              :||+++++.+++++++++|++|++++++|||iii||+:,:.-+:+|iViVXV\n"
+ "              iii||+++=.,+=,=,==++++++++++|||itttt|itiittXRXXXitV'\n"
+ "             ;tttii||++,.,,,.,,,,,=++++++++++|iittti|iiiiVXXXXXXV\n"
+ "            tVtttiii||++++=,,.  . ,,,=+++++++|itiiiiiii||||itttVt\n"
+ "           tVVttiiiii||||++++==,. ..,.,+++=++iiiiiitttttVVXXRRXXV\n"
+ "        ..ttVVttitttii||i|||||+|+=,.    .,,,,==+iittVVVXRRMXRRRV\n"
+ "...'''ittitttttitVttttiiiiii|ii|++++=+=..... ,.,,||+itiVVXXVXV\n"
+ "      ,|iitiiitttttttiiiii||ii||||||||+++++,.i|itVt+,,=,==.........\n"
+ "        ,|itiiiVtVtiii||iiiiii|||||||++||||tt|VXXRX|  ....  ..     ' ' '\n"
+ "          ,,i|ii||i||+|i|i|iiiiiiii||||ittRVVXRXRMX+, .  ...   .        ,\n"
+ "    .       .,+|++|||||ii|i|iiiitttVVttXVVXVXRRRRXt+. .....  . .      ,. .\n"
+ "  . .          ,,++|||||||i|iiitVVVXXXXVXXVXXRRRV+=,.....  ....  .      ..\n"
+ "                  .,,++|||i|iittXXXXRMViRXXXXRVt+=, ..    .......       ..\n"
+ "                   ,XX+.=+++iitVVXXXRXVtXXVRRV++=,..... .,, .            .\n"
+ "            ....       +XX+|i,,||tXRRRXVXti|+++,,. .,,. . . ...     . ....\n"
+ "  . .          .      ..  ..........++,,..,...,.... ..             .. ...\n"
);

                        break;
                    default:
                        console.println("You should press either 'y' for "
                                + "yes, or 'n' "
                                + "for no.");
                        break;
                }
            } while (false == exit);
        } catch (Exception e) {
            console.println("Error reading input: " + e.getMessage());
        }
        console.println("You have chosen to feed " + bushels + " bushels "
                + "to " + Population + " for the year.\n\n");
    }

    public static void plantCropsView() {
        int bushelsToSpend = 0;
        int wheat = theGame.getCrops().getWheatInStore();
        int acres = theGame.getCrops().getAcres();

        console.println("REMINDER: Two acres can be planted per bushel.");
        try {
            do {
                TimeUnit.SECONDS.sleep(1);
                console.println("\nHow many bushels would you like to use "
                        + "to plant? \n");
                bushelsToSpend = Integer.parseInt(keyboard.readLine());
                try {
                    CropsControl.plantCrops(bushelsToSpend, theGame.getCrops());
                } catch (CropsControlException me) {
                    console.println(me.getMessage());
                }
            } while (bushelsToSpend < 0 || bushelsToSpend > wheat
                    || bushelsToSpend * 2 > acres);
        } catch (Exception e) {
            console.println("Error reading input: " + e.getMessage());
        }

    }

    public static void harvestWheatView() {
        console.println("\n# THIS IS A REPORT OF THE HARVEST #");

        int rats = CropsControl.harvestCrops(theGame.getCrops());
        Crops theCropsObj = theGame.getCrops();
        int planted = theCropsObj.getPlanted();
        int cropYield = theCropsObj.getCropYield();
        int harvest = theCropsObj.getHarvest();

        console.format("You planted %2d acres and yielded %2d crops per acre.\n",
                planted, cropYield);
 
        console.format("looks like the rats have eaten %3d bushels\n" , rats);

        console.format("The harvest was: %2d\n\n", harvest);
    }
     
    public static void payPharoahView() {

        int pharoahsCut;

        try {
            CropsControl.payPharoah(theGame.getCrops());
        } catch (CropsControlException me) {
            console.println(me.getMessage());
        }
        pharoahsCut = theGame.getCrops().getPharoahsShare();

        console.println("\n# PAYING PHAROAH #");
        console.println("The Pharoah is paid before the people are fed.");
        console.format("Pharoah has now taken %3d bushels.\n\n", pharoahsCut);

    }

    public static void showStarvedView() {
        int starved = theGame.getCrops().getStarvedPeople();
        int Pop = theGame.getCrops().getPopulation();
        int amountSupplied = theGame.getCrops().getFoodSupplied();
        double Mastery = starved / Pop;
        String message;

        console.println("###########################"
                + "\n# People who have starved #"
                + "\n###########################\n\n");
        console.println("Your People have suffered the loss of " + Pop
                + " starved Individuals this year.");

        if (Mastery < .05) {
            message = "You have done excellent at keeping Your People alive.  \n"
                    + "Some may fall, but You are providing well.";
        } else if (Mastery < .1) {
            message = "Your losses are minimal, but You must strive to feed Your"
                    + "People better.";
        } else if (Mastery < .15) {
            message = "Your losses are becoming many.";
        } else if (Mastery < .2) {
            message = "You've lost a fifth of Your People to starvation, "
                    + "\nYou must feed Your People better.";
        } else if (Mastery < .5) {
            message = "Your People are falling in massive numbers.  You must feed"
                    + "better.";
        } else {
            message = "You have need of some serious provisions.  Your losses "
                    + "have become overwhelming.  ";
        }
        console.println(message + "\nYour losses are " + starved + " out of "
                + Pop + " People.");
        console.println("Mastery is : " + Mastery + "\n\n\n");
    }

    public static void getHints() {
        console.println("###########################################"
                + "# here's a game hint that You can utilize #"
                + "###########################################");

        final String[] hint = {"hint 1", "hint 2", "hint 3"};
        Random pickHint = new Random();
        int index = pickHint.nextInt(hint.length);
        console.println(hint[index]);
    }

    public static void growPopulationView() {

    }

    public static void displayCropsReportView() throws InterruptedException {
        
        Crops theCrops = theGame.getCrops();
        try {
        console.println("###########################\n"
                + "#       CROP REPORT       #\n"
                + "###########################\n");
        TimeUnit.SECONDS.sleep(1);
        console.format("You are in year number%2d of the seven years of plenty"
                + "\n"
                , theCrops.getYear());
        TimeUnit.SECONDS.sleep(1);
        console.format("Your Population consists of %2d People at this time\n"
                , theCrops.getPopulation());
        TimeUnit.SECONDS.sleep(1);
        console.format("You have %2d total acres that are available to plant\n"
                , theCrops.getAcres());
        TimeUnit.SECONDS.sleep(1);
        console.format("Your crops did yield %2d bushels this harvest\n"
                , theCrops.getCropYield());
        TimeUnit.SECONDS.sleep(1);
        console.format("You have %2d bushels of wheat in store\n"
                , theCrops.getWheatInStore());
        TimeUnit.SECONDS.sleep(1);
        console.format("Your harvest produced %2d bushels\n"
                , theCrops.getHarvest());
        TimeUnit.SECONDS.sleep(1);
        console.format("Pharoah's share has amounted to %2d total bushels\n"
                , theCrops.getPharoahsShare());
        TimeUnit.SECONDS.sleep(1);
        console.format("You have fed %d People\n"
                , theCrops.getFed());
        TimeUnit.SECONDS.sleep(1);
        console.format("You have planted %2d crops this year\n"
                , theCrops.getPlanted());
        TimeUnit.SECONDS.sleep(1);
        console.format("You have lost %2d People due to starvation\n"
                , theCrops.getStarvedPeople());
        TimeUnit.SECONDS.sleep(1);
    
        } catch (Exception me) {
                console.println(me.getMessage());
            }
    }
    
    public static void endGameView() {
        console.println("\n\nThanks for playing!");
        console.println("\nYour final result:");
        displayCropsReportView();
        GameControl.createCrops();
        console.println("\n\n\nPress ENTER to exit...");
        try {
            keyboard.read();
        } catch (Exception e) {
            ErrorView.display("CropsView", e.getMessage());
        }
    }

}
