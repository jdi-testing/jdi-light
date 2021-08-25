package com.epam.jdi.light.angular.elements.complex;

import com.epam.jdi.light.angular.asserts.DatepickerAssert;
import com.epam.jdi.light.angular.elements.composite.DatepickerContainer;
import com.epam.jdi.light.angular.entities.DatepickerNavigation;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.common.TextTypes;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.elements.interfaces.common.IsInput;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import static com.epam.jdi.light.angular.entities.DatepickerNavigation.DATEPICKER;
import static com.epam.jdi.light.angular.entities.DatepickerNavigation.TOGGLE;
import static com.epam.jdi.light.logger.LogLevels.DEBUG;

/**
 * To see an example of Datepicker web element please visit https://material.angular.io/components/datepicker/overview.
 */

public class Datepicker extends UIBaseElement<DatepickerAssert> implements HasLabel, IsInput {
    public static final String CLASS = "class";
    public String inputLocator = DATEPICKER.getName().replace("/ancestor::mat-form-field", "");
    public String openButton = DATEPICKER.getName().concat("/following-sibling::*/span[contains(text(),'Open')]");
    public String exampleEvents = DATEPICKER.getName().concat("/following-sibling::div[@class='example-events']/div");
    public String switchLocaleButton = DATEPICKER.getName().concat("/following-sibling::*/span[contains(text(),'switch')]");
    public String toggleButton = TOGGLE.getName().replace("mat-datepicker-toggle", "button");
    public String smartSharp = "smart: #";
    public String cssSharp = "css='#";
    protected DatepickerContainer cdkOverlayContainer;

    public Datepicker() {
        cdkOverlayContainer = new DatepickerContainer();
    }

    @JDIAction(level = DEBUG, timeout = 0)
    public void expand() {
        if (openButton().isExist()) {
            if (isCollapsed()) {
                openButton().click();
            }
        } else if (isCollapsed()) {
            toggleButton().click();
        }
    }

    @JDIAction(level = DEBUG, timeout = 0)
    public void collapse() {
        if (openButton().isExist()) {
            if (isExpanded()) {
                cdkOverlayContainer.collapse();
            }
        } else if (isExpanded()) {
            cdkOverlayContainer.collapse();
        }
    }

    @JDIAction(value = "Is '{name}' expanded")
    public boolean isExpanded() {
        if (openButton().isExist()) {
            return cdkOverlayContainer.isDisplayed();
        } else {
            return toggle().attr(CLASS).contains("mat-datepicker-toggle-active");
        }
    }

    public boolean isCollapsed() {
        return !isExpanded();
    }

    @JDIAction(value = "Is '{name}' focused")
    public boolean isFocused() {
        return datepicker().attr(CLASS).contains("mat-focused");
    }

    public boolean isValid() {
        return !isInvalid();
    }

    @JDIAction(value = "Is '{name}' has valid value")
    public boolean isInvalid() {
        return datepicker().attr(CLASS).contains("mat-form-field-invalid");
    }

    @Override
    public boolean isEnabled() {
        return !isDisabled();
    }

    @JDIAction(value = "Is '{name}' disabled")
    @Override
    public boolean isDisabled() {
        return datepicker().attr(CLASS).contains("mat-form-field-disabled");
    }

    public boolean isToggleEnabled() {
        return !isToggleDisabled();
    }

    @JDIAction(value = "Is '{name}' toggle disabled")
    public boolean isToggleDisabled() {
        return toggleButton().attr("disabled").contains("true");
    }

    public boolean isInputEnabled() {
        return !isInputDisabled();
    }

    @JDIAction(value = "Is '{name}' input disabled")
    public boolean isInputDisabled() {
        return input().hasAttribute("disabled");
    }

    public boolean isEnabledNavigationElements(final String... navigationElements) {
        return !isDisabledNavigationElements(navigationElements);
    }

    @JDIAction(value = "Is '{name}' has disabled values '{0}'")
    public boolean isDisabledNavigationElements(final String... navigationElements) {
        expand();
        return cdkOverlayContainer.disabled(navigationElements);
    }

    @JDIAction(level = DEBUG, timeout = 0)
    @Override
    public void clear() {
        core().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        core().click(getOutsidePoint().getX(), getOutsidePoint().getY());
        core().waitFor().value("");
    }

    @JDIAction("Get '{name}' date")
    public String value() {
        return core().text(TextTypes.VALUE);
    }

    @JDIAction("Send keys '{0}' for '{name}'")
    @Override
    public void sendKeys(final CharSequence... date) {
        core().sendKeys(date);
        core().click(getOutsidePoint().getX(), getOutsidePoint().getY());
    }

    @JDIAction("Set text '{0}' for '{name}'")
    @Override
    public void setText(final String date) {
        clear();
        sendKeys(date);
    }

    @JDIAction("Input text '{0}' for '{name}'")
    @Override
    public void input(final String date) {
        clear();
        sendKeys(date);
    }

    @JDIAction("Set date '{0}' for '{name}'")
    public void setDate(final LocalDate date) {
        clear();
        core().sendKeys(date.format(DateTimeFormatter.ofPattern("M/dd/yyyy", Locale.ENGLISH)));
        core().click(getOutsidePoint().getX(), getOutsidePoint().getY());
    }

    @JDIAction("Open years view in '{name}'")
    public void openYearsView() {
        expand();
        cdkOverlayContainer.openYearsView();
    }

    @JDIAction("Select '{0}' day '{name}' in previous month")
    public void selectDayInPreviousMonth(final int day) {
        expand();
        cdkOverlayContainer.selectPreviousMonth();
        cdkOverlayContainer.selectDay(day);
    }

    @JDIAction("Select '{0}' day '{name}' in next month")
    public void selectDayInNextMonth(final int day) {
        expand();
        cdkOverlayContainer.selectNextMonth();
        cdkOverlayContainer.selectDay(day);
    }

    @JDIAction("Select '{1}' day '{0}' month earlier '{name}'")
    public void navigateToDayInPreviousMonths(final int monthCount, final int day) {
        if (monthCount < 0) {
            navigateToDayInNextMonths(-monthCount, day);
        }
        expand();
        for (int i = 0; i < monthCount; i++) {
            cdkOverlayContainer.selectPreviousMonth();
        }
        cdkOverlayContainer.selectDay(day);
    }

    @JDIAction("Select '{1}' day '{0}' month later '{name}'")
    public void navigateToDayInNextMonths(final int monthCount, final int day) {
        if (monthCount < 0) {
            navigateToDayInPreviousMonths(-monthCount, day);
        }
        expand();
        for (int i = 0; i < monthCount; i++) {
            cdkOverlayContainer.selectNextMonth();
        }
        cdkOverlayContainer.selectDay(day);
    }

    @JDIAction("Get '{name}' input month value")
    public Month getMonth() {
        int slashIndex = core().text().trim().indexOf("/");
        return Month.of(Integer.valueOf(core().text().trim().substring(0, slashIndex)));
    }

    @JDIAction("Get '{name}' start month value")
    public Month startMonth() {
        expand();
        Month startMonth = cdkOverlayContainer.startMonth();
        cdkOverlayContainer.collapse();
        return startMonth;
    }

    @JDIAction("Get '{name}' input day value")
    public int getDay() {
        int firstSlashIndex = core().text().trim().indexOf("/") + 1;
        int secondSlashIndex = core().text().trim().lastIndexOf("/");
        return Integer.valueOf(core().text().trim().substring(firstSlashIndex, secondSlashIndex));
    }

    @JDIAction("Get '{name}' start day value")
    public int startDay() {
        expand();
        cdkOverlayContainer.selectActiveMonth();
        return cdkOverlayContainer.activeDay();
    }

    /**
     * Select start day.
     *
     * @param locale for month value
     * @return int value of the start day
     */
    @JDIAction("Get '{name}' start day value with '{0}' locale")
    public int startDay(final Locale locale) {
        expand();
        cdkOverlayContainer.selectActiveMonth(locale);
        return cdkOverlayContainer.activeDay();
    }

    @JDIAction("Get '{name}' input year value")
    public Year getYear() {
        int secondSlashIndex = core().text().trim().lastIndexOf("/") + 1;
        return Year.of(Integer.valueOf(core().text().trim().substring(secondSlashIndex)));
    }

    @JDIAction("Get '{name}' start year value")
    public Year startYear() {
        expand();
        return cdkOverlayContainer.startYear();
    }

    /**
     * Select date.
     *
     * @param date string value with 'US' locale
     */
    @JDIAction("Select date '{0}' for '{name}'")
    public void select(final String date) {
        expand();
        cdkOverlayContainer.select(date, Locale.US);
    }

    @JDIAction("Select date '{0}' with '{1}' locale for '{name}'")
    public void select(final String date, final Locale locale) {
        expand();
        cdkOverlayContainer.select(date, locale);
    }

    /**
     * Select date.
     *
     * @param date LocalDate value with 'US' locale
     */
    @JDIAction("Select date '{0}' for '{name}'")
    public void select(final LocalDate date) {
        expand();
        cdkOverlayContainer.select(date, Locale.US);
    }

    @JDIAction("Select date '{0}' with '{1}' for '{name}'")
    public void select(final LocalDate date, final Locale locale) {
        expand();
        cdkOverlayContainer.select(date, locale);
    }

    /**
     * Get selected date as LocalDate value with 'US' locale as default.
     *
     * @return LocalDate value
     */
    @JDIAction("Get '{name}' selected date value")
    public LocalDate selectedDate() {
        expand();
        return cdkOverlayContainer.selectedDate();
    }

    @JDIAction("Get '{name}' selected date value")
    public LocalDate selectedDate(final Locale locale) {
        expand();
        return cdkOverlayContainer.selectedDate(locale);
    }

    @JDIAction("Get '{name}' selected month value")
    public Month selectedMonth() {
        expand();
        return cdkOverlayContainer.selectedMonth();
    }

    @JDIAction("Select day '{0}' for '{name}'")
    public void selectDay(final int day) {
        expand();
        cdkOverlayContainer.selectDay(day);
    }

    @JDIAction("Get '{name}' selected day value")
    public int selectedDay() {
        expand();
        return cdkOverlayContainer.selectedDay();
    }

    @JDIAction("Get '{name}' today day value")
    public int todayDay() {
        expand();
        return cdkOverlayContainer.todayDay();
    }

    @JDIAction("Get '{name}' selected year value")
    public Year selectedYear() {
        expand();
        return cdkOverlayContainer.selectedYear();
    }

    @JDIAction("Get '{name}' week day numbers")
    public String[] getWeekDayNumbers(final DatepickerNavigation weekName) {
        expand();
        return cdkOverlayContainer.getWeekDayNumbers(weekName);
    }

    @JDIAction("Switch locale for '{name}'")
    public void switchLocale() {
        switchLocaleButton().click();
    }

    @JDIAction(value = "Is '{name}' locale '{0}'")
    public boolean isSelectedLocale(final Locale locale) {
        expand();
        return cdkOverlayContainer.isSelectedLocale(locale);
    }

    @JDIAction(value = "Is '{name}' has first input & change events '{0}'")
    public boolean isFirstInputChangeEvents(final List<String> firstInputChangeEvents) {
        WebList allEvents = exampleEvents();
        String firstInputEvent = allEvents.get(1).text();
        String firstChangeEvent = allEvents.get(2).text();
        List<String> actualInputChangeEvents = new ArrayList<>(Arrays.asList(firstInputEvent, firstChangeEvent));
        return actualInputChangeEvents.get(0).contains(firstInputChangeEvents.get(0))
                && actualInputChangeEvents.get(1).contains(firstInputChangeEvents.get(1));
    }

    @JDIAction(value = "Is '{name}' has last input & change events '{0}'")
    public boolean isLastInputChangeEvents(final List<String> lastInputChangeEvents) {
        WebList allEvents = exampleEvents();
        String lastInputEvent = allEvents.get(allEvents.size() - 1).text();
        String lastChangeEvent = allEvents.get(allEvents.size()).text();
        List<String> actualInputChangeEvents = new ArrayList<>(Arrays.asList(lastInputEvent, lastChangeEvent));
        return actualInputChangeEvents.get(0).contains(lastInputChangeEvents.get(0))
                && actualInputChangeEvents.get(1).contains(lastInputChangeEvents.get(1));
    }

    @JDIAction(value = "Is '{name}' has last change event '{0}'")
    public boolean isLastChangeEvent(final String lastChangeEvent) {
        WebList allEvents = exampleEvents();
        String changeEvent = allEvents.get(allEvents.size()).text();
        return changeEvent.contains(lastChangeEvent);
    }

    @JDIAction(value = "Is '{name}' has last input event '{0}'")
    public boolean isLastInputEvent(final String lastInputEvent) {
        WebList allEvents = exampleEvents();
        String inputEvent = allEvents.get(allEvents.size() - 1).text();
        return inputEvent.contains(lastInputEvent);
    }

    @Override
    public DatepickerAssert is() {
        return new DatepickerAssert().set(this);
    }

    protected UIElement datepicker() {
        return new UIElement(By.xpath(String.format(DATEPICKER.getName(),
                                                    this.core().locator.printLocator().replace(smartSharp, "")
                                                            .replace(cssSharp, "").replace("'", ""))));
    }

    protected UIElement input() {
        return new UIElement(By.xpath(String.format(inputLocator,
                                                    this.core().locator.printLocator().replace(smartSharp, "")
                                                            .replace(cssSharp, "").replace("'", ""))));
    }

    protected UIElement toggle() {
        return new UIElement(By.xpath(String.format(TOGGLE.getName(),
                                                    this.core().locator.printLocator().replace(smartSharp, "")
                                                            .replace(cssSharp, "").replace("'", ""))));
    }

    protected UIElement toggleButton() {
        return new UIElement(By.xpath(String.format(toggleButton,
            this.core().locator.printLocator().replace(smartSharp, "")
                .replace(cssSharp, "").replace("'", ""))));
    }

    protected UIElement openButton() {
        String replaceExpression = this.core().locator.printLocator().replace(smartSharp, "").replace(cssSharp, "")
                .replace("'", "");
        return new UIElement(By.xpath(String.format(openButton, replaceExpression)));
    }

    protected WebList exampleEvents() {
        String replaceExpression = this.core().locator.printLocator().replace(smartSharp, "").replace(cssSharp, "")
                .replace("'", "");
        return new WebList(By.xpath(String.format(exampleEvents, replaceExpression)));
    }

    protected UIElement switchLocaleButton() {
        String replaceExpression = this.core().locator.printLocator().replace(smartSharp, "").replace(cssSharp, "")
                .replace("'", "");
        return new UIElement(By.xpath(String.format(switchLocaleButton, replaceExpression)));
    }

    protected Point getOutsidePoint() {
        return new Point(core().core().getRect().getWidth() + 2, core().core().getRect().getHeight() + 2);
    }
}
