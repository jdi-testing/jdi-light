package com.epam.jdi.light.elements.complex;

import com.epam.jdi.light.asserts.HasAssert;
import com.epam.jdi.light.asserts.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.*;
import com.epam.jdi.light.elements.interfaces.SetValue;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.tools.Timer;
import com.epam.jdi.tools.func.JFunc1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.driver.WebDriverByUtils.defineLocator;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.init.UIFactory.$$;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;
import static com.epam.jdi.light.logger.LogLevels.DEBUG;
import static com.epam.jdi.light.settings.TimeoutSettings.TIMEOUT;
import static com.epam.jdi.tools.EnumUtils.getEnumValue;
import static com.epam.jdi.tools.LinqUtils.map;
import static java.lang.String.format;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * Created by Roman Iovlev on 02.03.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public class Dropdown extends DriverBase implements ISetup, SetValue,
        ISelector, IBaseElement, HasAssert<UISelectAssert>, HasUIElement {
    protected UIElement element = new UIElement();
    public UIElement element() { return element; }

    private static final String SELECT_ERROR =
            "Can't %s element in dropdown '%s'. Droplist should have JDropdown annotation or locator to 'select' tag";
    private static final String TO_MUCH_ELEMENTS_FOUND_ERROR =
            "Found more than 1 <select> tag with locator '%s' for dropdown '%s'";

    protected UIElement expander;
    protected UIElement value;
    protected WebList list;

    /**
     * Select the specified element by the value
     * @param value
     */
    @JDIAction("Select '{0}' in '{name}'")
    public void select(String value) {
        if (list != null) {
            expand();
            list.select(value);
            if (list.hasAny(JDIBase::displayed))
                click();
        } else {
            getSelect(format("Select '%s'", value)).selectByVisibleText(value);
        }
    }
    protected void click() {
        if (expander != null)
            expander.click();
        else element().click();
    }
    public <TEnum extends Enum> void select(TEnum name) { select(getEnumValue(name));}

    /**
     * Select the specified element by the index
     * @param index
     */
    @JDIAction("Select '{0}' in '{name}'")
    public void select(int index) {
        if (index < 1)
            throw exception("Can't get element with index '%s'. Index should be 1 or more", index);
        if (list == null) {
            expand();
            list.select(index - 1);
            if (list.hasAny(JDIBase::displayed))
                click();
        } else {
            getSelect(format("Select '%s'", index)).selectByIndex(index);
        }
    }

    /**
     * Get text
     * @return String text
     */
    @JDIAction("Get '{name}' text")
    public String getText() {
        return value != null
            ? value.getText()
            : getSelect("getText").getFirstSelectedOption().getText();

    }

    protected Select getSelect(String action) {
        if (element().getTagName().contains("select"))
            return new Select(element());
        throw exception(SELECT_ERROR, action, this);
    }

    /**
     * Check element is expanded
     * @return boolean
     */
    @JDIAction(value = "Is '{name}' expanded", level = DEBUG)
    public boolean isExpanded() {
        assertLinked(list, "list", "expand");
        return list.hasAny(JDIBase::displayed);
    }
    /**
     * Expanding DropDown
     */
    @JDIAction(level = DEBUG)
    public void expand() {
        if (expander != null)
            if (!isExpanded())
                expander.click();
        else { try { element().click(); }
            catch (Throwable ignore) {
                assertLinked(expander, "expander", "expand");
            }
        }
    }
    /**
     * Closing DropDown
     */
    @JDIAction(level = DEBUG)
    public void close() {
        if (expander != null) {
            if (isExpanded())
                expander.click();
        }
        else { try { element().click(); }
        catch (Throwable ignore) {
                assertLinked(expander, "expander", "close");
            }
        }
    }
    public String getValue() { return selected(); }

    /**
     * Get the element text
     * @return String text
     */
    @JDIAction(level = DEBUG)
    public String selected() {
        return getText();
    }

    public void hover() {
        element.hover();
    }
    public boolean isEnabled() {
        if (list == null || expander == null)
            return false;
        expand();
        return list.listEnabled().size() > 0;
    }
    public boolean isDisabled() {
        return !isEnabled();
    }
    public void offCache() {
        list.offCache();
    }

    public boolean displayed() {
        return element().isDisplayed() || value.isDisplayed();
    }
    @JDIAction("Check that '{name}' is displayed")
    public boolean isDisplayed() {
        return displayed();
    }
    @JDIAction("Check that '{name}' is hidden")
    public boolean isHidden() {
        return !displayed();
    }

    public void highlight(String color) {
        element.highlight(color);
    }
    public void highlight() {
        element.highlight();
    }
    public void show() {
        element.show();
    }
    public boolean wait(JFunc1<Dropdown, Boolean> condition) {
        return new Timer(TIMEOUT.get()).wait(() -> condition.execute(this));
    }

    public boolean selected(String option) {
        return selected().equals(option);
    }

    @JDIAction("Get '{name}' values")
    public List<String> values() {
        List<String> result = new ArrayList<>();
        if (list == null && element().getTagName().contains("select"))
            return map(getSelect("values").getOptions(), WebElement::getText);
        if (list != null) {
            if (!list.hasAny(JDIBase::displayed))
                click();
            result = list.values();
            if (list.hasAny(JDIBase::displayed))
                click();
        }
        return result;
    }

    /**
     * Get the elements attribute 'innerValue'
     * @return List
     */
    @JDIAction("Get '{name}' values")
    public List<String> innerValues() {
        assertLinked(list, "list", "values");
        return list.innerValues();
    }
    public List<String> listEnabled() {
        return list.listEnabled();
    }

    public List<String> listDisabled() {
        return list.listDisabled();
    }

    protected void assertLinked(Object element, String name, String actionName) {
        if (element == null)
            throw exception(format("You must specify '%s' in Dropdown annotation in order to perform %s action", name ,actionName));
    }
    public void setup(Field field) {
        if (!fieldHasAnnotation(field, JDropdown.class, Dropdown.class))
            return;
        JDropdown j = field.getAnnotation(JDropdown.class);
        By root = isNotBlank(j.root())
                ? defineLocator(j.root()) : null;
        By valueLocator = isNotBlank(j.value())
                ? defineLocator(j.value()) : null;
        By listLocator = isNotBlank(j.list())
                ? defineLocator(j.list()) : null;
        By expandLocator = isNotBlank(j.expand())
                ? defineLocator(j.expand()) : null;
        if (root != null)
            element().setLocator(root);
        if (valueLocator != null) {
            value = $(valueLocator, this).setName(getName() + " value element");
            value.driverName = driverName;
            if (expandLocator == null)
                expander = value;
        }
        if (listLocator != null) {
            list = $$(listLocator, this).setName(getName() + " list element");
            list.driverName = driverName;
        }
        if (expandLocator != null) {
            expander = $(expandLocator, this).setName(getName() + " expander element");
            expander.driverName = driverName;
            if (valueLocator == null)
                value = expander;
        }
    }

    public void setValue(String value) {
        select(value);
    }

    public int size() {
        return values().size();
    }

    public UISelectAssert is() {
        list.offCache();
        return new UISelectAssert().set(this);
    }
}
