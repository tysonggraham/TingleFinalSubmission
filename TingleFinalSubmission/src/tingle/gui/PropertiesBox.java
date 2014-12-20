/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tingle.gui;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import tingle.data.BitmaskHandler;
import tingle.data.Tile;
import tingle.data.TileCoordinates;
import tingle.data.TileHandler;

/**
 * 
 * @author TYSONANDJENN
 */
public class PropertiesBox implements ItemListener {
    private JLabel label;
    private ArrayList<JCheckBox> boxes;
    private JPanel panel;
    private Tile focusedTile;
    private BitmaskHandler bh;
    
    /**
     * PropertiesBox constructor, Initializes Jlabel for boxes, makes arrayList
     * to store all of the boxes. Creates a panel to store the properties box
     */
    public PropertiesBox () {
        label = new JLabel("Properties");
        boxes = new ArrayList<>();
        panel = new JPanel();
        focusedTile = null;                
        
        for (int i = 0; i < 10; i++) {
            JCheckBox temp = new JCheckBox();     
            temp.setText(getCheckBoxTitle(i));
            temp.addItemListener(this); //???
            
            if (i % 2 == 0)
                temp.setBounds(new Rectangle(4, (i * 20) + 20, 100, 20));
            else
                temp.setBounds(new Rectangle(100, ((i - 1) * 20) + 20, 100, 20));
            
            boxes.add(temp);
            panel.add(temp);
            
        }        
        panel.setPreferredSize(new Dimension(200, 100));
    }
    
    private void saveTile() {
        if (focusedTile != null) {
            int x = focusedTile.getTileCoordinates().getX();
            int y = focusedTile.getTileCoordinates().getY();
            
            int tileIndex = Tingle.myTingleDataManager.getTileIndexAtCoordinates(x, y);            
            //Tile updatedTile = new Tile(new TileCoordinates(x, y), focusedTile.getTileProperties());
            //Tile tileToUpdate = Tingle.myTingleDataManager.getMapTiles().get(tileIndex);
            //tileToUpdate.setTileProperties(focusedTile.getTileProperties());
            Tingle.myTingleDataManager.getMapTiles().get(tileIndex).setTileProperties(focusedTile.getTileProperties());
            System.out.println("");
            focusedTile = null;
        }
    }
    
    private void loadTile() {
        
        TileHandler tileHandler = TileHandler.getInstance();
        focusedTile = tileHandler.getSelectedMapTile();

        if (focusedTile == null) {
            System.out.println("Selected Map Tile has not yet been selected.");
            return;
        }
        
        int properties = focusedTile.getTileProperties();
        
        bh = new BitmaskHandler(properties);
        
        List<Boolean> list = bh.getDecodedMask();
        Collections.reverse(list);
        //System.out.println(list);
        
        int size = bh.getDecodedMask().size();
        List<Boolean> propertiesList = new ArrayList<>();
        
        for (int i = 0; i < boxes.size(); i++) {
            Boolean b = list.get(i);
            boxes.get(i).setSelected(b);
            propertiesList.add(b);
        }
        
        Collections.reverse(propertiesList);
        //System.out.println("PROPERTIES: " + propertiesList);
        bh = new BitmaskHandler((ArrayList<Boolean>) propertiesList);
        
        focusedTile.setTileProperties(bh.getMask());
    }
    
    public void update() {       
        saveTile();
        loadTile();
    }       
    
    private String getCheckBoxTitle(int number) {
        switch (number) {
            case 0:
                return "Solid";
            case 1:
                return "Water";
            case 2:
                return "Sticky";
            case 3:
                return "Mudlike";
            case 4:
                return "Bouncy";
            case 5:
                return "Breakable";
            case 6:
                return "Slippery";
            case 7:           
                return "Sink";
            case 8:
                return "Launchy";
            case 9:
                return "Spiky";
            default:
                return "NOT AVAILABLE";
        }       
}
    /**
     * @return the label
     */
    public JLabel getLabel() {
        return label;
    }

    /**
     * @param label the label to set
     */
    public void setLabel(JLabel label) {
        this.label = label;
    }

    /**
     * @return the boxes
     */
    public ArrayList<JCheckBox> getBoxes() {
        return boxes;
    }

    /**
     * @param boxes the boxes to set
     */
    public void setBoxes(ArrayList<JCheckBox> boxes) {
        this.boxes = boxes;
    }

    /**
     * @return the panel
     */
    public JPanel getPanel() {
        return panel;
    }

    /**
     * @param panel the panel to set
     */
    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    /**
     * Handles the event in which check boxes are enabled or disabled.  Rebuilds
     * the mask when a check box is altered
     * 
     * @param e 
     */
    @Override
    public void itemStateChanged(ItemEvent e) {
        int mask = 0;        
  
        for (int i = 0; i < boxes.size(); i++) {
            if (boxes.get(i).isSelected()) {
                mask += power(2, i);
            }                  
        }

        if (bh == null) {
            bh = new BitmaskHandler(mask);
        }
        else {
            bh.setMask(mask);
        }
        
        focusedTile.setTileProperties(bh.getMask());
        
        //Tingle.myTingleDataManager.getMapTiles().
    }
    
    public int power(int number, int exp) {
        int result = 1;       
                
        for (int i = 1; i <= exp; i++) {
            result *= number;
        }
        
        return result;
    }
}
    /**
     * @return the scrollPane
     */