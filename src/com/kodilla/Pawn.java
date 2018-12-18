package com.kodilla;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Pawn {
    private Name name;
    private char color;
    private int strength;
    private int currentStrength;
    private Image image;
    private boolean active;
    private ImageView imageView;

    public enum Name {
        LION, TIGER, DOG, CAT, RAT, PHANTER, WOLF, ELEPHANT;
    }

    public Pawn(Name name, char color, int strength, String imagePath, boolean active) {
        this.name = name;
        this.color = color;
        this.strength = strength;
        currentStrength = strength;
        this.image = new Image(imagePath);
        this.active = active;
        imageView = new ImageView(image);
        imageView.setFitHeight(79);
        imageView.setFitWidth(79);
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

    public Image getImage() {
        return image;
    }

    public boolean getActive() {
        return active;
    }

    public ImageView getImageView() {
        return imageView;
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
