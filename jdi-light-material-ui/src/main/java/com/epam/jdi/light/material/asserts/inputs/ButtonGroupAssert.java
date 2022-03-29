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
     * @param number number of buttons to compare
     * @return {@link ButtonGroupAssert}
     */
    @JDIAction("Number of grouped buttons in '{name}' is '{0}'")
    public ButtonGroupAssert numberOfGroupedButtons(Integer number) {
        jdiAssert(element().getAllButtons().size(), Matchers.is(number));
        return this;
    }

    /**
     * Checks that button group contains given texts in any order.
     *
     * @param texts to compare
     * @return {@link ButtonGroupAssert}
     */
    @JDIAction("Number of grouped buttons in '{name}' is '{0}'")
    public ButtonGroupAssert buttonsTextsInAnyOrder(List<String> texts) {
        jdiAssert(element().getAllButtons().stream().map(Button::getText).toArray(),
                Matchers.arrayContainingInAnyOrder(texts.toArray()));
        return this;
    }
}
