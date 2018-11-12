package com.epam.jdi.light.asserts;

import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.complex.Selector;
import org.hamcrest.Matcher;

import java.util.List;

import static com.epam.jdi.tools.EnumUtils.getEnumValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SelectAssert extends IsAssert {

    Selector selector;
    public SelectAssert(Selector selector) {
        super(getHtml(selector));
        this.selector = selector;
    }
    private static UIElement<UIElement> getHtml(Selector selector) {
        try { return new UIElement<>(selector.get()); }
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
