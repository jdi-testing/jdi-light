package com.epam.jdi.light.ui.html.asserts;

import com.epam.jdi.light.asserts.IsAssert;
import com.epam.jdi.light.ui.html.base.HtmlElement;
import com.epam.jdi.tools.EnumUtils;
import com.epam.jdi.tools.LinqUtils;
import org.hamcrest.Matcher;

import java.util.List;

import static com.epam.jdi.tools.EnumUtils.getEnumValue;
import static com.epam.jdi.tools.LinqUtils.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SelectAssert extends IsAssert implements ComboboxAssert {

    BaseSelectorAssert selector;
    public SelectAssert(BaseSelectorAssert selector) {
        super(getHtml(selector));
        this.selector = selector;
    }
    private static HtmlElement getHtml(BaseSelectorAssert selector) {
        try { return new HtmlElement(selector.get()); }
        catch (Exception ignore) { return null; }
    }

    public void selected(String option) {
        assertThat(selector.selected(option), is(true));
    }
    public <TEnum extends Enum> void selected(TEnum option) {
        selected(getEnumValue(option));
    }
    public void selected(Matcher<? super List<String>> condition) {
        assertThat(selector.checked(), condition);
    }

    public void values(Matcher<? super List<String>> condition) {
        assertThat(selector.values(), condition);
    }
    public void enabled(Matcher<? super List<String>> condition) {
        assertThat(selector.enabled(), condition);
    }
    public void disabled(Matcher<? super List<String>> condition) {
        assertThat(selector.disabled(), condition);
    }
}
