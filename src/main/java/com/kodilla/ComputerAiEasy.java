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

    public ComputerAiEasy(char color, BoardView boardView, boolean whiteOnTop) {
        this.color = color;
        this.boardView = boardView;
        this.whiteOnTop = whiteOnTop;
    }

    public Pawn getPawn(){
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
        return pawnsList.get(random.nextInt(pawnsList.size()));
    }

    public Coordinates getCoordinates(Pawn pawn) {
        int column = boardView.getPawnCoordinates(pawn).getColumn();
        int row = boardView.getPawnCoordinates(pawn).getRow();
        return pawnMoves.getMoves(pawn, column, row, whiteOnTop).get(random.nextInt(pawnMoves.getMoves(pawn, column, row, whiteOnTop).size()));
    }
}
