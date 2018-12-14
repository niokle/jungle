package com.kodilla;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Jungle extends Application {
    private BackgroundAndGrid backgroundAndGrid = new BackgroundAndGrid();
    private BoardView boardView = new BoardView(true);
    private PawnMoves pawnMoves = new PawnMoves();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        backgroundAndGrid.setTextWhoseMove("Ruch gracza");

        for (int column = 0; column <= 6; column++) {
            for (int row = 0; row <= 8; row++) {
                if (boardView.getPawn(column, row) != null) {
                    backgroundAndGrid.getGrid().add(boardView.getPawn(column, row).getImageView(), column, row);
                }
            }
        }

        Scene scene = new Scene(backgroundAndGrid.getGrid(), 1600, 900, Color.web("#CCFFCC"));

        primaryStage.setTitle("Jungle chess");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}