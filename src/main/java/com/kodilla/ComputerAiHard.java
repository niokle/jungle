package com.kodilla;

import java.util.Random;

public class ComputerAiHard {
    private char color;
    private BoardView boardView;
    private boolean whiteOnTop;

    public ComputerAiHard(char color, BoardView boardView, boolean whiteOnTop) {
        this.color = color;
        this.boardView = boardView;
        this.whiteOnTop = whiteOnTop;
    }

    public ComputerPawnCoordinateDistance selectComputerPawnCoordinateDistance() {
        ComputerAvailablePawnsCoordinates computerAvailablePawnsCoordinates = new ComputerAvailablePawnsCoordinates(color, boardView, whiteOnTop);
        Random random = new Random();
        ComputerPawnCoordinateDistance resultPriority1 = null;
        Pawn pawnResultPriority1 = null;
        ComputerPawnCoordinateDistance resultPriority2 = null;
        ComputerPawnCoordinateDistance resultPriority3 = null;
        ComputerPawnCoordinateDistance resultPriority4 = null;
        ComputerPawnCoordinateDistance result = null;
        double distancePriority3 = 100;
        double distancePriority4 = 100;
        computerAvailablePawnsCoordinates.fillComputerPawnCoordinateDistanceList();

        for (ComputerPawnCoordinateDistance computerPawnCoordinateDistance : computerAvailablePawnsCoordinates.getComputerPawnCoordinateDistanceList()) {
            if (computerPawnCoordinateDistance.isPossibilityToBeBeatIfDoNotMove()) {
                pawnResultPriority1 = computerPawnCoordinateDistance.getPawn();
                resultPriority1 = computerAvailablePawnsCoordinates.getComputerPawnCoordinateDistanceListByPawn(pawnResultPriority1).get(random.nextInt(computerAvailablePawnsCoordinates.getComputerPawnCoordinateDistanceListByPawn(pawnResultPriority1).size()));
            }
            if (computerPawnCoordinateDistance.isBeatingPossibility() && !computerPawnCoordinateDistance.isPossibilityToBeBeatAfterMove() && !computerPawnCoordinateDistance.isMoveToStrongerPawnPosition()) {
                resultPriority2 = computerPawnCoordinateDistance;
            }
            if (!computerPawnCoordinateDistance.isPossibilityToBeBeatAfterMove()) {
                if (computerPawnCoordinateDistance.getDistanceToWinField() < distancePriority3) {
                    distancePriority3 = computerPawnCoordinateDistance.getDistanceToWinField();
                    resultPriority3 = computerPawnCoordinateDistance;
                }
            }
            if (computerPawnCoordinateDistance.getDistanceToWinField() < distancePriority4) {
                distancePriority4 = computerPawnCoordinateDistance.getDistanceToWinField();
                resultPriority4 = computerPawnCoordinateDistance;
            }
        }

        if (resultPriority1 != null) {
            result = resultPriority1;
        } else if (resultPriority2 != null) {
            result = resultPriority2;
        } else if (resultPriority3 != null) {
            result = resultPriority3;
        } else {
            result = resultPriority4;
        }
        return result;
    }

    public ComputerPawnCoordinateDistance getComputerPawnCoordinateDistance() {
        return selectComputerPawnCoordinateDistance();
    }
}
