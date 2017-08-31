import com.sun.javafx.scene.control.skin.IntegerFieldSkin;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

import java.util.Random;
import java.util.Scanner;

public class JavaFXMyTest extends Application{

    private static int NUMBER_OF_CIRCLES;
    private static int MIN_RADIUS_OF_CIRCLES;
    private static int MAX_RADIUS_OF_CIRCLES;

    public Circle[] circles;

    @Override
    public void start(Stage primaryStage) throws Exception {

        Scanner sc = new Scanner(System.in);

        /*System.out.print("Введите количество кругов: ");
        NUMBER_OF_CIRCLES = sc.nextInt() + 3;
        sc.nextLine();*/

        System.out.print("Введите минимальный радиус круга: ");
        MIN_RADIUS_OF_CIRCLES = sc.nextInt();
        sc.nextLine();

        System.out.print("Введите максимальный радиус круга: ");
        MAX_RADIUS_OF_CIRCLES = sc.nextInt();
        sc.nextLine();

        primaryStage.setTitle("Модуль#5(1) Static, final и JavaFX");
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);

        Pane root = new Pane();

        //BUTTONS
        Button buttonDrawCircles = new Button();
        buttonDrawCircles.setText("Нарисовать круги");
        buttonDrawCircles.setTranslateX(100);
        buttonDrawCircles.setTranslateY(50);

        Button buttonSetColors = new Button();
        buttonSetColors.setText("Разукрасить круги");
        buttonSetColors.setTranslateX(100);
        buttonSetColors.setTranslateY(100);

        TextField numberOfCirclesField = new TextField();
        numberOfCirclesField.setText("3");
        numberOfCirclesField.setTranslateX(100);
        numberOfCirclesField.setTranslateY(10);

        /*TextField countField = new TextField();
        countField.setTranslateX(10);
        countField.setTranslateY(10);
        countField.setText("50");*/

        NUMBER_OF_CIRCLES = Integer.parseInt(numberOfCirclesField.getText()) + 3;
        Circle[] circles = new Circle[NUMBER_OF_CIRCLES];

        buttonDrawCircles.setOnAction(event -> {
            NUMBER_OF_CIRCLES = Integer.parseInt(numberOfCirclesField.getText()) + 3;
            drawCircles(circles, root);
        });

        buttonSetColors.setOnAction(event -> {
            setColorCircles(circles);
        });

        Scene scene = new Scene(root);

        root.getChildren().add(buttonDrawCircles);
        root.getChildren().add(buttonSetColors);
        root.getChildren().add(numberOfCirclesField);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void drawCircles(Circle[] circles, Pane root){

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
                /*circles[i].setTranslateY(50);
                circles[i].setRadius(50);*/
                drawHeadCircles(circles, i);

            }

            root.getChildren().add(circles[i]);
            setColorCircle(circles, i);

        }

    }

    private void drawHeadCircles(Circle[] circles, int i){

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

    private void setColorCircles(Circle[] circles){

        for (int i = 0; i < NUMBER_OF_CIRCLES; i++) {
            setColorCircle(circles, i);
        }

    }

    private void setColorCircle(Circle[] circles, int i){

        Random randomValue = new Random();

        Color color = Color.color(randomValue.nextDouble(),
                randomValue.nextDouble(),
                randomValue.nextDouble(),
                0.6f);

        circles[i].setFill(Paint.valueOf(color.toString()));

    }

    public static void main(String[] args) {

        launch(args);

    }

}
