package dominio;

import java.util.Arrays;

public class LogicGameBoard {
    private int width;
    private int height;
    private int[][] board;

    /**
     * Constructor fot the logicGameBoard class
     * @param width The number of cells of a row of the matrix
     * @param height The number of rows of the matrix
     */
    public LogicGameBoard(int width, int height) {
        this.width = width;
        this.height = height;

        this.board = new int[width][height];

        this.populateBoard();
    }

    /**
     * Method for populating the board
     */
    private void populateBoard(){
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                this.board[i][j] = 0;
            }
        }
    }

    /**
     * Method for inserting a new value on the board
     * @param x The 'X' position for the value on the matrix
     * @param y The 'Y' position for the value on the matrix
     * @param value The integer value for the jewell
     */
    public void updateBoard(int x, int y, int value){
        this.board[x][y] = value;
    }

    public void printBoard(){
        for (int[] row: this.board){
            System.out.println(Arrays.toString(row));
        }
    }
}
