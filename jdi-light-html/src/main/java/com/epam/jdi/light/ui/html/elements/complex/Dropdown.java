package com.epam.jdi.light.ui.html.elements.complex;

import com.epam.jdi.light.asserts.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.*;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.tools.func.JFunc1;
import org.openqa.selenium.By;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.driver.WebDriverByUtils.defineLocator;
import static com.epam.jdi.light.elements.base.JDIBase.waitCondition;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.init.UIFactory.$$;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;
import static com.epam.jdi.light.logger.LogLevels.DEBUG;
import static com.epam.jdi.tools.EnumUtils.getEnumValue;
import static java.lang.String.format;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * Created by Roman Iovlev on 02.03.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public class Dropdown extends UIListBase<UISelectAssert> implements ISetup, IBaseElement, WithLabel {
    private DropdownSelect ds() {
        return new DropdownSelect(element(), SELECT_ERROR);
    }
    private static final String SELECT_ERROR =
        "Can't %s element in Dropdown '%s'. Dropdown should have JDropdown annotation or locator to 'select' tag";

    protected UIElement expander;
    protected UIElement value;

    /**
     * Select the specified element by the value
     * @param value
     */
    @JDIAction("Select '{0}' in '{name}'")
    public void select(String value) {
        if (list() != null) {
            expand();
            list().select(value);
            if (list().hasAny(uiElement -> uiElement.displayed() && uiElement.isEnabled()))
                click();
        } else {
            ds().select(value);
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
        if (list() == null) {
            expand();
            list().select(index - 1);
            if (list().hasAny(JDIBase::displayed))
                click();
        } else {
            ds().select(index);
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
            : ds().getText();

    }

    /**
     * Check element is expanded
     * @return boolean
     */
    @JDIAction(value = "Is '{name}' expanded", level = DEBUG)
    public boolean isExpanded() {
        assertLinked(list(), "list", "expand");
        return list().hasAny(JDIBase::displayed);
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

    /**
     * Get the element text
     * @return String text
     */
    @JDIAction(level = DEBUG)
    public String selected() {
        return getText();
    }

    public void hover() {
        element().hover();
    }
    public boolean isEnabled() {
        if (list() == null || expander == null)
            return ds().isEnabled();
        expand();
        return list().listEnabled().size() > 0;
    }

    @JDIAction("Check that '{name}' is displayed")
    public boolean isDisplayed() {
        return ds().isDisplayed() || value.isDisplayed();
    }

    public void highlight(String color) {
        element().highlight(color);
    }
    public void highlight() {
        element().highlight();
    }
    public void show() {
        element().show();
    }

    public boolean wait(JFunc1<Dropdown, Boolean> condition) {
        return waitCondition(condition, this);
    }

    public boolean selected(String option) {
        return selected().equals(option);
    }

    @JDIAction("Get '{name}' values")
    public List<String> values() {
        List<String> result = new ArrayList<>();
        if (list() == null && element().getTagName().contains("select"))
            return ds().values();
        if (list() != null) {
            if (!list().hasAny(JDIBase::displayed))
                click();
            result = list().values();
            if (list().hasAny(JDIBase::displayed))
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
        List<String> result = new ArrayList<>();
        if (list() == null && element().getTagName().contains("select"))
            return ds().innerValues();
        if (list() != null) {
            if (!list().hasAny(JDIBase::displayed))
                click();
            result = list().innerValues();
            if (list().hasAny(JDIBase::displayed))
                click();
        }
        return result;
    }
    public List<String> listEnabled() {
        return list() != null
            ? list().listEnabled()
            : ds().listEnabled();
    }

    public List<String> listDisabled() {
        return list() != null
                ? list().listDisabled()
                : ds().listDisabled();
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
            setList($$(listLocator, this).setName(getName() + " list element"));
            list().driverName = driverName;
        }
        if (expandLocator != null) {
            expander = $(expandLocator, this).setName(getName() + " expander element");
            expander.driverName = driverName;
            if (valueLocator == null)
                value = expander;
        }
    }

}
