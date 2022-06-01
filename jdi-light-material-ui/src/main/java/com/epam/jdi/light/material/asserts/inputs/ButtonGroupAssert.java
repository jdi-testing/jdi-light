package com.epam.jdi.light.material.asserts.inputs;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.inputs.ButtonGroup;
import com.epam.jdi.light.ui.html.elements.common.Button;
import java.util.stream.Collectors;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

/**
 * Assertions for {@link ButtonGroup}.
 */
public class ButtonGroupAssert extends UISelectAssert<ButtonGroupAssert, ButtonGroup> {

    /**
     * Checks that button group has given number of buttons.
     *
     * @param number expected number of buttons
     * @return this {@link ButtonGroupAssert} instance
     */
    @JDIAction("Assert that '{name}' has '{0}' buttons")
    public ButtonGroupAssert buttons(int number) {
        jdiAssert(element().getAllButtons().size(), Matchers.is(number));
        return this;
    }

    /**
     * Checks that texts of buttons in button group meet given condition.
     *
     * @param condition expected condition
     * @return this {@link ButtonGroupAssert} instance
     */
    @JDIAction("Assert that '{name}' buttons texts '{0}'")
    public ButtonGroupAssert buttonsTexts(Matcher<Iterable<?>> condition) {
        jdiAssert(element().getAllButtons().stream().map(Button::getText).collect(Collectors.toList()),
            condition);
        return this;
    }
}
