package io.github.com.custom.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import io.github.com.custom.ProfileCard;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ProfileCardAssert extends UIAssert<ProfileCardAssert, ProfileCard> {

    @JDIAction("Assert that '{name}' has username '{0}'")
    public ProfileCardAssert userName(String text) {
        jdiAssert(element().getUserName(), Matchers.is(text));
        return this;
    }

    @JDIAction("Assert that '{name}' has job function '{0}'")
    public ProfileCardAssert userJobFunction(String text) {
        jdiAssert(element().getUserJobFunction(), Matchers.is(text));
        return this;
    }
}
