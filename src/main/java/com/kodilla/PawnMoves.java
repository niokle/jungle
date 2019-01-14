package com.kodilla;

import java.util.ArrayList;

public class PawnMoves {
    private Board board = new Board();
    private BoardView boardView;

    public PawnMoves(BoardView boardView) {
        this.boardView = boardView;
    }

    public ArrayList<Coordinates> getMoves(Pawn pawn, boolean whiteOnTop) {
        int column = boardView.getPawnCoordinates(pawn).getColumn();
        int row = boardView.getPawnCoordinates(pawn).getRow();
        ArrayList<Coordinates> coordinatesList = new ArrayList<>();
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
            if (isCoordinateOutsideBoard(coordinates)) {
                continue;
            }
            Pawn pawnOnCoordinates = boardView.getPawn(coordinates.getColumn(), coordinates.getRow());
            Field fieldOnCoordinates = board.getField(coordinates.getColumn(), coordinates.getRow());
            if (isPawnInCoordinates(coordinates)) {
                if (pawn.getColour() == pawnOnCoordinates.getColour()  && !(fieldOnCoordinates.getType() == Field.Type.LAKE)) {
                    continue;
                }
            }
            if (isFieldLakePawnNotRatNotLionNotTiger(pawn, coordinates)) {
                continue;
            }
            if (isFieldLakePawnLionOrTiger(coordinates, pawn)) {
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
            if (isWhitePawnMoveToOwnHome(pawn, coordinates)) {
                continue;
            }
            if (isBlackPawnMoveToOwnHome(pawn, coordinates)) {
                continue;
            }
            if (isPawnInCoordinates(coordinates)) {
                if (isPawnRatTryMoveFromLakeToElephantField(pawn, column, row, coordinates)) {
                    continue;
                }
            }
            coordinatesList.add(coordinates);
        }
        return coordinatesList;
    }

    private boolean isBlackPawnMoveToOwnHome(Pawn pawn, Coordinates coordinates) {
        return board.getField(coordinates.getColumn(), coordinates.getRow()).getType() == Field.Type.HOME_BLACK && pawn.getColour() == 'B';
    }

    private boolean isWhitePawnMoveToOwnHome(Pawn pawn, Coordinates coordinates) {
        return board.getField(coordinates.getColumn(), coordinates.getRow()).getType() == Field.Type.HOME_WHITE && pawn.getColour() == 'W';
    }

    private boolean isPawnRatTryMoveFromLakeToElephantField(Pawn pawn, int column, int row, Coordinates coordinates) {
        return pawn.getName() == Pawn.Name.RAT && board.getField(column, row).getType() == Field.Type.LAKE && boardView.getPawn(coordinates.getColumn(), coordinates.getRow()).getName() == Pawn.Name.ELEPHANT;
    }

    private boolean isFieldLakePawnNotRatNotLionNotTiger(Pawn pawn, Coordinates coordinates) {
        return board.getField(coordinates.getColumn(), coordinates.getRow()).getType() == Field.Type.LAKE && pawn.getName() != Pawn.Name.RAT && pawn.getName() != Pawn.Name.LION && pawn.getName() != Pawn.Name.TIGER;
    }

    private boolean isPawnInCoordinates(Coordinates coordinates) {
        return boardView.getPawn(coordinates.getColumn(), coordinates.getRow()) != null;
    }

    private boolean isCoordinateOutsideBoard(Coordinates coordinates) {
        if (coordinates.getColumn() < 0 || coordinates.getColumn() > 6 || coordinates.getRow() < 0 || coordinates.getRow() > 8) {
            return true;
        }
        return false;
    }

    private boolean isFieldLakePawnLionOrTiger(Coordinates coordinates, Pawn pawn) {
        if (board.getField(coordinates.getColumn(), coordinates.getRow()).getType() == Field.Type.LAKE && (pawn.getName() == Pawn.Name.LION || pawn.getName() == Pawn.Name.TIGER)) {
            return true;
        }
        return false;
    }
}
