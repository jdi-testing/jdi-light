package com.epam.jdi.light.vuetify.asserts.tables;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.tables.DataIterator;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class DataIteratorAssert extends UIAssert<DataIteratorAssert, DataIterator> {

    @JDIAction(value = "Assert that '{name}' has required number of columns per page", isAssert = true)
    public DataIteratorAssert numberOfElements(int n) {
        jdiAssert(element().elements().size(), Matchers.is(n));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has text '{0}' inside", isAssert = true)
    public DataIteratorAssert text(String value) {
        this.text(Matchers.is(value));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has text '{0}' inside", isAssert = true)
    public DataIteratorAssert text(Matcher validation) {
        jdiAssert(element().content().text(), validation);
        return this;
    }

    @Override
    public DataIterator element() {
        return super.element();
    }

    @Override
    public DataIteratorAssert and() {
        return super.and();
    }
}
