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
    private boolean whitePlayeOne = true;
    private boolean computerPlayerOne = false;
    private boolean computerPlayerTwo = false;
    private boolean playerOneMove = true;
    private BoardView boardView = new BoardView(whiteOnTop);
    private PawnMoves pawnMoves = new PawnMoves(boardView);
    private Image image = new Image("file:resources/move.png");
    private ImageView imageView[] = {new ImageView(image), new ImageView(image), new ImageView(image), new ImageView(image)};
    private int numberOfImageViews;
    private ArrayList<Coordinates> coordinates = new ArrayList<>();
    private Pawn selectedPawn;

    public static void main(String[] args) {
        launch(args);
    }

    public void test() {
       boardView.resetPositions();
       drawPawns();
    }

    public void drawPawns() {
        backgroundAndGrid.getGrid().getChildren().clear();
        backgroundAndGrid.addConstantNodes();
        for (int column = 0; column <= 6; column++) {
            for (int row = 0; row <= 8; row++) {
                if (boardView.getPawn(column, row) != null) {
                    backgroundAndGrid.getGrid().add(boardView.getPawn(column, row).getImageView(), column, row);
                }
            }
        }
    }

    public void showPossiblePlayerMoves(Pawn pawn, int column, int row) {
        removePossiblePlayerMoves();
        coordinates.clear();
        coordinates = pawnMoves.getMoves(pawn, column, row, whiteOnTop);
        for (int j = 0; j < coordinates.size(); j++) {
            imageView[j].setFitHeight(79);
            imageView[j].setFitWidth(79);
            backgroundAndGrid.getGrid().add(imageView[j], coordinates.get(j).getColumn(), coordinates.get(j).getRow());
            numberOfImageViews = j;
        }
    }

    public void removePossiblePlayerMoves() {
        for (int i = 0; i <= numberOfImageViews; i++) {
            backgroundAndGrid.getGrid().getChildren().remove(imageView[i]);
        }
    }

    public void movePawn(Pawn selectedPawn, int column, int row) {
        Coordinates coordinates = new Coordinates(column, row, "");
        for (Coordinates c : pawnMoves.getMoves(selectedPawn, boardView.getPawnCoordinates(selectedPawn).getColumn(), boardView.getPawnCoordinates(selectedPawn).getRow(), whiteOnTop)) {
            //System.out.println(c.getColumn() + " - " + c.getRow());
            if (c.getColumn() == coordinates.getColumn() && c.getRow() == coordinates.getRow()) {
                boardView.setPawnPosition(selectedPawn, column, row);
                playerOneMove = !playerOneMove;
            }
        }
        drawPawns();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        if(whitePlayeOne && whiteOnTop || !whitePlayeOne && !whiteOnTop) {
            backgroundAndGrid.getLabelOnTop().setText("Gracz 1");
            backgroundAndGrid.getLabelOnBot().setText("Gracz 2");
        } else {
            backgroundAndGrid.getLabelOnTop().setText("Gracz 2");
            backgroundAndGrid.getLabelOnBot().setText("Gracz 1");
        }
        if (playerOneMove) {
            backgroundAndGrid.getLabelWhoseMove().setText("Ruch gracza 1");
        } else {
            backgroundAndGrid.getLabelWhoseMove().setText("Ruch gracza 2");
        }

        drawPawns();

        backgroundAndGrid.getButtonNewGame().setOnAction((event) -> {
            test();
        });

        backgroundAndGrid.getGrid().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                drawPawns();
                //if (playerOneMove) {
                    int column = GridPane.getColumnIndex(event.getPickResult().getIntersectedNode());
                    int row = GridPane.getRowIndex(event.getPickResult().getIntersectedNode());
                    Pawn pawn = boardView.getPawn(column, row);

                    if (pawn != null) {
                        char possibleColor;
                        if (whitePlayeOne && playerOneMove || !whitePlayeOne && !playerOneMove) {
                            possibleColor = 'W';
                        } else {
                            possibleColor = 'B';
                        }

                        if (pawn.getColour() == possibleColor) {
                            showPossiblePlayerMoves(pawn, column, row);
                            selectedPawn = pawn;
                        }

                    } else {
                        if (selectedPawn != null) {
                            movePawn(selectedPawn, column, row);
                        }
                    }
                //
                  ///      Pawn pawn = boardView.getPawn(column, row);
                     //   selectedPawn = pawn;
                    // test
                   // backgroundAndGrid.getLabelWhoseMove().setText(column + " - " + row + " / " + pawn);
                    // test

                }


        });

        Scene scene = new Scene(backgroundAndGrid.getGrid(), 1600, 900, Color.web("#CCFFCC"));

        primaryStage.setTitle("Jungle chess");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}