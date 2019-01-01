package com.kodilla;

public class ComputerAiMedium {
    private char color;
    private BoardView boardView;
    private boolean whiteOnTop;
    private ComputerAvailablePawnsCoordinates computerAvailablePawnsCoordinates;

    public ComputerAiMedium(char color, BoardView boardView, boolean whiteOnTop) {
        this.color = color;
        this.boardView = boardView;
        this.whiteOnTop = whiteOnTop;
        computerAvailablePawnsCoordinates = new ComputerAvailablePawnsCoordinates(color, boardView, whiteOnTop);
    }

    public ComputerPawnCoordinateDistance getComputerPawnCoordinateDistance() {
        computerAvailablePawnsCoordinates.fillComputerPawnCoordinateDistanceList();
        return computerAvailablePawnsCoordinates.getComputerPawnCoordinateDistanceList().get(0);
    }
}