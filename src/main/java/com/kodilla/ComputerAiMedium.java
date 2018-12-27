package com.kodilla;

import java.util.ArrayList;
import java.util.Random;

public class ComputerAiMedium {
    private char color;
    private BoardView boardView;
    private boolean whiteOnTop;
    private static final int boardNumberOfColumns = 6;
    private static final int boardNumberOfRows = 8;
    private ArrayList<Pawn> pawnsList = new ArrayList<>();
    private Random random = new Random();
    private PawnMoves pawnMoves;

    public ComputerAiMedium(char color, BoardView boardView, boolean whiteOnTop) {
        this.color = color;
        this.boardView = boardView;
        this.whiteOnTop = whiteOnTop;
    }

    public Pawn getPawn(){
        Coordinates coordinatesToWin;
        int nearstPawn = 0;
        double nearstDistance = 100;
        double distance = 0;
        pawnMoves = new PawnMoves(boardView);

        if (color == 'W' && whiteOnTop || color == 'B' && !whiteOnTop) {
            coordinatesToWin = new Coordinates(3, 8, "");
        } else {
            coordinatesToWin = new Coordinates(3, 0, "");
        }

        pawnsList.clear();
        for (int column = 0; column <= boardNumberOfColumns; column++) {
            for (int row = 0; row <= boardNumberOfRows; row++) {
                if (boardView.getPawn(column, row) != null) {
                    if (boardView.getPawn(column, row).getColour() == color && boardView.getPawn(column, row).getActive() == true) {
                        pawnsList.add(boardView.getPawn(column, row));
                        distance = Math.sqrt(Math.pow((coordinatesToWin.getColumn() - column), 2) + Math.pow((coordinatesToWin.getRow() - row), 2));
                        if (distance < nearstDistance) {
                            nearstDistance = distance;
                            nearstPawn = pawnsList.size() - 1;
                        }
                    }
                }
            }
        }
        return pawnsList.get(nearstPawn);
    }

    public Coordinates getCoordinates(Pawn pawn) {
        int column = boardView.getPawnCoordinates(pawn).getColumn();
        int row = boardView.getPawnCoordinates(pawn).getRow();
        return pawnMoves.getMoves(pawn, column, row, whiteOnTop).get(random.nextInt(pawnMoves.getMoves(pawn, column, row, whiteOnTop).size()));
    }
}
