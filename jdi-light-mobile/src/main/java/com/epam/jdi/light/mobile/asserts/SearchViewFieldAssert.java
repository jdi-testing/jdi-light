package com.epam.jdi.light.mobile.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.mobile.asserts.generic.ISearchViewFieldAssert;
import com.epam.jdi.light.mobile.elements.common.app.ISearchViewField;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class SearchViewFieldAssert extends UIAssert<SearchViewFieldAssert, ISearchViewField> implements ISearchViewFieldAssert<SearchViewFieldAssert> {

    @JDIAction("Assert that '{name}' is enabled")
    @Override
    public SearchViewFieldAssert enabled() {
        jdiAssert(element.get().isEnabled(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is expanded")
    @Override
    public SearchViewFieldAssert expanded() {
        jdiAssert(element.get().isExpanded(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' text {0}")
    @Override
    public SearchViewFieldAssert text(String expected) {
        jdiAssert(element().getValue(), Matchers.is(expected));
        return this;
    }
}
