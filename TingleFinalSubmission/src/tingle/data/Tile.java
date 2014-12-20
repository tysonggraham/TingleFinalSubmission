/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tingle.data;

import java.awt.image.BufferedImage;

/**
 * The tile class holds information relevant to an individual tile
 */
public class Tile {
    private TileCoordinates tileCoordinates;    //Grid location of tile
    private int tileProperties;             //bit masked property holder
    private int tileUsed;

    public int getTileUsed() {
        return tileUsed;
    }

    public void setTileUsed(int tileUsed) {
        this.tileUsed = tileUsed;
    }
    /**
     * 
     * @param coordinates
     * @param properties 
     */
    public Tile(TileCoordinates coordinates, int properties, int tileNum) {
        if (coordinates == null) {
            tileCoordinates = new TileCoordinates(-1, -1);
        } else {
            this.tileCoordinates = coordinates;
        }
        tileUsed = tileNum;
        this.tileProperties = properties;    
    }
    
    /**
     * 
     * @return 
     */
    public TileCoordinates getTileCoordinates() {
        return tileCoordinates;
    }
    
    /**
     * 
     * @param coordinates 
     */
    public void setTileCoordinates(TileCoordinates coordinates) {
        this.tileCoordinates = coordinates;
    }
    
    /**
     * 
     * @return 
     */
    public int getTileProperties() {
        return tileProperties;
    }
    
    /**
     * 
     * @param properties 
     */
    public void setTileProperties(int properties) {
        this.tileProperties = properties;
    }
    
    /**
     * 
     * @return coordinates:properties
     */
    @Override
    public String toString() {
        return String.format(tileCoordinates + ":" + tileProperties + ";" + tileUsed);
    }
}