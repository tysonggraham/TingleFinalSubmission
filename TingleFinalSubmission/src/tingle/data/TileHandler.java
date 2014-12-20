/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tingle.data;

/**
 * Singleton class TileHandler: Holds the currently selected tiles in mapgrid
 * and tile selector
 * 
 * @author Kevin
 */
public class TileHandler {
    private static TileHandler instance = null;
    private static Tile selectedMapTile;
    private static Tile selectedPlaceableTile;
    private static int zoom;
    public static TileSet globalTileSet;
    
    /**
     * Protected TileHandler constructor; keeps users from being able to 
     * construct additional TileHandler singletons.
     */
    protected TileHandler() {

    }
    
    /**
     * returns the instance of the singleton
     * @return 
     */
    public static TileHandler getInstance() {                
        if (instance == null)
            instance = new TileHandler();
        
        return instance;
    }
    
    /**
     * returns selected til in the map
     * @return 
     */
    public Tile getSelectedMapTile() {
        System.out.println("Returning: " + selectedMapTile);
        return selectedMapTile;
    }
    
    /**
     * 
     * @param input 
     */
    public void setSelectedMapTile(Tile input) {
        System.out.println("Selected Tile set as " + input);
        selectedMapTile = input;
    }
    
    /**
     * 
     * @return 
     */
    public Tile getSelectedPlaceableTile() {
        System.out.println("Returning: " + selectedPlaceableTile);
        return selectedPlaceableTile;
    }
    
    /**
     * 
     * @param input 
     */
    public void setSelectedPlaceableTile(Tile input) {
        System.out.println("Placeable Tile set as " + input);
        selectedPlaceableTile = input;
    }
    
    /**
     * 
     * @param input 
     */
    public static void setZoom(int input) {
        TileHandler.zoom = input;
    }

    /**
     * 
     * @return 
     */
    public static int getZoom() {
        return zoom;
    }
}
