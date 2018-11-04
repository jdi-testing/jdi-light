package com.epam.jdi.light.elements.base;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.light.asserts.IsAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.SetValue;
import com.epam.jdi.tools.func.JFunc1;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.driver.WebDriverByUtils.uiSearch;
import static com.epam.jdi.tools.EnumUtils.getEnumValue;
import static com.epam.jdi.tools.LinqUtils.valueOrDefault;
import static com.epam.jdi.tools.PrintUtils.print;
import static java.lang.Thread.currentThread;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class UIElement extends JDIBase implements WebElement, BaseElement, SetValue {
    public UIElement() { }
    public UIElement(WebElement el) { webElement.setForce(el); }

    //region WebElement Wrapper
    @JDIAction
    public void click() {
        get().click();
    }
    public void submit() {
        get().submit();
    }
    @JDIAction("Input {value}")
    public void sendKeys(CharSequence... value) {
        checkEnabled();
        get().sendKeys(value);
    }
    protected void checkEnabled() {
        if (isDisabled()) {
            String methodName = currentThread().getStackTrace()[2].getMethodName();
            throw exception("Can't do "+methodName+" for disabled element '"+getName()+"'");
        }
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
        return get().isSelected() || getAttribute("class").contains("checked") ||
                getAttribute("checked").equals("true");
    }
    @JDIAction
    public boolean isEnabled() {
        String cl = getAttribute("class");
        return cl.contains("active") ||
                get().isEnabled() && !cl.contains("disabled");
    }

    @JDIAction
    public boolean isDisplayed() {
        try {
            WebElement el = get();
            return el != null && el.isDisplayed();
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
        return valueOrDefault(get().getAttribute(name), "");
    }
    //endregion

    //region Enchantments
    @JDIAction
    public void hover() {
        doActions(a -> a.moveToElement(get()));
    }
    @JDIAction
    public void jsClick() {
        jsExecute("click()");
    }

    @JDIAction("Input {value}")
    public void input(String value) {
        clear();
        sendKeys(value);
    }
    public void focus(){ sendKeys(""); }

    @JDIAction
    public void setText(String value) {
        //setAttribute("value", value);
        jsExecute("value='"+value+"'");
    }
    public UIElement find(String by) {
        return find(By.cssSelector(by));
    }

    public UIElement find(By by) {
        UIElement el = new UIElement();
        el.parent = this;
        el.setLocator(by);
        return el;
    }

    public List<UIElement> finds(String by) {
        return finds(By.cssSelector(by));
    }

    public List<UIElement> finds(By by) {
        UIElement el = new UIElement();
        el.parent = this;
        el.setLocator(by);
        return el.allUI();
    }

    public void setAttribute(String name, String value) {
        jsExecute("setAttribute('"+name+"','"+value+"')");
    }
    public List<String> getAllAttributes() {
        List<String> result;
        try {
            result = (List<String>) js().executeScript("var s = []; var attrs = arguments[0].attributes; for (var l = 0; l < attrs.length; ++l) { var a = attrs[l]; s.push(a.name + '=\"' + a.value + '\"'); } ; return s;", get());
        } catch (Exception ignore) { return new ArrayList<>(); }
        if (getAttribute("selected").equals("true"))
            result.add("selected");
        if (getAttribute("checked").equals("true"))
            result.add("checked");
        return result;
    }
    public String printHtml() {
        return MessageFormat.format("<{0}{1}>{2}</{0}>", getTagName(),
                print(getAllAttributes(), el -> " "+ el), getAttribute("innerHTML"));
    }

    public boolean isDisabled() {
        return !isEnabled();
    }
    public boolean isHidden() {
        return !isDisplayed();
    }

    @JDIAction
    public void higlight(String color) {
        jsExecute("style.border='3px dashed "+color+"'");
    }
    public void higlight() { show();
        higlight("red");
    }
    @JDIAction
    public void show() {
        jsExecute("scrollIntoView(true)");
    }

    public String getValue() {
        return getText();
    }

    @JDIAction
    public void select(String name) {
        get(name).click();
    }
    @JDIAction
    public <TEnum extends Enum> void select(TEnum name) {
        select(getEnumValue(name));
    }

    public void setValue(String value) {
        setText(value);
    }
    public Select select() {
        return new Select(get());
    }
    //endregion

    //region Actions
    @JDIAction
    public void dragAndDropTo(WebElement to) {
        doActions(a -> a.clickAndHold(get()).moveToElement(to).release(to));
    }
    @JDIAction
    public void doubleClick() {
        doActions(Actions::doubleClick);
    }
    @JDIAction
    public void rightClick() {
        doActions(Actions::contextClick);
    }
    @JDIAction
    public void dragAndDropTo(int x, int y) {
        doActions(a -> a.dragAndDropBy(get(), x, y));
    }
    public void doActions(JFunc1<Actions, Actions> actions) {
        actions.execute(new Actions(driver())).build().perform();
    }
    //endregion

    //region Asserts
    public IsAssert is() {
        return new IsAssert(this);
    }
    public IsAssert assertThat() {
        return is();
    }
    //endregion
}
