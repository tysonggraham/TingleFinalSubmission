/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tingle.data;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

/**
 *
 * @author Dallin
 */
public class TileSet {

    private BufferedImage image;
    List<BufferedImage> imagesList;
    private int tileHeight;
    private int tileWidth;
    private int numTilesWidth;
    private int numTilesHeight;
    private int numTiles;

    /**
     * Builds TIleset, loaded from a file
     * @param fileName 
     */
    public TileSet(String fileName) {
        tileHeight = 32;
        tileWidth = 32;
        
        System.out.println("Creating TileSet for file: " + fileName);

        imagesList = new ArrayList<>();
        
        createTileSet(fileName);
    }

    /**
     * creates and initializes tileset, loaded from a default file
     * @param fileName 
     */
    private void createTileSet(String fileName) {
        try {
            File file = new File(fileName);
            
            if (!file.exists())
                throw new IOException("File not found...");
            
            image = ImageIO.read(new File(fileName));
            
            numTilesWidth = image.getWidth() /tileWidth; //Set how many tiles on the X axis there are
            numTilesHeight = image.getHeight() / tileHeight; //Set how many tiles on the Y axis there are
            numTiles = numTilesHeight * numTilesWidth;
            
            for (int h = 0; h < numTilesHeight; h++) {
                for (int w = 0; w < numTilesWidth; w++) {
                    imagesList.add(image.getSubimage(w * tileWidth, h * tileHeight, tileWidth, tileHeight));
                }
            }
        } catch (IOException e) {
            System.out.println("IOException catch: " + e);
            e.printStackTrace();
        }
    }

    /**
     * 
     * @return 
     */
    public int getNumTilesWidth() {
        return numTilesWidth;
    }
        /**
         * 
         * @return 
         */
    public int getNumTiles() {
        return numTiles;
    }
    /**
     * 
     * @param image 
     */
    public void setImage(BufferedImage image) {
        this.image = image;
    }
    
    /**
     * 
     * @param tileHeight 
     */
    public void setTileHeight(int tileHeight) {
        this.tileHeight = tileHeight;
    }

        /**
         * 
         * @param tileWidth 
         */
    public void setTileWidth(int tileWidth) {
        this.tileWidth = tileWidth;
    }
    /**
     * 
     * @return 
     */
    public BufferedImage getImage() {
        return image;
    }
    /**
     * 
     * @return 
     */
    public List<BufferedImage> getImagesList() {
        return imagesList;
    }
    /**
     * returns tile at given index
     * @param index
     * @return 
     */
    public BufferedImage getTile(int index) {
        if (imagesList.isEmpty()) {
            return null;
        } else if (index >= imagesList.size()) {
            return null;
        } else if (index < 0) {
            return null;
        } else {
            return imagesList.get(index);
        }

    }
    
    /**
     * 
     * @return 
     */
    public int getTileHeight() {
        return tileHeight;
    }
    
    /**
     * 
     * @return 
     */
    public int getTileWidth() {
        return tileWidth;
    }

}
