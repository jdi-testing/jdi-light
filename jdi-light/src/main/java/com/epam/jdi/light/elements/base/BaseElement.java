package com.epam.jdi.light.elements.base;

import com.epam.jdi.light.elements.interfaces.HasValue;
import com.epam.jdi.tools.func.JFunc1;
import com.epam.jdi.tools.map.MapArray;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public interface BaseElement extends JDIElement, HasValue {
    void hover();
    boolean isEnabled();
    boolean isDisabled();
    boolean isDisplayed();
    boolean isHidden();
    Point getLocation();
    Dimension getSize();
    Rectangle getRect();
    <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException;
    String getAttribute(String value);
    String attr(String value);
    MapArray<String, String> getAllAttributes();
    MapArray<String, String> attrs();
    void setAttribute(String name, String value);
    void highlight(String color);
    void highlight();
    String printHtml();
    void show();
    Select select();
    void doActions(JFunc1<Actions, Actions> actions);
    void actions(JFunc1<Actions, Actions> actions);
    boolean wait(JFunc1<BaseElement, Boolean> condition);
    List<String> classes();
    boolean hasClass(String className);
}
