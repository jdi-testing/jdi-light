package io.github.epam.vuetify.tests.complex;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static io.github.com.StaticSite.calendarsPage;
import static io.github.com.pages.CalendarsPage.eventsClickCalendar;
import static io.github.com.pages.CalendarsPage.miscDragAndDropCalendar;
import static io.github.com.pages.CalendarsPage.slotsDayBodyCalendar;
import static io.github.com.pages.CalendarsPage.slotsDayCalendar;
import static io.github.com.pages.CalendarsPage.typeCategoryCalendar;
import static io.github.com.pages.CalendarsPage.typeDayCalendar;
import static io.github.com.pages.CalendarsPage.typeWeekCalendar;
import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CalendarsTests extends TestsInit {

    @BeforeClass
    public static void setup() {
        calendarsPage.open();
    }

    @Test
    public static void typeCategoryCalendarTest() {
        typeCategoryCalendar.nextDay();
        typeCategoryCalendar.previousDay();
        typeCategoryCalendar.previousDay();
        typeCategoryCalendar.today();
        typeCategoryCalendar.is().today();
        typeCategoryCalendar.assertThat().hasCategories();
        typeCategoryCalendar.has().category(1, "John Smith")
                .and().category(2, "Tori Walker");
    }

    @Test
    public static void typeDayCalendarTest() {
        typeDayCalendar.is().daily();
        typeDayCalendar.is().today();
        typeDayCalendar.assertThat().hasIntervals();
        typeDayCalendar.has().dayInterval(3, "2 o'clock").and().dayInterval(7, "6 o'clock");
    }

    @Test
    public static void typeWeekCalendarTest() {
        typeWeekCalendar.is().weekly();
        typeWeekCalendar.has().event(2, "Mash Potatoes")
                .and().event(1, "Weekly Meeting");
    }

    @Test
    public static void eventsClickCalendarTest() {
        eventsClickCalendar.selectCalendarType("Day");
        eventsClickCalendar.is().daily();
        eventsClickCalendar.selectCalendarType("Week");
        eventsClickCalendar.is().weekly();
        eventsClickCalendar.events().select(3);
        eventsClickCalendar.assertThat().eventIsOpened();
        eventsClickCalendar.closeEvent();
    }

    @Test
    public static void slotsDayCalendarTest() {
        slotsDayCalendar.selectSlot(2, 2, 2);
        slotsDayCalendar.assertThat().slotHasTitle(2, 2, 2, "Slacking");
        slotsDayCalendar.selectSlot(1, 4, 1);
        slotsDayCalendar.assertThat().slotHasTitle(1, 4, 1, "Development");
    }

    @Test
    public static void slotsDayBodyCalendarTest() {
        slotsDayBodyCalendar.is().weekly();
        slotsDayBodyCalendar.assertThat().hasIntervals();
        slotsDayBodyCalendar.has().currentTimeLine();
    }

    @Test
    public static void miscDragAndDropCalendarTest() {
        int firstLocation = getEventLocation(4);
        miscDragAndDropCalendar.events().get(4).dragAndDropTo(0, 70);
        jdiAssert(firstLocation != getEventLocation(4), Matchers.is(true));

        int previousSIze = miscDragAndDropCalendar.events().size();
        miscDragAndDropCalendar.intervals(1).select(15);
        jdiAssert(miscDragAndDropCalendar.events().size() > previousSIze, Matchers.is(true));
    }


    private static int getEventLocation(int eventNum) {
        return miscDragAndDropCalendar.events().get(eventNum).getLocation().getY();
    }
}
