package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.vuetify.annotations.JTimePicker;
import com.epam.jdi.light.vuetify.asserts.TimePickerAssert;
import com.epam.jdi.light.vuetify.interfaces.HasColor;
import com.epam.jdi.light.vuetify.interfaces.HasElevation;
import com.epam.jdi.light.vuetify.interfaces.HasMeasurement;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;
import com.epam.jdi.light.vuetify.interfaces.IsReadOnly;
import java.time.Duration;
import java.util.stream.IntStream;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput.ScrollOrigin;
import org.openqa.selenium.support.Color;

import java.lang.reflect.Field;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * To see examples of TimePickers web elements please visit <a href="https://vuetifyjs.com/en/components/time-pickers/">time-pickers</a>
 */

public class TimePicker extends UIBaseElement<TimePickerAssert> implements ISetup, HasColor, HasTheme, HasElevation,
        IsReadOnly, HasMeasurement {
    private String root;
    private String expandedRoot;
    private static final String EXPANDER = "div.v-input__slot";
    private static final String TITLE = "div.v-time-picker-title__time";
    private static final String TITLE_HOURS = TITLE + " > div:nth-child(1)";
    private static final String TITLE_MINUTES = TITLE + " > div:nth-child(3)";
    private static final String TITLE_SECONDS = TITLE + " > div:nth-child(5)";
    private static final String TITLE_AM_PM_STATUS = "div.v-time-picker-title__ampm > div";
    private static final String AM_BOTTOM_SWITCHER = "div.v-time-picker-clock__ampm > div:nth-child(1)";
    private static final String PM_BOTTOM_SWITCHER = "div.v-time-picker-clock__ampm > div:nth-child(2)";
    private static final String COLOR_FIELD = "div.v-picker__title";
    private static final String AM_TITLE_SWITCHER = "div.v-time-picker-title__ampm > div:nth-child(1)";
    private static final String PM_TITLE_SWITCHER = "div.v-time-picker-title__ampm > div:nth-child(2)";
    public static final String CLOCK_FACE = "div.v-time-picker-clock__inner";
    private static final String DISABLED_CLOCK_FACE_NUMBERS = CLOCK_FACE + " > span.v-time-picker-clock__item--disabled";
    private static final String ENABLED_CLOCK_FACE_NUMBERS = CLOCK_FACE + " > span.v-time-picker-clock__item:not([class*='--disabled'])";
    private static final String CLOCK_FACE_NUMBERS = "//span[contains(@class, 'v-time-picker-clock__item')]";
    private static final String ALL_HOURS = "div.v-time-picker-clock__inner > span";
    private static final String ACTIVE_HOURS_MINUTES = "div.v-time-picker-clock__inner > span[class*='active']";
    private static final String BOTH_AM_PM_TITLE = "div.v-time-picker-title__ampm";
    private static final String ACTIVE_AM_PM_IN_TITLE = "div.v-time-picker-title__ampm > div[class*='active']";
    private static final String AM_PM_BUTTON = "div.v-picker__body div.v-picker__title__btn";
    private static final String RESULT_TIME_WITH_EXPANDER = "div.v-text-field__slot > input";
    private static final String CANCEL_BUTTON = "div.v-picker__actions > button:nth-of-type(1)";
    private static final String OK_BUTTON = "div.v-picker__actions > button:nth-of-type(2)";

    private final DateTimeFormatter formatterTwelveHoursNoSeconds = DateTimeFormatter.ofPattern("K:mm a");
    private final DateTimeFormatter formatterTwelveHoursWithSeconds = DateTimeFormatter.ofPattern("K:mm:ss a");
    private final DateTimeFormatter formatterTwentyFourHoursNoSeconds = DateTimeFormatter.ofPattern("K:mm");
    private final DateTimeFormatter formatterTwentyFourHoursWithSeconds = DateTimeFormatter.ofPattern("K:mm:ss");
    private final DateTimeFormatter formatterResultTime = DateTimeFormatter.ofPattern("HH:mm");

    @Override
    public void setup(Field field) {
        if (!fieldHasAnnotation(field, JTimePicker.class, TimePicker.class)) {
            return;
        }
        JTimePicker annotation = field.getAnnotation(JTimePicker.class);
        setup(annotation.root(), annotation.expandedRoot());
    }

    public TimePicker setup(String rootLocator, String expandedRootLocator) {
        if (isNotBlank(rootLocator)) {
            root = rootLocator;
        }
        if (isNotBlank(expandedRootLocator)) {
            expandedRoot = expandedRootLocator;
        }
        base().setLocator(root);
        return this;
    }

    private UIElement root() {
        return $(root);
    }

    private UIElement expandedRoot() {
        return $(expandedRoot);
    }

    private UIElement fromRoot() {
        return isExpanded() ? expandedRoot() : root();
    }

    private UIElement expander() {
        return root().find(EXPANDER);
    }

    private boolean isExpanded() {
        return expander().isExist();
    }

    private UIElement watchFaceNumber(final String number) {
        String watchFaceNumberXpath = CLOCK_FACE_NUMBERS + "//span[text()='" + number + "']";
        return fromRoot().find(By.xpath(watchFaceNumberXpath));
    }

    @JDIAction("Get '{name}' title hours")
    public UIElement titleHours() {
        return fromRoot().find(TITLE_HOURS);
    }

    @JDIAction("Get '{name}' title minutes")
    public UIElement titleMinutes() {
        return fromRoot().find(TITLE_MINUTES);
    }

    @JDIAction("Get '{name}' title seconds")
    public UIElement titleSeconds() {
        return fromRoot().find(TITLE_SECONDS);
    }

    @JDIAction("Get '{name}' title AM/PM status")
    public UIElement titleAmPm() {
        return fromRoot().find(TITLE_AM_PM_STATUS);
    }

    @JDIAction("Get '{name}' clock")
    public UIElement clockFace() {
        return fromRoot().find(CLOCK_FACE);
    }

    private UIElement amPmBody() {
        return fromRoot().find(AM_PM_BUTTON);
    }

    private UIElement amBottomSwitcher() {
        return fromRoot().find(AM_BOTTOM_SWITCHER);
    }

    private UIElement pmBottomSwitcher() {
        return fromRoot().find(PM_BOTTOM_SWITCHER);
    }

    private UIElement amTitleSwitcher() {
        return fromRoot().find(AM_TITLE_SWITCHER);
    }

    private UIElement pmTitleSwitcher() {
        return fromRoot().find(PM_TITLE_SWITCHER);
    }

    private UIElement colorField() {
        return fromRoot().find(COLOR_FIELD);
    }

    private List<UIElement> disabledHoursOrMinutes() {
        return fromRoot().finds(DISABLED_CLOCK_FACE_NUMBERS);
    }

    private List<UIElement> enabledHoursOrMinutes() {
        return fromRoot().finds(ENABLED_CLOCK_FACE_NUMBERS);
    }

    private List<UIElement> allHours() {
        return fromRoot().finds(ALL_HOURS);
    }

    private UIElement activeHoursOrMinutes() {
        return fromRoot().find(ACTIVE_HOURS_MINUTES);
    }

    private UIElement title() {
        return fromRoot().find(TITLE);
    }

    private UIElement bothAmPmTitle() {
        return fromRoot().find(BOTH_AM_PM_TITLE);
    }

    private UIElement activeAmPmInTitle() {
        return fromRoot().find(ACTIVE_AM_PM_IN_TITLE);
    }

    private UIElement resultTimeField() {
        return isExpanded() ? root().find(RESULT_TIME_WITH_EXPANDER) : null;
    }

    private UIElement cancelButton() {
        return expandedRoot().find(CANCEL_BUTTON);
    }

    private UIElement okButton() {
        return expandedRoot().find(OK_BUTTON);
    }

    @JDIAction("Expand '{name}'")
    public void expand() {
        if (root().find(EXPANDER).isExist()) {
            expander().click();
        }
    }

    @JDIAction("Switch '{name}' time to AM")
    public void switchToAM() {
        if (amTitleSwitcher().isExist()) {
            amTitleSwitcher().click();
        } else {
            amBottomSwitcher().click();
        }
    }

    @JDIAction("Switch '{name}' time to PM")
    public void switchToPM() {
        if (pmTitleSwitcher().isExist()) {
            pmTitleSwitcher().click();
        } else {
            pmBottomSwitcher().click();
        }
    }

    @JDIAction("Get '{name}' hours shown in title")
    public String getHours() {
        return titleHours().getText();
    }

    @JDIAction("Get '{name}' minutes shown in title")
    public String getMinutes() {
        return titleMinutes().getText();
    }

    @JDIAction("Get '{name}' seconds shown in title")
    public String getSeconds() {
        return titleSeconds().getText();
    }

    @JDIAction("Get '{name}' time shown in title")
    public String getTime() {
        if (titleSeconds().isExist()) {
            return getTimeWithSeconds();
        } else {
            return getTimeWithoutSeconds();
        }
    }

    @JDIAction("Get '{name}' time shown in title - with seconds")
    public String getTimeWithSeconds() {
        if (getAmPmTitle().isExist() || titleAmPm().isExist()) {
            return (getHours() + ":" + getMinutes() + ":" + getSeconds() + " " + amPmStatus());
        } else {
            return (getHours() + ":" + getMinutes() + ":" + getSeconds());
        }
    }

    @JDIAction("Get '{name}' time shown in title - without seconds")
    public String getTimeWithoutSeconds() {
        if (getAmPmTitle().isExist() || titleAmPm().isExist()) {
            return (getHours() + ":" + getMinutes() + " " + amPmStatus());
        } else {
            return (getHours() + ":" + getMinutes());
        }
    }

    @JDIAction("Get '{name}' time shown in title in localTime format")
    public LocalTime getLocalTime() {
        if (titleSeconds().isExist()) {
            return getLocalTimeWithSeconds();
        } else {
            return getLocalTimeWithoutSeconds();
        }
    }

    @JDIAction("Get '{name}' time shown in title in localTime format - with seconds")
    public LocalTime getLocalTimeWithSeconds() {
        if (getAmPmTitle().isExist() || titleAmPm().isExist()) {
            return LocalTime.parse(getTime(), formatterTwelveHoursWithSeconds);
        } else {
            return LocalTime.parse(getTime(), formatterTwentyFourHoursWithSeconds);
        }
    }

    @JDIAction("Get '{name}' time shown in title in localTime format - without seconds")
    public LocalTime getLocalTimeWithoutSeconds() {
        if (getAmPmTitle().isExist() || titleAmPm().isExist()) {
            return LocalTime.parse(getTime(), formatterTwelveHoursNoSeconds);
        } else {
            return LocalTime.parse(getTime(), formatterTwentyFourHoursNoSeconds);
        }
    }

    @JDIAction("Get '{name}' background color from color field")
    public String fieldBackgroundColor() {
        return Color.fromString(colorField().css("background-color")).asHex();
    }

    @JDIAction("Get '{name}' list of disabled hours/minutes")
    public List<String> getDisabledHoursOrMinutes() {
        return disabledHoursOrMinutes().stream().map(UIElement::getText).collect(Collectors.toList());
    }

    @JDIAction("Get '{name}' list of enabled hours/minutes")
    public List<String> getEnabledHoursOrMinutes() {
        return enabledHoursOrMinutes().stream().map(UIElement::getText).collect(Collectors.toList());
    }

    @JDIAction("Get '{name}' list of enabled hours/minutes")
    public List<UIElement> getEnabledHoursOrMinutesElements() {
        return enabledHoursOrMinutes();
    }

    @JDIAction("Get '{name}' list of disabled hours/minutes")
    public List<UIElement> getDisabledHoursOrMinutesElements() {
        return disabledHoursOrMinutes();
    }

    @JDIAction("Get '{name}' list of all hours/minutes")
    public List<UIElement> getAllHoursElements() {
        return allHours();
    }

    @JDIAction("Check that '{name}' is elevated")
    public boolean isElevated() {
        return root().attr("class").matches(String.format(".*%s.*", ELEVATION_PATTERN));
    }

    @JDIAction("Get '{name}' elevation")
    public String elevation() {
        return root().classes().stream()
                .filter(cls -> cls.matches(ELEVATION_PATTERN))
                .map(value -> value.split("-")[1])
                .findFirst()
                .orElse("");
    }

    @JDIAction("Get '{name}' active hours or minutes")
    public String getActiveHoursMinutes() {
        return activeHoursOrMinutes().getText();
    }

    @JDIAction("Get '{name}' title element")
    public UIElement getTitleElement() {
        return title();
    }

    @JDIAction("Get '{name}' element of title with both AM and PM")
    public UIElement getAmPmTitle() {
        return bothAmPmTitle();
    }

    @JDIAction("Get '{name}' AM/PM status")
    public String amPmStatus() {
        if (getAmPmTitle().isExist()) {
            return activeAmPmInTitle().getText();
        } else {
            return titleAmPm().getText();
        }
    }

    @JDIAction("Select '{name}' hours")
    public void selectHours(final String hours) {
        if (titleHours().isExist()) {
            titleHours().click();
        }
        watchFaceNumber(hours).click();
    }

    @JDIAction("Select '{name}' minutes")
    public void selectMinutes(final String minutes) {
        if (titleMinutes().isExist()) {
            titleMinutes().click();
        }
        watchFaceNumber(minutes).click();
    }

    @JDIAction("Select '{name}' seconds")
    public void selectSeconds(final String seconds) {
        if (titleSeconds().isExist()) {
            titleSeconds().click();
        }
        watchFaceNumber(seconds).click();
    }

    @JDIAction("Select '{name}' time using ISO format")
    public void selectTime(final String time) {
        int firstColonIndex = time.indexOf(":");
        String expectedHours = time.substring(0, firstColonIndex);
        String expectedMinutes = time.substring(firstColonIndex + 1, firstColonIndex + 3);
        String expectedSeconds = time.substring(firstColonIndex + 4, firstColonIndex + 6);
        selectHours(expectedHours);
        selectMinutes(expectedMinutes);
        selectSeconds(expectedSeconds);
        if (time.contains("AM") || time.contains("PM")) {
            if (time.contains("AM")) {
                switchToAM();
            } else {
                switchToPM();
            }
        }
    }

    @JDIAction("Click '{name}' hours section in title")
    public void clickTitleHours() {
        WebElement titleHours = titleHours().getWebElement();
        titleHours.click();

        boolean catched = false;

        try {
            Wait<WebDriver> wait = new FluentWait<>(base().driver())
                .withTimeout(Duration.ofMillis(500))
                .pollingEvery(Duration.ofMillis(100));

            wait.until(ExpectedConditions.stalenessOf(titleHours));
        } catch (TimeoutException ignore) {
            catched = true;
        }

        if (catched) {
            logger.debug("CATCHED EX");
            return;
        }
        logger.debug("NON CATCHED EX"); //TODO
    }

    @JDIAction("Click '{name}' minutes section in title")
    public void clickTitleMinutes() {
        WebElement titleMinutes = titleMinutes().getWebElement();
        titleMinutes.click();

        boolean catched = false;

        try {
            Wait<WebDriver> wait = new FluentWait<>(base().driver())
                .withTimeout(Duration.ofMillis(500))
                .pollingEvery(Duration.ofMillis(100));

            wait.until(ExpectedConditions.stalenessOf(titleMinutes));
        } catch (TimeoutException ignore) {
            catched = true;
        }

        if (catched) {
            logger.debug("CATCHED EX");
            return;
        }
        logger.debug("NON CATCHED EX"); //TODO
    }

    @Override
    @JDIAction("Get '{name}' width of the whole time picker")
    public int width() {
        return fromRoot().getSize().getWidth();
    }

    @Override
    @JDIAction("Get '{name}' height of the whole time picker")
    public int height() {
        return fromRoot().getSize().getHeight();
    }

    @JDIAction("Get '{name}' result time in the field")
    public String getResultTime() {
        UIElement resultTimeField = resultTimeField();
        return resultTimeField == null ? "" : resultTimeField.getText();
    }

    @JDIAction("Get '{name}' time shown in result time field in localTime format")
    public LocalTime getResultLocalTime() {
        return LocalTime.parse(getResultTime(), formatterResultTime);
    }

    @JDIAction("Click '{name}' Cancel button")
    public void clickCancel() {
        cancelButton().click();
    }

    @JDIAction("Click '{name}' OK button")
    public void clickOk() {
        okButton().click();
    }

    @Override
    @JDIAction("Check that '{name}' is readonly")
    public boolean isReadOnly() {
        return amPmBody().attr("class").contains("-readonly");
    }

    @JDIAction("Get '{name}' theme")
    public String theme() {
        return fromRoot().classLike("theme--");
    }

    @JDIAction("Check that '{name}' is landscape")
    public boolean isLandscape() {
        return fromRoot().hasClass("v-picker--landscape");
    }

    @JDIAction("Scroll on '{name}' clock '{0}' times")
    public void scrollOnClock(int wheelScrolls) {
        ScrollOrigin scrollOrigin = ScrollOrigin.fromElement(clockFace().get());
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