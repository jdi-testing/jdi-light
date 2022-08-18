package io.github.com.custom.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import io.github.com.custom.cards.AvatarMenuCard;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

/**
 * Assertions for {@link AvatarMenuCard}.
 */
public class MenuCardAssert extends UIAssert<MenuCardAssert, AvatarMenuCard> {

    @JDIAction("Assert that '{name}' has email '{0}'")
    public MenuCardAssert email(String text) {
        jdiAssert(element().email(), Matchers.is(text));
        return this;
    }

    @JDIAction("Assert that '{name}' has expected text")
    public MenuCardAssert text(String text) {
        jdiAssert(element().getText(), Matchers.containsString(text));
        return this;
    }
}
