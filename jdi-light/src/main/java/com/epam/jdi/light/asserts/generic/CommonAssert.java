package com.epam.jdi.light.asserts.generic;

import com.epam.jdi.light.asserts.core.IsAssert;
import com.epam.jdi.light.asserts.core.SoftAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.tools.func.JFunc1;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public interface CommonAssert<A> extends JAssert, HasAssert<A> {
    A displayed();
    A disappear();
    A hidden();
    A shown();
    A notAppear();
    A notAppear(int timeoutSec);
    A enabled();
    A disabled();
    A attr(String attrName, Matcher<String> condition);
    A attr(String attrName, String value);
    A css(String css, Matcher<String> condition);
    A css(String css, String value);
    A cssClasses(Matcher<? super List<String>> condition);
    A classValue(Matcher<String> condition);
    A classValue(String value);
    A cssClass(String className);
    A tag(Matcher<String> condition);
    A tag(String tagName);
    A visible();

    default A and() { return (A) this; }
    default A condition(JFunc1<A, A> t) {
        return t.execute((A) this);
    }

    default void assertResults() {
        SoftAssert.assertResults();
    }
}
