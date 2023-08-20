package com.epam.jdi.light.angular.asserts;

import com.epam.jdi.light.angular.elements.common.Icon;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class IconAssert extends UIAssert<IconAssert, Icon> {
    
    @JDIAction("Assert that '{name}' has type '{0}'")
    public IconAssert type(String expectedType) {
        jdiAssert(element().type(), Matchers.equalToIgnoringCase(expectedType));
        return this;
    }

}
