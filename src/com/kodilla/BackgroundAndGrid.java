package com.kodilla;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class BackgroundAndGrid {
    private Image imageback = new Image("file:resources/board.png");
    private BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
    private BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
    private Background background = new Background(backgroundImage);
    private GridPane grid = new GridPane();
    private Font font = new Font("Arial", 16);
    private Color color = Color.rgb(0,0,0);
    private Label labelOnTop = new Label();
    private Label labelWhoseMove = new Label();
    private Label labelOnBot = new Label();
    private Button buttonNewGame = new Button();

    public BackgroundAndGrid() {
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setPadding(new Insets(0, 0, 0, 316));
        for (int column = 0; column <= 10; column++) {
            grid.getColumnConstraints().add(new ColumnConstraints(79));
            for (int row = 0; row <= 8; row++) {
                grid.getRowConstraints().add(new RowConstraints(79));
            }
        }
        grid.setHgap(0);
        grid.setVgap(0);
        grid.setBackground(background);
        //grid.setGridLinesVisible(true);

        labelOnTop.setFont(font);
        labelOnTop.setTextFill(color);
        labelWhoseMove.setFont(font);
        labelWhoseMove.setTextFill(color);
        labelOnBot.setFont(font);
        labelOnBot.setTextFill(color);
        grid.add(labelOnTop, 8, 1, 10, 1);
        grid.add(labelWhoseMove,8,3, 10,3);
        grid.add(labelOnBot, 8, 5, 10, 5);

        buttonNewGame.setFont(font);
        buttonNewGame.setTextFill(color);
        buttonNewGame.setText("Nowa gra");
        grid.add(buttonNewGame,8, 4, 9,4);
    }

    public GridPane getGrid() {
        return grid;
    }

    public Label getLabelOnTop() {
        return labelOnTop;
    }

    public Label getLabelWhoseMove() {
        return labelWhoseMove;
    }

    public Label getLabelOnBot() {
        return labelOnBot;
    }

    public Button getButtonNewGame() {
        return buttonNewGame;
    }

}
