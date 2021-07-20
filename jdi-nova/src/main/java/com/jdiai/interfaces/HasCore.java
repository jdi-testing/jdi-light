package com.jdiai.interfaces;

import com.jdiai.JS;
import com.jdiai.asserts.ShouldValidations;
import com.jdiai.jswraper.JSEngine;
import com.jdiai.visual.Direction;
import com.jdiai.visual.ImageTypes;
import com.jdiai.visual.StreamToImageVideo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.jdiai.tools.VisualSettings.DEFAULT_IMAGE_TYPE;

public interface HasCore extends HasName, HasLocators, ShouldValidations<HasCore> {
    JS core();

    JS setCore(JS core);

    default JS list() {
        JS core = core();
        core.engine().multiSearch();
        return core;
    }

    default List<By> locators() { return core().locators(); }

    default WebElement we() {
        return core().we();
    }

    default String printHtml() {
        return core().printHtml();
    }

    default JS show() {
        return core().show();
    }

    default boolean isEnabled() {
        return core().isEnabled();
    }

    default boolean isDisabled() {
        return !isEnabled();
    }

    default boolean isDisplayed() {
        return core().isDisplayed();
    }

    default boolean isHidden() {
        return !isDisplayed();
    }

    default boolean isVisible() {
        return core().isVisible();
    }

    default boolean isNotVisible() {
        return !isVisible();
    }

    default boolean isInView() {
        return core().isInView();
    }

    default boolean isOutOfView() {
        return !isInView();
    }

    default boolean isExist() {
        return core().isExist();
    }

    default boolean isClickable() {
        return core().isClickable();
    }

    default boolean isNotExist() {
        return !isExist();
    }

    default StreamToImageVideo makeScreenshot(ImageTypes imageType) {
        return core().makeScreenshot(imageType);
    }

    default StreamToImageVideo makeScreenshot() {
        return makeScreenshot(DEFAULT_IMAGE_TYPE);
    }

    default boolean hasAttribute(String attrName) {
        return core().hasAttribute(attrName);
    }

    default String attr(String attrName) {
        return core().attr(attrName);
    }

    default String getText() {
        return core().getText();
    }

    default boolean hasClass(String className) {
        return core().hasClass(className);
    }

    default Direction getDirectionTo(WebElement element) {
        return core().getDirectionTo(element);
    }
    default void highlight() {
        core().highlight();
    }

    default String getName() {
        return core().getName();
    }

    default HasCore setName(String name) {
        core().setName(name);
        try {
            return this;
        } catch (Exception ignore) {
            return null;
        }
    }

    default JSEngine engine() {
        return core().engine();
    }
}
