package com.kodilla;

import java.util.ArrayList;

public class PawnMoves {
    private Board board = new Board();
    private ArrayList<Coordinates> coordinatesList = new ArrayList<>();

    public ArrayList<Coordinates> getMoves(Pawn pawn, int column, int row, boolean whiteOnTop) {
        Coordinates moveLeft = new Coordinates(column, row - 1, "moveLeft");
        Coordinates moveRight = new Coordinates(column, row + 1, "moveRight");
        Coordinates moveUp = new Coordinates(column - 1, row, "moveUp");
        Coordinates moveDown = new Coordinates(column + 1, row, "moveDown");

        ArrayList<Coordinates> coordinatesListTemp = new ArrayList<>();
        coordinatesListTemp.add(moveLeft);
        coordinatesListTemp.add(moveRight);
        coordinatesListTemp.add(moveUp);
        coordinatesListTemp.add(moveDown);

        for (Coordinates coordinates : coordinatesListTemp) {
            if (coordinates.getColumn() < 0 || coordinates.getColumn() > 6 || coordinates.getRow() < 0 || coordinates.getRow() > 8) {
                continue;
            }
            if (board.getField(coordinates.getColumn(), coordinates.getRow()).getType() == "Lake" && pawn.getName() != "Rat" && pawn.getName() != "Lion" && pawn.getName() != "Tiger") {
                continue;
            }
            if (board.getField(coordinates.getColumn(), coordinates.getRow()).getType() == "Lake" && (pawn.getName() == "Lion" || pawn.getName() == "Tiger")) {
                int tempColumn = coordinates.getColumn();
                int tempRow = coordinates.getRow();
                switch (coordinates.getName()) {
                    case "moveLeft":
                        while (board.getField(tempColumn, tempRow).getType() == "Lake") {
                            tempRow--;
                        }
                        coordinates.setRow(tempRow);
                        coordinatesList.add(coordinates);
                        continue;
                    case "moveRight":
                        while (board.getField(tempColumn, tempRow).getType() == "Lake") {
                            tempRow++;
                        }
                        coordinates.setRow(tempRow);
                        coordinatesList.add(coordinates);
                        continue;
                    case "moveUp":
                        while (board.getField(tempColumn, tempRow).getType() == "Lake") {
                            tempColumn--;
                        }
                        coordinates.setColumn(tempColumn);
                        coordinatesList.add(coordinates);
                        continue;
                    case "moveDown":
                        while (board.getField(tempColumn, tempRow).getType() == "Lake") {
                            tempColumn++;
                        }
                        coordinates.setColumn(tempColumn);
                        coordinatesList.add(coordinates);
                        continue;
                }
            }
            if (board.getField(coordinates.getColumn(), coordinates.getRow()).getType() == "Home" && board.getField(coordinates.getColumn(), coordinates.getRow()).getOnTop() == true && whiteOnTop == true && pawn.getColour() == 'W') {
                continue;
            }
            if (board.getField(coordinates.getColumn(), coordinates.getRow()).getType() == "Home" && board.getField(coordinates.getColumn(), coordinates.getRow()).getOnTop() == true && whiteOnTop == false && pawn.getColour() == 'B') {
                continue;
            }
            if (board.getField(coordinates.getColumn(), coordinates.getRow()).getType() == "Home" && board.getField(coordinates.getColumn(), coordinates.getRow()).getOnTop() == false && whiteOnTop == true && pawn.getColour() == 'B') {
                continue;
            }
            if (board.getField(coordinates.getColumn(), coordinates.getRow()).getType() == "Home" && board.getField(coordinates.getColumn(), coordinates.getRow()).getOnTop() == false && whiteOnTop == false && pawn.getColour() == 'W') {
                continue;
            }
            coordinatesList.add(coordinates);
        }
        return coordinatesList;
    }
}
