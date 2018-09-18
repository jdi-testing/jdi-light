package com.epam.jdi.light.elements.base;

import com.epam.jdi.light.elements.interfaces.IHasValue;
import com.epam.jdi.tools.func.JFunc1;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public interface BaseElement extends IHasValue {
    void hover();
    boolean isEnabled();
    boolean isDisplayed();
    Point getLocation();
    Dimension getSize();
    Rectangle getRect();
    <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException;
    String getAttribute(String name);
    UIElement setAttribute(String name, String value);
    UIElement higlight(String color);
    UIElement higlight();
    UIElement show();
    Select select();
    UIElement dragAndDropTo(WebElement to);
    UIElement dragAndDropTo(int x, int y);
    UIElement doActions(JFunc1<Actions, Actions> actions);
    IsAssert is();
    IsAssert assertThat();

}
