package com.epam.jdi.mobile.asserts.complex;

import com.epam.jdi.mobile.asserts.generic.UISelectAssert;
import com.epam.jdi.mobile.common.JDIAction;
import com.epam.jdi.mobile.elements.interfaces.complex.IsChecklist;
import org.hamcrest.Matcher;

import java.util.List;

import static com.epam.jdi.mobile.asserts.core.SoftAssert.jdiAssert;

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
        jdiAssert(element.checked(), condition);
        return this;
    }
}
