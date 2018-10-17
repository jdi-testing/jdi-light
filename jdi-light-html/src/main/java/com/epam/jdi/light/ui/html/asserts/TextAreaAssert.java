package com.epam.jdi.light.ui.html.asserts;

import org.hamcrest.Matcher;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public interface TextAreaAssert extends TextAssert {
    void rows(Matcher<Integer> condition);
    void cols(Matcher<Integer> condition);
    void minlength(Matcher<Integer> condition);
    void maxlength(Matcher<Integer> condition);

}
