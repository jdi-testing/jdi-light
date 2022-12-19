package io.github.epam.vuetify.tests.complex;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

import com.epam.jdi.light.elements.common.UIElement;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.calendarsPage;
import static io.github.com.pages.CalendarsPage.eventsClickCalendar;
import static io.github.com.pages.CalendarsPage.miscDragAndDropCalendar;
import static io.github.com.pages.CalendarsPage.slotsDayBodyCalendar;
import static io.github.com.pages.CalendarsPage.slotsDayCalendar;
import static io.github.com.pages.CalendarsPage.typeCategoryCalendar;
import static io.github.com.pages.CalendarsPage.typeDayCalendar;
import static io.github.com.pages.CalendarsPage.typeWeekCalendar;

import com.epam.jdi.light.elements.complex.WebList;
import io.github.epam.TestsInit;
import io.github.epam.vuetify.tests.data.CalendarDataProvider;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CalendarsTests extends TestsInit {

    @BeforeClass
    public static void setup() {
        calendarsPage.open();
        waitCondition(() -> calendarsPage.isOpened());
        calendarsPage.checkOpened();
    }

    @Test
    public static void typeCategoryCalendarTest() {
        typeCategoryCalendar.show();
        typeCategoryCalendar.nextDay();
        typeCategoryCalendar.previousDay();
        typeCategoryCalendar.previousDay();
        typeCategoryCalendar.today();
        typeCategoryCalendar.is().today();
        typeCategoryCalendar.has().categories();
        typeCategoryCalendar.has().category(1, "John Smith")
                .and().category(2, "Tori Walker");
    }

    @Test
    public static void typeDayCalendarTest() {
        typeDayCalendar.show();
        typeDayCalendar.is().daily();
        typeDayCalendar.is().today();
        typeDayCalendar.has().intervals();
        typeDayCalendar.has().dayInterval(3, "2 o'clock").and().dayInterval(7, "6 o'clock");
    }

    @Test
    public static void typeWeekCalendarTest() {
        typeWeekCalendar.show();
        typeWeekCalendar.is().weekly();
        typeWeekCalendar.has().event(2, "Mash Potatoes")
                .and().event(1, "Weekly Meeting");
    }

    @Test
    public static void eventsClickCalendarTest() {
        eventsClickCalendar.show();
        eventsClickCalendar.openMenu();
        waitCondition(() -> eventsClickCalendar.menu().isDisplayed());
        eventsClickCalendar.menu().select("Day");
        eventsClickCalendar.is().daily();
        eventsClickCalendar.openMenu();
        waitCondition(() -> eventsClickCalendar.menu().isDisplayed());
        eventsClickCalendar.menu().select("Week");
        eventsClickCalendar.is().weekly();
        eventsClickCalendar.events().select(3);
        eventsClickCalendar.assertThat().eventIsOpened();
        eventsClickCalendar.closeEvent();
    }

    @Test(dataProvider = "slotsDayCalendarTestData", dataProviderClass = CalendarDataProvider.class)
    public static void slotsDayCalendarTest(int week, int day, int slot, String title) {
        slotsDayCalendar.show();
        slotsDayCalendar.selectSlot(week, day, slot);
        slotsDayCalendar.assertThat().slotHasTitle(week, day, slot, title);
    }

    @Test
    public static void slotsDayBodyCalendarTest() {
        slotsDayBodyCalendar.show();
        slotsDayBodyCalendar.is().weekly();
        slotsDayBodyCalendar.has().intervals();
        slotsDayBodyCalendar.has().currentTimeLine();
    }

    @Test(enabled = false) // disabled due to an unpredicted behaviour based on randomly generated calendar events - need to be fixed through changes on a test site
    public static void miscDragAndDropCalendarTest() {
        miscDragAndDropCalendar.show();
        WebList events = miscDragAndDropCalendar.events();
        // get the last event to be sure that it's not for today
        UIElement event = miscDragAndDropCalendar.events().get(events.size());
        int todayEventsNumber = miscDragAndDropCalendar.dailyEvents(1).size();

        UIElement today = miscDragAndDropCalendar.intervals().get(2);
        event.dragAndDropTo(today.getWebElement());

        jdiAssert(todayEventsNumber == miscDragAndDropCalendar.dailyEvents(1).size() - 1
                ? "event was moved" : "event was NOT moved", Matchers.is("event was moved"));
    }

}
