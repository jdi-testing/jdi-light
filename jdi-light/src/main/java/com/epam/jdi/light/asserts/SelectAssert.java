package com.epam.jdi.light.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.complex.Selector;
import org.hamcrest.Matcher;

import java.util.Collection;
import java.util.List;

import static com.epam.jdi.tools.EnumUtils.getEnumValue;
import static com.epam.jdi.tools.LinqUtils.map;
import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SelectAssert extends IsAssert {
    Selector<UIElement> selector;

    public SelectAssert(Selector selector) {
        super(selector);
        this.selector = selector;
    }

    @JDIAction("Assert that '{0}' option selected for '{name}'")
    public SelectAssert selected(String option) {
        assertThat(selector.selected(option), is(true));
        return this;
    }
    public <TEnum extends Enum> SelectAssert selected(TEnum option) {
        return selected(getEnumValue(option));
    }
    
    @JDIAction("Assert that '{name}' selected option {0}")
    public SelectAssert selected(Matcher<? super List<String>> condition) {
        assertThat(selector.checked(), condition);
        return this;
    }

    @JDIAction("Assert that '{name}' values {0}")
    public SelectAssert values(Matcher<? super List<String>> condition) {
        assertThat(selector.values(), condition);
        return this;
    }
    @JDIAction("Assert that '{name}' enabled items {0}")
    public SelectAssert enabled(Matcher<? super List<String>> condition) {
        assertThat(selector.listEnabled(), condition);
        return this;
    }
    @JDIAction("Assert that '{name}' disabled items {0}")
    public SelectAssert disabled(Matcher<? super List<String>> condition) {
        assertThat(selector.listDisabled(), condition);
        return this;
    }
    @JDIAction("Assert that all '{name}' texts {0}")
    public SelectAssert texts(Matcher<Collection<? extends String>> condition) {
        assertThat(selector.values(), condition);
        return this;
    }
    @JDIAction("Assert that all '{name}' attributes {0}")
    public SelectAssert attrs(String attrName, Matcher<Collection<? extends String>> condition) {
        assertThat(selector.getAllAttributes(), condition);
        return this;
    }
    @JDIAction("Assert that all '{name}' elements css '{0}' {1}")
    public SelectAssert allCss(String css, Matcher<Collection<? extends String>> condition) {
        assertThat(map(selector.allUI(), el -> el.getCssValue(css)), condition);
        return this;
    }
    @JDIAction("Assert that all '{name}' tags {0}")
    public SelectAssert allTags(Matcher<Collection<? extends String>> condition) {
        assertThat(map(selector.allUI(), UIElement::getTagName), condition);
        return this;
    }
    @JDIAction("Assert that all '{name}' css classes {0}")
    public SelectAssert cssClasses(Matcher<Collection<? extends String>> condition) {
        assertThat(selector.classes(), condition);
        return this;
    }
    @JDIAction("Assert that all '{name}' elements are displayed")
    public SelectAssert allDisplayed() {
        assertThat(map(selector.allUI(), UIElement::isDisplayed), everyItem(is(true)));
        return this;
    }
    @JDIAction("Assert that all '{name}' elements are hidden")
    public SelectAssert allHidden() {
        assertThat(map(selector.allUI(), UIElement::isDisplayed), everyItem(is(false)));
        return this;
    }
    @JDIAction("Assert that all '{name}' elements are selected")
    public SelectAssert allSelected() {
        assertThat(map(selector.allUI(), UIElement::isSelected), everyItem(is(true)));
        return this;
    }
    @JDIAction("Assert that all '{name}' elements are enabled")
    public SelectAssert allEnabled() {
        assertThat(map(selector.allUI(), UIElement::isEnabled), everyItem(is(true)));
        return this;
    }
}
