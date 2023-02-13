package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.complex.Calendar;
import io.github.com.custom.bars.CalendarToolBar;

public class CalendarsPage extends VuetifyPage {

    @UI("#calendar-type-category")
    public static Calendar typeCategoryCalendar;

    @UI("#TypeDayCalendar .v-calendar")
    public static Calendar typeDayCalendar;

    @UI("#calendar-type-week")
    public static Calendar typeWeekCalendar;

    @UI("#calendar-events-click")
    public static Calendar eventsClickCalendar;

    @UI("#EventsClickCalendar .v-toolbar__content")
    public static CalendarToolBar toolbarOfEventsClickCalendar;
    @UI("#TypeCategoryCalendar .v-toolbar__content")
    public static CalendarToolBar toolbarOfTypeCategoryCalendar;

    @UI("#calendar-slots-day")
    public static Calendar slotsDayCalendar;

    @UI("#calendar-slots-day-body")
    public static Calendar slotsDayBodyCalendar;

    @UI("#MiscDragAndDropCalendar .v-calendar")
    public static Calendar miscDragAndDropCalendar;

    @UI("#DarkCalendar .v-calendar")
    public static Calendar darkCalendar;
}
