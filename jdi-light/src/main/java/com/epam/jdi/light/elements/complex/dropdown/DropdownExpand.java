package com.epam.jdi.light.elements.complex.dropdown;

import com.epam.jdi.light.asserts.complex.DropdownAssert;
import com.epam.jdi.light.asserts.generic.HasAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISelector;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.complex.IsDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;

import java.lang.reflect.Field;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.TextTypes.INNER;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;
import static com.epam.jdi.light.logger.LogLevels.DEBUG;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * Created by Roman Iovlev on 02.03.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class DropdownExpand extends UIBaseElement<DropdownAssert> implements IsDropdown, ISetup, ISelector, HasAssert<DropdownAssert> {
    public String expandLocator = ".caret";

    public UIElement expander() {
        return linked(expandLocator, "expand");
    }

    public String valueLocator = "input span:not(.caret),button span:not(.caret)";

    @Override
    public UIElement value() {
        return linked(valueLocator, "value");
    }

    @Override
    public UIElement iCore() {
        return value();
    }

    public String listLocator = "li";

    @Override
    public WebList list() {
        return linkedList(listLocator, "list").setUIElementName(INNER);
    }

    public boolean autoClose = false;

    public void toggle() {
        expander().click();
    }

    @JDIAction(value = "Is '{name}' expanded", level = DEBUG, timeout = 0)
    public boolean isExpanded() {
        try {
            return list().noWait(WebList::isDisplayed, WebList.class);
        } catch (Exception ex) {
            return false;
        }
    }

    @JDIAction(level = DEBUG, timeout = 0)
    public void expand() {
        if (!isExpanded())
            toggle();
    }

    @JDIAction(level = DEBUG, timeout = 0)
    public void close() {
        if (isExpanded())
            toggle();
    }

    @JDIAction("Select '{0}' in '{name}'") @Override
    public void select(String value) {
        expand();
        list().select(value);
        if (autoClose)
            toggle();
    }

    @JDIAction("Select '{0}' in '{name}'")
    @Override
    public void select(int index) {
        if (index < 1)
            throw exception("Can't get element with index '%s'. Index should be 1 or more", index);
        expand();
        list().select(index);
        if (autoClose)
            close();
    }

    @JDIAction("Get selected value")
    @Override
    public String selected() {
        return value().getText();
    }

    @JDIAction("Is '{0}' selected")
    @Override
    public boolean selected(String value) {
        return selected().equals(value);
    }

    @Override
    public String getText() {
        return value().getText();
    }

    @Override
    public String getValue() {
        return getText();
    }

    @Override
    public int size() {
        WebList list = list();
        return list.noValidation(list::size);
    }

    protected boolean setupDone = false;

    public IsDropdown setup(String root, String value, String list, String expand) {
        if (isNotBlank(root))
            base().setLocator(root);
        else if (isNotBlank(value)) {
            base().setLocator(value);
            thisParent = true;
        }
        if (isNotBlank(value)) {
            valueLocator = value;
            expandLocator = isNotBlank(expand)
                    ? expand
                    : value;
        } else if (isNotBlank(expand))
            expandLocator = expand;
        if (isNotBlank(list))
            listLocator = list;
        setupDone = true;
        return this;
    }

    public void setup(Field field) {
        if (!fieldHasAnnotation(field, JDropdown.class, IsDropdown.class))
            return;
        JDropdown j = field.getAnnotation(JDropdown.class);
        setup(j.root(), j.value(), j.list(), j.expand());
        autoClose = j.autoClose();
    }

    @JDIAction("Check that '{name}' is displayed")
    public boolean isDisplayed() {
        return value().isDisplayed();
    }
    @Override
    public DropdownAssert is() {
        return new DropdownAssert().set(this);
    }
}