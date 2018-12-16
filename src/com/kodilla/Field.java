package com.kodilla;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Field {
    private String type;
    private Image image;
    private ImageView imageView;

    public Field(String type, String imagePath) {
        this.type = type;
        image = new Image(imagePath);
        imageView = new ImageView(image);
        imageView.setFitHeight(79);
        imageView.setFitWidth(79);
    }

    public String getType() {
        return type;
    }

    public ImageView getImageView() {
        return imageView;
    }
}
