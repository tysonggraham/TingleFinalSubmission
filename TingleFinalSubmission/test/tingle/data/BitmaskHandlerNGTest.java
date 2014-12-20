/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tingle.data;

import java.util.ArrayList;
import java.util.HashSet;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author TYSONANDJENN
 */
public class BitmaskHandlerNGTest {
    
    public BitmaskHandlerNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of getMask method, of class BitmaskHandler.
     */
    @Test
    public void testGetMask() {
        System.out.println("getMask");
        BitmaskHandler instance = new BitmaskHandler(111);
        int expResult = 111;
        int result = instance.getMask();
        assertEquals(result, expResult);
        
    }

    /**
     * Test of setMask method, of class BitmaskHandler.
     */
    @Test
    public void testSetMask() {
        System.out.println("setMask");
        int expMask = 1;
        BitmaskHandler instance = new BitmaskHandler(1);
        assertEquals(instance.getMask(), expMask);
        expMask = 0;
        instance.setMask(0);
        assertEquals(instance.getMask(), expMask);       
    }

    /**
     * Test of getDecodedMask method, of class BitmaskHandler.
     */
    @Test
    public void testGetDecodedMask() {
        System.out.println("getDecodedMask");
        ArrayList expResult = new ArrayList();
        expResult.add(true);
        expResult.add(false);
        BitmaskHandler instance = new BitmaskHandler(expResult);
        ArrayList result = instance.getDecodedMask();
        assertEquals(result, expResult);
        

    }

    /**
     * Test of setDecodedMask method, of class BitmaskHandler.
     */
    @Test
    public void testSetDecodedMask() {
        System.out.println("setDecodedMask");
        ArrayList expResult = new ArrayList();
        expResult.add(true);
        BitmaskHandler instance = new BitmaskHandler(expResult);
        ArrayList result = instance.getDecodedMask();
        assertEquals(result, expResult);
        expResult.add(false);
        instance.setDecodedMask(expResult);
        result = instance.getDecodedMask();
        assertEquals(result, expResult);
    }

    /**
     * Test of power method, of class BitmaskHandler.
     */
    @Test
    public void testPower() {
        System.out.println("power");
        int number = 2;
        int exp = 3;
  
        BitmaskHandler instance = new BitmaskHandler();
        int expResult = 8;
        int result = instance.power(number, exp);
        assertEquals(result, expResult);
    }
    
}
