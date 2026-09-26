package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class BlackHole extends GamePiece {
    public BlackHole(int location) {
        super('O', "BlackHole", location);
    }

    @Override
    public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
        if (Math.abs(getLocation() - playerLocation) <= 1) {
            return InteractionResult.KILL;
        }
        return InteractionResult.NONE;
    }
}
