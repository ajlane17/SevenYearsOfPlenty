/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.sevenyearsofplenty.control;

import byui.cit260.sevenyearsofplenty.model.Crops;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ajlan
 */
public class CropsControlTest {
    
    public CropsControlTest() {
    }

    /**
     * Test of payPharoah method, of class CropsControl.
     */
    @Test
    public void testPayPharoah() {
        
        Crops theCropsObj = new Crops();
        int low;
        int high;
        int expResult;
        int result;
        
        // Test Case #1 
        System.out.println("payPharoah #1");
        theCropsObj.setHarvest(1);
        expResult = 0;
        result = CropsControl.payPharoah(theCropsObj);
        assertEquals(expResult, result);
        
        // Test Case #2        
        System.out.println("payPharoah #2");
        theCropsObj.setHarvest(234);
        low = 191;
        high = 219;
        result = CropsControl.payPharoah(theCropsObj);
        assertTrue("Error, result is too low", low <= result);
        assertTrue("Error, result is too high", high >= result);
        
        // Test Case #3
        System.out.println("payPharoah #3");
        theCropsObj.setHarvest(1000);
        low = 820;
        high = 940;
        result = CropsControl.payPharoah(theCropsObj);
        assertTrue("Error, result is too low", low <= result);
        assertTrue("Error, result is too high", high >= result);
        
        // Test Case #4
        System.out.println("payPharoah #4");
        theCropsObj.setHarvest(-100);
        expResult = -1;
        result = CropsControl.payPharoah(theCropsObj);
        assertEquals(expResult, result);
        
        // Test Case #5
        System.out.println("payPharoah #5");
        theCropsObj.setHarvest(0);
        expResult = 0;
        result = CropsControl.payPharoah(theCropsObj);
        assertEquals(expResult, result);
    }

    /**
     * Test of buyLand method, of class CropsControl.
     */
    @Test
    public void testBuyLand() {
        
        Crops theCropsObj = new Crops();
        int landPrice;
        int acresToBuy;
        int expResult;
        int result;
        
        // Test Case #1
        System.out.println("buyLand #1");
        landPrice = 20;
        acresToBuy = 10;
        theCropsObj.setWheatInStore(2800);
        expResult = 2600;
        result = CropsControl.buyLand(landPrice, acresToBuy, theCropsObj);
        assertEquals(expResult, result);
        
        // Test Case #2
        System.out.println("buyLand #2");
        landPrice = 20;
        acresToBuy = -5;
        theCropsObj.setWheatInStore(2800);
        expResult = -1;
        result = CropsControl.buyLand(landPrice, acresToBuy, theCropsObj);
        assertEquals(expResult, result);
        
         // Test Case #3
        System.out.println("buyLand #3");
        landPrice = 20;
        acresToBuy = 200;
        theCropsObj.setWheatInStore(2800);
        expResult = -1;
        result = CropsControl.buyLand(landPrice, acresToBuy, theCropsObj);
        assertEquals(expResult, result);
        
          // Test Case #4
        System.out.println("buyLand #4");
        landPrice = 10;
        acresToBuy = 200;
        theCropsObj.setWheatInStore(2000);
        expResult = 0;
        result = CropsControl.buyLand(landPrice, acresToBuy, theCropsObj);
        assertEquals(expResult, result);
        
           // Test Case #5
        System.out.println("buyLand #5");
        landPrice = 10;
        acresToBuy = 0;
        theCropsObj.setWheatInStore(2000);
        expResult = 2000;
        result = CropsControl.buyLand(landPrice, acresToBuy, theCropsObj);
        assertEquals(expResult, result);
    }
    
    
}
