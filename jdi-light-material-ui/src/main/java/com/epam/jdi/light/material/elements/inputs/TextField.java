package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.elements.interfaces.base.HasPlaceholder;
import com.epam.jdi.light.elements.interfaces.base.SetValue;
import com.epam.jdi.light.material.asserts.inputs.TextFieldAssert;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.ui.html.elements.common.TextArea;

/**
 * To see an example of Checkbox group List web element please visit
 * https://mui.com/components/text-fields/
 */

public class TextField extends UIBaseElement<TextFieldAssert>
        implements HasClick, HasLabel, SetValue, HasPlaceholder {

    public TextArea getTextArea() {
        return new TextArea().setCore(TextArea.class, find("//input"));
    }

    @JDIAction("Send text to '{name}'s text area")
    public void sendText(String text) {
        getTextArea().setText(text);
    }

    @JDIAction("'{name}'s text area has text")
    public String hasText() {
        return getTextArea().getText();
    }

    @JDIAction("'{name}' has helper text")
    private Text helperText() {
        return new Text().setCore(Text.class, find("p.MuiFormHelperText-root"));
    }

    @JDIAction("'{name}' has helper text")
    public boolean hasHelperText() {
        return helperText().core().isDisplayed();
    }

    @JDIAction("'{name}' has helper text")
    public String getHelperText() {
        return helperText().getText();
    }

    @Override
    @JDIAction("Get '{name}'s label")
    public Label label() {
        return new Label().setCore(Label.class, find("label"));
    }

    @Override
    @JDIAction("Is '{name}' disabled")
    public boolean isDisabled() {
        return label().attr("class").contains("Mui-disabled");
    }

    @Override
    @JDIAction("Is '{name}' enabled")
    public boolean isEnabled() {
        return !isDisabled();
    }

    @Override
    public String getValue() {
        return hasText();
    }

    @Override
    public void setValue(String value) {
        sendText(value);
    }

    @Override
    public TextFieldAssert is() {
        return new TextFieldAssert().set(this);
    }

    @Override
    public TextFieldAssert has() {
        return is();
    }
}
