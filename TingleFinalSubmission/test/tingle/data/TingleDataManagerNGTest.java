/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tingle.data;

import java.awt.Graphics;
import java.io.File;
import java.util.List;
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
public class TingleDataManagerNGTest {
    
    public TingleDataManagerNGTest() {
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

//    /**
//     * Test of saveFile method, of class TingleDataManager.
//     */
//    @Test
//    public void testSaveFile() {
//        System.out.println("saveFile");
//        TingleDataManager instance = new TingleDataManager();
//        instance.saveFile();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of loadFile method, of class TingleDataManager.
//     */
//    @Test
//    public void testLoadFile() {
//        System.out.println("loadFile");
//        TingleDataManager instance = new TingleDataManager();
//        instance.loadFile();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getMapTiles method, of class TingleDataManager.
//     */
//    @Test
//    public void testGetMapTiles() {
//        System.out.println("getMapTiles");
//        TingleDataManager instance = new TingleDataManager();
//        List expResult = null;
//        List result = instance.getMapTiles();
//        assertEquals(result, expResult);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getTile method, of class TingleDataManager.
//     */
//    @Test
//    public void testGetTile() {
//        System.out.println("getTile");
//        int count = 0;
//        TingleDataManager instance = new TingleDataManager();
//        Tile expResult = null;
//        Tile result = instance.getTile(count);
//        assertEquals(result, expResult);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getTileIndexAtCoordinates method, of class TingleDataManager.
//     */
//    @Test
//    public void testGetTileIndexAtCoordinates() {
//        System.out.println("getTileIndexAtCoordinates");
//        int x = 0;
//        int y = 0;
//        TingleDataManager instance = new TingleDataManager();
//        int expResult = 0;
//        int result = instance.getTileIndexAtCoordinates(x, y);
//        assertEquals(result, expResult);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setMapTiles method, of class TingleDataManager.
//     */
//    @Test
//    public void testSetMapTiles() {
//        System.out.println("setMapTiles");
//        List<Tile> mapTiles = null;
//        TingleDataManager instance = new TingleDataManager();
//        instance.setMapTiles(mapTiles);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getTileGraphics method, of class TingleDataManager.
//     */
//    @Test
//    public void testGetTileGraphics() {
//        System.out.println("getTileGraphics");
//        int input = 0;
//        TingleDataManager instance = new TingleDataManager();
//        List expResult = null;
//        List result = instance.getTileGraphics(input);
//        assertEquals(result, expResult);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setTileGraphics method, of class TingleDataManager.
//     */
//    @Test
//    public void testSetTileGraphics() {
//        System.out.println("setTileGraphics");
//        List<Graphics> tileGraphics = null;
//        TingleDataManager instance = new TingleDataManager();
//        instance.setTileGraphics(tileGraphics);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

//    /**
//     * Test of getMapFile method, of class TingleDataManager.
//     */
//    @Test
//    public void testGetMapFile() {
//        System.out.println("getMapFile");
//        TingleDataManager instance = new TingleDataManager();
//        File expResult = null;
//        File result = instance.getMapFile();
//        assertEquals(result, expResult);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setMapFile method, of class TingleDataManager.
//     */
//    @Test
//    public void testSetMapFile() {
//        System.out.println("setMapFile");
//        File mapFile = null;
//        TingleDataManager instance = new TingleDataManager();
//        instance.setMapFile(mapFile);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getMapWidth method, of class TingleDataManager.
//     */
//    @Test
//    public void testGetMapWidth() {
//        System.out.println("getMapWidth");
//        TingleDataManager instance = new TingleDataManager();
//        int expResult = 0;
//        int result = instance.getMapWidth();
//        assertEquals(result, expResult);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getMapHeight method, of class TingleDataManager.
//     */
//    @Test
//    public void testGetMapHeight() {
//        System.out.println("getMapHeight");
//        TingleDataManager instance = new TingleDataManager();
//        int expResult = 0;
//        int result = instance.getMapHeight();
//        assertEquals(result, expResult);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setMapWidth method, of class TingleDataManager.
//     */
//    @Test
//    public void testSetMapWidth() {
//        System.out.println("setMapWidth");
//        int mapWidth = 0;
//        TingleDataManager instance = new TingleDataManager();
//        instance.setMapWidth(mapWidth);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setMapHeight method, of class TingleDataManager.
//     */
//    @Test
//    public void testSetMapHeight() {
//        System.out.println("setMapHeight");
//        int mapHeight = 0;
//        TingleDataManager instance = new TingleDataManager();
//        instance.setMapHeight(mapHeight);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
//}
