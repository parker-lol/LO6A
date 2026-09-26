package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;
import gameEngine.GameEngine;
import java.util.Random;

public class Alien extends GamePiece implements Moveable {
    private Random rand = new Random();

    public Alien(int location) {
        super('A', "Alien", location);
    }

    @Override
    public void move(Drawable[] gameBoard, int playerLocation) {
        gameBoard[getLocation()] = null;

        int dir = rand.nextBoolean() ? 1 : -1;
        int newLoc = getLocation() + dir;
        
        if (newLoc >= 0 && newLoc < GameEngine.BOARD_SIZE && gameBoard[newLoc] == null) {
            setLocation(newLoc);
        }
        gameBoard[getLocation()] = this;
    }

    @Override
    public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
        if (getLocation() == playerLocation) {
            return InteractionResult.HIT;
        }
        return InteractionResult.NONE;
    }
}