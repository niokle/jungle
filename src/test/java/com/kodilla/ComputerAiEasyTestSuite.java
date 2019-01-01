package com.kodilla;

import org.junit.Assert;
import org.junit.Test;

public class ComputerAiEasyTestSuite {

    @Test
    public void testPawnCoordinates() {
        //Given
        Pawn pawn;
        Coordinates coordinates;
        char color = 'W';
        boolean whiteOnTop = true;
        BoardView boardView = new BoardView(whiteOnTop);
        ComputerAiEasy computerAiEasy = new ComputerAiEasy(color, boardView, whiteOnTop);

        //When
        for (Pawn p : boardView.getAllPawns()) {
           if (p.getColour() == color && p.getName() != Pawn.Name.ELEPHANT) {
               p.setActive(false);
           }
        }
        pawn = computerAiEasy.getPawn();
        coordinates = computerAiEasy.getCoordinates(pawn);

        //Then
        Assert.assertEquals(Pawn.Name.ELEPHANT, pawn.getName());
        Assert.assertEquals(6, coordinates.getColumn());
        Assert.assertEquals(3, coordinates.getRow());
    }
}
