package com.epam.jdi.light.mobile.elements.base;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.common.JDebug;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.base.JdiSettings;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.MarkupLocator;
import com.epam.jdi.tools.func.JAction1;
import com.epam.jdi.tools.func.JFunc;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static com.epam.jdi.light.elements.base.JdiSettings.DEFAULT_CONTEXT;
import static com.epam.jdi.light.elements.base.JdiSettings.getAllElementsInContext;
import static com.epam.jdi.light.settings.JDISettings.ELEMENT;
import static com.epam.jdi.tools.LinqUtils.map;
import static java.util.Collections.singletonList;

public class MobileAppUIElement extends MobileUIElement {

    //region Constructors
    public MobileAppUIElement() { }
    public MobileAppUIElement(WebElement el) { setWebElement(el); }
    public MobileAppUIElement(List<WebElement> els) { setWebElements(els); }
    public MobileAppUIElement(@MarkupLocator By locator) { setLocator(locator); }
    public MobileAppUIElement(JDIBase base) {
        super(base);
    }
    public MobileAppUIElement(JDIBase base, String locator, String name, Object parent) {
        super(base);
        setLocator(locator);
        setName(name);
        setParent(parent);
    }
    public MobileAppUIElement(JDIBase base, By locator, String name) {
        super(base);
        setLocator(locator);
        setName(name);
    }
    public MobileAppUIElement(JDIBase base, WebElement el, JFunc<WebElement> func) {
        super(base);
        setWebElement(el);
        setGetFunc(func);
    }
    //endregion

    //region Core
    public MobileAppUIElement core() { return this; }
    public MobileAppUIElement setup(JAction1<JDIBase> setup) {
        return setup(MobileAppUIElement.class, setup);
    }
    @Override
    public MobileAppUIElement setCore(JDIBase base) {
        super.setCore(base);
        return this;
    }
    @Override
    public MobileAppUIElement setName(String name) {
        super.setName(name);
        return this;
    }
    @Override
    public MobileAppUIElement waitSec(int timeout) {
        super.waitSec(timeout);
        return this;
    }
    @Override
    public MobileAppUIElement noWait() {
        super.noWait();
        return this;
    }

    @Override
    @JDIAction("Perform tap on '{name}'")
    public void tap() {
        new TouchAction<>((PerformsTouchActions) getDriver())
                .tap(TapOptions.tapOptions()
                        .withElement(ElementOption.element(getWebElement())))
                .perform();
    }

    @Override
    @JDIAction("Perform double tap on '{name}'")
    public void doubleTap() {
        new TouchAction<>((PerformsTouchActions) getDriver())
                .tap(TapOptions.tapOptions()
                        .withTapsCount(2)
                        .withElement(ElementOption.element(getWebElement())))
                .perform();
    }

    @Override
    @JDIAction("Perform long press on '{name}'")
    public void longPress() {
        new TouchAction<>((PerformsTouchActions) getDriver())
                .longPress(LongPressOptions.longPressOptions()
                        .withElement(ElementOption.element(getWebElement())))
                .release()
                .perform();
    }

    @Override
    @JDIAction("Perform long press on '{name}' with duration of {0} seconds")
    public void longPress(int seconds) {
        new TouchAction<>((PerformsTouchActions) getDriver())
                .longPress(LongPressOptions.longPressOptions()
                        .withElement(ElementOption.element(getWebElement()))
                        .withDuration(Duration.ofSeconds(seconds)))
                .release()
                .perform();
    }

    @Override
    @JDIAction("Drag '{name}' and drop it to coordinates: (x:{0}, y:{1})")
    public void dragAndDropTo(int xOffset, int yOffset) {
        Point location = getCenter();
        new TouchAction<>((PerformsTouchActions) getDriver())
                .press(PointOption.point(location))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(location.moveBy(xOffset, yOffset)))
                .release().perform();
    }

    @Override
    protected boolean enabled() {
        if (hasAttribute("enabled"))
            return true;
        if (hasAttribute("disabled"))
            return false;
        return getWebElement().isEnabled();
    }

    @Override
    public boolean isVisible() {
        return getWebElement().isDisplayed();
    }

    @JDebug
    @Override
    public List<WebElement> getWebElements(Object... args) {
        List<WebElement> elements = getAllWebElements(args);
        if (elements.size() > 0) {
            beforeSearch(elements.get(0));
        }
        return elements;
    }

    @JDebug
    private List<WebElement> getAllWebElements(Object... args) {
        DEFAULT_CONTEXT.execute(driver());
        if (webElements.hasValue()) {
            List<WebElement> elements = map(webElements.get(), JdiSettings::purify);
            if (elements.size() > 0) {
                try {
                    elements.get(0).getTagName();
                    return elements;
                } catch (Exception ignore) {
                    webElements.clear();
                }
            }
        }
        if (locator.isNull())
            return singletonList(getSmart());
        return getAllElementsInContext(this, args);
    }

    WebElement beforeSearch(WebElement el) {
        (beforeSearch == null ? ELEMENT.beforeSearch : beforeSearch).execute(new UIElement(el));
        return el;
    }
}
