package levelPieces;

import gameEngine.Drawable;

public class Meteor {
    private char symbol;

    public Meteor() {
        this.symbol = '#';
    }
    
    @Override 
    public void draw() {
        System.out.print(symbol);
    }
}
