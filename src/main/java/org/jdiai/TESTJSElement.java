package org.jdiai;

import org.openqa.selenium.*;

import java.util.List;

import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.jdiai.WebDriverByUtils.getByLocator;
import static org.jdiai.WebDriverByUtils.getByType;

public class TESTJSElement implements WebElement {
    private final WebDriver driver;
    private final By locator;
    public TESTJSElement(WebDriver driver, By locator) {
        this.driver = driver;
        this.locator = locator;
    }

    protected WebElement we() {
        return driver.findElement(locator);
    }
    protected Object jsExecute(String text) { return ((JavascriptExecutor) driver).executeScript(text); }
    protected String js(String text) {
        return getByType(locator).equals("css") ? css(text) : xpath(text);
    }
    protected String xpath(String text) {
        return (String) jsExecute("return document.evaluate('" + getByLocator(locator) + "', document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue." + text);
    }
    protected String css(String text) {
        return (String) jsExecute("return document.querySelector('" + getByLocator(locator) + "')." + text);
    }
    public void click() {
        js("click()");
    }

    public void submit() {
        js("submit");
    }

    public void sendKeys(CharSequence... value) {
        // jsGet("val('" + value + "')");
        // jsGet("setAttribute('value', '"+value+"')");
        js("value='"+value+"'");
    }

    public void clear() {
        js("clear");
    }

    public String getTagName() {
        return js("tagName");
    }

    public String getAttribute(String name) {
        return js("getAttribute(" + name + ")");
    }

    public boolean isSelected() {
        return isNotBlank(getAttribute("selected"));
    }

    public boolean isEnabled() {
        return isNotBlank(getAttribute("enabled"));
    }

    public String getText() {
        return js("textContent");
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
