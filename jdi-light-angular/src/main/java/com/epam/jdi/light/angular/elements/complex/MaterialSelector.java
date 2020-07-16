package com.epam.jdi.light.angular.elements.complex;

import com.epam.jdi.light.angular.asserts.MaterialSelectorAssert;
import com.epam.jdi.light.angular.elements.composite.CdkOverlayContainer;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.complex.dropdown.DropdownExpand;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Map;

import static com.epam.jdi.light.logger.LogLevels.DEBUG;

public class MaterialSelector extends UIBaseElement<MaterialSelectorAssert> implements HasLabel {
    private static final String HINT_LOCATOR = "//*[@id='%s']/ancestor::mat-form-field//mat-hint";
    private static final String ERROR_LOCATOR = "//*[@id='%s']/ancestor::mat-form-field//mat-error";
    private static final String SMART = "smart: #";
    private static final String CSS = "css='#";
    private CdkOverlayContainer cdkOverlayContainer;
    private DropdownExpand dropdown;

    public MaterialSelector() {
        cdkOverlayContainer = new CdkOverlayContainer();
        dropdown = new DropdownExpand();
        dropdown.setCore(DropdownExpand.class, base());
    }

    private void setupLocators() {
        dropdown.expandLocator = this.uiElement.locator.printLocator().replace(SMART, "").replace(CSS, "")
                .replace("'", "");
        dropdown.valueLocator = this.uiElement.locator.printLocator().replace(SMART, "").replace(CSS, "")
                .replace("'", "");
        dropdown.listLocator = "mat-option span";
    }

    @JDIAction(level = DEBUG, timeout = 0)
    public void expand() {
        setupLocators();
        dropdown.expand();
    }

    @JDIAction(level = DEBUG, timeout = 0)
    public void collapse() {
        if (isExpanded()) {
            setupLocators();
            cdkOverlayContainer.collapsePanel();
        }
    }

    @JDIAction(value = "Is '{name}' expanded", level = DEBUG, timeout = 0)
    public boolean isExpanded() {
        setupLocators();
        cdkOverlayContainer.waitFor();
        try {
            return cdkOverlayContainer.list().noWait(WebList::isDisplayed, WebList.class);
        } catch (Exception ex) {
            return false;
        }
    }

    @JDIAction(value = "Is '{name}' collapsed", level = DEBUG, timeout = 0)
    public boolean isCollapsed() {
        return !isExpanded();
    }

    /**
     * Select the specified element by the value.
     *
     * @param value string value
     */
    @JDIAction("Select '{0}' in '{name}'")
    public void select(String value) {
        expand();
        cdkOverlayContainer.select(value);
    }

    /**
     * Select the specified element by the index.
     *
     * @param index integer value
     */
    @JDIAction("Select '{0}' in '{name}'")
    public void select(int index) {
        expand();
        cdkOverlayContainer.select(index);
    }

    @JDIAction("Check that '{name}' is displayed")
    public String selected() {
        setupLocators();
        return dropdown.selected();
    }

    @JDIAction("Is '{0}' selected")
    public boolean selected(String option) {
        setupLocators();
        return dropdown.selected(option);
    }

    /**
     * Multiple select the specified elements by the value.
     *
     * @param values string values
     */
    @JDIAction("Select {0} for '{name}'")
    public void multipleSelect(final String... values) {
        expand();
        cdkOverlayContainer.multipleSelect(values);
    }

    /**
     * Multiple select the specified elements by the index.
     *
     * @param values int values
     */
    @JDIAction("Select {0} for '{name}'")
    public void multipleSelect(final int... values) {
        expand();
        cdkOverlayContainer.multipleSelect(values);
    }

    /**
     * Get the available selector values.
     *
     * @return List<String> list of available values
     */
    @JDIAction("Get '{name}' values")
    public List<String> values() {
        expand();
        return cdkOverlayContainer.values();
    }

    /**
     * Get the available selector groups.
     *
     * @return List<String> list of available groups
     */
    @JDIAction("Get '{name}' groups")
    public List<String> groups() {
        expand();
        return cdkOverlayContainer.getGroups();
    }

    /**
     * Get the available selector groups and options.
     *
     * @return Map<String, List < String>> map of available groups and options
     */
    @JDIAction("Get '{name}' groups and options")
    public Map<String, List<String>> groupsAndOptions() {
        expand();
        return cdkOverlayContainer.getMapGroupsAndOptions();
    }

    /**
     * Get the list of enabled elements.
     *
     * @return List<String> enabled values
     */
    @JDIAction("Get '{name}' enabled values")
    public List<String> listEnabled() {
        expand();
        return cdkOverlayContainer.listEnabled();
    }

    /**
     * Get the list of disabled elements.
     *
     * @return List<String> disabled values
     */
    @JDIAction("Get '{name}' disabled values")
    public List<String> listDisabled() {
        expand();
        return cdkOverlayContainer.listDisabled();
    }

    /**
     * Check the element background has a color with the specified parameters.
     *
     * @param red   decimal representation of color Red of the form rgba(R,G,B,a)
     * @param green decimal representation of color Green of the form rgba(R,G,B,a)
     * @param blue  decimal representation of color Blue of the form rgba(R,G,B,a)
     * @param a     opacity of the color of the form rgba(R,G,B,a)
     * @return boolean is background has a specified color
     */
    @JDIAction("Check that rgba({0}, {1}, {2}, {3}) is the specified color")
    public boolean color(final int red, final int green, final int blue, final double a) {
        expand();
        return cdkOverlayContainer.color(red, green, blue, a);
    }

    /**
     * Ui hint message element.
     *
     * @return UIElement with hint text
     */
    public UIElement hint() {
        return new UIElement(By.xpath(String.format(HINT_LOCATOR,
                                                    this.uiElement.locator.printLocator().replace(SMART, "")
                                                            .replace(CSS, "").replace("'", ""))));
    }

    /**
     * Ui error message element.
     *
     * @return UIElement with error text
     */
    public UIElement error() {
        return new UIElement(By.xpath(String.format(ERROR_LOCATOR,
                                                    this.uiElement.locator.printLocator().replace(SMART, "")
                                                            .replace(CSS, "").replace("'", ""))));
    }

    @Override
    public MaterialSelectorAssert is() {
        return new MaterialSelectorAssert().set(this);
    }
}
