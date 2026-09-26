package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;
import gameEngine.GameEngine;

public class Spaceship extends GamePiece implements Moveable {
    private int direction = 1;

    public Spaceship(int location) {

        super('S', "Ship", location);
    }

    @Override 
    public void move(Drawable[] gameBoard, int playerLocation) {
        //removing spaceship from current local
        gameBoard[getLocation()] = null;

        int newLocation = getLocation() + direction;
        
        if (newLocation >= GameEngine.BOARD_SIZE || newLocation < 0) {
            direction *= -1;
            newLocation = getLocation() + direction;
        }

        setLocation(newLocation);
        
        gameBoard[getLocation()] = this;
    }

    @Override
    public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
        return InteractionResult.NONE; 
    }
}
