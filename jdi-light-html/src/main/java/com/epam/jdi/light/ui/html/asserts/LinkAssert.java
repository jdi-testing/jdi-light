package com.epam.jdi.light.ui.html.asserts;

import org.hamcrest.Matcher;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public interface LinkAssert {
    void text(Matcher<String> condition);
    void ref(Matcher<String> condition);
    void alt(Matcher<String> condition);

}
