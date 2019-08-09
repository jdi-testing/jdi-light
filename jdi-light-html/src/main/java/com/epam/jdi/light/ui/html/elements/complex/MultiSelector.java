package com.epam.jdi.light.ui.html.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static com.epam.jdi.tools.EnumUtils.getEnumValues;
import static com.epam.jdi.tools.LinqUtils.map;
import static java.util.Arrays.asList;

// Implements TextField + Droplist
// https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_datalist
public class MultiSelector extends Combobox {
    protected Select asSelect() {
        return core().asSelect();
    }
    @JDIAction("Check '{0}' for '{name}'")
    public void check(String... values) {
        asSelect().deselectAll();
        for (String value : values)
            select(value);
    }
    @Override
    public void select(String value) {
        ds().select(value);
    }
    public <TEnum extends Enum> void check(TEnum... values) {
        check(getEnumValues(values));
    }
    @JDIAction("Check '{0}' for '{name}'")
    public void check(int... values) {
        asSelect().deselectAll();
        for (int index : values)
            select(index);
    }

    @Override
    public void select(int index) {
        ds().select(index);
    }
    @JDIAction("Uncheck '{0}' for '{name}'")
    public void uncheck(String... values) {
        for (WebElement opt : asSelect().getOptions()) {
            if (opt.isSelected() && asList(values).contains(opt.getText())
                    || !opt.isSelected() && !asList(values).contains(opt.getText()))
                opt.click();
        }
    }
    public <TEnum extends Enum> void uncheck(TEnum... values) {
        uncheck(getEnumValues(values));
    }
    @JDIAction("Uncheck '{0}' for '{name}'")
    public void uncheck(int... values) {
        List<WebElement> options = asSelect().getOptions();
        for (int i = 0; i < options.size(); i++) {
            WebElement opt = options.get(i);
            if (opt.isSelected() && asList(values).contains(i)
                    || !opt.isSelected() && !asList(values).contains(i))
                opt.click();
        }
    }
    @JDIAction("Get checked elements")
    public List<String> checked() {
        return map(asSelect().getAllSelectedOptions(), WebElement::getText);
    }

}
