package com.kodilla;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Home {
    private char colour;
    private Image image;
    private ImageView imageView;

    public Home(char colour, String imagePath) {
        this.colour = colour;
        this.image = new Image(imagePath);
        imageView = new ImageView(image);
        imageView.setFitHeight(77);
        imageView.setFitWidth(77);
    }

    public char getColour() {
        return colour;
    }

    public Image getImage() {
        return image;
    }

    public ImageView getImageView() {
        return imageView;
    }

}
