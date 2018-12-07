package com.kodilla;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Jungle extends Application {
    private Image imageback = new Image("file:resources/board.png");
    private Image card = new Image("file:resources/pawns/pantherW.png");
    private FlowPane cards = new FlowPane(Orientation.HORIZONTAL);

    public static void main(String[] args) {
        //launch(args);
       Pawn pawn = new Pawn("Lion",'B', 1, "file:resources/pawns/ratW.png", true);
       PawnMoves pawnMoves = new PawnMoves();

       Board board = new Board();

       //System.out.println(board.getField(1, 1).getType());

          //     && pawn.getName() != "Rat" && pawn.getName() != "Lion" && pawn.getName() != "Tiger")

       for (Coordinates c : pawnMoves.getMoves(pawn, 3,1, true)) {
            System.out.println(c.getColumn() + " " + c.getRow());
        }

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        grid.setHgap(5.5);
        grid.setVgap(5.5);
        grid.setBackground(background);

        ImageView img = new ImageView(card);
        img.setFitHeight(70);
        img.setFitWidth(70);
        cards.getChildren().add(img);

        grid.add(cards, 0, 0, 3, 1);

        Scene scene = new Scene(grid, 1600, 900, Color.web("#CCFFCC"));

        primaryStage.setTitle("BlackJack");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
