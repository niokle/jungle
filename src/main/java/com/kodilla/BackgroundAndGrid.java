package com.kodilla;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class BackgroundAndGrid {
    private GridPane grid = new GridPane();
    private Font font = new Font("Arial", 14);
    private Color color = Color.rgb(0,0,0);
    private Label labelTop = new Label();
    private Label labelWhoseMove = new Label();
    private Label labelBot = new Label();
    private Button buttonNewGame = new Button();
    private Board board = new Board();
    private static final int GRID_NUMBER_OF_COLUMNS = 10;
    private static final int GRID_NUMBER_OF_ROWS = 8;
    private ChoiceBox<Jungle.Level> choiceBoxTop = new ChoiceBox<>();
    private ChoiceBox<Jungle.Level> choiceBoxBot = new ChoiceBox<>();

    public BackgroundAndGrid() {
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setPadding(new Insets(0, 0, 0, 316));
        for (int column = 0; column <= GRID_NUMBER_OF_COLUMNS; column++) {
            grid.getColumnConstraints().add(new ColumnConstraints(79));
            for (int row = 0; row <= GRID_NUMBER_OF_ROWS; row++) {
                grid.getRowConstraints().add(new RowConstraints(79));
            }
        }
        grid.setHgap(0);
        grid.setVgap(0);
        //TODO kod do wyczyszczenia
        //grid.setGridLinesVisible(true);
    }

    public void addConstantNodes() {
        BoardLoop boardLoop = new BoardLoop();
        boardLoop.runBoardLoop((columnBoardLoop, rowBoardLoop) -> grid.add(board.getField(columnBoardLoop, rowBoardLoop).getImageView(), columnBoardLoop, rowBoardLoop));

        labelTop.setFont(font);
        labelTop.setTextFill(color);
        labelWhoseMove.setFont(font);
        labelWhoseMove.setTextFill(color);
        labelBot.setFont(font);
        labelBot.setTextFill(color);
        grid.add(labelTop, 8, 1, 10, 1);
        grid.add(choiceBoxTop, 8, 1, 10, 2);
        grid.add(labelWhoseMove,8,3, 10,3);
        grid.add(labelBot, 8, 5, 10, 5);
        grid.add(choiceBoxBot, 8, 5, 10, 6);
        buttonNewGame.setFont(font);
        buttonNewGame.setTextFill(color);
        buttonNewGame.setText("Nowa gra");
        grid.add(buttonNewGame,8, 3, 8,4);
    }

    public GridPane getGrid() {
        return grid;
    }

    public Label getLabelTop() {
        return labelTop;
    }

    public Label getLabelWhoseMove() {
        return labelWhoseMove;
    }

    public Label getLabelBot() {
        return labelBot;
    }

    public Button getButtonNewGame() {
        return buttonNewGame;
    }

    public Board getBoard() {
        return board;
    }

    public ChoiceBox<Jungle.Level> getChoiceBoxTop() {
        return choiceBoxTop;
    }

    public ChoiceBox<Jungle.Level> getChoiceBoxBot() {
        return choiceBoxBot;
    }
}
