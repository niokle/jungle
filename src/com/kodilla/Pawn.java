package com.kodilla;

import javafx.scene.image.Image;

public class Pawn {
    private String name;
    private char colour;
    private int strength;
    private Image image;
    private boolean active;

    public Pawn(String name, char colour, int strength, String imagePath, boolean active) {
        this.name = name;
        this.colour = colour;
        this.strength = strength;
        this.image = new Image(imagePath);
        this.active = active;
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
}
