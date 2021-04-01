package com.epam.jdi.light.material.asserts.inputs.Buttons;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.asserts.displaydata.AvatarAssert;
import com.epam.jdi.light.material.asserts.inputs.ButtonAssert;
import com.epam.jdi.light.material.elements.inputs.Buttons.IconLabelButton;
import com.epam.jdi.light.material.elements.inputs.Buttons.TextButton;
import com.epam.jdi.tools.Timer;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class IconLabelButtonAssert extends UIAssert<IconLabelButtonAssert, IconLabelButton> {

    @JDIAction("Assert that '{name}' text is '{0}'")
    public IconLabelButtonAssert text(String text) {
        jdiAssert(element().getText(), Matchers.is(text));
        return this;
    }

    @JDIAction("Assert that '{name}' is enabled")
    @Override
    public IconLabelButtonAssert enabled() {
        jdiAssert(element().isEnabled(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is disabled")
    @Override
    public IconLabelButtonAssert disabled() {
        jdiAssert(element().isDisabled(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has attribute")
    @Override
    public IconLabelButtonAssert attr(String attrName) {
        jdiAssert(element().hasAttribute(attrName), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is not visible")
    @Override
    public IconLabelButtonAssert notVisible() {
        jdiAssert(element().isNotVisible(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} child contains svg")
    public IconLabelButtonAssert hasSvg(String className){
        jdiAssert(element().find("//*[name()='svg']").hasClass(className), Matchers.is(true));
        return this;
    }


    @JDIAction("Assert that {name}'s child svg is visible")
    public IconLabelButtonAssert displayedSpanIcon() {
        try {
            boolean isDisplayed = new Timer(base().getTimeout() * 1000L)
                    .wait(() -> element().find("material-icons MuiIcon-root").isDisplayed());
            jdiAssert(isDisplayed, Matchers.is(true));
        } catch (AssertionError e){
            new AssertionError("Svg not found");
        }
        return this;
    }

}
