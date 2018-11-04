package com.epam.jdi.light.ui.html.asserts;

import org.hamcrest.Matcher;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public interface DateTimeAssert {
    void min(String value);
    void max(String value);

    void date(Matcher<String> date);
    void month(Matcher<String> month);
    void week(Matcher<String> week);
    void time(Matcher<String> time);
}