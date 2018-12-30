package com.kodilla;

public class PawnAndCoordinate {
    private Pawn pawn;
    private Coordinates coordinates;

    public PawnAndCoordinate(Pawn pawn, Coordinates coordinates) {
        this.pawn = pawn;
        this.coordinates = coordinates;
    }

    public Pawn getPawn() {
        return pawn;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setPawn(Pawn pawn) {
        this.pawn = pawn;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
