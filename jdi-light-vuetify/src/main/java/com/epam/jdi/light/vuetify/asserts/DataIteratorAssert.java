package com.epam.jdi.light.vuetify.asserts;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.DataIterator;
import org.hamcrest.Matchers;

public class DataIteratorAssert extends UIAssert<DataIteratorAssert, DataIterator> {

    @Override
    public DataIteratorAssert and() {
        return super.and();
    }


    @JDIAction("Assert that {name} column is expanded")
    public DataIteratorAssert expanded(int colNum) {
        jdiAssert(element().columnIsExpanded(colNum), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} column is closed")
    public DataIteratorAssert closed(int colNum) {
        jdiAssert(element().columnIsExpanded(colNum), Matchers.is(false));
        return this;
    }

    @JDIAction("Assert that {name} column is empty")
    public DataIteratorAssert empty(int colNum) {
        jdiAssert(element().columnIsEmpty(colNum), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} column is ton empty")
    public DataIteratorAssert notEmpty(int colNum) {
        jdiAssert(element().columnIsEmpty(colNum), Matchers.is(false));
        return this;
    }
}
