package com.epam.jdi.light.angular.elements.complex;

import com.epam.jdi.light.angular.asserts.ChipsAssert;
import com.epam.jdi.light.angular.elements.enums.ChipsColors;
import com.epam.jdi.light.angular.elements.enums.ChipsOrientations;
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
    public UIElement getChipsByText(String value) {
        UIElement element = null;
        for (UIElement e : getChips()) {
            if (e.getText().startsWith(value)) {
                element = e;
            }
        }
        return element;
    }

    @JDIAction("'{name}' has text '{0}'")
    public boolean chipsHasText(String value) {
        return getChipsByText(value).getText().startsWith(value);
    }

    public boolean enabled() {
        return !finds(By.className("mat-mdc-chip-disabled")).isExist();
    }

    @JDIAction("Get placeholder for '{name}'")
    public String getPlaceholderForChips() {
        String placeholder = "placeholder";
        return core().hasAttribute(placeholder) ? core().getAttribute(placeholder) : "";
    }

    @JDIAction("'{name}' input '{0}' value")
    public void input(String value) {
        core().input(value);
    }

    @JDIAction("Select value '{0}' for '{name}'")
    public void select(String value) {
        if (value == null) return;
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
        Keys osSpecificShortcutKey = System.getProperty("os.name").equalsIgnoreCase("Mac OS X") ? Keys.COMMAND : Keys.CONTROL;
        sendKeys(osSpecificShortcutKey + "a");
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

    protected UIElement getBackdropField() {
        return new UIElement(By.cssSelector(backdropField));
    }

    protected Point getPointOutsideField() {
        UIElement uiElement = getBackdropField();
        return new Point(uiElement.core().getRect().
                getWidth() + 3, uiElement.core().getRect().getHeight() + 3);
    }

    private WebList getChips() {
        return this.finds(".mat-mdc-chip");
    }

    private WebList getOptions(String css) {
        return new WebList(By.cssSelector(css));
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



    //TODO move public methods higher and add the @JDIAction to them

    private String getAttrClass() {
        return attr("class");
    }

    public ChipsColors color() {
        return ChipsColors.valueOf(attr("color"));
    }

    public boolean focused() {
        return getAttrClass().contains("cdk-focused");
    }

    public boolean disableRipple() {
        //TODO
        //The node only appears during the animation
        //span[contains(@class, 'mat-ripple')]/*
        return getAttrClass().contains("");
    }

    public boolean disabled() {
        return !enabled();
    }

    //value: any

    public ChipsOrientations ariaOrientation() {
        return ChipsOrientations.valueOf(attr("aria-orientation"));
    }

    public boolean multiple() {
        return getAttrClass().contains("mat-mdc-chip-multiple");
    }

    public boolean required() {
        return !attr("aria-required").contains("false");
    }

    public boolean errorState() {
        return getAttrClass().contains("mat-mdc-chip-list-invalid");
    }

    public boolean hideSingleSelectionIndicator() {
        return getAttrClass().contains("");
    }

    public boolean highlighted() {
        return getAttrClass().contains("mat-mdc-chip-highlighted");
    }

    public boolean removable() {
        return getAttrClass().contains("mdc-evolution-chip--with-trailing-action");
    }

    //removeIcon: MatChipRemove

    //defaultColor: Primary | Accent | Warn| undefined

    //isInteractive: boolean - remove trailing icon

    //leadingIcon: MatChipAvatar

    public boolean selected() {
        return getAttrClass().contains("mat-mdc-chip-selected");
    }

    public boolean editable() {
        return getAttrClass().contains("mat-mdc-chip-editable");
    }

    public boolean empty(Chips chips) {
        return chips.finds(By.cssSelector("mat-chip-row")).size() == 0;
    }
}

