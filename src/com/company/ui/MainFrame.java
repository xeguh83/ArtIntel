package com.company.ui;

import com.company.logic.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executors;

/**
 * Created by �������� ������ on 10.10.2015.
 */
public class MainFrame extends Application {

    public static final int MENU_HEIGHT = 25;
    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;
    public static final int OFFSET_X = 5;
    public static final int OFFSET_Y = 5;
    public static final int LENGTH = 3;
    public static final int RECT_WIDTH = (WIDTH - (OFFSET_X * (LENGTH + 2))) / (LENGTH + 1);
    public static final int RECT_HEIGHT = (HEIGHT - (OFFSET_Y * (LENGTH + 1))) / (LENGTH);
    public static final int FONT_SIZE = RECT_HEIGHT / 2;
    private Canvas canvas;



    @Override public void start(Stage primaryStage) {
        canvas = new Canvas(WIDTH, HEIGHT);
        Stage stage = new Stage(StageStyle.DECORATED);
        Scene scene = new Scene(new AnchorPane(canvas), WIDTH, HEIGHT);
        stage.setScene(scene);

        stage.setTitle("8Puzzle game solution finder");


        MenuBar menuBar = new MenuBar();


        Menu menuFile = new Menu("File");
        MenuItem exit = new MenuItem("Exit");
        exit.setOnAction(t -> System.exit(0));
        MenuItem startSearch = new MenuItem("Start");
        startSearch.setOnAction(event -> {
            Executors.newSingleThreadExecutor().execute(() -> {
                State startState = new State(new int[][] {
                        {6, 0, 8},
                        {5, 2, 1},
                        {4, 3, 7}
                }, new Coordinates(1, 0));

                State endState = new State(new int[][] {
                        {1, 2, 3},
                        {8, 0, 4},
                        {7, 6, 5}
                }, new Coordinates(1, 1));

                Problem problem = new Problem(startState, endState);

                LinkedList<State> solution = null;
                try {
                    solution = new SolutionFinder().generalSearch(problem, new Strategy());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (solution.isEmpty()) {
                    System.out.println("There is no solution for this task");
                } else {
                   while (!solution.isEmpty()) {
                       drawState(solution.poll());
                   }

                }
                });


        });
        menuFile.getItems().addAll(startSearch, exit);

        Menu menuSearch = new Menu("Search");

        //Toggle Group Menu

        ToggleGroup toggleGroup = new ToggleGroup();
        RadioMenuItem radioItemA = new RadioMenuItem("Depth-first search");
        radioItemA.setSelected(true);
        RadioMenuItem radioItemB = new RadioMenuItem("A star search");
        radioItemA.setToggleGroup(toggleGroup);
        radioItemB.setToggleGroup(toggleGroup);
        menuSearch.getItems().add(radioItemA);
        menuSearch.getItems().add(radioItemB);


        menuBar.getMenus().addAll(menuFile, menuSearch);
        ((AnchorPane) scene.getRoot()).getChildren().addAll(menuBar);
        stage.setScene(scene);
        drawGame();
        stage.show();
    }

    private void drawGame() {
        GraphicsContext g2d = canvas.getGraphicsContext2D();
        g2d.setFill(Color.BEIGE);
        g2d.fillRect(0, MENU_HEIGHT, WIDTH, HEIGHT);

        g2d.setFont(Font.font(FONT_SIZE));
        for (int i = 0; i < LENGTH; i++) {
            for (int j = 0; j < LENGTH; j++) {
                int rectX = OFFSET_X + (i * (RECT_WIDTH + OFFSET_X));
                int rectY = MENU_HEIGHT + OFFSET_Y + (j * (RECT_HEIGHT + OFFSET_Y));
                g2d.setFill(Color.BLACK);
                g2d.fillRect(rectX, rectY, RECT_WIDTH, RECT_HEIGHT);
              /*  g2d.setFill(Color.AQUA);
                String text = String.valueOf(gameBoard.getState().getCondition().charAt(i+j*2));
                if (text.equals("0"))
                    continue;
                g2d.fillText(text, rectX + (RECT_WIDTH - FONT_SIZE / 2 * text.length()) / 2, rectY + (RECT_HEIGHT / 2 + FONT_SIZE / 2)); */
            }
        }
        int consoleWidth = RECT_WIDTH;
        int consoleHeight = (RECT_HEIGHT * LENGTH) + (OFFSET_Y * (LENGTH - 1));
        int consoleX = (RECT_WIDTH * LENGTH) + (OFFSET_X * (LENGTH + 1));
        int consoleY = MENU_HEIGHT + OFFSET_Y;
        g2d.fillRect(consoleX, consoleY, consoleWidth, consoleHeight);
    }

    public void drawState(State state) {
        GraphicsContext g2d = canvas.getGraphicsContext2D();
        int[][] data = state.getData();
        for (int j = 0; j < data.length; j++) {
            for (int i = 0; i < data[j].length; i++) {
                int rectX = OFFSET_X + (i * (RECT_WIDTH + OFFSET_X));
                int rectY = MENU_HEIGHT + OFFSET_Y + (j * (RECT_HEIGHT + OFFSET_Y));
                g2d.setFill(Color.BLACK);
                g2d.fillRect(rectX, rectY, RECT_WIDTH, RECT_HEIGHT);
                g2d.setFill(Color.AQUA);
                String text = String.valueOf(data[j][i]);
                if (text.equals("0"))
                    continue;
                g2d.fillText(text, rectX + (RECT_WIDTH - FONT_SIZE / 2 * text.length()) / 2, rectY + (RECT_HEIGHT / 2 + FONT_SIZE / 2));
            }
        }

    }




}
