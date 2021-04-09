package org.jdiai.visual;

import com.epam.jdi.tools.func.JFunc1;
import org.jdiai.jsdriver.JSException;

import static com.google.common.collect.Range.closed;
import static java.lang.Math.max;
import static java.lang.Math.min;

public class Directions {
    public static int MAIN_ACCURACY = 90;
    public static int SECOND_ACCURACY = 45;
    public static int LINE_ACCURACY = 5;
    public static int ANGLE_ACCURACY = 5;

    public static JFunc1<Direction, Boolean> HIGHER = DIRECTION(90, MAIN_ACCURACY);
    public static JFunc1<Direction, Boolean> LOWER = DIRECTION(270, MAIN_ACCURACY);
    public static JFunc1<Direction, Boolean> LEFT = DIRECTION(180, MAIN_ACCURACY);
    public static JFunc1<Direction, Boolean> RIGHT = DIRECTION(0, MAIN_ACCURACY);

    public static JFunc1<Direction, Boolean> TOP_RIGHT = DIRECTION(45, SECOND_ACCURACY);
    public static JFunc1<Direction, Boolean> TOP_LEFT = DIRECTION(135, SECOND_ACCURACY);
    public static JFunc1<Direction, Boolean> BOTTOM_LEFT = DIRECTION(225, SECOND_ACCURACY);
    public static JFunc1<Direction, Boolean> BOTTOM_RIGHT = DIRECTION(315, SECOND_ACCURACY);

    public static JFunc1<Direction, Boolean> SAME_HORIZONTAL =
        d -> closed(180 - LINE_ACCURACY, 180 + LINE_ACCURACY).contains(d.angle())
            || closed(0, LINE_ACCURACY).contains(d.angle())
            || closed(360 - LINE_ACCURACY, 360).contains(d.angle());
    public static JFunc1<Direction, Boolean> SAME_VERTICAL =
        d -> closed(90 - LINE_ACCURACY, 90 + LINE_ACCURACY).contains(d.angle())
            || closed(270 - LINE_ACCURACY, 270 + LINE_ACCURACY).contains(d.angle());

    public static JFunc1<Direction, Boolean> DIRECTION(int angle, int accuracy) {
        if (angle < 0 || angle > 360 || accuracy < 0 || accuracy > 180) {
            throw new JSException("Angle should be in range [0, 360]; Accuracy in [0, 180], but Angle=%s; Accuracy=%s",
                    angle, accuracy);
        }
        return d -> d.angle() >= max(normalizeAngle(angle - accuracy), 0)
            && d.angle() <= min(normalizeAngle(angle + accuracy), 360);
    }
    private static int normalizeAngle(int angle) {
        if (angle >= 0 && angle <= 360) {
            return angle;
        }
        if (angle < 0 && angle > -360) {
            return 360 - angle;
        }
        if (angle > 360 && angle < 720) {
            return angle - 360;
        }
        throw new JSException("Angle should be in [-360, 720] range, but " + angle);
    }
    public static JFunc1<Direction, Boolean> ANGLE(int angle) {
        return DIRECTION(angle, ANGLE_ACCURACY);
    }
}
