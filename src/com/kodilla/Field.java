package com.kodilla;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Field {
    private Type type;
    private Image image;
    private ImageView imageView;

    public enum Type {
        LAKE, TRAP, GRASS, HOME_WHITE, HOME_BLACK;
    }

    public Field(Type type, String imagePath) {
        this.type = type;
        image = new Image(imagePath);
        imageView = new ImageView(image);
        imageView.setFitHeight(79);
        imageView.setFitWidth(79);
    }

    public Type getType() {
        return type;
    }

    public ImageView getImageView() {
        return imageView;
    }
}
