package com.epam.jdi.light.angular.elements.composite;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Section;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CdkOverlayContainer extends Section {
    private static final String BACKDROP_SHOWING_PANEL = "div[class*=cdk-overlay-backdrop-showing]";
    private static final String BACKDROP_SELECT_PANEL = "div.mat-select-panel.mat-primary";
    private static final String GROUPS_AND_OPTIONS_LIST = "div.mat-select-panel.mat-primary mat-optgroup";
    private static final String OPTION_SPAN = "mat-option span";
    private static final String OPTIONS = "mat-option";

    public WebList list() {
        return getOptions();
    }

    /**
     * Select the specified element by the value.
     *
     * @param value string value
     */
    @JDIAction("Select {0} for '{name}'")
    public void select(String value) {
        WebList options = getOptions();
        options.get(value).click();
    }

    /**
     * Select the specified element by the index.
     *
     * @param index integer value
     */
    @JDIAction("Select '{0}' in '{name}'")
    public void select(int index) {
        WebList options = getOptions();
        options.get(index).click();
    }

    /**
     * Select the specified elements by the value.
     *
     * @param values string values
     */
    @JDIAction("Select {0} for '{name}'")
    public void multipleSelect(String... values) {
        WebList options = getOptions();
        for (String str : values) {
            options.get(str).click();
        }
        collapsePanel();
    }

    /**
     * Select the specified elements by the index.
     *
     * @param indexes integer indexes
     */
    @JDIAction("Select {0} for '{name}'")
    public void multipleSelect(int... indexes) {
        WebList options = getOptions();
        for (int index : indexes) {
            options.get(index).click();
        }
        collapsePanel();
    }

    /**
     * Get the elements values.
     *
     * @return List<String> values
     */
    @JDIAction("Get '{name}' values")
    public List<String> values() {
        List<String> values = new ArrayList<>();
        WebList options = getOptions(OPTION_SPAN);
        options.forEach(option -> values.add(option.getValue()));
        collapsePanel();
        return values;
    }

    private WebList getOptions() {
        return new WebList(By.cssSelector(OPTION_SPAN));
    }

    private WebList getOptions(String css) {
        return new WebList(By.cssSelector(css));
    }

    /**
     * Get the available selector groups.
     *
     * @return List<String> list of available groups
     */
    @JDIAction("Get '{name}' groups")
    public List<String> getGroups() {
        List<String> groups = new ArrayList<>();
        WebList webList = new WebList(By.cssSelector(GROUPS_AND_OPTIONS_LIST));
        int groupSize = webList.values().size();
        for (int i = 0; i < groupSize; i++) {
            String stringGroupsAndOptions = webList.values().get(i);
            List<String> listGroupsAndOptions = Stream.of(stringGroupsAndOptions.split("\n"))
                    .collect(Collectors.toCollection(ArrayList::new));
            groups.add(listGroupsAndOptions.get(0));
        }
        collapsePanel();
        return groups;
    }

    /**
     * Get the available selector groups and options.
     *
     * @return Map<String, List < String>> map of available groups and options
     */
    @JDIAction("Get '{name}' groups and options")
    public Map<String, List<String>> getMapGroupsAndOptions() {
        Map<String, List<String>> map = new LinkedHashMap<>();
        WebList webList = new WebList(By.cssSelector(GROUPS_AND_OPTIONS_LIST));
        int groupSize = webList.values().size();
        for (int i = 0; i < groupSize; i++) {
            String stringGroupsAndOptions = webList.values().get(i);
            List<String> listGroupsAndOptions = Stream.of(stringGroupsAndOptions.split("\n"))
                    .collect(Collectors.toCollection(ArrayList::new));
            String key = listGroupsAndOptions.remove(0);
            map.put(key, listGroupsAndOptions);
        }
        collapsePanel();
        return map;
    }

    /**
     * Get the list of enabled elements.
     *
     * @return List<String> enabled values
     */
    @JDIAction("Get '{name}' enabled values")
    public List<String> listEnabled() {
        List<String> list = getOptions(OPTIONS).stream()
                .filter(e -> !e.hasAttribute("disabled") && e.attr("aria-disabled").contains("false"))
                .map(e -> e.text().trim()).collect(Collectors.toList());
        collapsePanel();
        return list;
    }

    /**
     * Get the list of disabled elements.
     *
     * @return List<String> disabled values
     */
    @JDIAction("Get '{name}' disabled values")
    public List<String> listDisabled() {
        List<String> list = getOptions(OPTIONS).stream()
                .filter(e -> e.hasAttribute("disabled") || e.attr("aria-disabled").contains("true"))
                .map(e -> e.text().trim()).collect(Collectors.toList());
        collapsePanel();
        return list;
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
        getBackdropShowingPanel().waitFor();
        boolean hasColor = getBackdropSelectPanel().css("background-color")
                .equalsIgnoreCase("rgba(" + red + ", " + green + ", " + blue + ", " + a + ")");
        collapsePanel();
        return hasColor;
    }

    private UIElement getBackdropShowingPanel() {
        return new UIElement(By.cssSelector(BACKDROP_SHOWING_PANEL));
    }

    private UIElement getBackdropSelectPanel() {
        return new UIElement(By.cssSelector(BACKDROP_SELECT_PANEL));
    }

    private Point getPointOutsidePanel() {
        UIElement uiElement = getBackdropSelectPanel();
        return new Point(uiElement.core().getRect().getWidth() + 2, uiElement.core().getRect().getHeight() + 2);
    }

    private void collapsePanel() {
        getBackdropSelectPanel().core().click(getPointOutsidePanel().getX(), getPointOutsidePanel().getY());
    }
}
