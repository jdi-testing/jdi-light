package jdisite.custom;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.complex.webList;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;

import java.util.List;

import static com.epam.jdi.light.logger.LogLevels.DEBUG;
import static com.epam.jdi.tools.LinqUtils.map;
import static org.apache.commons.lang3.StringUtils.isBlank;

public class MultiSelect extends UIListBase<UISelectAssert<?, ?>> implements HasLabel {
    @UI(".caret")
    com.epam.jdi.light.elements.common.uiElement expander;
    @UI("ul")
    com.epam.jdi.light.elements.common.uiElement valuesList;
    @UI("button")
    com.epam.jdi.light.elements.common.uiElement valueText;
    @UI("li")
    webList allValues;
    @UI("//a[label[text()='%s']]//input")
    JList<Checkbox> checkboxes;

    @JDIAction("Check '{0}' for '{name}'")
    public void check(String values) {
        if (isBlank(values)) return;
        expand();
        List<String> listNames = map(values.split(","), String::trim);
        for (String name : allValues.values()) {
            Checkbox checkbox = checkboxes.get(name);
            if (listNames.contains(name)) {
                checkbox.check();
            } else {
                checkbox.uncheck();
            }
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