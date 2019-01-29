package com.kodilla;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ComputerAiHard {
    private char color;
    private BoardView boardView;
    private boolean whiteOnTop;

    public ComputerAiHard(char color, BoardView boardView, boolean whiteOnTop) {
        this.color = color;
        this.boardView = boardView;
        this.whiteOnTop = whiteOnTop;
    }

    public ArrayList<ComputerPawnCoordinateDistance> selectComputerPawnCoordinateDistanceList() {
        List<ComputerPawnCoordinateDistance> computerPawnCoordinateDistancesList;
        ComputerAvailablePawnsCoordinates computerAvailablePawnsCoordinates = new ComputerAvailablePawnsCoordinates(color, boardView, whiteOnTop);
        computerAvailablePawnsCoordinates.fillComputerPawnCoordinateDistanceList();
        long numberOfMoves = computerAvailablePawnsCoordinates.getComputerPawnCoordinateDistanceList().stream()
                .filter(c -> c.isBeatingPossibility())
                .count();
        if( numberOfMoves > 0) {
            computerPawnCoordinateDistancesList = computerAvailablePawnsCoordinates.getComputerPawnCoordinateDistanceList().stream()
                    .filter(c -> c.isBeatingPossibility())
                    .sorted(Comparator.comparing(ComputerPawnCoordinateDistance::getDistanceToWinField))
                    .collect(Collectors.toList());
            return (ArrayList<ComputerPawnCoordinateDistance>) computerPawnCoordinateDistancesList;
        } else {
            numberOfMoves = computerAvailablePawnsCoordinates.getComputerPawnCoordinateDistanceList().stream()
                    .filter(c -> !c.isMoveToStrongerPawnPosition())
                    .filter(c -> !c.isPossibilityToBeBeatAfterMove())
                    .filter(c -> !c.isPossibilityToBeBeatIfDoNotMove())
                    .count();
            if( numberOfMoves > 0) {
                computerPawnCoordinateDistancesList = computerAvailablePawnsCoordinates.getComputerPawnCoordinateDistanceList().stream()
                        .filter(c -> !c.isMoveToStrongerPawnPosition())
                        .filter(c -> !c.isPossibilityToBeBeatAfterMove())
                        .filter(c -> !c.isPossibilityToBeBeatIfDoNotMove())
                        .sorted(Comparator.comparing(ComputerPawnCoordinateDistance::getDistanceToWinField))
                        .collect(Collectors.toList());
                return (ArrayList<ComputerPawnCoordinateDistance>) computerPawnCoordinateDistancesList;
            } else {
                numberOfMoves = computerAvailablePawnsCoordinates.getComputerPawnCoordinateDistanceList().stream()
                        .filter(c -> !c.isMoveToStrongerPawnPosition())
                        .filter(c -> !c.isPossibilityToBeBeatAfterMove())
                        .count();
                if( numberOfMoves > 0) {
                    computerPawnCoordinateDistancesList = computerAvailablePawnsCoordinates.getComputerPawnCoordinateDistanceList().stream()
                            .filter(c -> !c.isMoveToStrongerPawnPosition())
                            .filter(c -> !c.isPossibilityToBeBeatAfterMove())
                            .sorted(Comparator.comparing(ComputerPawnCoordinateDistance::getDistanceToWinField))
                            .collect(Collectors.toList());
                    return (ArrayList<ComputerPawnCoordinateDistance>) computerPawnCoordinateDistancesList;
                } else {
                    numberOfMoves = computerAvailablePawnsCoordinates.getComputerPawnCoordinateDistanceList().stream()
                            .filter(c -> !c.isMoveToStrongerPawnPosition())
                            .count();
                    if( numberOfMoves > 0) {
                        computerPawnCoordinateDistancesList = computerAvailablePawnsCoordinates.getComputerPawnCoordinateDistanceList().stream()
                                .filter(c -> !c.isMoveToStrongerPawnPosition())
                                .sorted(Comparator.comparing(ComputerPawnCoordinateDistance::getDistanceToWinField))
                                .collect(Collectors.toList());
                        return (ArrayList<ComputerPawnCoordinateDistance>) computerPawnCoordinateDistancesList;
                    } else {
                        numberOfMoves = computerAvailablePawnsCoordinates.getComputerPawnCoordinateDistanceList().stream()
                                .count();
                        if( numberOfMoves > 0) {
                            computerPawnCoordinateDistancesList = computerAvailablePawnsCoordinates.getComputerPawnCoordinateDistanceList().stream()
                                    .sorted(Comparator.comparing(ComputerPawnCoordinateDistance::getDistanceToWinField))
                                    .collect(Collectors.toList());
                            return (ArrayList<ComputerPawnCoordinateDistance>) computerPawnCoordinateDistancesList;
                        }
                    }
                }
            }
        }

        computerPawnCoordinateDistancesList = computerAvailablePawnsCoordinates.getComputerPawnCoordinateDistanceList().stream()
                .filter(c -> !c.isMoveToStrongerPawnPosition())
                .sorted(Comparator.comparing(ComputerPawnCoordinateDistance::getDistanceToWinField))
                .collect(Collectors.toList());
        //TODO kod do wyczyszczenia
        //System.out.println(computerPawnCoordinateDistancesList.size());
        return (ArrayList<ComputerPawnCoordinateDistance>) computerPawnCoordinateDistancesList;
    }

    public ComputerPawnCoordinateDistance getComputerPawnCoordinateDistance() {
        return PawnCoordinateDistance.getComputerPawnCoordinateDistance(selectComputerPawnCoordinateDistanceList());
    }
}
