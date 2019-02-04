package uk.co.suskins.bbc;

import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Game of Life
 * <p>
 * Ben Suskins 2019
 * <p>
 * This class represents the logic
 * for the Game of Logic.
 */
class GameOfLife {
    private final int rows;
    private final int columns;
    //Instance Variables
    private boolean[][] generation;
    private TimerTask game;
    private GameOfLifeFrame gameOfLifeFrame;

    /**
     * Constructor for Game Of Life.
     *
     * @param rows    Number of rows to play - int
     * @param columns Number of columns to play - int
     */
    GameOfLife(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;

        //Start the game from here
        initialiseGame();

        //Start a time or something
        startTimer();
    }

    /**
     * Starts a Timer task which runs the
     * game by evolving and drawing every 60ms
     */
    private void startTimer() {
        game = new TimerTask() {
            @Override
            public void run() {
                drawGeneration();
                generation = evolveGeneration();
            }
        };
        new Timer().schedule(game, 0, 60);
    }

    /**
     * Evolves the current generation
     * by cloning the current generation,
     * then iterating through cell to get its neighbours
     * it will then play out the correct scenario based on the
     * number of neighbours.
     *
     * @return New Boolean[][] with an evolved generation
     */
    private boolean[][] evolveGeneration() {
        //Clone current generation
        boolean[][] nextGeneration = Arrays.stream(generation)
                .map(boolean[]::clone)
                .toArray(boolean[][]::new);

        //Iterate through and play out scenarios
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                int neighbours = getNeighbours(nextGeneration, row, column);

                if (neighbours < 2) { //Scenario 1
                    nextGeneration[row][column] = false;
                } else if (neighbours > 3) { //Scenario 2
                    nextGeneration[row][column] = false;
                } else if (neighbours == 2) { //Scenario 3
                    nextGeneration[row][column] = generation[row][column];
                } else {//Scenario 3
                    nextGeneration[row][column] = true;
                }
            }
        }

        //Return new generation
        return nextGeneration;
    }

    /**
     * Calls the view to draw the game with
     * the current generation.
     */
    private void drawGeneration() {
        gameOfLifeFrame.drawGame(this.generation);
    }

    /**
     * Sets up the game with a random seed.
     */
    private void initialiseGame() {
        //Initialise Variables
        Random random = new Random();
        this.generation = new boolean[rows][columns];
        this.gameOfLifeFrame = new GameOfLifeFrame(rows, columns);

        //Initialise randomly
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                this.generation[row][column] = random.nextBoolean();
            }
        }
    }

    /**
     * Gets the number of neighbours a supplied cell and generation has.
     *
     * @param generation Array to search
     * @param cellRow    Row to check
     * @param cellColumn Column to check
     * @return Int number of neighbours the cell has
     */
    private int getNeighbours(boolean[][] generation, int cellRow, int cellColumn) {
        int neighbours = 0;

        for (int row = Math.max(0, cellRow - 1);
             row <= Math.min(cellRow + 1, generation.length - 1); ++row) {
            for (int column = Math.max(0, cellColumn - 1);
                 column <= Math.min(cellColumn + 1, generation[0].length - 1); ++column) {

                if (!(row == cellRow && column == cellColumn) && generation[row][column]) {
                    neighbours++;
                }
            }
        }
        //Return number of neighbours
        return neighbours;
    }
}
