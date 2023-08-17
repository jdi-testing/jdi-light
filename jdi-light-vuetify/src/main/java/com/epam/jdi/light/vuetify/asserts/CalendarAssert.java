package com.epam.jdi.light.vuetify.asserts;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.Calendar;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static org.hamcrest.Matchers.containsString;

public class CalendarAssert extends UIAssert<CalendarAssert, Calendar>
    implements ThemeAssert<CalendarAssert, Calendar> {

    /**
     * Assert element name is of daily type
     *
     * @return Assert object for chain creation
     */
    @JDIAction("Assert that {name} is of daily type")
    public CalendarAssert daily() {
        jdiAssert(element().isDailyType(), Matchers.is(true), "calendar's type is not 'daily'");
        return this;
    }

    /**
     * Assert element name is of weekly type
     *
     * @return Assert object for chain creation
     */
    @JDIAction("Assert that {name} is of weekly type")
    public CalendarAssert weekly() {
        jdiAssert(element().isWeeklyType(), Matchers.is(true), "calendar's type is not 'weekly'");
        return this;
    }

    /**
     * Assert element name is today
     *
     * @return Assert object for chain creation
     */
    @JDIAction("Assert that {name} has the today")
    public CalendarAssert today() {
        jdiAssert(element().isToday(), Matchers.is(true), "calendar's day is no 'today'");
        return this;
    }

    /**
     * Assert element name has the category
     *
     * @param catNum category index
     * @param catName expected category name
     *
     * @return Assert object for chain creation
     */
    @JDIAction("Assert that {name} has the category")
    public CalendarAssert category(int catNum, String catName) {
        jdiAssert(element().getCategory(catNum), Matchers.is(catName));
        return this;
    }

    /**
     * Assert element name has the event
     *
     * @param eventNum event index
     * @param eventName expected part of the name
     * @return Assert object for chain creation
     */
    @JDIAction("Assert that {name} has the event with num {0} title {1}")
    public CalendarAssert eventTitle(int eventNum, String eventName) {
        jdiAssert(element().dailyEvent(eventNum).text(), Matchers.is(containsString(eventName)));
        return this;
    }

    /**
     * Assert element name has the day interval
     *
     * @param intNum interval index
     * @param intText expected interval title
     * @return Assert object for chain creation
     */
    @JDIAction("Assert that {name} has the day interval")
    public CalendarAssert dayInterval(int intNum, String intText) {
        jdiAssert(element().getDayInterval(intNum), Matchers.is(intText));
        return this;
    }

    /**
     * Assert element name has the categories
     *
     * @return Assert object for chain creation
     */
    @JDIAction("Assert that {name} has categories")
    public CalendarAssert categories() {
        jdiAssert(element().hasCategories(), Matchers.is(true), "Calendar has no categories");
        return this;
    }

    /**
     * Assert element name has intervals
     *
     * @return Assert object for chain creation
     */
    @JDIAction("Assert that {name} has intervals")
    public CalendarAssert intervals() {
        jdiAssert(element().hasDayIntervals(), Matchers.is(true), "Calendar has no day intervals");
        return this;
    }

    /**
     * Assert element name slot has the title
     *
     * @param week week number
     * @param day day number
     * @param slot slot number
     * @param title expected title
     *
     * @return Assert object for chain creation
     */
    @JDIAction("Assert that the {name} slot has the title")
    public CalendarAssert slotHasTitle(int week, int day, int slot, String title) {
        jdiAssert(element().slotTitle(week, day, slot), Matchers.is(title));
        return this;
    }

    /**
     * Assert element name slot has the current timeline
     *
     * @return Assert object for chain creation
     */
    @JDIAction("Assert that {name} has the current time line")
    public CalendarAssert currentTimeLine() {
        jdiAssert(element().hasCurrentTimeLine(), Matchers.is(true), "Calendar has NO current timeline");
        return this;
    }

    @JDIAction("Assert that {name} has expected number of daily events")
    public CalendarAssert numberOfEventsPerDay(int dayNumber, int expectedNumberOfEvents) {
        int actualNumberOfEvents = element().dayEvents(dayNumber).size();
        jdiAssert(
            actualNumberOfEvents,
            Matchers.equalTo(expectedNumberOfEvents),
            String.format(
                "Wrong number of daily events. Expected: %d, but was: %d",
                expectedNumberOfEvents, actualNumberOfEvents
            )
        );
        return this;
    }

    @JDIAction("Assert that {name} has expected number of daily events")
    public CalendarAssert totalNumberOfEvents(int expectedNumberOfEvents) {
        int actualNumberOfEvents = element().events().size();
        jdiAssert(
            actualNumberOfEvents,
            Matchers.equalTo(expectedNumberOfEvents),
            String.format(
                "Wrong number of events. Expected: %d, but was: %d",
                expectedNumberOfEvents, actualNumberOfEvents
            )
        );
        return this;
    }

    @JDIAction("Assert that {name} has expected number of daily events")
    public CalendarAssert totalNumberOfEvents(Matcher<Integer> condition) {
        int actualNumberOfEvents = element().events().size();
        jdiAssert(actualNumberOfEvents, condition);
        return this;
    }

    @JDIAction("Assert that {name} has active date")
    public CalendarAssert activeDay(int expectedDayOfMonth) {
        int actualDay = element().activeDay();
        jdiAssert(
                actualDay,
            Matchers.equalTo(expectedDayOfMonth),
            String.format(
                "Wrong active day. Expected: %s, but was: %s",
                    expectedDayOfMonth, actualDay
            )
        );
        return this;
    }

    @JDIAction("Assert that {name} has number of intervals")
    public CalendarAssert numberOfIntervals(int expectedNumberOfIntervals) {
        int actualNumberOfIntervals = element().intervalHeaders().size();
        jdiAssert(
            actualNumberOfIntervals,
            Matchers.equalTo(expectedNumberOfIntervals),
            String.format(
                "Wrong number of intervals. Expected: %d, but was: %d",
                expectedNumberOfIntervals, actualNumberOfIntervals
            )
        );
        return this;
    }
}
