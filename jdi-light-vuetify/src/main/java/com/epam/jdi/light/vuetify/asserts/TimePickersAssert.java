package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.DatePicker;
import com.epam.jdi.light.vuetify.elements.complex.TimePickers;
import com.epam.jdi.tools.Timer;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;


//public class TimePickersAssert extends UISelectAssert<TimePickersAssert, TimePickers> {
//
//    @Override
//    @JDIAction("Assert that {name} is enabled")
//    public TimePickersAssert enabled() {
//        jdiAssert(element().enabled() ? "enabled" : "not enabled", Matchers.is("enabled"));
//        return this;
//    }
//
//    @Override
//    @JDIAction("Assert that {name} is disabled")
//    public TimePickersAssert disabled() {
//        jdiAssert(element().disabled() ? "disabled" : "not disabled", Matchers.is("disabled"));
//        return this;
//    }
//
//    @Override
//    @JDIAction("Assert that {name} has selected element {0}")
//    public TimePickersAssert selected(String value) {
//        jdiAssert(element().get(value).hasClass("v-time-picker-clock__item--active")
//                ? "selected" : "not selected", Matchers.is("selected"));
//        return this;
//    }
//
//    @Override
//    @JDIAction("Assert that {name} has selected element {0}")
//    public TimePickersAssert selected(int value) {
//        jdiAssert(element().get(value).hasClass("v-time-picker-clock__item--active")
//                ? "selected" : "not selected", Matchers.is("selected"));
//        return this;
//    }
//
//    @JDIAction("Assert that {name} has enabled element {0}")
//    public TimePickersAssert elementEnabled(String value) {
//        jdiAssert(element().elementEnabled(value) ?
//                "element enabled" : "element is not enabled", Matchers.is("element enabled"));
//        return this;
//    }
//
//    @JDIAction("Assert that {name} has enabled element {0}")
//    public TimePickersAssert elementEnabled(int value) {
//        jdiAssert(element().elementEnabled(value) ?
//                "element enabled" : "element is not enabled", Matchers.is("element enabled"));
//        return this;
//    }
//
//    @JDIAction("Assert that {name} has disabled element {0}")
//    public TimePickersAssert elementDisabled(String value) {
//        jdiAssert(element().elementDisabled(value) ?
//                "element disabled" : "element is enabled", Matchers.is("element disabled"));
//        return this;
//    }
//
//    @JDIAction("Assert that {name} has disabled element {0}")
//    public TimePickersAssert elementDisabled(int value) {
//        jdiAssert(element().elementDisabled(value) ?
//                "element disabled" : "element is enabled", Matchers.is("element disabled"));
//        return this;
//    }
//}


public class TimePickersAssert extends UIAssert<TimePickersAssert, TimePickers>{


//        @JDIAction("Assert that picker title has correct value")
//        public DatePickerAssert date(String expectedTime) {
//            //Timer.waitCondition(() -> element().getDate().equals(expectedTime));
//            jdiAssert(element().getDate(), Matchers.is(expectedDate));
//            return this;
//        }
    //
    //    @JDIAction("Assert that field color is correct")
    //    public DatePickerAssert color(String expectedColor) {
    //        jdiAssert(element().getColor(), Matchers.is(expectedColor));
    //        return this;
    //    }


}