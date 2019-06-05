package com.epam.jdi.light.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UISelectBase;
import com.epam.jdi.tools.Timer;
import com.epam.jdi.tools.func.JFunc1;
import org.hamcrest.Matcher;

import java.util.List;

import static com.epam.jdi.light.asserts.SoftAssert.jdiAssert;
import static com.epam.jdi.light.settings.TimeoutSettings.TIMEOUT;
import static com.epam.jdi.tools.EnumUtils.getEnumValue;
import static com.epam.jdi.tools.PrintUtils.print;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class UISelectAssert<A extends UISelectAssert, E extends UISelectBase> extends BaseAssert<E> {
    @JDIAction("Assert that '{0}' option selected for '{name}'")
    public UISelectAssert selected(String option) {
        uiElement.element.assertThat().selected(option);
        return this;
    }
    public <TEnum extends Enum> UISelectAssert selected(TEnum option) {
        return selected(getEnumValue(option));
    }

    @JDIAction("Assert that '{name}' values {0}")
    public UISelectAssert values(Matcher<? super List<String>> condition) {
        uiElement.element.assertThat().values(condition);
        return this;
    }
    @JDIAction("Assert that '{name}' values {0}")
    public UISelectAssert innerValues(Matcher<? super List<String>> condition) {
        uiElement.element.assertThat().innerValues(condition);
        return this;
    }
    @JDIAction("Assert that '{name}' enabled items {0}")
    public UISelectAssert enabled(Matcher<? super List<String>> condition) {
        uiElement.element.assertThat().enabled(condition);
        return this;
    }
    @JDIAction("Assert that '{name}' disabled items {0}")
    public UISelectAssert disabled(Matcher<? super List<String>> condition) {
        uiElement.element.assertThat().disabled(condition);
        return this;
    }

    @JDIAction("Assert that '{name}' size {0}")
    public A size(Matcher<Integer> condition) {
        uiElement.element.assertThat().size(condition);
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
        uiElement.element.assertThat().displayed();
        return (A) this;
    }
    @JDIAction("Assert that '{name}' is disappear")
    public A disappear() {
        uiElement.element.assertThat().disappear();
        return (A) this;
    }

    @JDIAction("Assert that '{name}' is hidden")
    public A hidden() {
        uiElement.element.assertThat().hidden();
        return (A) this;
    }
    public A notAppear() {
        return notAppear(TIMEOUT.get());
    }

    @JDIAction(value = "Assert that '{name}' does not appear during {0} seconds", timeout = 0)
    public A notAppear(int timeoutSec) {
        uiElement.element.assertThat().notAppear(timeoutSec);
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
