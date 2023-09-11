package com.epam.jdi.light.mobile.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.mobile.asserts.generic.ISearchViewButtonAssert;
import com.epam.jdi.light.mobile.asserts.generic.ISearchViewFieldAssert;
import com.epam.jdi.light.mobile.elements.common.app.IActionBar;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ActionBarAssert extends UIAssert<ActionBarAssert, IActionBar> implements ISearchViewButtonAssert<ActionBarAssert>, ISearchViewFieldAssert<ActionBarAssert> {

    @Override
    public ActionBarAssert enabled() {
        jdiAssert(element().isEnabled(), Matchers.is(true), "ActionBar is not enabled");
        return this;
    }

    @Override
    public ActionBarAssert expanded() {
        jdiAssert(element().isExpanded(), Matchers.is(true), "Action bar is not expanded");
        return this;
    }

    @Override
    public ActionBarAssert text(String expected) {
        jdiAssert(element().getValue(), Matchers.is(expected));
        return this;
    }

}
