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
        jdiAssert(element().isDailyType() ? "calendar's type is 'daily'"
                : "calendar has another type", Matchers.is("calendar's type is 'daily'"));
        return this;
    }

    @JDIAction("Assert that {name} is of weekly type")
    public CalendarAssert weekly() {
        jdiAssert(element().isWeeklyType() ? "calendar's type is 'weekly'"
                : "calendar has another type", Matchers.is("calendar's type is 'weekly'"));
        return this;
    }

    @JDIAction("Assert that {name} has the current day")
    public CalendarAssert today() {
        jdiAssert(element().isToday() ? "calendar's day is 'today'"
                : "calendar's day is not 'today'", Matchers.is("calendar's day is 'today'"));
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
    public CalendarAssert categories() {
        jdiAssert(element().hasCategories() ? "calendar has categories"
                : "there are no categories", Matchers.is("calendar has categories"));
        return this;
    }

    @JDIAction("Assert that {name} has intervals")
    public CalendarAssert intervals() {
        jdiAssert(element().hasDayIntervals() ? "calendar has intervals"
                : "there are no intervals", Matchers.is("calendar has intervals"));
        return this;
    }

    @JDIAction("Assert that {name} event is opened")
    public CalendarAssert eventIsOpened() {
        jdiAssert(element().eventIsOpened() ? "event is opened"
                : "event isn't opened", Matchers.is("event is opened"));
        return this;
    }

    @JDIAction("Assert that the {name} slot has the title")
    public CalendarAssert slotHasTitle(int week, int day, int slot, String title) {
        jdiAssert(element().getSlot(week, day, slot), Matchers.is(title));
        return this;
    }

    @JDIAction("Assert that {name} has the current time line")
    public CalendarAssert currentTimeLine() {
        jdiAssert(element().hasCurrentTimeLine() ? "calendar has current time line"
                : "current time line not found", Matchers.is("calendar has current time line"));
        return this;
    }

}
