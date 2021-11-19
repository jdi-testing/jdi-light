package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.common.IsButton;
import com.epam.jdi.light.material.asserts.inputs.AdornmentAssert;
import com.epam.jdi.light.ui.html.elements.common.Button;

import java.util.Arrays;
import java.util.stream.Collectors;

import static com.epam.jdi.light.common.Exceptions.exception;

public class Adornment extends UIBaseElement<AdornmentAssert>
        implements IsButton {

    @Override
    @JDIAction("Get '{name}'s text")
    public String getText() {
        return find("p").getText();
    }

    @JDIAction("Get '{name}'s position")
    public String getPosition() {
        return Arrays.stream(attr("class")
                        .split("[^a-zA-Z0-9]"))
                .filter(s -> s.startsWith("position"))
                .collect(Collectors.joining())
                .replace("position", "")
                .toLowerCase();
    }

    private Button getButton() {
        return new Button().setCore(Button.class, find("button"));
    }

    @Override
    @JDIAction("Click on adornment")
    public void click() {
        if (getButton().isDisplayed()) {
            getButton().click();
        } else throw exception("Adornment does not contain button");
    }

    @Override
    public AdornmentAssert is() {
        return new AdornmentAssert().set(this);
    }

    @Override
    public AdornmentAssert has() {
        return is();
    }

}
