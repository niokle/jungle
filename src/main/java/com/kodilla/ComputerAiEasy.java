package com.kodilla;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ComputerAiEasy {
    private char color;
    private BoardView boardView;
    private boolean whiteOnTop;

    public ComputerAiEasy(char color, BoardView boardView, boolean whiteOnTop) {
        this.color = color;
        this.boardView = boardView;
        this.whiteOnTop = whiteOnTop;
    }

    public ArrayList<ComputerPawnCoordinateDistance> selectComputerPawnCoordinateDistanceList() {
        List<ComputerPawnCoordinateDistance> computerPawnCoordinateDistancesList;
        ComputerAvailablePawnsCoordinates computerAvailablePawnsCoordinates = new ComputerAvailablePawnsCoordinates(color, boardView, whiteOnTop);
        computerAvailablePawnsCoordinates.fillComputerPawnCoordinateDistanceList();
        computerPawnCoordinateDistancesList = computerAvailablePawnsCoordinates.getComputerPawnCoordinateDistanceList().stream()
                .filter(c -> !c.isMoveToStrongerPawnPosition())
                .sorted(Comparator.comparing(ComputerPawnCoordinateDistance::getDistanceToWinField))
                .collect(Collectors.toList());
        return (ArrayList<ComputerPawnCoordinateDistance>) computerPawnCoordinateDistancesList;
    }

    public ComputerPawnCoordinateDistance getComputerPawnCoordinateDistance() {
        return PawnCoordinateDistance.getComputerPawnCoordinateDistance(selectComputerPawnCoordinateDistanceList());
    }
}
