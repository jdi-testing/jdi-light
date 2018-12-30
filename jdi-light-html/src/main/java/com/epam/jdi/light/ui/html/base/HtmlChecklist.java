package com.epam.jdi.light.ui.html.base;

import com.epam.jdi.light.asserts.BaseSelectorAssert;
import com.epam.jdi.light.asserts.SelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.complex.Selector;
import com.epam.jdi.light.ui.html.complex.Checklist;
import com.epam.jdi.tools.EnumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.epam.jdi.light.driver.WebDriverByUtils.fillByTemplate;
import static com.epam.jdi.light.ui.html.HtmlFactory.$;
import static com.epam.jdi.tools.EnumUtils.getEnumValues;
import static com.epam.jdi.tools.LinqUtils.*;
import static com.epam.jdi.tools.PrintUtils.print;
import static java.util.Arrays.asList;
import static org.openqa.selenium.By.cssSelector;

public class HtmlChecklist extends Selector implements BaseSelectorAssert, Checklist {
    By checkbox = cssSelector("input[type=checkbox][id='%s']");
    By label = By.xpath(".//label[text()='%s']");
    private String getId(String name) { return label(name).getAttribute("for"); }
    public HtmlElement get(String name) { return
            $(fillByTemplate(checkbox, getId(name)), parent).setName("checkboxes");
    }
    private HtmlElement label(String name) {
        return $(fillByTemplate(label, name), parent).setName("label");
    }


    public HtmlChecklist() { }
    public HtmlChecklist(WebElement el) { super(el); }
    List<UIElement> labels() {
        return map(getAll(), el -> new HtmlElement(el).label());
    }
    List<HtmlElement> checkboxes() { return map(getAll(), HtmlElement::new); }

    /**
     * Select values from parameters
     * @param names String var arg, elements with text to select
     */
    @JDIAction
    @Override
    public void select(String... names) {
        for (String name : names) {
            HtmlElement value = get(name);
            if (value.isEnabled())
                value.click();
        }
    }
    @JDIAction
    public <TEnum extends Enum> void select(TEnum... value) {
        select(toStringArray(map(value, EnumUtils::getEnumValue)));
    }

    /**
     * Selects only particular elements
     * @param indexes String var arg, elements with text to select
     */
    @JDIAction
    public void select(int... indexes) {
        for (int i = 1; i <= indexes.length; i++) {
            HtmlElement value = checkboxes().get(indexes[i]);
            if (value.isEnabled())
                value.click();
        }
    }

    /**
     * Selects only particular elements
     * @param names String var arg, elements with text to select
     */
    @JDIAction
    public void check(String... names) {
        List<String> listNames = asList(names);
        for (String name : values()) {
            HtmlElement value = get(name);
            if (value.isDisabled()) continue;
            if (value.isSelected() && !listNames.contains(value.labelText().trim())
                    || !value.isSelected() && listNames.contains(value.labelText().trim()))
                value.click();
        }
    }

    /**
     * Unselects only particular elements
     * @param names String var arg, elements with text to unselect
     */
    @JDIAction
    public void uncheck(String... names) {
        List<String> listNames = asList(names);
        for (String name : values()) {
            HtmlElement value = get(name);
            if (value.isDisabled()) continue;
            if (value.isSelected() && listNames.contains(value.labelText().trim())
                    || !value.isSelected() && !listNames.contains(value.labelText().trim()))
                value.click();
        }
    }
    @JDIAction
    public <TEnum extends Enum> void check(TEnum... values) {
        check(getEnumValues(values));
    }

    @JDIAction
    public <TEnum extends Enum> void uncheck(TEnum... values) {
        uncheck(getEnumValues(values));
    }

    /**
     * Checks particular elements by index
     * @param indexes int var arg, ids to check
     */
    @JDIAction
    public void check(int... indexes) {
        List<Integer> listIndexes = toList(indexes);
        for (int i = 1; i <= values().size(); i++) {
            HtmlElement value = checkboxes().get(i-1);
            if (value.isDisabled()) continue;
            if (value.isSelected() && !listIndexes.contains(i)
                    || !value.isSelected() && listIndexes.contains(i))
                value.click();
        }
    }

    /**
     * Unchecks particular elements by index
     * @param indexes int var arg, ids to uncheck
     */
    @JDIAction
    public void uncheck(int... indexes) {
        List<Integer> listIndexes = toList(indexes);
        for (int i = 1; i <= values().size(); i++) {
            HtmlElement value = checkboxes().get(i-1);
            if (value.isDisabled()) continue;
            if (value.isSelected() && listIndexes.contains(i)
                    || !value.isSelected() && !listIndexes.contains(i))
                value.click();
        }
    }

    @JDIAction
    public List<String> checked() {
        return ifSelect(checkboxes(), HtmlElement::isSelected, HtmlElement::labelText);
    }

    @JDIAction
    public void select(String value) {
        select(new String[]{value});
    }

    @JDIAction
    public void select(int index) {
        select(new int[]{index});
    }

    @JDIAction
    public List<String> values() {
        return map(labels(), element -> element.getText().trim());
    }

    @JDIAction
    public List<String> enabled() {
        return ifSelect(checkboxes(),
                HtmlElement::isEnabled,
                HtmlElement::labelText);
    }
    @JDIAction
    public List<String> disabled() {
        return ifSelect(checkboxes(),
                HtmlElement::isDisabled,
                HtmlElement::labelText);
    }

    @Override
    public void setValue(String value) {
        check(value.split(";"));
    }
    @JDIAction
    @Override
    public String selected() {
        return print(ifSelect(checkboxes(), HtmlElement::isSelected, HtmlElement::labelText));
    }

    @JDIAction
    public boolean selected(String value) {
        return get(value).isSelected();
    }
    @Override
    public String getValue() {
        return selected();
    }

    public SelectAssert is() {
        return new SelectAssert(this);
    }
    public SelectAssert assertThat() {
        return is();
    }

}
