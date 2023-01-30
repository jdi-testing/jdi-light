package io.github.epam.vuetify.tests.data;

import static java.time.temporal.ChronoUnit.DAYS;

import java.util.function.Consumer;

import com.epam.jdi.light.vuetify.elements.complex.bars.CalendarToolBar;
import org.testng.annotations.DataProvider;

public class CalendarDataProvider {

    @DataProvider
    public static Object[][] slotsDayCalendarTestData() {
        return new Object[][]{
            {2, 2, 2, "Slacking"},
            {1, 4, 1, "Development"}
        };
    }

    @DataProvider
    public static Object[][] calendarActionsDataProvider() {
        return new Object[][]{
            {"Week", DAYS, 7L, (Consumer<CalendarToolBar>) CalendarToolBar::nextDay},
            {"Week", DAYS, -7L, (Consumer<CalendarToolBar>) CalendarToolBar::previousDay},
            {"Month", DAYS, 28L, (Consumer<CalendarToolBar>) CalendarToolBar::nextDay},
            {"Month", DAYS, -28L, (Consumer<CalendarToolBar>) CalendarToolBar::previousDay},
        };
    }

}