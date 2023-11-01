package com.epam.jdi.light.angular.elements.complex;

import com.epam.jdi.light.angular.asserts.ChipGroupAssert;
import com.epam.jdi.light.angular.elements.common.Chip;
import com.epam.jdi.light.angular.elements.interfaces.IsGroupElement;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ChipGroup extends UIBaseElement<ChipGroupAssert> implements IsGroupElement<Chip> {

    private final String matOptions = "mat-option";
    public String backdropField = "#chips-autocomplete-field";

    @Override
    public List<Chip> groupElements() {
        core().timer().wait(() -> core().finds(".mat-mdc-chip").isDisplayed());
        return core().finds(".mat-mdc-chip").stream()
                .map(listItem -> new Chip().setCore(Chip.class, listItem))
                .collect(Collectors.toList());
    }



    @Override
    public Chip getElement(String value) {
        return groupElements().stream()
                .filter(element -> element.getText().equals(value))
                .findFirst()
                .get();
    }

    public boolean hasElement(String value) {
        return groupElements().stream()
                .anyMatch(chip -> chip.getText().equals(value));
    }

    @Override
    public boolean isDisplayed() {
        return groupElements().stream()
                .allMatch(ICoreElement::isDisplayed);
    }



    public void selectByText(String text) {
        getElement(text).click();
    }

    public void setValue(String selectValue) {
        inputField().click();
        select(selectValue);
    }

    @JDIAction("'{name}' input '{0}' value")
    public void input(String value) {
        inputField().input(value);
    }

    @JDIAction("Clear value from '{name}'")
    public void clearInputField() {
        inputField().sendKeys(Keys.CONTROL + "a");
        inputField().sendKeys(Keys.DELETE);
    }

    @JDIAction("Select value '{0}' for '{name}'")
    public void select(String value) {
        if (value == null) return;
        WebList options = getOptions(this.matOptions);
        options.get(value).click();
    }

    @JDIAction("Get placeholder for '{name}'")
    public String getPlaceholderForChips() {
        String placeholder = "placeholder";
        return inputField().hasAttribute(placeholder) ? inputField().getAttribute(placeholder) : "";
    }

    @JDIAction("Collapse '{name}' chips autocomplete field")
    public void collapseField() {
        getBackdropField().core()
                .click(getPointOutsideField().getX(), getPointOutsideField().getY());
    }

    @JDIAction("Get options for '{name}'")
    public List<String> options() {
        getItems();
        return getValues();
    }

    @JDIAction("")
    public String getOrientation() {
        return hasClass("mat-chip-list-stacked") ? "vertical" : "horizontal";
    }

    @JDIAction("")
    public String isMultiselectable() {
        return attr("aria-multiselectable");
    }

    private WebList getChips() {
        return this.finds(".mat-mdc-chip");
    }

    @Override
    public ChipGroupAssert is() {
        return new ChipGroupAssert().set(this);
    }

    protected UIElement getBackdropField() {
        return new UIElement(By.cssSelector(backdropField));
    }

    protected Point getPointOutsideField() {
        UIElement uiElement = getBackdropField();
        return new Point(uiElement.core().getRect().
                getWidth() + 3, uiElement.core().getRect().getHeight() + 3);
    }

    public UIElement inputField() {
        return find("input");
    }

    private WebList getOptions(String css) {
        return new WebList(By.cssSelector(css));
    }

    private WebList getItems() {
        inputField().click();
        WebList options = getOptions(matOptions);
        inputField().click();
        return options;
    }

    private List<String> getValues() {
        List<String> values = new ArrayList<>();
        WebList options = getOptions(this.matOptions);
        options.forEach(option -> values.add(option.getValue()));
        return values;
    }
}
