package com.epam.jdi.light.ui.bootstrap.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.ui.bootstrap.elements.common.Progress;
import org.hamcrest.Matcher;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static org.hamcrest.Matchers.is;

/**
 * Created by Aleksandr Khmelinin on 2.10.2019
 * Email: aleksandr_khmelinin@epam.com; Skype: live:bea50ebde18b7f9e
 */
public class ProgressAssert extends UIAssert<ProgressAssert, Progress> {
    @JDIAction("Assert that '{name}' value {0}")
    public ProgressAssert ariaValue(Matcher<String> condition) {
        jdiAssert(element.getAriaValue(), condition);
        return this;
    }
    public ProgressAssert ariaValue(String value) {
        return ariaValue(is(value));
    }

    @JDIAction("Assert that '{name}' value {0}")
    public ProgressAssert ariaMaxValue(Matcher<String> condition) {
        jdiAssert(element.getMaxValue(), condition);
        return this;
    }
    public ProgressAssert ariaMaxValue(String value) {
        return ariaValue(is(value));
    }

    @JDIAction("Assert that '{name}' value {0}")
    public ProgressAssert ariaMinValue(Matcher<String> condition) {
        jdiAssert(element.getMinValue(), condition);
        return this;
    }
    public ProgressAssert ariaMinValue(String value) {
        return ariaValue(is(value));
    }

    @JDIAction("Assert that '{name}' color {0}")
    public ProgressAssert color(Matcher<String> condition) {
        jdiAssert(element.getColor(), condition);
        return this;
    }
    public ProgressAssert color(String color) {
        return color(is(color));
    }

    @JDIAction("Assert that '{name}' is animated")
    public ProgressAssert animated() {
        jdiAssert(element.css("animation-play-state"), is("running"));
        //jdiAssert(element.core().css("animation-play-state"), true);
        return this;
    }

   /* protected String getIsAnimated() {
        return element.css("dfs", is("df"));
    }*/
}
