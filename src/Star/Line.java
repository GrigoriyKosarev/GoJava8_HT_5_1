package Star;

import javafx.scene.Group;
import javafx.scene.layout.Pane;

/**
 * Created by admin on 08.09.2017.
 */
public class Line {

    private Point p1, p2;
    private javafx.scene.shape.Line line;

    Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public void clear(Group root) {
        root.getChildren().remove(line);
        line = null;
    }

    public void drawLine(){
        line = new javafx.scene.shape.Line(p1.getX(), p1.getY(), p2.getX(), p2.getY());
        line.setStrokeWidth(5);
    }

    public void addLineStar(Group root){
        root.getChildren().add(line);
    }

    public Point getStart() {
        return p1;
    }

    public Point getEnd() {
        return p2;
    }

}
