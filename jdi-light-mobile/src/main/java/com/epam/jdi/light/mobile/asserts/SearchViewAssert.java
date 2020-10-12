package com.epam.jdi.light.mobile.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.mobile.asserts.generic.ISearchAssert;
import com.epam.jdi.light.mobile.elements.common.app.ISearchView;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class SearchViewAssert extends UIAssert<SearchViewAssert, ISearchView> implements ISearchAssert<SearchViewAssert> {

    @JDIAction("Assert that '{name}' is iconified")
    @Override
    public SearchViewAssert searchViewEnabled() {
        jdiAssert(element.isEnabled(), Matchers.is("true"));
        return this;
    }

    @JDIAction("Assert that '{name}' is iconified")
    @Override
    public SearchViewAssert iconifiedByDefault() {
        jdiAssert(element.isIconified(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is expanded")
    @Override
    public SearchViewAssert searchViewExpanded() {
        jdiAssert(element.isExpanded(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' text {0}")
    @Override
    public SearchViewAssert searchViewText(String expected) {
        jdiAssert(element().getValue(), Matchers.is(expected));
        return this;
    }

}
