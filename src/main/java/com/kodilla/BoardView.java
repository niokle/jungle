package com.kodilla;

import java.util.ArrayList;

public class BoardView {
    private static final int BOARD_NUMBER_OF_COLUMNS = 6;
    private static final int BOARD_NUMBER_OF_ROWS = 8;
    private boolean whiteOnTop;
    private Pawn[][] pawn = new Pawn[7][9];

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

        for (int column = 0; column <= BOARD_NUMBER_OF_COLUMNS; column++) {
            for (int row = 0; row <= BOARD_NUMBER_OF_ROWS; row++) {
                pawn[column][row] = null;
            }
        }

        pawn[0][0] = new Pawn(Pawn.Name.LION, colourOnTop, 7, "file:src/main/resources/pawns/lion" + colourOnTop + ".png", true);
        pawn[6][0] = new Pawn(Pawn.Name.TIGER, colourOnTop, 6, "file:src/main/resources/pawns/tiger" + colourOnTop + ".png", true);
        pawn[1][1] = new Pawn(Pawn.Name.DOG, colourOnTop, 4, "file:src/main/resources/pawns/dog" + colourOnTop + ".png", true);
        pawn[5][1] = new Pawn(Pawn.Name.CAT, colourOnTop, 2, "file:src/main/resources/pawns/cat" + colourOnTop + ".png", true);
        pawn[0][2] = new Pawn(Pawn.Name.RAT, colourOnTop, 1, "file:src/main/resources/pawns/rat" + colourOnTop + ".png", true);
        pawn[2][2] = new Pawn(Pawn.Name.PHANTER, colourOnTop, 5, "file:src/main/resources/pawns/panther" + colourOnTop + ".png", true);
        pawn[4][2] = new Pawn(Pawn.Name.WOLF, colourOnTop, 3, "file:src/main/resources/pawns/wolf" + colourOnTop + ".png", true);
        pawn[6][2] = new Pawn(Pawn.Name.ELEPHANT, colourOnTop, 8, "file:src/main/resources/pawns/elephant" + colourOnTop + ".png", true);
        pawn[6][8] = new Pawn(Pawn.Name.LION, colourOnBot, 7, "file:src/main/resources/pawns/lion" + colourOnBot + ".png", true);
        pawn[0][8] = new Pawn(Pawn.Name.TIGER, colourOnBot, 6, "file:src/main/resources/pawns/tiger" + colourOnBot + ".png", true);
        pawn[5][7] = new Pawn(Pawn.Name.DOG, colourOnBot, 4, "file:src/main/resources/pawns/dog" + colourOnBot + ".png", true);
        pawn[1][7] = new Pawn(Pawn.Name.CAT, colourOnBot, 2, "file:src/main/resources/pawns/cat" + colourOnBot + ".png", true);
        pawn[6][6] = new Pawn(Pawn.Name.RAT, colourOnBot, 1, "file:src/main/resources/pawns/rat" + colourOnBot + ".png", true);
        pawn[4][6] = new Pawn(Pawn.Name.PHANTER, colourOnBot, 5, "file:src/main/resources/pawns/panther" + colourOnBot + ".png", true);
        pawn[2][6] = new Pawn(Pawn.Name.WOLF, colourOnBot, 3, "file:src/main/resources/pawns/wolf" + colourOnBot + ".png", true);
        pawn[0][6] = new Pawn(Pawn.Name.ELEPHANT, colourOnBot, 8, "file:src/main/resources/pawns/elephant" + colourOnBot + ".png", true);
    }

    public Pawn getPawn(int column, int row) {
        return pawn[column][row];
    }

    public void setPawnPosition(Pawn pawn, int column, int row) {
        for (int c = 0; c <= BOARD_NUMBER_OF_COLUMNS; c++) {
            for (int r = 0; r <= BOARD_NUMBER_OF_ROWS; r++) {
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
        for (int c = 0; c <= BOARD_NUMBER_OF_COLUMNS; c++) {
            for (int r = 0; r <= BOARD_NUMBER_OF_ROWS; r++) {
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
        for (int c = 0; c <= BOARD_NUMBER_OF_COLUMNS; c++) {
            for (int r = 0; r <= BOARD_NUMBER_OF_ROWS; r++) {
                if (this.pawn[c][r] != null) {
                    if (this.pawn[c][r].getName() == name && this.pawn[c][r].getColour() == color) {
                        pawn = this.pawn[c][r];
                    }
                }
            }
        }
        return pawn;
    }

    public ArrayList<Pawn> getAllPawns() {
        ArrayList<Pawn> pawnsList = new ArrayList<>();
        for (int c = 0; c <= BOARD_NUMBER_OF_COLUMNS; c++) {
            for (int r = 0; r <= BOARD_NUMBER_OF_ROWS; r++) {
                if (this.pawn[c][r] != null) {
                    pawnsList.add(this.pawn[c][r]);
                }
            }
        }
        return pawnsList;
    }
}
