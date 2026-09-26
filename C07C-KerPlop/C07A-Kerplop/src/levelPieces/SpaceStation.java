package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class SpaceStation extends GamePiece {
    public SpaceStation(int location) {
        super('{', "Space Station", location);
    }

    @Override
    public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
        return InteractionResult.NONE;
    }
}