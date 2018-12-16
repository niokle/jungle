package com.kodilla;

public class Board {
    private Field[][] field = new Field[7][9];
    private Field homeWhite = new Field("HomeWhite", "file:resources/homeW.png");
    private Field homeBlack = new Field("HomeBlack", "file:resources/homeB.png");

    public Board() {
        field[1][3] = new Field("Lake", "file:resources/water.png");
        field[1][4] = new Field("Lake", "file:resources/water.png");
        field[1][5] = new Field("Lake", "file:resources/water.png");
        field[2][3] = new Field("Lake", "file:resources/water.png");
        field[2][4] = new Field("Lake", "file:resources/water.png");
        field[2][5] = new Field("Lake", "file:resources/water.png");
        field[4][3] = new Field("Lake", "file:resources/water.png");
        field[4][4] = new Field("Lake", "file:resources/water.png");
        field[4][5] = new Field("Lake", "file:resources/water.png");
        field[5][3] = new Field("Lake", "file:resources/water.png");
        field[5][4] = new Field("Lake", "file:resources/water.png");
        field[5][5] = new Field("Lake", "file:resources/water.png");
        field[2][0] = new Field("Trap", "file:resources/trap.png");
        field[4][0] = new Field("Trap", "file:resources/trap.png");
        field[3][1] = new Field("Trap", "file:resources/trap.png");
        field[3][7] = new Field("Trap", "file:resources/trap.png");
        field[2][8] = new Field("Trap", "file:resources/trap.png");
        field[4][8] = new Field("Trap", "file:resources/trap.png");
        field[3][0] = homeWhite;
        field[3][8] = homeBlack;

        for (int column = 0; column <= 6; column++) {
            for (int row = 0; row <=8; row++) {
                if (field[column][row] == null) {
                    field[column][row] = new Field("Grass", "file:resources/grass.png");
                }
            }
        }
    }

    public Field getField(int column, int row) {
        return field[column][row];
    }

    public void whiteOnTop(boolean whiteOnTop) {
        if (whiteOnTop) {
            field[3][0] = homeWhite;
            field[3][8] = homeBlack;
        } else {
            field[3][0] = homeBlack;
            field[3][8] = homeWhite;
        }
    }
}
