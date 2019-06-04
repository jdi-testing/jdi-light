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
import static com.epam.jdi.light.driver.WebDriverByUtils.defineLocator;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.init.UIFactory.$$;
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

    /**
     * Select the specified element by the value
     * @param value
     */
    @JDIAction("Select '{0}' in '{name}'")
    public void select(String value) {
        if (list == null) {
            getSelectElement(format("select '%s'", value)).selectByVisibleText(value);
            return;
        }
        if (expander == null)
            click();
        else expand();
        list.select(value);
    }
    public <TEnum extends Enum> void select(TEnum name) { select(getEnumValue(name));}

    /**
     * Select the specified element by the index
     * @param index
     */
    @JDIAction("Select '{0}' in '{name}'")
    public void select(int index) {
        if (list == null) {
            getSelectElement(format("select '%s'", index)).selectByIndex(index);
            return;
        }
        if (expander == null)
            click();
        else expand();
        list.select(index-1);
    }

    /**
     * Get text
     * @return String text
     */
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

    /**
     * Check element is expanded
     * @return boolean
     */
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

    /**
     * Check the element is displayed
     * @param value
     * @return boolean
     */
    @JDIAction("Is item '{0}' displayed in '{value}'")
    public boolean isDisplayed(String value) {
        assertLinked(list, "list", "isDisplayed");
        return isExpanded() && list.values().contains(value);
    }

    /**
     * Get the element text
     * @return String text
     */
    @JDIAction(level = DEBUG)
    public String getSelected() {
        return getText();
    }

    /**
     * Waits while Element becomes visible
     * @return boolean
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

    /**
     * Get the elements attribute 'value'
     * @return List
     */
    @JDIAction("Get '{name}' values")
    public List<String> values() {
        assertLinked(list, "list", "values");
        return list.values();
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
        return list.ifSelect(JDIBase::isEnabled, BaseUIElement::getText);
    }

    public List<String> listDisabled() {
        return list.ifSelect(JDIBase::isDisabled, BaseUIElement::getText);
    }

    /**
     * Click on the item
     */
    @JDIAction(level = DEBUG)
    public void click() {
        assertLinked(list, "expander", "click");
        expander.click();
    }

    /**
     * Send specified value as keys
     * @param charSequence
     */
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
                ? defineLocator(j.root()) : null;
        By valueLocator = isNotBlank(j.value())
                ? defineLocator(j.value()) : null;
        By listLocator = isNotBlank(j.list())
                ? defineLocator(j.list()) : null;
        By expandLocator = isNotBlank(j.expand())
                ? defineLocator(j.expand()) : null;
        if (root != null)
            setLocator(root);
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

    //region matchers
    public ListAssert<UIElement> is() {
        return new ListAssert<>(() -> { list.refresh(); return list; }, () -> { list.refresh(); return this; }, toError());
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
