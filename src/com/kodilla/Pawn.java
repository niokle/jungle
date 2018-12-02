package com.kodilla;

import javafx.scene.image.Image;

public class Pawn {
    private int strength;
    private Image image;

    public Pawn(int strength, String imagePath) {
        this.strength = strength;
        this.image = new Image(imagePath);
    }

    public int getStrength() {
        return strength;
    }

    public Image getImage() {
        return image;
    }

}
