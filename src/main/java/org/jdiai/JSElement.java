package org.jdiai;

import org.openqa.selenium.*;

import java.util.List;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class JSElement implements WebElement {
    private final JSDriver js;
    private final WebDriver driver;
    private final By locator;
    public JSElement(WebDriver driver, By locator) {
        this.js = new JSDriver(driver, locator);
        this.driver = driver;
        this.locator = locator;
    }
    private void jsAction(String action) {
        js.getOne(action);
    }
    private String jsResult(String action) {
        return js.getOne(action);
    }
    private WebElement we() {
        return driver.findElement(locator);
    }

    public void click() {
        jsAction("click()");
    }

    public void submit() {
        jsAction("submit");
    }

    public void sendKeys(CharSequence... value) {
        // jsGet("val('" + value + "')");
        // jsGet("setAttribute('value', '"+value+"')");
        jsAction("value='"+value+"'");
    }

    public void clear() {
        jsAction("clear");
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

    public String getTextC() {
        return jsResult("textContent");
    }
    public String getTextI() {
        return jsResult("innerText");
    }
    public String getTextH() { return jsResult("innerHTML "); }
    public String getText() {
        return getTextC();
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
