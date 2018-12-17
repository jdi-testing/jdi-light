package com.epam.jdi.light.elements.complex;

import com.epam.jdi.light.asserts.BaseSelectorAssert;
import com.epam.jdi.light.asserts.SelectAssert;
import com.epam.jdi.light.elements.base.UIElement;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.epam.jdi.tools.EnumUtils.getEnumValues;
import static com.epam.jdi.tools.LinqUtils.ifSelect;
import static com.epam.jdi.tools.LinqUtils.map;
import static com.epam.jdi.tools.PrintUtils.print;
import static java.util.Arrays.asList;

public class Selector extends UIElement implements BaseSelectorAssert {

    public Selector() { }
    public Selector(WebElement el) { super(el); }

    /**
     * Selects the value based on its visible text
     * @param value String to search
     */
    @Override
    public void select(String value) {
        select().selectByVisibleText(value);
    }

    /**
     * Selects the value based on its index
     * @param index int to search
     */
    public void select(int index) {
        select().selectByIndex(index-1);
    }

    /**
     * Selects only particular elements
     * @param values String var arg, elements with text to select
     */
    public void check(String... values) {
        select().deselectAll();
        for (String value : values)
            select().selectByVisibleText(value);
    }

    /**
     * Unselects only particular elements
     * @param values String var arg, elements with text to unselect
     */
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
    public void check(int... values) {
        select().deselectAll();
        for (int index : values)
            select(index);
    }

    /**
     * Unchecks particular elements by index
     * @param values int var arg, ids to uncheck
     */
    public void uncheck(int... values) {
        List<WebElement> options = select().getOptions();
        for (int i = 0; i < options.size(); i++) {
            WebElement opt = options.get(i);
            if (opt.isSelected() && asList(values).contains(i)
                    || !opt.isSelected() && !asList(values).contains(i))
                opt.click();
        }
    }

    public List<String> checked() {
        return map(select().getAllSelectedOptions(), WebElement::getText);
    }
    public String selected() {
        return select().getFirstSelectedOption().getText();
    }
    public boolean selected(String value) {
        return selected().trim().equalsIgnoreCase(value.trim());
    }

    /**
     * Gets attr 'placeholder'
     * @return String
     */
    public String placeholder() { return getAttribute("placeholder"); }

    public List<String> values() {
        return map(select().getOptions(), WebElement::getText);
    }

    public List<String> enabled() {
        return ifSelect(getUI().finds("option"),
            UIElement::isEnabled, UIElement::getText);
    }
    public List<String> disabled() {
        return ifSelect(getUI().finds("option"),
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

    public SelectAssert is() {
        return new SelectAssert(this);
    }
    public SelectAssert assertThat() {
        return is();
    }

}
