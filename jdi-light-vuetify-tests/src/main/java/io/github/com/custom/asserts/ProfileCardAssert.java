package io.github.com.custom.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.jdiai.tools.Timer;
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

    @JDIAction("Assert that '{name}' has expected user's name")
    public ProfileCardAssert userName(String text) {
        jdiAssert(element().getUserName(), Matchers.is(text));
        return this;
    }

    @JDIAction("Assert that '{name}' has expected user's job function")
    public ProfileCardAssert userJobFunction(String text) {
        jdiAssert(element().getUserJobFunction(), Matchers.is(text));
        return this;
    }

}
