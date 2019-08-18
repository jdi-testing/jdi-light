package com.epam.jdi.light.ui.html.elements.complex;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.common.TextTypes;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.tools.func.JFunc1;

import java.util.List;

import static com.epam.jdi.light.logger.LogLevels.DEBUG;

public class Tabs extends UIListBase<UISelectAssert> {
    @JDIAction("Select '{0}' in '{name}'")
    public void select(String value) { list().select(value); }
    @JDIAction("Select '{0}' in '{name}'")
    public void select(int index) { list().select(index);  }

    @JDIAction(level = DEBUG)
    public UIElement get(String value) { return list().get(value);}
    @JDIAction(level = DEBUG)
    public <TEnum extends Enum> UIElement get(TEnum value) { return list().get(value);}
    @JDIAction(level = DEBUG)
    public UIElement get(int index) { return list().get(index);  }

    @JDIAction("Get selected value")
    public String selected() { return list().selected(); }
    @JDIAction("Is '{0}' selected")
    public boolean selected(String value) { return list().selected(value); }

    @JDIAction(level = DEBUG)
    public List<String> values() {
        return list().values();
    }
    @JDIAction(level = DEBUG)
    public List<String> values(TextTypes type) {
        return list().values(type);
    }
    @JDIAction(level = DEBUG)
    public List<String> listEnabled() { return list().listEnabled(); }

    @JDIAction(level = DEBUG)
    public List<String> listDisabled() { return list().listDisabled();
    }
    public boolean wait(JFunc1<Tabs, Boolean> condition) {
        return base().timer().wait(() -> condition.execute(this));
    }

    @JDIAction("Hover to '{name}'")
    public void hover() {
        list().hover();
    }
    @JDIAction("Check that '{name}' is displayed")
    public boolean isDisplayed() {
        return list().isDisplayed();
    }
    @JDIAction("Check that '{name}' is hidden")
    public boolean isHidden() {
        return list().isHidden();
    }
    @JDIAction(level = DEBUG)
    public void highlight(String color) {
        list().highlight(color);
    }
    @JDIAction(level = DEBUG)
    public void highlight() {
        list().highlight();
    }
    @JDIAction(level = DEBUG)
    public void show() {
        list().show();
    }
    @JDIAction("Check that '{name}' is enabled")
    public boolean isEnabled() {
        return list().listEnabled().size() > 0;
    }
    @Override
    public UISelectAssert is() {
        return new UISelectAssert<>().set(this);
    }
}
