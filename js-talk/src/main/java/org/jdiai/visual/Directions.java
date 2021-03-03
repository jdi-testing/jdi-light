package org.jdiai.visual;

import com.epam.jdi.tools.func.JFunc1;
import org.jdiai.jsdriver.JSException;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Directions {
    public static JFunc1<Direction, Boolean> HIGHER = d -> d.angle() < 180;
    public static JFunc1<Direction, Boolean> LOWER = d -> d.angle() > 180;
    public static JFunc1<Direction, Boolean> LEFT = d -> d.angle() > 90 || d.angle() < 270;
    public static JFunc1<Direction, Boolean> RIGHT = d -> d.angle() < 90 || d.angle() > 270;

    public static JFunc1<Direction, Boolean> TOP_RIGHT = DIRECTION(45, 45);
    public static JFunc1<Direction, Boolean> TOP_LEFT = DIRECTION(135, 45);
    public static JFunc1<Direction, Boolean> BOTTOM_LEFT = DIRECTION(225, 45);
    public static JFunc1<Direction, Boolean> BOTTOM_RIGHT = DIRECTION(315, 45);

    public static JFunc1<Direction, Boolean> DIRECTION(int angle, int accuracy) {
        if (angle < 0 || angle > 360 || accuracy < 0 || accuracy > 45) {
            throw new JSException("Angle should be in range [0, 360]; Accuracy in [0, 45], but Angle=%s; Accuracy=%s",
                    angle, accuracy);
        }
        return d -> d.angle() > max(angle - accuracy, 0) && d.angle() < min(angle + accuracy, 360);
    }
    public static JFunc1<Direction, Boolean> ANGLE(int angle) {
        return DIRECTION(angle, 5);
    }
}
