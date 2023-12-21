package io.github.com.custom.bars;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.complex.WebList;
import io.github.com.custom.asserts.CalendarToolBarAssert;
import java.time.Month;
import java.util.Locale;

import static com.epam.jdi.light.elements.init.UIFactory.$$;
import static com.jdiai.tools.Timer.waitCondition;

public class CalendarToolBar extends UIBaseElement<CalendarToolBarAssert> {
    private static final String MENU_LOCATOR = ".menuable__content__active [role='menuitem']";
    private static final String MENU_DOWN_LOCATOR = ".mdi-menu-down";
    private static final String TODAY_BUTTON_LOCATOR = "//span[contains(text(),'Today')]";
    private static final String PREVIOUS_DAY_LOCATOR = ".mdi-chevron-left";
    private static final String NEXT_LOCATOR = ".mdi-chevron-right";

    private static final String ACTIVE_MONTH_YEAR_LOCATOR = ".v-toolbar__title";

    public WebList menu() {
        return $$(MENU_LOCATOR);
    }

    @JDIAction("Switch {name} to the previous day")
    public void previousDay() {
        find(PREVIOUS_DAY_LOCATOR).click();
    }

    @JDIAction("Switch {name} to the next day")
    public void nextDay() {
        find(NEXT_LOCATOR).click();
    }

    @JDIAction("Switch {name} to the present day")
    public void today() {
        find(TODAY_BUTTON_LOCATOR).click();
    }

    public void openMenu() {
        find(MENU_DOWN_LOCATOR).click();
    }

    @JDIAction("Select {type} of the calendar in dropdown menu")
    public void selectCalendarType(String type) {
        openMenu();
        waitCondition(() -> menu().isDisplayed());
        menu().select(type);
    }

    @JDIAction("Get active date of {name}")
    public int activeYear() {
        String[] yearAndMonth = core().find(ACTIVE_MONTH_YEAR_LOCATOR)
                .text()
                .trim()
                .split("\\s");
        return Integer.parseInt(yearAndMonth[1]);
    }

    @JDIAction("Get active month of {name}")
    public Month activeMonth() {
        String[] yearAndMonth = core().find(ACTIVE_MONTH_YEAR_LOCATOR)
                .text()
                .trim()
                .split("\\s");

        return Month.valueOf(yearAndMonth[0].toUpperCase(Locale.ROOT));
    }

    @Override
    public CalendarToolBarAssert is() {
        return new CalendarToolBarAssert().set(this);
    }
}

