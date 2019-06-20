package com.epam.jdi.light.elements.base;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.interfaces.SetValue;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.UIUtils.create;
import static com.epam.jdi.light.driver.WebDriverByUtils.*;
import static com.epam.jdi.light.logger.LogLevels.DEBUG;
import static com.epam.jdi.tools.EnumUtils.getEnumValue;
import static com.epam.jdi.tools.LinqUtils.map;
import static java.lang.Thread.currentThread;

public abstract class BaseWebElement<T extends BaseWebElement>
        extends JDIBase implements WebElement, SetValue {
    protected Class<T> initClass;

    public T setInitClass(Class<T> listClass) {
        initClass = listClass;
        return (T)this;
    }

    protected T newElement() {
        try {
            return create(initClass);
        }
        catch (Exception ex) {
            throw exception("Can't instantiate %s. Exception: ",
                    getClass().getSimpleName(), ex.getMessage());
        }
    }
    protected T newElement(WebElement el) {
        T element = newElement();
        element.setWebElement(el);
        return element;
    }

    //region WebElement Wrapper
    /**
     * Сlick on the element
     */
    @JDIAction("Click on '{name}'")
    public void click() {
        get().click();
    }

    /**
     * Submit
     */
    @JDIAction(level = DEBUG)
    public void submit() {
        get().submit();
    }

    /**
     * Send specified value as keys
     * @param value
     */
    @JDIAction("Input '{0}' in '{name}'")
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
    @JDIAction(level = DEBUG)
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return get().getScreenshotAs(outputType);
    }
    public T find(String by) {
        return find(defineLocator(by));
    }
    public T find(By by) {
        List<WebElement> els = uiSearch(get(), by);
        if (els.size() > 0)
            return newElement(els.get(0));
        throw exception("Can't find sub element by locator %s for %s", shortBy(by), this);
    }
    public List<T> finds(String by) {
        return finds(defineLocator(by));
    }
    public List<T> finds(By by) {
        return map(get().findElements(by), this::newElement);
    }
    public T firstChild() { return find("*"); }
    public List<T> childs() { return finds("*"); }
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

    public Label label() {
        return new Label().core()
                .setLocator(By.cssSelector("[for="+attr("id")+"]"))
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
    @Override
    public String getText() { return super.getText(); }

    /**
     * Clear
     */
    @JDIAction("Clear '{name}'")
    public void clear() {
        get().clear();
    }

    /**
     * Get attribute 'value'
     * @return String
     */
    @JDIAction("Get '{name}' text")
    public String getValueText() {
        return getAttribute("value");
    }

    public List<WebElement> findElements(By by) {
        return uiSearch(get(),by);
    }

    public WebElement findElement(By by) {
        return findElements(by).get(0);
    }
    //endregion

    //region Enchantments
    /**
     * Сlick on the element
     */
    @JDIAction("Click on '{name}'")
    public void jsClick() {
        jsExecute("click()");
    }

    /**
     * Input specified value as keys
     * @param value
     */
    @JDIAction("Input '{0}' in '{name}'")
    public void input(String value) {
        clear();
        sendKeys(value);
    }

    /**
     * Focus
     */
    @JDIAction(level = DEBUG)
    public void focus(){ sendKeys(""); }

    /**
     * Get item text
     * @return String
     */
    @JDIAction(level = DEBUG) @Override
    public String getValue() {
        return getText();
    }

    /**
     * Select item by the value
     * @param value
     */
    @JDIAction("Select '{0}' in '{name}'")
    public void select(String value) {
        get(value).click();
    }

    /**
     * Select items by the values
     * @param names
     */
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
     * Gets attribute 'placeholder'
     * @return String
     */
    @JDIAction(value = "Get '{name}' placeholder", level = DEBUG)
    public String placeholder() { return getAttribute("placeholder"); }
    /**
     * Gets attribute 'value'
     * @return String
     */
    public String value() { return getAttribute("value"); }

    //endregion
}
