package com.kodilla;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MyImageView {
    private ImageView imageView;

    public MyImageView(String imagePath) {
        Image image = new Image(imagePath);
        imageView = new ImageView(image);
        imageView.setFitHeight(79);
        imageView.setFitWidth(79);
    }

    public ImageView getImageView() {
        return imageView;
    }
}
