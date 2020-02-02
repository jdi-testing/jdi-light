package com.epam.jdi.light.elements.common;

import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import org.openqa.selenium.Rectangle;

import java.awt.event.InputEvent;

import static com.epam.jdi.light.elements.common.Keyboard.getRobot;
import static com.epam.jdi.tools.Timer.sleep;

public class Mouse {
    public static void mouseClick(int x, int y) {
        int button1Down = InputEvent.BUTTON1_DOWN_MASK;
        getRobot().mouseMove(x, y);
        getRobot().mousePress(button1Down);
        getRobot().mouseRelease(button1Down);
    }
    public static void mouseClick(ICoreElement element) {
        Rectangle rect = element.core().getRect();
        mouseClick(rect.x + rect.width/2, rect.y + rect.height / 2);
    }
    public static void mouseRightClick(int x, int y) {
        int button1Down = InputEvent.BUTTON2_DOWN_MASK;
        getRobot().mouseMove(x, y);
        getRobot().mousePress(button1Down);
        getRobot().mouseRelease(button1Down);
    }
    public static void mouseClickRight(ICoreElement element) {
        Rectangle rect = element.core().getRect();
        mouseRightClick(rect.x + rect.width/2, rect.y + rect.height / 2);
    }
    public static void mouseWheel(int wheelAmt) {
        mouseWheel(wheelAmt, 50);
    }
    public static void mouseWheel(int wheelAmt, int speed) {
        int count = Math.abs(wheelAmt);
        int step = wheelAmt > 0 ? 1 : -1;
        for (int i = 1; i <= count; i++) {
            getRobot().mouseWheel(step);
            sleep(speed);
        }
    }
}
