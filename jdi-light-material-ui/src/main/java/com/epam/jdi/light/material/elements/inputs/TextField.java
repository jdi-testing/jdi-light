package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.base.SetValue;
import com.epam.jdi.light.elements.interfaces.common.IsInput;
import com.epam.jdi.light.material.asserts.inputs.TextFieldAssert;
import com.epam.jdi.light.material.interfaces.inputs.CanBeFocused;
import com.epam.jdi.light.material.interfaces.inputs.HasAdornment;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.ui.html.elements.common.TextArea;
import org.openqa.selenium.Keys;

/**
 * To see examples of Text Field web elements please visit
 * https://mui.com/components/text-fields/
 */

public class TextField extends UIBaseElement<TextFieldAssert>
        implements IsInput, HasClick, SetValue, HasAdornment, CanBeFocused {

    @Override
    @JDIAction("Send text to '{name}'s text area")
    public void sendKeys(CharSequence... text) {
        getTextArea().sendKeys(text);
    }

    @Override
    @JDIAction("Set text is '{name}'s text area")
    public void setText(String value) {
        getTextArea().setText(value);
    }

    @Override
    @JDIAction("'{name}'s text area is empty")
    public boolean isEmpty() {
        return hasText().isEmpty();
    }

    @JDIAction("'{name}'s text area has text")
    public String hasText() {
        return getTextArea().getText();
    }

    @JDIAction("'{name}' has helper text")
    public String getHelperText() {
        if(helperText().core().isDisplayed()) {
            return helperText().getText();
        } else return null;
    }

    @Override
    @JDIAction("Is '{name}' disabled")
    public boolean isDisabled() {
        return label().attr("class").contains("Mui-disabled");
    }

    @JDIAction("Does '{name}' has placeholder")
    public boolean hasPlaceholder() {
        return label().attr("data-shrink").equals("false");
    }

    @JDIAction("Does '{name}' have error notification")
    public boolean hasError() {
        return label().attr("class").contains("Mui-error");
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
        click();
        getTextArea().clear();
        while (!getTextArea().getText().equals("")) {
            getTextArea().sendKeys(Keys.BACK_SPACE);
        }
        getTextArea().sendKeys(Keys.SPACE);
        getTextArea().sendKeys(Keys.BACK_SPACE);
    }

    @Override
    public String getValue() {
        return hasText();
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
        } else return new TextArea().setCore(TextArea.class, find("//input"));
    }

    @Override
    @JDIAction("Get '{name}'s label")
    public Label label() {
        return new Label().setCore(Label.class, find("label"));
    }

    @JDIAction("'{name}' has helper text")
    private Text helperText() {
        return new Text().setCore(Text.class, find("p.MuiFormHelperText-root"));
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
    public TextFieldAssert is() {
        return new TextFieldAssert().set(this);
    }

    @Override
    public TextFieldAssert has() {
        return is();
    }
}
