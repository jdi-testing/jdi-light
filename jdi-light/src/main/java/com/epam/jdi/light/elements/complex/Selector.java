package com.epam.jdi.light.elements.complex;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.SetValue;
import org.apache.logging.log4j.util.Strings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.logger.LogLevels.DEBUG;
import static com.epam.jdi.tools.EnumUtils.getEnumValues;
import static com.epam.jdi.tools.LinqUtils.ifSelect;
import static com.epam.jdi.tools.LinqUtils.map;
import static com.epam.jdi.tools.PrintUtils.print;
import static java.util.Arrays.asList;

public class Selector extends UIBaseElement<UISelectAssert> implements ISelector, SetValue {
    public static By LABEL_LOCATOR = By.xpath(".//label[text()='%s']");
    protected Select select() {
        return core().select();
    }

    /**
     * Selects the value based on its visible text
     * @param value String to search
     */
    @JDIAction("Select '{0}' in '{name}'")
    public void select(String value) {
        select().selectByVisibleText(value);
    }

    /**
     * Selects the value based on its index
     * @param index int to search
     */
    @JDIAction("Select '{0}' in '{name}'")
    public void select(int index) {
        select().selectByIndex(index-1);
    }

    /**
     * Check that only particular elements are selected
     * @param values String var arg, elements with text to select
     */
    @JDIAction("Check '{0}' for '{name}'")
    public void check(String... values) {
        select().deselectAll();
        for (String value : values)
            select().selectByVisibleText(value);
    }

    /**
     * Check the particular element is selected
     * @param values String var arg, element with text to select
     */
    @JDIAction("Check '{0}' for '{name}'")
    public void check(String values) {
        if (Strings.isEmpty(values)) return;
        check(values.split(","));
    }

    /**
     * Unselects only particular elements
     * @param values String var arg, elements with text to unselect
     */
    @JDIAction("Uncheck '{0}' for '{name}'")
    public void uncheck(String... values) {
        for (WebElement opt : select().getOptions()) {
            if (opt.isSelected() && asList(values).contains(opt.getText())
                || !opt.isSelected() && !asList(values).contains(opt.getText()))
                opt.click();
        }
    }
    public <TEnum extends Enum> void check(TEnum... values) {
        check(getEnumValues(values));
    }
    public <TEnum extends Enum> void uncheck(TEnum... values) {
        uncheck(getEnumValues(values));
    }

    /**
     * Checks particular elements by index
     * @param values int var arg, ids to check
     */
    @JDIAction("Check '{0}' for '{name}'")
    public void check(int... values) {
        select().deselectAll();
        for (int index : values)
            select(index);
    }

    /**
     * Unchecks particular elements by index
     * @param values int var arg, ids to uncheck
     */
    @JDIAction("Uncheck '{0}' for '{name}'")
    public void uncheck(int... values) {
        List<WebElement> options = select().getOptions();
        for (int i = 0; i < options.size(); i++) {
            WebElement opt = options.get(i);
            if (opt.isSelected() && asList(values).contains(i)
                    || !opt.isSelected() && !asList(values).contains(i))
                opt.click();
        }
    }

    /**
     * Get checked elements
     * @return List
     */
    @JDIAction("Get checked elements")
    public List<String> checked() {
        return map(select().getAllSelectedOptions(), WebElement::getText);
    }

    /**
     * Get selected element value
     * @return String
     */
    @JDIAction("Get selected value")
    public String selected() {
        return select().getFirstSelectedOption().getText();
    }
    @JDIAction("Is '{0}' selected")
    public boolean selected(String value) {
        return core().locator.isTemplate()
            ? new UIElement(core().get(value)).isSelected()
            : selected().trim().equalsIgnoreCase(value.trim());
    }

    /**
     * Gets attribute 'placeholder'
     * @return String
     */
    @JDIAction(value = "Get '{name}' placeholder", level = DEBUG)
    public String placeholder() { return core().attr("placeholder"); }

    /**
     * Get the elements values
     * @return List
     */
    @JDIAction(level = DEBUG)
    public List<String> values() {
        return map(select().getOptions(), WebElement::getText);
    }

    /**
     * Get the elements values
     * @return List
     */
    @JDIAction(level = DEBUG)
    public List<String> innerValues() {
        return map(select().getOptions(), w -> $(w).innerText());
    }
    public int size() { return select().getOptions().size(); }

    /**
     * Get the list of enabled elements
     * @return List
     */
    @JDIAction(level = DEBUG)
    public List<String> listEnabled() {
        List<UIElement> els = core().finds("option");
        return ifSelect(els, UIElement::isEnabled, UIElement::getText);
    }

    /**
     * Get the list of disabled elements
     * @return List
     */
    @JDIAction(level = DEBUG)
    public List<String> listDisabled() {
        return ifSelect(core().finds("option"),
            UIElement::isDisabled, UIElement::getText);
    }

    @Override
    public void setValue(String value) {
        if (select().isMultiple())
            check(value.split(";"));
        else select(value);
    }
    @Override
    public String getValue() {
        return select().isMultiple() ? print(checked(),";") : selected();
    }
}
