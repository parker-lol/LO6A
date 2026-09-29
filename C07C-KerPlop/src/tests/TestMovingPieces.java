// Parker Lollini and Eknara Dassanayake

package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import levelPieces.*;

public class TestMovingPieces {

    @Test
    public void testSpaceshipMovement() {
        Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
        Spaceship ship = new Spaceship(18); // Place near the right edge
        gameBoard[18] = ship;

        // Test normal forward movement (direction starts as +1)
        ship.move(gameBoard, 0);
        assertEquals(19, ship.getLocation());

        // Test bouncing off the right edge (location 20 is GameEngine.BOARD_SIZE - 1)
        ship.move(gameBoard, 0);
        assertEquals(20, ship.getLocation());
        
        // Ship is at edge. Next move should flip direction to -1 and move to 19
        ship.move(gameBoard, 0);
        assertEquals(19, ship.getLocation());
        
        // Continues moving left
        ship.move(gameBoard, 0);
        assertEquals(18, ship.getLocation());
    }

    @Test
    public void testAlienRandomMovement() {
        Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
        
        // Fill the board with dummy objects to restrict movement, leaving only spaces 9, 10, and 11 open
        for (int i = 0; i < GameEngine.BOARD_SIZE; i++) {
            if (i != 9 && i != 10 && i != 11) {
                gameBoard[i] = new Meteor(); 
            }
        }

        // Place Alien in the center of the open spaces
        Alien alien = new Alien(10);
        gameBoard[10] = alien;

        int count9 = 0;
        int count11 = 0;

        // Move the alien many times to ensure random distribution and bound checking
        for (int i = 0; i < 200; i++) {
            alien.move(gameBoard, 0);
            int loc = alien.getLocation();

            // Ensure the alien never jumps over the obstacles or stays entirely still forever
            if (loc != 9 && loc != 10 && loc != 11) {
                fail("Alien moved to an invalid or occupied square: " + loc);
            }

            if (loc == 9) count9++;
            if (loc == 11) count11++;
            
            // Reset to middle for the next iteration to test left/right equally
            gameBoard[alien.getLocation()] = null;
            alien.setLocation(10);
            gameBoard[10] = alien;
        }

        // Ensure both valid random options were chosen at least once over 200 iterations
        assertTrue(count9 > 1, "Alien did not randomly move left enough");
        assertTrue(count11 > 1, "Alien did not randomly move right enough");
    }
}