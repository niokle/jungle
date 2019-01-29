package com.kodilla;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

    public ArrayList<ComputerPawnCoordinateDistance> selectComputerPawnCoordinateDistanceList() {
        List<ComputerPawnCoordinateDistance> computerPawnCoordinateDistancesList;
        ComputerAvailablePawnsCoordinates computerAvailablePawnsCoordinates = new ComputerAvailablePawnsCoordinates(color, boardView, whiteOnTop);
        computerAvailablePawnsCoordinates.fillComputerPawnCoordinateDistanceList();
        computerPawnCoordinateDistancesList = computerAvailablePawnsCoordinates.getComputerPawnCoordinateDistanceList().stream()
                .filter(c -> !c.isMoveToStrongerPawnPosition())
                .sorted(Comparator.comparing(ComputerPawnCoordinateDistance::getDistanceToWinField))
                .filter(c -> !c.isPossibilityToBeBeatAfterMove())
                .collect(Collectors.toList());
        //TODO kod do wyczyszczenia
        //System.out.println("-------------------------- ComputerAiMedium ------------------------");
        //for (ComputerPawnCoordinateDistance c : computerPawnCoordinateDistancesList) {
        //    System.out.println(
        //            c.getPawn().getColour() + " " +
        //                    c.getPawn().getName() + " " +
        //                    c.isPossibilityToBeBeatAfterMove() + " " +
        //                    c.isPossibilityToBeBeatIfDoNotMove() + " " +
        //                    c.isBeatingPossibility() + " " +
        //                    c.getDistanceToWinField() + " " +
        //                    c.getCoordinates().getColumn() + " " +
        //                    c.getCoordinates().getRow() + " " +
        //                    c.isMoveToStrongerPawnPosition()
        //    );
        //}
        //System.out.println("-------------------------- ComputerAiMedium ------------------------");
        return (ArrayList<ComputerPawnCoordinateDistance>) computerPawnCoordinateDistancesList;
    }

    public ComputerPawnCoordinateDistance getComputerPawnCoordinateDistance() {
        return PawnCoordinateDistance.getComputerPawnCoordinateDistance(selectComputerPawnCoordinateDistanceList());
    }
}