package com.epam.jdi.light.asserts.generic;

import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matcher;

import static org.hamcrest.Matchers.is;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public interface ITextAssert<A> {
    @JDIAction("Assert that '{name}' text {0}")
    A text(Matcher<String> condition, String... messages);
    @JDIAction("Assert that '{name}' text {0}")
    default A text(String text, String... messages) { return text(is(text), messages); }
    @JDIAction("Assert that '{name}' value {0}")
    default A value(Matcher<String> condition, String... messages) {
        return text(condition, messages);
    }
    @JDIAction("Assert that '{name}' value {0}")
    default A value(String condition, String... messages) {
        return text(condition, messages);
    }
}