package com.kodilla;

public class Rules {
    public enum Win {
        WHITE, BLACK;
    }

    public Win runRules(Pawn pawn, int newColumn, int newRow, Board board, BoardView boardView) {
        Win result = null;
        if (board.getField(newColumn, newRow).getType() == Field.Type.TRAP) {
            pawn.setCurrentStrength(0);
        }
        if (board.getField(boardView.getPawnCoordinates(pawn).getColumn(), boardView.getPawnCoordinates(pawn).getRow()).getType() == Field.Type.TRAP) {
            pawn.setCurrentStrength(pawn.getStrength());
        }

        if (boardView.getPawn(newColumn, newRow) != null) {
            if (pawn.getName() == Pawn.Name.RAT && boardView.getPawn(newColumn, newRow).getName() == Pawn.Name.ELEPHANT || pawn.getName() == Pawn.Name.ELEPHANT && boardView.getPawn(newColumn, newRow).getName() == Pawn.Name.RAT) {
                if (pawn.getName() == Pawn.Name.RAT && boardView.getPawn(newColumn, newRow).getName() == Pawn.Name.ELEPHANT) {
                    if (pawn.getCurrentStrength() != 0) {
                        boardView.getPawn(newColumn, newRow).setActive(false);
                    } else {
                        pawn.setActive(false);
                    }
                }
                if (pawn.getName() == Pawn.Name.ELEPHANT && boardView.getPawn(newColumn, newRow).getName() == Pawn.Name.RAT) {
                    if (boardView.getPawn(newColumn, newRow).getCurrentStrength() != 0) {
                        pawn.setActive(false);
                    } else {
                        boardView.getPawn(newColumn, newRow).setActive(false);
                    }
                }
            } else {
                if (pawn.getCurrentStrength() < boardView.getPawn(newColumn, newRow).getCurrentStrength()) {
                    pawn.setActive(false);
                } else {
                    boardView.getPawn(newColumn, newRow).setActive(false);
                }
            }
        } else {

            if (pawn.getColour() == 'W' && board.getField(newColumn, newRow).getType() == Field.Type.HOME_BLACK) {
                result = Win.WHITE;
            } else if (pawn.getColour() == 'B' && board.getField(newColumn, newRow).getType() == Field.Type.HOME_WHITE) {
                result = Win.BLACK;
            }
        }
        return result;
    }
}