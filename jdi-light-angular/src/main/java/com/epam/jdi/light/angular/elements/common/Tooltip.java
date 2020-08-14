package com.epam.jdi.light.angular.elements.common;

import com.epam.jdi.light.angular.asserts.TooltipAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;


public class Tooltip extends UIBaseElement<TooltipAssert> implements IsText {

    public enum Position {
        ABOVE,
        BELOW,
        LEFT,
        RIGHT
    }

    @JDIAction("Get '{name}' text")
    public String text() {
        return this.getText();
    }

    @JDIAction("Get '{name}' color")
    public String color() {
        return this.css("background-color");
    }

    @JDIAction("Get '{name}' position")
    public Position position(final UIBaseElement<?> element) {
        Rectangle r1 = element.core().getRect();
        Rectangle r2 = this.core().getRect();

        Point p1 = new Point(
                (r1.getX() + r1.width) / 2,
                (r1.getY() + r1.height) / 2
        );
        Point p2 = new Point(
                (r2.getX() + r2.width) / 2,
                (r2.getY() + r2.height) / 2
        );

        int absX = Math.abs(p1.getX() - p2.getX());
        int absY = Math.abs(p1.getY() - p2.getY());

        Position result;

        if (absX > absY)
            if (p1.getX() < p2.getX())
                result = Position.RIGHT;
            else
                result = Position.LEFT;
        else if (p1.getY() < p2.getY())
            result = Position.BELOW;
        else
            result = Position.ABOVE;

        return result;
    }

    @Override
    public TooltipAssert is() {
        return new TooltipAssert().set(this);
    }
}
