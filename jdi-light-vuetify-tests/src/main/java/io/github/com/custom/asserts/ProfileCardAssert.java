package io.github.com.custom.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.tools.Timer;
import io.github.com.custom.ProfileCard;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ProfileCardAssert extends UIAssert<ProfileCardAssert, ProfileCard> {

    @JDIAction("Assert that '{name}' is displayed")
    public ProfileCardAssert displayed() {
        Timer.waitCondition(element()::isDisplayed);
        jdiAssert(element().isDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has expected text in 'name' text field")
    public ProfileCardAssert name(String text) {
        jdiAssert(element().hasName(), Matchers.is(text));
        return this;
    }

    @JDIAction("Assert that '{name}' has expected text in 'job function' text field")
    public ProfileCardAssert jobFunction(String text) {
        jdiAssert(element().hasJobFunction(), Matchers.is(text));
        return this;
    }

    @JDIAction("Assert that '{name}' has a background image")
    public ProfileCardAssert backgroundImage() {
        jdiAssert(element().hasBackgroundImage() ? "has background image" : "does not have background image",
                Matchers.is("has background image"));
        return this;
    }

    @JDIAction("Assert that '{name}' has an avatar image")
    public ProfileCardAssert avatarImage() {
        jdiAssert(element().hasAvatarImage() ? "has avatar image" : "does not have avatar image",
                Matchers.is("has avatar image"));
        return this;
    }
}
