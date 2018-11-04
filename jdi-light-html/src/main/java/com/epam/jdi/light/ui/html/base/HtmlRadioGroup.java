package com.epam.jdi.light.ui.html.base;

import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.ui.html.asserts.BaseSelectorAssert;
import com.epam.jdi.light.ui.html.asserts.SelectAssert;
import com.epam.jdi.light.ui.html.complex.RadioButtons;
import com.epam.jdi.light.ui.html.complex.RadioGroup;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.epam.jdi.light.ui.html.HtmlFactory.$;
import static com.epam.jdi.tools.EnumUtils.getEnumValue;
import static com.epam.jdi.tools.LinqUtils.*;
import static java.util.Arrays.asList;

public class HtmlRadioGroup extends UIElement implements BaseSelectorAssert, RadioGroup, RadioButtons {
    UIElement input = $("input[type='radio'][id='%s']").setParent(parent);
    UIElement label = $("label['%s']").setParent(parent);

    public HtmlRadioGroup() { }
    public HtmlRadioGroup(WebElement el) { super(el); }
    List<HtmlElement> elements() { return map(getAll(), HtmlElement::new); }

    /**
     * Selects radio based on value
     * @param value String to select
     */
    @Override
    public void select(String value) {
        label.get(value).click();
    }
    @Override
    public <TEnum extends Enum> void select(TEnum value) {
        input.get(getEnumValue(value)).click();
    }

    /**
     * Selects radio based on index
     * @param index int to select
     */
    public void select(int index) {
        getAll().get(index).click();
    }
    /**
     * Gets secleted radio
     * @return String
     */
    public String selected() {
        HtmlElement result = first(elements(), UIElement::isSelected);
        return result != null ? result.labelText() : "";
    }

    public List<String> checked() {
        return asList(selected());
    }

    public List<String> values() {
        return map(elements(), HtmlElement::labelText);
    }

    public List<String> enabled() {
        return ifSelect(elements(), UIElement::isEnabled, HtmlElement::labelText);
    }
    public List<String> disabled() {
        return ifSelect(elements(), el -> !el.isEnabled(), HtmlElement::labelText);
    }

    @Override
    public void setValue(String value) {
        select(value);
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
