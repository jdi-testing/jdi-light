package com.epam.jdi.light.elements.common;

import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;

import static com.epam.jdi.light.elements.common.Keyboard.getRobot;
import static com.epam.jdi.light.elements.composite.WebPage.zoomLevel;
import static com.epam.jdi.tools.Timer.sleep;
import static java.awt.event.InputEvent.BUTTON1_DOWN_MASK;
import static java.awt.event.InputEvent.BUTTON2_DOWN_MASK;

public class Mouse {
    public static int startX = 100;
    public static int startY = 250;
    public static void mouseClick(int x, int y) {
        mouseClick(x, y, BUTTON1_DOWN_MASK);
    }
    public static void mouseClick(WebElement element) {
        Rectangle rect = element.getRect();
        mouseClick(rect.x + rect.width/2, rect.y + rect.height / 2);
    }
    public static void mouseClick(ICoreElement element) {
        Rectangle rect = element.core().getRect();
        mouseClick(rect.x + rect.width/2, rect.y + rect.height / 2);
    }
    public static void mouseRightClick(int x, int y) {
        mouseClick(x, y, BUTTON2_DOWN_MASK);
    }
    public static void mouseClickRight(WebElement element) {
        Rectangle rect = element.getRect();
        mouseRightClick(rect.x + rect.width/2, rect.y + rect.height / 2);
    }
    public static void mouseClickRight(ICoreElement element) {
        Rectangle rect = element.core().getRect();
        mouseRightClick(rect.x + rect.width/2, rect.y + rect.height / 2);
    }
    private static int zoomFactor(int coordinate) {
        return (int)(Math.round(coordinate)* zoomLevel());
    }
    private static void mouseClick(int x, int y, int inputEvent) {
        getRobot().mouseMove(startX + zoomFactor(x), startY + zoomFactor(y));
        getRobot().mousePress(inputEvent);
        getRobot().mouseRelease(inputEvent);
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
