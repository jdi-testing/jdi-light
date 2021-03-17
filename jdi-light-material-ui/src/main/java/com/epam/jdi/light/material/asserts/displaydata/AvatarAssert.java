package com.epam.jdi.light.material.asserts.displaydata;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.material.elements.displaydata.Avatar;
import com.epam.jdi.tools.Timer;
import org.hamcrest.Matchers;
import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import com.epam.jdi.light.common.JDIAction;

public class AvatarAssert extends UIAssert<AvatarAssert, Avatar> {
    @JDIAction("Assert that {name}'s child image is visible")
    public AvatarAssert displayedImg() {
        try {
            boolean isDisplayed = new Timer(base().getTimeout() * 1000L)
                    .wait(() -> element().find(".MuiAvatar-img").isDisplayed());
            jdiAssert(isDisplayed, Matchers.is(true));
        } catch (AssertionError e){
            new AssertionError("Img not found");
        }
        return this;
    }

    @JDIAction("Assert that {name}'s child svg is visible")
    public AvatarAssert displayedSvg() {
        try {
            boolean isDisplayed = new Timer(base().getTimeout() * 1000L)
                    .wait(() -> element().find(".MuiSvgIcon-root").isDisplayed());
            jdiAssert(isDisplayed, Matchers.is(true));
        } catch (AssertionError e){
            new AssertionError("Img not found");
        }
        return this;
    }

    @JDIAction("Assert that {name} is visible")
    @Override
    public AvatarAssert displayed() {
        boolean isDisplayed = new Timer(base().getTimeout() * 1000L)
                .wait(() -> element().isDisplayed());
        jdiAssert(isDisplayed, Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} has {className}")
    public AvatarAssert hasClass(String className){
        jdiAssert(element().hasClass(className), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} child contains img")
    public AvatarAssert hasImg(String className){
        jdiAssert(element().find("//img").hasClass(className), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} child contains svg")
    public AvatarAssert hasSvg(String className){
        jdiAssert(element().find("//*[name()='svg']").hasClass(className), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} has text {text}")
    public AvatarAssert text(String text){
        jdiAssert(element().hasText(text), Matchers.is(true));
        return this;
    }
}
