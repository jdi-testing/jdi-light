package com.epam.jdi.light.angular.asserts;

import com.epam.jdi.light.angular.elements.complex.Datepicker;
import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.List;
import java.util.Locale;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class DatepickerAssert extends UIAssert<DatepickerAssert, Datepicker> implements ITextAssert<DatepickerAssert> {
    @JDIAction(value = "Assert that '{name}' expanded", isAssert = true)
    public DatepickerAssert expanded() {
        jdiAssert(element().isExpanded(), Matchers.is(true), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' collapsed", isAssert = true)
    public DatepickerAssert collapsed() {
        jdiAssert(element().isCollapsed(), Matchers.is(true), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' focused", isAssert = true)
    public DatepickerAssert focused() {
        jdiAssert(element().isFocused(), Matchers.is(true), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has locale '{0}'", isAssert = true)
    public DatepickerAssert locale(final Locale locale) {
        jdiAssert(element().isSelectedLocale(locale), Matchers.is(true), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has first input & change events '{0}'", isAssert = true)
    public DatepickerAssert firstInputChangeEvents(final List<String> firstInputChangeEvents) {
        jdiAssert(element().isFirstInputChangeEvents(firstInputChangeEvents), Matchers.is(true), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has last input & change events '{0}'", isAssert = true)
    public DatepickerAssert lastInputChangeEvents(final List<String> lastInputChangeEvents) {
        jdiAssert(element().isLastInputChangeEvents(lastInputChangeEvents), Matchers.is(true), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has last change event '{0}'", isAssert = true)
    public DatepickerAssert lastChangeEvent(final String lastChangeEvent) {
        jdiAssert(element().isLastChangeEvent(lastChangeEvent), Matchers.is(true), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has last input event '{0}'", isAssert = true)
    public DatepickerAssert lastInputEvent(final String lastInputEvent) {
        jdiAssert(element().isLastInputEvent(lastInputEvent), Matchers.is(true), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has valid value", isAssert = true)
    public DatepickerAssert valid() {
        jdiAssert(element().isValid(), Matchers.is(true), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has invalid value", isAssert = true)
    public DatepickerAssert invalid() {
        jdiAssert(element().isInvalid(), Matchers.is(true), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' enabled", isAssert = true)
    public DatepickerAssert enabled() {
        jdiAssert(element().isEnabled(), Matchers.is(true), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' disabled", isAssert = true)
    public DatepickerAssert disabled() {
        jdiAssert(element().isDisabled(), Matchers.is(true), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has enabled toggle", isAssert = true)
    public DatepickerAssert enabledToggle() {
        jdiAssert(element().isToggleEnabled(), Matchers.is(true), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has disabled toggle", isAssert = true)
    public DatepickerAssert disabledToggle() {
        jdiAssert(element().isToggleDisabled(), Matchers.is(true), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has enabled input", isAssert = true)
    public DatepickerAssert enabledInput() {
        jdiAssert(element().isInputEnabled(), Matchers.is(true), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has disabled input", isAssert = true)
    public DatepickerAssert disabledInput() {
        jdiAssert(element().isInputDisabled(), Matchers.is(true), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has enabled values '{0}'", isAssert = true)
    public DatepickerAssert enabledNavigation(final String... navigationElements) {
        jdiAssert(element().isEnabledNavigationElements(navigationElements), Matchers.is(true), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has disabled values '{0}'", isAssert = true)
    public DatepickerAssert disabledNavigation(final String... navigationElements) {
        jdiAssert(element().isDisabledNavigationElements(navigationElements), Matchers.is(true), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' text '{0}'", isAssert = true)
    public DatepickerAssert text(final Matcher<String> condition) {
        jdiAssert(element().text(), condition);
        return this;
    }

    @JDIAction(value = "Assert that '{name}' placeholder '{0}'", isAssert = true)
    public DatepickerAssert placeholder(final Matcher<String> condition) {
        jdiAssert(element().placeholder(), condition);
        return this;
    }

    public DatepickerAssert placeholder(final String date) {
        return placeholder(Matchers.is(date));
    }

    @JDIAction(value = "Assert that '{name}' date '{0}'", isAssert = true)
    public DatepickerAssert date(final Matcher<String> date) {
        jdiAssert(element().getValue(), date);
        return this;
    }

    public DatepickerAssert date(final String date) {
        return date(Matchers.is(date));
    }

    @JDIAction(value = "Assert that '{name}' has selected date '{0}'", isAssert = true)
    public DatepickerAssert selectedDate(final Matcher<LocalDate> selectedDate) {
        jdiAssert(element().selectedDate(), selectedDate);
        return this;
    }

    public DatepickerAssert selectedDate(final LocalDate selectedDate) {
        return selectedDate(Matchers.is(selectedDate));
    }

    @JDIAction(value = "Assert that '{name}' has selected date '{0}' with '{1}' locale", isAssert = true)
    public DatepickerAssert selectedDate(final Matcher<LocalDate> selectedDate, final Locale locale) {
        jdiAssert(element().selectedDate(locale), selectedDate);
        return this;
    }

    public DatepickerAssert selectedDate(final LocalDate selectedDate, final Locale locale) {
        return selectedDate(Matchers.is(selectedDate), locale);
    }

    @JDIAction(value = "Assert that '{name}' month '{0}'", isAssert = true)
    public DatepickerAssert month(final Matcher<Month> month) {
        jdiAssert(element().getMonth(), month);
        return this;
    }

    public DatepickerAssert month(final Month month) {
        return month(Matchers.is(month));
    }

    @JDIAction(value = "Assert that '{name}' has selected month '{0}'", isAssert = true)
    public DatepickerAssert selectedMonth(final Matcher<Month> selectedMonth) {
        jdiAssert(element().selectedMonth(), selectedMonth);
        return this;
    }

    public DatepickerAssert selectedMonth(final Month selectedMonth) {
        return selectedMonth(Matchers.is(selectedMonth));
    }

    @JDIAction(value = "Assert that '{name}' has start month '{0}'", isAssert = true)
    public DatepickerAssert startMonth(final Matcher<Month> startMonth) {
        jdiAssert(element().startMonth(), startMonth);
        return this;
    }

    public DatepickerAssert startMonth(final Month startMonth) {
        return startMonth(Matchers.is(startMonth));
    }

    @JDIAction(value = "Assert that '{name}' year '{0}'", isAssert = true)
    public DatepickerAssert year(final Matcher<Year> year) {
        jdiAssert(element().getYear(), year);
        return this;
    }

    public DatepickerAssert year(final Year year) {
        return year(Matchers.is(year));
    }

    @JDIAction(value = "Assert that '{name}' has selected year '{0}'", isAssert = true)
    public DatepickerAssert selectedYear(final Matcher<Year> selectedYear) {
        jdiAssert(element().selectedYear(), selectedYear);
        return this;
    }

    public DatepickerAssert selectedYear(final Year selectedYear) {
        return selectedYear(Matchers.is(selectedYear));
    }

    @JDIAction(value = "Assert that '{name}' has start year '{0}'", isAssert = true)
    public DatepickerAssert startYear(final Matcher<Year> startYear) {
        jdiAssert(element().startYear(), startYear);
        return this;
    }

    public DatepickerAssert startYear(final Year startYear) {
        return startYear(Matchers.is(startYear));
    }

    @JDIAction(value = "Assert that '{name}' day '{0}'", isAssert = true)
    public DatepickerAssert day(final Matcher<Integer> day) {
        jdiAssert(element().getDay(), day);
        return this;
    }

    public DatepickerAssert day(final int day) {
        return day(Matchers.is(day));
    }

    @JDIAction(value = "Assert that '{name}' has selected day '{0}'", isAssert = true)
    public DatepickerAssert selectedDay(final Matcher<Integer> selectedDay) {
        jdiAssert(element().selectedDay(), selectedDay);
        return this;
    }

    public DatepickerAssert selectedDay(final int selectedDay) {
        return selectedDay(Matchers.is(selectedDay));
    }

    @JDIAction(value = "Assert that '{name}' has start day '{0}'", isAssert = true)
    public DatepickerAssert startDay(final Matcher<Integer> startDay) {
        jdiAssert(element().startDay(), startDay);
        return this;
    }

    public DatepickerAssert startDay(final int startDay) {
        return startDay(Matchers.is(startDay));
    }

    @JDIAction(value = "Assert that '{name}' has start day '{0}' with '{1}' locale", isAssert = true)
    public DatepickerAssert startDay(final Matcher<Integer> startDay, final Locale locale) {
        jdiAssert(element().startDay(locale), startDay);
        return this;
    }

    public DatepickerAssert startDay(final int startDay, final Locale locale) {
        return startDay(Matchers.is(startDay), locale);
    }

    @JDIAction(value = "Assert that '{name}' has today day '{0}'", isAssert = true)
    public DatepickerAssert todayDay(final Matcher<Integer> todayDay) {
        jdiAssert(element().todayDay(), todayDay);
        return this;
    }

    public DatepickerAssert todayDay(final int todayDay) {
        return todayDay(Matchers.is(todayDay));
    }
}
