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
import static com.epam.jdi.light.common.ScreenshotMaker.takeScreen;
import static com.epam.jdi.light.driver.WebDriverByUtils.uiSearch;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.logger.LogLevels.DEBUG;
import static com.epam.jdi.light.settings.WebSettings.SMART_SEARCH;
import static com.epam.jdi.tools.EnumUtils.getEnumValue;
import static com.epam.jdi.tools.LinqUtils.map;
import static com.epam.jdi.tools.LinqUtils.valueOrDefault;
import static com.epam.jdi.tools.PrintUtils.print;
import static java.lang.Thread.currentThread;
import static java.util.Arrays.asList;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class UIElement<T extends UIElement> extends JDIBase implements WebElement, BaseElement, SetValue {
    public UIElement() { }
    public UIElement(WebElement el) { webElement.setForce(el); }

    protected T newElement(WebElement el) { return (T) new UIElement(el); }

    //region WebElement Wrapper
    @JDIAction("Click on '{name}'")
    public void click() {
        get().click();
    }
    @JDIAction(level = DEBUG)
    public void submit() {
        get().submit();
    }
    @JDIAction("Input '{value}' in '{name}'")
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

    /**
     * If not selected - click to select
     */
    @JDIAction("Check '{name}'")
    public void check() {
        checkEnabled();
        if (!isSelected())
            click();
    }

    /**
     * If selected - click to deselect
     */
    @JDIAction("Uncheck '{name}'")
    public void uncheck() {
        checkEnabled();
        if (isSelected())
            click();
    }

    public UIElement label() {
        return $("[for="+getAttribute("id")+"]");
    }

    /**
     * Gets label text
     * @return String text
     */
    @JDIAction("Get '{name}' label text")
    public String labelText() {
        return label().getText();
    }

    @JDIAction("Clear '{name}'")
    public void clear() {
        get().clear();
    }
    @JDIAction(level = DEBUG)
    public String getTagName() {
        return get().getTagName();
    }
    @JDIAction("Get '{name}' text")
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

    @JDIAction("Check that '{name}' is selected")
    public boolean isSelected() {
        return selected();
    }
    @JDIAction("Check that '{name}' is deselected")
    public boolean isDeselected() {
        return !selected();
    }
    @JDIAction(level = DEBUG)
    private boolean selected() {
        List<String> cl = classes();
        return get().isSelected() || cl.contains("checked") || cl.contains("active")||
                getAttribute("checked").equals("true");
    }

    @JDIAction("Check that '{name}' is enabled")
    public boolean isEnabled() {
        return enabled();
    }
    @JDIAction("Check that '{name}' is disabled")
    public boolean isDisabled() {
        return !enabled();
    }
    public boolean enabled() {
        String cl = getAttribute("class");
        return cl.contains("active") ||
                get().isEnabled() && !cl.contains("disabled");
    }

    @JDIAction("Check that '{name}' is displayed")
    public boolean isDisplayed() {
        return displayed();
    }
    @JDIAction("Check that '{name}' is hidden")
    public boolean isHidden() {
        return !displayed();
    }
    public boolean displayed() {
        try {
            if (webElement.hasValue())
                return webElement.get().isDisplayed();
            if (byLocator == null) {
                WebElement element = SMART_SEARCH.execute(this);
                return element != null && element.isDisplayed();
            }
            List<WebElement> result = getAll();
            return result.size() == 1 && result.get(0).isDisplayed();
        } catch (Exception ex) { return false; }
    }

    @JDIAction(level = DEBUG)
    public Point getLocation() {
        return get().getLocation();
    }
    @JDIAction(level = DEBUG)
    public Dimension getSize() {
        return get().getSize();
    }
    @JDIAction(level = DEBUG)
    public Rectangle getRect() {
        return get().getRect();
    }
    @JDIAction(level = DEBUG)
    public String getCssValue(String s) {
        return get().getCssValue(s);
    }
    @JDIAction(level = DEBUG)
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return get().getScreenshotAs(outputType);
    }
    @JDIAction(value = "Get '{name}' attribute '{0}'", level = DEBUG)
    public String getAttribute(String name) {
        return valueOrDefault(get().getAttribute(name), "");
    }
    //endregion

    //region Enchantments
    @JDIAction("Hover to '{name}'")
    public void hover() {
        doActions(a -> a.moveToElement(get()));
    }
    @JDIAction("Click on '{name}'")
    public void jsClick() {
        jsExecute("click()");
    }

    @JDIAction("Input '{value}' in '{name}'")
    public void input(String value) {
        clear();
        sendKeys(value);
    }
    @JDIAction(level = DEBUG)
    public void focus(){ sendKeys(""); }

    @JDIAction("Set '{value}' in '{name}'")
    public void setText(String value) {
        //setAttribute("value", value);
        jsExecute("value='"+value+"'");
    }
    public T find(String by) {
        return find(By.cssSelector(by));
    }
    public T find(By by) {
        return newElement(get().findElement(by));
    }
    public List<T> finds(String by) {
        return finds(By.cssSelector(by));
    }
    public List<T> finds(By by) {
        return map(get().findElements(by), this::newElement);
    }

    @JDIAction(level = DEBUG)
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
    public List<String> classes() {
        return asList(getAttribute("class").split(" "));
    }

    @JDIAction(level = DEBUG)
    public String printHtml() {
        return MessageFormat.format("<{0}{1}>{2}</{0}>", getTagName(),
                print(getAllAttributes(), el -> " "+ el), getAttribute("innerHTML"));
    }

    @JDIAction(level = DEBUG)
    public void higlight(String color) {
        jsExecute("style.border='3px dashed "+color+"'");
    }
    public void higlight() {
        show();
        higlight("red");
    }
    @JDIAction(level = DEBUG)
    public String makePhoto() {
        higlight();
        return takeScreen();
    }
    @JDIAction
    public void show() {
        jsExecute("scrollIntoView(true)");
    }

    @JDIAction(level = DEBUG)
    public String getValue() {
        return getText();
    }

    @JDIAction("Select '{0}' for '{name}'")
    public void select(String name) {
        get(name).click();
    }

    @JDIAction("Select '{0}' for '{name}'")
    public void select(String... names) {
        for (String name : names)
            select(name);
    }
    public <TEnum extends Enum> void select(TEnum name) {
        select(getEnumValue(name));
    }

    public void setValue(String value) {
        setText(value);
    }

    /**
     * Gets attr 'placeholder'
     * @return String
     */
    @JDIAction(level = DEBUG)
    public String placeholder() { return getAttribute("placeholder"); }
    /**
     * Gets attribute with name value
     * @return String
     */
    public String value() { return getAttribute("value"); }

    public Select select() {
        return new Select(get());
    }
    //endregion

    //region Actions
    @JDIAction("Drag '{name}' and drop it to '{value}'")
    public void dragAndDropTo(UIElement to) {
        doActions(a -> a.clickAndHold(get()).moveToElement(to).release(to));
    }
    @JDIAction("DoubleClick on '{name}'")
    public void doubleClick() {
        doActions(Actions::doubleClick);
    }
    @JDIAction("RightClick on '{name}'")
    public void rightClick() {
        doActions(Actions::contextClick);
    }
    @JDIAction("Drag '{name}' and drop it to ({0},{1})")
    public void dragAndDropTo(int x, int y) {
        doActions(a -> a.dragAndDropBy(get(), x, y));
    }
    private Actions actions = null;
    private Actions actionsClass() {
        if (actions == null)
            actions = new Actions(driver());
        return actions;
    }
    public void doActions(JFunc1<Actions, Actions> actions) {
        actions.execute(actionsClass()).build().perform();
    }
    public void actions(JFunc1<Actions, Actions> actions) {
        actions.execute(actionsClass().moveToElement(this)).build().perform();
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
