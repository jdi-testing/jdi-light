package com.epam.jdi.light.mobile.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.mobile.elements.common.app.android.RatingBar;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class RatingBarAssert extends UIAssert<RatingBarAssert, RatingBar> {

    @JDIAction("Assert that {name} is {value}")
    public RatingBarAssert value(double value){
        jdiAssert(element.get().getRating(), Matchers.equalTo(value));
        return this;
    }

}
