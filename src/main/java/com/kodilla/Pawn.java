package com.kodilla;

import javafx.scene.image.ImageView;

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
}
