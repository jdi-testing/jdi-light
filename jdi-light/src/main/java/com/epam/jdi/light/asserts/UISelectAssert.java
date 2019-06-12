package com.epam.jdi.light.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.complex.ISelector;
import com.epam.jdi.tools.Timer;
import com.epam.jdi.tools.func.JFunc1;
import org.hamcrest.Matcher;

import java.util.List;

import static com.epam.jdi.light.asserts.SoftAssert.jdiAssert;
import static com.epam.jdi.light.settings.TimeoutSettings.TIMEOUT;
import static com.epam.jdi.tools.EnumUtils.getEnumValue;
import static org.hamcrest.Matchers.*;

public class UISelectAssert<A extends UISelectAssert, E extends ISelector> extends UIAssert<A, E> {
    @JDIAction("Assert that '{0}' option selected for '{name}'")
    public A selected(String option) {
        jdiAssert(uiElement.selected(option), is(true));
        return (A) this;
    }
    public <TEnum extends Enum> UISelectAssert selected(TEnum option) {
        return selected(getEnumValue(option));
    }

    @JDIAction("Assert that '{name}' values {0}")
    public A values(Matcher<? super List<String>> condition) {
        jdiAssert(uiElement.values(), condition);
        return (A) this;
    }
    public A values(String... values) {
        return values(hasItems(values));
    }
    @JDIAction("Assert that '{name}' values {0}")
    public A innerValues(Matcher<? super List<String>> condition) {
        jdiAssert(uiElement.innerValues(), condition);
        return (A) this;
    }
    @JDIAction("Assert that '{name}' enabled items {0}")
    public A enabled(Matcher<? super List<String>> condition) {
        jdiAssert(uiElement.listEnabled(), condition);
        return (A) this;
    }
    @JDIAction("Assert that '{name}' disabled items {0}")
    public A disabled(Matcher<? super List<String>> condition) {
        jdiAssert(uiElement.listDisabled(), condition);
        return (A) this;
    }

    @JDIAction("Assert that '{name}' size {0}")
    public A size(Matcher<Integer> condition) {
        jdiAssert(uiElement.size(), condition);
        return (A) this;
    }

    /**
     * Check that the list size is given size
     * @param size to compare
     * @return UIListAssert
     */
    @JDIAction("Assert that '{name}' size {0}")
    public A size(int size) {
        return size(equalTo(size));
    }

    @JDIAction("Assert that '{name}' is displayed")
    public A displayed() {
        jdiAssert(uiElement.isDisplayed() ? "displayed" : "hidden", is("displayed"));
        return (A) this;
    }
    @JDIAction("Assert that '{name}' is disappeared")
    public A disappear() {
        jdiAssert(uiElement.isHidden() ? "hidden" : "displayed", is("hidden"));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' is hidden")
    public A hidden() {
        return disappear();
    }
    public A notAppear() {
        return notAppear(TIMEOUT.get());
    }

    @JDIAction(value = "Assert that '{name}' does not appear during {0} seconds", timeout = 0)
    public A notAppear(int timeoutSec) {
        boolean result = new Timer(timeoutSec * 1000)
                .wait(() -> uiElement.isDisplayed());
        jdiAssert(result ? "displayed" : "hidden", is("hidden"));
        return (A) this;
    }

    public A and() { return (A) this; }
    public A condition(JFunc1<A, A> t) {
        return t.execute((A) this);
    }

    public A set(E element) {
        this.uiElement = element;
        return (A) this;
    }
}
