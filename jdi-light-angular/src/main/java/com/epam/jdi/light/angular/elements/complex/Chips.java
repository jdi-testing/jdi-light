package com.epam.jdi.light.angular.elements.complex;

import com.epam.jdi.light.angular.asserts.ChipsAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.uiElement;
import com.epam.jdi.light.elements.complex.webList;
import com.epam.jdi.light.elements.interfaces.base.HasPlaceholder;
import com.epam.jdi.light.elements.interfaces.base.SetValue;
import com.epam.jdi.light.elements.interfaces.common.IsInput;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;

import java.util.ArrayList;
import java.util.List;

/**
 * To see an example of Chips web element please visit https://material.angular.io/components/chips/overview.
 */

public class Chips extends UIBaseElement<ChipsAssert> implements HasPlaceholder, SetValue, IsInput {

    public String backdropField = "#chips-autocomplete-field";
    private final String matOptions = "mat-option";

    @JDIAction("Click '{name}' chips by text '{0}'")
    public void clickChipsByTextValue(String value) {
        getChipsByText(value).click();
    }

    @JDIAction("Click '{name}'")
    public void click() {
        core().click();
    }

    @JDIAction("Get options for '{name}'")
    public List<String> options() {
        getItems();
        return getValues();
    }

    @JDIAction("Get '{name}' chips by text '{0}'")
    public com.epam.jdi.light.elements.common.uiElement getChipsByText(String value) {
        com.epam.jdi.light.elements.common.uiElement element = null;
        for (com.epam.jdi.light.elements.common.uiElement e : getChips()) {
            if (e.getText().equalsIgnoreCase(value)) {
                element = e;
            }
        }
        return element;
    }

    @JDIAction("'{name}' has text '{0}'")
    public boolean chipsHasText(String value) {
        return getChipsByText(value).getText().equalsIgnoreCase(value);
    }

    public boolean enabled() {
        return !isDisabled();
    }

    @JDIAction("Get placeholder for '{name}'")
    public String getPlaceholderForChips() {
        String placeholder = "placeholder";
        return (core().hasAttribute(placeholder)) ?
                core().getAttribute(placeholder) : "";
    }

    @JDIAction("'{name}' input '{0}' value")
    public void input(String value) {
        core().input(value);
    }

    @JDIAction("Select value '{0}' for '{name}'")
    public void select(String value) {
        webList options = getOptions(this.matOptions);
        options.get(value).click();
    }

    @Override
    public String getValue() {
        return text();
    }

    public void setValue(String inputValue, String selectValue) {
        input(inputValue);
        select(selectValue);
    }

    @Override
    public void setValue(String selectValue) {
        click();
        select(selectValue);
    }

    @JDIAction("Clear value from '{name}'")
    public void clearInputField() {
        sendKeys(Keys.CONTROL + "a");
        sendKeys(Keys.DELETE);
    }

    @JDIAction("Collapse '{name}' chips autocomplete field")
    public void collapseField() {
        getBackdropField().core()
                .click(getPointOutsideField().getX(), getPointOutsideField().getY());
    }


    @Override
    public ChipsAssert is() {
        return new ChipsAssert().set(this);
    }

    protected com.epam.jdi.light.elements.common.uiElement getBackdropField() {
        return new uiElement(By.cssSelector(backdropField));
    }

    protected Point getPointOutsideField() {
        com.epam.jdi.light.elements.common.uiElement uiElement = getBackdropField();
        return new Point(uiElement.core().getRect().
                getWidth() + 3, uiElement.core().getRect().getHeight() + 3);
    }

    private webList getChips() {
        return this.finds("mat-chip");
    }

    private webList getOptions(String css) {
        return new webList(By.cssSelector(css));
    }

    private webList getItems() {
        click();
        webList options = getOptions(matOptions);
        click();
        return options;
    }

    private List<String> getValues() {
        List<String> values = new ArrayList<>();
        webList options = getOptions(this.matOptions);
        options.forEach(option -> values.add(option.getValue()));
        return values;
    }

}
