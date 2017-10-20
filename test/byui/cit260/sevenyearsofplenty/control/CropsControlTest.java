/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.sevenyearsofplenty.control;

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
        
        int cropYield;
        int low;
        int high;
        int expResult;
        int result;
        
        // Test Case #1 
        System.out.println("payPharoah #1");
        cropYield = 1;
        expResult = 0;
        result = CropsControl.payPharoah(cropYield);
        assertEquals(expResult, result);
        
        // Test Case #2        
        System.out.println("payPharoah #2");
        cropYield = 234;
        low = 191;
        high = 219;
        result = CropsControl.payPharoah(cropYield);
        assertTrue("Error, result is too low", low <= result);
        assertTrue("Error, result is too high", high >= result);
        
        // Test Case #3
        System.out.println("payPharoah #3");
        cropYield = 1000;
        low = 820;
        high = 940;
        result = CropsControl.payPharoah(cropYield);
        assertTrue("Error, result is too low", low <= result);
        assertTrue("Error, result is too high", high >= result);
        
        // Test Case #4
        System.out.println("payPharoah #4");
        cropYield = -100;
        expResult = -1;
        result = CropsControl.payPharoah(cropYield);
        assertEquals(expResult, result);
        
        // Test Case #5
        System.out.println("payPharoah #5");
        cropYield = 0;
        expResult = 0;
        result = CropsControl.payPharoah(cropYield);
        assertEquals(expResult, result);
    }
    
    
}
