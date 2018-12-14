package com.kodilla;

import javafx.scene.image.Image;

public class Home {
    private char colour;
    private Image image;

    public Home(char colour, String imagePath) {
        this.colour = colour;
        this.image = new Image(imagePath);
    }

    public char getColour() {
        return colour;
    }

    public Image getImage() {
        return image;
    }

}
