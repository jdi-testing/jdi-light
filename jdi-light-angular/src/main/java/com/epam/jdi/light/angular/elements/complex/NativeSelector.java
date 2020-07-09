package com.epam.jdi.light.angular.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.ui.html.elements.complex.MultiSelector;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NativeSelector extends MultiSelector {
    private static final String GROUPS_AND_OPTIONS_LIST = "optgroup";
    private static final String HINT_LOCATOR = "//*[@id='%s']/ancestor::mat-form-field//mat-hint";
    private static final String ERROR_LOCATOR = "//*[@id='%s']/ancestor::mat-form-field//mat-error";

    /**
     * Get the available selector groups.
     *
     * @return List<String> list of available groups
     */
    @JDIAction("Get '{name}' groups")
    public List<String> groups() {
        List<String> groups = new ArrayList<>();
        WebList webList = new WebList(By.cssSelector(GROUPS_AND_OPTIONS_LIST));
        int groupSize = webList.values().size();
        for (int i = 0; i < groupSize; i++) {
            groups.add(String.valueOf(webList.attrs("label").get(i)));
        }
        return groups;
    }

    /**
     * Get the available selector groups and options.
     *
     * @return Map<String, List<String>> map of available groups and options
     */
    @JDIAction("Get '{name}' groups and options")
    public Map<String, List<String>> groupsAndOptions() {
        Map<String, List<String>> map = new LinkedHashMap<>();
        WebList webList = new WebList(By.cssSelector(GROUPS_AND_OPTIONS_LIST));
        int groupSize = webList.values().size();
        for (int i = 0; i < groupSize; i++) {
            String stringGroupsAndOptions = webList.values().get(i);
            List<String> listGroupsAndOptions = Stream.of(stringGroupsAndOptions.split("\n"))
                    .collect(Collectors.toCollection(ArrayList::new));
            String key = String.valueOf(webList.attrs("label").get(i));
            map.put(key, listGroupsAndOptions);
        }
        return map;
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
}
