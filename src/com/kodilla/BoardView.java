package com.kodilla;

public class BoardView {
    private boolean whiteOnTop;
    private Pawn[][] pawn = new Pawn[7][9];
    private Board board = new Board();

    public BoardView(boolean whiteOnTop) {
        this.whiteOnTop = whiteOnTop;
        char colourOnTop;
        char colourOnBot;
        if (whiteOnTop) {
            colourOnTop = 'W';
            colourOnBot = 'B';
        } else {
            colourOnTop = 'B';
            colourOnBot = 'W';
        }

        pawn[0][0] = new Pawn("Lion", colourOnTop, 7, "file:resources/lion" + colourOnTop + ".png", true);
        pawn[6][0] = new Pawn("Tiger", colourOnTop, 6, "file:resources/tiger" + colourOnTop + ".png", true);
        pawn[1][1] = new Pawn("Dog", colourOnTop, 4, "file:resources/dog" + colourOnTop + ".png", true);
        pawn[5][1] = new Pawn("Cat", colourOnTop, 2, "file:resources/cat" + colourOnTop + ".png", true);
        pawn[0][2] = new Pawn("Rat", colourOnTop, 1, "file:resources/rat" + colourOnTop + ".png", true);
        pawn[2][2] = new Pawn("Panther", colourOnTop, 5, "file:resources/panther" + colourOnTop + ".png", true);
        pawn[4][2] = new Pawn("Wolf", colourOnTop, 3, "file:resources/wolf" + colourOnTop + ".png", true);
        pawn[6][2] = new Pawn("Elephant", colourOnTop, 8, "file:resources/elephant" + colourOnTop + ".png", true);
        pawn[6][8] = new Pawn("Lion", colourOnBot, 7, "file:resources/lion" + colourOnBot + ".png", true);
        pawn[0][8] = new Pawn("Tiger", colourOnBot, 6, "file:resources/tiger" + colourOnBot + ".png", true);
        pawn[5][7] = new Pawn("Dog", colourOnBot, 4, "file:resources/dog" + colourOnBot + ".png", true);
        pawn[1][7] = new Pawn("Cat", colourOnBot, 2, "file:resources/cat" + colourOnBot + ".png", true);
        pawn[6][6] = new Pawn("Rat", colourOnBot, 1, "file:resources/rat" + colourOnBot + ".png", true);
        pawn[4][6] = new Pawn("Panther", colourOnBot, 5, "file:resources/panther" + colourOnBot + ".png", true);
        pawn[2][6] = new Pawn("Wolf", colourOnBot, 3, "file:resources/wolf" + colourOnBot + ".png", true);
        pawn[0][6] = new Pawn("Elephant", colourOnBot, 8, "file:resources/elephant" + colourOnBot + ".png", true);
    }

    public Pawn getPawn(int column, int row) {
        return pawn[column][row];
    }

}
