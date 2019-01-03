package com.kodilla;

public class Board {
    private static final int BOARD_NUMBER_OF_COLUMNS = 6;
    private static final int BOARD_NUMBER_OF_ROWS = 8;
    private Field[][] field = new Field[7][9];
    private Field homeWhite = new Field(Field.Type.HOME_WHITE, "file:src/main/resources/homeW.png");
    private Field homeBlack = new Field(Field.Type.HOME_BLACK, "file:src/main/resources/homeB.png");

    public Board() {
        field[1][3] = new Field(Field.Type.LAKE, "file:src/main/resources/water.png");
        field[1][4] = new Field(Field.Type.LAKE, "file:src/main/resources/water.png");
        field[1][5] = new Field(Field.Type.LAKE, "file:src/main/resources/water.png");
        field[2][3] = new Field(Field.Type.LAKE, "file:src/main/resources/water.png");
        field[2][4] = new Field(Field.Type.LAKE, "file:src/main/resources/water.png");
        field[2][5] = new Field(Field.Type.LAKE, "file:src/main/resources/water.png");
        field[4][3] = new Field(Field.Type.LAKE, "file:src/main/resources/water.png");
        field[4][4] = new Field(Field.Type.LAKE, "file:src/main/resources/water.png");
        field[4][5] = new Field(Field.Type.LAKE, "file:src/main/resources/water.png");
        field[5][3] = new Field(Field.Type.LAKE, "file:src/main/resources/water.png");
        field[5][4] = new Field(Field.Type.LAKE, "file:src/main/resources/water.png");
        field[5][5] = new Field(Field.Type.LAKE, "file:src/main/resources/water.png");
        field[2][0] = new Field(Field.Type.TRAP, "file:src/main/resources/trap.png");
        field[4][0] = new Field(Field.Type.TRAP, "file:src/main/resources/trap.png");
        field[3][1] = new Field(Field.Type.TRAP, "file:src/main/resources/trap.png");
        field[3][7] = new Field(Field.Type.TRAP, "file:src/main/resources/trap.png");
        field[2][8] = new Field(Field.Type.TRAP, "file:src/main/resources/trap.png");
        field[4][8] = new Field(Field.Type.TRAP, "file:src/main/resources/trap.png");
        field[3][0] = homeWhite;
        field[3][8] = homeBlack;

        for (int column = 0; column <= BOARD_NUMBER_OF_COLUMNS; column++) {
            for (int row = 0; row <= BOARD_NUMBER_OF_ROWS; row++) {
                if (field[column][row] == null) {
                    field[column][row] = new Field(Field.Type.GRASS, "file:src/main/resources/grass.png");
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
