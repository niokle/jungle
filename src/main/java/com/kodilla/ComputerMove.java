package com.kodilla;

import java.util.Random;

public class ComputerMove {
    private static final int boardNumberOfColumns = 6;
    private static final int boardNumberOfRows = 8;

    public void runComputerMove ( char color, BoardView boardView,boolean whiteOnTop, int level){
        PawnMoves pawnMoves = new PawnMoves(boardView);
        int coordinateChose = 0;
        int i = 0;
        Random random = new Random();

        for (int column = 0; column <= boardNumberOfColumns; column++) {
            for (int row = 0; row <= boardNumberOfRows; row++) {
                if (boardView.getPawn(column, row) != null) {
                    if (boardView.getPawn(column, row).getColour() == color) {

                        coordinateChose = random.nextInt(pawnMoves.getMoves(boardView.getPawn(column, row), column, row, whiteOnTop).size());
                        i = 0;

                        for (Coordinates c : pawnMoves.getMoves(boardView.getPawn(column, row), column, row, whiteOnTop)) {
                            if (boardView.getPawn(c.getColumn(), c.getRow()) != null) {
                                if (boardView.getPawn(c.getColumn(), c.getRow()).getActive() == true && boardView.getPawn(c.getColumn(), c.getRow()).getCurrentStrength() <= boardView.getPawn(column, row).getCurrentStrength()) {
                                    boardView.getPawn(c.getColumn(), c.getRow()).setActive(false);
                                    boardView.setPawnPosition(boardView.getPawn(column, row), c.getColumn(), c.getRow());
                                    continue;
                                }
                            } else {
                                if (i == coordinateChose) {
                                    boardView.setPawnPosition(boardView.getPawn(column, row), c.getColumn(), c.getRow());
                                    continue;
                                }
                            }
                            i++;
                        }
                    }
                }
            }
        }
    }
}