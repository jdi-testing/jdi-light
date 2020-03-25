package com.epam.jdi.light.asserts.generic;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.common.TextTypes;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISelector;
import com.epam.jdi.tools.Timer;
import com.epam.jdi.tools.func.JFunc1;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.*;
import static com.epam.jdi.light.settings.JDISettings.*;
import static com.epam.jdi.tools.EnumUtils.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class UISelectAssert<A extends UISelectAssert<?,?>, E extends ISelector> extends UIAssert<A, E>
        implements ITextAssert<A> {

    @JDIAction("Assert that '{0}' option selected for '{name}'")
    public A selected(Matcher<String> condition) {
        jdiAssert(element.selected(), condition);
        return (A) this;
    }
    @JDIAction("Assert that '{0}' option selected for '{name}'")
    public A selected(String option) {
        return selected(Matchers.is(option));
    }
    @JDIAction("Assert that '{0}' option selected for '{name}'")
    public A selected(int i) {
        jdiAssert(element.selected(i), Matchers.is(true));
        return (A) this;
    }
    public <TEnum extends Enum<?>> UISelectAssert<?, ?> selected(TEnum option) {
        return selected(getEnumValue(option));
    }
    public A text(Matcher<String> condition) {
        return selected(condition);
    }
    public A text(String condition) {
        return selected(condition);
    }
    public <TEnum extends Enum<?>> UISelectAssert<?, ?> value(TEnum option) {
        return selected(option);
    }
    @JDIAction("Assert that '{name}' values {0}")
    public A values(Matcher<? super List<String>> condition) {
        jdiAssert(element.values(), condition);
        return (A) this;
    }
    public A values(String... values) {
        return values(hasItems(values));
    }
    @JDIAction("Assert that '{name}' values {0}")
    public A values(TextTypes type, Matcher<? super List<String>> condition) {
        jdiAssert(element.values(type), condition);
        return (A) this;
    }
    public A values(TextTypes type, String... values) {
        return values(type, hasItems(values));
    }
    @JDIAction("Assert that '{name}' enabled items {0}")
    public A enabled(Matcher<? super List<String>> condition) {
        jdiAssert(element.listEnabled(), condition);
        return (A) this;
    }
    public A enabled(String... enabled) {
        return enabled(hasItems(enabled));
    }
    @JDIAction("Assert that '{name}' disabled items {0}")
    public A disabled(Matcher<? super List<String>> condition) {
        jdiAssert(element.listDisabled(), condition);
        return (A) this;
    }
    public A disabled(String... disabled) {
        return disabled(hasItems(disabled));
    }

    @JDIAction("Assert that '{name}' size {0}")
    public A size(Matcher<Integer> condition) {
        jdiAssert(element.size(), condition);
        return (A) this;
    }

    /**
     * Check that the list size is given size
     * @param size to compare
     * @return DataListAssert
     */
    @JDIAction("Assert that '{name}' size {0}")
    public A size(int size) {
        return size(equalTo(size));
    }
    @JDIAction("Assert that '{name}' size {0}")
    public A empty() {
        return size(0);
    }
    @JDIAction("Assert that '{name}' size {0}")
    public A notEmpty() {
        return size(greaterThan(0));
    }
    @JDIAction("Assert that '{name}' is displayed")
    public A displayed() {
        jdiAssert(element.isDisplayed() ? "displayed" : "hidden", Matchers.is("displayed"));
        return (A) this;
    }
    @JDIAction("Assert that '{name}' is disappeared")
    public A disappear() {
        jdiAssert(element.isHidden() ? "hidden" : "displayed", Matchers.is("hidden"));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' is hidden")
    public A hidden() {
        return disappear();
    }
    public A notAppear() {
        return notAppear(TIMEOUTS.element.get());
    }

    @JDIAction(value = "Assert that '{name}' does not appear during {0} seconds", timeout = 0)
    public A notAppear(int timeoutSec) {
        boolean result = new Timer(timeoutSec * 1000)
                .wait(() -> element.isDisplayed());
        jdiAssert(result ? "displayed" : "hidden", Matchers.is("hidden"));
        return (A) this;
    }

    public Compare exact(int count) {
        return new Compare(count, this, true);
    }
    public Compare atLeast(int count) {
        return new Compare(count, this, false);
    }
    public Compare no() {
        return exact(0);
    }
    public Compare all() {
        return exact(element.size());
    }
    public Compare onlyOne() {
        return exact(1);
    }

    public class Compare implements JAssert {

        public int count;
        public String name;
        public String type;
        UISelectAssert<A,E> dtAssert;
        boolean exact;
        public JDIBase base() { return UISelectAssert.this.base(); }

        private Compare(int count, UISelectAssert<A,E> dtAssert, boolean exact) {
            this.count = count;
            this.dtAssert = dtAssert;
            this.exact = exact;
            this.type = exact ? "exactly" : "at least";
            this.name = dtAssert.name;
        }

        @JDIAction("Assert that '{name}' has {type} '{count}' elements that meet expected condition")
        public UISelectAssert<A,E> elements(JFunc1<UIElement, Boolean> condition) {
            jdiAssert(element.list().filter(condition), hasSize(count));
            return dtAssert;
        }
        @JDIAction("Assert that '{name}' has {type} '{count}' '{0}'")
        public UISelectAssert<A,E> elements(UIElement data) {
            return elements(d -> d.equals(data));
        }
    }
    public A and() { return (A) this; }
}
