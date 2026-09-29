// Parker Lollini and Eknara Dassanayake

package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import levelPieces.*;

public class TestInteractions {

    @Test
    public void testStar() {
        Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
        Star star = new Star(10);
        gameBoard[10] = star;

        // GET_POINT only when player is on the exact same space
        assertEquals(InteractionResult.GET_POINT, star.interact(gameBoard, 10));
        
        // NONE for all other spaces
        for (int i = 0; i < 10; i++)
            assertEquals(InteractionResult.NONE, star.interact(gameBoard, i));
        for (int i = 11; i < GameEngine.BOARD_SIZE; i++)
            assertEquals(InteractionResult.NONE, star.interact(gameBoard, i));
    }

    @Test
    public void testWormhole() {
        Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
        Wormhole wormhole = new Wormhole(5);
        gameBoard[5] = wormhole;

        // ADVANCE only when player is on the exact same space
        assertEquals(InteractionResult.ADVANCE, wormhole.interact(gameBoard, 5));
        assertEquals(InteractionResult.NONE, wormhole.interact(gameBoard, 4));
    }

    @Test
    public void testAlienInteraction() {
        Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
        Alien alien = new Alien(15);
        gameBoard[15] = alien;

        // HIT only when player is on the exact same space
        assertEquals(InteractionResult.HIT, alien.interact(gameBoard, 15));
        assertEquals(InteractionResult.NONE, alien.interact(gameBoard, 14));
    }

    @Test
    public void testSpaceStation() {
        Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
        SpaceStation station = new SpaceStation(8);
        gameBoard[8] = station;

        // NONE regardless of player location
        assertEquals(InteractionResult.NONE, station.interact(gameBoard, 8));
        assertEquals(InteractionResult.NONE, station.interact(gameBoard, 0));
    }

    @Test
    public void testBlackHole() {
        Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
        BlackHole hole = new BlackHole(10);
        gameBoard[10] = hole;

        // KILL if player is within 1 space (locations 9, 10, 11)
        assertEquals(InteractionResult.KILL, hole.interact(gameBoard, 9));
        assertEquals(InteractionResult.KILL, hole.interact(gameBoard, 10));
        assertEquals(InteractionResult.KILL, hole.interact(gameBoard, 11));

        // NONE if player is 2 or more spaces away
        assertEquals(InteractionResult.NONE, hole.interact(gameBoard, 8));
        assertEquals(InteractionResult.NONE, hole.interact(gameBoard, 12));
    }
}