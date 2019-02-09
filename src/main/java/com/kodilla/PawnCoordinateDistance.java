package com.kodilla;

import java.util.ArrayList;
import java.util.Random;

public class PawnCoordinateDistance {
    public static ComputerPawnCoordinateDistance getComputerPawnCoordinateDistance(ArrayList<ComputerPawnCoordinateDistance> computerPawnCoordinateDistancesList) {
        Random random = new Random();
        int sizeForRandom = computerPawnCoordinateDistancesList.size();
        if (sizeForRandom < 1) {
            sizeForRandom = 1;
        }
        int index = random.nextInt(sizeForRandom);
        return computerPawnCoordinateDistancesList.get(index);
    }
}
