package com.kodilla;

import java.util.ArrayList;

public class PawnMoves {
    private Board board = new Board();
    private ArrayList<Coordinates> coordinatesList = new ArrayList<>();

    public ArrayList<Coordinates> getMoves(Pawn pawn, int column, int row, boolean whiteOnTop) {
        Coordinates moveLeft = new Coordinates(column, row - 1);
        Coordinates moveRight = new Coordinates(column, row + 1);
        Coordinates moveUp = new Coordinates(column - 1, row);
        Coordinates moveDown = new Coordinates(column + 1, row);

        coordinatesList.add(moveLeft);
        coordinatesList.add(moveRight);
        coordinatesList.add(moveUp);
        coordinatesList.add(moveDown);

        for (Coordinates coordinates : coordinatesList) {
            if (coordinates.getColumn() < 0 || coordinates.getColumn() > 6 || coordinates.getRow() < 0 || coordinates.getRow() > 8) {
                coordinatesList.remove(coordinates);
            }
            if (board.getField(coordinates.getColumn(), coordinates.getRow()).getType() == "Lake" && pawn.getName() != "Rat" && pawn.getName() != "Lion" && pawn.getName() != "Tiger") {
                coordinatesList.remove(coordinates);
            }
            if (board.getField(coordinates.getColumn(), coordinates.getRow()).getType() == "Lake" && (pawn.getName() == "Lion" || pawn.getName() == "Tiger")) {
                int tempColumn = coordinates.getColumn();
                int tempRow = coordinates.getRow();
                switch (coordinates.toString()) {
                    case "moveLeft":
                        while (board.getField(tempColumn, tempRow).getType() != "Lake") {
                            tempRow--;
                        }
                        coordinates.setRow(tempRow);
                        break;
                    case "moveRight":
                        while (board.getField(tempColumn, tempRow).getType() != "Lake") {
                            tempRow++;
                        }
                        coordinates.setRow(tempRow);
                        break;
                    case "moveUp":
                        while (board.getField(tempColumn, tempRow).getType() != "Lake") {
                            tempColumn--;
                        }
                        coordinates.setColumn(tempColumn);
                        break;
                    case "moveDown":
                        while (board.getField(tempColumn, tempRow).getType() != "Lake") {
                            tempColumn++;
                        }
                        coordinates.setColumn(tempColumn);
                        break;
                }
            }
            if (board.getField(coordinates.getColumn(), coordinates.getRow()).getType() == "Home" && board.getField(coordinates.getColumn(), coordinates.getRow()).getOnTop() == true && whiteOnTop == true && pawn.getColour() == 'W') {
                coordinatesList.remove(pawn);
            }
            if (board.getField(coordinates.getColumn(), coordinates.getRow()).getType() == "Home" && board.getField(coordinates.getColumn(), coordinates.getRow()).getOnTop() == true && whiteOnTop == false && pawn.getColour() == 'B') {
                coordinatesList.remove(pawn);
            }
            if (board.getField(coordinates.getColumn(), coordinates.getRow()).getType() == "Home" && board.getField(coordinates.getColumn(), coordinates.getRow()).getOnTop() == false && whiteOnTop == true && pawn.getColour() == 'B') {
                coordinatesList.remove(pawn);
            }
            if (board.getField(coordinates.getColumn(), coordinates.getRow()).getType() == "Home" && board.getField(coordinates.getColumn(), coordinates.getRow()).getOnTop() == false && whiteOnTop == false && pawn.getColour() == 'W') {
                coordinatesList.remove(pawn);
            }
        }
        return coordinatesList;
    }
}
