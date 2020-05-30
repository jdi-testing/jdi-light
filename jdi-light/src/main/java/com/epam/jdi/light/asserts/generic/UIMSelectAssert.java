package com.epam.jdi.light.asserts.generic;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.complex.IMultiSelector;
import org.hamcrest.Matcher;

import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class UIMSelectAssert<A extends UIMSelectAssert<?,?>, E extends IMultiSelector>
        extends UISelectAssert<UIMSelectAssert<?,?>, IMultiSelector> {

    @JDIAction("Assert that '{0}' values checked in '{name}'")
    public A checked(Matcher<? super List<String>> values) {
        jdiAssert(element().checked(), values);
        return (A) this;
    }
    @JDIAction("Assert that '{0}' values checked in '{name}'")
    public A checked(String... values) {
        return checked(containsInAnyOrder(values));
    }
    @JDIAction("Assert that '{0}' values checked in '{name}'")
    public A checked(List<String> values) {
        return checked(containsInAnyOrder(values.toArray()));
    }

    public A and() { return (A) this; }
}
