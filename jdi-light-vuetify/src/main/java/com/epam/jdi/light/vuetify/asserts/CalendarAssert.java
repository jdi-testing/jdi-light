package com.epam.jdi.light.vuetify.asserts;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.Calendar;
import org.hamcrest.Matchers;

import static org.hamcrest.Matchers.containsString;

public class CalendarAssert extends UIAssert<CalendarAssert, Calendar> {

    /**
     * Assert element name is of daily type
     *
     * @return daily type or not daily type
     */
    @JDIAction("Assert that {name} is of daily type")
    public CalendarAssert daily() {
        jdiAssert(element().isDailyType() ? "calendar's type is 'daily'"
                : "calendar has another type", Matchers.is("calendar's type is 'daily'"));
        return this;
    }

    /**
     * Assert element name is of weekly type
     *
     * @return weekly type or not weekly type
     */
    @JDIAction("Assert that {name} is of weekly type")
    public CalendarAssert weekly() {
        jdiAssert(element().isWeeklyType() ? "calendar's type is 'weekly'"
                : "calendar has another type", Matchers.is("calendar's type is 'weekly'"));
        return this;
    }

    /**
     * Assert element name is today
     *
     * @return today or not today
     */
    @JDIAction("Assert that {name} has the current day")
    public CalendarAssert today() {
        jdiAssert(element().isToday() ? "calendar's day is 'today'"
                : "calendar's day is not 'today'", Matchers.is("calendar's day is 'today'"));
        return this;
    }

    /**
     * Assert element name has the category
     *
     * @return has category or not
     */
    @JDIAction("Assert that {name} has the category")
    public CalendarAssert category(int catNum, String catName) {
        jdiAssert(element().getCategory(catNum), Matchers.is(catName));
        return this;
    }

    /**
     * Assert element name has the event
     *
     * @return has event or not
     */
    @JDIAction("Assert that {name} has the event")
    public CalendarAssert event(int eventNum, String eventName) {
        jdiAssert(element().getDailyEvent(eventNum), Matchers.is(containsString(eventName)));
        return this;
    }

    /**
     * Assert element name has the day interval
     *
     * @return has day interval or not
     */
    @JDIAction("Assert that {name} has the day interval")
    public CalendarAssert dayInterval(int intNum, String intText) {
        jdiAssert(element().getDayInterval(intNum), Matchers.is(intText));
        return this;
    }

    /**
     * Assert element name has the categories
     *
     * @return has categories or not
     */
    @JDIAction("Assert that {name} has categories")
    public CalendarAssert categories() {
        jdiAssert(element().hasCategories() ? "calendar has categories"
                : "there are no categories", Matchers.is("calendar has categories"));
        return this;
    }

    /**
     * Assert element name has intervals
     *
     * @return has intervals or not
     */
    @JDIAction("Assert that {name} has intervals")
    public CalendarAssert intervals() {
        jdiAssert(element().hasDayIntervals() ? "calendar has intervals"
                : "there are no intervals", Matchers.is("calendar has intervals"));
        return this;
    }

    /**
     * Assert element name event is opened
     *
     * @return is opened or not
     */
    @JDIAction("Assert that {name} event is opened")
    public CalendarAssert eventIsOpened() {
        jdiAssert(element().isEventOpened() ? "event is opened"
                : "event isn't opened", Matchers.is("event is opened"));
        return this;
    }

    /**
     * Assert element name slot has the title
     *
     * @return has the title or not
     */
    @JDIAction("Assert that the {name} slot has the title")
    public CalendarAssert slotHasTitle(int week, int day, int slot, String title) {
        jdiAssert(element().getSlot(week, day, slot), Matchers.is(title));
        return this;
    }

    /**
     * Assert element name slot has the current time line
     *
     * @return has the current time line or not
     */
    @JDIAction("Assert that {name} has the current time line")
    public CalendarAssert currentTimeLine() {
        jdiAssert(element().hasCurrentTimeLine() ? "calendar has current time line"
                : "current time line not found", Matchers.is("calendar has current time line"));
        return this;
    }

}
