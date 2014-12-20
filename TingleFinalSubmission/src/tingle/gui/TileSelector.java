/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package tingle.gui;

/**
 *
 * @author Dallin
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import tingle.data.Tile;
import tingle.data.TileCoordinates;
import tingle.data.TileHandler;

import tingle.data.TileSet;

/**
 * Creates the Jpanel that holds tileselector
 * @author TYSONANDJENN
 */
public class TileSelector extends JPanel implements MouseListener {
    
    public static Coordinates coord = new Coordinates();
    TileSet tiles;
    BufferedImage subImage; //The currently selected tile for quick reference
    
    /**
     * Builds tileselector from tileset
     * @param tiles
     */
    public TileSelector(TileSet tiles) {
        super();
        this.tiles = tiles;
        System.out.println("Created: " + tiles.getImagesList().size() + " for tile graphics");
        
        this.setPreferredSize(new Dimension(((tiles.getNumTiles()*tiles.getTileWidth()) /6),193));
        
    }
    
    /**
     * overriding paint component to allow tiles to repaint themselves within the tileset
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        TileHandler th = TileHandler.getInstance();
        tiles = th.globalTileSet;
        this.setPreferredSize(new Dimension(((tiles.getNumTiles()*tiles.getTileWidth()) /6),193));
        g.setColor(Color.DARK_GRAY);
        int count = 0;
        for (int c = 0; c < 6; c++){
            for (int r = 0; r < (tiles.getNumTiles()/6); r++){
                g.drawImage(tiles.getTile(count), r*tiles.getTileWidth(), c*tiles.getTileHeight(), tiles.getTileWidth(), tiles.getTileHeight(),Color.WHITE, this);
                
                count++;
                
                g.drawRect(r * 32, c * 32, 32, 32);
                
                if (coord.xSelected >= 0) {
                    g.setColor(Color.WHITE);
                    g.drawRect(coord.xSelected * 32, coord.ySelected * 32, 32, 32);
                    
                    g.setColor(Color.DARK_GRAY);
                }
            }
        }
    }
    
    /**
     * Coordinates stores the coordinates for the selected tile.
     *
     */
    public static class Coordinates {
        
        private static int xSelected;
        private static int ySelected;
        
        Coordinates() {
            xSelected = -1;
            ySelected = -1;
        }
        /**
         *
         * @return
         */
        
        public int getx() {
            return xSelected;
        }
        
        /**
         *
         * @return
         */
        
        public int gety() {
            return ySelected;
        }
        
        /**
         *
         * @param input
         */
        public void setx(int input) {
            xSelected = input;
        }
        
        /**
         *
         * @param input
         */
        public void sety(int input) {
            ySelected = input;
        }
    }
    
    /**
     * mouse listener that indicates that a tile has been clicked and gives
     * the coordinates of that tile
     * @param e
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        
        // Set the coordinates for the selected tile.
        coord.setx(e.getX() / 32);
        coord.sety(e.getY() / 32);
        System.out.println("There was a click at " + coord.getx() + ", " + coord.gety() + "!");
        this.repaint();
        
        TileHandler th = TileHandler.getInstance();
        int count = (((tiles.getNumTiles()/6) * coord.gety()) + coord.getx());
        System.out.println("I think it's at: "+count);
        Tile placeTile = new Tile(new TileCoordinates(1,1), 0, count);
        th.setSelectedPlaceableTile(placeTile);
    }
    
    /**
     * 
     * @param e 
     */
    @Override
    public void mousePressed(MouseEvent e) {
        //System.out.println("here was a click ! ");
    }
    
    /**
     * 
     * @param e 
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        //System.out.println("here was a click ! ");
    }
    
    /**
     * 
     * @param e 
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        //System.out.println("here was a click ! ");
    }
    
    /**
     * 
     * @param e 
     */
    @Override
    public void mouseExited(MouseEvent e) {
        //System.out.println("here was a click ! ");
    }
}
