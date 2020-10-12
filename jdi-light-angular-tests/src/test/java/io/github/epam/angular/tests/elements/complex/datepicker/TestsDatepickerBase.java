package io.github.epam.angular.tests.elements.complex.datepicker;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static io.github.com.StaticSite.angularPage;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static java.lang.String.format;

public class TestsDatepickerBase extends TestsInit {
    public static final String CHOOSE_A_DATE = "Choose a date";
    public static final LocalDate currentDate = LocalDate.now();
    public static final int CURRENT_YEAR = currentDate.getYear();
    public static final int MIN_YEAR = CURRENT_YEAR - 20;
    public static final int MAX_YEAR = CURRENT_YEAR + 1;

    @BeforeTest(alwaysRun = true)
    public static void beforeStartTest() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    public static String getMinDate() {
        return "1/1/" + MIN_YEAR;
    }

    public static String getMaxDate() {
        return "12/31/" + MAX_YEAR;
    }

    public static List<String> getInputChangeEvents(LocalDate localDate) {
        String day = localDate.getDayOfWeek().toString().substring(0, 3).toLowerCase();
        day = day.replaceFirst(day.substring(0, 1), day.toUpperCase().substring(0, 1));
        String month = localDate.getMonth().toString().substring(0, 3).toLowerCase();
        month = month.replaceFirst(month.substring(0, 1), month.toUpperCase().substring(0, 1));
        String dayOfMonth = String.valueOf(localDate.getDayOfMonth());
        String year = String.valueOf(localDate.getYear());
        String inputEvent = format("input: %s %s %s %s", day, month, dayOfMonth, year);
        String changeEvent = format("change: %s %s %s %s", day, month, dayOfMonth, year);
        List<String> inputChangeEvents = new ArrayList<>();
        inputChangeEvents.add(inputEvent);
        inputChangeEvents.add(changeEvent);
        return inputChangeEvents;
    }
}
