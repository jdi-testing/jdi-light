package com.epam.jdi.light.ui.html.base;

import com.epam.jdi.light.elements.base.BaseUIElement;
import com.epam.jdi.light.ui.html.asserts.DropdownAssert;
import com.epam.jdi.light.ui.html.complex.Combobox;
import com.epam.jdi.light.ui.html.complex.DataList;
import com.epam.jdi.light.ui.html.complex.Dropdown;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.epam.jdi.tools.LinqUtils.ifSelect;
import static com.epam.jdi.tools.LinqUtils.map;

public class HtmlBaseSelector extends BaseUIElement {
    public List<String> values() { return map(select().getOptions(), WebElement::getText); }

    @Override
    public void setValue(String value) { select(value); }

    public List<String> enabled() { return ifSelect(getUI().find("option").allUI(),
            BaseUIElement::isEnabled, BaseUIElement::getText);
    }
    public List<String> disabled() { return ifSelect(getUI().find("option").allUI(),
            uiElement -> !uiElement.isEnabled(), BaseUIElement::getText);
    }

}
