package com.epam.jdi.light.vuetify.elements.complex;

import static com.epam.jdi.light.common.Exceptions.runtimeException;
import static java.lang.String.format;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.base.HasInit;
import com.epam.jdi.light.vuetify.asserts.TimePickerAssert;
import com.epam.jdi.light.elements.interfaces.base.HasColor;
import com.epam.jdi.light.vuetify.interfaces.*;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput.ScrollOrigin;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;


/**
 * Represents v-time-picker Vuetify component TimePicker is stand-alone component that can be utilized in many
 * existing Vuetify components. It offers the user a visual representation for selecting the time. To see
 * examples of TimePickers web elements please visit:
 *
 * @see <a href="https://v2.vuetifyjs.com/en/components/time-pickers/">Vuetify documentation for
 * TimePickers</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/vuetify/#/time-pickers">JDI test page</a>
 */

public class TimePicker extends UIBaseElement<TimePickerAssert>
    implements HasInit, HasColor, HasTheme, HasElevation, IsReadOnly, HasMeasurement, IsScrollable {

    private static final String TITLE = ".v-picker__title";
    private static final String TITLE_TIME = ".v-time-picker-title__time";
    private static final String TITLE_TIME_ELEMENTS = ".v-time-picker-title__time > div";
    private static final String TITLE_BUTTONS_ALL = ".v-picker__title__btn";
    private static final String TITLE_BUTTON_ACTIVE_CLASS = "v-picker__title__btn--active";
    private static final String AM_PM_SWITCHERS = "[class*='__ampm'] .v-picker__title__btn";
    private static final String CLOCK = ".v-time-picker-clock__inner";
    private static final String CLOCK_NUMBERS = ".v-time-picker-clock__item";
    private static final String CLOCK_NUMBERS_ACTIVE = ".v-time-picker-clock__item[class*='active']";
    private static final String CLOCK_NUMBERS_DISABLED = ".v-time-picker-clock__item--disabled";
    private static final String CLOCK_NUMBERS_ENABLED = ".v-time-picker-clock__item:not([class*='--disabled'])";
    private static final String CLOCK_HAND = ".v-time-picker-clock__hand";
    private static final String CLOCK_NUMBER_XPATH_TEMPLATE = "//span[contains(@class, 'v-time-picker-clock__item')]//span[text()='%s']";
    private static final String AM = "AM";
    private static final String PM = "PM";


    public UIElement title() {
        return core().find(TITLE);
    }

    public UIElement clock() {
        return core().find(CLOCK);
    }

    /**
     * Sets TimePicker to provided time, string must represent a valid time and is parsed using
     * {@link java.time.format.DateTimeFormatter#ISO_LOCAL_TIME ISO_LOCAL_TIME} ex. "07:15", "07:15:45".
     * If seconds are not present in timepicker - they are skipped
     *
     * @param time {@link String}
     */
    @JDIAction("Set '{name}' time to {0}")
    public void setTime(final String time) {
        setTime(LocalTime.parse(time));
    }

    /**
     * Sets TimePicker to provided time
     *
     * @param localTime {@link LocalTime}
     */
    @JDIAction("Set '{name}' time to {0}")
    public void setTime(final LocalTime localTime) {
        setTime(localTime.getHour(), localTime.getMinute(), localTime.getSecond());
    }

    /**
     * Sets TimePicker to provided time
     *
     * @param hours   - hours to set (0 - 24) would be converted to 12h if TimePicker is 12h
     * @param minutes - minutes to set (0 - 59) if TimePicker has seconds in title they would be set to `00`
     */
    @JDIAction("Set '{name}' time to {0}:{1}")
    public void setTime(int hours, int minutes) {
        setTime(hours, minutes, 0);
    }

    /**
     * Sets TimePicker to provided time
     *
     * @param hours   - hours to set (0 - 23) would be converted to 12h if TimePicker is 12h
     * @param minutes - minutes to set (0 - 59)
     * @param seconds - seconds to set (0 - 59) - if TimePicker do not have seconds - they would be ignored
     */
    @JDIAction("Set '{name}' time to {0}:{1}:{2}")
    public void setTime(int hours, int minutes, int seconds) {
        boolean hasSeconds = hasSeconds();
        setHours(hours);
        setMinutes(minutes);
        if (hasSeconds) {
            setSeconds(seconds);
        }
    }

    /**
     * Selects number on clock face
     *
     * @param number - number to set
     */
    @JDIAction("Select {0} on a '{name}' clock face dial")
    public void select(int number) {
        if (isMinutesOrSeconds()) {
            executeAndWaitForClockRefresh(() -> selectMinutesSeconds(number));
        } else {
            executeAndWaitForClockRefresh(() -> selectHours(number));
        }
    }

    /**
     * Checks if clock dial shows hours or minutes/seconds
     */
    private boolean isMinutesOrSeconds() {
        return core().find(CLOCK_NUMBERS).getText().equals("00");
    }

    /**
     * Switches TimePicker to hours and sets TimePicker hours
     *
     * @param hours - hours to set (0 - 23) would be converted to 12h if TimePicker is 12h
     */
    @JDIAction("Set '{name}' to {0} hours")
    public void setHours(int hours) {
        switchToHours();
        executeAndWaitForClockRefresh(() -> selectHours(hours));
    }

    /**
     * If provided number is present on clock face and enabled - clicks it
     *
     * @param number - number to set
     */
    private void selectHours(int number) {
        if (number < 0 || number > 23) {
            throw runtimeException("Unexpected input '%s', expecting numbers 0-23 for hours");
        }
        int numberToClick = number;
        if (is12h()) {
            if (number < 12) {
                switchToAM();
            } else {
                switchToPM();
            }
            numberToClick = number == 0 ? 12 : number > 12 ? number - 12 : number;
        }
        UIElement clockNumber = clockNumber(format("%d", numberToClick));
        if (clockNumber.isClickable()) {
            clockNumber.click();
        }
    }

    /**
     * Switches TimePicker to minutes and sets TimePicker minutes
     *
     * @param minutes - minutes to set
     */
    @JDIAction("Set '{name}' to {0} minutes")
    public void setMinutes(int minutes) {
        switchToMinutes();
        executeAndWaitForClockRefresh(() -> selectMinutesSeconds(minutes));
    }

    /**
     * Sets TimePicker seconds to provided if TimePicker do not have seconds - this would be ignored
     *
     * @param seconds - seconds to set
     */
    @JDIAction("Set '{name}' to {0} seconds")
    public void setSeconds(int seconds) {
        switchToSeconds();
        executeAndWaitForClockRefresh(() -> selectMinutesSeconds(seconds));
    }

    /**
     * If provided number is present on clock face and enabled - clicks it, if number is not present -
     * clicks on clock face circumference to set seconds or minutes
     *
     * @param number - number to set
     * @throws RuntimeException if provided number is not in 0..59
     */
    @SuppressWarnings("IntegerDivisionInFloatingPointContext")
    private void selectMinutesSeconds(final int number) {
        if (number < 0 || number > 59) {
            throw runtimeException("Unexpected input '%s', expecting numbers 0-59 for minutes and seconds");
        }
        if (clockNumbers().contains(number)) {
            UIElement clockNumber = clockNumber(format("%02d", number));
            if (clockNumber.isClickable()) {
                clockNumber.click();
            }
            return;
        }
        Rectangle rect = clock().getRect();
        int clockRadius = rect.width / 2;
        double x = clockRadius * Math.sin(Math.toRadians(number * 360 / 60));
        double y = -clockRadius * Math.cos(Math.toRadians(number * 360 / 60));

        new Actions(clock().driver())
            .moveToElement(clock().getWebElement(), (int) x, (int) y)
            .click()
            .perform();
    }

    private UIElement clockNumber(final String number) {
        return core().find(By.xpath(format(CLOCK_NUMBER_XPATH_TEMPLATE, number)));
    }

    /**
     * @return True if TimePicker allows to set seconds false if not
     * @throws RuntimeException if Timepicker has no title - as it impossible to distinguish minutes/seconds.
     *                          Use {@link #select(int)} to set time
     */
    public boolean hasSeconds() {
        if (title().isExist()) {
            return core().finds(TITLE_TIME_ELEMENTS).size() == 3;
        }
        throw runtimeException("TimePicker without title - impossible to distinguish if it has seconds");
    }

    /**
     * Switches TimePicker to AM, action is not performed if there is no AM/PM switcher
     */
    @JDIAction("Switch '{name}' to AM")
    public void switchToAM() {
        amSwitcher().click();
    }

    /**
     * Switches TimePicker to PM, action is not performed if there is no AM/PM switcher
     */
    @JDIAction("Switch '{name}' to PM")
    public void switchToPM() {
        pmSwitcher().click();
    }

    /**
     * Sets TimePicker to select hours and waits for clock face to reload
     */
    @JDIAction("Click '{name}' hours section in title")
    public void switchToHours() {
        selectTitleElement(1);
    }

    /**
     * Sets TimePicker to select minutes and waits for clock face to reload
     */
    @JDIAction("Click '{name}' minutes section in title")
    public void switchToMinutes() {
        selectTitleElement(2);
    }

    /**
     * Sets TimePicker to select seconds and waits for clock face to reload
     *
     * @throws RuntimeException if trying to set seconds for TimePicker that do not have them
     */
    @JDIAction("Click '{name}' seconds section in title")
    public void switchToSeconds() {
        selectTitleElement(3);
    }

    private void selectTitleElement(int position) {
        WebList titleElements = core().finds(TITLE_TIME_ELEMENTS);
        if (position > titleElements.size()) {
            throw runtimeException("Trying to set seconds, but TimePicker is configured without seconds or title is missing");
        }
        if (titleElements.get(position).hasClass(TITLE_BUTTON_ACTIVE_CLASS)) {
            return;
        }
        executeAndWaitForClockRefresh(() -> titleElements.get(position).click());
    }

    private void executeAndWaitForClockRefresh(Runnable action) {
        WebElement clockToRefresh = clock().getWebElement();
        action.run();
        try {
            new FluentWait<>(base().driver())
                .withTimeout(Duration.ofMillis(500))
                .pollingEvery(Duration.ofMillis(50))
                .until(ExpectedConditions.stalenessOf(clockToRefresh));
        } catch (TimeoutException ignore) { }
    }

    /**
     * @return Time shown in Title as {@link String}
     */
    @JDIAction("Get '{name}' time shown in title")
    public String titleText() {
        return core().find(TITLE_TIME).getText().replaceAll("\n", "") + amPmPeriod();
    }

    /**
     * @return Time shown in Title as {@link LocalTime}
     * @throws DateTimeParseException – if the text in title cannot be parsed
     */
    @JDIAction("Get '{name}' time shown in title")
    public LocalTime titleTime() {
        if (is12h()) {
            return LocalTime.parse(titleText(), DateTimeFormatter.ofPattern("h:mm[:ss]a"));
        }
        return LocalTime.parse(titleText(), DateTimeFormatter.ofPattern("HH:mm[:ss]"));
    }

    /**
     * @return Hours shown in Title as int
     * @throws NumberFormatException if TimePicker hours were not set
     */
    @JDIAction("Get '{name}' hours shown in title")
    public int titleHours() {
        return Integer.parseInt(titleText().split(":")[0]);
    }

    /**
     * @return Minutes shown in Title as int
     * @throws NumberFormatException if TimePicker minutes were not set
     */
    @JDIAction("Get '{name}' minutes shown in title")
    public int titleMinutes() {
        return Integer.parseInt(titleText().split(":")[1].substring(0, 2));
    }

    /**
     * @return Seconds shown in Title as int
     * @throws NumberFormatException if TimePicker seconds were not set or not shown
     */
    @JDIAction("Get '{name}' seconds shown in title")
    public int titleSeconds() {
        String[] titleTime = titleText().split(":");
        return Integer.parseInt(titleTime.length == 3 ? titleTime[2].substring(0, 2) : "");
    }

    /**
     * @return true if TimePicker is 12h or false if 24h
     */
    public boolean is12h() {
        return amPmSwitchers().size() > 0;
    }

    /**
     * @return Currently selected AM/PM status
     */
    @JDIAction("Get '{name}' AM/PM status")
    public String amPmPeriod() {
        return is12h() ? amSwitcher().attr("class").contains("--active") ? AM : PM : "";
    }

    private UIElement amSwitcher() {
        return amPmSwitchers().get(amPmSwitchers().size() - 1);
    }
    private UIElement pmSwitcher() {
        return amPmSwitchers().get(amPmSwitchers().size());
    }

    private WebList amPmSwitchers() {
        return core().finds(AM_PM_SWITCHERS);
    }

    /**
     * @return List of all numbers shown on the clock face (starting from the topmost clockwise)
     */
    @JDIAction("Get '{name}' list of clock face numbers")
    public List<Integer> clockNumbers() {
        return elementsTextToInteger(core().finds(CLOCK_NUMBERS));
    }

    /**
     * @return List of all enabled numbers shown on the clock face (starting from the topmost clockwise)
     */
    @JDIAction("Get '{name}' list of enabled hours/minutes")
    public List<Integer> enabledClockNumbers() {
        return elementsTextToInteger(core().finds(CLOCK_NUMBERS_ENABLED));
    }

    /**
     * @return List of all disabled numbers shown on the clock face (starting from the topmost clockwise)
     */
    @JDIAction("Get '{name}' list of disabled clock face numbers")
    public List<Integer> disabledClockNumbers() {
        return elementsTextToInteger(core().finds(CLOCK_NUMBERS_DISABLED));
    }

    private List<Integer> elementsTextToInteger(WebList webList) {
        return webList.getValuesFast()
            .stream()
            .map(Integer::valueOf)
            .collect(Collectors.toList());
    }

    /**
     * @return Currently selected number on the clock face
     *
     */
    @JDIAction("Get '{name}' currently selected number")
    public int selectedNumber() {
        if (core().find(CLOCK_NUMBERS_ACTIVE).isExist()) {
            return Integer.parseInt(core().find(CLOCK_NUMBERS_ACTIVE).getText());
        }
        Pattern pattern = Pattern.compile(".*rotate\\((\\d+)deg\\).*");
        Matcher matcher = pattern.matcher(core().find(CLOCK_HAND).attr("style"));
        if (matcher.matches()) {
            return Integer.parseInt(matcher.group(1)) / 6;
        }
        throw runtimeException("This is unexpected. Clock hand was not present - could not get selected number");
    }

    /**
     * @return Check if TimePicker is readonly
     */
    @Override
    @JDIAction("Get if '{name}' is readonly")
    public boolean isReadOnly() {
        return amPmSwitchers().stream().allMatch(el -> el.attr("class").contains("--readonly"));
    }

    /**
     * @return Check if TimePicker is disabled
     */
    @Override
    @JDIAction("Check that '{name}' is disabled")
    public boolean isDisabled() {
        return core().finds(TITLE_BUTTONS_ALL).stream()
            .allMatch(el -> el.attr("class").contains("--readonly"))
            && core().finds(CLOCK_NUMBERS).stream()
            .allMatch(el -> el.attr("class").contains("--disabled"));
    }

    @Override
    @JDIAction("Check that '{name}' is enabled")
    public boolean isEnabled() {
        return !this.isDisabled();
    }

    /**
     * @return Return title background color as hex {@link String}
     */
    @JDIAction("Get '{name}' title background color")
    public String titleBackgroundColor() {
        return Color.fromString(title().css("background-color")).asHex();
    }

    @JDIAction("Get if '{name}' is landscape")
    public boolean isLandscape() {
        return core().hasClass("v-picker--landscape");
    }

    /**
     * Mouse over the element and emulate mouse wheel scroll
     *
     * @param wheelScrolls number of mouse wheel "ticks" to emulate. Negative value scrolls up.
     */
    @Override
    @JDIAction("Scroll on '{name}' '{0}' times")
    public void scroll(int wheelScrolls) {
        ScrollOrigin scrollOrigin = ScrollOrigin.fromElement(clock().get());
        Actions actions = new Actions(core().driver());
        IntStream.range(0, Math.abs(wheelScrolls))
            .forEach(i -> actions.scrollFromOrigin(scrollOrigin, 0, wheelScrolls < 0 ? -1 : 1));
        actions.build().perform();
    }

    @Override
    public TimePickerAssert is() {
        return new TimePickerAssert().set(this);
    }
}
