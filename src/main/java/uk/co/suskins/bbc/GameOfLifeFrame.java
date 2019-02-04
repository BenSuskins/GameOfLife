package uk.co.suskins.bbc;

import javax.swing.*;

/**
 * Game of Life View
 * <p>
 * Ben Suskins 2019
 * <p>
 * This class represents the JFrame
 * used to show the Game of Life.
 */
class GameOfLifeFrame {
    //Instance Variables
    private JFrame frame;
    private GameOfLifePanel panel;

    /**
     * Constructor for Game Of Life Frame.
     *
     * @param rows    Number of rows to play - int
     * @param columns Number of columns to play - int
     */
    GameOfLifeFrame(int rows, int columns) {
        this.panel = new GameOfLifePanel(rows, columns);
        createFrame();
    }

    /**
     * Creates the JFrame for the game
     * and adds the Game Of Life Panel object.
     */
    private void createFrame() {
        this.frame = new JFrame("Game of Life Ben Suskins");
        this.frame.add(panel);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.frame.setVisible(true);
    }

    /**
     * Takes the current generation and supplies it
     * to the Game of Life Panel and repaints the frame.
     *
     * @param array Boolean[][] Current Generation to paint
     */
    void drawGame(boolean[][] array) {
        panel.setArray(array);
        frame.repaint();
    }
}
