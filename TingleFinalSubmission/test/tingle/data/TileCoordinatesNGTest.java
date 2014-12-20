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
public class TileCoordinatesNGTest {
    
    public TileCoordinatesNGTest() {
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
     * Test of getX method, of class TileCoordinates.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        TileCoordinates instance = new TileCoordinates(0,1);
        int expResult = 0;
        int result = instance.getX();
        assertEquals(result, expResult);
    }

    /**
     * Test of getY method, of class TileCoordinates.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        TileCoordinates instance = new TileCoordinates(0,1);
        int expResult = 1;
        int result = instance.getY();
        assertEquals(result, expResult);
    }

    /**
     * Test of setX method, of class TileCoordinates.
     */
    @Test
    public void testSetX() {
        System.out.println("setX");
        int x = 0;
        TileCoordinates instance = new TileCoordinates();
        instance.setX(x);
    }

    /**
     * Test of setY method, of class TileCoordinates.
     */
    @Test
    public void testSetY() {
        System.out.println("setY");
        int y = 0;
        TileCoordinates instance = new TileCoordinates();
        instance.setY(y);
    }

    /**
     * Test of toString method, of class TileCoordinates.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        TileCoordinates instance = new TileCoordinates(1,0);
        String expResult = "1,0";
        String result = instance.toString();
        assertEquals(result, expResult);
    }

    /**
     * Test of equals method, of class TileCoordinates.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        TileCoordinates otherInstance = new TileCoordinates(2,3);
        TileCoordinates instance = new TileCoordinates(2,3);
        boolean expResult = true;
        boolean result = instance.equals(otherInstance);
        assertEquals(result, expResult);
    }

    /**
     * Test of hashcode method, of class TileCoordinates.
     */
    @Test
    public void testHashcode() {
        System.out.println("hashcode");
        TileCoordinates instance = new TileCoordinates(1,0);
        int expResult = 1;
        int result = instance.hashcode();
        assertEquals(result, expResult);
    }
    
}
