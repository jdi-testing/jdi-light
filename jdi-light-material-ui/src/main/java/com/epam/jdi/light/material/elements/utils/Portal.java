package com.epam.jdi.light.material.elements.utils;

import com.epam.jdi.light.asserts.generic.TextAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;

/**
 * Represent portal MUI component on GUI. The portal component renders its children into a new "subtree" outside of the current DOM hierarchy.
 *
 * @see <a href="https://mui.com/components/portal/">portal MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material">MUI test page</a>
 */
public class Portal extends UIBaseElement<UIAssert<TextAssert, Portal>> {

    /**
     * Gets text of this portal with given index.
     *
     * @return text of this portal with given index as {@link Text}
     */
    @JDIAction("Get {name} {0} field")
    public Text text(int num) {
        return new Text().setCore(Text.class, core().finds("//button/following::div").get(num));
    }

    /**
     * Gets button of this portal.
     *
     * @return text of this portal as {@link Button}
     */
    @JDIAction("Get {name} button")
    public Button button() {
        return new Button().setCore(Button.class, core().find("button"));
    }
}
