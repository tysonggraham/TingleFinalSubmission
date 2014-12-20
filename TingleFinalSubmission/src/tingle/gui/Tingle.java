/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package tingle.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import tingle.gui.popups.AboutWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import tingle.data.Tile;
import tingle.data.TileHandler;
import tingle.data.TileSet;
import tingle.data.TingleDataManager;

/*
* This is the main class that holds all of the data members and Gui Members
* This is the main class. This class initializes the GUI and holds objects
* that hold the data. This is basically the controller.
*/
public class Tingle extends JFrame {
    
    //BEGIN GUI MEMBERS
    
    public static JFrame frame;
    public static JMenuBar menuBar;
    public static JPanel tileSelectorScrollPane;
    public static JPanel mapGridScrollPane;
    public static JScrollPane propertiesBox;
    public static PropertiesBox propBox;
    Component bottomPane;
    
    
    // public static
    
    //BEGIN DATA MEMBERS
    public static TingleDataManager myTingleDataManager;
    public static Tile currentSelectedMapTile;
    public static Tile currentSelectedTileToPlace;
    
    /**
     * Tingle Constructor, intializes the Data manager and loads in the map file
     * it also calls the run() function which starts the GUI
     */
    private Tingle() {
        myTingleDataManager = new TingleDataManager(new File("src\\resources\\testLoad.tingle"));
        myTingleDataManager.loadFile();
        try {
            run();
        } catch (IOException ex) {
            Logger.getLogger(Tingle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Initializes the main JFrame state, size, layout, title, and close
     * operation
     */
    private void initializeFrame() {
        TileHandler th = TileHandler.getInstance();
        frame = new JFrame("Tingle Map Editor - src\\resources\\minecraft.png");
        th.globalTileSet = new TileSet("src\\resources\\minecraft.png");
        frame.setLayout(new BorderLayout());
        
        
        frame.setSize(1366, 740);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(640, 480));
        
        // sets icon
        ImageIcon img = new ImageIcon("src\\resources\\tingleIcon.png");
        frame.setIconImage(img.getImage());
    }
    
    /**
     * Creates the menu bar to be used within the main JFrame
     */
    private void createMenuBar() {
        menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        
        //BEGIN FILE MENU
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        
        JMenuItem newFile = new JMenuItem("New");
        JMenuItem openFile = new JMenuItem("Open...");
        JMenuItem saveFile = new JMenuItem("Save");
        JMenuItem saveAsFile = new JMenuItem("Save As...");
        JMenuItem openNewTileSet = new JMenuItem("Open Tile Set...");
        JMenuItem exit = new JMenuItem("Exit");
        JMenuItem zoomIn = new JMenuItem("Zoom In");
        JMenuItem zoomOut = new JMenuItem("Zoom Out");
        
        fileMenu.add(newFile);
        fileMenu.add(openFile);
        fileMenu.add(openNewTileSet);
        fileMenu.add(saveFile);
        fileMenu.add(saveAsFile);
        fileMenu.add(exit);
        fileMenu.add(zoomIn);
        fileMenu.add(zoomOut);
        
        
        //BEGIN ABOUT MENU
        JMenu aboutMenu = new JMenu("About");
        menuBar.add(aboutMenu);
        
        JMenuItem about = new JMenuItem("About");
        
        aboutMenu.add(about);
        
        //BEGIN ACTION LISTENERS
        about.addActionListener(new AboutAction());
        exit.addActionListener(new ExitAction());
        newFile.addActionListener(new NewFileAction());
        openFile.addActionListener(new OpenFileAction());
        openNewTileSet.addActionListener(new OpenTileSetAction());
        saveFile.addActionListener(new SaveFileAction());
        saveAsFile.addActionListener(new SaveAsFileAction());
        zoomOut.addActionListener(new zoomOutAction());
        zoomIn.addActionListener(new zoomInAction());
    }
    
    /**
     * Creates the bottom pane which h0lds the properties box as well as the
     * Tileselector. This sets their location in the bottom pane by giving
     * them a borderlayout to organize them and putting the propbox in the left, the
     * tileselcted in the right.
     * @param tileSet
     * @return
     */
    private JPanel createBottomPane(String tileSet) {
        JPanel bottomPane = new JPanel();
        bottomPane.setLayout(new BorderLayout());
        JScrollPane tileScroll = new JScrollPane(createTileSelectorScrollPane(tileSet));
        tileScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        bottomPane.add(tileScroll, BorderLayout.CENTER);
        bottomPane.add(new JScrollPane(createPropertiesBox()), BorderLayout.WEST);
        return bottomPane;
    }
    
    /**
     * Creates the tileSelector scroll pane and adds it to the JFrame.
     */
    private JPanel createTileSelectorScrollPane(String input) {
        TileHandler th = TileHandler.getInstance();
        TileSelector ts = new TileSelector(th.globalTileSet);
        tileSelectorScrollPane = ts;
        
        return tileSelectorScrollPane;
    }
    /**
     * Initializes the JScrollPane for the mapgrid and tileselector
     *
     */
    private JScrollPane createMapViewGUIScrollPane() {
        TileHandler th = TileHandler.getInstance();
        MapGridGUI mapView = new MapGridGUI(th.globalTileSet);
        mapGridScrollPane = mapView;
        JScrollPane scroll = new JScrollPane(mapGridScrollPane);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        return scroll;
    }
    
    /**
     * Creates the PropertiesBox and adds it to the JFrame.
     */
    private JPanel createPropertiesBox() {
        propBox = new PropertiesBox();
        
        return propBox.getPanel();
    }
    
    /**
     * Runs the GUI
     */
    private void run() throws IOException {
       // File file = new File("config.properties");
        //System.out.println(file.getAbsolutePath());

//      Logging is almost done, we just need to fix what's in the properties file
        LogManager manager = LogManager.getLogManager();
        String propFile = "/tingle/gui/config.properties";
        manager.readConfiguration(manager.getClass().getResourceAsStream(propFile));
        Logger logger = Logger.getLogger("myLaunchy");
        logger.log(Level.SEVERE,"This is not cool brah!");
        logger.log(Level.WARNING,"whoa whoa calm down my nookah!");
        
        initializeFrame();
        createMenuBar();
        TileHandler th = TileHandler.getInstance();
        th.setZoom(1);
        Component bottomPane = createBottomPane("src\\resources\\minecraft.png");
        frame.add(bottomPane, BorderLayout.SOUTH);
        frame.add(createMapViewGUIScrollPane(), BorderLayout.CENTER);
        frame.setVisible(true);
        
        tileSelectorScrollPane.addMouseListener((MouseListener) tileSelectorScrollPane);
        mapGridScrollPane.addMouseListener((MouseListener) mapGridScrollPane);
        frame.addKeyListener((KeyListener) mapGridScrollPane);
        
    }
    
    /**
     * Main method for the Tingle Map Editor program. Where the magic begins!
     *
     * @param args
     */
    public static void main(String[] args) {
        Tingle tingle = new Tingle();
    }
    
    ///BEGIN PUBLIC CLASSES///
    /**
     * public action listener class which handles the about menu option
     */
    public class AboutAction implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            AboutWindow gui = new AboutWindow(Tingle.this);
            gui.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            gui.setSize(340, 125);
            gui.setLocation(300, 300);
            gui.setVisible(true);
            gui.setTitle("Tingle Map Editor");
        }
    }
    
    /**
     * public action listener class which handles the exit menu option
     */
    public class ExitAction implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            int result = JOptionPane.showConfirmDialog(null, "Do you wish to save before exiting?", "Tingle Data Manager", WIDTH);
            
            if (result == 0) {
                myTingleDataManager.saveFile();
                System.exit(0);
            } else if (result == 1) {
                System.exit(0);
            }
        }
    }
    
    /**
     * public action listener class which handles the new file creation option
     */
    public class NewFileAction implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if (myTingleDataManager.getMapFile() != null) {
                //Save before closing dialog
            }
            
            myTingleDataManager = new TingleDataManager();
            frame.setTitle("Tingle Map Editor - New File (unsaved!)" );
        }
    }
    
    /**
     * public action listener class which handles the open file menu dialog
     */
    public class OpenFileAction implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            final JFileChooser fc = new JFileChooser();
            FileFilter filter = new FileNameExtensionFilter("Tingle Map File", "tingle");
            fc.setFileFilter(filter);
            
            JLabel myLabel = new JLabel("");
            
            int response = fc.showOpenDialog(Tingle.this);
            
            if (response == JFileChooser.APPROVE_OPTION) {
                myTingleDataManager.setMapFile(new File(fc.getSelectedFile().toString()));
                myTingleDataManager.loadFile();
                frame.repaint();
                frame.setTitle("Tingle Map Editor - "+ fc.getSelectedFile().toString() );
            }
        }
    }
    
    /**
     * public action listener class which handles the open tileset menu dialog
     */
    
    public class OpenTileSetAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            final JFileChooser fc = new JFileChooser();
            
            fc.addChoosableFileFilter(new FileNameExtensionFilter(".bmp", "bmp"));
            fc.setFileFilter(new FileNameExtensionFilter(".jpeg", "jpeg"));
            //fc.addChoosableFileFilter(new FileNameExtensionFilter("png", "*.png"));
            fc.setFileFilter(new FileNameExtensionFilter(".png", "png"));
            JLabel myLabel = new JLabel("");
            
            int response = fc.showOpenDialog(Tingle.this);
            
            if (response == JFileChooser.APPROVE_OPTION) {
                //bottomPane =createBottomPane(fc.getSelectedFile().toString());
                TileHandler th = TileHandler.getInstance();
                th.globalTileSet = new TileSet(fc.getSelectedFile().toString());
                
                frame.repaint();
            }
        }
    }
    
    
    
    /**
     * public action listener class which handles the save menu operation
     */
    public class SaveFileAction implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            myTingleDataManager.saveFile();
        }
    }
    
    /**
     * public action listener class which handles the save as menu dialog.
     */
    public class SaveAsFileAction implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            final JFileChooser fc = new JFileChooser();
            
            JLabel myLabel = new JLabel("");
            
            int response = fc.showSaveDialog(Tingle.this);
            
            if (response == JFileChooser.APPROVE_OPTION) {
                myTingleDataManager.setMapFile(new File(fc.getSelectedFile().toString()));
                //System.out.println(myTingleDataManager.getMapFile());
                myTingleDataManager.saveFile();
                frame.setTitle("Tingle Map Editor - "+ fc.getSelectedFile().toString() );
            }
        }
    }
    /**
     * menu button listener that zooms into the mapgrid
     */
    public class zoomInAction implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            TileHandler th  = TileHandler.getInstance();
            th.setZoom(th.getZoom()+1);
            System.out.println("zoomed");
            frame.repaint();
        }
    }
    
    /**
     * menu button listener that zooms into the mapgrid
     */   
    public class zoomOutAction implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            TileHandler th  = TileHandler.getInstance();
            if (th.getZoom() == 1)
                System.out.println("zoomed out all I will let you!");
            else{
                th.setZoom(th.getZoom()-1);
                System.out.println("zoomed");
                frame.repaint();
            }
        }
    }
}