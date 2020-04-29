package jdisite.custom;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

import java.util.List;

import static com.epam.jdi.light.logger.LogLevels.*;
import static com.epam.jdi.tools.LinqUtils.*;
import static org.jsoup.helper.StringUtil.*;

public class MultiSelect extends UIListBase<UISelectAssert<?,?>> implements HasLabel {
    @UI(".caret") UIElement expander;
    @UI("ul") UIElement valuesList;
    @UI("button") UIElement valueText;
    @UI("li") WebList allValues;
    @UI("input") WebList value;

    @JDIAction("Check '{0}' for '{name}'")
    public void check(String values) {
        if (isBlank(values)) return;
        expand();
        List<String> listNames = map(values.split(","), String::trim);
        for (String name : allValues.values()) {
            UIElement input = value.get(name);
            boolean valueSelected = input.isSelected();
            if (valueSelected && !listNames.contains(name)
                    || !valueSelected && listNames.contains(name))
                input.label().click();
        }
        label().click();
    }
    @JDIAction(level = DEBUG)
    private void expand() {
        if (valuesList.isHidden())
            expander.click();
    }
    @Override
    public void setValue(String value) {
        check(value);
    }

    @Override
    @JDIAction("Get '{name}' selected value")
    public String selected() {
        return valueText.getText();
    }

    @Override
    public String getValue() {
        return selected();
    }

}