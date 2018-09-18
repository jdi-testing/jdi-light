package com.epam.jdi.light.elements.base;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.IHasValue;
import com.epam.jdi.light.elements.interfaces.ISetValue;
import com.epam.jdi.tools.func.JFunc1;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static com.epam.jdi.light.driver.WebDriverByUtils.uiSearch;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class UIElement extends JDIBase implements WebElement, BaseElement, ISetValue, IHasValue {

    @JDIAction
    public void click() {
        get().click();
    }
    @JDIAction
    public void hover() {
        doActions(a -> a.moveToElement(get()));
    }
    @JDIAction
    public void jsClick() {
        jsExecute("click()");
    }

    public void submit() {
        get().submit();
    }
    @JDIAction("Input {value}")
    public void sendKeys(CharSequence... value) {
        get().sendKeys(value);
    }
    @JDIAction("Input {value}")
    public void input(String value) {
        clear();
        sendKeys(value);
    }
    public void focus(){ sendKeys(""); }

    @JDIAction
    public UIElement setText(String value) {
        jsExecute("value = '"+value+"'");
        return this;
    }
    @JDIAction
    public void clear() {
        get().clear();
    }
    public String getTagName() {
        return get().getTagName();
    }
    @JDIAction
    public String getText() {
        WebElement el = get();
        String text = el.getText();
        if (isNotBlank(text))
            return text;
        String value = el.getAttribute("value");
        return isNotBlank(value) ? value : text;
    }

    public List<WebElement> findElements(By by) {
        return uiSearch(get(),by);
    }

    public WebElement findElement(By by) {
        return findElements(by).get(0);
    }

    @JDIAction
    public boolean isSelected() {
        return getAttribute("class").contains("checked") ||
            getAttribute("checked") != null || get().isSelected();
    }
    @JDIAction
    public boolean isEnabled() {
        String cl = getAttribute("class");
        return cl.contains("active") ||
            get().isEnabled() && !cl.contains("disabled");
    }

    @JDIAction
    public boolean isDisplayed() {
        WebElement el = get();
        try { return el != null && el.isDisplayed();
        } catch (Exception ex) { return false; }
    }
    public Point getLocation() {
        return get().getLocation();
    }
    public Dimension getSize() {
        return get().getSize();
    }
    public Rectangle getRect() {
        return get().getRect();
    }
    public String getCssValue(String s) {
        return get().getCssValue(s);
    }
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return get().getScreenshotAs(outputType);
    }
    public String getAttribute(String name) {
        return get().getAttribute(name);
    }
    public UIElement setAttribute(String name, String value) {
        jsExecute("setAttribute('"+name+"','"+value+"')");
        return this;
    }
    @JDIAction
    public UIElement higlight(String color) {
        jsExecute("style.border='3px dashed "+color+"'");
        return this;
    }
    public UIElement higlight() { show();
        return higlight("red");
    }
    @JDIAction
    public UIElement show() {
        jsExecute("scrollIntoView(true)");
        return this;
    }

    public String getValue() {
        return getText();
    }

    @JDIAction
    public UIElement select(String name) {
        get(name).click();
        return this;
    }

    public void setValue(String value) {
        clear();
        sendKeys(value);
    }
    public Select select() {
        return new Select(get());
    }

    //region Actions
    @JDIAction
    public UIElement dragAndDropTo(WebElement to) {
        doActions(a -> a.clickAndHold(get()).moveToElement(to).release(to));
        return this;
    }
    @JDIAction
    public UIElement doubleClick() {
        doActions(Actions::doubleClick);
        return this;
    }
    @JDIAction
    public UIElement rightClick() {
        doActions(Actions::contextClick);
        return this;
    }
    @JDIAction
    public UIElement dragAndDropTo(int x, int y) {
        doActions(a -> a.dragAndDropBy(get(), x, y));
        return this;
    }
    public UIElement doActions(JFunc1<Actions, Actions> actions) {
        actions.execute(new Actions(driver())).build().perform();
        return this;
    }
    //endregion
    public IsAssert is() {
        return new IsAssert(this);
    }
    public IsAssert assertThat() {
        return is();
    }

}
