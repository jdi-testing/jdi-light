package io.github.com.custom.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import io.github.com.custom.bars.PanelBar;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class PanelBarAssert extends UIAssert<PanelBarAssert, PanelBar> {

    @JDIAction("Assert that '{name}' has expected text")
    public PanelBarAssert avatarText(String text) {
        jdiAssert(element().avatarText(), Matchers.containsString(text));
        return this;
    }

    @JDIAction("Assert that '{name}' has expected text")
    public PanelBarAssert greyText(String text) {
        jdiAssert(element().greyText(), Matchers.containsString(text));
        return this;
    }

    @JDIAction("Assert that '{name}' has expected text")
    public PanelBarAssert textNotification(String text) {
        jdiAssert(element().textNotification(), Matchers.containsString(text));
        return this;
    }

    @JDIAction("Assert that '{name}' has expected text")
    public PanelBarAssert cntNotification(String text) {
        jdiAssert(element().cntNotification(), Matchers.containsString(text));
        return this;
    }
}
