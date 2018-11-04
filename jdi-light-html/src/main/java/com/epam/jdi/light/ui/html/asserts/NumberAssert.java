package com.epam.jdi.light.ui.html.asserts;

import org.hamcrest.Matcher;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public interface NumberAssert {
    void minValue(double value);
    void maxValue(double value);
    void stepValue(double value);
    void placeholder(Matcher<String> value);
    void number(Matcher<Double> matcher);
}