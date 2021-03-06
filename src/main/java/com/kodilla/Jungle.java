package com.kodilla;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.ArrayList;

public class Jungle extends Application {
    private BackgroundAndGrid backgroundAndGrid = new BackgroundAndGrid();
    private boolean whiteOnTop = true;
    private boolean whitePlayerOne = true;
    private boolean endOfGame = false;
    private boolean computerPlayerOne = false;
    private boolean computerPlayerTwo = false;
    private Level computerPlayerOneLevel = Level.EASY;
    private Level computerPlayerTwoLevel = Level.EASY;
    private boolean playerOneMove = true;
    private BoardView boardView = new BoardView(whiteOnTop);
    private PawnMoves pawnMoves = new PawnMoves(boardView);
    private Image image = new Image("file:src/main/resources/move.png");
    private ImageView imageView[] = {new ImageView(image), new ImageView(image), new ImageView(image), new ImageView(image)};
    private int numberOfImageViews;
    private ArrayList<Coordinates> coordinates = new ArrayList<>();
    private Pawn selectedPawn;
    private Rules rules = new Rules();
    private ComputerMove computerMove = new ComputerMove();
    private Win win = new Win(whitePlayerOne, backgroundAndGrid);
    private BoardLoop boardLoop = new BoardLoop();

    public enum Level {
        HUMAN, EASY, MEDIUM, HARD
    }

    public static void main(String[] args) {
        launch(args);
    }


    public void newGame() {
        endOfGame = false;
        playerOneMove = true;
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
        boardLoop.runBoardLoop((columnBoardLoop, rowBoardLoop) -> {
            if (boardView.getPawn(columnBoardLoop, rowBoardLoop) != null && boardView.getPawn(columnBoardLoop, rowBoardLoop).getActive()) {
                backgroundAndGrid.getGrid().add(boardView.getPawn(columnBoardLoop, rowBoardLoop).getImageView(), columnBoardLoop, rowBoardLoop);
            }
        });
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
        coordinates = pawnMoves.getMoves(pawn, whiteOnTop);
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

    public void movePawnComputer(char color, Level level) {
        computerMove.runComputerMove(color, boardView, whiteOnTop, level, rules, backgroundAndGrid, whitePlayerOne, endOfGame, win);
        endOfGame = win.getEndOfGame();
        playerOneMove = !playerOneMove;
        drawPawns();
        if (!endOfGame) {
            setupTexts();
        }
        if (playerOneMove) {
            playerOneMove();
        } else {
            playerTwoMove();
        }
    }

    public void movePawn(Pawn selectedPawn, int column, int row) {
        Coordinates coordinates = new Coordinates(column, row, "");
        Rules.Win rulesWin;
        for (Coordinates c : pawnMoves.getMoves(selectedPawn, whiteOnTop)) {
            if (c.getColumn() == coordinates.getColumn() && c.getRow() == coordinates.getRow()) {
                rulesWin = rules.runRules(selectedPawn, column, row, backgroundAndGrid.getBoard(), boardView);
                win.checkWin(rulesWin);
                endOfGame = win.getEndOfGame();
                if (selectedPawn.getActive()) {
                    boardView.setPawnPosition(selectedPawn, column, row);
                }
                break;
            }
        }
        playerOneMove = !playerOneMove;
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
        if (whitePlayerOne && whiteOnTop || !whitePlayerOne && !whiteOnTop) {
            backgroundAndGrid.getLabelTop().setText("PLAYER 1");
            backgroundAndGrid.getLabelBot().setText("PLAYER 2");
        } else {
            backgroundAndGrid.getLabelTop().setText("PLAYER 2");
            backgroundAndGrid.getLabelBot().setText("PLAYER 1");
        }
        if (playerOneMove) {
            backgroundAndGrid.getLabelWhoseMove().setText("PLAYER 1 MOVE");
        } else {
            backgroundAndGrid.getLabelWhoseMove().setText("PLAYER 2 MOVE");
        }
    }

    public void playerOneMove() {
        char color;
        if (whitePlayerOne) {
            color = 'W';
        } else {
            color = 'B';
        }
        if (computerPlayerOne) {
            movePawnComputer(color, computerPlayerOneLevel);
        }
    }

    public void playerTwoMove() {
        char color;
        if (whitePlayerOne) {
            color = 'B';
        } else {
            color = 'W';
        }
        if (computerPlayerTwo) {
            movePawnComputer(color, computerPlayerTwoLevel);
        }
    }

    public void fillLevels() {
        backgroundAndGrid.getChoiceBoxTop().setItems(FXCollections.observableArrayList());
        backgroundAndGrid.getChoiceBoxTop().setItems(FXCollections.observableArrayList(Level.values()));
        backgroundAndGrid.getChoiceBoxTop().getSelectionModel().selectFirst();
        backgroundAndGrid.getChoiceBoxBot().setItems(FXCollections.observableArrayList());
        backgroundAndGrid.getChoiceBoxBot().setItems(FXCollections.observableArrayList(Level.values()));
        backgroundAndGrid.getChoiceBoxBot().getSelectionModel().selectFirst();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        fillLevels();
        setupTexts();
        drawPawns();

        backgroundAndGrid.getButtonNewGame().setOnAction((event) -> {
            newGame();
        });

        backgroundAndGrid.getChoiceBoxTop().setOnAction((event) -> {
            if (backgroundAndGrid.getChoiceBoxTop().getValue() == Level.HUMAN) {
                computerPlayerOne = false;
            } else {
                computerPlayerOne = true;
            }
            computerPlayerOneLevel = backgroundAndGrid.getChoiceBoxTop().getValue();
        });

        backgroundAndGrid.getChoiceBoxBot().setOnAction((event) -> {
            if (backgroundAndGrid.getChoiceBoxBot().getValue() == Level.HUMAN) {
                computerPlayerTwo = false;
            } else {
                computerPlayerTwo = true;
            }
            computerPlayerTwoLevel = backgroundAndGrid.getChoiceBoxBot().getValue();
        });

        backgroundAndGrid.getGrid().setOnMouseClicked(event -> {
            if (!endOfGame) {
                drawPawns();
                int column = 0;
                int row = 0;
                try {
                    column = GridPane.getColumnIndex(event.getPickResult().getIntersectedNode());
                    row = GridPane.getRowIndex(event.getPickResult().getIntersectedNode());
                } catch (NullPointerException exeption) {

                }
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
                    if (whitePlayerOne && playerOneMove || !whitePlayerOne && !playerOneMove) {
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
        });

        Scene scene = new Scene(backgroundAndGrid.getGrid(), 1600, 900, Color.web("#CCFFCC"));
        primaryStage.setTitle("Jungle chess");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}