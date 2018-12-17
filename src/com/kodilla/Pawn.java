package com.kodilla;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Pawn {
    private Name name;
    private char colour;
    private int strength;
    private Image image;
    private boolean active;
    private ImageView imageView;

    public enum Name {
        LION, TIGER, DOG, CAT, RAT, PHANTER, WOLF, ELEPHANT;
    }

    public Pawn(Name name, char colour, int strength, String imagePath, boolean active) {
        this.name = name;
        this.colour = colour;
        this.strength = strength;
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
        return colour;
    }

    public int getStrength() {
        return strength;
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
}
