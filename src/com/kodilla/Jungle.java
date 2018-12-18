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
    private static final int boardNumberOfColumns = 6;
    private static final int boardNumberOfRows = 8;
    private BackgroundAndGrid backgroundAndGrid = new BackgroundAndGrid();
    private boolean whiteOnTop = true;
    private boolean whitePlayeOne = true;
    private boolean endOfGame = false;
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
    private Rules rules = new Rules();
    private ComputerMove computerMove = new ComputerMove();

    public static void main(String[] args) {
        launch(args);
    }

    public void newGame() {
       boardView.resetPositions();
       drawPawns();
       setupTexts();
       if (playerOneMove) {
           playerOneMove();
       } else {
           playerTwoMove();
       }
    }

    public void drawPawns() {
        backgroundAndGrid.getGrid().getChildren().clear();
        backgroundAndGrid.addConstantNodes();
        for (int column = 0; column <= boardNumberOfColumns; column++) {
            for (int row = 0; row <= boardNumberOfRows; row++) {
                if (boardView.getPawn(column, row) != null && boardView.getPawn(column, row).getActive()) {
                    backgroundAndGrid.getGrid().add(boardView.getPawn(column, row).getImageView(), column, row);
                }
            }
        }
    }

    public boolean checkIfVisiblePlayerMove(int column, int row) {
        boolean result = false;
        for (Coordinates c : coordinates) {
            if (c.getColumn() == column && c.getRow() == row) {
                result = true;
            }
        }
        return result;
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
        Rules.Win win;
        for (Coordinates c : pawnMoves.getMoves(selectedPawn, boardView.getPawnCoordinates(selectedPawn).getColumn(), boardView.getPawnCoordinates(selectedPawn).getRow(), whiteOnTop)) {
            if (c.getColumn() == coordinates.getColumn() && c.getRow() == coordinates.getRow()) {
                win = rules.runRules(selectedPawn, column, row, backgroundAndGrid.getBoard(), boardView);
                if (win == Rules.Win.WHITE && whitePlayeOne || win == Rules.Win.BLACK && !whitePlayeOne) {
                    backgroundAndGrid.getLabelWhoseMove().setText("Gracz 1 WYGRAŁ!");
                    endOfGame = true;
                } else if (win == Rules.Win.BLACK && whitePlayeOne || win == Rules.Win.WHITE && !whitePlayeOne) {
                    backgroundAndGrid.getLabelWhoseMove().setText("Gracz 2 WYGRAŁ!");
                    endOfGame = true;
                }
                if (selectedPawn.getActive()) {
                    boardView.setPawnPosition(selectedPawn, column, row);
                }
                playerOneMove = !playerOneMove;
                break;
            }
        }
        if (!endOfGame) {
            setupTexts();
        }
        drawPawns();
        if (playerOneMove) {
            playerOneMove();
        } else {
            playerTwoMove();
        }
    }

    public void setupTexts() {
        String top = null;
        String bot = null;
        if (backgroundAndGrid.getCheckBoxTop().isSelected()) {
            top = ": komputer";
        } else {
            top = ": człowiek";
        }
        if (backgroundAndGrid.getCheckBoxBot().isSelected()) {
            bot = ": komputer";
        } else {
            bot = ": człowiek";
        }

        if (whitePlayeOne && whiteOnTop || !whitePlayeOne && !whiteOnTop) {
            backgroundAndGrid.getCheckBoxTop().setText("Gracz 1" + top);
            backgroundAndGrid.getCheckBoxBot().setText("Gracz 2" + bot);
        } else {
            backgroundAndGrid.getCheckBoxTop().setText("Gracz 2" + top);
            backgroundAndGrid.getCheckBoxBot().setText("Gracz 1" + bot);
        }
        if (playerOneMove) {
            backgroundAndGrid.getLabelWhoseMove().setText("Ruch gracza 1");
        } else {
            backgroundAndGrid.getLabelWhoseMove().setText("Ruch gracza 2");
        }
    }

    public void playerOneMove() {
        char color;
        if (whitePlayeOne) {
            color = 'W';
        } else {
            color = 'B';
        }
        if (computerPlayerOne) {
            computerMove.runComputerMove(color, boardView);
            playerOneMove = false;
            drawPawns();
            playerTwoMove();
        }
    }

    public void playerTwoMove() {
        char color;
        if (whitePlayeOne) {
            color = 'B';
        } else {
            color = 'W';
        }
        if (computerPlayerTwo) {
            computerMove.runComputerMove(color, boardView);
            playerOneMove = true;
            drawPawns();
            playerOneMove();
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        setupTexts();

        drawPawns();

        backgroundAndGrid.getButtonNewGame().setOnAction((event) -> {
            newGame();
        });

        backgroundAndGrid.getCheckBoxTop().setOnAction((event) -> {
            if (backgroundAndGrid.getCheckBoxTop().isSelected()) {
                if (whitePlayeOne && whiteOnTop || !whitePlayeOne && !whiteOnTop) {
                    computerPlayerOne = true;
                } else {
                    computerPlayerTwo = true;
                }
            } else {
                if (whitePlayeOne && whiteOnTop || !whitePlayeOne && !whiteOnTop) {
                    computerPlayerOne = false;
                } else {
                    computerPlayerTwo = false;
                }
            }
            setupTexts();
        });

        backgroundAndGrid.getCheckBoxBot().setOnAction((event) -> {
            if (backgroundAndGrid.getCheckBoxBot().isSelected()) {
                if (whitePlayeOne && whiteOnTop || !whitePlayeOne && !whiteOnTop) {
                    computerPlayerTwo = true;
                } else {
                    computerPlayerOne = true;
                }
            } else {
                if (whitePlayeOne && whiteOnTop || !whitePlayeOne && !whiteOnTop) {
                    computerPlayerTwo = false;
                } else {
                    computerPlayerOne = false;
                }
            }
            setupTexts();
        });

        backgroundAndGrid.getGrid().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (!endOfGame) {
                    drawPawns();
                    int column = GridPane.getColumnIndex(event.getPickResult().getIntersectedNode());
                    int row = GridPane.getRowIndex(event.getPickResult().getIntersectedNode());
                    Pawn pawn = boardView.getPawn(column, row);

                    if (selectedPawn != null) {
                        if (selectedPawn == pawn) {
                            selectedPawn = null;
                            removePossiblePlayerMoves();
                        } else {
                            if (checkIfVisiblePlayerMove(column, row)) {
                                movePawn(selectedPawn, column, row);
                                selectedPawn = null;
                            }
                        }
                    } else if (pawn != null) {
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