package com.kodilla;

public class ComputerPawnCoordinateDistance {
    private Pawn pawn;
    private Coordinates coordinates;
    private double distanceToWinField;
    private boolean beatingPossibility;
    private boolean possibilityToBeBeatIfDoNotMove;
    private boolean possibilityToBeBeatAfterMove;
    private boolean moveToStrongerPawnPosition;

    public ComputerPawnCoordinateDistance(Pawn pawn, Coordinates coordinates, double distanceToWinField, boolean beatingPossibility, boolean possibilityToBeBeatIfDoNotMove, boolean possibilityToBeBeatAfterMove, boolean moveToStrongerPawnPosition) {
        this.pawn = pawn;
        this.coordinates = coordinates;
        this.distanceToWinField = distanceToWinField;
        this.beatingPossibility = beatingPossibility;
        this.possibilityToBeBeatIfDoNotMove = possibilityToBeBeatIfDoNotMove;
        this.possibilityToBeBeatAfterMove = possibilityToBeBeatAfterMove;
        this.moveToStrongerPawnPosition = moveToStrongerPawnPosition;
    }

    public Pawn getPawn() {
        return pawn;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public double getDistanceToWinField() {
        return distanceToWinField;
    }

    public boolean isBeatingPossibility() {
        return beatingPossibility;
    }

    public boolean isPossibilityToBeBeatIfDoNotMove() {
        return possibilityToBeBeatIfDoNotMove;
    }

    public boolean isPossibilityToBeBeatAfterMove() {
        return possibilityToBeBeatAfterMove;
    }

    public boolean isMoveToStrongerPawnPosition() {
        return moveToStrongerPawnPosition;
    }
}
