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

import java.util.Set;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class DatePickerMonthAssert extends UIAssert<DatePickerMonthAssert, DatePickerMonth> implements
        MeasurementAssert<DatePickerMonthAssert, DatePickerMonth>, ColorAssert<DatePickerMonthAssert, DatePickerMonth>,
        ThemeAssert<DatePickerMonthAssert, DatePickerMonth>, ElevationAssert<DatePickerMonthAssert, DatePickerMonth> {
    @JDIAction(value = "Assert that '{name}' next year icon class is correct", isAssert = true)
    public DatePickerMonthAssert nextYearIconClass(String iconClass) {
        jdiAssert(element().getNextYearIconClass(), Matchers.containsString(iconClass));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' previous year icon class is correct", isAssert = true)
    public DatePickerMonthAssert previousYearIconClass(String iconClass) {
        jdiAssert(element().getPreviousYearIconClass(), Matchers.containsString(iconClass));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has additional year icon", isAssert = true)
    public DatePickerMonthAssert additionalYearIcon() {
        jdiAssert(element().getAdditionalYearIcon().isExist(), Matchers.is(true), "Element hasn't " +
                "additional year icon");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' additional year icon class is correct", isAssert = true)
    public DatePickerMonthAssert additionalYearIconClass(String iconClass) {
        jdiAssert(element().getAdditionalYearIconClass(), Matchers.containsString(iconClass));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' shown year is '{0}'", isAssert = true)
    public DatePickerMonthAssert year(int year) {
        jdiAssert(element().getYear(), Matchers.is(year));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' shown month is '{0}'", isAssert = true)
    public DatePickerMonthAssert month(String month) {
        jdiAssert(element().getMonth(), Matchers.is(month));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' list of enabled months is not empty", isAssert = true)
    public DatePickerMonthAssert enabledMonthsNonEmptyList() {
        jdiAssert(element().getEnabledMonths().size(), Matchers.greaterThanOrEqualTo(1), "Enabled " +
                "months is an empty list");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' list of disabled months is not empty", isAssert = true)
    public DatePickerMonthAssert disabledMonthsNonEmptyList() {
        jdiAssert(element().getDisabledMonths().size(), Matchers.greaterThanOrEqualTo(1), "Disabled " +
                "months is an empty list");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' enabled months are clickable", isAssert = true)
    public DatePickerMonthAssert clickableEnabledMonths() {
        element().getEnabledMonthElements().forEach(elem -> {
                elem.hover();
                Timer.waitCondition(() -> elem.isClickable());
                jdiAssert(elem.isClickable(), Matchers.is(true), "Element is not clickable");
            }
        );
        return this;
    }

    @JDIAction(value = "Assert that '{name}' disabled months are non-clickable", isAssert = true)
    public DatePickerMonthAssert nonClickableDisabledMonths() {
        element().getDisabledMonthElements().forEach(elem ->
                jdiAssert(elem.isClickable(), Matchers.is(false), "Element is clickable", isAssert = true)
        );
        return this;
    }

    @JDIAction(value = "Assert that all chosen months are correctly chosen", isAssert = true)
    public DatePickerMonthAssert properSetOfActiveMonths(Set<String> months) {
        jdiAssert(element().getAllActiveMonths(), Matchers.containsInAnyOrder(months.toArray()));
        return this;
    }

    @JDIAction(value = "Assert that result date field has {0} date", isAssert = true)
    public DatePickerMonthAssert resultDate(String resultDate) {
        jdiAssert(element().getResultDate(), Matchers.is(resultDate));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' hasn't month field", isAssert = true)
    public DatePickerMonthAssert notMonthField() {
        jdiAssert(element().getMonthField().isNotExist(), Matchers.is(true), "Element has month field");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has month field", isAssert = true)
    public DatePickerMonthAssert monthField() {
        Timer.waitCondition(() -> element().getMonthField().isExist());
        jdiAssert(element().getMonthField().isExist(), Matchers.is(true), "Element has not month field");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has portrait orientation", isAssert = true)
    public DatePickerMonthAssert portraitOrientation() {
        jdiAssert(element().getColorFieldWidth(), Matchers.greaterThan(element().getColorFieldHeight()),
                "Element has not portrait orientation");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has landscape orientation", isAssert = true)
    public DatePickerMonthAssert landscapeOrientation() {
        jdiAssert(element().getColorFieldWidth(), Matchers.lessThan(element().getColorFieldHeight()),
                "Element has not landscape orientation");
        return this;
    }
}
