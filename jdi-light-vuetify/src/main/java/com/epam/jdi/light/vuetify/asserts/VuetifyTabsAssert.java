package com.epam.jdi.light.vuetify.asserts;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.vuetify.elements.complex.VuetifyTabs;
import org.hamcrest.Matchers;

public class VuetifyTabsAssert extends UISelectAssert<VuetifyTabsAssert, VuetifyTabs> {

    @Override
    public VuetifyTabsAssert selected(int index) {
        jdiAssert(element().isSelected(index) ? "selected" : "not selected",
                Matchers.is("selected"));
        return this;
    }

    public VuetifyTabsAssert size(int size) {
        jdiAssert(element().size(), Matchers.is(size));
        return this;
    }

    public VuetifyTabsAssert fixed() {
        jdiAssert(element().isFixed() ? "is fixed" : "is not fixed",
                Matchers.is("is fixed"));
        return this;
    }

    public VuetifyTabsAssert grow() {
        jdiAssert(element().isGrow() ? "is grow" : "is not grow",
                Matchers.is("is grow"));
        return this;
    }

    public VuetifyTabsAssert right() {
        jdiAssert(element().isRight() ? "is right" : "is not right",
                Matchers.is("is right"));
        return this;
    }

    public VuetifyTabsAssert vertical() {
        jdiAssert(element().isVertical() ? "is vertical" : "is not vertical",
                Matchers.is("is vertical"));
        return this;
    }

    public VuetifyTabsAssert elementExist(int elNum) {
        jdiAssert(element().get(elNum).isExist() ? "element is exist" : "element is not exist",
                Matchers.is("element is exist"));
        return this;
    }

    public VuetifyTabsAssert elementNotExist(int elNum) {
        jdiAssert(element().get(elNum).isNotExist() ? "element is not exist" : "element exist",
                Matchers.is("element is not exist"));
        return this;
    }
}
