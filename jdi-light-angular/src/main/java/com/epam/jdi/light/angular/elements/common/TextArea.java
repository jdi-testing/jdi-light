package com.epam.jdi.light.angular.elements.common;

import static com.epam.jdi.light.ui.html.HtmlUtils.getInt;

import com.epam.jdi.light.angular.asserts.TextAreaAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.SetValue;
import com.epam.jdi.light.elements.interfaces.common.IsInput;
import org.openqa.selenium.Keys;

public class TextArea extends UIBaseElement<TextAreaAssert> implements SetValue, IsInput {

    @JDIAction
    public int rows() {
        return getInt(core().attr("rows"));
    }

    @JDIAction
    public int minRows() {
        return getInt(core().attr("cdkautosizeminrows"));
    }

    @JDIAction
    public int maxRows() {
        return getInt(core().attr("cdkautosizemaxrows"));
    }

    @JDIAction("Check that '{name}' has auto-size attribute")
    public boolean hasAutoSize() {
        return attrs().has("cdktextareaautosize");
    }

    @JDIAction("Press button '{0}' in '{name}'")
    public TextArea pressButton(Keys key) {
        core().sendKeys(key);
        return this;
    }

    @Override
    public String getValue() {
        return core().getAttribute("value");
    }

    @Override
    public void setValue(String value) {
        input(value);
    }

    @JDIAction("Set '{name}' height to '{0}'")
    public void changeHeight(int px) {
        setAttribute("style", "height: " + px + "px");
    }

    @Override
    public TextAreaAssert is() {
        return new TextAreaAssert().set(this);
    }
}
