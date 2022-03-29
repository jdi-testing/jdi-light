package com.epam.jdi.light.material.asserts.inputs;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.inputs.ButtonGroup;
import com.epam.jdi.light.ui.html.elements.common.Button;
import org.hamcrest.Matchers;

import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

/**
 * Assertions for {@link ButtonGroup}
 */
public class ButtonGroupAssert extends UISelectAssert<ButtonGroupAssert, ButtonGroup> {

    /**
     * Checks that button group has given number of buttons.
     *
     * @param number expected number of buttons
     * @return this {@link ButtonGroupAssert} instance
     */
    @JDIAction("Number of grouped buttons in '{name}' is '{0}'")
    public ButtonGroupAssert numberOfGroupedButtons(Integer number) {
        jdiAssert(element().getAllButtons().size(), Matchers.is(number));
        return this;
    }

    /**
     * Checks that button group contains buttons with given texts in any order.
     *
     * @param texts expected button texts
     * @return this {@link ButtonGroupAssert} instance
     */
    @JDIAction("Assert that '{name}' contains buttons with '{0}' in any order")
    public ButtonGroupAssert buttonsTextsInAnyOrder(List<String> texts) {
        jdiAssert(element().getAllButtons().stream().map(Button::getText).toArray(),
                Matchers.arrayContainingInAnyOrder(texts.toArray()));
        return this;
    }
}
