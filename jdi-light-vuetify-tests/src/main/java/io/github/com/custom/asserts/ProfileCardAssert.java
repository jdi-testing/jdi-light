package io.github.com.custom.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.tools.Timer;
import io.github.com.custom.ProfileCard;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ProfileCardAssert extends UIAssert<ProfileCardAssert, ProfileCard> {

    @JDIAction("Assert that {name} is displayed")
    public ProfileCardAssert displayed() {
        new Timer(base().getTimeout() * 1000L)
                .wait(() -> element().isDisplayed());
        jdiAssert(element().isDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} text is '{0}'")
    public ProfileCardAssert properName(String text) {
        jdiAssert(element().hasProperName(), Matchers.is(text));
        return this;
    }

    @JDIAction("Assert that {name} text is '{0}'")
    public ProfileCardAssert properJobFunction(String text) {
        jdiAssert(element().hasProperJobFunction(), Matchers.is(text));
        return this;
    }

    @JDIAction("Assert that {name} has a background image")
    public ProfileCardAssert backgroundImage() {
        jdiAssert(element().hasBackgroundImage(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} has an avatar image")
    public ProfileCardAssert avatarImage() {
        jdiAssert(element().hasAvatarImage(), Matchers.is(true));
        return this;
    }
}
