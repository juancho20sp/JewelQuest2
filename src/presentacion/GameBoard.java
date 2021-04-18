package presentacion;

import dominio.*;
import dominio.jewel.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;
import java.util.Random;

public class GameBoard extends JPanel {
    private int width;
    private int height;

    private int rows = 6;
    private int cols = 6;

    private JPanel upperPanel;
    private JButton mainMenuButton;
    private JLabel movementsLabel;
    private JLabel pointsLabel;

    private JPanel boardPanel;

    private Random random;

    private LogicGameBoard logicBoard;

    private Color boardColor = Color.white;

    public static boolean gameRunning = false;
    public static Jewel board[][];

    /**
     * Constructor of the GameBoard class
     * @param height Height of the main frame
     * @param width Width of the main frame
     */
    public GameBoard(int width, int height){
        this.width = width - 18;
        this.height = height - 38;

        gameRunning = true;

        new JPanel();

        // Instanciamos Random
        this.random = new Random();

        prepareElementosTablero();
    }

    /**
     * Constructor for resuming the game
     * @param height Height of the main frame
     * @param width Width of the main frame
     * @param values The values of the matrix
     */
    public GameBoard(){
        new JPanel();

        redoGameBoard();
    }

    private void prepareElementosTablero(){
        // Panel del menú superior
        upperPanel = new JPanel();
        upperPanel.setBounds(0, 0, this.width, 30);
        upperPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        //upperPanel.setBackground(Color.red);
        upperPanel.setLayout(new GridLayout(1, 3));

        // Definimos los elementos
        mainMenuButton = new JButton("Menú principal");
        mainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleMainMenu();
            }
        });

        movementsLabel = new JLabel("Movimientos: 0", SwingConstants.CENTER);

        pointsLabel = new JLabel("Puntos: 0", SwingConstants.CENTER);

        // Agregamos los elementos al panel superior
        upperPanel.add(mainMenuButton);
        upperPanel.add(movementsLabel);
        upperPanel.add(pointsLabel);

        // Agregamos el panel superior al panel principal
        add(upperPanel);

        // Creamos el tablero de juego
        createGameBoard();
    }

    private void createGameBoard(){
        // Creamos el tablero lógico
        logicBoard = new LogicGameBoard(this.cols, this.rows);

        // Creamos el panel
        boardPanel = new JPanel();

        boardPanel.setBackground(this.boardColor);

        boardPanel.setAlignmentX(SwingConstants.CENTER);
        //boardPanel.setPreferredSize(new Dimension(this.width, this.height - 30));
        boardPanel.setBounds(0, 30, this.width, this.height - 30);
        //boardPanel.setBackground(Color.YELLOW);

        board = new Jewel[this.rows][this.cols];

        int boxWidth = (this.width / this.cols);
        int boxHeight = ((this.height - 11)/ this.rows);

        System.out.println(boxWidth);
        System.out.println(boxHeight);

        // Definimos el layout del GameBoard
        setLayout(null);

        // Llenamos de labels
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                // Inicializamos el label
                try{
                    // Insertamos la joya visual
                    board[i][j] = this.insertJewel();

                    // Insertamos la joya lógica
                    logicBoard.updateBoard(i, j, board[i][j].getId());

                } catch(JewelQuestException e){
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }


                // Ubicamos el label
                board[i][j].setPreferredSize(new Dimension(boxWidth - 10, boxHeight - 10));
                board[i][j].setBounds(i * boxWidth, j * boxHeight, boxWidth, boxHeight);


                // Agregamos el label al panel de juego
                boardPanel.add(board[i][j]);
            }
        }

        // Agregamos el panel al panel principal
        add(boardPanel);

        logicBoard.printBoard();



    }

    private void redoGameBoard(){
        // Creamos el tablero lógico
        logicBoard = new LogicGameBoard(this.cols, this.rows);

        // Creamos el panel
        boardPanel = new JPanel();

        boardPanel.setBackground(Color.red);

        System.out.println("Width: " + this.width);

        boardPanel.setAlignmentX(SwingConstants.CENTER);
        boardPanel.setBounds(0, 30, this.width, this.height - 30);

        int boxWidth = (this.width / this.cols);
        int boxHeight = ((this.height - 11)/ this.rows);

        // Definimos el layout del GameBoard
        setLayout(null);

        // Llenamos de labels
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                board[i][j] = this.getJewel(board[i][j].getId());

                // Insertamos la joya lógica
                logicBoard.updateBoard(i, j, board[i][j].getId());

                // Ubicamos el label
                //board[i][j].setPreferredSize(new Dimension(boxWidth - 10, boxHeight - 10));
                //board[i][j].setBounds(i * boxWidth, j * boxHeight, boxWidth, boxHeight);


                // Agregamos el label al panel de juego
                boardPanel.add(board[i][j]);
            }
        }

        // Agregamos el panel al panel principal
        add(boardPanel);

        logicBoard.printBoard();

        revalidate();
    }

    /**
     * Select a random number between 1 and 4
     * @return a new Jewel
     */
    private Jewel insertJewel() throws JewelQuestException{
        // Seleccionamos un número entre 1 y 4 aleatorio
        int option = random.nextInt(4) + 1;

        switch(option){
            case 1:
                return new BlueJewel();
            case 2:
                return new GreenJewel();
            case 3:
                return new RedJewel();
            case 4:
                return new YellowJewel();
            default:
                throw new JewelQuestException(JewelQuestException.RANDOM_ERROR);
        }

    }

    private Jewel getJewel(int id){
        switch(id){
            case 1:
                return new BlueJewel();
            case 2:
                return new GreenJewel();
            case 3:
                return new RedJewel();
            case 4:
                return new YellowJewel();
        }

        return null;
    }

    /**
     * Method for repainting the board
     */
    private void refresque(){
        this.upperPanel.revalidate();
        this.boardPanel.revalidate();
    }

    /**
     * Method for going back
     */
    private void toggleMainMenu(){
        /*setVisible(false);

        invalidate();
        validate();

        repaint();*/
        JewelQuestGUI.selectCard(JewelQuestGUI.MAIN_MENU);


    }
}
