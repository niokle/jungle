package com.kodilla;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class ComputerAiHard {
    private char color;
    private BoardView boardView;
    private boolean whiteOnTop;
    private static final int boardNumberOfColumns = 6;
    private static final int boardNumberOfRows = 8;
    private ArrayList<PawnAndCoordinate> pawnsAndCoordinateList = new ArrayList<>();
    private Random random = new Random();
    private PawnMoves pawnMoves;
    private Pawn pawn;
    private Coordinates coordinates;

    public ComputerAiHard(char color, BoardView boardView, boolean whiteOnTop) {
        this.color = color;
        this.boardView = boardView;
        this.whiteOnTop = whiteOnTop;
    }

    public PawnAndCoordinate findBating() {
        pawnsAndCoordinateList.clear();
        pawn = null;
        for (int column = 0; column <= boardNumberOfColumns; column++) {
            for (int row = 0; row <= boardNumberOfRows; row++) {
                if (boardView.getPawn(column, row) != null) {
                    if (boardView.getPawn(column, row).getColour() == color && boardView.getPawn(column, row).getActive() == true) {
                        for (Coordinates c : pawnMoves.getMoves(boardView.getPawn(column, row), column, row, whiteOnTop)) {
                            if (boardView.getPawn(c.getColumn(), c.getRow()) != null) {
                                if (boardView.getPawn(c.getColumn(), c.getRow()).getStrength() <= boardView.getPawn(column, row).getStrength()) {
                                    pawnsAndCoordinateList.add(new PawnAndCoordinate(boardView.getPawn(column, row), c));
                                }
                            }
                        }
                    }
                }
            }
        }
        return pawnsAndCoordinateList.get(random.nextInt(pawnsAndCoordinateList.size() - 1));
    }

    public PawnAndCoordinate findNearest() {
        pawn = null;
        // KOD
        return new PawnAndCoordinate(pawn, coordinates);
    }

    public Pawn getPawn(){
        Pawn pawn = null;
        if (findBating() != null) {
           pawn = findBating().getPawn();
           coordinates = findBating().getCoordinates();
        } else {
            if (findNearest() != null) {
                pawn = findNearest().getPawn();
                coordinates = findNearest().getCoordinates();
            }
        }
        return pawn;
    }

    public Coordinates getCoordinates(Pawn pawn) {
        return coordinates;
    }
}
