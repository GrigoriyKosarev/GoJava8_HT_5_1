import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.*;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.Random;

public class ProgramCircles extends Application{

    private static int NUMBER_OF_CIRCLES;
    private static int MIN_RADIUS_OF_CIRCLES;
    private static int MAX_RADIUS_OF_CIRCLES;

    private Pane root = new Pane();
    public Circle[] circles;

    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Модуль#5(1) Static, final и JavaFX");
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);

        //BUTTONS
        Button buttonDrawCircles = new Button();
        buttonDrawCircles.setText("Нарисовать круги");
        buttonDrawCircles.setTranslateX(120);
        buttonDrawCircles.setTranslateY(100);

        Button buttonSetColors = new Button();
        buttonSetColors.setText("Разукрасить круги");
        buttonSetColors.setTranslateX(120);
        buttonSetColors.setTranslateY(130);

        Button buttonSetColorsRed = new Button();
        buttonSetColorsRed.setText("Разукрасить в красный");
        buttonSetColorsRed.setTranslateX(120);
        buttonSetColorsRed.setTranslateY(160);

        Button buttonSetGradient = new Button();
        buttonSetGradient.setText("Gradient");
        buttonSetGradient.setTranslateX(120);
        buttonSetGradient.setTranslateY(190);

        //TEXT FIELD
        Label numberOfCirclesLabel =  new Label("Количество кругов: ");
        numberOfCirclesLabel.setTranslateX(10);
        numberOfCirclesLabel.setTranslateY(10);

        TextField numberOfCirclesField = new TextField();
        numberOfCirclesField.setText("3");
        numberOfCirclesField.setTranslateX(120);
        numberOfCirclesField.setTranslateY(10);

        Label minRadiusOfCirclesLabel =  new Label("Мин. радиус круга: ");
        minRadiusOfCirclesLabel.setTranslateX(10);
        minRadiusOfCirclesLabel.setTranslateY(40);

        TextField minRadiusOfCirclesField = new TextField();
        minRadiusOfCirclesField.setText("33");
        minRadiusOfCirclesField.setTranslateX(120);
        minRadiusOfCirclesField.setTranslateY(40);

        Label maxRadiusOfCirclesLabel =  new Label("Макс. радиус круга: ");
        maxRadiusOfCirclesLabel.setTranslateX(10);
        maxRadiusOfCirclesLabel.setTranslateY(70);

        TextField maxRadiusOfCirclesField = new TextField();
        maxRadiusOfCirclesField.setText("44");
        maxRadiusOfCirclesField.setTranslateX(120);
        maxRadiusOfCirclesField.setTranslateY(70);

        buttonDrawCircles.setOnAction(event -> {

            MIN_RADIUS_OF_CIRCLES = Integer.parseInt(minRadiusOfCirclesField.getText());
            MAX_RADIUS_OF_CIRCLES = Integer.parseInt(maxRadiusOfCirclesField.getText());
            NUMBER_OF_CIRCLES = Integer.parseInt(numberOfCirclesField.getText()) + 3;
            drawCircles();

        });

        buttonSetColors.setOnAction(event -> {
            setColorCircles();
        });

        buttonSetColorsRed.setOnAction(event -> {
            setColorCirclesRed();
        });

        buttonSetGradient.setOnAction(event -> {
            setGradient();
        });

        Scene scene = new Scene(root);

        root.getChildren().add(buttonDrawCircles);
        root.getChildren().add(buttonSetColors);
        root.getChildren().add(numberOfCirclesField);
        root.getChildren().add(numberOfCirclesLabel);
        root.getChildren().add(minRadiusOfCirclesLabel);
        root.getChildren().add(minRadiusOfCirclesField);
        root.getChildren().add(maxRadiusOfCirclesLabel);
        root.getChildren().add(maxRadiusOfCirclesField);
        root.getChildren().add(buttonSetColorsRed);
        root.getChildren().add(buttonSetGradient);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void drawCircles(){

        clearCircles();

        circles = new Circle[NUMBER_OF_CIRCLES];

        for (int i = 0; i < NUMBER_OF_CIRCLES; i++){

            root.getChildren().remove(circles[i]);

            circles[i] = new Circle();
            circles[i].setTranslateX(400);
            if (i > 3){

                double yRadius = MIN_RADIUS_OF_CIRCLES + Math.random()*MAX_RADIUS_OF_CIRCLES;
                double yTranslateY = 0;
                if (i == 4)
                    yTranslateY = circles[0].getTranslateY() + circles[0].getRadius() + yRadius;
                else
                    yTranslateY = circles[i-1].getTranslateY() + circles[i-1].getRadius() + yRadius;

                circles[i].setTranslateY(yTranslateY);
                circles[i].setRadius(yRadius);

            }
            else{
                drawHeadCircles(i);
            }

            root.getChildren().add(circles[i]);
            setColorCircle(i);

        }

    }

    private void drawHeadCircles(int i){

        if (i == 0){
            circles[i].setTranslateY(50);
            circles[i].setRadius(50);
        } else if (i == 1){
            circles[i].setTranslateY(25);
            circles[i].setTranslateX(390);
            circles[i].setRadius(5);
        } else if (i == 2){
            circles[i].setTranslateY(25);
            circles[i].setTranslateX(410);
            circles[i].setRadius(5);
        } else if (i == 3){
            circles[i].setTranslateY(45);
            circles[i].setTranslateX(400);
            circles[i].setRadius(7);
        }

    }

    private void clearCircles() {
        if (circles != null && circles.length > 0) {
            root.getChildren().removeAll(circles);
        }
    }

    private void setColorCircles(){

        for (int i = 0; i < NUMBER_OF_CIRCLES; i++) {
            setColorCircle(i);
        }

    }

    private void setColorCircle(int i){

        Random randomValue = new Random();

        Color color = Color.color(randomValue.nextDouble(),
                randomValue.nextDouble(),
                randomValue.nextDouble(),
                0.6f);

        circles[i].setFill(Paint.valueOf(color.toString()));

    }

    private void setColorCirclesRed(){

        for (int i = 0; i < NUMBER_OF_CIRCLES; i++) {
            circles[i].setFill(Paint.valueOf("red"));
        }

    }

    private void setGradient(){

        Stop[] stops = new Stop[] { new Stop(0, Color.BLACK), new Stop(1, Color.WHITE)};

        double endX   = 0;
        double endY   = 0;

        for (int i = 0; i < NUMBER_OF_CIRCLES; i++) {
            LinearGradient lg2 = new LinearGradient(circles[i].getTranslateX(), circles[i].getTranslateY(), endX, endY, false, CycleMethod.REFLECT, stops);
            circles[i].setFill(lg2);
        }

    }

    public static void main(String[] args) {

        launch(args);

    }

}
