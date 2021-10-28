package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.elements.common.UIElement;
import org.openqa.selenium.Keys;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class TextFieldDemo extends UIElement {

    protected String INPUT_LOCATOR = "input";
    protected String LABEL_LOCATOR = "label";
    protected String COUNTER_LOCATOR = ".v-counter";
    protected String MESSAGE_LOCATOR = ".v-messages__message";

    UIElement inputField() {
        return find(INPUT_LOCATOR);
    }

    UIElement labelField() {
        return find(LABEL_LOCATOR);
    }

    public UIElement message() {
        return core().find(MESSAGE_LOCATOR);
    }

    public String getText() {
        return inputField().getText();
    }

    public void setText(String value) {
        inputField().sendKeys(value);
    }

    public void clearAndSetText(String value) {
        clear();
        inputField().sendKeys(value);
    }

    public void clear() {
        inputField().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
    }

    public String labelText() {
        return labelField().getText();
    }

    public String getCounter() {
        return core().find(COUNTER_LOCATOR).getText();
    }

    public String getMessage() {
        return core().find(MESSAGE_LOCATOR).getText();
    }

    //Asserts

    public void isText(String value) {
        jdiAssert(getText(), Matchers.is(value));
    }

}
