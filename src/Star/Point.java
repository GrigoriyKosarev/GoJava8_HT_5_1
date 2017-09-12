package Star;

public class Point {

    private double x;
    private double y;
    private double x0;
    private double y0;

    Point() {
        this.x = 0;
        this.y = 0;
        this.x0 = 0;
        this.y0 = 0;
    }

    Point(double x0, double y0) {
        this.x0 = x0;
        this.y0 = y0;
    }

    Point(double x, double y, double x0, double y0) {
        this.x = x;
        this.y = y;
        this.x0 = x0;
        this.y0 = y0;
    }

    public void setX(double l, double a) {
        x = (float)(x0 + l * Math.cos(a));
    }

    public void setY(double l, double a) {
        y = (float)(y0 + l * Math.sin(a));
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
