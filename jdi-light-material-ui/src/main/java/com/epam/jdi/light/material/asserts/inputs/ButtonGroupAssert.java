package com.epam.jdi.light.material.asserts.inputs;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.inputs.ButtonGroup;
import org.hamcrest.Matchers;

import java.util.List;
import java.util.stream.Collectors;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ButtonGroupAssert extends UIAssert<ButtonGroupAssert, ButtonGroup> {

    @JDIAction("Number of grouped buttons in '{name}' is '{0}'")
    public ButtonGroupAssert numberOfGroupedButtons(Integer number) {
        jdiAssert(element().getSize(), Matchers.is(number));
        return this;
    }

    @JDIAction("Number of grouped buttons in '{name}' is '{0}'")
    public ButtonGroupAssert buttonsTextsExactlyInThisOrder(List<String> texts) {
        jdiAssert(element().getAllButtons().stream().map(Button::getText).toArray(),
                Matchers.arrayContainingInAnyOrder(texts.toArray()));
        return this;
    }
}
