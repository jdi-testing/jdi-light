package com.epam.jdi.light.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.IHasValue;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.interfaces.ISetValue;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.lang.reflect.Field;
import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.elements.pageobjects.annotations.WebAnnotationsUtil.findByToBy;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;
import static com.epam.jdi.tools.EnumUtils.getEnumValue;
import static java.lang.String.format;
import static org.apache.commons.lang3.StringUtils.isBlank;


/**
 * Created by Roman Iovlev on 02.03.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public class Dropdown extends JDIBase implements ISetup, IHasValue, ISetValue {
    private static final String SELECT_ERROR =
            "Can't %s element in dropdown '%s'. Dropdown should have JDropdown annotation or locator to 'select' tag";
    private static final String TO_MUCH_ELEMENTS_FOUND_ERROR =
            "Found more than 1 <select> tag with locator '%s' for dropdown '%s'";

    protected UIElement expander;
    protected UIElement value;
    protected UIList list;

    @JDIAction
    public void select(String name) {
        if (expander != null && list != null) {
            expand();
            list.select(name);
        }
        else getSelectElement(format("select '%s'", name)).selectByVisibleText(name);
    }
    public <TEnum extends Enum> void select(TEnum name) { select(getEnumValue(name));}
    @JDIAction
    public void select(int index) {
        if (expander != null && list != null) {
            expand();
            list.select(index);
        }
        else getSelectElement(format("select '%s'", index)).selectByIndex(index);
    }
    @JDIAction
    public String getText() {
        if (value != null) {
            String result = "";
            if (value.getTagName().contains("select")) try {
                result = new Select(value).getFirstSelectedOption().getText();
            } catch (Exception ignore) {}
            return !isBlank(result) ? result : value.getText();
        }
        return getSelectElement("getSelected").getFirstSelectedOption().getText();

    }

    private Select getSelectElement(String action) {
        WebElement root = get();
        if (root.getTagName().contains("select"))
            return new Select(root);
        throw exception(SELECT_ERROR, action, this);
    }

    @JDIAction
    public boolean isExpanded() {
        assertLinked(list, "list", "expand");
        return list.isDisplayed();
    }
    /**
     * Expanding DropDown
     */
    @JDIAction
    public void expand() {
        if (!isExpanded())
            click();
    }
    /**
     * Closing DropDown
     */
    @JDIAction
    public void close() {
        if (isExpanded())
            click();
    }
    public String getValue() { return getText(); }

    public boolean isDisplayed(String name) {
        assertLinked(list, "list", "isDisplayed");
        return isExpanded() && list.values().contains(name);
    }

    public String getSelected() {
        return getText();
    }

    /**
     * Waits while Element becomes visible
     */
    public boolean isDisplayed() {
        return value.isDisplayed();
    }

    @JDIAction
    public List<String> values() {
        assertLinked(list, "list", "values");
        return list.values();
    }
    @JDIAction
    public void click() {
        assertLinked(list, "expander", "click");
        expander.click();
    }
    @JDIAction
    public void sendKeys(CharSequence... charSequence) {
        value.sendKeys(charSequence);
    }

    private void assertLinked(Object element, String name, String actionName) {
        if (element == null)
            throw exception(format("You must specify '%s' in Dropdown annotation in order to perform %s action", name ,actionName));
    }
    public void setup(Field field) {
        if (!fieldHasAnnotation(field, JDropdown.class, Dropdown.class))
            return;
        JDropdown j = field.getAnnotation(JDropdown.class);
        By root = findByToBy(j.root());
        By valueLocator = findByToBy(j.value());
        By listLocator = findByToBy(j.list());
        By expandLocator = findByToBy(j.expand());
        if (root != null)
            setLocator(root);
        if (valueLocator != null) {
            value = new UIElement();
            value.setLocator(valueLocator);
            value.parent = this;
            value.driverName = driverName;
            if (expandLocator == null)
                expander = value;
        }
        if (listLocator != null) {
            list = new UIList();
            list.setLocator(listLocator);
            list.parent = this;
            list.driverName = driverName;
        }
        if (expandLocator != null) {
            expander = new UIElement();
            expander.setLocator(expandLocator);
            expander.parent = this;
            expander.driverName = driverName;
            if (valueLocator == null)
                value = expander;
        }
    }

    public void setValue(String value) {
        select(value);
    }
}
