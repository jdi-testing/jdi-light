package com.epam.jdi.light.ui.html.asserts;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.ui.html.elements.complex.Checklist;
import org.hamcrest.Matcher;

import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ChecklistAssert extends UISelectAssert<ChecklistAssert, Checklist> {

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
