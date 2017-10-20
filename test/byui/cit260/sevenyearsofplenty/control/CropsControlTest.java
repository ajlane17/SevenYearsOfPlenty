/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.sevenyearsofplenty.control;

import byui.cit260.sevenyearsofplenty.model.Crops;
import static org.hamcrest.CoreMatchers.is;
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
        
        Crops payPharoahCropsObj = new Crops();
        int low;
        int high;
        int expResult;
        int result;
        
        // Test Case #1 
        System.out.println("payPharoah #1");
        payPharoahCropsObj.setHarvest(1);
        expResult = 0;
        CropsControl.payPharoah(payPharoahCropsObj);
        result = payPharoahCropsObj.getHarvest();
        assertEquals(expResult, result);
        
        // Test Case #2        
        System.out.println("payPharoah #2");
        payPharoahCropsObj.setHarvest(234);
        low = 191;
        high = 219;
        CropsControl.payPharoah(payPharoahCropsObj);
        result = payPharoahCropsObj.getHarvest();
        assertTrue("Error, result is too low", low <= result);
        assertTrue("Error, result is too high", high >= result);
        
        // Test Case #3
        System.out.println("payPharoah #3");
        payPharoahCropsObj.setHarvest(1000);
        low = 820;
        high = 940;
        CropsControl.payPharoah(payPharoahCropsObj);
        result = payPharoahCropsObj.getHarvest();
        assertTrue("Error, result is too low", low <= result);
        assertTrue("Error, result is too high", high >= result);
        
        // Test Case #4
        System.out.println("payPharoah #4");
        payPharoahCropsObj.setHarvest(-100);
        try {
            CropsControl.payPharoah(payPharoahCropsObj);
        } catch (Exception e) {
            assertThat(e.getMessage(), is("Can't do that"));
        }
        
        // Test Case #5
        System.out.println("payPharoah #5");
        payPharoahCropsObj.setHarvest(0);
        expResult = 0;
        CropsControl.payPharoah(payPharoahCropsObj);
        result = payPharoahCropsObj.getHarvest();
        assertEquals(expResult, result);
    }

    /**
     * Test of buyLand method, of class CropsControl.
     */
    @Test
    public void testBuyLand() {
        
        Crops testBuyLandCropsObj = new Crops();
        int landPrice;
        int acresToBuy;
        int expResult;
        int result;
        
        // Test Case #1
        System.out.println("buyLand #1");
        landPrice = 20;
        acresToBuy = 10;
        testBuyLandCropsObj.setWheatInStore(2800);
        expResult = 2600;
        result = CropsControl.buyLand(landPrice, acresToBuy, testBuyLandCropsObj);
        assertEquals(expResult, result);
        
        // Test Case #2
        System.out.println("buyLand #2");
        landPrice = 20;
        acresToBuy = -5;
        testBuyLandCropsObj.setWheatInStore(2800);
        expResult = -1;
        result = CropsControl.buyLand(landPrice, acresToBuy, testBuyLandCropsObj);
        assertEquals(expResult, result);
        
        // Test Case #3
        System.out.println("buyLand #3");
        landPrice = 20;
        acresToBuy = 200;
        testBuyLandCropsObj.setWheatInStore(2800);
        expResult = -1;
        result = CropsControl.buyLand(landPrice, acresToBuy, testBuyLandCropsObj);
        assertEquals(expResult, result);
        
        // Test Case #4
        System.out.println("buyLand #4");
        landPrice = 10;
        acresToBuy = 200;
        testBuyLandCropsObj.setWheatInStore(2000);
        expResult = 0;
        result = CropsControl.buyLand(landPrice, acresToBuy, testBuyLandCropsObj);
        assertEquals(expResult, result);
        
        // Test Case #5
        System.out.println("buyLand #5");
        landPrice = 10;
        acresToBuy = 0;
        testBuyLandCropsObj.setWheatInStore(2000);
        expResult = 2000;
        result = CropsControl.buyLand(landPrice, acresToBuy, testBuyLandCropsObj);
        assertEquals(expResult, result);
    }

    /**
     * Test of plantCrops method, of class CropsControl.
     */
    @Test
    public void testPlantCrops() {
        
        Crops testPlantCropsCropsObj = new Crops();
        int wheatInStore;
        int acres;
        int cropsToPlant;
        int expResult;
        int result;
        
        // Test Case #1
        System.out.println("PlantCrops #1");
        cropsToPlant = 234;
        wheatInStore = 500;
        acres = 440;
        expResult = 234;
        testPlantCropsCropsObj.setWheatInStore(wheatInStore);
        testPlantCropsCropsObj.setAcres(acres);
        CropsControl.plantCrops(cropsToPlant, testPlantCropsCropsObj);
        result = testPlantCropsCropsObj.getPlanted();
        assertEquals(expResult, result);
        
        // Test Case #2
        System.out.println("PlantCrops #2");
        cropsToPlant = 51;
        wheatInStore = 50;
        acres = 440;
        testPlantCropsCropsObj.setWheatInStore(wheatInStore);
        testPlantCropsCropsObj.setAcres(acres);
        try {
            CropsControl.plantCrops(cropsToPlant, testPlantCropsCropsObj);
        } catch (Exception e) {
            assertThat(e.getMessage(), is("Can't do that"));
        }
        
        // Test Case #3
        System.out.println("PlantCrops #3");
        cropsToPlant = 50;
        wheatInStore = 100;
        acres = 40;
        testPlantCropsCropsObj.setWheatInStore(wheatInStore);
        testPlantCropsCropsObj.setAcres(acres);
        try {
            CropsControl.plantCrops(cropsToPlant, testPlantCropsCropsObj);
        } catch (Exception e) {
            assertThat(e.getMessage(), is("Can't do that"));
        }
        
        // Test Case #4
        System.out.println("PlantCrops #4");
        cropsToPlant = 20;
        wheatInStore = 20;
        acres = 100;
        expResult = 20;
        testPlantCropsCropsObj.setWheatInStore(wheatInStore);
        testPlantCropsCropsObj.setAcres(acres);
        CropsControl.plantCrops(cropsToPlant, testPlantCropsCropsObj);
        result = testPlantCropsCropsObj.getPlanted();
        assertEquals(expResult, result);
        
        // Test Case #5
        System.out.println("PlantCrops #5");
        cropsToPlant = 20;
        wheatInStore = 100;
        acres = 20;
        expResult = 20;
        testPlantCropsCropsObj.setWheatInStore(wheatInStore);
        testPlantCropsCropsObj.setAcres(acres);
        CropsControl.plantCrops(cropsToPlant, testPlantCropsCropsObj);
        result = testPlantCropsCropsObj.getPlanted();
        assertEquals(expResult, result);
        
        // Test Case #6
        System.out.println("PlantCrops #6");
        cropsToPlant = 0;
        wheatInStore = 100;
        acres = 20;
        expResult = 0;
        testPlantCropsCropsObj.setWheatInStore(wheatInStore);
        testPlantCropsCropsObj.setAcres(acres);
        CropsControl.plantCrops(cropsToPlant, testPlantCropsCropsObj);
        result = testPlantCropsCropsObj.getPlanted();
        assertEquals(expResult, result);
        
    }    
}
