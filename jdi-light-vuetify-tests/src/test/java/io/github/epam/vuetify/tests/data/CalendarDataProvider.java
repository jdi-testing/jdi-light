package io.github.epam.vuetify.tests.data;

import static java.time.temporal.ChronoUnit.DAYS;

import com.epam.jdi.light.vuetify.elements.complex.Calendar;
import java.util.function.Consumer;
import org.testng.annotations.DataProvider;

public class CalendarDataProvider {

    @DataProvider
    public static Object[][] slotsDayCalendarTestData() {
        return new Object[][]{
            {2, 2, 2, "Slacking"},
            {1, 4, 1, "Development"}
        };
    }

    /**
     * To check next/prev month we need 35 days difference, since in the 'Month' view calendar always displays 5 weeks.
     */
    @DataProvider
    public static Object[][] calendarActionsDataProvider() {
        return new Object[][]{
            {"Week", DAYS, 7L, (Consumer<Calendar>) Calendar::next},
            {"Week", DAYS, -7L, (Consumer<Calendar>) Calendar::previous},
            {"Month", DAYS, 35L, (Consumer<Calendar>) Calendar::next},
            {"Month", DAYS, -35L, (Consumer<Calendar>) Calendar::previous},
        };
    }

}
