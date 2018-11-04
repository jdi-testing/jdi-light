package com.epam.jdi.light.ui.html.asserts;

import org.hamcrest.Matcher;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public interface RangeAssert {
    void minVolume(int value);
    void maxVolume(int value);
    void step(int value);
    void volume(Matcher<Integer> matcher);
}