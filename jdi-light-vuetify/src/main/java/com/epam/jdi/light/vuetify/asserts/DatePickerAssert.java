package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.DatePicker;
import com.epam.jdi.light.vuetify.interfaces.asserts.ElevationAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.MeasurementAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import com.jdiai.tools.Timer;
import org.hamcrest.Matchers;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class DatePickerAssert extends UIAssert<DatePickerAssert, DatePicker> implements
        ElevationAssert<DatePickerAssert, DatePicker>, MeasurementAssert<DatePickerAssert, DatePicker>,
        ThemeAssert<DatePickerAssert, DatePicker> {
    String getDayOfMonthSuffix(int n) {
        String res = "th";
        if (n >= 11 && n <= 13) {
            return res;
        }
        switch (n % 10) {
            case 1:
                res = "st";
                break;
            case 2:
                res = "nd";
                break;
            case 3:
                res = "rd";
                break;
            default:
                break;
        }
        return res;
    }

    @JDIAction(value = "Assert that '{name}' date field has value '{0}'")
    public DatePickerAssert date(String date) {
        Timer.waitCondition(() -> element().getDate().equals(date));
        String actualDate = element().getDate();
        jdiAssert(actualDate, Matchers.is(date), String.format("Element's actual date '%s' is not equal to expected '%s'",
                actualDate, date));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' field color is '{0}'")
    public DatePickerAssert color(String color) {
        String actualColor = element().getColor();
        jdiAssert(actualColor, Matchers.is(color), String.format("Element's actual color '%s' is not equal to expected " +
                "'%s'", actualColor, color));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' shown day of month is '{0}'")
    public DatePickerAssert dayOfMonth(String dayOfMonth) {
        Timer.waitCondition(() -> element().getDayOfMonth().equals(dayOfMonth));
        String actualDayOfMonth = element().getDayOfMonth();
        jdiAssert(actualDayOfMonth, Matchers.is(dayOfMonth), String.format("Element's actual day of month '%s' is not " +
                "equal to expected '%s'", actualDayOfMonth, dayOfMonth));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' shown day of month is '{0}' based on locale '{1}'")
    public DatePickerAssert dayOfMonth(String dayOfMonth, Locale locale) {
        Timer.waitCondition(() -> element().getDayOfMonth(locale).equals(dayOfMonth));
        String actualDayOfMonth = element().getDayOfMonth(locale);
        jdiAssert(actualDayOfMonth, Matchers.containsString(dayOfMonth), String.format("Actual day of " +
                "month '%s' is not equal to expected '%s'", actualDayOfMonth, dayOfMonth));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' shown month is '{0}'")
    public DatePickerAssert month(String month) {
        Timer.waitCondition(() -> element().getMonth().equals(month));
        String actualMonth = element().getMonth();
        jdiAssert(actualMonth, Matchers.is(month), String.format("Actual month '%s' is not equal to expected '%s'",
                actualMonth, month));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' shown month is '{0}' based on locale '{1}'")
    public DatePickerAssert month(String month, Locale locale) {
        Timer.waitCondition(() -> element().getMonth(locale).equals(month));
        String actualMonth = element().getMonth(locale);
        jdiAssert(actualMonth, Matchers.is(month), String.format("Actual month '%s' is not equal to expected '%s'",
                actualMonth, month));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' shown year is '{0}'")
    public DatePickerAssert year(String year) {
        Timer.waitCondition(() -> element().getYear().equals(year));
        String actualYear = element().getYear();
        jdiAssert(actualYear, Matchers.containsString(year), String.format("Actual year '%s' is not equal to " +
                "expected '%s'", actualYear, year));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' shown year is '{0}' based on locale '{1}'")
    public DatePickerAssert year(String year, Locale locale) {
        Timer.waitCondition(() -> element().getYear(locale).equals(year));
        String actualYear = element().getYear(locale);
        jdiAssert(actualYear, Matchers.containsString(year), String.format("Actual year '%s' is not equal to " +
                "expected '%s'", actualYear, year));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' list of disabled dates is not empty")
    public DatePickerAssert disabledDatesNonEmptyList() {
        jdiAssert(element().getDisabledDates().size(), Matchers.greaterThanOrEqualTo(1), "Element " +
                "doesn't have disabled dates");
        return this;
    }


    @JDIAction(value = "Assert that '{name}' list of enabled dates is not empty")
    public DatePickerAssert enabledDatesNonEmptyList() {
        jdiAssert(element().getEnabledDates().size(), Matchers.greaterThanOrEqualTo(1), "Element " +
                "doesn't have enabled dates");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' enabled dates are clickable")
    public DatePickerAssert clickableEnabledDates() {
        element().getEnabledDatesElements().stream().forEach(elem -> {
                elem.hover();
                Timer.waitCondition(() -> elem.isClickable());
                jdiAssert(elem.isClickable(), Matchers.is(true), "Element is not clickable");
            }
        );
        return this;
    }

    @JDIAction(value = "Assert that '{name}' disabled dates are non-clickable")
    public DatePickerAssert nonClickableDisabledDates() {
        element().getDisabledDatesElements().stream().forEach(elem ->
                jdiAssert(elem.isClickable(), Matchers.is(false), "Element is clickable")
        );
        return this;
    }

    @JDIAction(value = "Assert that '{name}' next month icon class is '{0}'")
    public DatePickerAssert nextMonthIconClass(String nextMonthIconClass) {
        String actualNextMonthIconClass = element().getNextMonthIconClass();
        jdiAssert(actualNextMonthIconClass, Matchers.containsString(nextMonthIconClass), String.format("Actual next " +
                "month icon class '%s' is not equal to expected '%s'", actualNextMonthIconClass, nextMonthIconClass));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' previous month icon class is '{0}'")
    public DatePickerAssert previousMonthIconClass(String previousMonthIconClass) {
        String actualPreviousMonthIconClass = element().getPreviousMonthIconClass();
        jdiAssert(actualPreviousMonthIconClass, Matchers.containsString(previousMonthIconClass), String.format(
                "Actual element's previous month icon class '%s' is not equal to expected '%s'",
                actualPreviousMonthIconClass, previousMonthIconClass));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' additional year icon exists")
    public DatePickerAssert additionalYearIcon() {
        jdiAssert(element().getAdditionalYearIcon().isExist(), Matchers.is(true), "Element hasn't " +
                "additional year icon");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' chosen dates are '{0}'")
    public DatePickerAssert properSetOfActiveDays(Set<String> days) {
        Timer.waitCondition(() -> element().getAllActiveDaysOfMonth().equals(days));
        List<String> actualActiveDaysOfMonth = element().getAllActiveDaysOfMonth();
        jdiAssert(actualActiveDaysOfMonth, Matchers.containsInAnyOrder(days.toArray()), String.format(
                "Actual element's days of month '%s' don't contain all of the expected days '%s'",
                actualActiveDaysOfMonth, days));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' all chosen dates are shown in menu list")
    public DatePickerAssert properShownMultipleDates() {
        List<String> activeFormattedDates = element().getAllActiveDaysOfMonth().stream().map(elem
                -> LocalDate.of(Integer.parseInt(element().getYear()),
                Month.valueOf(element().getMonth(Locale.ENGLISH).toUpperCase(Locale.ROOT)).getValue(),
                Integer.parseInt(elem)).toString()).collect(Collectors.toList());
        Object[] shownDates = element().getShownMultipleDates().toArray();
        jdiAssert(activeFormattedDates, Matchers.containsInAnyOrder(shownDates),
                String.format("Element's actual active dates '%s' don't contain all of the shown dates '%s'",
                        activeFormattedDates, shownDates));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' all dates in range '{0} - {1}' are active")
    public DatePickerAssert activeDatesInRange(int startDay, int finalDay) {
        List<String> expectedNumbersInRange = new ArrayList<>();
        for (int i = startDay; i < finalDay + 1; i++) {
            expectedNumbersInRange.add(Integer.toString(i));
        }
        List<String> activeDays = element().getAllActiveDaysOfMonth();
        jdiAssert(activeDays, Matchers.is(expectedNumbersInRange), String.format("Actual element's " +
                "active days '%s' don't contain all of the expected '%s'", activeDays, expectedNumbersInRange));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' list of event color circles is not empty")
    public DatePickerAssert eventColorCirclesNonEmptyList() {
        jdiAssert(element().getEventCirclesColor().size(), Matchers.greaterThanOrEqualTo(1), "Element " +
                "hasn't event color circles");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has following colors of event circles '{0}'")
    public DatePickerAssert properColorsOfEventCircles(String... colors) {
        List<String> actualEventCirclesColor = element().getEventCirclesColor();
        jdiAssert(actualEventCirclesColor, Matchers.hasItems(colors), String.format("Actual event circles " +
                "colors '%s' don't contain all of the expected colors '%s'", actualEventCirclesColor, colors));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' result date field has date '{0}'")
    public DatePickerAssert resultDate(String resultDate) {
        Timer.waitCondition(() -> element().getResultDate().equals(resultDate));
        String actualResultDate = element().getResultDate();
        jdiAssert(actualResultDate, Matchers.is(resultDate), String.format("Actual result date '%s' is not equal to " +
                "expected '%s'", actualResultDate, resultDate));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' change year button is visible")
    public DatePickerAssert visibleChangeYearButton() {
        Timer.waitCondition(() -> element().getChangeYearButton().isVisible());
        jdiAssert(element().getChangeYearButton().isVisible(), Matchers.is(true), "Element hasn't " +
                "visible change year button");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' main date field does not exist")
    public DatePickerAssert mainDateFieldIsNotExist() {
        jdiAssert(element().getMainField().isNotExist(), Matchers.is(true), "Element's main date " +
                "field exists");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' main date field exists")
    public DatePickerAssert mainDateField() {
        Timer.waitCondition(() -> element().getMainField().isExist());
        jdiAssert(element().getMainField().isExist(), Matchers.is(true), "Element's main date field " +
                "exists");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' formatted date field has date '{0}'")
    public DatePickerAssert formattedDate(String formattedDate) {
        Timer.waitCondition(() -> element().getFormattedDate().equals(formattedDate));
        String actualFormattedDate = element().getFormattedDate();
        jdiAssert(actualFormattedDate, Matchers.is(formattedDate), String.format("Element's actual formatted date " +
                "'%s' is not equal to expected '%s'", actualFormattedDate, formattedDate));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' date field has readonly attribute")
    public DatePickerAssert dateFieldReadonlyAttribute() {
        jdiAssert(element().getDateFieldReadonlyAttribute(), Matchers.is("true"), "Element's date " +
                "field hasn't readonly attribute");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' result date '{0}' is formatted according to external libraries")
    public DatePickerAssert properExternalLibFormattingDate(LocalDate date) {
        DateTimeFormatter formatterJS = DateTimeFormatter.
                ofPattern("cccc, MMMM d'" + getDayOfMonthSuffix(date.getDayOfMonth()) + "' yyyy")
                .withLocale(Locale.ENGLISH);
        jdiAssert(element().getResultDate(), Matchers.is(date.format(formatterJS)), "Element's result date " +
                "isn't formatted according to external libraries");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' result date is empty")
    public DatePickerAssert emptyResultDate() {
        jdiAssert(element().getResultDate(), Matchers.is(""), "Element's result date is not empty");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has portrait orientation")
    public DatePickerAssert portraitOrientation() {
        jdiAssert(element().getColorFieldWidth(), Matchers.greaterThan(element().getColorFieldHeight()),
                "Element has not portrait orientation");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has landscape orientation")
    public DatePickerAssert landscapeOrientation() {
        jdiAssert(element().getColorFieldWidth(), Matchers.lessThan(element().getColorFieldHeight()),
                "Element has not landscape orientation");
        return this;
    }

    @JDIAction(value = "Assert that expandable '{name}' is expanded")
    public DatePickerAssert expanded() {
        jdiAssert(element().getExpandedElement().attr("class"),
                Matchers.containsString("primary--text"), "Element is not expanded");
        return this;
    }
}
