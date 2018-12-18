package com.kodilla;

import java.util.ArrayList;

public class PawnMoves {
    private Board board = new Board();
    private ArrayList<Coordinates> coordinatesList = new ArrayList<>();
    private BoardView boardView;

    public PawnMoves(BoardView boardView) {
        this.boardView = boardView;
    }

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
            if (boardView.getPawn(coordinates.getColumn(), coordinates.getRow()) != null) {
                if (pawn.getColour() == boardView.getPawn(coordinates.getColumn(), coordinates.getRow()).getColour()) {
                    continue;
                }
            }
            if (board.getField(coordinates.getColumn(), coordinates.getRow()).getType() == Field.Type.LAKE && pawn.getName() != Pawn.Name.RAT && pawn.getName() != Pawn.Name.LION && pawn.getName() != Pawn.Name.TIGER) {
                continue;
            }
            if (board.getField(coordinates.getColumn(), coordinates.getRow()).getType() == Field.Type.LAKE && (pawn.getName() == Pawn.Name.LION || pawn.getName() == Pawn.Name.TIGER)) {
                int tempColumn = coordinates.getColumn();
                int tempRow = coordinates.getRow();
                switch (coordinates.getName()) {
                    case "moveLeft":
                        while (board.getField(tempColumn, tempRow).getType() == Field.Type.LAKE) {
                            tempRow--;
                        }
                        coordinates.setRow(tempRow);
                        coordinatesList.add(coordinates);
                        continue;
                    case "moveRight":
                        while (board.getField(tempColumn, tempRow).getType() == Field.Type.LAKE) {
                            tempRow++;
                        }
                        coordinates.setRow(tempRow);
                        coordinatesList.add(coordinates);
                        continue;
                    case "moveUp":
                        while (board.getField(tempColumn, tempRow).getType() == Field.Type.LAKE) {
                            tempColumn--;
                        }
                        coordinates.setColumn(tempColumn);
                        coordinatesList.add(coordinates);
                        continue;
                    case "moveDown":
                        while (board.getField(tempColumn, tempRow).getType() == Field.Type.LAKE) {
                            tempColumn++;
                        }
                        coordinates.setColumn(tempColumn);
                        coordinatesList.add(coordinates);
                        continue;
                }
            }
            if (board.getField(coordinates.getColumn(), coordinates.getRow()).getType() == Field.Type.HOME_WHITE && pawn.getColour() == 'W') {
                continue;
            }
            if (board.getField(coordinates.getColumn(), coordinates.getRow()).getType() == Field.Type.HOME_BLACK && pawn.getColour() == 'B') {
                continue;
            }
            if (boardView.getPawn(coordinates.getColumn(), coordinates.getRow()) != null) {
                if (pawn.getName() == Pawn.Name.RAT && board.getField(column, row).getType() == Field.Type.LAKE && boardView.getPawn(coordinates.getColumn(), coordinates.getRow()).getName() == Pawn.Name.ELEPHANT) {
                    continue;
                }
            }
            coordinatesList.add(coordinates);
        }
        return coordinatesList;
    }
}
