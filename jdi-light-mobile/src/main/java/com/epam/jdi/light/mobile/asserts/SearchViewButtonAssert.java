package com.epam.jdi.light.mobile.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.mobile.asserts.generic.ISearchViewButtonAssert;
import com.epam.jdi.light.mobile.elements.common.app.ISearchViewButton;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class SearchViewButtonAssert extends UIAssert<SearchViewButtonAssert, ISearchViewButton>
        implements ISearchViewButtonAssert<SearchViewButtonAssert> {

    @JDIAction("Assert that '{name}' is iconified")
    @Override
    public SearchViewButtonAssert enabled() {
        jdiAssert(element().isEnabled(), Matchers.is(true), "SearchViewButton is not enabled");
        return this;
    }

    @JDIAction("Assert that '{name}' is iconified")
    public SearchViewButtonAssert iconifiedByDefault() {
        jdiAssert(element().isDisplayed(), Matchers.is(true),
                "SearchViewButton is not iconified by default");
        return this;
    }
}
