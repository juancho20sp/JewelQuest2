package presentacion;

import javax.swing.*;
import java.awt.*;

public class GameBoard extends JPanel {
    private int width;
    private int height;

    private JPanel upperPanel;
    private JButton mainMenuButton;
    private JLabel movementsLabel;
    private JLabel pointsLabel;

    private JPanel boardPanel;
    private JButton board[][];

    /**
     * Constructor of the GameBoard class
     * @param height Height of the main frame
     * @param width Width of the main frame
     */
    public GameBoard(int width, int height){
        this.width = width - 18;
        this.height = height - 38;

        new JPanel();


        prepareElementosTablero();
    }

    private void prepareElementosTablero(){
        // Panel del menú superior
        upperPanel = new JPanel();
        upperPanel.setBounds(0, 0, this.width, 30);
        upperPanel.setBackground(Color.red);
        upperPanel.setLayout(new GridLayout(1, 3));

        // Definimos los elementos
        mainMenuButton = new JButton("Menú principal");

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
        boardPanel = new JPanel();
        boardPanel.setAlignmentX(SwingConstants.CENTER);
        //boardPanel.setPreferredSize(new Dimension(this.width, this.height - 30));
        boardPanel.setBounds(0, 30, this.width, this.height - 30);
        boardPanel.setBackground(Color.YELLOW);

        board = new JButton[6][6];

        int boxWidth = (this.width / 6);
        int boxHeight = ((this.height - 11)/ 6);

        System.out.println(boxWidth);
        System.out.println(boxHeight);

        // Definimos el layout del GameBoard
        setLayout(null);

        // Llenamos de labels
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                // Inicializamos el label
                board[i][j] = new JButton("Test");

                // Ubicamos el label
                board[i][j].setPreferredSize(new Dimension(boxWidth - 10, boxHeight - 10));
                board[i][j].setBounds(i * boxWidth, j * boxHeight, boxWidth, boxHeight);
                board[i][j].setVisible(true);

                // Agregamos el label al panel de juego
                boardPanel.add(board[i][j]);
                board[i][j].setBounds(i * boxWidth, (j * boxHeight) + 30, boxWidth, boxHeight);
            }
        }

        // Agregamos el panel al panel principal
        add(boardPanel);





    }

    private void refresque(){

    }
}
