package com.kodilla;

public class ComputerMove {
    private Board board = new Board();

    public void runComputerMove (char color, BoardView boardView, boolean whiteOnTop, Jungle.Level level, Rules rules, BackgroundAndGrid backgroundAndGrid, boolean whitePlayerOne, boolean endOfGame, Win win) {
        Pawn pawn = null;
        Coordinates coordinates = null;
        Rules.Win rulesWin;

        switch (level) {
            case EASY:
                ComputerAiEasy computerAiEasy = new ComputerAiEasy(color, boardView, whiteOnTop);
                ComputerPawnCoordinateDistance computerPawnCoordinateDistance = computerAiEasy.getComputerPawnCoordinateDistance();
                pawn = computerPawnCoordinateDistance.getPawn();
                coordinates = computerPawnCoordinateDistance.getCoordinates();
                break;
            case MEDIUM:
                ComputerAiMedium computerAiMedium = new ComputerAiMedium(color, boardView, whiteOnTop);
                pawn = computerAiMedium.getComputerPawnCoordinateDistance().getPawn();
                coordinates = computerAiMedium.getComputerPawnCoordinateDistance().getCoordinates();
                break;
            case HARD:
                ComputerAiHard computerAiHard = new ComputerAiHard(color, boardView, whiteOnTop);
                pawn = computerAiHard.getComputerPawnCoordinateDistance().getPawn();
                coordinates = computerAiHard.getComputerPawnCoordinateDistance().getCoordinates();
                break;
        }
        rulesWin = rules.runRules(pawn, coordinates.getColumn(), coordinates.getRow(), board, boardView);
        win.checkWin(rulesWin);
        if (pawn.getActive()) {
            boardView.setPawnPosition(pawn, coordinates.getColumn(), coordinates.getRow());
            //test
            //System.out.println(pawn.getColour() + " " + pawn.getName() + " " + coordinates.getColumn() + "-" + coordinates.getRow());
        }
    }
}