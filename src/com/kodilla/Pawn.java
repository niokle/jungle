package com.kodilla;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Pawn {
    private String name;
    private char colour;
    private int strength;
    private Image image;
    private boolean active;
    private ImageView imageView;

    public Pawn(String name, char colour, int strength, String imagePath, boolean active) {
        this.name = name;
        this.colour = colour;
        this.strength = strength;
        this.image = new Image(imagePath);
        this.active = active;
        imageView = new ImageView(image);
        imageView.setFitHeight(77);
        imageView.setFitWidth(77);
    }

    public String getName() {
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
