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
import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
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
        typeDayCalendar.is().daily();
        typeDayCalendar.is().today();
        typeDayCalendar.has().intervals();
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

    @Test(dataProvider = "slotsDayCalendarTestData")
    public static void slotsDayCalendarTest(int week, int day, int slot, String title) {
        slotsDayCalendar.selectSlot(week, day, slot);
        slotsDayCalendar.assertThat().slotHasTitle(week, day, slot, title);
    }

    @Test
    public static void slotsDayBodyCalendarTest() {
        slotsDayBodyCalendar.is().weekly();
        slotsDayBodyCalendar.has().intervals();
        slotsDayBodyCalendar.has().currentTimeLine();
    }

    @Test
    public static void miscDragAndDropCalendarTest() {
        UIElement event = miscDragAndDropCalendar.events().get(3);
        int previousDailyEventsNumber = miscDragAndDropCalendar.dailyEvents(2).size();

        Actions action = new Actions(calendarsPage.driver());
        action.dragAndDropBy(calendarsPage.driver()
                        .findElement(By.cssSelector(getElementLocator(event))),
                200, 0).build().perform();

        jdiAssert(previousDailyEventsNumber != miscDragAndDropCalendar.dailyEvents(2).size()
                ? "position changed" : "position didn't change", Matchers.is("position changed"));
    }

    private static String getElementLocator(UIElement element) {
        return element.locator.toString().replaceAll("\\b(WebElement->css: )|\\b(->css:)", "");
    }

    @DataProvider(name = "slotsDayCalendarTestData")
    public static Object[][] slotsDayCalendarTestData() {
        return new Object[][]{
                {2, 2, 2, "Slacking"},
                {1, 4, 1, "Development"}
        };
    }
}
