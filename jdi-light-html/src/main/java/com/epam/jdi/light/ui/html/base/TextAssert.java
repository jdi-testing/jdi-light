package com.epam.jdi.light.ui.html.base;

import org.hamcrest.Matcher;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public interface TextAssert {
    void text(Matcher<String> condition);
}