package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.asserts.generic.TextAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.elements.interfaces.base.HasPlaceholder;
import com.epam.jdi.light.elements.interfaces.base.SetValue;
import com.epam.jdi.light.elements.interfaces.common.IsButton;
import com.epam.jdi.light.material.asserts.inputs.TextFieldAssert;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.ui.html.elements.common.TextArea;
import org.openqa.selenium.Keys;

import java.util.Arrays;
import java.util.stream.Collectors;

import static com.epam.jdi.light.common.Exceptions.exception;

/**
 * To see examples of Text Field web elements please visit
 * https://mui.com/components/text-fields/
 */

public class TextField extends UIBaseElement<TextFieldAssert>
        implements HasClick, HasLabel, SetValue, HasPlaceholder {

    @JDIAction("Send text to '{name}'s text area")
    public void sendText(String text) {
        getTextArea().sendKeys(text);
    }

    @JDIAction("'{name}'s text area has text")
    public String hasText() {
        return getTextArea().getText();
    }

    @JDIAction("'{name}' has helper text")
    public String hasHelperText() {
        if(helperText().core().isDisplayed()) {
            return helperText().getText();
        } else throw exception("Text Field does not have helper text");
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

    @JDIAction("Is '{name}' focused")
    public boolean isFocused() {
        return label().attr("class").contains("Mui-focused");
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

    @JDIAction("'{name}'s adornment's position")
    public String hasAdornmentPosition() {
        return adornment().position().replace("position", "").toLowerCase();
    }

    @JDIAction("'{name}'s adornment's text")
    public String hasAdornmentText() {
        return adornment().text();
    }

    @Override
    public String getValue() {
        return hasText();
    }

    @Override
    @JDIAction("Send text to '{name}'s text area")
    public void setValue(String value) {
        sendText(value);
    }

    @JDIAction("Set value of '{name}'s text area")
    public void setValue(Float value) {
        if(hasType().equals("number")) {
            getTextArea().sendKeys(value.toString());
        }
    }

    private TextArea getTextArea() {
        if(find(".MuiInputBase-root").attr("class").contains("multiline")) {
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

    @JDIAction("Get '{name}'s adornment")
    public Adornment adornment() {
        return new Adornment().setCore(Adornment.class, find(".MuiInputAdornment-root"));
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


    public static class Adornment extends UIBaseElement<TextAssert>
        implements IsButton {

        @JDIAction("Adornment has text")
        public String text() {
            return find("p").getText();
        }

        @JDIAction("Adornment has position")
        public String position() {
            return Arrays.stream(attr("class")
                    .split("[^a-zA-Z0-9]"))
                    .filter(s -> s.startsWith("position"))
                    .collect(Collectors.joining());
        }

        private Button getButton() {
            return new Button().setCore(Button.class, find("button"));
        }

        @JDIAction("Click on adornment")
        public void clickOnAdornment() {
            if (getButton().isDisplayed()) {
                getButton().click();
            } else throw exception("Adornment does not contain button");
        }
    }
}
