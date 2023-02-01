package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.complex.Calendar;
import com.epam.jdi.light.vuetify.elements.complex.bars.CalendarToolBar;

public class CalendarsPage extends VuetifyPage {

    @UI("#calendar-type-category")
    public static Calendar typeCategoryCalendar;

    @UI("#TypeDayCalendar")
    public static Calendar typeDayCalendar;

    @UI("#TypeWeekCalendar")
    public static Calendar typeWeekCalendar;

    @UI("#calendar-events-click")
    public static Calendar eventsClickCalendar;

    @UI("#EventsClickCalendar .v-toolbar__content")
    public static CalendarToolBar toolbarOfEventsClickCalendar;
    @UI("#TypeCategoryCalendar .v-toolbar__content")
    public static CalendarToolBar toolbarOfTypeCategoryCalendar;

    @UI("#SlotsDayCalendar")
    public static Calendar slotsDayCalendar;

    @UI("#SlotsDayBodyCalendar")
    public static Calendar slotsDayBodyCalendar;

    @UI("#MiscDragAndDropCalendar")
    public static Calendar miscDragAndDropCalendar;

    @UI("#DarkCalendar .v-sheet")
    public static Calendar darkCalendar;
}
