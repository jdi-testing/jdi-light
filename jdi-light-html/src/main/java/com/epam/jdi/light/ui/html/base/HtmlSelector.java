package com.epam.jdi.light.ui.html.base;

import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.ui.html.asserts.BaseSelectorAssert;
import com.epam.jdi.light.ui.html.asserts.SelectAssert;
import com.epam.jdi.light.ui.html.common.Title;
import com.epam.jdi.light.ui.html.complex.Combobox;
import com.epam.jdi.light.ui.html.complex.DataList;
import com.epam.jdi.light.ui.html.complex.Dropdown;
import com.epam.jdi.light.ui.html.complex.MultiSelect;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.tools.EnumUtils.getEnumValues;
import static com.epam.jdi.tools.LinqUtils.ifSelect;
import static com.epam.jdi.tools.LinqUtils.map;
import static com.epam.jdi.tools.PrintUtils.print;
import static java.util.Arrays.asList;

public class HtmlSelector extends UIElement implements BaseSelectorAssert, Dropdown, DataList, Combobox, MultiSelect {

    public HtmlSelector() { }
    public HtmlSelector(WebElement el) { super(el); }

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
        select().selectByIndex(index);
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
            select().selectByIndex(index);
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
    public String placeholder() { return getAttribute("placeholder"); }

    public List<String> values() {
        return map(select().getOptions(), WebElement::getText);
    }

    public List<String> enabled() { return ifSelect(getUI().find("option").allUI(),
            UIElement::isEnabled, UIElement::getText);
    }
    public List<String> disabled() { return ifSelect(getUI().find("option").allUI(),
            uiElement -> !uiElement.isEnabled(), UIElement::getText);
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

    public Title label() {
        return (Title) $("[for="+getAttribute("ïd")+"]");
    }
}
