package com.kodilla;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class BackgroundAndGrid {
    private GridPane grid = new GridPane();
    private Font font = new Font("Arial", 12);
    private Color color = Color.rgb(0,0,0);
    private CheckBox checkBoxTop = new CheckBox();
    private Label labelWhoseMove = new Label();
    private CheckBox checkBoxBot = new CheckBox();
    private Button buttonNewGame = new Button();
    private Board board = new Board();
    private static final int gridNumberOfColumns = 10;
    private static final int gridNumberOfRows = 8;
    private static final int boardNumberOfColumns = 6;
    private static final int boardNumberOfRows = 8;

    public BackgroundAndGrid() {
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setPadding(new Insets(0, 0, 0, 316));
        for (int column = 0; column <= gridNumberOfColumns; column++) {
            grid.getColumnConstraints().add(new ColumnConstraints(79));
            for (int row = 0; row <= gridNumberOfRows; row++) {
                grid.getRowConstraints().add(new RowConstraints(79));
            }
        }
        grid.setHgap(0);
        grid.setVgap(0);
        //grid.setGridLinesVisible(true);
    }

    public void addConstantNodes() {
        for (int column = 0; column <= boardNumberOfColumns; column++) {
            for (int row = 0; row <= boardNumberOfRows; row++) {
                grid.add(board.getField(column, row).getImageView(), column, row);
            }
        }

        checkBoxTop.setFont(font);
        checkBoxTop.setTextFill(color);
        labelWhoseMove.setFont(font);
        labelWhoseMove.setTextFill(color);
        checkBoxBot.setFont(font);
        checkBoxBot.setTextFill(color);
        grid.add(checkBoxTop, 8, 1, 10, 1);
        grid.add(labelWhoseMove,8,3, 10,3);
        grid.add(checkBoxBot, 8, 5, 10, 5);

        buttonNewGame.setFont(font);
        buttonNewGame.setTextFill(color);
        buttonNewGame.setText("Nowa gra");
        grid.add(buttonNewGame,8, 4, 8,4);
    }

    public GridPane getGrid() {
        return grid;
    }

    public CheckBox getCheckBoxTop() {
        return checkBoxTop;
    }

    public Label getLabelWhoseMove() {
        return labelWhoseMove;
    }

    public CheckBox getCheckBoxBot() {
        return checkBoxBot;
    }

    public Button getButtonNewGame() {
        return buttonNewGame;
    }

    public Board getBoard() {
        return board;
    }

}