package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.common.TextTypes;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.complex.dropdown.DropdownExpand;
import com.epam.jdi.light.elements.interfaces.complex.IsDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules;
import com.epam.jdi.light.material.asserts.inputs.SelectAssert;
import com.epam.jdi.light.material.interfaces.CanBeDisabled;
import org.openqa.selenium.Keys;

import java.lang.reflect.Field;

import static com.epam.jdi.light.common.TextTypes.INNER;

/**
 * Represents Select MUI Component on GUI.
 * <p>Select components are used for collecting user provided information from a list of options.</p>
 *
 * @see CanBeDisabled
 * @see <a href="https://v4.mui.com/components/selects/">Select MUI document</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material/selects">MUI test page</a>
 */
public class Select extends DropdownExpand implements CanBeDisabled {

    /**
     * Locator for list item.
     */
    private static final String LIST_LOCATOR = ".MuiPopover-root ul li";

    /**
     * Locator for value item.
     */
    private static final String VALUE_LOCATOR = ".MuiSelect-nativeInput";

    /**
     * Locator for expand.
     */
    private static final String EXPAND_LOCATOR = "*";

    /**
     * Gets list item of this select.
     *
     * @return list item of this select as {@link WebList}
     */
    @Override
    public WebList list() {
        WebList l = linkedList(listLocator, "list").setUIElementName(INNER);
        l.setParent(null);
        return l;
    }

    /**
     * Closes the expanded select by Escape key.
     */
    @JDIAction("Close '{name}'")
    @Override
    public void close() {
        if (isExpanded()) {
            core().actions((a) -> a.sendKeys(Keys.ESCAPE));
        }
    }

    /**
     * Selects list value of this Select.
     *
     * @param value list value of select to be selected.
     */
    @JDIAction("Select '{0}' in '{name}'")
    public void select(String... value) {
        expand();
        list().select(value);
        if (autoClose) {
            close();
        }
    }

    /**
     * Gets value of selected item.
     *
     * @return value of selected item as {@link String}
     */
    @JDIAction("Get selected value")
    @Override
    public String selected() {
        return text();
    }

    /**
     * Gets text of this Select
     *
     * @return text of this Select as {@link String}
     */
    @Override
    @JDIAction("Get text in '{name}'")
    public String getText() {
        return value().text(TextTypes.VALUE);
    }

    /**
     * Gets text of this Select.
     *
     * @return text of this Select as {@link String}
     */
    @Override
    @JDIAction("Get text in '{name}'")
    public String text() {
        return core().text();
    }

    /**
     * Initials this Select.
     *
     * @param field field of this Select
     */
    @Override
    @JDIAction("Initial '{name}'")
    public void setup(Field field) {
        if (!FillFromAnnotationRules.fieldHasAnnotation(field, JDropdown.class, IsDropdown.class)) {
            return;
        }
        JDropdown j = field.getAnnotation(JDropdown.class);
        String l = j.list().isEmpty() ? LIST_LOCATOR : j.list();
        String v = j.value().isEmpty() ? VALUE_LOCATOR : j.value();
        String e = j.expand().isEmpty() ? EXPAND_LOCATOR : j.expand();
        setup(j.root(), v, l, e);
        autoClose = j.autoClose();
    }

    @Override
    public SelectAssert is() {
        return (SelectAssert) new SelectAssert().set(this);
    }
}
