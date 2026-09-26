package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Star extends GamePiece {
    public Star(int location) {
        super('*', "Star", location);
    }

    @Override
    public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
        if (getLocation() == playerLocation) {
            return InteractionResult.GET_POINT;
        }
        return InteractionResult.NONE;
    }
}