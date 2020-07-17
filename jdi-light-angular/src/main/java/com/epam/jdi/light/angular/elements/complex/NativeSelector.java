package com.epam.jdi.light.angular.elements.complex;

import com.epam.jdi.light.angular.asserts.NativeSelectorAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.common.TextTypes;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.ui.html.elements.complex.MultiSelector;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.epam.jdi.tools.LinqUtils.map;

public class NativeSelector extends UIBaseElement<NativeSelectorAssert> implements HasLabel {
    public String groupsAndOptionsList = "optgroup";
    public String hintLocator = "//*[@id='%s']/ancestor::mat-form-field//mat-hint";
    public String errorLocator = "//*[@id='%s']/ancestor::mat-form-field//mat-error";
    public String smartSharp = "smart: #";
    public String cssSharp = "css='#";

    /**
     * Get MultiSelector wrapper.
     *
     * @return MultiSelector object
     */
    protected MultiSelector ms() {
        return new MultiSelector().setCore(MultiSelector.class, base());
    }

    /**
     * Get a list of expander items.
     *
     * @return WebList element
     */
    public WebList list() {
        return ms().list();
    }

    /**
     * Select the specified element by the value.
     *
     * @param value string value
     */
    @JDIAction("Select '{0}' in '{name}'")
    public void select(final String value) {
        ms().select(value);
    }

    /**
     * Select the specified element by the index.
     *
     * @param index integer value
     */
    @JDIAction("Select '{0}' in '{name}'")
    public void select(final int index) {
        ms().select(index);
    }

    /**
     * Get selected element value.
     *
     * @return String selected value
     */
    @JDIAction("Get '{name}' selected value")
    public String selected() {
        return ms().selected();
    }

    /**
     * Checks selected element value.
     *
     * @param value element as string
     * @return boolean is value selected
     */
    @JDIAction("Is '{0}' selected")
    public boolean selected(final String value) {
        return ms().selected(value);
    }

    /**
     * Get the available selector values.
     *
     * @return List<String> list of available values
     */
    @JDIAction("Get '{name}' values")
    public List<String> values() {
        return map(ms().list(), e -> e.getText().trim());
    }

    /**
     * Get the available selector values by text type.
     *
     * @param type TextType
     * @return List<String> list of available values
     */
    @JDIAction("Get '{name}' values")
    public List<String> values(final TextTypes type) {
        return ms().values(type);
    }

    /**
     * Get the available selector groups.
     *
     * @return List<String> list of available groups
     */
    @JDIAction("Get '{name}' groups")
    public List<String> groups() {
        List<String> groups = new ArrayList<>();
        WebList webList = new WebList(By.cssSelector(groupsAndOptionsList));
        int groupSize = webList.values().size();
        for (int i = 0; i < groupSize; i++) {
            groups.add(String.valueOf(webList.attrs("label").get(i)));
        }
        return groups;
    }

    /**
     * Get the available selector groups and options.
     *
     * @return Map<String, List < String>> map of available groups and options
     */
    @JDIAction("Get '{name}' groups and options")
    public Map<String, List<String>> groupsAndOptions() {
        Map<String, List<String>> map = new LinkedHashMap<>();
        WebList webList = new WebList(By.cssSelector(groupsAndOptionsList));
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
     * Get the list of enabled elements.
     *
     * @return List<String> enabled values
     */
    @JDIAction("Get '{name}' enabled values")
    public List<String> listEnabled() {
        return list().stream().filter(e -> !e.hasAttribute("disabled")).map(e -> e.text().trim())
                .collect(Collectors.toList());
    }

    /**
     * Get the list of disabled elements.
     *
     * @return List<String> disabled values
     */
    @JDIAction("Get '{name}' disabled values")
    public List<String> listDisabled() {
        return list().stream().filter(e -> e.hasAttribute("disabled")).map(e -> e.text().trim())
                .collect(Collectors.toList());
    }

    @Override
    public NativeSelectorAssert is() {
        return new NativeSelectorAssert().set(this);
    }

    /**
     * Ui hint message element.
     *
     * @return UIElement with hint text
     */
    public UIElement hint() {
        return new UIElement(By.xpath(String.format(hintLocator,
                                                    this.uiElement.locator.printLocator().replace(smartSharp, "")
                                                            .replace(cssSharp, "").replace("'", ""))));
    }

    /**
     * Ui error message element.
     *
     * @return UIElement with error text
     */
    public UIElement error() {
        return new UIElement(By.xpath(String.format(errorLocator,
                                                    this.uiElement.locator.printLocator().replace(smartSharp, "")
                                                            .replace(cssSharp, "").replace("'", ""))));
    }
}
