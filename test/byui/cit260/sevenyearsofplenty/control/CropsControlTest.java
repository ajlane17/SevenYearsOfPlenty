/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.sevenyearsofplenty.control;

import byui.cit260.sevenyearsofplenty.model.Crops;
import static org.hamcrest.CoreMatchers.is;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author ajlan
 */
public class CropsControlTest {
    
    public CropsControlTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of payPharoah method, of class CropsControl.
     */
    @Test
    public void testPayPharoah() {
        
        Crops payPharoahCropsObj = new Crops();
        int pharoahsShareLow;
        int pharoahsShareHigh;
        int wheatInStoreLow;
        int wheatInStoreHigh;
        int wheatInStoreExpResult;
        int pharoahsShareExpResult;
        int wheatInStoreResult;
        int pharoahsShareResult;
        
        // Test Case #1 
        System.out.println("payPharoah #1");
        payPharoahCropsObj.setWheatInStore(1);
        wheatInStoreExpResult = 1;
        CropsControl.payPharoah(payPharoahCropsObj);
        wheatInStoreResult = payPharoahCropsObj.getWheatInStore();
        assertEquals(wheatInStoreExpResult, wheatInStoreResult);
        
        // Test Case #2        
        System.out.println("payPharoah #2");
        payPharoahCropsObj.setWheatInStore(234);
        pharoahsShareLow = 18;
        pharoahsShareHigh = 23;
        wheatInStoreLow = 211;
        wheatInStoreHigh = 216;
        CropsControl.payPharoah(payPharoahCropsObj);
        pharoahsShareResult = payPharoahCropsObj.getPharoahsShare();
        wheatInStoreResult = payPharoahCropsObj.getWheatInStore();
        assertTrue("Error, result is too low", pharoahsShareResult >= pharoahsShareLow);
        assertTrue("Error, result is too high", pharoahsShareResult <= pharoahsShareHigh);
        assertTrue("Error, result is too low", wheatInStoreResult >= wheatInStoreLow);
        assertTrue("Error, result is too high", wheatInStoreResult <= wheatInStoreHigh);
        
        // Test Case #3
        System.out.println("payPharoah #3");
        payPharoahCropsObj.setWheatInStore(1000);
        pharoahsShareLow = 80;
        pharoahsShareHigh = 100;
        wheatInStoreLow = 900;
        wheatInStoreHigh = 920;
        CropsControl.payPharoah(payPharoahCropsObj);
        pharoahsShareResult = payPharoahCropsObj.getPharoahsShare();
        wheatInStoreResult = payPharoahCropsObj.getWheatInStore();
        assertTrue("Error, result is too low", pharoahsShareResult >= pharoahsShareLow);
        assertTrue("Error, result is too high", pharoahsShareResult <= pharoahsShareHigh);
        assertTrue("Error, result is too low", wheatInStoreResult >= wheatInStoreLow);
        assertTrue("Error, result is too high", wheatInStoreResult <= wheatInStoreHigh);
        
        // Test Case #4
        System.out.println("payPharoah #4");
        payPharoahCropsObj.setWheatInStore(-100);
        try {
            CropsControl.payPharoah(payPharoahCropsObj);
        } catch (Exception e) {
            assertThat(e.getMessage(), is("Can't do that"));
        }
        
        // Test Case #5
        System.out.println("payPharoah #5");
        payPharoahCropsObj.setWheatInStore(0);
        wheatInStoreExpResult = 0;
        CropsControl.payPharoah(payPharoahCropsObj);
        wheatInStoreResult = payPharoahCropsObj.getWheatInStore();
        assertEquals(wheatInStoreExpResult, wheatInStoreResult);
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
    
    /** 
     * Test of sellLand method, of class CropsControl. 
     */ 
    @Test 
    public void testSellLand() { 
        Crops testSellLandCropsObj = new Crops(); 
        int landPrice; 
        int acresToSell; 
        int expResult; 
        int result; 
         
        // Test Case #1 
        System.out.println("sellLand #1"); 
        landPrice = 20; 
        acresToSell = 20; 
        testSellLandCropsObj.setWheatInStore(2000); 
        expResult = -1; 
        result = CropsControl.sellLand(landPrice, acresToSell, testSellLandCropsObj); 
        assertEquals(expResult, result); 
         
        // Test Case #2 
        System.out.println("sellLand #2"); 
        landPrice = 20; 
        acresToSell = -5; 
        testSellLandCropsObj.setWheatInStore(2000); 
        expResult = -1; 
        result = CropsControl.sellLand(landPrice, acresToSell, testSellLandCropsObj); 
        assertEquals(expResult, result);         
       
        // Test Case #3 
        System.out.println("sellLand #3"); 
        landPrice = 20; 
        acresToSell = 250; 
        testSellLandCropsObj.setWheatInStore(2000); 
        expResult = -1; 
        result = CropsControl.sellLand(landPrice, acresToSell, testSellLandCropsObj); 
        assertEquals(expResult, result); 
         
        // Test Case #4 
        System.out.println("sellLand #4"); 
        landPrice = 20; 
        acresToSell = 0; 
        testSellLandCropsObj.setWheatInStore(2000); 
        expResult = 2000; 
        result = CropsControl.sellLand(landPrice, acresToSell, testSellLandCropsObj); 
        assertEquals(expResult, result); 
         
        // Test Case #5 
        System.out.println("sellLand #5"); 
        landPrice = 20; 
        acresToSell = 200; 
        testSellLandCropsObj.setWheatInStore(2000); 
        expResult = -1; 
        result = CropsControl.sellLand(landPrice, acresToSell, testSellLandCropsObj); 
        assertEquals(expResult, result); 
    } 

    /**
     * Test of harvestCrops method, of class CropsControl.
     */
    @Test 
    public void testHarvestCrops() { 
        Crops testHarvestCropsObj = new Crops(); 
        int ratTax;
        int expResult; 
        int result; 
        
        // Test Case #1                 
        System.out.println("harvestCrops #1"); 
        ratTax = 1;
        expResult = 0; 
        result = testHarvestCropsObj.getHarvest(); 
        assertEquals(expResult, result); 
        
        // Test Case #2
        System.out.println("harvestCrops #2"); 
        ratTax = 2;
        result = testHarvestCropsObj.getHarvest(); 
        assertEquals(expResult, result); 
        
        // Test Case #3
        System.out.println("harvestCrops #2"); 
        ratTax = 3;
        result = testHarvestCropsObj.getHarvest(); 
        assertEquals(expResult, result); 
        
        // Test Case #4
        System.out.println("harvestCrops #2"); 
        ratTax = 4;
        result = testHarvestCropsObj.getHarvest(); 
        assertEquals(expResult, result); 
        
        // Test Case #5 
        System.out.println("harvestCrops #2"); 
        ratTax = 5;
        result = testHarvestCropsObj.getHarvest(); 
        assertEquals(expResult, result); 
    }
}
