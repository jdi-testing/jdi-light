package com.epam.jdi.light.elements.complex;

import com.epam.jdi.light.asserts.ListAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.BaseUIElement;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.interfaces.SetValue;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.lang.reflect.Field;
import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;
import static com.epam.jdi.light.logger.LogLevels.DEBUG;
import static com.epam.jdi.tools.EnumUtils.getEnumValue;
import static com.epam.jdi.tools.LinqUtils.any;
import static java.lang.String.format;
import static java.util.Arrays.asList;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.isNotBlank;


/**
 * Created by Roman Iovlev on 02.03.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public class Droplist extends JDIBase implements ISetup, SetValue, ISelector {
    private static final String SELECT_ERROR =
            "Can't %s element in dropdown '%s'. Droplist should have JDropdown annotation or locator to 'select' tag";
    private static final String TO_MUCH_ELEMENTS_FOUND_ERROR =
            "Found more than 1 <select> tag with locator '%s' for dropdown '%s'";

    protected UIElement expander;
    protected UIElement value;
    protected WebList list;

    @JDIAction("Select '{0}' in '{name}'")
    public void select(String value) {
        if (expander != null && list != null) {
            expand();
            list.select(value);
        }
        else getSelectElement(format("select '%s'", value)).selectByVisibleText(value);
    }
    public <TEnum extends Enum> void select(TEnum name) { select(getEnumValue(name));}

    @JDIAction("Select '{0}' in '{name}'")
    public void select(int index) {
        if (expander != null && list != null) {
            expand();
            list.select(index-1);
        }
        else getSelectElement(format("select '%s'", index)).selectByIndex(index);
    }
    @JDIAction("Get '{name}' text")
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

    @JDIAction("Is '{name}' expanded")
    public boolean isExpanded() {
        assertLinked(list, "list", "expand");
        return any(list.getAll(), el -> new UIElement(el).displayed());
    }
    /**
     * Expanding DropDown
     */
    @JDIAction(level = DEBUG)
    public void expand() {
        if (!isExpanded()) {
            click();
        }
    }
    /**
     * Closing DropDown
     */
    @JDIAction(level = DEBUG)
    public void close() {
        if (isExpanded())
            click();
    }
    public String getValue() { return getText(); }

    @JDIAction("Is item '{0}' displayed in '{name}'")
    public boolean isDisplayed(String value) {
        assertLinked(list, "list", "isDisplayed");
        return isExpanded() && list.values().contains(name);
    }

    @JDIAction(level = DEBUG)
    public String getSelected() {
        return getText();
    }

    /**
     * Waits while Element becomes visible
     */
    @JDIAction("Is '{name}' displayed")
    public boolean isDisplayed() {
        return value.isDisplayed();
    }

    public boolean selected(String option) {
        return getSelected().equals(option);
    }

    public List<String> checked() {
        return asList(getSelected());
    }

    @JDIAction("Get '{name}' values")
    public List<String> values() {
        assertLinked(list, "list", "values");
        return ((WebList)list.noValidation()).values();
    }
    @JDIAction("Get '{name}' values")
    public List<String> innerValues() {
        assertLinked(list, "list", "values");
        return ((WebList)list.noValidation()).innerValues();
    }
    public List<String> listEnabled() {
        return list.ifSelect(JDIBase::isEnabled, BaseUIElement::getText);
    }

    public List<String> listDisabled() {
        return list.ifSelect(JDIBase::isDisabled, BaseUIElement::getText);
    }

    @JDIAction(level = DEBUG)
    public void click() {
        assertLinked(list, "expander", "click");
        expander.click();
    }
    @JDIAction("Input '{0}' in '{name}'")
    public void sendKeys(CharSequence... charSequence) {
        value.sendKeys(charSequence);
    }

    private void assertLinked(Object element, String name, String actionName) {
        if (element == null)
            throw exception(format("You must specify '%s' in Droplist annotation in order to perform %s action", name ,actionName));
    }
    public void setup(Field field) {
        if (!fieldHasAnnotation(field, JDropdown.class, Droplist.class))
            return;
        JDropdown j = field.getAnnotation(JDropdown.class);
        By root = isNotBlank(j.root())
                ? By.cssSelector(j.root()) : null;
        By valueLocator = isNotBlank(j.value())
                ? By.cssSelector(j.value()) : null;
        By listLocator = isNotBlank(j.list())
                ? By.cssSelector(j.list()) : null;
        By expandLocator = isNotBlank(j.expand())
                ? By.cssSelector(j.expand()) : null;
        if (root != null)
            setLocator(root);
        if (valueLocator != null) {
            value = new UIElement();
            value.name = getName() + " value element";
            value.setLocator(valueLocator);
            value.parent = this;
            value.driverName = driverName;
            if (expandLocator == null)
                expander = value;
        }
        if (listLocator != null) {
            list = new WebList();
            list.name = getName() + " list element";
            list.setLocator(listLocator);
            list.parent = this;
            list.driverName = driverName;
        }
        if (expandLocator != null) {
            expander = new UIElement();
            expander.name = getName() + " expander element";
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

    //region matchers
    public ListAssert<UIElement> is() {
        return new ListAssert<>(list, this, toError());
    }
    public ListAssert<UIElement> assertThat() {
        return is();
    }
    public ListAssert<UIElement> has() {
        return is();
    }
    public ListAssert<UIElement> waitFor() {
        return is();
    }
    public ListAssert<UIElement> shouldBe() {
        return is();
    }
    //endregion

    public int size() {
        return list.size();
    }

}
