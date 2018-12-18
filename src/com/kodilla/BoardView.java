package com.kodilla;

public class BoardView {
    private static final int boardNumberOfColumns = 6;
    private static final int boardNumberOfRows = 8;
    private boolean whiteOnTop;
    private Pawn[][] pawn = new Pawn[7][9];
    private Board board = new Board();

    public BoardView(boolean whiteOnTop) {
        this.whiteOnTop = whiteOnTop;
        resetPositions();
        }

    public void resetPositions() {
        char colourOnTop;
        char colourOnBot;
        if (whiteOnTop) {
            colourOnTop = 'W';
            colourOnBot = 'B';
        } else {
            colourOnTop = 'B';
            colourOnBot = 'W';
        }

        for (int column = 0; column <= boardNumberOfColumns; column++) {
            for (int row = 0; row <= boardNumberOfRows; row++) {
                pawn[column][row] = null;
            }
        }

        pawn[0][0] = new Pawn(Pawn.Name.LION, colourOnTop, 7, "file:resources/pawns/lion" + colourOnTop + ".png", true);
        pawn[6][0] = new Pawn(Pawn.Name.TIGER, colourOnTop, 6, "file:resources/pawns/tiger" + colourOnTop + ".png", true);
        pawn[1][1] = new Pawn(Pawn.Name.DOG, colourOnTop, 4, "file:resources/pawns/dog" + colourOnTop + ".png", true);
        pawn[5][1] = new Pawn(Pawn.Name.CAT, colourOnTop, 2, "file:resources/pawns/cat" + colourOnTop + ".png", true);
        pawn[0][2] = new Pawn(Pawn.Name.RAT, colourOnTop, 1, "file:resources/pawns/rat" + colourOnTop + ".png", true);
        pawn[2][2] = new Pawn(Pawn.Name.PHANTER, colourOnTop, 5, "file:resources/pawns/panther" + colourOnTop + ".png", true);
        pawn[4][2] = new Pawn(Pawn.Name.WOLF, colourOnTop, 3, "file:resources/pawns/wolf" + colourOnTop + ".png", true);
        pawn[6][2] = new Pawn(Pawn.Name.ELEPHANT, colourOnTop, 8, "file:resources/pawns/elephant" + colourOnTop + ".png", true);
        pawn[6][8] = new Pawn(Pawn.Name.LION, colourOnBot, 7, "file:resources/pawns/lion" + colourOnBot + ".png", true);
        pawn[0][8] = new Pawn(Pawn.Name.TIGER, colourOnBot, 6, "file:resources/pawns/tiger" + colourOnBot + ".png", true);
        pawn[5][7] = new Pawn(Pawn.Name.DOG, colourOnBot, 4, "file:resources/pawns/dog" + colourOnBot + ".png", true);
        pawn[1][7] = new Pawn(Pawn.Name.CAT, colourOnBot, 2, "file:resources/pawns/cat" + colourOnBot + ".png", true);
        pawn[6][6] = new Pawn(Pawn.Name.RAT, colourOnBot, 1, "file:resources/pawns/rat" + colourOnBot + ".png", true);
        pawn[4][6] = new Pawn(Pawn.Name.PHANTER, colourOnBot, 5, "file:resources/pawns/panther" + colourOnBot + ".png", true);
        pawn[2][6] = new Pawn(Pawn.Name.WOLF, colourOnBot, 3, "file:resources/pawns/wolf" + colourOnBot + ".png", true);
        pawn[0][6] = new Pawn(Pawn.Name.ELEPHANT, colourOnBot, 8, "file:resources/pawns/elephant" + colourOnBot + ".png", true);
    }

    public Pawn getPawn(int column, int row) {
        return pawn[column][row];
    }

    public void setPawnPosition(Pawn pawn, int column, int row) {
        for (int c = 0; c <= boardNumberOfColumns; c++) {
            for (int r = 0; r <= boardNumberOfRows; r++) {
                if (this.pawn[c][r] == pawn) {
                    this.pawn[c][r] = null;
                    this.pawn[column][row] = pawn;
                }
            }
        }
    }

    public Coordinates getPawnCoordinates(Pawn pawn) {
        int column = 0;
        int row = 0;
        for (int c = 0; c <= boardNumberOfColumns; c++) {
            for (int r = 0; r <= boardNumberOfRows; r++) {
                if (this.pawn[c][r] == pawn) {
                    column = c;
                    row = r;
                }
            }
        }
        return new Coordinates(column, row, "");
    }

    public Pawn getPawnByNameColor(Pawn.Name name, char color) {
        Pawn pawn = null;
        for (int c = 0; c <= boardNumberOfColumns; c++) {
            for (int r = 0; r <= boardNumberOfRows; r++) {
                if (this.pawn[c][r] != null) {
                    if (this.pawn[c][r].getName() == name && this.pawn[c][r].getColour() == color) {
                        pawn = this.pawn[c][r];
                    }
                }
            }
        }
        return pawn;
    }
}
