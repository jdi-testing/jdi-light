package com.epam.jdi.light.ui.bootstrap.asserts;

import com.epam.jdi.light.asserts.generic.SelectedAssert;
import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.ui.bootstrap.elements.complex.ListGroup;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

/**
 * Created by Dmitrii Pavlov on 25.09.2019
 * Email: delnote@gmail.com; Skype: Dmitrii Pavlov
 */

public class ListGroupAssert extends UISelectAssert<ListGroupAssert, ListGroup>
        implements SelectedAssert<ListGroupAssert> {

    @JDIAction("Assert that '{name}' is selected")
    public ListGroupAssert selected() {
        jdiAssert(getIsSelected(), Matchers.is("selected"));
        return this;
    }

    @JDIAction("Assert that '{name}' is not selected")
    public ListGroupAssert deselected() {
        jdiAssert(getIsSelected(), Matchers.is("not selected"));
        return this;
    }

    @JDIAction("Assert that '{name}' is enabled")
    public ListGroupAssert enabled() {
        jdiAssert(element.isEnabled() ? "enabled" : "disabled", Matchers.is("enabled"));
        return this;
    }

    @JDIAction("Assert that '{name}' is enabled")
    public ListGroupAssert disabled() {
        jdiAssert(element.isDisabled() ? "disabled" : "enabled", Matchers.is("enabled"));
        return this;
    }

    //protected
    protected String getIsSelected() {
        return element.isSelected() ? "selected" : "not selected";
    }

}
