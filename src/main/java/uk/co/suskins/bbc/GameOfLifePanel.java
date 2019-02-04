package uk.co.suskins.bbc;

import javax.swing.*;
import java.awt.*;

/**
 * Game of Life Panel
 * <p>
 * Ben Suskins 2019
 * <p>
 * This class represents the JPanel
 * used to paint the game.
 */
class GameOfLifePanel extends JPanel {
    //Class Variables
    private static final int SIZE = 15; //Size of the squares

    //Instance Variables
    private final int rows;
    private final int columns;
    private boolean[][] array;

    /**
     * Constructor for Game Of Life Panel.
     *
     * @param rows    Number of rows to play - int
     * @param columns Number of columns to play - int
     */
    GameOfLifePanel(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    /**
     * Used to update the array to be drawn.
     *
     * @param array Boolean[][] Current Generation
     */
    void setArray(boolean[][] array) {
        this.array = array;
    }

    /**
     * Paint Component called to update
     * the panel with the current generation.
     * Paints the grid.
     *
     * @param g Graphics object
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int posX = 0;
        int posY = 0;
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (array[row][column]) { //If true set to black
                    g2d.setColor(Color.black);
                } else { //Else white
                    g2d.setColor(Color.white);
                }

                g2d.fill3DRect(posX, posY, SIZE, SIZE, true);
                posX += SIZE;
            }
            posY += SIZE;
            posX = 0;
        }
    }
}
