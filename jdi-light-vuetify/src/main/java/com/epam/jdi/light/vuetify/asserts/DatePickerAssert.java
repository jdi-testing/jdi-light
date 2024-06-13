package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.DatePicker;
import com.epam.jdi.light.vuetify.interfaces.asserts.ElevationAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.MeasurementAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
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

    @JDIAction(value = "Assert that '{name}' date field has value '{0}'", isAssert = true)
    public DatePickerAssert date(String date) {
        jdiAssert(element().getDate(), Matchers.is(date));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' field color is '{0}'", isAssert = true)
    public DatePickerAssert color(String color) {
        jdiAssert(element().color(), Matchers.is(color));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' shown day of month is '{0}'", isAssert = true)
    public DatePickerAssert dayOfMonth(String dayOfMonth) {
        jdiAssert(element().getDayOfMonth(), Matchers.is(dayOfMonth));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' shown day of month is '{0}' based on locale '{1}'", isAssert = true)
    public DatePickerAssert dayOfMonth(String dayOfMonth, Locale locale) {
        jdiAssert(element().getDayOfMonth(locale), Matchers.containsString(dayOfMonth));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' shown month is '{0}'", isAssert = true)
    public DatePickerAssert month(String month) {
        jdiAssert(element().getMonth(), Matchers.is(month));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' shown month is '{0}' based on locale '{1}'", isAssert = true)
    public DatePickerAssert month(String month, Locale locale) {
        jdiAssert(element().getMonth(locale), Matchers.is(month));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' shown year is '{0}'", isAssert = true)
    public DatePickerAssert year(String year) {
        jdiAssert(element().getYear(), Matchers.containsString(year));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' shown year is '{0}' based on locale '{1}'", isAssert = true)
    public DatePickerAssert year(String year, Locale locale) {
        jdiAssert(element().getYear(locale), Matchers.containsString(year));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' list of disabled dates is not empty", isAssert = true)
    public DatePickerAssert disabledDatesNonEmptyList() {
        jdiAssert(element().getDisabledDates().size(), Matchers.greaterThanOrEqualTo(1),
                "DatePicker doesn't have disabled dates");
        return this;
    }


    @JDIAction(value = "Assert that '{name}' list of enabled dates is not empty", isAssert = true)
    public DatePickerAssert enabledDatesNonEmptyList() {
        jdiAssert(element().getEnabledDates().size(), Matchers.greaterThanOrEqualTo(1),
                "DatePicker doesn't have enabled dates");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' enabled dates are clickable", isAssert = true)
    public DatePickerAssert clickableEnabledDates() {
        element().getEnabledDatesElements().stream().forEach(elem -> {
                elem.hover();
                jdiAssert(elem.isClickable(), Matchers.is(true), "DatePicker is not clickable");
            }
        );
        return this;
    }

    @JDIAction(value = "Assert that '{name}' disabled dates are non-clickable", isAssert = true)
    public DatePickerAssert nonClickableDisabledDates() {
        element().getDisabledDatesElements().stream().forEach(elem ->
                jdiAssert(elem.isClickable(), Matchers.is(false), "DatePicker's disabled dates is clickable")
        );
        return this;
    }

    @JDIAction(value = "Assert that '{name}' next month icon class is '{0}'", isAssert = true)
    public DatePickerAssert nextMonthIconClass(String nextMonthIconClass) {
        jdiAssert(element().getNextMonthIconClass(), Matchers.containsString(nextMonthIconClass));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' previous month icon class is '{0}'", isAssert = true)
    public DatePickerAssert previousMonthIconClass(String previousMonthIconClass) {
        jdiAssert(element().getPreviousMonthIconClass(), Matchers.containsString(previousMonthIconClass));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' additional year icon exists", isAssert = true)
    public DatePickerAssert additionalYearIcon() {
        jdiAssert(element().getAdditionalYearIcon().isExist(), Matchers.is(true),
                "DatePicker hasn't additional year icon");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' chosen dates are '{0}'", isAssert = true)
    public DatePickerAssert properSetOfActiveDays(Set<String> days) {
        jdiAssert(element().getAllActiveDaysOfMonth(), Matchers.containsInAnyOrder(days.toArray()));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' all chosen dates are shown in menu list", isAssert = true)
    public DatePickerAssert properShownMultipleDates() {
        List<String> activeFormattedDates = element().getAllActiveDaysOfMonth().stream().map(elem
                -> LocalDate.of(Integer.parseInt(element().getYear()),
                Month.valueOf(element().getMonth(Locale.ENGLISH).toUpperCase(Locale.ROOT)).getValue(),
                Integer.parseInt(elem)).toString()).collect(Collectors.toList());
        jdiAssert(activeFormattedDates, Matchers.containsInAnyOrder(element().getShownMultipleDates().toArray()));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' all dates in range '{0} - {1}' are active", isAssert = true)
    public DatePickerAssert activeDatesInRange(int startDay, int finalDay) {
        List<String> expectedNumbersInRange = new ArrayList<>();
        for (int i = startDay; i < finalDay + 1; i++) {
            expectedNumbersInRange.add(Integer.toString(i));
        }
        jdiAssert(element().getAllActiveDaysOfMonth(), Matchers.is(expectedNumbersInRange));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' list of event color circles is not empty", isAssert = true)
    public DatePickerAssert eventColorCirclesNonEmptyList() {
        jdiAssert(element().getEventCirclesColor().size(), Matchers.greaterThanOrEqualTo(1),
                "DatePicker does not have event color circles");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has following colors of event circles '{0}'", isAssert = true)
    public DatePickerAssert properColorsOfEventCircles(String... colors) {
        jdiAssert(element().getEventCirclesColor(), Matchers.hasItems(colors));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' result date field has date '{0}'", isAssert = true)
    public DatePickerAssert resultDate(String resultDate) {
        jdiAssert(element().getResultDate(), Matchers.is(resultDate));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' change year button is visible", isAssert = true)
    public DatePickerAssert visibleChangeYearButton() {
        jdiAssert(element().getChangeYearButton().isVisible(), Matchers.is(true),
                "DatePicker's does not have visible change year button");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' main date field does not exist", isAssert = true)
    public DatePickerAssert mainDateFieldIsNotExist() {
        jdiAssert(element().getMainField().isNotExist(), Matchers.is(true),
                "DatePicker's main date field exists");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' main date field exists", isAssert = true)
    public DatePickerAssert mainDateField() {
        jdiAssert(element().getMainField().isExist(), Matchers.is(true),
                "DatePicker's main date field exists");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' formatted date field has date '{0}'", isAssert = true)
    public DatePickerAssert formattedDate(String formattedDate) {
        jdiAssert(element().getFormattedDate(), Matchers.is(formattedDate));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' date field has readonly attribute", isAssert = true)
    public DatePickerAssert dateFieldReadonlyAttribute() {
        jdiAssert(element().getDateFieldReadonlyAttribute(), Matchers.is("true"),
                "DatePicker's date field hasn't readonly attribute");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' result date '{0}' is formatted according to external libraries", isAssert = true)
    public DatePickerAssert properExternalLibFormattingDate(LocalDate date) {
        DateTimeFormatter formatterJS = DateTimeFormatter.
                ofPattern("cccc, MMMM d'" + getDayOfMonthSuffix(date.getDayOfMonth()) + "' yyyy")
                .withLocale(Locale.ENGLISH);
        jdiAssert(element().getResultDate(), Matchers.is(date.format(formatterJS)));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' result date is empty", isAssert = true)
    public DatePickerAssert emptyResultDate() {
        jdiAssert(element().getResultDate(), Matchers.is(""),
                "DatePicker's result date is not empty");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has portrait orientation", isAssert = true)
    public DatePickerAssert portraitOrientation() {
        jdiAssert(element().isLandscape(), Matchers.is(false),
                "DatePicker is not in portrait orientation");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has landscape orientation", isAssert = true)
    public DatePickerAssert landscapeOrientation() {
        jdiAssert(element().isLandscape(), Matchers.is(true),
                "Element has not landscape orientation");
        return this;
    }

    @JDIAction(value = "Assert that expandable '{name}' is expanded", isAssert = true)
    public DatePickerAssert expanded() {
        jdiAssert(element().getExpandedElement().attr("class"),
                Matchers.containsString("primary--text"), "Element is not expanded");
        return this;
    }
}
