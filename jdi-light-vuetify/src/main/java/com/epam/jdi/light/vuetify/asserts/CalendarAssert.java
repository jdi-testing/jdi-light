package com.epam.jdi.light.vuetify.asserts;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.Calendar;
import org.hamcrest.Matchers;
import static org.hamcrest.Matchers.containsString;

public class CalendarAssert extends UIAssert<CalendarAssert, Calendar> {

    @JDIAction("Assert that {name} is of daily type")
    public CalendarAssert daily() {
        jdiAssert(element().isDailyType(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} is of weekly type")
    public CalendarAssert weekly() {
        jdiAssert(element().isWeeklyType(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} has the current day")
    public CalendarAssert today() {
        jdiAssert(element().isToday(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} has the category")
    public CalendarAssert category(int catNum, String catName) {
        jdiAssert(element().getCategory(catNum), Matchers.is(catName));
        return this;
    }

    @JDIAction("Assert that {name} has the event")
    public CalendarAssert event(int eventNum, String eventName) {
        jdiAssert(element().getDailyEvent(eventNum), Matchers.is(containsString(eventName)));
        return this;
    }

    @JDIAction("Assert that {name} has the day interval")
    public CalendarAssert dayInterval(int intNum, String intText) {
        jdiAssert(element().getDayInterval(intNum), Matchers.is(intText));
        return this;
    }

    @JDIAction("Assert that {name} has categories")
    public CalendarAssert hasCategories() {
        jdiAssert(element().hasCategories(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} has intervals")
    public CalendarAssert hasIntervals() {
        jdiAssert(element().hasDayIntervals(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} event is opened")
    public CalendarAssert eventIsOpened() {
        jdiAssert(element().eventIsOpened(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that the {name} slot has the title")
    public CalendarAssert slotHasTitle(int week, int day, int slot, String title) {
        jdiAssert(element().getSlot(week, day, slot), Matchers.is(title));
        return this;
    }

    @JDIAction("Assert that {name} has the current time line")
    public CalendarAssert currentTimeLine() {
        jdiAssert(element().hasCurrentTimeLine(), Matchers.is(true));
        return this;
    }

}
