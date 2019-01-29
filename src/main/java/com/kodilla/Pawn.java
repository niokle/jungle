package com.kodilla;

import javafx.scene.image.ImageView;

import java.util.Objects;

public class Pawn {
    private Name name;
    private char color;
    private int strength;
    private int currentStrength;
    private boolean active;
    private String imagePath;
    private MyImageView myImageView;

    public enum Name {
        LION, TIGER, DOG, CAT, RAT, PANTHER, WOLF, ELEPHANT
    }

    public Pawn(Name name, char color, int strength, String imagePath, boolean active) {
        this.name = name;
        this.color = color;
        this.strength = strength;
        currentStrength = strength;
        this.active = active;
        this.imagePath = imagePath;
    }

    public Name getName() {
        return name;
    }

    public char getColour() {
        return color;
    }

    public int getCurrentStrength() {
        return currentStrength;
    }


    public boolean getActive() {
        return active;
    }

    public ImageView getImageView() {
        if (myImageView == null) {
            myImageView = new MyImageView(imagePath);
        }
        return myImageView.getImageView();
    }

    public void setCurrentStrength(int currentStrength) {
        this.currentStrength = currentStrength;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getStrength() {
        return strength;
    }

    public enum StrengthComparison {
        STRONGER, WEAKER, EQUAL
    }

    public StrengthComparison compareTheStrengthToAnotherPawn(Pawn otherPawn) {
        if (currentStrength == 1 && otherPawn.getCurrentStrength() == 8) {
            return StrengthComparison.STRONGER;
        } else if (currentStrength == 8 && otherPawn.getCurrentStrength() == 1) {
            return StrengthComparison.WEAKER;
        } else {
                if (currentStrength > otherPawn.getCurrentStrength()) {
                    return StrengthComparison.STRONGER;
                } else if (currentStrength < otherPawn.getCurrentStrength()) {
                    return StrengthComparison.WEAKER;
                }
                return StrengthComparison.EQUAL;
            }
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pawn pawn = (Pawn) o;
        return color == pawn.color &&
                getStrength() == pawn.getStrength() &&
                getCurrentStrength() == pawn.getCurrentStrength() &&
                getActive() == pawn.getActive() &&
                getName() == pawn.getName() &&
                imagePath.equals(pawn.imagePath);
    }
}
