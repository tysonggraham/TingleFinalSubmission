/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tingle.data;

/**
 *
 * @author Kevin
 */
public class TileCoordinates {
    private int x;
    private int y;
    
    public TileCoordinates() {
        x = -1;
        y = -1;
    }
    
    /**
     * build constructor object from Cartesian coordinates
     * 
     * @param x
     * @param y 
     */
    public TileCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * 
     * @return
     */
    public int getX() {
        return x;
    }
    
    /**
     * 
     * @return 
     */
    public int getY() {
        return y;
    }
    
    /**
     * 
     * @param x 
     */
    public void setX(int x) {
        this.x = x;
    }
    
    /**
     * 
     * @param y 
     */
    public void setY(int y) {
        this.y = y;
    }
    
    /**
    Overriden toString for the TileCoordinates class: returns "x,y"
    */
    @Override
    public String toString() {
        return String.format(x + "," + y);
    }
    @Override
    public boolean equals(Object other){
        
        // check for invalid cast here
        TileCoordinates tileOther = (TileCoordinates)other;
        
        return (x == tileOther.x && y == tileOther.y);
        
    }

    public int hashcode(){
       return x + y;
    }
    
}
