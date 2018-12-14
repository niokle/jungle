package com.kodilla;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.ArrayList;

public class Jungle extends Application {
    private BackgroundAndGrid backgroundAndGrid = new BackgroundAndGrid();
    private boolean whiteOnTop = true;
    private boolean computerOnTop = true;
    private BoardView boardView = new BoardView(whiteOnTop);
    private PawnMoves pawnMoves = new PawnMoves();
    private Image image = new Image("file:resources/move.png");
    private ImageView imageView[] = {new ImageView(image), new ImageView(image), new ImageView(image), new ImageView(image)};
    private int numberOfImageViews;
    private ArrayList<Coordinates> coordinates = new ArrayList<>();

    public static void main(String[] args) {
        launch(args);
    }

    public void test() {
       //akcja
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
        if(computerOnTop) {
            backgroundAndGrid.getLabelOnTop().setText("KOMPUTER");
            backgroundAndGrid.getLabelOnBot().setText("GRACZ");
        } else {
            backgroundAndGrid.getLabelOnTop().setText("GRACZ");
            backgroundAndGrid.getLabelOnBot().setText("KOMPUTER");
        }
        backgroundAndGrid.getLabelWhoseMove().setText("Ruch gracza");

        drawPawns();

        backgroundAndGrid.getButtonNewGame().setOnAction((event) -> {
            test();
        });

        backgroundAndGrid.getGrid().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                int column = GridPane.getColumnIndex(event.getPickResult().getIntersectedNode());
                int row = GridPane.getRowIndex(event.getPickResult().getIntersectedNode());
                Pawn pawn = boardView.getPawn(column, row);
                char colorNotAvailable;
                if (computerOnTop) {
                    if (whiteOnTop) {
                        colorNotAvailable = 'W';
                    } else {
                        colorNotAvailable = 'B';
                    }
                }  else {
                    if (whiteOnTop) {
                        colorNotAvailable = 'B';
                    } else {
                        colorNotAvailable = 'W';
                    }
                }
                if (pawn.getColour() != colorNotAvailable) {
                    coordinates.clear();
                    coordinates = pawnMoves.getMoves(pawn, column, row, whiteOnTop);
                    for (int i = 0; i <= numberOfImageViews; i++) {
                        backgroundAndGrid.getGrid().getChildren().remove(imageView[i]);
                    }
                    for (int j = 0; j < coordinates.size(); j++) {
                        imageView[j].setFitHeight(20);
                        imageView[j].setFitWidth(20);
                        backgroundAndGrid.getGrid().add(imageView[j], coordinates.get(j).getColumn(), coordinates.get(j).getRow());
                        numberOfImageViews = j;
                    }
                }
            }
        });

        Scene scene = new Scene(backgroundAndGrid.getGrid(), 1600, 900, Color.web("#CCFFCC"));

        primaryStage.setTitle("Jungle chess");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}