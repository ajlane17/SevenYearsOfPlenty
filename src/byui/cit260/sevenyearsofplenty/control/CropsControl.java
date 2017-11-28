/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.sevenyearsofplenty.control;

import byui.cit260.sevenyearsofplenty.exceptions.CropsControlException;
import byui.cit260.sevenyearsofplenty.model.Crops;
import static java.lang.Math.round;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Dennis, Vanessa, Adrian
 */
public class CropsControl {

    public static void payPharoah(Crops theCropsObj)
            throws CropsControlException {
        int taxLow = 8;
        int taxHigh = 10;
        double taxRate;
        int pharoahsShare = theCropsObj.getPharoahsShare();
        int pharoahsCut;
        int wheatInStore = theCropsObj.getWheatInStore();
        if (wheatInStore >= 0) {
            // generate tax rate
            taxRate = ThreadLocalRandom.current().nextInt(taxLow, taxHigh + 1);
            taxRate = taxRate / 100;
            // calculate Pharoah’s share
            pharoahsCut = (int) (wheatInStore * taxRate);
            // Update Crops object
            theCropsObj.setPharoahsShare(pharoahsShare + pharoahsCut);
            theCropsObj.setWheatInStore(wheatInStore - pharoahsShare);
        } else {
            throw new CropsControlException("You can't pay taxes with "
                    + "a negative balance - something went wrong in a "
                    + "previous step.");
        }
    }

    public static int buyLand(int landPrice, int acresToBuy,
            Crops theCropsObj) {

        int wheatInStore = theCropsObj.getWheatInStore();
        int acresOwned = theCropsObj.getAcres();

        if (acresToBuy < 0 || acresToBuy * landPrice > wheatInStore) {
            return -1;
        } else {
            acresOwned = acresOwned + acresToBuy;
            theCropsObj.setAcres(acresOwned);

            wheatInStore = wheatInStore - (acresToBuy * landPrice);
            theCropsObj.setWheatInStore(wheatInStore);

            return wheatInStore;
        }
    }

    public static void plantCrops(int bushelsToSpend, Crops theCropsObj)
            throws CropsControlException {

        int wheatInStore = theCropsObj.getWheatInStore();
        int acres = theCropsObj.getAcres();
        if (bushelsToSpend > wheatInStore || bushelsToSpend * 2 > acres) {
            throw new CropsControlException("You're trying to plant more land"
                    + "than you're allowed.");
        } else {
            theCropsObj.setPlanted(bushelsToSpend * 2);
            theCropsObj.setWheatInStore(wheatInStore - bushelsToSpend);
        }
    }
    
    public static int sellLand(int landPrice, int acresToSell, 
            Crops theCropsObj)
       throws CropsControlException { 
        int wheatInStore = theCropsObj.getWheatInStore(); 
        int acresOwned = theCropsObj.getAcres(); 
         
        if(acresToSell < 0 || acresToSell > acresOwned){ 
            throw new CropsControlException("A negative value was input");
        } else { 
            acresOwned = acresOwned - acresToSell; 
            theCropsObj.setAcres(acresOwned); 
             
            wheatInStore = wheatInStore + (acresToSell * landPrice); 
            theCropsObj.setWheatInStore(wheatInStore); 
             
            return wheatInStore; 
        } 
    }

    public static int harvestCrops(Crops theCropsObj) {
        int planted = theCropsObj.getPlanted();
        int wheatInStore = theCropsObj.getWheatInStore();
        int ratTaxLow = 10;
        int ratTaxHigh = 15;
        int yieldLow = 1;
        int yieldHigh = 5;
        int harvest;
        double yield;
        int cropYield;
        boolean rats;
        double ratTax;

        //Getting crop yield 
        cropYield = ThreadLocalRandom.current().nextInt(yieldLow, yieldHigh + 1);

        //Calculate total cropYield 
        harvest = planted * (int) cropYield;

        //Rats eat 
        rats = Math.random() < 0.5;

        //Calculate how much did rats eat 
        if (rats) {
            ratTax = ThreadLocalRandom.current().nextInt(ratTaxLow,
                    ratTaxHigh + 1);
            ratTax = ratTax / 100;
            ratTax = ratTax * harvest;
            harvest = harvest - (int) ratTax;
        } else {
            ratTax = 0;
        }

        //Update the crops object 
        theCropsObj.setCropYield(cropYield);
        theCropsObj.setHarvest(harvest);
        theCropsObj.setWheatInStore(wheatInStore + harvest);

        return (int) ratTax;
    }

    //reqNutrition is how much each Member of the Population needs each year
    //to be sustained.  
    public static int feedPeople(int reqNutrition, int feedAmount,
            Crops theCropsObj) {
        int wheatInStore = theCropsObj.getWheatInStore();
        int currPopulation = theCropsObj.getPopulation();
        double productivity;
        theCropsObj.setFoodSupplied(feedAmount);

        if (feedAmount <= 0 || wheatInStore <= 0 || currPopulation <= 0
                || reqNutrition <= 0 || reqNutrition > feedAmount
                || feedAmount > wheatInStore) {
            return -1;
        } else {
            theCropsObj.setWheatInStore(wheatInStore -= feedAmount);
            int fedPopulation = feedAmount / reqNutrition;

            if (fedPopulation > currPopulation) {
                productivity = fedPopulation / currPopulation;
                theCropsObj.setProductivity(productivity);
            } else {
                theCropsObj.setStarvedPeople(currPopulation - fedPopulation);
                currPopulation = fedPopulation;
                theCropsObj.setPopulation(currPopulation);
            }

            return currPopulation;
        }
    }

    public static int growPopulation(Crops theCropsObj) {
        double rate = theCropsObj.getGrowthRate();
        double productivity = theCropsObj.getProductivity();
        int yield = theCropsObj.getCropYield();
        int Population = theCropsObj.getPopulation();

        if (productivity > 1) {
            double formula = (rate * yield) + productivity;
            Population = (int) round(Population * formula);
        } else {

        }
        return Population;
    }

    public static int calcLandCost() {
        return 10;
    }
}
