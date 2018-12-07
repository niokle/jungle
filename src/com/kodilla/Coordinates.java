package com.kodilla;

public class Coordinates {
    private int column;
    private int row;
    private String name;

    public Coordinates(int column, int row, String name) {
        this.column = column;
        this.row = row;
        this.name = name;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public String getName() {
        return name;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setRow(int row) {
        this.row = row;
    }
}
