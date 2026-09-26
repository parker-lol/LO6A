package levelPieces;

import gameEngine.Drawable;

public class Meteor implements Drawable{
    private char symbol;

    public Meteor() {
        this.symbol = '#';
    }
    
    @Override 
    public void draw() {
        System.out.print(symbol);
    }
}
