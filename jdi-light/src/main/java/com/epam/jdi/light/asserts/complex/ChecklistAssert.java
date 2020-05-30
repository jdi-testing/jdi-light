package com.epam.jdi.light.asserts.complex;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.complex.IsChecklist;
import org.hamcrest.Matcher;

import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class ChecklistAssert extends UISelectAssert<ChecklistAssert, IsChecklist> {

    /**
     * Match passed value with selected option
     * @param condition to compare
     * @return SelectAssert
     */
    @JDIAction("Assert that '{name}' selected option {0}")
    public ChecklistAssert checked(Matcher<? super List<String>> condition) {
        jdiAssert(element().checked(), condition);
        return this;
    }
    @JDIAction("Assert that '{name}' selected option {0}")
    public ChecklistAssert checked(String... values) {
        return checked(containsInAnyOrder(values));
    }
    @JDIAction("Assert that '{name}' selected option {0}")
    public ChecklistAssert checked(List<String> values) {
        return checked(containsInAnyOrder(values.toArray()));
    }
}
