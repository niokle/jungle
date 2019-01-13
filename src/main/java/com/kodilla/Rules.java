package com.kodilla;

public class Rules {
    public enum Win {
        WHITE, BLACK
    }

    public Win runRules(Pawn pawn, int newColumn, int newRow, Board board, BoardView boardView) {
        Win result = null;
        if (isFieldTrap(newColumn, newRow, board)) {
            pawn.setCurrentStrength(0);
        }
        if (isFieldTrap(boardView.getPawnCoordinates(pawn).getColumn(), boardView.getPawnCoordinates(pawn).getRow(), board)) {
            pawn.setCurrentStrength(pawn.getStrength());
        }

        if (boardView.getPawn(newColumn, newRow) != null) {
            if (isBothPawnsAreRatAndElephant(pawn, newColumn, newRow, boardView)) {
                if (isPawnRatBeatPawnElephant(pawn, newColumn, newRow, boardView)) {
                    if (pawn.getCurrentStrength() != 0) {
                        boardView.getPawn(newColumn, newRow).setActive(false);
                    } else {
                        pawn.setActive(false);
                    }
                }
                if (isPawnElephantBeatPawnRat(pawn, newColumn, newRow, boardView)) {
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

            if (isWhitePawnInBlackHome(pawn, newColumn, newRow, board)) {
                result = Win.WHITE;
            } else if (isBlackPawnInWhiteHome(pawn, newColumn, newRow, board)) {
                result = Win.BLACK;
            }
        }
        if (!isAnyPawnActive(boardView, 'B')) {
            result = Win.WHITE;
        } else if (!isAnyPawnActive(boardView, 'W')) {
            result = Win.BLACK;
        }
        return result;
    }

    private boolean isPawnElephantBeatPawnRat(Pawn pawn, int newColumn, int newRow, BoardView boardView) {
        return pawn.getName() == Pawn.Name.ELEPHANT && boardView.getPawn(newColumn, newRow).getName() == Pawn.Name.RAT;
    }

    private boolean isPawnRatBeatPawnElephant(Pawn pawn, int newColumn, int newRow, BoardView boardView) {
        return pawn.getName() == Pawn.Name.RAT && boardView.getPawn(newColumn, newRow).getName() == Pawn.Name.ELEPHANT;
    }

    private boolean isBlackPawnInWhiteHome(Pawn pawn, int newColumn, int newRow, Board board) {
        return pawn.getColour() == 'B' && board.getField(newColumn, newRow).getType() == Field.Type.HOME_WHITE;
    }

    private boolean isWhitePawnInBlackHome(Pawn pawn, int newColumn, int newRow, Board board) {
        return pawn.getColour() == 'W' && board.getField(newColumn, newRow).getType() == Field.Type.HOME_BLACK;
    }

    private boolean isBothPawnsAreRatAndElephant(Pawn pawn, int newColumn, int newRow, BoardView boardView) {
        return isPawnRatBeatPawnElephant(pawn, newColumn, newRow, boardView) || isPawnElephantBeatPawnRat(pawn, newColumn, newRow, boardView);
    }

    private boolean isFieldTrap(int newColumn, int newRow, Board board) {
        return board.getField(newColumn, newRow).getType() == Field.Type.TRAP;
    }

    public boolean isAnyPawnActive(BoardView boardView, char color) {
        long numberOfActivePawns = boardView.getAllPawns().stream()
                .filter(pawn -> pawn.getActive())
                .filter(pawn -> pawn.getColour() == color)
                .count();
        if (numberOfActivePawns > 0) {
            return true;
        }
        return false;
    }
}