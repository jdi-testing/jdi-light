package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;

import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.init.UIFactory.$$;

import com.epam.jdi.light.vuetify.asserts.CalendarAssert;

import java.util.GregorianCalendar;


/**
 * To see an example of Calendars please visit https://vuetifyjs.com/en/components/calendars/
 */

public class Calendar extends UIBaseElement<CalendarAssert> {

    private static final String MENU_LOCATOR = ".menuable__content__active [role='menuitem']";
    private static final String INTERVAL_LOCATOR = ".v-calendar-daily__day-interval";
    private static final String WEEKLY_LOCATOR = ".v-calendar-weekly__week";
    private static final String WEEKLY_DAY_LOCATOR = ".v-calendar-weekly__day";

    private static final String TODAY_LOCATOR = ".v-present";
    private static final String DAYS_LOCATOR = ".v-calendar-daily__day";
    private static final String EVENT_LOCATOR = ".v-event-timed";

    public WebList events() {
        if (finds(EVENT_LOCATOR).isExist()) {
            return finds(EVENT_LOCATOR);
        } else {
            return finds(".v-event");
        }
    }

    public WebList days() {
        return finds(DAYS_LOCATOR);
    }

    public WebList intervals() {
        return finds(INTERVAL_LOCATOR);
    }

    public WebList dailyEvents(int day) {
        return finds(DAYS_LOCATOR).get(day).finds(EVENT_LOCATOR);
    }

    private WebList categories() {
        return finds(".v-calendar-category__category");
    }

    private UIElement eventCard() {
        return $(".v-card--flat");
    }

    private UIElement slot(int week, int day, int slot) {
        WebList weeks = finds(WEEKLY_LOCATOR);
        return weeks.get(week).finds(WEEKLY_DAY_LOCATOR).get(day).finds(".v-sheet").get(slot);
    }

    public WebList menu() {
        return $$(MENU_LOCATOR);
    }

    private int weekdaysNumber() {
        return finds(".v-calendar-daily_head-weekday").size();
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
        find(".mdi-chevron-left").click();
    }

    @JDIAction("Switch {name} to the next day")
    public void nextDay() {
        find(".mdi-chevron-right").click();
    }

    @JDIAction("Switch {name} to the present day")
    public void today() {
        find("//span[contains(text(),'Today')]").click();
    }

    @JDIAction("Check that {name} has the current day")
    public boolean isToday() {
        return find(".v-present button").text()
                .equalsIgnoreCase(String.valueOf(new GregorianCalendar().get(java.util.Calendar.DAY_OF_MONTH)));
    }

    @JDIAction("Get {name} {0} event name")
    public String getDailyEvent(int eventNum) {
        return events().get(eventNum).text();
    }

    public void openMenu() {
        find(".mdi-menu-down").click();
    }

    @JDIAction("Close {name} event")
    public void closeEvent() {
        eventCard().find("//span[contains(text(), 'Cancel')]").click();
    }

    @JDIAction("Check that {name} event is opened")
    public boolean isEventOpened() {
        return eventCard().find("//ancestor::div[@role='menu']").attr("class").contains("active");
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
        return find(".v-current-time").isExist();
    }

    @Override
    public CalendarAssert is() {
        return new CalendarAssert().set(this);
    }
}
