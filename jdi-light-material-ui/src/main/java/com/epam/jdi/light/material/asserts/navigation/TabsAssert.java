package com.epam.jdi.light.material.asserts.navigation;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.navigation.Tabs;

import static org.hamcrest.Matchers.containsString;

public class TabsAssert extends UIAssert<TabsAssert, Tabs> {

    @JDIAction("Assert that tab {name} root is disabled")
    public TabsAssert disabled(){
        element().has().classValue(containsString("Mui-disabled"));
        return this;
    }
}
