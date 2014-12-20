
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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JPanel;
import tingle.data.TileCoordinates;
import tingle.data.Tile;
import tingle.data.TileHandler;

import tingle.data.TileSet;

public class MapGridGUI extends JPanel implements MouseListener, KeyListener{
    /**
     * 
     */
    public static GridCoordinates coord = new GridCoordinates();
    TileSet tiles;
    public double zoom;

    /**
     * 
     * @param zoom 
     */
    public void setZoom(double zoom) {
        this.zoom = zoom;
    }

    /**
     * 
     * @return 
     */
    public double getZoom() {
        return zoom;
    }
    /**
     * 
     * @param tiles 
     */
    public MapGridGUI(TileSet inputTiles) {
        super();
        this.tiles = inputTiles;
        System.out.println("Created: " + tiles.getImagesList().size() + " for map tiles");
        this.setPreferredSize(new Dimension(2048, 2048));
         zoom = 1.0;
    }

    /**
     * Override for paintcomponent to paint each tile in the mapgrid sets 
     * preferred size for tileset in mapgrid
     * @param g 
     */
    @Override
    public void paintComponent(Graphics g) {
        TileHandler th = TileHandler.getInstance();
        tiles = th.globalTileSet;
        this.setPreferredSize(new Dimension(((2048*th.getZoom())),2048*th.getZoom()));
        g.setColor(new Color(200, 200, 200));
        g.fillRect(0, 0, 2000, 2000);
        
    
        int zoomy = th.getZoom();
        
        int count = 0;
        
        int colCap = Tingle.myTingleDataManager.getMapWidth();
        int rowCap = Tingle.myTingleDataManager.getMapHeight();
 
        for(Tile tileToDraw:Tingle.myTingleDataManager.getMapTiles()){
           g.drawImage(tiles.getTile(tileToDraw.getTileUsed()), 
                   tileToDraw.getTileCoordinates().getX()*tiles.getTileWidth()*zoomy,
                   tileToDraw.getTileCoordinates().getY()*tiles.getTileHeight()*zoomy,
                  Math.round((float) (32*zoomy)), (int) Math.round(32*zoomy), this);

        }
        
        
        for (int c = 0; c < colCap; c++) {
            for (int r = 0; r < rowCap; r++) {
                
                count++;
                g.setColor(Color.DARK_GRAY);
                g.drawRect(Math.round((float) (r * 32*zoomy)), (int) Math.round(c * 32*zoomy), 32 *zoomy, 32*zoomy);
                //determine where to draw a white rectangle.
                if (coord.xSelected >= 0) {
                    g.setColor(Color.RED);
                    g.drawRect(coord.xSelected * 32 *zoomy, coord.ySelected * 32 *zoomy, 32 *zoomy, 32*zoomy);

                    g.setColor(Color.DARK_GRAY);
                }
            }
        }
        
        
    }
    /**
     * This allows you to copy tiles in the mapgrid and paste them in other
     * places in the mapgrid
     * @param e 
     */
    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("button pressed");
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            System.out.println("Right key pressed");
            zoom += .1;
            this.repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            System.out.println("Left key pressed");
            zoom -= .1;
            this.repaint();
        }
        
    }
    
     /**
      * 
      * @param e 
      */
    @Override
    public void mouseClicked(MouseEvent e) {
        
    }
    /**
     * 
     * @param e 
     */
    @Override
    public void mousePressed(MouseEvent e) {        
        // Set the coordinates for the selected tile.
        
        TileHandler th = TileHandler.getInstance();
        int zoomy = th.getZoom();
        
        coord.setx(e.getX() / (32*zoomy));
        coord.sety(e.getY() / (32*zoomy));
        

        
        int x = coord.getx(), y = coord.gety();       
        
        if (e.getButton() == MouseEvent.BUTTON1) {
            System.out.println("Left Click at " + x + ", " + y);
            
            int index = Tingle.myTingleDataManager.getTileIndexAtCoordinates(x, y);
//count = ((tiles.getNumTilesWidth() * y) + x);
            Tile tempTile = Tingle.myTingleDataManager.getMapTiles().get(index);
            th.setSelectedPlaceableTile(tempTile);     
            Tingle.propBox.update();
            this.repaint();
        }
        else if (e.getButton() == MouseEvent.BUTTON3) {
            System.out.println("Right Click at " + x + ", " + y);            
            
            if (th.getSelectedPlaceableTile() == null) {
                System.out.println("No placeable tile has been selected...");
                return;
            }
            
            //Load the tile we're modifying...
            int tileIndex = Tingle.myTingleDataManager.getTileIndexAtCoordinates(x, y);
            Tile tileToModify = Tingle.myTingleDataManager.getMapTiles().get(tileIndex);
            
            //int properties = tileToModify.getTileProperties();
            
            //Save the tile we've modified...                                    
            tileToModify.setTileUsed(th.getSelectedPlaceableTile().getTileUsed());
            
            Tingle.myTingleDataManager.getMapTiles().set(tileIndex, tileToModify);
            Tingle.propBox.update();
            
            this.repaint();
        }               
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
    
    /**
     * 
     * @param e 
     */
    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * 
     * @param e 
     */
    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    /**
     * GridCoordinates stores the coordinates for the selected tile.
     *
     */
    public static class GridCoordinates {

        private static int xSelected;
        private static int ySelected;

        GridCoordinates() {
            xSelected = -1;
            ySelected = -1;
        }

        public int getx() {
            return xSelected;
        }

        public int gety() {
            return ySelected;
        }

        public void setx(int input) {
            xSelected = input;
        }

        public void sety(int input) {
            ySelected = input;
        }
    }
}