package com.epam.jdi.light.elements.base;

import com.epam.jdi.light.elements.interfaces.HasValue;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public interface BaseElement extends HasValue {
    void hover();
    boolean isEnabled();
    boolean isDisplayed();
    boolean isDisabled();
    boolean isHidden();
    Point getLocation();
    Dimension getSize();
    Rectangle getRect();
    <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException;
    String getAttribute(String name);
    List<String> getAllAttributes();
    void setAttribute(String name, String value);
    void higlight(String color);
    void higlight();
    String printHtml();
    void show();
    Select select();

    default UIElement base() {return (UIElement) this; }
}
