package com.epam.jdi.light.ui.bootstrap.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.ui.bootstrap.elements.common.Progress;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Aleksandr Khmelinin on 2.10.2019
 * Email: aleksandr_khmelinin@epam.com; Skype: live:bea50ebde18b7f9e
 */
public class ProgressAssert extends UIAssert<ProgressAssert, Progress> {
    @JDIAction("Assert that '{name}' value {0}")
    public ProgressAssert value(Matcher<String> condition) {
        jdiAssert(element.value(), condition);
        return this;
    }
    public ProgressAssert value(String value) {
        return value(Matchers.is(value));
    }
    @JDIAction("Assert that '{name}' values {0}")
    public ProgressAssert values(Matcher<? super List<String>> condition) {
        jdiAssert(element.values(), condition);
        return this;
    }
    public ProgressAssert values(String... values) {
        return values(hasItems(values));
    }
    @JDIAction(value = "Get '{name}' min value {0}")
    public ProgressAssert min(Matcher<Integer> condition) {
        jdiAssert(element.min(), condition);
        return this;
    }
    public ProgressAssert min(int minValue) {
        return min(Matchers.is(minValue));
    }

    @JDIAction(value = "Get '{name}' max value {0}")
    public ProgressAssert max(Matcher<Integer> condition) {
        jdiAssert(element.max(), condition);
        return this;
    }
    public ProgressAssert max(int maxValue) {
        return max(Matchers.is(maxValue));
    }
}
