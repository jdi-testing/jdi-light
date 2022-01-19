package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.DatePicker;
import com.epam.jdi.tools.Timer;
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

public class DatePickerAssert extends UIAssert<DatePickerAssert, DatePicker> {
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

    @JDIAction("Assert that date field has correct value")
    public DatePickerAssert date(String expectedDate) {
        Timer.waitCondition(() -> element().getDate().equals(expectedDate));
        jdiAssert(element().getDate(), Matchers.is(expectedDate));
        return this;
    }

    @JDIAction("Assert that field color is correct")
    public DatePickerAssert color(String expectedColor) {
        jdiAssert(element().getColor(), Matchers.is(expectedColor));
        return this;
    }

    @JDIAction("Assert that shown day of month is correct")
    public DatePickerAssert dayOfMonth(String expectedDayOfMonth) {
        Timer.waitCondition(() -> element().getDayOfMonth().equals(expectedDayOfMonth));
        jdiAssert(element().getDayOfMonth(), Matchers.is(expectedDayOfMonth));
        return this;
    }

    @JDIAction("Assert that shown day of month is correct based on locale")
    public DatePickerAssert dayOfMonth(String expectedDayOfMonth, Locale locale) {
        if (locale.equals(Locale.CHINESE)) {
            Timer.waitCondition(() -> element().getDayOfMonth(Locale.CHINESE).equals(expectedDayOfMonth));
            jdiAssert(element().getDayOfMonth(Locale.CHINESE), Matchers.containsString(expectedDayOfMonth));
            return this;
        } else {
            Timer.waitCondition(() -> element().getDayOfMonth(Locale.ENGLISH).equals(expectedDayOfMonth));
            jdiAssert(element().getDayOfMonth(Locale.ENGLISH), Matchers.is(expectedDayOfMonth));
            return this;
        }
    }

    @JDIAction("Assert that shown month is correct")
    public DatePickerAssert month(String expectedMonth) {
        Timer.waitCondition(() -> element().getMonth().equals(expectedMonth));
        jdiAssert(element().getMonth(), Matchers.is(expectedMonth));
        return this;
    }

    @JDIAction("Assert that shown month is correct based on locale")
    public DatePickerAssert month(String expectedMonth, Locale locale) {
        if (locale.equals(Locale.CHINESE)) {
            Timer.waitCondition(() -> element().getMonth(Locale.CHINESE).equals(expectedMonth));
            jdiAssert(element().getMonth(Locale.CHINESE), Matchers.is(expectedMonth));
            return this;
        } else {
            Timer.waitCondition(() -> element().getMonth(Locale.ENGLISH).equals(expectedMonth));
            jdiAssert(element().getMonth(Locale.ENGLISH), Matchers.is(expectedMonth));
            return this;
        }
    }

    @JDIAction("Assert that shown year is correct")
    public DatePickerAssert year(String expectedYear) {
        Timer.waitCondition(() -> element().getYear().equals(expectedYear));
        jdiAssert(element().getYear(), Matchers.containsString(expectedYear));
        return this;
    }

    @JDIAction("Assert that shown year is correct based on locale")
    public DatePickerAssert year(String expectedYear, Locale locale) {
        if (locale.equals(Locale.CHINESE)) {
            Timer.waitCondition(() -> element().getYear(Locale.CHINESE).equals(expectedYear));
            jdiAssert(element().getYear(Locale.CHINESE), Matchers.containsString(expectedYear));
            return this;
        }
        Timer.waitCondition(() -> element().getYear(Locale.ENGLISH).equals(expectedYear));
        jdiAssert(element().getYear(Locale.ENGLISH), Matchers.containsString(expectedYear));
        return this;
    }

    @JDIAction("Assert that list of disabled dates is not empty")
    public DatePickerAssert disabledDatesNonEmptyList() {
        jdiAssert(element().getDisabledDates().size(), Matchers.greaterThanOrEqualTo(1));
        return this;
    }

    @JDIAction("Assert that enable dates are clickable")
    public DatePickerAssert clickableEnabledDates() {
        element().getEnabledDatesElements().stream().forEach(elem -> {
                    elem.hover();
                    Timer.waitCondition(() -> elem.isClickable());
                    jdiAssert(elem.isClickable(), Matchers.is(true));
                }
        );
        return this;
    }

    @JDIAction("Assert that disable dates are non-clickable")
    public DatePickerAssert nonClickableDisabledDates() {
        element().getDisabledDatesElements().stream().forEach(elem ->
                jdiAssert(!elem.isClickable(), Matchers.is(true))
        );
        return this;
    }

    @JDIAction("Assert that elevation level is correct")
    public DatePickerAssert elevation(String expectedElevation) {
        Timer.waitCondition(() -> element().getElevation().equals(expectedElevation));
        jdiAssert(element().getElevation(), Matchers.containsString(expectedElevation));
        return this;
    }

    @JDIAction("Assert that next month icon class is correct")
    public DatePickerAssert nextMonthIconClass(String expectedNextMonthIconClass) {
        jdiAssert(element().getNextMonthIconClass(), Matchers.containsString(expectedNextMonthIconClass));
        return this;
    }

    @JDIAction("Assert that previous month icon class is correct")
    public DatePickerAssert previousMonthIconClass(String expectedPreviousMonthIconClass) {
        jdiAssert(element().getPreviousMonthIconClass(), Matchers.containsString(expectedPreviousMonthIconClass));
        return this;
    }

    @JDIAction("Assert that additional year icon exists")
    public DatePickerAssert additionalYearIcon() {
        jdiAssert(element().getAdditionalYearIcon().isExist(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that all chosen dates are correctly chosen")
    public DatePickerAssert properSetOfActiveDays(Set<String> expectedDays) {
        Timer.waitCondition(() -> element().getAllActiveDaysOfMonth().equals(expectedDays));
        jdiAssert(element().getAllActiveDaysOfMonth(), Matchers.containsInAnyOrder(expectedDays.toArray()));
        return this;
    }

    @JDIAction("Assert that all chosen dates are shown in menu list")
    public DatePickerAssert properShownMultipleDates() {
        List<String> activeFormattedDates = element().getAllActiveDaysOfMonth().stream().map(elem
                -> LocalDate.of(Integer.parseInt(element().getYear()),
                Month.valueOf(element().getMonth(Locale.ENGLISH).toUpperCase(Locale.ROOT)).getValue(),
                Integer.parseInt(elem)).toString()).collect(Collectors.toList());
        jdiAssert(activeFormattedDates, Matchers.containsInAnyOrder(element().getShownMultipleDates().toArray()));
        return this;
    }

    @JDIAction("Assert that all dates in range became active")
    public DatePickerAssert properRangeDates(int startDay, int finalDay) {
        List<String> expectedNumbersInRange = new ArrayList<>();
        for (int i = startDay; i < finalDay + 1; i++) {
            expectedNumbersInRange.add(Integer.toString(i));
        }
        List<String> activeDays = element().getAllActiveDaysOfMonth();
        jdiAssert(activeDays, Matchers.is(expectedNumbersInRange));
        return this;
    }

    @JDIAction("Assert that outlined date border is correct")
    public DatePickerAssert properOutlinedDateBorder(String expectedBorderThickness) {
        jdiAssert(element().getOutlinedDateBorder(), Matchers.containsString(expectedBorderThickness));
        return this;
    }

    @JDIAction("Assert that width of the picker is correct")
    public DatePickerAssert pickerWidth(int expectedWidth) {
        jdiAssert(element().getPickerWidth(), Matchers.is(expectedWidth));
        return this;
    }

    @JDIAction("Assert that list of event color circles is not empty")
    public DatePickerAssert eventColorCirclesNonEmptyList() {
        jdiAssert(element().getEventCirclesColor().size(), Matchers.greaterThanOrEqualTo(1));
        return this;
    }

    @JDIAction("Assert that picker has correct colors of event circles")
    public DatePickerAssert properColorsOfEventCircles(String... expectedColors) {
        jdiAssert(element().getEventCirclesColor(), Matchers.hasItems(expectedColors));
        return this;
    }

    @JDIAction("Assert that result date field has proper date")
    public DatePickerAssert resultDate(String expectedResultDate) {
        Timer.waitCondition(() -> element().getResultDate().equals(expectedResultDate));
        jdiAssert(element().getResultDate(), Matchers.is(expectedResultDate));
        return this;
    }

    @JDIAction("Assert that change year button is visible")
    public DatePickerAssert visibleChangeYearButton() {
        Timer.waitCondition(() -> element().getChangeYearButton().isVisible());
        jdiAssert(element().getChangeYearButton().isVisible(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that main date field does not exist")
    public DatePickerAssert mainDateFieldIsNotExist() {
        jdiAssert(element().getMainField().isNotExist(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that main date field exists")
    public DatePickerAssert mainDateField() {
        Timer.waitCondition(() -> element().getMainField().isExist());
        jdiAssert(element().getMainField().isExist(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that Cancel button does not exist")
    public DatePickerAssert cancelButtonIsNotExist() {
        jdiAssert(element().getCancelButton().isNotExist(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that OK button does not exist")
    public DatePickerAssert okButtonIsNotExist() {
        jdiAssert(element().getOkButton().isNotExist(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that formatted date field has proper date")
    public DatePickerAssert formattedDate(String expectedFormattedDate) {
        Timer.waitCondition(() -> element().getFormattedDate().equals(expectedFormattedDate));
        jdiAssert(element().getFormattedDate(), Matchers.is(expectedFormattedDate));
        return this;
    }

    @JDIAction("Assert that the field has readonly attribute")
    public DatePickerAssert dateFieldReadonlyAttribute() {
        jdiAssert(element().getDateFieldReadonlyAttribute(), Matchers.is("true"));
        return this;
    }

    @JDIAction("Assert that result date is formatted according to external libraries")
    public DatePickerAssert properExternalLibFormattingDate(LocalDate date) {
        DateTimeFormatter formatterJS = DateTimeFormatter.
                ofPattern("cccc, MMMM d'" + getDayOfMonthSuffix(date.getDayOfMonth()) + "' yyyy")
                .withLocale(Locale.ENGLISH);
        jdiAssert(element().getResultDate(), Matchers.is(date.format(formatterJS)));
        return this;
    }

    @JDIAction("Assert that result date is empty")
    public DatePickerAssert emptyResultDate() {
        jdiAssert(element().getResultDate(), Matchers.is(""));
        return this;
    }

    @JDIAction("Assert that color field has portrait orientation")
    public DatePickerAssert portraitOrientation() {
        jdiAssert(element().getColorFieldWidth(), Matchers.greaterThan(element().getColorFieldHeight()));
        return this;
    }

    @JDIAction("Assert that color field has landscape orientation")
    public DatePickerAssert landscapeOrientation() {
        jdiAssert(element().getColorFieldWidth(), Matchers.lessThan(element().getColorFieldHeight()));
        return this;
    }

    @JDIAction("Assert that expandable date picker is expanded")
    public DatePickerAssert expanded() {
        jdiAssert(element().getExpandedElement().attr("class"),
                Matchers.containsString("primary--text"));
        return this;
    }
}
