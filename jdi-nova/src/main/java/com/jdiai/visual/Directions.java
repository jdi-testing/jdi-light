package com.jdiai.visual;

import com.jdiai.jsdriver.JSException;

import java.util.function.Function;

import static com.google.common.collect.Range.closed;

public class Directions {
    public static int MAIN_ACCURACY = 90;
    public static int SECOND_ACCURACY = 45;
    public static int LINE_ACCURACY = 5;
    public static int ANGLE_ACCURACY = 5;

    public static Function<Direction, Boolean> HIGHER = DIRECTION(90, MAIN_ACCURACY);
    public static Function<Direction, Boolean> LOWER = DIRECTION(270, MAIN_ACCURACY);
    public static Function<Direction, Boolean> LEFT = DIRECTION(180, MAIN_ACCURACY);
    public static Function<Direction, Boolean> RIGHT = DIRECTION(0, MAIN_ACCURACY);

    public static Function<Direction, Boolean> TOP_RIGHT = DIRECTION(45, SECOND_ACCURACY);
    public static Function<Direction, Boolean> TOP_LEFT = DIRECTION(135, SECOND_ACCURACY);
    public static Function<Direction, Boolean> BOTTOM_LEFT = DIRECTION(225, SECOND_ACCURACY);
    public static Function<Direction, Boolean> BOTTOM_RIGHT = DIRECTION(315, SECOND_ACCURACY);

    public static Function<Direction, Boolean> SAME_HORIZONTAL =
        d -> closed(180 - LINE_ACCURACY, 180 + LINE_ACCURACY).contains(d.angle())
            || closed(0, LINE_ACCURACY).contains(d.angle())
            || closed(360 - LINE_ACCURACY, 360).contains(d.angle());
    public static Function<Direction, Boolean> SAME_VERTICAL =
        d -> closed(90 - LINE_ACCURACY, 90 + LINE_ACCURACY).contains(d.angle())
            || closed(270 - LINE_ACCURACY, 270 + LINE_ACCURACY).contains(d.angle());

    public static Function<Direction, Boolean> DIRECTION(int angle, int accuracy) {
        if (angle < 0 || angle > 360 || accuracy < 0 || accuracy > 180) {
            throw new JSException("Angle should be in range [0, 360]; Accuracy in [0, 180], but Angle=%s; Accuracy=%s",
                    angle, accuracy);
        }
        int lower = angle - accuracy;
        int upper = angle + accuracy;
        if (lower >= 0 && upper <= 360) {
            return d -> d.angle() >= lower && d.angle() <= upper;
        }
        int min = lower < 0 ? 360 + lower : lower;
        int max = upper > 360 ? upper - 360 : upper;
        return d -> (d.angle() <= max && d.angle() >= 0) || (d.angle() <= 360 && d.angle() >= min);
    }
    public static Function<Direction, Boolean> ANGLE(int angle, int accuracy) {
        return DIRECTION(angle, accuracy);
    }
    public static Function<Direction, Boolean> ANGLE(int angle) {
        return ANGLE(angle, ANGLE_ACCURACY);
    }
}
