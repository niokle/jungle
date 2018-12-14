package com.kodilla;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Jungle extends Application {
    private BackgroundAndGrid backgroundAndGrid = new BackgroundAndGrid();
    private boolean whiteOnTop = true;
    private BoardView boardView = new BoardView(whiteOnTop);
    private PawnMoves pawnMoves = new PawnMoves();
    private ArrayList<ImageView> oldMoves = new ArrayList<>();

    public static void main(String[] args) {
        launch(args);
    }

    public void test() {
       //test
    }

    public void drawPawns() {
        for (int column = 0; column <= 6; column++) {
            for (int row = 0; row <= 8; row++) {
                if (boardView.getPawn(column, row) != null) {
                    backgroundAndGrid.getGrid().add(boardView.getPawn(column, row).getImageView(), column, row);
                }
                if (boardView.getHome(column, row) != null) {
                    backgroundAndGrid.getGrid().add(boardView.getHome(column, row).getImageView(), column, row);
                }
            }
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        backgroundAndGrid.getLabelWhoseMove().setText("Ruch gracza");

        drawPawns();

        backgroundAndGrid.getButtonNewGame().setOnAction((event) -> {
            test();
        });

        backgroundAndGrid.getGrid().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Image image = new Image("file:resources/move.png");
                ImageView imageView[] = {new ImageView(image), new ImageView(image), new ImageView(image), new ImageView(image)};
                int column = GridPane.getColumnIndex(event.getPickResult().getIntersectedNode());
                int row = GridPane.getRowIndex(event.getPickResult().getIntersectedNode());
                Pawn pawn = boardView.getPawn(column, row);
                ArrayList<Coordinates> coordinates = pawnMoves.getMoves(pawn, column, row, whiteOnTop);
                for (ImageView imv : oldMoves) {
                    //backgroundAndGrid.getGrid().remove(imv);
                }
                for (int i = 0; i < coordinates.size(); i++) {
                    oldMoves.add(imageView[i]);
                    backgroundAndGrid.getGrid().add(imageView[i], coordinates.get(i).getColumn(), coordinates.get(i).getRow());
                }
            }
        });

        Scene scene = new Scene(backgroundAndGrid.getGrid(), 1600, 900, Color.web("#CCFFCC"));

        primaryStage.setTitle("Jungle chess");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

}