package com.epam.jdi.light.angular.elements.complex;

import com.epam.jdi.light.angular.asserts.ChipsAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.base.HasPlaceholder;
import com.epam.jdi.light.elements.interfaces.base.SetValue;
import com.epam.jdi.light.elements.interfaces.common.IsInput;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.epam.jdi.light.logger.LogLevels.DEBUG;


/**
 * To see an example of Chips web element please visit https://material.angular.io/components/chips/overview.
 */

public class Chips extends UIBaseElement<ChipsAssert> implements HasPlaceholder, SetValue, IsInput {

    //private String removeIcon = "//*[@id='mat-chip-list-2']//*[2]/*[last()]";
    public String backdropField = "#chips-autocomplete-field";
    private String matOptions = "mat-option";

    @JDIAction("Click '{name}' chips by text '{0}'")
    public void clickChipsByTextValue(String value) {
        getChipsByText(value).click();
    }

    public void click() {
        core().click(); }

    @JDIAction("Get '{name}' chips")
    private WebList getChips() {
        return this.finds("mat-chip");
    }

    @JDIAction("Get '{name}' chips by text '{0}'")
    public UIElement getChipsByText(String value) {
        UIElement element = null;
        for (UIElement e : getChips()) {
            if (e.getText().equalsIgnoreCase(value)) {
                element = e;
            }
        }
        return element;
    }

    public UIElement getChipIconByText (String value) {
        UIElement element = null;
        for (UIElement e : getChips()) {
            if (e.getText().equalsIgnoreCase(value)) {
                element = e;
            }
        }
            return element.find("mat-icon");
    }

    public void deleteChip (String value) {
        getChipIconByText(value).click();
        //find(By.xpath(removeIcon)).click();
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

    private WebList getOptions(String css) {
        return new WebList(By.cssSelector(css));
    }

    @JDIAction("Get options for '{name}'")
    public List<String> options() {
        getItems();
        return getValues();
    }

    private WebList getItems() {
        click();
        WebList options = getOptions(matOptions);
        click();
        return options;
    }

    private List<String> getValues() {
        List<String> values = new ArrayList<>();
        WebList options = getOptions(this.matOptions);
        options.forEach(option -> values.add(option.getValue()));
        return values;
    }

    public void input(String value) {
        core().input(value);
    }

    @JDIAction("Select value {0} for '{name}'")
    public void select(String value) {
        WebList options = getOptions(this.matOptions);
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

    protected UIElement getBackdropField() {
        return new UIElement(By.cssSelector(backdropField));
    }

    protected Point getPointOutsideField() {
        UIElement uiElement = getBackdropField();
        return new Point(uiElement.core().getRect().
                getWidth() + 3, uiElement.core().getRect().getHeight() + 3);
    }

    @Override
    public ChipsAssert is() {
        return new ChipsAssert().set(this);
    }
}









