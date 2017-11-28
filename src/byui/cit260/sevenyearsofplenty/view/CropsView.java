/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.sevenyearsofplenty.view;

import byui.cit260.sevenyearsofplenty.control.CropsControl;
import byui.cit260.sevenyearsofplenty.exceptions.CropsControlException;
import byui.cit260.sevenyearsofplenty.control.GameControl;
import byui.cit260.sevenyearsofplenty.exceptions.CropsControlException;
import byui.cit260.sevenyearsofplenty.model.Crops;
import byui.cit260.sevenyearsofplenty.model.Game;
import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import sevenyearsofplenty.SevenYearsOfPlenty;

/**
 *
 * @author ajlan
 */
public class CropsView {

    // Create a Scanner object
    private static Scanner keyboard = new Scanner(System.in);

    // Get references to the Game object and the Crops object
    private static Game theGame = SevenYearsOfPlenty.getGame();

    // The startProgramView method
    // Purpose: Start the game
    // Parameters: None
    // Returns: none
    public static void displayStartProgramView() {
        String playerName = getPlayersName();
        GameControl.createPlayer(playerName);
        GameControl.createCrops();
        GameControl.createPlayerMap(5, 5);

        System.out.println("\n\n\n\n");
        System.out.println(playerName + ", you have been appointed "
                + "overseer for your");
        System.out.println("village. Tread carefully, if your people are not "
                + "fed well");
        System.out.println("you may lose your head.");

        displayNextView();
    }

    public static void displayNextView() {
        GameMenuView gameMenuView = new GameMenuView();
        gameMenuView.display();

        // control returns to this point when user exits main menu
        // goodbye message
        System.out.println("Goodbye ... thanks for playing.");
    }

    public static String getPlayersName() {
        String playerName = "";
        keyboard = new Scanner(System.in);
        do {
            System.out.print("Please enter your name: ");
            playerName = keyboard.nextLine();
            playerName = playerName.trim();
            if (playerName.length() < 2) // must have at least 2 characters
            {
                System.out.println("Invalid input: name must be at least "
                        + "2 characters");
            }

        } while (playerName.length() < 2);  // must have at least 2 characters

        return playerName;
    }

    public static void buyLandView() {
        int toBuy = 0;
        int price = CropsControl.calcLandCost();
        System.out.format("Land is selling for %d bushels per acre.%n", price);

        int wheat = theGame.getCrops().getWheatInStore();
        int population = theGame.getCrops().getPopulation();
        do {
            System.out.print("\nHow many acres of land do you wish to buy? ");
            toBuy = keyboard.nextInt();
            if (toBuy < 0) {
                System.out.println("I am sorry master, I cannot do this.");
                System.out.println("You cannot buy a negative amount of land.");
            } else if (toBuy * price > wheat) {
                System.out.println("I am sorry master, I cannot do this.");
                System.out.println("You do not have enough wheat to buy this "
                        + "much land.");
            }
        } while (toBuy < 0 || toBuy * price > wheat);
        CropsControl.buyLand(price, toBuy, theGame.getCrops());
    }

    public static void sellLandView() {
        int toSell = 0;
        int price = CropsControl.calcLandCost();
        Game theGame = SevenYearsOfPlenty.getGame();
        boolean paramsNotOkay = false;
        int wheat = theGame.getCrops().getWheatInStore(); 
        int population = theGame.getCrops().getPopulation();
        int owned = theGame.getCrops().getAcres();
       do
       {
           System.out.print("\nHow many acres of land do you wish to sell? ");      
           toSell = keyboard.nextInt();
           try
            {               
                CropsControl.sellLand(price, toSell, theGame.getCrops());
            }
           catch(CropsControlException e)
            {
             System.out.println("I am sorry master, I cannot do this.");
             System.out.println(e.getMessage());
             paramsNotOkay = true;
            }
      } while(paramsNotOkay);
           
    }

    public static void feedPeopleView() throws InterruptedException {
        int reqNutrition = 20;
        int Population = theGame.getCrops().getPopulation();
        System.out.println("\n\n\n# You must feed the People #\n"
                + "Your attention is required, as "
                + "We must allocate rations for the People. \n"
                + "You must decide how much You will feed the People. \n"
                + "You should enter a whole number for the bushels that will \n"
                + "be distributed for the year. \n "
                + "please enter Your decision : ");

        int bushels = keyboard.nextInt();
        boolean exit = false;
        TimeUnit.SECONDS.sleep(1);
        System.out.println("You have decided to feed " + bushels + " bushels to "
                + Population + " People for this year, \nenter 'y' if You agree,"
                + " and 'n', if You would like to re-enter Your decision : ");
        do {
            String word = keyboard.next();
            char letter = word.charAt(0);

            TimeUnit.SECONDS.sleep(1);
            switch (letter) {
                case 'y':
                    CropsControl.feedPeople(reqNutrition, bushels, theGame.getCrops());
                    int testPopulation = theGame.getCrops().getPopulation();
                    System.out.println("the Population is : " + testPopulation + "after"
                            + "calling the feedPeople method.");
                    int theStarved = theGame.getCrops().getStarvedPeople();
                    int fedPeople = theGame.getCrops().getFed();
                    System.out.println("theStarved = " + theStarved);
                    System.out.println("fedPeople = " + fedPeople);
                    exit = true;
                    break;
                case 'n':
                    System.out.println("You should enter a whole number of bushels "
                            + "to feed the People for this year.\n"
                            + "please enter the amount here: ");
                    break;
                case 'm':
                    System.out.println("You have chosen wisely...\n"
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
                            + "You have made it so... far...");

                    break;
                default:
                    System.out.println("You should press either 'y' for yes, or 'n' "
                            + "for no.");
                    break;
            }
        } while (false == exit);
        System.out.println("You have chosen to feed " + bushels + " bushels "
                + "to " + Population + " for the year.\n\n");
    }

    public static void plantCropsView() {
        int bushelsToSpend = 0;
        int wheat = theGame.getCrops().getWheatInStore();
        int acres = theGame.getCrops().getAcres();

        System.out.println("REMINDER: Two acres can be planted per bushel.");

        do {
            System.out.print("\nHow many bushels would you like to use to plant? ");
            bushelsToSpend = keyboard.nextInt();
            if (bushelsToSpend < 0) {
                System.out.println("I am sorry master, I cannot do this.");
                System.out.println("You cannot buy a negative amount of acres.");
            } else if (bushelsToSpend > wheat) {
                System.out.println("I am sorry master, I cannot do this.");
                System.out.println("You do not have enough wheat to buy this much "
                        + "land.");
            } else if (bushelsToSpend * 2 > acres) {
                System.out.println("I am sorry master, I cannot do this.");
                System.out.println("You cannot plant more acres than you have.");
            }
        } while (bushelsToSpend < 0 || bushelsToSpend > wheat
                || bushelsToSpend * 2 > acres);
        try {
            CropsControl.plantCrops(bushelsToSpend, theGame.getCrops());
        } catch (CropsControlException me) {
            System.out.println(me.getMessage());
        }

    }

    public static void harvestWheatView() {

        System.out.println("\n# THIS IS A REPORT OF THE HARVEST #");

        int rats = CropsControl.harvestCrops(theGame.getCrops());
        Crops theCropsObj = theGame.getCrops();
        int planted = theCropsObj.getPlanted();
        int cropYield = theCropsObj.getCropYield();
        int harvest = theCropsObj.getHarvest();

        System.out.format("You planted %2d acres and yielded %2d crops per acre.\n",
                planted, cropYield);
        System.out.format("Rates ate: %2d\n", rats);
        System.out.format("The harvest was: %2d\n\n", harvest);
    }

    public static void payPharoahView() {

        int pharoahsCut;

        try {
            CropsControl.payPharoah(theGame.getCrops());
        } catch (CropsControlException me) {
            System.out.println(me.getMessage());
        }
        pharoahsCut = theGame.getCrops().getPharoahsShare();

        System.out.println("\n# PAYING PHAROAH #");
        System.out.println("The Pharoah is paid before the people are fed.");
        System.out.format("Pharoah total take is now %2d bushels.\n\n", pharoahsCut);

    }

    public static void showStarvedView() {
        int starved = theGame.getCrops().getStarvedPeople();
        int Pop = theGame.getCrops().getPopulation();
        int amountSupplied = theGame.getCrops().getFoodSupplied();
        double Mastery = starved / Pop;
        String message;

        System.out.println("###########################"
                + "\n# People who have starved #"
                + "\n###########################\n\n");
        System.out.println("Your People have suffered the loss of " + Pop
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
        System.out.println(message + "\nYour losses are " + starved + " out of "
                + Pop + " People.");
        System.out.println("Mastery is : " + Mastery + "\n\n\n");
    }

    public static void getHints() {
        System.out.println("###########################################"
                + "# here's a game hint that You can utilize #"
                + "###########################################");

        final String[] hint = {"hint 1", "hint 2", "hint 3"};
        Random pickHint = new Random();
        int index = pickHint.nextInt(hint.length);
        System.out.println(hint[index]);
    }

    public static void growPopulationView() {

    }

    public static void displayCropsReportView() {

        Crops theCrops = theGame.getCrops();

        System.out.println("###########################\n"
                + "#       CROP REPORT       #\n"
                + "###########################\n");
        System.out.format("YEAR: %2d\n", theCrops.getYear());
        System.out.format("POPULATION: %2d\n", theCrops.getPopulation());
        System.out.format("ACRES: %2d\n", theCrops.getAcres());
        System.out.format("CROP YIELD: %2d\n", theCrops.getCropYield());
        System.out.format("WHEAT IN STORE: %2d\n", theCrops.getWheatInStore());
        System.out.format("HARVEST: %2d\n", theCrops.getHarvest());
        System.out.format("PHAROAH'S SHARE: %2d\n", theCrops.getPharoahsShare());
        System.out.format("FED: %2d\n", theCrops.getFed());
        System.out.format("PLANTED: %2d\n", theCrops.getPlanted());
        System.out.format("STARVED PEOPLE: %2d\n", theCrops.getStarvedPeople());
    }

}
