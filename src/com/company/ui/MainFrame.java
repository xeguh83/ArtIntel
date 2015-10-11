package com.company.ui;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * Created by например Андрей on 10.10.2015.
 */
public class MainFrame extends Application {

    public static final int WIDTH = 600;
    public static final int HEIGHT = 600;
    public static final int OFFSET_X = 5;
    public static final int OFFSET_Y = 5;

    @Override public void start(Stage primaryStage) {
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        Stage stage = new Stage(StageStyle.DECORATED);
        Scene scene = new Scene(new AnchorPane(canvas), WIDTH, HEIGHT);
        stage.setScene(scene);

        stage.setTitle("8Puzzle game solution finder");


        MenuBar menuBar = new MenuBar();


        Menu menuFile = new Menu("File");
        MenuItem exit = new MenuItem("Exit");
        exit.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                System.exit(0);
            }
        });
        menuFile.getItems().addAll(exit);

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
        drawGame(canvas);
        stage.show();
    }

    private void drawGame(Canvas canvas) {

    }


}
