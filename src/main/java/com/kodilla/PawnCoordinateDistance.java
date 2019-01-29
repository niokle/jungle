package com.kodilla;

import java.util.ArrayList;
import java.util.Random;

public class PawnCoordinateDistance {
    public static ComputerPawnCoordinateDistance getComputerPawnCoordinateDistance(ArrayList<ComputerPawnCoordinateDistance> computerPawnCoordinateDistancesList) {
        Random random = new Random();
        int sizeForRandom = computerPawnCoordinateDistancesList.size(); //TODO / 2
        if (sizeForRandom < 1) {
            sizeForRandom = 1;
        }
        int index = random.nextInt(sizeForRandom);
        //TODO kod do wyczyszczenia
        //System.out.println("------------------ PawnCoordinateDistance ------------------");
        //System.out.println(computerPawnCoordinateDistancesList.get(index).getPawn().getName() + " " + computerPawnCoordinateDistancesList.get(index).getCoordinates().getColumn() + "-" + computerPawnCoordinateDistancesList.get(index).getCoordinates().getRow());
        //System.out.println("------------------ PawnCoordinateDistance ------------------");
        return computerPawnCoordinateDistancesList.get(index);
    }
}
