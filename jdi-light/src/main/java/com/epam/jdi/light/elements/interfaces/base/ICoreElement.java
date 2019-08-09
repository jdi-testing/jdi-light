package com.epam.jdi.light.elements.interfaces.base;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.tools.map.MapArray;
import org.openqa.selenium.By;

import java.util.List;

public interface ICoreElement extends IBaseElement {
    UIElement core();

    default void hover() { core().hover(); }
    default boolean isEnabled() { return core().isEnabled(); }
    default boolean isDisabled() { return !isEnabled(); }
    default boolean isDisplayed() { return core().isDisplayed(); }
    default boolean isHidden() { return !isDisplayed(); }
    default void highlight(String color) { core().highlight(); }
    default void highlight() { core().highlight(); }
    default void show() { core().show(); }
    default String attr(String name) { return core().attr(name); }
    default MapArray<String, String> attrs() { return core().attrs(); }
    default String css(String prop) {
        return core().css(prop);
    }
    default boolean hasClass(String className) { return core().hasClass(className); }
    default boolean hasAttribute(String attrName) { return core().hasAttribute(attrName); }
    default String printHtml() { return core().printHtml(); }
    default List<String> classes() {return core().classes(); }
    default UIElement find(String by) {
        return core().find(by);
    }
    default UIElement find(By by) {
        return core().find(by);
    }
    default WebList finds(String by) {
        return core().finds(by);
    }
    default WebList finds(By by) { return core().finds(by); }
    default UIElement firstChild() { return core().firstChild(); }
    default WebList childs() { return core().childs(); }

}
