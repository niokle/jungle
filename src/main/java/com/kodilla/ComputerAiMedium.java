package com.kodilla;

import java.util.ArrayList;
import java.util.Random;

public class ComputerAiMedium {
    private char color;
    private BoardView boardView;
    private boolean whiteOnTop;
    private static final int boardNumberOfColumns = 6;
    private static final int boardNumberOfRows = 8;
    private ArrayList<Pawn> pawnsList = new ArrayList<>();
    private Random random = new Random();
    private PawnMoves pawnMoves;

    public ComputerAiMedium(char color, BoardView boardView, boolean whiteOnTop) {
        this.color = color;
        this.boardView = boardView;
        this.whiteOnTop = whiteOnTop;
    }

    public Pawn getPawn(){
        pawnMoves = new PawnMoves(boardView);
        pawnsList.clear();

        //temp
        return new Pawn(Pawn.Name.RAT, 'W', 1, "", true);
    }

    public Coordinates getCoordinates(Pawn pawn) {

        //temp
        return new Coordinates(0,0, "");
    }
}
