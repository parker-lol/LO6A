// Parker Lollini and Eknara Dassanayake | 9/25/2026

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
        playerStartLoc = 10; // start the player for level 1 on position 10

        if (levelNum == 1) {
            // Drawable only
            Meteor meteor = new Meteor();
            gameBoard[2] = meteor;

            // moveable and interacting
            Spaceship ship = new Spaceship(5);
            gameBoard[5] = ship;
            movingPieces.add(ship);
            interactingPieces.add(ship);

            // Interacting (Static obstacle)
            SpaceStation station = new SpaceStation(15);
            gameBoard[15] = station;
            interactingPieces.add(station);

            // Interacting (Need 2 points to advance, collect both stars)
            Star star1 = new Star(8);
            gameBoard[8] = star1;
            interactingPieces.add(star1);

            Star star2 = new Star(12);
            gameBoard[12] = star2;
            interactingPieces.add(star2);
        } else if (levelNum == 2) {
            // Moveable & Interacting
            Alien alien = new Alien(4);
            gameBoard[4] = alien;
            movingPieces.add(alien);
            interactingPieces.add(alien);

            // Interacting (kill condition)
            BlackHole hole = new BlackHole(14);
            gameBoard[14] = hole;
            interactingPieces.add(hole);

            // Interacting (instant win condition)
            Wormhole wormhole = new Wormhole(19);
            gameBoard[19] = wormhole;
            interactingPieces.add(wormhole);
        }
    }

    public Drawable[] getBoard() { return gameBoard; }
    public ArrayList<Moveable> getMovingPieces() { return movingPieces; }
    public ArrayList<GamePiece> getInteractingPieces() { return interactingPieces; }
    public int getPlayerStartLoc() { return playerStartLoc; }
}