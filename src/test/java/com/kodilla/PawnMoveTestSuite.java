package com.kodilla;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;

public class PawnMoveTestSuite {

    @Test
    public void testMoveCase() {
        //Given
        boolean whiteOnTop = true;
        char colorOnTop = 'W';
        BoardView boardViewMock = mock(BoardView.class);
        PawnMoves pawnMoves = new PawnMoves(boardViewMock);

        //When
        Pawn pawn1 = new Pawn(Pawn.Name.RAT, colorOnTop, 1, "file:src/main/resources/pawns/rat" + colorOnTop + ".png", true);
        ArrayList<Coordinates> coordinates1 = pawnMoves.getMoves(pawn1, 1, 1, whiteOnTop);

        //Then
        Assert.assertEquals(4, coordinates1.size());
    }
}
