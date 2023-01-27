package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.bars.CalendarToolBar;
import org.hamcrest.Matchers;
import java.time.Month;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class CalendarToolBarAssert extends UIAssert<CalendarToolBarAssert, CalendarToolBar> {

    @JDIAction("Assert that {name} has active month")
    public CalendarToolBarAssert activeMonth(Month expectedMonth) {
        Month actualMonth = element().activeMonth();
        jdiAssert(
                actualMonth,
                Matchers.equalTo(expectedMonth),
                String.format(
                        "Wrong active month. Expected: %s, but was: %s",
                        expectedMonth, actualMonth
                )
        );
        return this;
    }

    @JDIAction("Assert that {name} has active year")
    public CalendarToolBarAssert activeYear(int expectedYear) {
        int actualYear = element().activeYear();
        jdiAssert(
                actualYear,
                Matchers.equalTo(expectedYear),
                String.format(
                        "Wrong active year. Expected: %s, but was: %s",
                        expectedYear, actualYear
                )
        );
        return this;
    }
}
