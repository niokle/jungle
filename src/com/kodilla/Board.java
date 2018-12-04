package com.kodilla;

public class Board {
    private String [][] field = new String[7][9];

    public Board() {
        field [1][3] = "lake";
        field [1][4] = "lake";
        field [1][5] = "lake";
        field [2][3] = "lake";
        field [2][4] = "lake";
        field [2][5] = "lake";
        field [4][3] = "lake";
        field [4][4] = "lake";
        field [4][5] = "lake";
        field [5][3] = "lake";
        field [5][4] = "lake";
        field [5][5] = "lake";
        field [2][0] = "trapTop";
        field [4][0] = "trapTop";
        field [3][1] = "trapTop";
        field [3][7] = "trapBot";
        field [2][8] = "trapBot";
        field [4][8] = "trapBot";
        field [3][0] = "homeTop";
        field [3][8] = "homeBot";
    }

    public String getField(int column, int row) {
        return field [column] [row];
    }
}
