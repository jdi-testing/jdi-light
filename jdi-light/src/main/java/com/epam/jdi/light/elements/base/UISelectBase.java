package com.epam.jdi.light.elements.base;

import com.epam.jdi.light.asserts.HasAssert;
import com.epam.jdi.light.asserts.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.complex.ISelector;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.SetValue;

import java.util.List;

import static com.epam.jdi.light.logger.LogLevels.DEBUG;
import static com.epam.jdi.tools.EnumUtils.getEnumValue;

public abstract class UISelectBase<A extends UISelectAssert> extends DriverBase
        implements HasAssert<A>, HasUIList, ISelector, SetValue {
    protected WebList list = new WebList();
    public WebList element() { return list; }

    @JDIAction("Select '{0}' in '{name}'")
    public void select(String value) { list.select(value); }

    @JDIAction("Select '{0}' in '{name}'")
    public <TEnum extends Enum> void select(TEnum value) {
        select(getEnumValue(value));
    }

    @JDIAction("Select '{0}' in '{name}'")
    public void select(int index) { list.select(index);  }

    @JDIAction("Get selected value")
    public String selected() {
        return list.selected();
    }

    @JDIAction("Is '{0}' selected")
    public boolean selected(String value) {
        return list.selected(value);
    }

    @JDIAction(level = DEBUG)
    public List<String> listEnabled() {
        return list.listEnabled();
    }

    @JDIAction(level = DEBUG)
    public List<String> listDisabled() {
        return list.listDisabled();
    }

    @JDIAction(level = DEBUG)
    public List<String> values() {
        return list.values();
    }
    @JDIAction(level = DEBUG)
    public List<String> innerValues() {
        return list.innerValues();
    }

    public void hover() {
        list.hover();
    }
    public boolean isDisplayed() {
        return list.isDisplayed();
    }
    public boolean isHidden() {
        return list.isHidden();
    }
    public void highlight(String color) {
        list.highlight(color);
    }
    public void highlight() {
        list.highlight();
    }
    public void show() {
        list.show();
    }
    public boolean isEnabled() {
        return list.listEnabled().size() > 0;
    }



}
