package com.epam.jdi.light.elements.base;

import com.epam.jdi.light.elements.asserts.IsAssert;
import com.epam.jdi.light.elements.interfaces.HasValue;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public interface BaseElement extends HasValue {
    void hover();
    boolean isEnabled();
    boolean isDisplayed();
    Point getLocation();
    Dimension getSize();
    Rectangle getRect();
    <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException;
    String getAttribute(String name);
    void setAttribute(String name, String value);
    void higlight(String color);
    void higlight();
    void show();
    Select select();

    IsAssert is();
    IsAssert assertThat();

    default UIElement base() {return (UIElement) this; }
}
