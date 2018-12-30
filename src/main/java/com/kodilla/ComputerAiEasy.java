package com.kodilla;

import java.util.ArrayList;
import java.util.Random;

public class ComputerAiEasy {
    private char color;
    private BoardView boardView;
    private boolean whiteOnTop;
    private static final int boardNumberOfColumns = 6;
    private static final int boardNumberOfRows = 8;
    private ArrayList<Pawn> pawnsList = new ArrayList<>();
    private Random random = new Random();
    private PawnMoves pawnMoves;
    private Coordinates coordinatesToWin;
    private ArrayList<Coordinates> coordinates = new ArrayList<>();

    public ComputerAiEasy(char color, BoardView boardView, boolean whiteOnTop) {
        this.color = color;
        this.boardView = boardView;
        this.whiteOnTop = whiteOnTop;
        if (color == 'W' && whiteOnTop || color == 'B' && !whiteOnTop) {
            coordinatesToWin = new Coordinates(3, 8, "");
        } else {
            coordinatesToWin = new Coordinates(3, 0, "");
        }
        pawnMoves = new PawnMoves(boardView);
    }

    public Pawn getPawn(){
        int pawnsListIndex = 0;
        pawnMoves = new PawnMoves(boardView);
        pawnsList.clear();
        for (int column = 0; column <= boardNumberOfColumns; column++) {
            for (int row = 0; row <= boardNumberOfRows; row++) {
                if (boardView.getPawn(column, row) != null) {
                    if (boardView.getPawn(column, row).getColour() == color && boardView.getPawn(column, row).getActive() == true) {
                        pawnsList.add(boardView.getPawn(column, row));
                    }
                }
            }
        }
        if (pawnsList.size() == 1) {
            pawnsListIndex = 0;
        } else {
            pawnsListIndex = random.nextInt(pawnsList.size());
        }
        return pawnsList.get(pawnsListIndex);
    }

    public Coordinates getCoordinates(Pawn pawn) {
        int column = boardView.getPawnCoordinates(pawn).getColumn();
        int row = boardView.getPawnCoordinates(pawn).getRow();
        int nearstCoordinate = 0;
        double nearstDistance = 100;
        double distance = 0;

        for (Coordinates c : pawnMoves.getMoves(pawn, column, row, whiteOnTop)) {
            coordinates.add(c);
            distance = Math.sqrt(Math.pow((coordinatesToWin.getColumn() - c.getColumn()), 2) + Math.pow((coordinatesToWin.getRow() - c.getRow()), 2));
            if (distance < nearstDistance) {
                if (boardView.getPawn(c.getColumn(), c.getRow()) == null) {
                    nearstDistance = distance;
                    nearstCoordinate = coordinates.size() - 1;
                } else if (boardView.getPawn(c.getColumn(), c.getRow()).getStrength() <= pawn.getStrength()) {
                    nearstDistance = distance;
                    nearstCoordinate = coordinates.size() - 1;
                }
            }
        }
        return coordinates.get(nearstCoordinate);
    }
}
