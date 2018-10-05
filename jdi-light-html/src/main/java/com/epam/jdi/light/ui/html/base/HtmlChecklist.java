package com.epam.jdi.light.ui.html.base;

import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.ui.html.asserts.BaseSelectorAssert;
import com.epam.jdi.light.ui.html.asserts.SelectAssert;
import com.epam.jdi.light.ui.html.complex.*;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.tools.EnumUtils.getEnumValue;
import static com.epam.jdi.tools.EnumUtils.getEnumValues;
import static com.epam.jdi.tools.LinqUtils.*;
import static com.epam.jdi.tools.PrintUtils.print;
import static java.util.Arrays.asList;

public class HtmlChecklist extends UIElement implements BaseSelectorAssert, Checklist {
    UIElement input = $("input[type='checkbox'][id='%s']").setParent(parent);
    UIElement label = $("label['%s']").setParent(parent);

    public HtmlChecklist() { }
    public HtmlChecklist(WebElement el) { super(el); }
    List<HtmlElement> elements() { return map(getAll(), HtmlElement::new); }

    @Override
    public void select(String value) {
        label.get(value).click();
    }
    @Override
    public <TEnum extends Enum> void select(TEnum value) {
        input.get(getEnumValue(value)).click();
    }
    public void select(int index) {
        getAll().get(index).click();
    }

    public void check(String... values) {
        for (HtmlElement ui :  elements()) {
            if (ui.isSelected() && !asList(values).contains(ui.labelText())
                    || !ui.isSelected() && asList(values).contains(ui.labelText()))
                ui.click();
        }
    }
    public void uncheck(String... values) {
        for (HtmlElement ui :  elements()) {
            if (ui.isSelected() && asList(values).contains(ui.labelText())
                    || !ui.isSelected() && !asList(values).contains(ui.labelText()))
                ui.click();
        }
    }
    public <TEnum extends Enum> void check(TEnum... values) {
        check(getEnumValues(values));
    }
    public <TEnum extends Enum> void uncheck(TEnum... values) {
        uncheck(getEnumValues(values));
    }
    public void check(int... values) {
        List<UIElement> options = allUI();
        for (int i = 0; i < options.size(); i++) {
            WebElement opt = options.get(i);
            if (opt.isSelected() && !asList(values).contains(i)
                    || !opt.isSelected() && asList(values).contains(i))
                opt.click();
        }
    }
    public void uncheck(int... values) {
        List<UIElement> options = allUI();
        for (int i = 0; i < options.size(); i++) {
            WebElement opt = options.get(i);
            if (opt.isSelected() && asList(values).contains(i)
                    || !opt.isSelected() && !asList(values).contains(i))
                opt.click();
        }
    }

    public String selected() {
        return print(checked(),";");
    }

    public List<String> checked() {
        return ifSelect(elements(), UIElement::isSelected, HtmlElement::labelText);
    }

    public List<String> values() {
        return map(elements(), HtmlElement::labelText);
    }

    public List<String> enabled() {
        return ifSelect(elements(), HtmlElement::isEnabled, HtmlElement::labelText);
    }
    public List<String> disabled() {
        return ifSelect(elements(), el -> !el.isEnabled(), HtmlElement::labelText);
    }

    @Override
    public void setValue(String value) {
        check(value.split(";"));
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
