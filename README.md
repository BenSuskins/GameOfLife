# GameOfLife

Game of Life developed in Java 8.

## Assumptions
As part of the development I assumed that an infinite grid would be rather impossible, as a result I made the grid size configurable as a command line argument or if not provided a preset configuration would run.


## Running 
[Game of Life Jar](https://github.com/BenSuskins/GameOfLife/releases/tag/1.0.0)

Game can be ran using:

```
java -jar bbcGameOfLife.jar
```
Additionally two command line arguments can be supplied to indicate the number of rows and columns that the game will execute with. 
If none supplied the game will execute with a 50 x 50 grid.

```
java -jar bbcGameOfLife.jar 75 75
```
