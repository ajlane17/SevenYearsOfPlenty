/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.sevenyearsofplenty.control;

import byui.cit260.sevenyearsofplenty.model.Crops;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Dennis, Vanessa, Adrian
 */
public class CropsControl {
    
    public static void payPharoah (Crops theCropsObj) {
        int taxLow = 8;
        int taxHigh = 10;
        float taxRate;
        int pharoahsShare;
        int wheatInStore = theCropsObj.getWheatInStore();
        if (wheatInStore >= 0) {
            // generate tax rate
            taxRate = ThreadLocalRandom.current().nextInt(taxLow, taxHigh + 1);
            taxRate = taxRate/100;
            // calculate Pharoah’s share
            pharoahsShare = (int)(wheatInStore * taxRate);
            // Update Crops object
            theCropsObj.setPharoahsShare(pharoahsShare);
            theCropsObj.setWheatInStore(wheatInStore - pharoahsShare);
        } else {
            throw new IllegalArgumentException("Can't do that");
        }
    }

    public static int buyLand(int landPrice, int acresToBuy, Crops theCropsObj) {

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
    
    public static void plantCrops(int cropsToPlant, Crops theCropsObj) {
        
        int wheatInStore = theCropsObj.getWheatInStore();
        int acres = theCropsObj.getAcres();
        if (cropsToPlant > wheatInStore || cropsToPlant > acres) {
            throw new IllegalArgumentException("Can't do that");
        } else {
            theCropsObj.setPlanted(cropsToPlant);
        }
    }
    
    public static int sellLand(int landPrice, int acresToSell, Crops theCropsObj){ 
        int wheatInStore = theCropsObj.getWheatInStore(); 
        int acresOwned = theCropsObj.getAcres(); 
         
        if(acresToSell < 0 || acresToSell > acresOwned){ 
            return -1; 
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
        float yield; 
        int cropYield; 
        boolean rats; 
        float ratTax; 
         
        //Getting crop yield 
        yield = ThreadLocalRandom.current().nextInt(yieldLow, yieldHigh +1); 
         
        //Calculate total cropYield 
        cropYield = planted * (int)yield; 
         
        //Rats eat 
        rats = Math.random() < 0.5; 
         
        //Calculate how much did rats eat 
        if (rats){ 
            ratTax = ThreadLocalRandom.current() .nextInt(ratTaxLow, ratTaxHigh +1); 
            ratTax = ratTax/100; 
            harvest = cropYield - (int)ratTax; 
        }else{ 
            harvest = cropYield; 
            ratTax = 0; 
        } 
         
        //Update the crops object 
        theCropsObj.setCropYield(cropYield); 
        theCropsObj.setHarvest(harvest); 
        theCropsObj.setWheatInStore(harvest); 
         
        return (int)ratTax; 
    } 
    
    

        //reqNutrition is how much each Member of the Population needs each year
    //to be sustained.  
    public static int feedPeople(int reqNutrition, int feedAmount, Crops theCropsObj) {
        int wheatInStore = theCropsObj.getWheatInStore();
        int currPopulation = theCropsObj.getPopulation();
        float productivity;

        if (feedAmount <= 0 || wheatInStore <= 0 || currPopulation <= 0
                || reqNutrition <= 0 || reqNutrition > feedAmount || feedAmount > wheatInStore) {
            return -1;
        } else {
            theCropsObj.setWheatInStore(wheatInStore -= feedAmount);
            int fedPopulation = feedAmount / reqNutrition;

            if (fedPopulation > currPopulation) {
                productivity = fedPopulation / currPopulation;
            } else {
                theCropsObj.setStarvedPeople(currPopulation - fedPopulation);
                currPopulation = fedPopulation;
                theCropsObj.setPopulation(currPopulation);
            }

            return currPopulation;
        }

    }
}
