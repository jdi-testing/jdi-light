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

    /**
     * Backdrop showing panel element.
     *
     * @return UIElement an element that indicates that the backdrop panel is displayed
     */
    public UIElement getBackdropShowingPanel() {
        return new UIElement(By.cssSelector(BACKDROP_SHOWING_PANEL));
    }

    /**
     * Backdrop select panel element.
     *
     * @return UIElement an element that contains all the values that can be selected
     */
    public UIElement getBackdropSelectPanel() {
        return new UIElement(By.cssSelector(BACKDROP_SELECT_PANEL));
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
        return groups;
    }

    /**
     * Get the available selector groups and options.
     *
     * @return Map<String, List<String>> map of available groups and options
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
        return map;
    }

    /**
     * Get point outside backdrop select panel element.
     *
     * @return Point outside backdrop select panel
     */
    public Point getPointOutsideBackdropSelectPanel() {
        UIElement uiElement = getBackdropSelectPanel();
        return new Point(uiElement.core().getRect().getWidth() + 2, uiElement.core().getRect().getHeight() + 2);
    }
}
