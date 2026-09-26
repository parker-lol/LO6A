package levelPieces;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.Moveable;
import java.util.ArrayList;

public class LevelSetup {
    private Drawable[] gameBoard;
    private ArrayList<Moveable> movingPieces;
    private ArrayList<GamePiece> interactingPieces;
    private int playerStartLoc;

    public void createLevel(int levelNum) {
        gameBoard = new Drawable[GameEngine.BOARD_SIZE];
        movingPieces = new ArrayList<>();
        interactingPieces = new ArrayList<>();
        playerStartLoc = 10;

        if (levelNum == 1) {
            Meteor meteor = new Meteor();
            gameBoard[2] = meteor;

            Spaceship ship = new Spaceship(5);
            gameBoard[5] = ship;
            movingPieces.add(ship);
            interactingPieces.add(ship);

            BlackHole blackHole = new BlackHole(15);
            gameBoard[15] = blackHole;
            interactingPieces.add(blackHole);
        }
    }

    public Drawable[] getBoard() { return gameBoard; }
    public ArrayList<Moveable> getMovingPieces() { return movingPieces; }
    public ArrayList<GamePiece> getInteractingPieces() { return interactingPieces; }
    public int getPlayerStartLoc() { return playerStartLoc; }
}