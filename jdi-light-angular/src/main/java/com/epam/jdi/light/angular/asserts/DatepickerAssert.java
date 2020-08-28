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
    @JDIAction("Assert that '{name}' expanded")
    public DatepickerAssert expanded() {
        jdiAssert(element().isExpanded(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' collapsed")
    public DatepickerAssert collapsed() {
        jdiAssert(element().isCollapsed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' focused")
    public DatepickerAssert focused() {
        jdiAssert(element().isFocused(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has locale '{0}'")
    public DatepickerAssert locale(final Locale locale) {
        jdiAssert(element().isSelectedLocale(locale), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has first input & change events '{0}'")
    public DatepickerAssert firstInputChangeEvents(final List<String> firstInputChangeEvents) {
        jdiAssert(element().isFirstInputChangeEvents(firstInputChangeEvents), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has last input & change events '{0}'")
    public DatepickerAssert lastInputChangeEvents(final List<String> lastInputChangeEvents) {
        jdiAssert(element().isLastInputChangeEvents(lastInputChangeEvents), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has last change event '{0}'")
    public DatepickerAssert lastChangeEvent(final String lastChangeEvent) {
        jdiAssert(element().isLastChangeEvent(lastChangeEvent), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has last input event '{0}'")
    public DatepickerAssert lastInputEvent(final String lastInputEvent) {
        jdiAssert(element().isLastInputEvent(lastInputEvent), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has valid value")
    public DatepickerAssert valid() {
        jdiAssert(element().isValid(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has invalid value")
    public DatepickerAssert invalid() {
        jdiAssert(element().isInvalid(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' enabled")
    public DatepickerAssert enabled() {
        jdiAssert(element().isEnabled(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' disabled")
    public DatepickerAssert disabled() {
        jdiAssert(element().isDisabled(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has enabled toggle")
    public DatepickerAssert enabledToggle() {
        jdiAssert(element().isToggleEnabled(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has disabled toggle")
    public DatepickerAssert disabledToggle() {
        jdiAssert(element().isToggleDisabled(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has enabled input")
    public DatepickerAssert enabledInput() {
        jdiAssert(element().isInputEnabled(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has disabled input")
    public DatepickerAssert disabledInput() {
        jdiAssert(element().isInputDisabled(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has enabled values '{0}'")
    public DatepickerAssert enabledNavigation(final String... navigationElements) {
        jdiAssert(element().isEnabledNavigationElements(navigationElements), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has disabled values '{0}'")
    public DatepickerAssert disabledNavigation(final String... navigationElements) {
        jdiAssert(element().isDisabledNavigationElements(navigationElements), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' text '{0}'")
    public DatepickerAssert text(final Matcher<String> condition) {
        jdiAssert(element().text(), condition);
        return this;
    }

    @JDIAction("Assert that '{name}' placeholder '{0}'")
    public DatepickerAssert placeholder(final Matcher<String> condition) {
        jdiAssert(element().placeholder(), condition);
        return this;
    }

    public DatepickerAssert placeholder(final String date) {
        return placeholder(Matchers.is(date));
    }

    @JDIAction("Assert that '{name}' date '{0}'")
    public DatepickerAssert date(final Matcher<String> date) {
        jdiAssert(element().getValue(), date);
        return this;
    }

    public DatepickerAssert date(final String date) {
        return date(Matchers.is(date));
    }

    @JDIAction("Assert that '{name}' has selected date '{0}'")
    public DatepickerAssert selectedDate(final Matcher<LocalDate> selectedDate) {
        jdiAssert(element().selectedDate(), selectedDate);
        return this;
    }

    public DatepickerAssert selectedDate(final LocalDate selectedDate) {
        return selectedDate(Matchers.is(selectedDate));
    }

    @JDIAction("Assert that '{name}' has selected date '{0}' with '{1}' locale")
    public DatepickerAssert selectedDate(final Matcher<LocalDate> selectedDate, final Locale locale) {
        jdiAssert(element().selectedDate(locale), selectedDate);
        return this;
    }

    public DatepickerAssert selectedDate(final LocalDate selectedDate, final Locale locale) {
        return selectedDate(Matchers.is(selectedDate), locale);
    }

    @JDIAction("Assert that '{name}' month '{0}'")
    public DatepickerAssert month(final Matcher<Month> month) {
        jdiAssert(element().getMonth(), month);
        return this;
    }

    public DatepickerAssert month(final Month month) {
        return month(Matchers.is(month));
    }

    @JDIAction("Assert that '{name}' has selected month '{0}'")
    public DatepickerAssert selectedMonth(final Matcher<Month> selectedMonth) {
        jdiAssert(element().selectedMonth(), selectedMonth);
        return this;
    }

    public DatepickerAssert selectedMonth(final Month selectedMonth) {
        return selectedMonth(Matchers.is(selectedMonth));
    }

    @JDIAction("Assert that '{name}' has start month '{0}'")
    public DatepickerAssert startMonth(final Matcher<Month> startMonth) {
        jdiAssert(element().startMonth(), startMonth);
        return this;
    }

    public DatepickerAssert startMonth(final Month startMonth) {
        return startMonth(Matchers.is(startMonth));
    }

    @JDIAction("Assert that '{name}' year '{0}'")
    public DatepickerAssert year(final Matcher<Year> year) {
        jdiAssert(element().getYear(), year);
        return this;
    }

    public DatepickerAssert year(final Year year) {
        return year(Matchers.is(year));
    }

    @JDIAction("Assert that '{name}' has selected year '{0}'")
    public DatepickerAssert selectedYear(final Matcher<Year> selectedYear) {
        jdiAssert(element().selectedYear(), selectedYear);
        return this;
    }

    public DatepickerAssert selectedYear(final Year selectedYear) {
        return selectedYear(Matchers.is(selectedYear));
    }

    @JDIAction("Assert that '{name}' has start year '{0}'")
    public DatepickerAssert startYear(final Matcher<Year> startYear) {
        jdiAssert(element().startYear(), startYear);
        return this;
    }

    public DatepickerAssert startYear(final Year startYear) {
        return startYear(Matchers.is(startYear));
    }

    @JDIAction("Assert that '{name}' day '{0}'")
    public DatepickerAssert day(final Matcher<Integer> day) {
        jdiAssert(element().getDay(), day);
        return this;
    }

    public DatepickerAssert day(final int day) {
        return day(Matchers.is(day));
    }

    @JDIAction("Assert that '{name}' has selected day '{0}'")
    public DatepickerAssert selectedDay(final Matcher<Integer> selectedDay) {
        jdiAssert(element().selectedDay(), selectedDay);
        return this;
    }

    public DatepickerAssert selectedDay(final int selectedDay) {
        return selectedDay(Matchers.is(selectedDay));
    }

    @JDIAction("Assert that '{name}' has start day '{0}'")
    public DatepickerAssert startDay(final Matcher<Integer> startDay) {
        jdiAssert(element().startDay(), startDay);
        return this;
    }

    public DatepickerAssert startDay(final int startDay) {
        return startDay(Matchers.is(startDay));
    }

    @JDIAction("Assert that '{name}' has start day '{0}' with '{1}' locale")
    public DatepickerAssert startDay(final Matcher<Integer> startDay, final Locale locale) {
        jdiAssert(element().startDay(locale), startDay);
        return this;
    }

    public DatepickerAssert startDay(final int startDay, final Locale locale) {
        return startDay(Matchers.is(startDay), locale);
    }

    @JDIAction("Assert that '{name}' has today day '{0}'")
    public DatepickerAssert todayDay(final Matcher<Integer> todayDay) {
        jdiAssert(element().todayDay(), todayDay);
        return this;
    }

    public DatepickerAssert todayDay(final int todayDay) {
        return todayDay(Matchers.is(todayDay));
    }
}
