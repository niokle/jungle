package com.kodilla;

import java.util.ArrayList;
import java.util.Random;

public class ComputerAiEasy {
    private char color;
    private BoardView boardView;
    private boolean whiteOnTop;
    private ComputerAvailablePawnsCoordinates computerAvailablePawnsCoordinates;
    private Random random = new Random();

    public ComputerAiEasy(char color, BoardView boardView, boolean whiteOnTop) {
        this.color = color;
        this.boardView = boardView;
        this.whiteOnTop = whiteOnTop;
        computerAvailablePawnsCoordinates = new ComputerAvailablePawnsCoordinates(color, boardView, whiteOnTop);
    }

    public ComputerPawnCoordinateDistance selectComputerPawnCoordinateDistance() {
        ArrayList<ComputerPawnCoordinateDistance> computerPawnCoordinateDistanceList = new ArrayList<>();
        Pawn pawn;
        double distance = 100;
        int i = 0;
        int index = 0;
        computerAvailablePawnsCoordinates.fillComputerPawnCoordinateDistanceList();
        for (ComputerPawnCoordinateDistance computerPawnCoordinateDistance : computerAvailablePawnsCoordinates.getComputerPawnCoordinateDistanceList()) {
            if (!computerPawnCoordinateDistance.isPossibilityToBeBeatAfterMove()) {
                computerPawnCoordinateDistanceList.add(computerPawnCoordinateDistance);
            }
        }
        pawn = computerPawnCoordinateDistanceList.get(random.nextInt(computerPawnCoordinateDistanceList.size())).getPawn();
        for (ComputerPawnCoordinateDistance computerPawnCoordinateDistance : computerAvailablePawnsCoordinates.getComputerPawnCoordinateDistanceListByPawn(pawn)) {
            if (computerPawnCoordinateDistance.getDistanceToWinField() < distance) {
                distance = computerPawnCoordinateDistance.getDistanceToWinField();
                index = i;
            }
            i++;
        }
        return computerAvailablePawnsCoordinates.getComputerPawnCoordinateDistanceListByPawn(pawn).get(index);
    }

    public ComputerPawnCoordinateDistance getComputerPawnCoordinateDistance() {
        return selectComputerPawnCoordinateDistance();
    }
}
