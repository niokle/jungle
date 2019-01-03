package com.kodilla;

public class Win {
    private boolean endOfGame;
    private boolean whitePlayerOne;
    private BackgroundAndGrid backgroundAndGrid;

    public Win(boolean whitePlayerOne, BackgroundAndGrid backgroundAndGrid) {
        endOfGame = false;
        this.whitePlayerOne = whitePlayerOne;
        this.backgroundAndGrid = backgroundAndGrid;
    }

    public void checkWin(Rules.Win win) {
        if (win == Rules.Win.WHITE && whitePlayerOne || win == Rules.Win.BLACK && !whitePlayerOne) {
            backgroundAndGrid.getLabelWhoseMove().setText("PLAYER 1 WIN!");
            endOfGame = true;
        } else if (win == Rules.Win.BLACK && whitePlayerOne || win == Rules.Win.WHITE && !whitePlayerOne) {
            backgroundAndGrid.getLabelWhoseMove().setText("PLAYER 2 WIN!");
            endOfGame = true;
        }
    }

    public boolean getEndOfGame() {
        return endOfGame;
    }
}
