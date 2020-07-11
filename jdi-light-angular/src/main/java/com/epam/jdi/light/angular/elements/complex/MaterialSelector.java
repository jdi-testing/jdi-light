package com.epam.jdi.light.angular.elements.complex;

import com.epam.jdi.light.angular.elements.composite.CdkOverlayContainer;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;

import java.util.List;
import java.util.Map;

public class MaterialSelector extends Dropdown {
    private static final String HINT_LOCATOR = "//*[@id='%s']/ancestor::mat-form-field//mat-hint";
    private static final String ERROR_LOCATOR = "//*[@id='%s']/ancestor::mat-form-field//mat-error";
    private CdkOverlayContainer cdkOverlayContainer;

    public MaterialSelector() {
        cdkOverlayContainer = new CdkOverlayContainer();
        listLocator = "mat-option span";
    }

    /**
     * Get the available selector groups.
     *
     * @return List<String> list of available groups
     */
    public List<String> groups() {
        super.expand();
        List<String> list = cdkOverlayContainer.getGroups();
        super.expander().click(pointOutsidePanel().getX(), pointOutsidePanel().getY());
        return list;
    }

    /**
     * Get the available selector groups and options.
     *
     * @return Map<String, List<String>> map of available groups and options
     */
    public Map<String, List<String>> groupsAndOptions() {
        super.expand();
        Map<String, List<String>> map = cdkOverlayContainer.getMapGroupsAndOptions();
        super.expander().click(pointOutsidePanel().getX(), pointOutsidePanel().getY());
        return map;
    }

    /**
     * Get the available selector values.
     *
     * @return List<String> list of available values
     */
    @JDIAction("Get '{name}' values")
    @Override
    public List<String> values() {
        super.expand();
        List<String> values = super.values();
        super.expander().click(pointOutsidePanel().getX(), pointOutsidePanel().getY());
        return values;
    }

    /**
     * Multiple select the specified elements by the value.
     *
     * @param values string values
     */
    public void multipleSelect(final String... values) {
        super.expand();
        super.list().select(values);
        super.expander().click(pointOutsidePanel().getX(), pointOutsidePanel().getY());
    }

    /**
     * Multiple select the specified elements by the index.
     *
     * @param values int values
     */
    public void multipleSelect(final int... values) {
        super.expand();
        super.list().select(values);
        super.expander().click(pointOutsidePanel().getX(), pointOutsidePanel().getY());
    }

    /**
     * Ui hint message element.
     *
     * @return UIElement with hint text
     */
    public UIElement hint() {
        return new UIElement(By.xpath(String.format(HINT_LOCATOR,
                                                    this.uiElement.locator.printLocator().replace("css='#", "")
                                                            .replace("'", ""))));
    }

    /**
     * Ui error message element.
     *
     * @return UIElement with error text
     */
    public UIElement error() {
        return new UIElement(By.xpath(String.format(ERROR_LOCATOR,
                                                    this.uiElement.locator.printLocator().replace("css='#", "")
                                                            .replace("'", ""))));
    }

    /**
     * Check the element background has a color with the specified parameters.
     *
     * @param red decimal representation of color Red of the form rgba(R,G,B,a)
     * @param green decimal representation of color Green of the form rgba(R,G,B,a)
     * @param blue decimal representation of color Blue of the form rgba(R,G,B,a)
     * @param a opacity of the color of the form rgba(R,G,B,a)
     * @return boolean is background has a specified color
     */
    @JDIAction("Check that rgba({0}, {1}, {2}, {3}) is the specified color")
    public boolean hasColor(final int red, final int green, final int blue, final double a) {
        expand();
        visibleExpander().waitFor();
        boolean hasColor = expandedSelector().css("background-color")
                .equalsIgnoreCase("rgba(" + red + ", " + green + ", " + blue + ", " + a + ")");
        expandedSelector().core().click(pointOutsidePanel().getX(), pointOutsidePanel().getY());
        return hasColor;
    }

    private UIElement visibleExpander() {
        return cdkOverlayContainer.getBackdropShowingPanel();
    }

    private UIElement expandedSelector() {
        return cdkOverlayContainer.getBackdropSelectPanel();
    }

    private Point pointOutsidePanel() {
        return cdkOverlayContainer.getPointOutsideBackdropSelectPanel();
    }
}
