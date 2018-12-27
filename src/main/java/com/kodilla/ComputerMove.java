package com.kodilla;

public class ComputerMove {
    private Board board = new Board();

    public void runComputerMove (char color, BoardView boardView, boolean whiteOnTop, Jungle.Level level, Rules rules, BackgroundAndGrid backgroundAndGrid, boolean whitePlayeOne, boolean endOfGame) {
        Pawn pawn = null;
        Coordinates coordinates = null;
        Rules.Win win;

        switch (level) {
            case EASY:
                ComputerAiEasy computerAiEasy = new ComputerAiEasy(color, boardView, whiteOnTop);
                pawn = computerAiEasy.getPawn();
                coordinates = computerAiEasy.getCoordinates(pawn);
                break;
            case MEDIUM:
                ComputerAiMedium computerAiMedium = new ComputerAiMedium(color, boardView, whiteOnTop);
                pawn = computerAiMedium.getPawn();
                coordinates = computerAiMedium.getCoordinates(pawn);
                break;
            case HARD:
                ComputerAiHard computerAiHard = new ComputerAiHard(color, boardView, whiteOnTop);
                pawn = computerAiHard.getPawn();
                coordinates = computerAiHard.getCoordinates(pawn);
                break;
        }
        win = rules.runRules(pawn, coordinates.getColumn(), coordinates.getRow(), board, boardView);
        if (win == Rules.Win.WHITE && whitePlayeOne || win == Rules.Win.BLACK && !whitePlayeOne) {
            backgroundAndGrid.getLabelWhoseMove().setText("Gracz 1 WYGRAŁ!");
            endOfGame = true;
        } else if (win == Rules.Win.BLACK && whitePlayeOne || win == Rules.Win.WHITE && !whitePlayeOne) {
            backgroundAndGrid.getLabelWhoseMove().setText("Gracz 2 WYGRAŁ!");
            endOfGame = true;
        }
        if (pawn.getActive()) {
            boardView.setPawnPosition(pawn, coordinates.getColumn(), coordinates.getRow());
        }
    }
}