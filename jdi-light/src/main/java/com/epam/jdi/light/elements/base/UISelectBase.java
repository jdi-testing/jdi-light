package com.epam.jdi.light.elements.base;

import com.epam.jdi.light.asserts.IHasAssert;
import com.epam.jdi.light.asserts.UIAssert;
import com.epam.jdi.light.asserts.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.tools.func.JFunc1;
import org.apache.logging.log4j.util.Strings;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.logger.LogLevels.DEBUG;
import static com.epam.jdi.tools.EnumUtils.getEnumValue;
import static com.epam.jdi.tools.EnumUtils.getEnumValues;
import static com.epam.jdi.tools.LinqUtils.ifSelect;
import static com.epam.jdi.tools.LinqUtils.map;
import static java.util.Arrays.asList;

public class UISelectBase<A extends UISelectAssert> extends DriverBase implements IHasAssert<A> {
    public WebList element;

    @JDIAction("Select '{0}' in '{name}'")
    public void select(String value) { element.select(value); }

    @JDIAction("Select '{0}' in '{name}'")
    public <TEnum extends Enum> void select(TEnum value) {
        select(getEnumValue(value));
    }

    @JDIAction("Select '{0}' in '{name}'")
    public void select(int index) { element.select(index);  }

    @JDIAction("Get selected value")
    public String selected() {
        return element.selected();
    }

    @JDIAction("Is '{0}' selected")
    public boolean selected(String value) {
        return element.selected(value);
    }
    public int size() { return element.size(); }

    @JDIAction(level = DEBUG)
    public List<String> listEnabled() {
        return element.listEnabled();
    }

    @JDIAction(level = DEBUG)
    public List<String> listDisabled() {
        return element.listDisabled();
    }

    @JDIAction(level = DEBUG)
    public List<String> values() {
        return element.values();
    }
    @JDIAction(level = DEBUG)
    public List<String> innerValues() {
        return element.innerValues();
    }

    public void hover() {
        element.hover();
    }
    public boolean isDisplayed() {
        return element.isDisplayed();
    }
    public boolean isHidden() {
        return element.isHidden();
    }
    public void highlight(String color) {
        element.highlight(color);
    }
    public void highlight() {
        element.highlight();
    }
    public void show() {
        element.show();
    }
    public boolean wait(JFunc1<IBaseElement, Boolean> condition) {
        return element.wait(condition);
    }

    public A is() {
        return (A) new UISelectAssert().set(this);
    }
}
