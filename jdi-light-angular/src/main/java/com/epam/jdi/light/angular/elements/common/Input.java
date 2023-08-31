package com.epam.jdi.light.angular.elements.common;

import static com.epam.jdi.light.common.TextTypes.VALUE;

import com.epam.jdi.light.angular.asserts.InputAssert;
import com.epam.jdi.light.angular.elements.enums.InputsTypes;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.elements.interfaces.base.SetValue;
import com.epam.jdi.light.elements.interfaces.common.IsInput;
import com.jdiai.tools.map.MapArray;
import org.openqa.selenium.Keys;

public class Input extends UIBaseElement<InputAssert> implements IsInput, HasLabel, SetValue {

    @JDIAction("Type text to '{name}' input field")
    public Input pressButton(Keys key) {
        core().sendKeys(key);
        return this;
    }

    @JDIAction("Clear '{name}' text field and type text to it")
    public Input clearAndSetText(String text) {
        this.clear();
        this.sendKeys(text);
        return this;
    }

    @JDIAction("Get {name}' typed text")
    public String typedText() {
        return core().getText();
    }

    @JDIAction("")
    public Boolean readonly() {
        return Boolean.valueOf(core().getAttribute("readonly"));
    }

    @JDIAction("")
    public InputsTypes inputType() {
        MapArray<String, String> attrsMap = attrs();
        return InputsTypes.fromType(core().getAttribute("type"));
    }

    public boolean hasAutoSize() {
        return attrs().has("cdktextareaautosize");
    }

    public void setValue(String value) {
        sendKeys(value);
    }

    public String getValue() {
        return core().text(VALUE);
    }

    @Override
    public InputAssert is() {
        return new InputAssert().set(this);
    }
}
