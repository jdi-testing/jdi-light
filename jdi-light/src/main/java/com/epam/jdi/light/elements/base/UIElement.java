package com.epam.jdi.light.elements.base;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.light.asserts.IsAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.SetValue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.driver.WebDriverByUtils.uiSearch;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.logger.LogLevels.DEBUG;
import static com.epam.jdi.tools.EnumUtils.getEnumValue;
import static com.epam.jdi.tools.LinqUtils.map;
import static java.lang.Thread.currentThread;
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
        return $("[for="+getAttribute("id")+"]")
                .setName(getName() + " label");
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
    //endregion

    //region Enchantments

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


    @JDIAction(level = DEBUG)
    public String getValue() {
        return getText();
    }

    @JDIAction("Select '{0}' in '{name}'")
    public void select(String value) {
        get(value).click();
    }

    @JDIAction("Select '{0}' in '{name}'")
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
