package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.asserts.generic.TextAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.common.IsButton;
import com.epam.jdi.light.ui.html.elements.common.Button;

import java.util.Arrays;
import java.util.stream.Collectors;

import static com.epam.jdi.light.common.Exceptions.exception;

public class Adornment extends UIBaseElement<TextAssert>
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
