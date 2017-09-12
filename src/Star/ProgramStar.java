package Star;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ProgramStar extends Application {

    public Group root = new Group();
    private Scene scene = new Scene(root, 800, 600);
    private double x0 = 300, y0 = 300; // центр
    private double R = 100;
    public Line[] lines = new Line[10];


    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Drawing Star");

        Button buttonDrawStar = new Button();
        buttonDrawStar.setText("Нарисовать звезду");
        buttonDrawStar.setTranslateX(265);
        buttonDrawStar.setTranslateY(10);

        Label x0y0Label =  new Label("Координаты центра (х; у): ");
        x0y0Label.setTranslateX(10);
        x0y0Label.setTranslateY(15);

        TextField x0TextField = new TextField();
        x0TextField.setText("" + x0);
        x0TextField.setTranslateX(155);
        x0TextField.setTranslateY(10);
        x0TextField.setMaxWidth(50);

        TextField y0TextField = new TextField();
        y0TextField.setText("" + y0);
        y0TextField.setTranslateX(210);
        y0TextField.setTranslateY(10);
        y0TextField.setMaxWidth(50);

        Label radiusOfCirclesLabel =  new Label("Радиус круга (R): ");
        radiusOfCirclesLabel.setTranslateX(10);
        radiusOfCirclesLabel.setTranslateY(40);

        TextField RTextField = new TextField();
        RTextField.setText("" + R);
        RTextField.setTranslateX(155);
        RTextField.setTranslateY(40);
        RTextField.setMaxWidth(105);

        buttonDrawStar.setOnAction(event -> {
            x0 = Double.parseDouble(x0TextField.getText());
            y0 = Double.parseDouble(y0TextField.getText());
            R  = Double.parseDouble(RTextField.getText());
            drawStar();
        });

        root.getChildren().add(buttonDrawStar);
        root.getChildren().add(x0y0Label);
        root.getChildren().add(x0TextField);
        root.getChildren().add(y0TextField);
        root.getChildren().add(radiusOfCirclesLabel);
        root.getChildren().add(RTextField);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void drawStar(){

        int n = 5;       // число вершин
        double vCol= 11; // число всех вершин
        double r = R * 2;   // радиусы
        double alpha = 55;        // поворот

        double a = alpha;
        double da = Math.PI / n;
        double l;

        //root.getChildren().remove(lines);
        for (int i = 0; i < 10; i++){
            if (lines[i] != null)
                lines[i].clear(root);
        }

        Point[] points = new Point[11];

        for (int k = 0; k < vCol; k++)
        {
            l = k % 2 == 0 ? r : R;
            points[k] = new Point(x0, y0);
            points[k].setX(l, a);
            points[k].setY(l, a);
            a += da;
        }

        Point prevPoint = points[0];

        for (int i = 1; i < 11; i++){
            Line line = new Line(prevPoint, points[i]);
            line.drawLine();
            prevPoint = points[i];
            lines[i-1] = line;
            line.addLineStar(root);
        }

    }

    private void drawStarTest(){

/*        int n = 5;       // число вершин
        double vCol= 11; // число всех вершин
        double r = R * 2;   // радиусы
        double alpha = 55;        // поворот

        double a = alpha, da = Math.PI / n, l;
        Point[] points = new Point[11];

        for (int k = 0; k < vCol; k++)
        {
            l = k % 2 == 0 ? r : R;
            double resultX = (float)(x0 + l * Math.cos(a));
            double resultY = (float)(y0 + l * Math.sin(a));
            a += da;
            points[k] = new Point(resultX, resultY);
        }

        Point prevPoint = points[0];

        for (int i = 1; i < 11; i++){
            Line line = new Line(prevPoint.x, prevPoint.y, points[i].x, points[i].y);
            line.setStrokeWidth(5);
            prevPoint = points[i];
            root.getChildren().add(line);
        }*/

    }

    public static void main(String[] args) {

        launch(args);

    }

}
