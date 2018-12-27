package com.kodilla;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class PawnMoveTestSuite {

    @Test
    public void testMoveCase() {
        //Given
        boolean whiteOnTop = true;
        char colorOnTop = 'W';
        BoardView boardView = new BoardView(whiteOnTop);
        PawnMoves pawnMoves = new PawnMoves(boardView);

        //When
        Pawn pawn1 = new Pawn(Pawn.Name.RAT, colorOnTop, 1, "file:src/main/resources/pawns/rat" + colorOnTop + ".png", true);
        ArrayList<Coordinates> coordinates1 = pawnMoves.getMoves(pawn1, 1, 1, whiteOnTop);

        //Then
        Assert.assertEquals(4, coordinates1.size());
    }
}
