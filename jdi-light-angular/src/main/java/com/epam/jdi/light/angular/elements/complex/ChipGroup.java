package com.epam.jdi.light.angular.elements.complex;

import com.epam.jdi.light.angular.asserts.ChipGroupAssert;
import com.epam.jdi.light.angular.elements.common.Chip;
import com.epam.jdi.light.angular.elements.interfaces.HasOrientation;
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

public class ChipGroup extends UIBaseElement<ChipGroupAssert> implements IsGroupElement<Chip>, HasOrientation {

    public static final String CHIP_LOCATOR = ".mat-mdc-chip";
    private final String matOptions = "mat-option";

    @Override
    @JDIAction("Get list of '{name}' items")
    public List<Chip> groupElements() {
        core().timer().wait(() -> core().finds(CHIP_LOCATOR).isDisplayed());
        return core().finds(CHIP_LOCATOR).stream()
                .map(listItem -> new Chip().setCore(Chip.class, listItem))
                .collect(Collectors.toList());
    }

    @Override
    @JDIAction("Get {0} element from '{name}'")
    public Chip getElement(String value) {
        return groupElements().stream()
                .filter(element -> element.getText().equals(value))
                .findFirst()
                .get();
    }

    @JDIAction("Get if {0} element exist in '{name}'")
    public boolean hasElement(String value) {
        return groupElements().stream()
                .anyMatch(chip -> chip.getText().equals(value));
    }

    @Override
    @JDIAction("Get if all chips elements in '{name}' is displayed")
    public boolean isDisplayed() {
        return groupElements().stream()
                .allMatch(ICoreElement::isDisplayed);
    }

    @Override
    @JDIAction("Get if all chips elements in '{name}' is enabled")
    public boolean isEnabled() {
        return groupElements().stream()
                .allMatch(ICoreElement::isEnabled);
    }

    @JDIAction("Select chip element in '{name}' by '{0}'")
    public void selectByText(String text) {
        Chip chip = getElement(text);
        if (!chip.selected()){
            chip.click();
        }
    }

    @JDIAction("Deselect chip element in '{name}' by '{0}'")
    public void deselectByText(String text) {
        Chip chip = getElement(text);
        if (chip.selected()){
            chip.click();
        }
    }

    @JDIAction("Get '{name}' input field")
    public UIElement inputField() {
        return find("input");
    }

    @JDIAction("'{name}' input field input '{0}' value")
    public void input(String value) {
        inputField().input(value);
    }

    @JDIAction("Clear value from '{name}' input field")
    public void clearInputField() {
        inputField().sendKeys(Keys.CONTROL + "a");
        inputField().sendKeys(Keys.DELETE);
    }

    @JDIAction("Select value '{0}' for '{name}' autocomplete")
    public void select(String value) {
        if (value == null) return;
        inputField().click();
        WebList options = getOptions(this.matOptions);
        options.get(value).click();
    }

    @JDIAction("Get placeholder for '{name}' input field")
    public String getPlaceholderForChips() {
        String placeholder = "placeholder";
        return inputField().hasAttribute(placeholder) ? inputField().getAttribute(placeholder) : "";
    }

    @JDIAction("Collapse '{name}' chips autocomplete field")
    public void collapseField() {
        core().click(getPointOutsideField().getX(), getPointOutsideField().getY());
    }

    @JDIAction("Get options for '{name}' autocomplete field")
    public List<String> options() {
        getItems();
        return getValues();
    }

    @Override
    @JDIAction("Get if '{name}' is vertical")
    public boolean isVertical() {
        return core().attr("class").contains("mat-chip-list-stacked");
    }

    @JDIAction("Get if '{name}' has multiple selection")
    public String multiselectable() {
        return attr("aria-multiselectable");
    }

    @JDIAction("Get if '{name}' has error state")
    public boolean errorState() {
        return core().hasClass("mat-form-field-invalid");
    }

    @Override
    public ChipGroupAssert is() {
        return new ChipGroupAssert().set(this);
    }

    protected Point getPointOutsideField() {
        return new Point(core().getRect().
                getWidth() + 3, core().getRect().getHeight() + 3);
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
