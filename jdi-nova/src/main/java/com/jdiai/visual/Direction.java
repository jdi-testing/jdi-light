package com.jdiai.visual;

import org.openqa.selenium.Point;

import java.util.function.BiFunction;

import static com.jdiai.tools.StringUtils.format;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Direction {
    public static BiFunction<Direction, Direction, Boolean> VECTOR_SIMILARITY =
            (v1, v2) -> v1.angle == v2.angle && v1.length == v2.length;

    private int angle;
    private int length;

    public Direction(int angle, int length) {
        this.angle = angle;
        this.length = length;
    }
    public Direction(Point point1, Point point2) {
        double difX = point2.x - point1.x;
        double difY = point2.y - point1.y;
        angle = calculateAngle(difX, difY);
        length = (int) sqrt(pow(difY, 2) + pow(difX, 2));
    }
    private int calculateAngle(double difX, double difY) {
        float angle = (float) Math.toDegrees(Math.atan2(-difY, difX));
        if(angle < 0){
            angle += 360;
        }
        return (int) angle;
    }
    public int angle() { return angle; }
    public double length() { return length; }
    public boolean isSimilarTo(Direction vector) {
        return VECTOR_SIMILARITY.apply(this, vector);
    }
    @Override
    public String toString() {
        return format("(angle:%s, length:%s)", angle, length);
    }
}
