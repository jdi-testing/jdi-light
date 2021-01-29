package com.epam.jdi.light.mobile.elements.base;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.MarkupLocator;

import com.epam.jdi.light.mobile.elements.common.app.android.Label;
import com.epam.jdi.light.mobile.elements.complex.MobileWebList;
import com.epam.jdi.light.mobile.interfaces.HasTouchActions;
import com.epam.jdi.tools.func.JAction1;
import com.epam.jdi.tools.func.JFunc;
import com.epam.jdi.tools.map.MapArray;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;

import java.time.Duration;
import java.util.List;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static com.epam.jdi.light.mobile.elements.init.MobileUIFactory.$;
import static com.epam.jdi.light.mobile.elements.init.MobileUIFactory.$$;
import static com.epam.jdi.light.logger.LogLevels.DEBUG;
import static com.epam.jdi.light.mobile.CoordinateConversionHelper.getCoordinatesOnScreen;

public class MobileUIElement extends UIElement implements HasTouchActions {

    //region Constructors
    public MobileUIElement() { }
    public MobileUIElement(WebElement el) { setWebElement(el); }
    public MobileUIElement(List<WebElement> els) { setWebElements(els); }
    public MobileUIElement(@MarkupLocator By locator) { setLocator(locator); }
    public MobileUIElement(JDIBase base) {
        super(base);
    }
    public MobileUIElement(JDIBase base, String locator, String name, Object parent) {
        super(base);
        setLocator(locator);
        setName(name);
        setParent(parent);
    }
    public MobileUIElement(JDIBase base, By locator, String name) {
        super(base);
        setLocator(locator);
        setName(name);
    }
    public MobileUIElement(JDIBase base, WebElement el, JFunc<WebElement> func) {
        super(base);
        setWebElement(el);
        setGetFunc(func);
    }
    //endregion

    //region Core
    public MobileUIElement core() { return this; }
    public MobileUIElement setup(JAction1<JDIBase> setup) {
        return setup(MobileUIElement.class, setup);
    }
    @Override
    public MobileUIElement setCore(JDIBase base) {
        super.setCore(base);
        return this;
    }
    @Override
    public MobileUIElement setName(String name) {
        super.setName(name);
        return this;
    }
    @Override
    public MobileUIElement waitSec(int timeout) {
        super.waitSec(timeout);
        return this;
    }
    @Override
    public MobileUIElement noWait() {
        super.noWait();
        return this;
    }

    @Override
    public MobileUIElement find(@MarkupLocator String by) {
        return $(by, this);
    }

    @Override
    public UIElement findFirst(@MarkupLocator String by) {
        UIElement element = $(by, this);
        element.strictSearch(false);
        return element;
    }

    @Override
    public MobileUIElement find(@MarkupLocator By by) {
        return $(by, this);
    }

    @Override
    public MobileWebList finds(@MarkupLocator String by) {
        return $$(by, this);
    }

    @Override
    public MobileWebList finds(@MarkupLocator By by) {
        return $$(by, this);
    }

    @Override
    public MobileUIElement firstChild() { return this.find("*"); }

    @Override
    public MobileWebList children() { return finds("*"); }

    @JDIAction("Perform tap on '{name}'")
    public void tap() {
        new TouchAction<>((PerformsTouchActions) getDriver())
                .tap(TapOptions.tapOptions().withPosition(PointOption.point(getCenterOnScreen())))
                .perform();
    }
    @JDIAction("Perform double tap on '{name}'")
    public void doubleTap() {
        new TouchAction<>((PerformsTouchActions) getDriver())
                .tap(TapOptions.tapOptions()
                        .withTapsCount(2)
                        .withPosition(PointOption.point(getCenterOnScreen())))
                .perform();
    }
    @JDIAction("Perform long press on '{name}'")
    public void longPress() {
        new TouchAction<>((PerformsTouchActions) getDriver())
                .longPress(LongPressOptions.longPressOptions().withPosition(PointOption.point(getCenterOnScreen())))
                .perform();
    }
    @JDIAction("Perform long press on '{name}' with duration of {0} seconds")
    public void longPress(int seconds) {
        new TouchAction<>((PerformsTouchActions) getDriver())
                .longPress(LongPressOptions.longPressOptions()
                        .withPosition(PointOption.point(getCenterOnScreen()))
                        .withDuration(Duration.ofSeconds(seconds)))
                .perform();
    }
    @Override
    @JDIAction("Drag '{name}' and drop it to coordinates: (x:{0}, y:{1})")
    public void dragAndDropTo(int xOffset, int yOffset) {
        Point location = getCenterOnScreen();
//        show();
        new TouchAction<>((PerformsTouchActions) getDriver())
                .press(PointOption.point(location))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(location.moveBy(xOffset, yOffset)))
                .release().perform();
    }

    /*This is needed for W3C compatibility*/
    @Override
    public Point getLocation() {
        Rectangle rect = getRect();
        return new Point(rect.x, rect.y);
    }
    public Point getCenter() {
        Rectangle rect = getRect();
        return new Point(rect.x, rect.y).moveBy(rect.width / 2, rect.height / 2);
    }

    public Point getLocationInViewport() {
        Rectangle rect = getPosition();
        return new Point(rect.x, rect.y);
    }
    public Point getCenterInViewport() {
        Rectangle rect = getPosition();
        return new Point(rect.x, rect.y).moveBy(rect.width / 2, rect.height / 2);
    }
    public Point getLocationOnScreen() {
        return getCoordinatesOnScreen(getLocationInViewport());
    }
    public Point getCenterOnScreen() {
        return getCoordinatesOnScreen(getCenterInViewport());
    }

    public Label mobileLabel() {
        return new Label().setup(Label.class, j->j
                .setLocator(By.cssSelector("[for="+ core().attr("id")+"]"))
                .setName(getName() + " label"));
    }
    //region Aliases
    /** getAllAttributes alias */
    public MapArray<String, String> attrs() { return getAllAttributes(); }
    /** getAttribute alias */
    public String attr(String value) { return getAttribute(value); }
    /** getText alias */ @Override
    public String text() { return text(textType); }
    /** getCssValue alias */
    public String css(String prop) {
        return getCssValue(prop);
    }
    //endregion

    //region SetValue
    public void setValue(String value) {
        input(value);
    }
    public String getValue() {
        return getText();
    }
    //endregion
    /**
     * Get all element's attributes
     */
    @JDIAction(level = DEBUG)
    public MapArray<String, String> getAllAttributes() {
        List<String> jsList;
        try {
            jsList = (List<String>) js().executeScript("var s = []; var attrs = arguments[0].attributes; for (var l = 0; l < attrs.length; ++l) { var a = attrs[l]; s.push(a.name + '=\"' + a.value + '\"'); } ; return s;", getWebElement());
            return new MapArray<>(jsList, r -> r.split("=")[0], r -> r.split("=")[1].replace("\"", ""));
        } catch (Exception ignore) { return new MapArray<>(); }
    }
    @Override
    protected boolean enabled() {
        if (hasClass("active") || hasAttribute("enabled"))
            return true;
        if (hasClass("disabled"))
            return false;
        return getWebElement().isEnabled();
    }
}
