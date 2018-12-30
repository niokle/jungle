package com.kodilla;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class PawnMoveTestSuite {

    @Test
    public void testMoveCaseRat() {
        //Given
        boolean whiteOnTop = true;
        char colorOnTop = 'W';
        BoardView boardView = new BoardView(whiteOnTop);
        PawnMoves pawnMoves = new PawnMoves(boardView);
        int column = 2;
        int row = 2;
        Coordinates coordinates1 = new Coordinates(column, row - 1, "");
        Coordinates coordinates2 = new Coordinates(column, row + 1, "");
        Coordinates coordinates3 = new Coordinates(column - 1, row, "");
        Coordinates coordinates4 = new Coordinates(column + 1, row, "");

        //When
        Pawn pawn1 = new Pawn(Pawn.Name.RAT, colorOnTop, 1, "file:src/main/resources/pawns/rat" + colorOnTop + ".png", true);
        ArrayList<Coordinates> coordinates = pawnMoves.getMoves(pawn1, column, row, whiteOnTop);

        //Then
        Assert.assertEquals(4, coordinates.size());
        Assert.assertEquals(coordinates1.getColumn(), coordinates.get(0).getColumn());
        Assert.assertEquals(coordinates1.getRow(), coordinates.get(0).getRow());
        Assert.assertEquals(coordinates2.getColumn(), coordinates.get(1).getColumn());
        Assert.assertEquals(coordinates2.getRow(), coordinates.get(1).getRow());
        Assert.assertEquals(coordinates3.getColumn(), coordinates.get(2).getColumn());
        Assert.assertEquals(coordinates3.getRow(), coordinates.get(2).getRow());
        Assert.assertEquals(coordinates4.getColumn(), coordinates.get(3).getColumn());
        Assert.assertEquals(coordinates4.getRow(), coordinates.get(3).getRow());
    }

    @Test
    public void testMoveCaseDog() {
        //Given
        boolean whiteOnTop = true;
        char colorOnTop = 'W';
        BoardView boardView = new BoardView(whiteOnTop);
        PawnMoves pawnMoves = new PawnMoves(boardView);
        int column = 2;
        int row = 2;
        Coordinates coordinates1 = new Coordinates(column, row - 1, "");
        Coordinates coordinates3 = new Coordinates(column - 1, row, "");
        Coordinates coordinates4 = new Coordinates(column + 1, row, "");

        //When
        Pawn pawn1 = new Pawn(Pawn.Name.DOG, colorOnTop, 1, "file:src/main/resources/pawns/dog" + colorOnTop + ".png", true);
        ArrayList<Coordinates> coordinates = pawnMoves.getMoves(pawn1, column, row, whiteOnTop);

        //Then
        Assert.assertEquals(3, coordinates.size());
        Assert.assertEquals(coordinates1.getColumn(), coordinates.get(0).getColumn());
        Assert.assertEquals(coordinates1.getRow(), coordinates.get(0).getRow());
        Assert.assertEquals(coordinates3.getColumn(), coordinates.get(1).getColumn());
        Assert.assertEquals(coordinates3.getRow(), coordinates.get(1).getRow());
        Assert.assertEquals(coordinates4.getColumn(), coordinates.get(2).getColumn());
        Assert.assertEquals(coordinates4.getRow(), coordinates.get(2).getRow());
    }

    @Test
    public void testMoveCaseLion() {
        //Given
        boolean whiteOnTop = true;
        char colorOnTop = 'W';
        BoardView boardView = new BoardView(whiteOnTop);
        PawnMoves pawnMoves = new PawnMoves(boardView);
        int column = 2;
        int row = 2;
        Coordinates coordinates1 = new Coordinates(column, row - 1, "");
        Coordinates coordinates2 = new Coordinates(column, row + 4, "");
        Coordinates coordinates3 = new Coordinates(column - 1, row, "");
        Coordinates coordinates4 = new Coordinates(column + 1, row, "");

        //When
        Pawn pawn1 = new Pawn(Pawn.Name.LION, colorOnTop, 7, "file:src/main/resources/pawns/lion" + colorOnTop + ".png", true);
        ArrayList<Coordinates> coordinates = pawnMoves.getMoves(pawn1, column, row, whiteOnTop);

        //Then
        Assert.assertEquals(4, coordinates.size());
        Assert.assertEquals(coordinates1.getColumn(), coordinates.get(0).getColumn());
        Assert.assertEquals(coordinates1.getRow(), coordinates.get(0).getRow());
        Assert.assertEquals(coordinates2.getColumn(), coordinates.get(1).getColumn());
        Assert.assertEquals(coordinates2.getRow(), coordinates.get(1).getRow());
        Assert.assertEquals(coordinates3.getColumn(), coordinates.get(2).getColumn());
        Assert.assertEquals(coordinates3.getRow(), coordinates.get(2).getRow());
        Assert.assertEquals(coordinates4.getColumn(), coordinates.get(3).getColumn());
        Assert.assertEquals(coordinates4.getRow(), coordinates.get(3).getRow());
    }
}

