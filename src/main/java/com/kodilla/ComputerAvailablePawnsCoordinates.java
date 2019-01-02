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
        ComputerPawnCoordinateDistance computerPawnCoordinateDistance;
        for (Pawn p : boardView.getAllPawns()) {
            if (p.getColour() == color && p.getActive() == true) {
                possibilityToBeBeatIfDoNotMove = isPossibilityToBeBeat(p, boardView.getPawnCoordinates(p).getColumn(), boardView.getPawnCoordinates(p).getRow());
                for (Coordinates c : pawnMoves.getMoves(p, boardView.getPawnCoordinates(p).getColumn(), boardView.getPawnCoordinates(p).getRow(), whiteOnTop)) {
                    distanceToWinField = Math.sqrt(Math.pow((coordinatesWinField.getColumn() - c.getColumn()), 2) + Math.pow((coordinatesWinField.getRow() - c.getRow()), 2));
                    possibilityToBeBeatAfterMove = isPossibilityToBeBeat(p, c.getColumn(), c.getRow());
                    if (boardView.getPawn(c.getColumn(), c.getRow()) != null) {
                        if (boardView.getPawn(c.getColumn(), c.getRow()).getColour() != color && boardView.getPawn(c.getColumn(), c.getRow()).getCurrentStrength() <= p.getCurrentStrength() && boardView.getPawn(c.getColumn(), c.getRow()).getActive()) {
                            beatingPossibility = true;
                        }
                    }
                    computerPawnCoordinateDistance = new ComputerPawnCoordinateDistance(p, c, distanceToWinField, beatingPossibility, possibilityToBeBeatIfDoNotMove, possibilityToBeBeatAfterMove);
                    computerPawnCoordinateDistanceList.add(computerPawnCoordinateDistance);
                }
            }
        }
    }

    public boolean isPossibilityToBeBeat(Pawn pawn, int column, int row) {
        for (Pawn p : boardView.getAllPawns()) {
            if (p.getColour() != pawn.getColour() && p.getCurrentStrength() >= pawn.getCurrentStrength()) {
                for (Coordinates c : pawnMoves.getMoves(p, column, row, whiteOnTop)) {
                    if(c.getColumn() == column && c.getRow() == row) {
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
}
