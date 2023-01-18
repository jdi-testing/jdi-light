package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.Conditions;
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
import com.jdiai.tools.Timer;
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
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * To see examples of TimePickers web elements please visit <a href="https://vuetifyjs.com/en/components/time-pickers/">time-pickers</a>
 */

public class TimePicker extends UIBaseElement<TimePickerAssert> implements ISetup, HasColor, HasTheme, HasElevation,
        IsReadOnly, HasMeasurement {
    private String root;
    private String expandedRoot;
    private static final String EXPANDER = "div.v-input__slot";
    private static final String TITLE = " div.v-time-picker-title__time";
    private static final String TITLE_HOURS = " div.v-time-picker-title__time > div:nth-child(1)";
    private static final String TITLE_MINUTES = " div.v-time-picker-title__time > div:nth-child(3)";
    private static final String TITLE_SECONDS = " div.v-time-picker-title__time > div:nth-child(5)";
    private static final String TITLE_AM_PM_STATUS = "div.v-time-picker-title__ampm > div";

    private static final String CLOCK_CONTAINER = "div.v-time-picker-clock__container";
    public static final String CLOCK = "div.v-time-picker-clock__inner";
    private static final String HOURS_MINUTES_LIST = "div.v-picker__title__btn";

    private static final String AM_BOTTOM_SWITCHER = "div.v-time-picker-clock__ampm > div:nth-child(1)";
    private static final String PM_BOTTOM_SWITCHER = "div.v-time-picker-clock__ampm > div:nth-child(2)";
    private static final String COLOR_FIELD = "//div[contains(@class, 'v-picker__title')]";
    private static final String AM_TITLE_SWITCHER = "//div[@class='v-time-picker-title__ampm']/div[text()='AM']";
    private static final String PM_TITLE_SWITCHER = "//div[@class='v-time-picker-title__ampm']/div[text()='PM']";
    private static final String DISABLED_HOURS_MINUTES = "div.v-time-picker-clock__inner > span[class*='disabled']";
    private static final String ENABLED_HOURS_MINUTES = "div.v-time-picker-clock__inner > " +
            "span[class='v-time-picker-clock__item']," +
            "span[class='v-time-picker-clock__item v-time-picker-clock__item--active accent']," +
            "span[class='v-time-picker-clock__item v-time-picker-clock__item--active']";
    private static final String ALL_HOURS = "div.v-time-picker-clock__inner > span";
    private static final String ACTIVE_HOURS_MINUTES = "div.v-time-picker-clock__inner > span[class*='active']";
    private static final String BOTH_AM_PM_TITLE = "div.v-time-picker-title__ampm";
    private static final String ACTIVE_AM_PM_IN_TITLE = "div.v-time-picker-title__ampm > div[class*='active']";
    private static final String AM_PM_BUTTON = ".v-picker__body .v-picker__title__btn";
    private static final String RESULT_TIME_WITH_EXPANDER = "div.v-text-field__slot > input";
    private static final String CANCEL = "//div[@class='v-picker__actions v-card__actions']" +
            "//span[text()[contains(.,'Cancel')]]";
    private static final String OK = "//div[@class='v-picker__actions v-card__actions']" +
            "//span[text()[contains(.,'OK')]]";

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
        JTimePicker j = field.getAnnotation(JTimePicker.class);
        setup(j.root(), j.expandedRoot());
    }

    public TimePicker setup(String rootLocator, String expandedRootLocator) {
        if (isNotBlank(rootLocator)) {
            root = rootLocator;
        }
        if (isNotBlank(expandedRootLocator)) {
            expandedRoot = expandedRootLocator;
        }
        return this;
    }

    public UIElement root() {
        return $(root);
    }

    public UIElement expandedRoot() {
        return $(expandedRoot);
    }

    private UIElement expander() {
        return root().find(EXPANDER);
    }

    //TODO Remove as it would select the first element with the text match - regardlles of hours/minutes/seconds
//    @JDIAction("Get '{name}' hours/minutes")
//    private UIElement getHoursMinutes(final String hoursMinutes) {
//        if (expander().isExist()) {
//            return expandedRoot().find(HOURS_MINUTES_LIST).find(By.xpath("//span[text()='" + hoursMinutes + "']"));
//        } else {
//            return root().find(HOURS_MINUTES_LIST).find(By.xpath("//span[text()='" + hoursMinutes + "']"));
//        }
//    }

    @JDIAction("Get '{name}' title hours")
    private UIElement titleHours() {
        if (expander().isExist()) {
            return expandedRoot().find(TITLE_HOURS);
        } else {
            return root().find(TITLE_HOURS);
        }
    }

    @JDIAction("Get '{name}' title minutes")
    private UIElement titleMinutes() {
        if (expander().isExist()) {
            return expandedRoot().find(TITLE_MINUTES);
        } else {
            return root().find(TITLE_MINUTES);
        }
    }

    @JDIAction("Get '{name}' title seconds")
    private UIElement titleSeconds() {
        if (expander().isExist()) {
            return expandedRoot().find(TITLE_SECONDS);
        } else {
            return root().find(TITLE_SECONDS);
        }
    }

    @JDIAction("Get '{name}' title AM/PM status")
    private UIElement titleAmPm() {
        if (expander().isExist()) {
            return expandedRoot().find(TITLE_AM_PM_STATUS);
        } else {
            return root().find(TITLE_AM_PM_STATUS);
        }
    }

    @JDIAction("Get '{name}' clock")
    public UIElement clockDial() {
        return root().find(CLOCK);
    }

    private UIElement amPmBody() {
        return root().find(AM_PM_BUTTON);
    }

    private UIElement amBottomSwitcher() {
        if (expander().isExist()) {
            return expandedRoot().find(AM_BOTTOM_SWITCHER);
        } else {
            return root().find(AM_BOTTOM_SWITCHER);
        }
    }

    private UIElement pmBottomSwitcher() {
        if (expander().isExist()) {
            return expandedRoot().find(PM_BOTTOM_SWITCHER);
        } else {
            return root().find(PM_BOTTOM_SWITCHER);
        }
    }

    private UIElement amTitleSwitcher() {
        if (expander().isExist()) {
            return expandedRoot().find(AM_TITLE_SWITCHER);
        } else {
            return root().find(AM_TITLE_SWITCHER);
        }
    }

    private UIElement pmTitleSwitcher() {
        if (expander().isExist()) {
            return expandedRoot().find(PM_TITLE_SWITCHER);
        } else {
            return root().find(PM_TITLE_SWITCHER);
        }
    }

    private UIElement colorField() {
        if (expander().isExist()) {
            return expandedRoot().find(COLOR_FIELD);
        } else {
            return root().find(COLOR_FIELD);
        }
    }

    private List<UIElement> disabledHoursOrMinutes() {
        if (expander().isExist()) {
            return expandedRoot().finds(DISABLED_HOURS_MINUTES);
        } else {
            return root().finds(DISABLED_HOURS_MINUTES);
        }
    }

    private List<UIElement> enabledHoursOrMinutes() {
        if (expander().isExist()) {
            return expandedRoot().finds(ENABLED_HOURS_MINUTES);
        } else {
            return root().finds(ENABLED_HOURS_MINUTES);
        }
    }

    private List<UIElement> allHours() {
        if (expander().isExist()) {
            return expandedRoot().finds(ALL_HOURS);
        } else {
            return root().finds(ALL_HOURS);
        }
    }

    private UIElement activeHoursOrMinutes() {
        if (expander().isExist()) {
            return expandedRoot().find(ACTIVE_HOURS_MINUTES);
        } else {
            return root().find(ACTIVE_HOURS_MINUTES);
        }
    }

    private UIElement title() {
        if (expander().isExist()) {
            return expandedRoot().find(TITLE);
        } else {
            return root().find(TITLE);
        }
    }

    private UIElement bothAmPmTitle() {
        if (expander().isExist()) {
            return expandedRoot().find(BOTH_AM_PM_TITLE);
        } else {
            return root().find(BOTH_AM_PM_TITLE);
        }
    }

    private UIElement activeAmPmInTitle() {
        if (expander().isExist()) {
            return expandedRoot().find(ACTIVE_AM_PM_IN_TITLE);
        } else {
            return root().find(ACTIVE_AM_PM_IN_TITLE);
        }
    }

    private UIElement resultTimeField() {
        if (expander().isExist()) {
            return root().find(RESULT_TIME_WITH_EXPANDER);
        } else {
            return null;
        }
    }

    private UIElement cancelButton() {
        return expandedRoot().find(CANCEL);
    }

    private UIElement okButton() {
        return expandedRoot().find(OK);
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
//        getHoursMinutes(hours).click();
    }

    @JDIAction("Select '{name}' minutes")
    public void selectMinutes(final String minutes) {
        if (titleMinutes().isExist()) {
            titleMinutes().click();
        }
//        getHoursMinutes(minutes).click();
    }

    @JDIAction("Select '{name}' seconds")
    public void selectSeconds(final String seconds) {
        if (titleSeconds().isExist()) {
            titleSeconds().click();
        }
//        getHoursMinutes(seconds).click();
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
            System.out.println("Cathced");
            return;
        }
        System.out.println("NON CATCHED");
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
            System.out.println("Cathced");
            return;
        }
        System.out.println("NON CATCHED");
    }

    @Override
    @JDIAction("Get '{name}' width of the whole time picker")
    public int width() {
        return root().getSize().getWidth();
    }

    @Override
    @JDIAction("Get '{name}' height of the whole time picker")
    public int height() {
        return root().getSize().getHeight();
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
        return root().classLike("theme--");
    }

    @JDIAction("Check that '{name}' is landscape")
    public boolean isLandscape() {
        return root().hasClass("v-picker--landscape");
    }

    @Override
    public TimePickerAssert is() {
        return new TimePickerAssert().set(this);
    }

    @JDIAction("Scroll on '{name}' clock '{0}' times")
    public void scrollOnClock(int wheelScrolls) {
        //200 millis stale
        //300 millis - OK
//        Timer.sleep(Duration.ofMillis(300).toMillis()); //TODO resolve
//        waitFor();
//        WebElement webElement = clockDial().get();
        ScrollOrigin scrollOrigin = ScrollOrigin.fromElement(root().find(CLOCK).get());
        Actions actions = new Actions(core().driver());
        IntStream.range(0, Math.abs(wheelScrolls))
            .forEach(i -> actions.scrollFromOrigin(scrollOrigin, 0, wheelScrolls < 0 ? -1 : 1));
        actions.build().perform();
    }
}