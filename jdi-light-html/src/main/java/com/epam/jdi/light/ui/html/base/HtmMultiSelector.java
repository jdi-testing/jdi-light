package com.epam.jdi.light.ui.html.base;

import com.epam.jdi.light.ui.html.asserts.MultiSelectAssert;
import com.epam.jdi.light.ui.html.complex.MultiSelect;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.epam.jdi.tools.LinqUtils.map;
import static com.epam.jdi.tools.PrintUtils.print;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.not;

public class HtmMultiSelector extends HtmlBaseSelector implements MultiSelect {

    public void select(String... values) {
        for (String value : values)
            select().selectByVisibleText(value);
    }
    public void select(int... indexes) {
        for (int index : indexes)
            select().selectByIndex(index);
    }
    public List<String> selected() { return map(select().getAllSelectedOptions(), WebElement::getText); }

    @Override
    public void setValue(String value) { select(value.split(";")); }
    @Override
    public String getValue() { return print(selected(),";"); }

    public MultiSelectAssert is() {
        return new MultiSelectAssert(this);
    }
    public MultiSelectAssert assertThat() {
        return is();
    }
}
