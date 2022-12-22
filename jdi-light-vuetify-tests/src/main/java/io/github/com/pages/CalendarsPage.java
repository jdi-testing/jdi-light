package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.complex.Calendar;

public class CalendarsPage extends VuetifyPage {

    @UI("#TypeCategoryCalendar")
    public static Calendar typeCategoryCalendar;

    @UI("#TypeDayCalendar")
    public static Calendar typeDayCalendar;

    @UI("#TypeWeekCalendar")
    public static Calendar typeWeekCalendar;

    @UI("#EventsClickCalendar")
    public static Calendar eventsClickCalendar;

    @UI("#SlotsDayCalendar")
    public static Calendar slotsDayCalendar;

    @UI("#SlotsDayBodyCalendar")
    public static Calendar slotsDayBodyCalendar;

    @UI("#MiscDragAndDropCalendar")
    public static Calendar miscDragAndDropCalendar;

    @UI("#DarkCalendar")
    public static Calendar darkCalendar;
}
