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
public class TileNGTest {
    
    public TileNGTest() {
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
     * Test of getTileUsed method, of class Tile.
     */
    @Test
    public void testGetTileUsed() {
        System.out.println("getTileUsed");
        TileCoordinates coordinates = new TileCoordinates();
        Tile instance = new Tile(coordinates, 12, 103);
        int expResult = 103;
        int result = instance.getTileUsed();
        assertEquals(result, expResult);
    }

    /**
     * Test of setTileUsed method, of class Tile.
     */
    @Test
    public void testSetTileUsed() {
        System.out.println("getTileUsed");
        TileCoordinates coordinates = new TileCoordinates();
        Tile instance = new Tile(coordinates, 12, 103);
        int expResult = 103;
        int result = instance.getTileUsed();
        assertEquals(result, expResult);
        expResult = 102;
        int tileUsed = 102;
        instance.setTileUsed(tileUsed);
        result = instance.getTileUsed();
        assertEquals(result, expResult);
       }

    /**
     * Test of getTileCoordinates method, of class Tile.
     */
    @Test
    public void testGetTileCoordinates() {
        System.out.println("getTileCoordinates");
        TileCoordinates coordinates = new TileCoordinates(2,3);
        Tile instance = new Tile(coordinates, 12, 103);
        TileCoordinates chords = new TileCoordinates(2,3);
        TileCoordinates expResult = chords;
        TileCoordinates result = instance.getTileCoordinates();
        assertEquals(result, expResult);
    }

    /**
     * Test of getTileProperties method, of class Tile.
     */
    @Test
    public void testGetTileProperties() {
        System.out.println("getTileProperties");
        TileCoordinates cordinates = new TileCoordinates(4,5);
        Tile instance = new Tile(cordinates, 1, 1);
        int expResult = 1;
        int result = instance.getTileProperties();
        assertEquals(result, expResult);
    }   
}
