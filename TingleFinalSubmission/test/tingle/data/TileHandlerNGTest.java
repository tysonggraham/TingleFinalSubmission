/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tingle.data;

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
public class TileHandlerNGTest {
    
    public TileHandlerNGTest() {
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
     * Test of setZoom method, of class TileHandler.
     */
    @Test
    public void testSetZoom() {
        System.out.println("setZoom");
        int input = 1;
        TileHandler.setZoom(input);
        int expResult = 1;
        assertEquals(input, expResult);
    }

    /**
     * Test of getZoom method, of class TileHandler.
     */
    @Test
    public void testGetZoom() {
        System.out.println("getZoom");
        int expResult = 0;
        int result = TileHandler.getZoom();
        assertEquals(result, expResult);
    }
    
}
