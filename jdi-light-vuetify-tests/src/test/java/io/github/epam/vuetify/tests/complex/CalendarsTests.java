package io.github.epam.vuetify.tests.complex;

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
import static org.hamcrest.MatcherAssert.assertThat;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import io.github.epam.TestsInit;
import io.github.epam.vuetify.tests.data.CalendarDataProvider;
import java.time.LocalDate;
import org.apache.commons.lang3.RandomUtils;
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
        LocalDate today = LocalDate.now();

        typeCategoryCalendar.show();
        typeCategoryCalendar.next();
        typeCategoryCalendar.has()
                            .activeDate(today.plusDays(1));

        typeCategoryCalendar.previousDay();
        typeCategoryCalendar.has()
                            .activeDate(today);

        typeCategoryCalendar.previousDay();
        typeCategoryCalendar.has()
                            .activeDate(today.minusDays(1));

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
        eventsClickCalendar.is().daily()
                           .has().activeDate(LocalDate.now());

        eventsClickCalendar.openMenu();
        waitCondition(() -> eventsClickCalendar.menu().isDisplayed());
        eventsClickCalendar.menu().select("Week");
        eventsClickCalendar.is().weekly();
        eventsClickCalendar.events().select(3);
        eventsClickCalendar.assertThat().eventIsOpened();
        eventsClickCalendar.closeEvent();
    }

    @Test
    public void renameEventTest() {
        int eventNumber = 1;
        String newTitle = "New Event Title";

        eventsClickCalendar.openMenu();
        waitCondition(() -> eventsClickCalendar.menu().isDisplayed());
        eventsClickCalendar.menu().select("Week");
        eventsClickCalendar.renameEvent(eventNumber, newTitle);

        eventsClickCalendar.has().event(eventNumber, newTitle);
    }

    @Test
    public void deleteEventTest() {
        int eventNumber = 1;

        eventsClickCalendar.openMenu();
        waitCondition(() -> eventsClickCalendar.menu().isDisplayed());
        eventsClickCalendar.menu().select("Week");


        int numberOfEventsBefore = eventsClickCalendar.events().size();
        eventsClickCalendar.deleteEvent(eventNumber);

        int numberOfEventsAfter = eventsClickCalendar.events().size();
        assertThat(numberOfEventsAfter, Matchers.equalTo(numberOfEventsBefore - 1));
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

    @Test
    public static void miscDragAndDropCalendarTest() {
        miscDragAndDropCalendar.show();
        WebList events = miscDragAndDropCalendar.events();
        // get the last event to be sure that it's not for today
        UIElement event = events.get(events.size());
        final int dayNumber = 1;
        int todayEventsNumber = miscDragAndDropCalendar.dailyEvents(dayNumber).size();

        UIElement today = miscDragAndDropCalendar.intervals().get(2);
        event.dragAndDropTo(today.getWebElement());

        miscDragAndDropCalendar.has()
                               .numberOfEventsPerDay(dayNumber, todayEventsNumber + 1);
    }

    @Test
    public void totalNumberOfEventsPresentTest() {
        miscDragAndDropCalendar.show();

        int expectedNumberOfEvents = 16;
        miscDragAndDropCalendar.has()
                               .totalNumberOfEvents(expectedNumberOfEvents);
    }

    @Test(enabled = false)// fix theme on the test site
    public void darkCalendarTest() {
        darkCalendar.show();
        darkCalendar.has().darkTheme();
    }

    @Test
    public void setDateThroughInputFieldTest() {
        LocalDate date = LocalDate.now().plusDays(RandomUtils.nextInt(10, 100));

        eventsClickCalendar.setDate(date);
        eventsClickCalendar.has().activeDate(date);
    }

}
