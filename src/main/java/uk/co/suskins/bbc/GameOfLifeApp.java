package uk.co.suskins.bbc;

/**
 * Game of Life App
 * <p>
 * Ben Suskins 2019
 * <p>
 * Can take a program argument containing the number of
 * rows and columns to use - if not supplied uses a
 * 50 x 50 grid.
 * <p>
 * This class is for starting the
 * Game of Life.
 */
class GameOfLifeApp {
    public static void main(String[] args) {
        if (args.length == 0) {
            new GameOfLife(50, 50);
        } else if (args.length == 2) {
            new GameOfLife(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        } else {
            throw new IllegalArgumentException("Zero or two arguments must be supplied");
        }
    }
}
