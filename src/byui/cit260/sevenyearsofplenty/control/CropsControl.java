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
        int taxLow = 6;
        int taxHigh = 18;
        int harvest = theCropsObj.getHarvest();
        if (harvest >= 0) {
            // generate tax rate
            float taxRate = ThreadLocalRandom.current().nextInt(taxLow, taxHigh + 1);
            // calculate new yield after Pharoah’s cut
            float newYield = (100-taxRate)/100*(float)harvest;
            theCropsObj.setHarvest((int)newYield);
        } else {
            throw new IllegalArgumentException("Can't do that");
        }
    }
    
    public static int buyLand(int landPrice, int acresToBuy, Crops theCropsObj){
        
        int wheatInStore = theCropsObj.getWheatInStore();
        int acresOwned = theCropsObj.getAcres();
        
        if (acresToBuy < 0 || acresToBuy * landPrice > wheatInStore){
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
        // if cropsToPlant greater than whheat in store, return -1
        // if cropsToPlant greater than acres owned, return -1
        if (cropsToPlant > wheatInStore || cropsToPlant > acres) {
            throw new IllegalArgumentException("Can't do that");
        } else {
            theCropsObj.setPlanted(cropsToPlant);
        }
    }
}
