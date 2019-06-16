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
    protected Select select() {
        return core().select();
    }
    @JDIAction("Check '{0}' for '{name}'")
    public void check(String... values) {
        select().deselectAll();
        for (String value : values)
            core().select().selectByVisibleText(value);
    }
    public <TEnum extends Enum> void check(TEnum... values) {
        check(getEnumValues(values));
    }
    @JDIAction("Check '{0}' for '{name}'")
    public void check(int... values) {
        select().deselectAll();
        for (int index : values)
            select(index);
    }
    @JDIAction("Uncheck '{0}' for '{name}'")
    public void uncheck(String... values) {
        for (WebElement opt : select().getOptions()) {
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
        List<WebElement> options = select().getOptions();
        for (int i = 0; i < options.size(); i++) {
            WebElement opt = options.get(i);
            if (opt.isSelected() && asList(values).contains(i)
                    || !opt.isSelected() && !asList(values).contains(i))
                opt.click();
        }
    }
    @JDIAction("Get selected value") @Override
    public String selected() {
        return select().getFirstSelectedOption().getText();
    }
    @JDIAction("Get checked elements")
    public List<String> checked() {
        return map(select().getAllSelectedOptions(), WebElement::getText);
    }

}
