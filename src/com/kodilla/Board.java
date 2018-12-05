package com.kodilla;

public class Board {
    private Field [][] field = new Field[7][9];

    public Board() {
        field [1][3] = new Field("Lake",null);
        field [1][4] = new Field("Lake",null);
        field [1][5] = new Field("Lake",null);
        field [2][3] = new Field("Lake",null);
        field [2][4] = new Field("Lake",null);
        field [2][5] = new Field("Lake",null);
        field [4][3] = new Field("Lake",null);
        field [4][4] = new Field("Lake",null);
        field [4][5] = new Field("Lake",null);
        field [5][3] = new Field("Lake",null);
        field [5][4] = new Field("Lake",null);
        field [5][5] = new Field("Lake",null);
        field [2][0] = new Field("Trap",true);
        field [4][0] = new Field("Trap",true);
        field [3][1] = new Field("Trap",true);
        field [3][7] = new Field("Trap",false);
        field [2][8] = new Field("Trap",false);
        field [4][8] = new Field("Trap",false);
        field [3][0] = new Field("Home",true);
        field [3][8] = new Field("Home",false);
    }

    public Field getField(int column, int row) {
        return field [column] [row];
    }
}
