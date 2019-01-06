package com.kodilla;

public class BoardLoop {
    private static final int BOARD_NUMBER_OF_COLUMNS = 6;
    private static final int BOARD_NUMBER_OF_ROWS = 8;

    public void runBoardLoop(BoardLoopBody boardLoopBody) {
        for (int column = 0; column <= BOARD_NUMBER_OF_COLUMNS; column++) {
            for (int row = 0; row <= BOARD_NUMBER_OF_ROWS; row++) {
                boardLoopBody.boardLoopBodyDef(column, row);
            }
        }
    }
}
