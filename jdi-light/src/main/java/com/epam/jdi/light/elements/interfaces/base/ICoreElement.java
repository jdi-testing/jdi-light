package com.epam.jdi.light.elements.interfaces.base;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.MarkupLocator;
import com.epam.jdi.tools.map.MapArray;
import org.openqa.selenium.*;

import java.util.List;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public interface ICoreElement extends IBaseElement {
    UIElement core();
    default UIElement iCore() { return core(); }

    @JDIAction("Hover to '{name}'")
    default void hover() { iCore().hover(); }
    @JDIAction(value = "Check that '{name}' is enabled", timeout = 0)
    default boolean isEnabled() { return iCore().isEnabled(); }
    @JDIAction(value = "Check that '{name}' is disabled", timeout = 0)
    default boolean isDisabled() { return !isEnabled(); }
    @JDIAction(value = "Check that '{name}' is displayed", timeout = 0)
    default boolean isDisplayed() { return iCore().isDisplayed(); }
    @JDIAction(value = "Check that '{name}' is visible for user", timeout = 0)
    default boolean isVisible() { return iCore().isVisible(); }
    @JDIAction(value = "Check that '{name}' is not visible by user", timeout = 0)
    default boolean isNotVisible() { return iCore().isNotVisible(); }
    @JDIAction(value = "Check that '{name}' is hidden", timeout = 0)
    default boolean isHidden() { return !isDisplayed(); }
    @JDIAction(value = "Check that '{name}' is exist on the page", timeout = 0)
    default boolean isExist() { return iCore().isExist(); }
    @JDIAction(value = "Check that '{name}' is missed on the page", timeout = 0)
    default boolean isNotExist() { return iCore().isNotExist(); }
    default void highlight(String color) { iCore().highlight(); }
    default void highlight() { iCore().highlight(); }
    default Point getLocation() { return iCore().getLocation(); }
    default Dimension getSize() { return iCore().getSize(); }
    default void show() { iCore().show(); }
    default void setAttribute(String name, String value) { iCore().setAttribute(name, value); }
    default String attr(String name) { return iCore().attr(name); }
    default MapArray<String, String> attrs() { return iCore().attrs(); }
    default String css(String prop) { return iCore().css(prop); }
    default boolean hasClass(String className) { return iCore().hasClass(className); }
    default boolean hasAttribute(String attrName) { return iCore().hasAttribute(attrName); }
    default String printHtml() { return iCore().printHtml(); }
    default List<String> classes() {return iCore().classes(); }
    default UIElement find(@MarkupLocator String by) {
        return iCore().find(by);
    }
    default UIElement find(@MarkupLocator By by) {
        return iCore().find(by);
    }
    default WebList finds(@MarkupLocator String by) {
        return iCore().finds(by);
    }
    default WebList finds(@MarkupLocator By by) { return iCore().finds(by); }
    default UIElement firstChild() { return iCore().firstChild(); }
    default WebList children() { return iCore().children(); }
    default String getTagName() {
        return iCore().getTagName();
    }
    default void visualValidation(String tag) {
        iCore().visualValidation(tag);
    }
    default void visualValidation(UIElement element) {
        iCore().visualValidation(element);
    }
    default void dragAndDropTo(WebElement element) {
        iCore().dragAndDropTo(element);
    }
    default void dragAndDropTo(int x, int y) {
        iCore().dragAndDropTo(x, y);
    }
    default void rightClick() {
        iCore().rightClick();
    }
    default void doubleClick() {
        iCore().doubleClick();
    }

}
