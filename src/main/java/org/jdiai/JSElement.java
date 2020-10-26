package org.jdiai;

import org.openqa.selenium.*;

import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class JSElement implements WebElement {
    private final JSDriver js;
    private final WebDriver driver;
    private final List<By> locators;

    public JSElement(WebDriver driver, By locator) {
        this(driver, locator, null);
    }
    public JSElement(WebDriver driver, By locator, HasLocators parent) {
        if (parent != null) {
            List<By> pLocators = parent.locators();
            this.locators = pLocators != null && pLocators.size() > 0
                ? pLocators : new ArrayList<>();
        } else {
            this.locators = new ArrayList<>();
        }
        this.locators.add(locator);
        this.js = new JSDriver(driver, locators);
        this.driver = driver;
    }
    private String jsResult(String action) {
        return js.getOne(action);
    }
    private WebElement we() {
        SearchContext ctx = driver;
        for (By locator : locators) {
            ctx = ctx.findElement(locator);
        }
        return (WebElement) ctx;
    }

    public void click() {
        jsResult("click()");
    }

    public void submit() {
        jsResult("submit");
    }

    public void sendKeys(CharSequence... value) {
        // jsGet("val('" + value + "')");
        // jsGet("setAttribute('value', '"+value+"')");
        jsResult("value='"+value+"'");
    }

    public void clear() {
        jsResult("clear");
    }

    public String getTagName() {
        return jsResult("tagName");
    }

    public String getAttribute(String name) {
        return jsResult("getAttribute(" + name + ")");
    }

    public boolean isSelected() {
        return isNotBlank(getAttribute("selected"));
    }

    public boolean isEnabled() {
        return isNotBlank(getAttribute("enabled"));
    }
    public JSElement getAsInnerText() { getTextType = "innerText"; return this; }
    public JSElement getAsTextContent() { getTextType = "textContent"; return this; }
    public JSElement getAsInnerHTML() { getTextType = "innerHTML"; return this; }

    String getTextType = "innerText";
    public String getText() {
        return jsResult(getTextType);
    }

    public List<WebElement> findElements(By by) {
        return we().findElements(by);
    }

    public WebElement findElement(By by) {
        return we().findElement(by);
    }

    public boolean isDisplayed() {
        return we().isDisplayed();
    }

    public Point getLocation() {
        return we().getLocation();
    }

    public Dimension getSize() {
        return we().getSize();
    }

    public Rectangle getRect() {
        return we().getRect();
    }

    public String getCssValue(String s) {
        return we().getCssValue(s);
    }

    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return we().getScreenshotAs(outputType);
    }
}
