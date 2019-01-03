package com.kodilla;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Field {
    private Type type;
    private String imagePath;

    public enum Type {
        LAKE, TRAP, GRASS, HOME_WHITE, HOME_BLACK;
    }

    public Field(Type type, String imagePath) {
        this.type = type;
        this.imagePath = imagePath;
    }

    public Type getType() {
        return type;
    }

    public ImageView getImageView() {
        MyImageView myImageView = new MyImageView(imagePath);
        return myImageView.getImageView();
    }
}
