package io.github.com.custom.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import io.github.com.custom.ProfileCard;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

/**
 * Assertions for {@link ProfileCard}.
 */
public class ProfileCardAssert extends UIAssert<ProfileCardAssert, ProfileCard> {

    /**
     * Checks that {@link ProfileCard} has given username.
     *
     * @param text expected username
     * @return this {@link ProfileCardAssert} instance
     */
    @JDIAction("Assert that '{name}' has username '{0}'")
    public ProfileCardAssert userName(String text) {
        jdiAssert(element().username(), Matchers.is(text));
        return this;
    }

    /**
     * Checks that {@link ProfileCard} has given job function.
     *
     * @param text expected job function
     * @return this {@link ProfileCardAssert} instance
     */
    @JDIAction("Assert that '{name}' has job function '{0}'")
    public ProfileCardAssert userJobFunction(String text) {
        jdiAssert(element().userJobFunction(), Matchers.is(text));
        return this;
    }
}
