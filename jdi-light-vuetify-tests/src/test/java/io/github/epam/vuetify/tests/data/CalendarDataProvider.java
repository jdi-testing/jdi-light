package io.github.epam.vuetify.tests.data;

import org.testng.annotations.DataProvider;

public class CalendarDataProvider {

    @DataProvider
    public static Object[][] slotsDayCalendarTestData() {
        return new Object[][]{
            {2, 2, 2, "Slacking"},
            {1, 4, 1, "Development"}
        };
    }

}
