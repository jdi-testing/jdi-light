package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.elements.interfaces.base.SetValue;
import com.epam.jdi.light.elements.interfaces.common.IsInput;
import com.epam.jdi.light.material.asserts.inputs.TextFieldAssert;
import com.epam.jdi.light.material.interfaces.base.CanBeDisabled;
import com.epam.jdi.light.material.interfaces.inputs.CanBeFocused;
import com.epam.jdi.light.material.interfaces.inputs.HasAdornment;
import com.epam.jdi.light.material.interfaces.inputs.HasValidationError;
import com.epam.jdi.light.material.interfaces.inputs.HasHelperText;
import com.epam.jdi.light.material.interfaces.inputs.HasPlaceholder;
import com.epam.jdi.light.ui.html.elements.common.TextArea;
import org.openqa.selenium.Keys;

/**
 * To see examples of Text Field web elements please visit
 * https://mui.com/components/text-fields/
 */

public class TextField extends UIBaseElement<TextFieldAssert>
        implements IsInput, HasClick, SetValue, HasAdornment, CanBeFocused,
        HasHelperText, HasValidationError, HasPlaceholder, HasLabel, CanBeDisabled {

    @Override
    @JDIAction("Send text to '{name}'s text area")
    public void sendKeys(CharSequence... text) {
        getTextArea().sendKeys(text);
    }

    @Override
    @JDIAction("Set text '{name}'s text area as {0}")
    public void setText(String value) {
        getTextArea().setText(value);
    }

    @Override
    @JDIAction("Check '{name}'s text area is empty")
    public boolean isEmpty() {
        return getText().isEmpty();
    }

    @Override
    @JDIAction("'{name}'s text area has text")
    public String getText() {
        return getTextArea().getText();
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

    @JDIAction("Is '{name}' readonly")
    public boolean isReadonly() {
        return getTextArea().hasAttribute("readonly");
    }

    @JDIAction("Does '{name}' have expected type")
    public String hasType() {
        return getTextArea().attr("type");
    }

    @Override
    @JDIAction("Clear '{name}'s text field")
    public void clear() {
        getTextArea().sendKeys(Keys.CONTROL + "a");
        getTextArea().sendKeys(Keys.DELETE);
    }

    @Override
    public String getValue() {
        return getText();
    }

    @Override
    @JDIAction("Send text to '{name}'s text area")
    public void setValue(String value) {
        sendKeys(value);
    }

    @JDIAction("Set value of '{name}'s text area")
    public void setValue(Float value) {
        if(hasType().equals("number")) {
            getTextArea().sendKeys(value.toString());
        }
    }

    private TextArea getTextArea() {
        if (find(".MuiInputBase-root").attr("class").contains("multiline")) {
            return new TextArea().setCore(TextArea.class, find("//textarea[1]"));
        } else {
            return new TextArea().setCore(TextArea.class, find("//input"));
        }
    }

    @Override
    @JDIAction("Get '{name}'s label")
    public Label label() {
        return new Label().setCore(Label.class, find("label"));
    }

    @JDIAction("Get '{name}'s select")
    public Select select() {
        return new Select().setCore(Select.class, find(".MuiInputBase-root"));
    }

    @JDIAction("Get '{name}'s dropdown")
    public Dropdown dropdown() {
        return new Dropdown().setCore(Dropdown.class, find(".MuiInputBase-root"));
    }

    @Override
    public boolean hasPlaceholder() {
        if (label().attr("data-shrink").equals("false")) {
            return true;
        } else {
            return getTextArea().hasAttribute("placeholder");
        }
    }

    @Override
    public String getPlaceHolderText() {
        String res = null;
        if (hasPlaceholder()) {
            if (label().attr("data-shrink").equals("false")) {
                res = label().getText();
            } else {
                res = getTextArea().attr("placeholder");
            }
        }
        return res;
    }

    @Override
    public TextFieldAssert is() {
        return new TextFieldAssert().set(this);
    }
}
