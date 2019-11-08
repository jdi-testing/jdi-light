package com.epam.jdi.light.asserts.complex;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.complex.IsChecklist;
import org.hamcrest.Matcher;

import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssertUtils.jdiAssert;

public class ChecklistAssert extends UISelectAssert<ChecklistAssert, IsChecklist> {

    /**
     * Match passed value with selected option
     * @param condition to compare
     * @return SelectAssert
     */
    @JDIAction("Assert that '{name}' selected option {0}")
    public ChecklistAssert checked(Matcher<? super List<String>> condition) {
        jdiAssert(element.checked(), condition);
        return this;
    }
}
