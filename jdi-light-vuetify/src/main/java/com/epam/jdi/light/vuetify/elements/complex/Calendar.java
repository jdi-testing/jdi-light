package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;

import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.init.UIFactory.$$;

import com.epam.jdi.light.vuetify.asserts.CalendarAssert;

import com.epam.jdi.light.vuetify.interfaces.HasTheme;
import java.time.LocalDate;
import java.time.Month;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * To see an example of Calendars please visit https://vuetifyjs.com/en/components/calendars/
 */

public class Calendar extends UIBaseElement<CalendarAssert> implements HasTheme {

    private static final String MENU_LOCATOR = ".menuable__content__active [role='menuitem']";
    private static final String MENU_DOWN_LOCATOR = ".mdi-menu-down";
    private static final String INTERVAL_LOCATOR = ".v-calendar-daily__day-interval";
    private static final String WEEKLY_LOCATOR = ".v-calendar-weekly__week";
    private static final String WEEKLY_DAY_LOCATOR = ".v-calendar-weekly__day";

    private static final String TODAY_LOCATOR = ".v-present";
    private static final String PRESENT_BUTTON_LOCATOR = ".v-present button";
    private static final String TODAY_BUTTON_LOCATOR = "//span[contains(text(),'Today')]";
    private static final String DAYS_LOCATOR = ".v-calendar-daily__day";
    private static final String PREVIOUS_DAY_LOCATOR = ".mdi-chevron-left";
    private static final String NEXT_DAY_LOCATOR = ".mdi-chevron-right";

    private static final String EVENT_TIMED_LOCATOR = ".v-event-timed";
    private static final String EVENT_ALL_DAY_LOCATOR = ".v-event";
    private static final String EVENT_CARD_LOCATOR = ".v-card--flat";
    private static final String EVENT_MENU_LOCATOR = "//ancestor::div[@role='menu']";
    private static final String EVENT_CANCEL_BUTTON_LOCATOR = "//span[contains(text(), 'Cancel')]";

    private static final String CATEGORY_LOCATOR = ".v-calendar-category__category";
    private static final String DAILY_HEAD_WEEKDAY_LOCATOR = ".v-calendar-daily_head-weekday";
    private static final String DAILY_HEAD_DAY_OF_MONTH_LOCATOR = ".v-calendar-daily_head-day-label";
    private static final String ACTIVE_MONTH_LOCATOR = ".v-toolbar__title";
    private static final String CURRENT_TIME_LOCATOR = ".v-current-time";
    private static final String SLOT_LOCATOR = ".v-sheet";

    private static final String THEME_LOCATOR = "// div[contains(@class, 'theme--')]";

    public WebList events() {
        WebList timedEvents = finds(EVENT_TIMED_LOCATOR);
        return timedEvents.isExist() ? timedEvents : finds(EVENT_ALL_DAY_LOCATOR);
    }

    public WebList days() {
        return finds(DAYS_LOCATOR);
    }

    public WebList intervals() {
        return finds(INTERVAL_LOCATOR);
    }

    public WebList dailyEvents(int day) {
        return finds(DAYS_LOCATOR).get(day).finds(EVENT_TIMED_LOCATOR);
    }

    private WebList categories() {
        return finds(CATEGORY_LOCATOR);
    }

    private UIElement eventCard() {
        return $(EVENT_CARD_LOCATOR);
    }

    private UIElement slot(int week, int day, int slot) {
        WebList weeks = finds(WEEKLY_LOCATOR);
        return weeks.get(week).finds(WEEKLY_DAY_LOCATOR).get(day).finds(SLOT_LOCATOR).get(slot);
    }

    public WebList menu() {
        return $$(MENU_LOCATOR);
    }

    private int weekdaysNumber() {
        return finds(DAILY_HEAD_WEEKDAY_LOCATOR).size();
    }

    @JDIAction("Get active date of {name}")
    public LocalDate getActiveDate() {
        if (!isDailyType()) {
            throw new RuntimeException("Calendar is not in daily mode. Cannot define active date.");
        }

        String[] yearAndMonth = find(ACTIVE_MONTH_LOCATOR)
            .text()
            .trim()
            .split("\\s");

        Month month = Month.valueOf(yearAndMonth[0].toUpperCase(Locale.ROOT));
        int year = Integer.parseInt(yearAndMonth[1]);
        int dayOfMonth = Integer.parseInt(find(DAILY_HEAD_DAY_OF_MONTH_LOCATOR).text());

        return LocalDate.of(year, month, dayOfMonth);
    }

    @JDIAction("Check that {name} has daily type")
    public boolean isDailyType() {
        return weekdaysNumber() == 1;
    }

    @JDIAction("Check that {name} has weekly type")
    public boolean isWeeklyType() {
        return weekdaysNumber() == 7;
    }

    @JDIAction("Check that {name} has categories")
    public boolean hasCategories() {
        return categories().isNotEmpty();
    }

    @JDIAction("Check that {name} has intervals")
    public boolean hasDayIntervals() {
        return finds(INTERVAL_LOCATOR).isNotEmpty();
    }

    @JDIAction("Get {name} {0} category name ")
    public String getCategory(int catNum) {
        return categories().get(catNum).text();
    }

    @JDIAction("Get {name} {0} interval text")
    public String getDayInterval(int intNum) {
        return finds(INTERVAL_LOCATOR).get(intNum).text();
    }

    @JDIAction("Switch {name} to the previous day")
    public void previousDay() {
        find(PREVIOUS_DAY_LOCATOR).click();
    }

    @JDIAction("Switch {name} to the next day")
    public void nextDay() {
        find(NEXT_DAY_LOCATOR).click();
    }

    @JDIAction("Switch {name} to the present day")
    public void today() {
        find(TODAY_BUTTON_LOCATOR).click();
    }

    @JDIAction("Check that {name} has the current day")
    public boolean isToday() {
        return find(PRESENT_BUTTON_LOCATOR).text()
                                           .equalsIgnoreCase(String.valueOf(new GregorianCalendar().get(java.util.Calendar.DAY_OF_MONTH)));
    }

    @JDIAction("Get {name} {0} event name")
    public String getDailyEvent(int eventNum) {
        return events().get(eventNum).text();
    }

    public void openMenu() {
        find(MENU_DOWN_LOCATOR).click();
    }

    @JDIAction("Close {name} event")
    public void closeEvent() {
        eventCard().find(EVENT_CANCEL_BUTTON_LOCATOR).click();
    }

    @JDIAction("Check that {name} event is opened")
    public boolean isEventOpened() {
        return eventCard().find(EVENT_MENU_LOCATOR).attr("class").contains("active");
    }

    @JDIAction("Select {name} slot")
    public void selectSlot(int week, int day, int slot) {
        slot(week, day, slot).hover();
    }

    @JDIAction("Get {name} slot")
    public String getSlot(int week, int day, int slot) {
        return slot(week, day, slot).attr("title");
    }

    @JDIAction("Check that {name} has current time line")
    public boolean hasCurrentTimeLine() {
        return find(CURRENT_TIME_LOCATOR).isExist();
    }

    @Override
    public CalendarAssert is() {
        return new CalendarAssert().set(this);
    }

    @Override
    public String theme() {
        return core().find(THEME_LOCATOR).classLike("theme--");
    }
}
