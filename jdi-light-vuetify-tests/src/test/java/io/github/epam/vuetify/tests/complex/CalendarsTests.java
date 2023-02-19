package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.elements.common.UIElement;
import io.github.com.custom.bars.CalendarToolBar;
import io.github.epam.TestsInit;
import io.github.epam.vuetify.tests.data.CalendarDataProvider;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.function.Consumer;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.calendarsPage;
import static io.github.com.pages.CalendarsPage.darkCalendar;
import static io.github.com.pages.CalendarsPage.eventsClickCalendar;
import static io.github.com.pages.CalendarsPage.miscDragAndDropCalendar;
import static io.github.com.pages.CalendarsPage.slotsDayBodyCalendar;
import static io.github.com.pages.CalendarsPage.slotsDayCalendar;
import static io.github.com.pages.CalendarsPage.typeCategoryCalendar;
import static io.github.com.pages.CalendarsPage.typeDayCalendar;
import static io.github.com.pages.CalendarsPage.typeWeekCalendar;
import static io.github.com.pages.CalendarsPage.toolbarOfEventsClickCalendar;
import static io.github.com.pages.CalendarsPage.toolbarOfTypeCategoryCalendar;
import static org.hamcrest.MatcherAssert.assertThat;


public class CalendarsTests extends TestsInit {

    @BeforeClass
    public static void setup() {
        calendarsPage.open();
        waitCondition(() -> calendarsPage.isOpened());
        calendarsPage.checkOpened();
    }

    @Test(description = "Check navigate to previous/next day")
    public static void typeCategoryCalendarTest() {
        LocalDate today = LocalDate.now();

        typeCategoryCalendar.show();
        toolbarOfTypeCategoryCalendar.nextDay();
        typeCategoryCalendar.has()
                .activeDay(today.plusDays(1).getDayOfMonth());

        toolbarOfTypeCategoryCalendar.previousDay();
        typeCategoryCalendar.has()
                .activeDay(today.getDayOfMonth());

        toolbarOfTypeCategoryCalendar.previousDay();
        typeCategoryCalendar.has()
                .activeDay(today.minusDays(1).getDayOfMonth());

        toolbarOfTypeCategoryCalendar.today();
        typeCategoryCalendar.is().today();

        typeCategoryCalendar.has().categories()
                .and().category(1, "John Smith")
                .and().category(2, "Tori Walker");
    }

    @Test(description = "Check hourly intervals in daily mode")
    public static void typeDayCalendarTest() {
        typeDayCalendar.show();
        typeDayCalendar.is().daily();
        typeDayCalendar.is().today();
        typeDayCalendar.has().intervals()
                .and().dayInterval(3, "2 o'clock")
                .and().dayInterval(7, "6 o'clock");
    }

    @Test(description = "Check presence of events by name in weekly mode")
    public static void typeWeekCalendarTest() {
        typeWeekCalendar.show();
        typeWeekCalendar.is().weekly();
        typeWeekCalendar.has().eventTitle(2, "Mash Potatoes")
                .and().eventTitle(1, "Weekly Meeting");
    }

    @Test(description = "Check switching to daily and weekly modes")
    public static void eventsClickCalendarTest() {
        eventsClickCalendar.show();
        toolbarOfEventsClickCalendar.selectCalendarType("Day");

        eventsClickCalendar.is().daily();
        LocalDate today = LocalDate.now();
        toolbarOfEventsClickCalendar.has().activeMonth(today.getMonth())
                .and().activeYear(today.getYear());

        toolbarOfEventsClickCalendar.selectCalendarType("Week");
        eventsClickCalendar.is().weekly();
        eventsClickCalendar.events().select(3);
        eventsClickCalendar.eventCard().is().visible();
        eventsClickCalendar.closeEvent();
    }

    @Test(description = "Check renaming of an event")
    public void renameEventTest() {
        int eventNumber = 1;
        String newTitle = "New Event Title";
        toolbarOfEventsClickCalendar.selectCalendarType("Week");
        eventsClickCalendar.renameEvent(eventNumber, newTitle);
        eventsClickCalendar.has().eventTitle(eventNumber, newTitle);
    }

    @Test(description = "Check deleting an event")
    public void deleteEventTest() {
        int eventNumber = 1;
        toolbarOfEventsClickCalendar.selectCalendarType("Week");
        int numberOfEventsBefore = eventsClickCalendar.events().size();
        eventsClickCalendar.deleteEvent(eventNumber);

        eventsClickCalendar.has().totalNumberOfEvents(Matchers.lessThanOrEqualTo(numberOfEventsBefore - 1));
    }

    @Test(description = "Check a slot has title",
            dataProvider = "slotsDayCalendarTestData",
            dataProviderClass = CalendarDataProvider.class)
    public static void slotsDayCalendarTest(int week, int day, int slot, String title) {
        slotsDayCalendar.show();
        slotsDayCalendar.selectSlot(week, day, slot);
        slotsDayCalendar.assertThat().slotHasTitle(week, day, slot, title);
    }

    @Test(description = "Check calendar has current time line")
    public static void slotsDayBodyCalendarTest() {
        slotsDayBodyCalendar.show();
        slotsDayBodyCalendar.is().weekly()
                .and().has().intervals()
                .and().currentTimeLine();
    }

    @Test(description = "Check drag-and-dropping an event to a different day")
    public static void miscDragAndDropCalendarTest() {
        miscDragAndDropCalendar.show();

        UIElement event = miscDragAndDropCalendar.dayEvents(4).get(1);
        final int dayNumber = 1;
        int todayEventsNumber = miscDragAndDropCalendar.dayEvents(dayNumber).size();

        UIElement today = miscDragAndDropCalendar.intervals().get(2);
        event.dragAndDropTo(today.getWebElement());

        miscDragAndDropCalendar.has()
                .numberOfEventsPerDay(dayNumber, todayEventsNumber + 1);
    }

    @Test(description = "Check total number of events present on a calendar")
    public void totalNumberOfEventsPresentTest() {
        miscDragAndDropCalendar.show();

        int expectedNumberOfEvents = 16;
        miscDragAndDropCalendar.has()
                .totalNumberOfEvents(expectedNumberOfEvents);
    }

    @Test(description = "Check number of intervals in daily mode")
    public void numberOfIntervalsTest() {
        typeDayCalendar.show();

        typeDayCalendar.has()
                .numberOfIntervals(24);
    }

    @Test(description = "Check dark theme")
    public void darkCalendarTest() {
        darkCalendar.show();
        darkCalendar.has().darkTheme();
    }

    @Test(description = "Check navigating to previous/next week or month",
            dataProvider = "calendarActionsDataProvider",
            dataProviderClass = CalendarDataProvider.class)
    public void navigateNextWeekOrMonthTest(String calendarType, ChronoUnit chronoUnit, long diff, Consumer<CalendarToolBar> action) {
        eventsClickCalendar.show();
        toolbarOfEventsClickCalendar.selectCalendarType(calendarType);

        // pick a day of the main month, because otherwise displayed dates are different in the 'month' view
        eventsClickCalendar.displayedDaysOfMonth().get(6).click();
        LocalDate firstDisplayedDateBefore = LocalDate.of(toolbarOfEventsClickCalendar.activeYear(),
                toolbarOfEventsClickCalendar.activeMonth(),
                eventsClickCalendar.activeDay());

        toolbarOfEventsClickCalendar.selectCalendarType(calendarType);
        action.accept(toolbarOfEventsClickCalendar);

        eventsClickCalendar.displayedDaysOfMonth().get(6).click();
        LocalDate firstDisplayedDateAfter = LocalDate.of(toolbarOfEventsClickCalendar.activeYear(),
                toolbarOfEventsClickCalendar.activeMonth(),
                eventsClickCalendar.activeDay());

        assertThat(
                firstDisplayedDateAfter.minus(diff, chronoUnit),
                Matchers.equalTo(firstDisplayedDateBefore)
        );
    }

    @Test(description = "Check calendar interval width (min, h)")
    public void calendarIntervalWidthTest() {
        typeCategoryCalendar.show();
        typeCategoryCalendar.intervalBody().has().css("width", "60px");
    }

    @Test(description = "Check calendar weekdays=[0,1,2,3]")
    public void calendarWeekdaysTest() {
        darkCalendar.show();
        darkCalendar.calendarDays().has().size(4);
    }
}
