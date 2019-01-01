package com.kodilla;

public class ComputerPawnCoordinateDistance {
    private Pawn pawn;
    private Coordinates coordinates;
    private double distanceToWinField;
    private boolean beatingPossibility;
    private boolean possibilityToBeBeatIfDoNotMove;
    private boolean possibilityToBeBeatAfterMove;

    public ComputerPawnCoordinateDistance(Pawn pawn, Coordinates coordinates, double distanceToWinField, boolean beatingPossibility, boolean possibilityToBeBeatIfDoNotMove, boolean possibilityToBeBeatAfterMove) {
        this.pawn = pawn;
        this.coordinates = coordinates;
        this.distanceToWinField = distanceToWinField;
        this.beatingPossibility = beatingPossibility;
        this.possibilityToBeBeatIfDoNotMove = possibilityToBeBeatIfDoNotMove;
        this.possibilityToBeBeatAfterMove = possibilityToBeBeatAfterMove;
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
}
