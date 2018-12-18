package com.kodilla;

public class ComputerMove {

    public void runComputerMove(char color, BoardView boardView) {
        PawnMoves pawnMoves = new PawnMoves(boardView);

        Pawn pawn = boardView.getPawnByNameColor(Pawn.Name.LION,color);
        int val = 0;
        int col = 0;
        if (color == 'W') {
            val = 1;
            col = 0;
        } else {
            val = -1;
            col = 6;
        }
        boardView.setPawnPosition(pawn, col, boardView.getPawnCoordinates(pawn).getRow() + val);
    }
}
