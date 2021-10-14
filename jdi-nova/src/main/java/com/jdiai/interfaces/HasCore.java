package com.jdiai.interfaces;

import com.jdiai.JS;
import com.jdiai.asserts.ShouldValidations;
import com.jdiai.jsbuilder.IJSBuilder;
import com.jdiai.jsdriver.JSDriver;
import com.jdiai.jswraper.JSEngine;
import com.jdiai.visual.Direction;
import com.jdiai.visual.ImageTypes;
import com.jdiai.visual.StreamToImageVideo;
import org.openqa.selenium.*;

import java.util.List;

import static com.jdiai.tools.VisualSettings.DEFAULT_IMAGE_TYPE;
import static com.jdiai.visual.Directions.*;

public interface HasCore extends WebElement, HasName, HasLocators, ShouldValidations<HasCore> {
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

    default JS showIfNotInView() {
        return core().showIfNotInView();
    }

    default JS show() {
        return core().show();
    }

    default boolean isEnabled() {
        return !isDisabled();
    }

    default boolean isDisabled() {
        return core().isDisabled();
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

    default boolean isNotCovered() {
        return core().isNotCovered();
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

    default boolean isAbove(WebElement element) {
        return HIGHER.apply(core().getDirectionTo(element));
    }

    default boolean isBelow(WebElement element) {
        return LOWER.apply(core().getDirectionTo(element));
    }

    default boolean isOnLeftOf(WebElement element) {
        return LEFT.apply(core().getDirectionTo(element));
    }

    default boolean isOnRightOf(WebElement element) {
        return RIGHT.apply(core().getDirectionTo(element));
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

    default IJSBuilder builder() {
        return jsDriver().builder();
    }

    default JSDriver jsDriver() {
        return engine().jsDriver();
    }

    // To be Compliant with WebElement
    default void click() { core().click(); }
    default void submit() { core().submit(); }
    default void sendKeys(CharSequence... charSequences) { core().sendKeys(charSequences); }
    default void clear() { core().clear(); }
    default String getTagName() { return core().getTagName(); }
    default String getAttribute(String s) { return core().getAttribute(s); }
    default boolean isSelected() { return core().isSelected(); }
    default List<WebElement> findElements(By by) {
        return core().findElements(by);
    }
    default WebElement findElement(By by) {
        return core().findElement(by);
    }
    default Point getLocation() {
        return core().getLocation();
    }
    default Dimension getSize() {
        return core().getSize();
    }
    default Rectangle getRect() {
        return core().getRect();
    }
    default String getCssValue(String s) {
        return core().getCssValue(s);
    }
    default <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return core().getScreenshotAs(outputType);
    }
}
