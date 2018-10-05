package com.epam.jdi.light.ui.html.asserts;

import com.epam.jdi.light.asserts.IsAssert;
import com.epam.jdi.light.ui.html.base.HtmlElement;
import org.hamcrest.Matcher;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SelectAssert extends IsAssert {

    BaseSelectorAssert selector;
    public SelectAssert(BaseSelectorAssert selector) {
        super(new HtmlElement(selector.get())); this.selector = selector;
    }

    public void selected(String option) {
        assertThat(selector.selected(), is(option));
    }
    public void selected(Matcher<Iterable<String>> condition) {
        assertThat(selector.checked(), condition);
    }

    public void values(Matcher<Iterable<String>> condition) {
        assertThat(selector.values(), condition);
    }
    public void enabled(Matcher<Iterable<String>> condition) {
        assertThat(selector.enabled(), condition);
    }
    public void disabled(Matcher<Iterable<String>> condition) {
        assertThat(selector.disabled(), condition);
    }
}
