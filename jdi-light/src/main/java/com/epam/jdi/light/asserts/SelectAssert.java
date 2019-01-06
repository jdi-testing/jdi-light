package com.epam.jdi.light.asserts;

import com.epam.jdi.light.elements.complex.Selector;
import org.hamcrest.Matcher;

import java.util.List;

import static com.epam.jdi.light.asserts.BaseSelectorAssert.waitAssert;
import static com.epam.jdi.tools.EnumUtils.getEnumValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SelectAssert extends IsAssert {
    Selector selector;

    public SelectAssert(Selector selector) {
        super(selector);
        this.selector = selector;
    }

    public SelectAssert selected(String option) {
        waitAssert(() -> assertThat(selector.selected(option), is(true)), name);
        return this;
    }
    public <TEnum extends Enum> SelectAssert selected(TEnum option) {
        return selected(getEnumValue(option));
    }
    public SelectAssert selected(Matcher<? super List<String>> condition) {
        waitAssert(() -> assertThat(selector.checked(), condition), name);
        return this;
    }

    public SelectAssert values(Matcher<? super List<String>> condition) {
        waitAssert(() -> assertThat(selector.values(), condition), name);
        return this;
    }
    public SelectAssert enabled(Matcher<? super List<String>> condition) {
        waitAssert(() -> assertThat(selector.listEnabled(), condition), name);
        return this;
    }
    public SelectAssert disabled(Matcher<? super List<String>> condition) {
        waitAssert(() -> assertThat(selector.listDisabled(), condition), name);
        return this;
    }
}
