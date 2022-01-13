package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.DatePickerMonth;
import com.epam.jdi.tools.Timer;
import org.hamcrest.Matchers;

import java.util.Set;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class DatePickerMonthAssert extends UIAssert<DatePickerMonthAssert, DatePickerMonth> {
    @JDIAction("Assert that next year icon class is correct")
    public DatePickerMonthAssert nextYearIconClass(String expectedYearMonthIconClass) {
        jdiAssert(element().getNextYearIconClass(), Matchers.containsString(expectedYearMonthIconClass));
        return this;
    }

    @JDIAction("Assert that previous year icon class is correct")
    public DatePickerMonthAssert previousYearIconClass(String expectedPreviousYearIconClass) {
        jdiAssert(element().getPreviousYearIconClass(), Matchers.containsString(expectedPreviousYearIconClass));
        return this;
    }

    @JDIAction("Assert that additional year icon exists")
    public DatePickerMonthAssert additionalYearIcon() {
        jdiAssert(element().getAdditionalYearIcon().isExist(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that color of color field is correct")
    public DatePickerMonthAssert color(String expectedColor) {
        jdiAssert(element().getColor(), Matchers.is(expectedColor));
        return this;
    }

    @JDIAction("Assert that shown year is correct")
    public DatePickerMonthAssert year(int expectedYear) {
        Timer.waitCondition(() -> element().getYear().equals(expectedYear));
        jdiAssert(element().getYear(), Matchers.is(expectedYear));
        return this;
    }

    @JDIAction("Assert that shown month is correct")
    public DatePickerMonthAssert month(String expectedMonth) {
        Timer.waitCondition(() -> element().getMonth().equals(expectedMonth));
        jdiAssert(element().getMonth(), Matchers.is(expectedMonth));
        return this;
    }

    @JDIAction("Assert that list of disabled months is not empty")
    public DatePickerMonthAssert disabledMonthsNonEmptyList() {
        jdiAssert(element().getDisabledMonths().size(), Matchers.greaterThanOrEqualTo(1));
        return this;
    }

    @JDIAction("Assert that enabled months are clickable")
    public DatePickerMonthAssert clickableEnabledMonths() {
        element().getEnabledMonthElements().stream().forEach(elem -> {
                    elem.hover();
                    Timer.waitCondition(() -> elem.isClickable());
                    jdiAssert(elem.isClickable(), Matchers.is(true));
                }
        );
        return this;
    }

    @JDIAction("Assert that disabled months are non-clickable")
    public DatePickerMonthAssert nonClickableDisabledMonths() {
        element().getDisabledMonthElements().stream().forEach(elem ->
                jdiAssert(!elem.isClickable(), Matchers.is(true))
        );
        return this;
    }

    @JDIAction("Assert that all chosen months are correctly chosen")
    public DatePickerMonthAssert properSetOfActiveMonths(Set<String> expectedMonths) {
        Timer.waitCondition(() -> element().getAllActiveMonths().equals(expectedMonths));
        jdiAssert(element().getAllActiveMonths(), Matchers.containsInAnyOrder(expectedMonths.toArray()));
        return this;
    }

    @JDIAction("Assert that outlined month border is correct")
    public DatePickerMonthAssert properOutlinedMonthBorder(String expectedBorderThickness) {
        jdiAssert(element().getOutlinedMonthBorder(), Matchers.containsString(expectedBorderThickness));
        return this;
    }

    @JDIAction("Assert that width of the picker is correct")
    public DatePickerMonthAssert pickerWidth(int expectedWidth) {
        jdiAssert(element().getPickerWidth(), Matchers.is(expectedWidth));
        return this;
    }

    @JDIAction("Assert that result date field has proper date")
    public DatePickerMonthAssert resultDate(String expectedResultDate) {
        Timer.waitCondition(() -> element().getResultDate().equals(expectedResultDate));
        jdiAssert(element().getResultDate(), Matchers.is(expectedResultDate));
        return this;
    }

    @JDIAction("Assert that month field does not exist")
    public DatePickerMonthAssert monthFieldIsNotExist() {
        jdiAssert(element().getMonthField().isNotExist(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that month field exists")
    public DatePickerMonthAssert monthField() {
        Timer.waitCondition(() -> element().getMonthField().isExist());
        jdiAssert(element().getMonthField().isExist(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that color field has portrait orientation")
    public DatePickerMonthAssert portraitOrientation() {
        jdiAssert(element().getColorFieldWidth(), Matchers.greaterThan(element().getColorFieldHeight()));
        return this;
    }

    @JDIAction("Assert that color field has landscape orientation")
    public DatePickerMonthAssert landscapeOrientation() {
        jdiAssert(element().getColorFieldWidth(), Matchers.lessThan(element().getColorFieldHeight()));
        return this;
    }
}
