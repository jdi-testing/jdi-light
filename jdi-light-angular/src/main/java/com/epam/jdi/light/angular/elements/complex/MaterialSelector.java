package com.epam.jdi.light.angular.elements.complex;

import com.epam.jdi.light.angular.asserts.MaterialSelectorAssert;
import com.epam.jdi.light.angular.elements.composite.MaterialSelectorContainer;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.dropdown.DropdownExpand;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Map;

import static com.epam.jdi.light.logger.LogLevels.DEBUG;

/**
 * To see an example of MaterialSelector web element please visit https://material.angular.io/components/select/overview.
 */

public class MaterialSelector extends UIBaseElement<MaterialSelectorAssert> implements HasLabel {
    public String toggle = "//*[@id='%s']//div[contains(@class,'mat-select-arrow')][not(contains(@class, 'wrapper'))]";
    public String hintLocator = "//*[@id='%s']/ancestor::mat-form-field//mat-hint";
    public String errorLocator = "//*[@id='%s']/ancestor::mat-form-field//mat-error";
    public String smart = "smart: ";
    public String smartSharp = "smart: #";
    public String cssSharp = "css='#";
    protected MaterialSelectorContainer cdkOverlayContainer;
    protected DropdownExpand dropdown;

    public MaterialSelector() {
        cdkOverlayContainer = new MaterialSelectorContainer();
        dropdown = new DropdownExpand();
        dropdown.setCore(DropdownExpand.class, base());
    }

    protected void setupLocators() {
        dropdown.expandLocator = this.core().locator.printLocator().replace(smart, "").replace(cssSharp, "")
                .replace("'", "");
        dropdown.valueLocator = this.core().locator.printLocator().replace(smart, "").replace(cssSharp, "")
                .replace("'", "");
        dropdown.listLocator = "mat-option span";
    }

    @JDIAction(level = DEBUG, timeout = 0)
    public void expand() {
        setupLocators();
        toggle().click();
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
        return this.hasAttribute("aria-owns");
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

    /**
     * Get selected element value.
     *
     * @return String selected value
     */
    @JDIAction("Get '{name}' selected value")
    public String selected() {
        setupLocators();
        return dropdown.selected();
    }

    /**
     * Checks selected element value.
     *
     * @param value element as string
     * @return boolean is value selected
     */
    @JDIAction("Is '{0}' selected")
    public boolean selected(String value) {
        setupLocators();
        return dropdown.selected(value);
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
     * @param indexes integer values
     */
    @JDIAction("Select {0} for '{name}'")
    public void multipleSelect(final int... indexes) {
        expand();
        cdkOverlayContainer.multipleSelect(indexes);
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
        return new UIElement(By.xpath(format(hintLocator,
                                                    this.core().locator.printLocator().replace(smartSharp, "")
                                                            .replace(cssSharp, "").replace("'", ""))));
    }

    /**
     * Ui error message element.
     *
     * @return UIElement with error text
     */
    public UIElement error() {
        return new UIElement(By.xpath(format(errorLocator,
                                                    this.core().locator.printLocator().replace(smartSharp, "")
                                                            .replace(cssSharp, "").replace("'", ""))));
    }

    @Override
    public MaterialSelectorAssert is() {
        return new MaterialSelectorAssert().set(this);
    }

    protected UIElement toggle() {
        return new UIElement(By.xpath(format(toggle,
                                                    this.core().locator.printLocator().replace(smartSharp, "")
                                                            .replace(cssSharp, "").replace("'", ""))));
    }
}
