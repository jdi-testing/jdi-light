package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;

import com.epam.jdi.light.vuetify.asserts.CalendarAssert;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;
import org.openqa.selenium.WebElement;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * To see an example of Calendars please visit https://v2.vuetifyjs.com/en/components/calendars/
 */

public class Calendar extends UIBaseElement<CalendarAssert> implements HasTheme {

    private static final String INTERVAL_LOCATOR = ".v-calendar-daily__day-interval";
    private static final String INTERVAL_HEADER_LOCATOR = ".v-calendar-daily__interval";
    private static final String INTERVAL_BODY_LOCATOR = ".v-calendar-daily__intervals-body";
    private static final String WEEKLY_LOCATOR = ".v-calendar-weekly__week";
    private static final String WEEKLY_DAY_LOCATOR = ".v-calendar-weekly__day";

    private static final String PRESENT_BUTTON_LOCATOR = ".v-present button";
    private static final String DAYS_LOCATOR = ".v-calendar-daily__day";

    private static final String EVENT_TIMED_LOCATOR = ".v-event-timed";
    private static final String EVENT_ALL_DAY_LOCATOR = ".v-event";
    private static final String CATEGORY_LOCATOR = ".v-calendar-category__category";
    private static final String DAILY_HEAD_WEEKDAY_LOCATOR = ".v-calendar-daily_head-weekday";
    private static final String DAILY_HEAD_DAY_OF_MONTH_LOCATOR = ".v-calendar-daily_head-day-label";
    private static final String WEEKLY_DAY_OF_MONTH_LOCATOR = ".v-calendar-weekly__day-label";
    private static final String CURRENT_TIME_LOCATOR = ".v-current-time";
    private static final String SLOT_LOCATOR = ".v-sheet";

    public List<WebElement> displayedDaysOfMonth() {
        return Stream.of(
                        core().finds(WEEKLY_DAY_OF_MONTH_LOCATOR),
                        core().finds(DAILY_HEAD_DAY_OF_MONTH_LOCATOR)
                     )
                     .filter(WebList::isExist)
                     .map(WebList::webElements)
                     .flatMap(List::stream)
                     .collect(Collectors.toList());
    }

    public WebList events() {
        List<WebElement> events = Stream.of(
                                            core().finds(EVENT_TIMED_LOCATOR),
                                            core().finds(EVENT_ALL_DAY_LOCATOR)
                                        )
                                        .filter(WebList::isExist)
                                        .map(WebList::webElements)
                                        .flatMap(List::stream)
                                        .collect(Collectors.toList());
        return new WebList(events);
    }

    public WebList intervals() {
        return core().finds(INTERVAL_LOCATOR);
    }

    public WebList intervalHeaders() {
        return core().finds(INTERVAL_HEADER_LOCATOR);
    }

    public UIElement intervalBody() {
        return core().find(INTERVAL_BODY_LOCATOR);
    }

    public WebList dayEvents(int day) {
        return core().finds(DAYS_LOCATOR).get(day).finds(EVENT_TIMED_LOCATOR);
    }

    public WebList calendarDays() {
        return core().finds(DAYS_LOCATOR);
    }

    private WebList categories() {
        return core().finds(CATEGORY_LOCATOR);
    }

    public UIElement eventRipple(int eventNumber) {
        return this.events().get(eventNumber).find(".v-ripple__container");
    }

    private UIElement slot(int week, int day, int slot) {
        WebList weeks = core().finds(WEEKLY_LOCATOR);
        return weeks.get(week).finds(WEEKLY_DAY_LOCATOR).get(day).finds(SLOT_LOCATOR).get(slot);
    }

    private int weekdaysCount() {
        return core().finds(DAILY_HEAD_WEEKDAY_LOCATOR).size();
    }

    @JDIAction("Get active date of {name}")
    public int activeDay() {
        return Integer.parseInt(core().find(DAILY_HEAD_DAY_OF_MONTH_LOCATOR).text());
    }

    @JDIAction("Get if {name} has daily type")
    public boolean isDailyType() {
        return weekdaysCount() == 1;
    }

    @JDIAction("Get if {name} has weekly type")
    public boolean isWeeklyType() {
        return weekdaysCount() == 7;
    }

    @JDIAction("Get if {name} has categories")
    public boolean hasCategories() {
        return categories().isNotEmpty();
    }

    @JDIAction("Get if {name} has intervals")
    public boolean hasDayIntervals() {
        return core().finds(INTERVAL_LOCATOR).isNotEmpty();
    }

    @JDIAction("Get {name} {0} category name ")
    public String getCategory(int catNum) {
        return categories().get(catNum).text();
    }

    @JDIAction("Get {name} {0} interval text")
    public String getDayInterval(int intNum) {
        return core().finds(INTERVAL_LOCATOR).get(intNum).text();
    }

    @JDIAction("Check that {name} has the current day")
    public boolean isToday() {
        return core().find(PRESENT_BUTTON_LOCATOR).text()
                                           .equalsIgnoreCase(String.valueOf(GregorianCalendar.getInstance()
                                                   .get(java.util.Calendar.DAY_OF_MONTH)));
    }

    @JDIAction("Get {name} {0} event summary")
    public UIElement dailyEvent(int eventNum) {
        return events().get(eventNum);
    }

    @JDIAction("Select {name} slot")
    public void selectSlot(int week, int day, int slot) {
        slot(week, day, slot).hover();
    }

    @JDIAction("Get {name} slot")
    public String slotTitle(int week, int day, int slot) {
        return slot(week, day, slot).attr("title");
    }

    @JDIAction("Get if {name} has current time line")
    public boolean hasCurrentTimeLine() {
        return core().find(CURRENT_TIME_LOCATOR).isExist();
    }

    @Override
    public CalendarAssert is() {
        return new CalendarAssert().set(this);
    }
}
