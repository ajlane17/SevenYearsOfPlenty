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
    
    public static int payPharoah (int cropYield) {
        int taxLow = 6;
        int taxHigh = 18;
        if (cropYield >= 0) {
            // generate tax rate
            float taxRate = ThreadLocalRandom.current().nextInt(taxLow, taxHigh + 1);
            // calculate new yield after Pharoah’s cut
            float newYield = (100-taxRate)/100*(float)cropYield;
            return (int)newYield;
        } else {
            return -1;
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
}
