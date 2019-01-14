package com.kodilla;

import java.util.ArrayList;

public class ComputerAvailablePawnsCoordinates {
    private char color;
    private BoardView boardView;
    private PawnMoves pawnMoves;
    private boolean whiteOnTop;
    private Coordinates coordinatesWinField;
    private ArrayList<ComputerPawnCoordinateDistance> computerPawnCoordinateDistanceList = new ArrayList<>();

    public ComputerAvailablePawnsCoordinates(char color, BoardView boardView, boolean whiteOnTop) {
        this.color = color;
        this.boardView = boardView;
        this.whiteOnTop = whiteOnTop;
        if (color == 'W' && whiteOnTop || color == 'B' && !whiteOnTop) {
            coordinatesWinField = new Coordinates(3, 8, "");
        } else {
            coordinatesWinField = new Coordinates(3, 0, "");
        }
        pawnMoves = new PawnMoves(boardView);
    }

    public void fillComputerPawnCoordinateDistanceList() {
        computerPawnCoordinateDistanceList.clear();
        double distanceToWinField;
        boolean beatingPossibility = false;
        boolean possibilityToBeBeatAfterMove;
        boolean possibilityToBeBeatIfDoNotMove;
        boolean moveToStrongerPawnPosition = false;
        ComputerPawnCoordinateDistance computerPawnCoordinateDistance;

        for (Pawn pawn : boardView.getAllPawns()) {
            if (pawn.getColour() == color && pawn.getActive()) {
                possibilityToBeBeatIfDoNotMove = isPossibilityToBeBeat(pawn, boardView.getPawnCoordinates(pawn).getColumn(), boardView.getPawnCoordinates(pawn).getRow());
                for (Coordinates coordinates : pawnMoves.getMoves(pawn, whiteOnTop)) {
                    distanceToWinField = getDistanceToWinField(coordinates);
                    possibilityToBeBeatAfterMove = isPossibilityToBeBeat(pawn, coordinates.getColumn(), coordinates.getRow());
                    Pawn pawnOnCoordinates = boardView.getPawn(coordinates.getColumn(), coordinates.getRow());
                    if (pawnOnCoordinates != null) {
                        char colorPawnOnCoordinates = pawnOnCoordinates.getColour();
                        int currentStrengthPawnOnCoordinates = pawnOnCoordinates.getCurrentStrength();
                        boolean activePawnOnCoordinates = pawnOnCoordinates.getActive();
                        if (colorPawnOnCoordinates != color && currentStrengthPawnOnCoordinates <= pawn.getCurrentStrength() && activePawnOnCoordinates) {
                            beatingPossibility = true;
                        } else if (colorPawnOnCoordinates != color && currentStrengthPawnOnCoordinates > pawn.getCurrentStrength() && activePawnOnCoordinates) {
                            moveToStrongerPawnPosition = true;
                        }
                    }
                    computerPawnCoordinateDistance = new ComputerPawnCoordinateDistance(pawn, coordinates, distanceToWinField, beatingPossibility, possibilityToBeBeatIfDoNotMove, possibilityToBeBeatAfterMove, moveToStrongerPawnPosition);
                    computerPawnCoordinateDistanceList.add(computerPawnCoordinateDistance);
                }
            }
        }
        //Test
        /* for (ComputerPawnCoordinateDistance c : computerPawnCoordinateDistanceList) {
            System.out.println(
                    c.getPawn().getColour() + " " +
                            c.getPawn().getName() + " " +
                            c.isPossibilityToBeBeatAfterMove() + " " +
                            c.isPossibilityToBeBeatIfDoNotMove() + " " +
                            c.isBeatingPossibility() + " " +
                            c.getDistanceToWinField() + " " +
                            c.getCoordinates().getColumn() + " " +
                            c.getCoordinates().getRow()
            );


        }
        */
    }

    private double getDistanceToWinField(Coordinates c) {
        return Math.sqrt(Math.pow((coordinatesWinField.getColumn() - c.getColumn()), 2) + Math.pow((coordinatesWinField.getRow() - c.getRow()), 2));
    }

    public boolean isPossibilityToBeBeat(Pawn pawn, int column, int row) {
        for (Pawn p : boardView.getAllPawns()) {
            if (p.getColour() != pawn.getColour() && p.getCurrentStrength() >= pawn.getCurrentStrength()) {
                for (Coordinates coordinates : pawnMoves.getMoves(p, whiteOnTop)) {
                    if(coordinates.getColumn() == column && coordinates.getRow() == row) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public ArrayList<ComputerPawnCoordinateDistance> getComputerPawnCoordinateDistanceList() {
        return computerPawnCoordinateDistanceList;
    }

    public ArrayList<ComputerPawnCoordinateDistance> getComputerPawnCoordinateDistanceListByPawn(Pawn pawn) {
        ArrayList<ComputerPawnCoordinateDistance> result = new ArrayList<>();
        for (ComputerPawnCoordinateDistance computerPawnCoordinateDistance : computerPawnCoordinateDistanceList) {
            if (computerPawnCoordinateDistance.getPawn() == pawn) {
                result.add(computerPawnCoordinateDistance);
            }
        }
        return result;
    }
}

