package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.DatePickerMonth;
import com.epam.jdi.light.asserts.generic.ColorAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ElevationAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.MeasurementAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import com.jdiai.tools.Timer;
import org.hamcrest.Matchers;

import java.util.List;
import java.util.Set;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class DatePickerMonthAssert extends UIAssert<DatePickerMonthAssert, DatePickerMonth> implements
        MeasurementAssert<DatePickerMonthAssert, DatePickerMonth>, ColorAssert<DatePickerMonthAssert, DatePickerMonth>,
        ThemeAssert<DatePickerMonthAssert, DatePickerMonth>, ElevationAssert<DatePickerMonthAssert, DatePickerMonth> {
    @JDIAction("Assert that '{name}' next year icon class is correct")
    public DatePickerMonthAssert nextYearIconClass(String iconClass) {
        String actualIconClass = element().getNextYearIconClass();
        jdiAssert(actualIconClass, Matchers.containsString(iconClass), String.format("Actual " +
                "next year icon class '%s' is not equal to expected '%s'", actualIconClass, iconClass));
        return this;
    }

    @JDIAction("Assert that '{name}' previous year icon class is correct")
    public DatePickerMonthAssert previousYearIconClass(String iconClass) {
        String actualIconClass = element().getPreviousYearIconClass();
        jdiAssert(actualIconClass, Matchers.containsString(iconClass), String.format("Actual previous year icon class " +
                "'%s' is not equal to expected '%s'", actualIconClass, iconClass));
        return this;
    }

    @JDIAction("Assert that '{name}' has additional year icon")
    public DatePickerMonthAssert additionalYearIcon() {
        jdiAssert(element().getAdditionalYearIcon().isExist(), Matchers.is(true), "Element hasn't " +
                "additional year icon");
        return this;
    }

    @JDIAction("Assert that '{name}' additional year icon class is correct")
    public DatePickerMonthAssert additionalYearIconClass(String iconClass) {
        String actualIconClass = element().getAdditionalYearIconClass();
        jdiAssert(actualIconClass, Matchers.containsString(iconClass), String.format("Actual additional year icon class " +
                "'%s' is not equal to expected '%s'", actualIconClass, iconClass));
        return this;
    }

    @JDIAction("Assert that '{name}' shown year is '{0}'")
    public DatePickerMonthAssert year(int year) {
        Timer.waitCondition(() -> element().getYear().equals(year));
        int actualYear = element().getYear();
        jdiAssert(actualYear, Matchers.is(year), String.format("Actual element's year '%s' is not equal to " +
                "expected '%s'", actualYear, year));
        return this;
    }

    @JDIAction("Assert that '{name}' shown month is '{0}'")
    public DatePickerMonthAssert month(String month) {
        Timer.waitCondition(() -> element().getMonth().equals(month));
        String actualMonth = element().getMonth();
        jdiAssert(actualMonth, Matchers.is(month), String.format("Actual element's shown month '%s' is not equal to " +
                "expected '%s'", actualMonth, month));
        return this;
    }

    @JDIAction("Assert that '{name}' list of enabled months is not empty")
    public DatePickerMonthAssert enabledMonthsNonEmptyList() {
        jdiAssert(element().getEnabledMonths().size(), Matchers.greaterThanOrEqualTo(1), "Enabled " +
                "months is an empty list");
        return this;
    }

    @JDIAction("Assert that '{name}' list of disabled months is not empty")
    public DatePickerMonthAssert disabledMonthsNonEmptyList() {
        jdiAssert(element().getDisabledMonths().size(), Matchers.greaterThanOrEqualTo(1), "Disabled " +
                "months is an empty list");
        return this;
    }

    @JDIAction("Assert that '{name}' enabled months are clickable")
    public DatePickerMonthAssert clickableEnabledMonths() {
        element().getEnabledMonthElements().forEach(elem -> {
                elem.hover();
                Timer.waitCondition(() -> elem.isClickable());
                jdiAssert(elem.isClickable(), Matchers.is(true), "Element is not clickable");
            }
        );
        return this;
    }

    @JDIAction("Assert that '{name}' disabled months are non-clickable")
    public DatePickerMonthAssert nonClickableDisabledMonths() {
        element().getDisabledMonthElements().forEach(elem ->
                jdiAssert(elem.isClickable(), Matchers.is(false), "Element is clickable")
        );
        return this;
    }

    @JDIAction("Assert that all chosen months are correctly chosen")
    public DatePickerMonthAssert properSetOfActiveMonths(Set<String> months) {
        Timer.waitCondition(() -> element().getAllActiveMonths().equals(months));
        List<String> actualActiveMonth = element().getAllActiveMonths();
        jdiAssert(actualActiveMonth, Matchers.containsInAnyOrder(months.toArray()), String.format("Element's " +
                "actual active months '%s' doesn't contain all of the expacted '%s'", actualActiveMonth, months));
        return this;
    }

    @JDIAction("Assert that result date field has proper date")
    public DatePickerMonthAssert resultDate(String resultDate) {
        Timer.waitCondition(() -> element().getResultDate().equals(resultDate));
        String actualResultDate = element().getResultDate();
        jdiAssert(actualResultDate, Matchers.is(resultDate),
                String.format("Actual result date '$s' is not equal to expected '%s'", actualResultDate, resultDate));
        return this;
    }

    @JDIAction("Assert that '{name}' hasn't month field")
    public DatePickerMonthAssert notMonthField() {
        jdiAssert(element().getMonthField().isNotExist(), Matchers.is(true), "Element has month field");
        return this;
    }

    @JDIAction("Assert that '{name}' has month field")
    public DatePickerMonthAssert monthField() {
        Timer.waitCondition(() -> element().getMonthField().isExist());
        jdiAssert(element().getMonthField().isExist(), Matchers.is(true), "Element has not month field");
        return this;
    }

    @JDIAction("Assert that '{name}' has portrait orientation")
    public DatePickerMonthAssert portraitOrientation() {
        jdiAssert(element().getColorFieldWidth(), Matchers.greaterThan(element().getColorFieldHeight()),
                "Element has not portrait orientation");
        return this;
    }

    @JDIAction("Assert that '{name}' has landscape orientation")
    public DatePickerMonthAssert landscapeOrientation() {
        jdiAssert(element().getColorFieldWidth(), Matchers.lessThan(element().getColorFieldHeight()),
                "Element has not landscape orientation");
        return this;
    }
}
