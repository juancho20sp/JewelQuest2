package presentacion;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;

public class JewelQuestGUI extends JFrame{
    JPanel panelMenu;
    JLabel menuLabel;
    JButton newGameButton;
    JButton resumeGameButton;
    JButton openGameButton;
    JButton saveButton;
    JButton saveAsButton;
    JButton modifyBoardButton;
    JButton endGameButton;

    private boolean menuCreated = false;

    public static JPanel cards;
    public static Component toDelete;
    final static String MAIN_MENU = "main menu";
    final static String GAME_BOARD = "game board";

    GameBoard board;


    /**
     * Constructor of the JewelQuestGUI class
     */
    public JewelQuestGUI(){
        cards = new JPanel(new CardLayout());

        prepareElementos();
    }

    /**
     * Main method of the JewelQuestGUI
     * @param args
     */
    public static void main(String[] args) {
        JFrame frame = new JewelQuestGUI();

        //frame.setLayout(new CardLayout());
        frame.setVisible(true);
        frame.setResizable(true);
    }

    /**
     * Method for preparing all the elements of the GUI
     */
    private void prepareElementos(){
        setTitle("JewelQuest");

        // Definimos tamaño
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width / 2, screenSize.height / 2);


        // Definimos la posición
        setLocationRelativeTo(null);

        // Definimos la acción a realizar cuando se cierra
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event){
                askBeforeClosing();
            }
        });

        // Agregamos el contenedor principal
        add(cards);

        // Creamos el menú
        this.createMenu();

        // Preparamos las acciones del menú
        this.prepareAccionesMenu();
    }

    /**
     * Method for creating the menu and its layout
     */
    private void createMenu(){
        // Creamos el panel
        panelMenu = new JPanel();
        panelMenu.setLayout(new GridLayout(7, 3));
        panelMenu.setBackground(Color.ORANGE);

        // Creamos el label
        menuLabel = new JLabel("Menú principal");
        menuLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Agregamos el lanel
        if (menuCreated){
            remove(panelMenu);
            panelMenu.add(menuLabel);
        } else {
            panelMenu.add(menuLabel);
        }


        // Creamos los botones
        newGameButton = new JButton("Nuevo juego");
        resumeGameButton = new JButton("Continuar juego");
        openGameButton = new JButton("Abrir juego");
        saveButton = new JButton("Guardar juego");
        saveAsButton = new JButton("Guardar como");
        modifyBoardButton = new JButton("Modificar tablero");
        endGameButton = new JButton("Finalizar juego");

        // Agregamos los botones
        if (GameBoard.gameRunning){
            panelMenu.add(resumeGameButton);
        } else {
            panelMenu.add(newGameButton);
        }

        panelMenu.add(openGameButton);
        panelMenu.add(saveButton);
        panelMenu.add(saveAsButton);
        panelMenu.add(modifyBoardButton);
        panelMenu.add(endGameButton);

        // Agregamos el panel al frame
        cards.add(panelMenu, MAIN_MENU);
    }

    /**
     * Method for preparing all the actions that can be triggered by the user
     * in the menu
     */
    private void prepareAccionesMenu(){
        // Preparamos los eventos de click de los botones
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newGame();
            }
        });

        resumeGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("RESUME");
                resumeGame();
            }
        });

        openGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openGame();
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveGame();
            }
        });

        saveAsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveGameAs();
            }
        });

        modifyBoardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modifyBoard();
            }
        });


        endGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                endGame();
            }
        });

    }

    /**
     * Method for creating a new game
     */
    private void newGame(){
        board = new GameBoard(getWidth(), getHeight());

        this.createMenu();
        this.prepareAccionesMenu();


        cards.add(board, GAME_BOARD);

        //this.switchPanel(board);
        selectCard(GAME_BOARD);
    }

    /**
     * Method for resuming the game
     */
    private void resumeGame(){
        System.out.println("RESUME GAME");
        board = new GameBoard();

        selectCard(GAME_BOARD);
    }

    /**
     * Method for open a previously saved game
     */
    private void openGame(){
        JOptionPane.showMessageDialog(null, "Abrir juego");

        // JFileChooser
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Seleccione un juego");
        int selected = chooser.showOpenDialog(panelMenu);

        switch(selected){
            case JFileChooser.APPROVE_OPTION:
                File file = chooser.getSelectedFile();

                System.out.println("\nEsta lógica está en construcción");
                System.out.println("Opening " + file.getName() + " in " +file.getAbsolutePath());

                // Lógica con el documento
                JOptionPane.showMessageDialog(null, "Message selected");
                break;
            case JFileChooser.ERROR_OPTION:
                JOptionPane.showMessageDialog(null, "Something bad happened");
                break;
            case JFileChooser.CANCEL_OPTION:
                JOptionPane.showMessageDialog(null, "Cancel everything!");
                break;

        }
    }

    /**
     * Method for saving the current game
     */
    private void saveGame(){
        JOptionPane.showMessageDialog(null, "Guardar juego");

        // JFileChooser
        JFileChooser chooser = new JFileChooser();
        int selected = chooser.showSaveDialog(panelMenu);

        switch(selected){
            case JFileChooser.APPROVE_OPTION:
                File file = chooser.getSelectedFile();
                System.out.println("\nEsta lógica está en construcción");
                System.out.println("Saving " + file.getName() + " at " +file.getAbsolutePath());

                // Lógica con el docuumento
                JOptionPane.showMessageDialog(null, "Message selected");
                break;
            case JFileChooser.ERROR_OPTION:
                JOptionPane.showMessageDialog(null, "Something bad happened");
                break;
            case JFileChooser.CANCEL_OPTION:
                JOptionPane.showMessageDialog(null, "Cancel everything!");
                break;

        }
    }

    /**
     * Method for saving the current game in an specific location
     */
    private void saveGameAs(){
        JOptionPane.showMessageDialog(null, "Guardar como");

        // JFileChooser
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Seleccione un archivo para guardar el juego");
        int selected = chooser.showSaveDialog(panelMenu);

        switch(selected){
            case JFileChooser.APPROVE_OPTION:
                File file = chooser.getSelectedFile();
                System.out.println("\nEsta lógica está en construcción");
                System.out.println("Saving " + file.getName() + " at " +file.getAbsolutePath());

                // Lógica con el docuumento
                JOptionPane.showMessageDialog(null, "Message selected");
                break;
            case JFileChooser.ERROR_OPTION:
                JOptionPane.showMessageDialog(null, "Something bad happened");
                break;
            case JFileChooser.CANCEL_OPTION:
                JOptionPane.showMessageDialog(null, "Cancel everything!");
                break;

        }
    }

    /**
     * Method for modifying the board
     */
    private void modifyBoard(){
        JOptionPane.showMessageDialog(null, "Modificar tablero");
    }

    /**
     * Method for ending the current game
     */
    private void endGame(){
        askBeforeClosing();
    }

    /**
     * Method for verifying actions
     */
    private void askBeforeClosing() {
        String ObjButtons[] = {"Sí","No"};
        int PromptResult = JOptionPane.showOptionDialog(null,"¿Desea salir del programa?","JewelQuest",
                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[1]);

        if(PromptResult==JOptionPane.YES_OPTION)
        {
            System.exit(0);
        }
    }

    /**
     * Method for switching between panels
     */
    private void switchPanel(JPanel newPanel){

        /*panelMenu.setVisible(false);
        add(newPanel);

        invalidate();
        validate();

        repaint();*/
    }

    public void refresque(){
        invalidate();
        validate();

        repaint();
    }

    public static void selectCard(String card){
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, card);

    }


}
