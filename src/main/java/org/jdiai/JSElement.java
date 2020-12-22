package org.jdiai;

import org.jdiai.interfaces.HasLocators;
import org.jdiai.jselement.JSSmart;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.jdiai.jselement.JSTalk.DRIVER;

public class JSElement implements WebElement {
    public final JSSmart js;
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
        this.js = new JSSmart(driver, locators).multiSearch();
        this.driver = driver;
    }
    protected String jsResult(String action) {
        return js.getAttribute(action);
    }
    protected WebElement we() {
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
        // jsResult("value='"+value+"'");
        String text = value.length == 1 ? value[0].toString() : "";
        js.jsDriver().builder().oneToOne("document", locators.get(0))
            .addJSCode("element.value='" + text + "';\n").trigger("change");
    }

    public void slide(String value) {
        //Actions a = new Actions(DRIVER.get());
        //a.dragAndDropBy(DRIVER.get().findElement(By.xpath("[aria-labelledby='range-slider'][data-index='0']")),20, 0)
        //        .build().perform();
        //js.jsDriver().builder().oneToOne("document", locators.get(0))
        //        .addJSCode("element.value='" + value + "';\n")
        //        .trigger("mousedown")
        //        .trigger("mousemove", "which: 1, pageX: 460");
        //.trigger("mousedown")
        //        .trigger("mousemove", { which: 1, pageX: 460 })
    }
    public void clear() {
        jsResult("clear");
    }

    public String getTagName() {
        return jsResult("tagName");
    }

    public String getAttribute(String name) {
        return jsResult("getAttribute('" + name + "')");
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

    String getTextType = "textContent";
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
        return js.getJson("{ 'displayed': element !== null && " +
            "getComputedStyle(element).visibility === 'visible' && " +
            "getComputedStyle(element).display !== 'none' }").get("displayed").getAsBoolean();
    }

    public boolean weDisplayed() {
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

    public String getCssValue(String style) {
        return js.getStyle(style);
    }

    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return we().getScreenshotAs(outputType);
    }
}
