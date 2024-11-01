package org.example;

public class Point {
    private int x;

    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double doubleCalcDistTo(Point point) {
        return (point.getX() - x) * (point.getX() - x) + (point.getY() - y) * (point.getY() - y);
    }
}
