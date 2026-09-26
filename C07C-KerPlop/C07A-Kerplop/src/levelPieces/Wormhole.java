package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Wormhole extends GamePiece {
    public Wormhole(int location) {
        super('@', "Wormhole", location);
    }

    @Override
    public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
        if (getLocation() == playerLocation) {
            return InteractionResult.ADVANCE;
        }
        return InteractionResult.NONE;
    }
}