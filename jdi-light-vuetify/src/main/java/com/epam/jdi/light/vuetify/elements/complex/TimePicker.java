package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.vuetify.annotations.JTimePicker;
import com.epam.jdi.light.vuetify.asserts.TimePickerAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;

import java.lang.reflect.Field;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * To see examples of TimePickers web elements please visit https://vuetifyjs.com/en/components/time-pickers/
 */

public class TimePicker extends UIBaseElement<TimePickerAssert> implements ISetup {
    private String root;
    private String expandedRoot;
    private static final String EXPANDER = "div.v-input__slot";
    private static final String TITLE = " div.v-time-picker-title__time";
    private static final String TITLE_HOURS = " div.v-time-picker-title__time > div:nth-child(1)";
    private static final String TITLE_MINUTES = " div.v-time-picker-title__time > div:nth-child(3)";
    private static final String TITLE_SECONDS = " div.v-time-picker-title__time > div:nth-child(5)";
    private static final String TITLE_AM_PM_STATUS =
            "div.v-time-picker-title__ampm.v-time-picker-title__ampm--readonly > div";
    private static final String HOURS_MINUTES_LIST = "//span[contains(@class, 'v-time-picker-clock__item')]";
    private static final String AM_BOTTOM_SWITCHER = "//div[@class='v-time-picker-clock__container']//div[text()='AM']";
    private static final String PM_BOTTOM_SWITCHER = "//div[@class='v-time-picker-clock__container']//div[text()='PM']";
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
    private static final String RESULT_TIME_WITH_EXPANDER = "div.v-text-field__slot > input";
    private static final String CANCEL = "//div[@class='v-picker__actions v-card__actions']" +
            "//span[text()[contains(.,'Cancel')]]";
    private static final String OK = "//div[@class='v-picker__actions v-card__actions']" +
            "//span[text()[contains(.,'OK')]]";

    private DateTimeFormatter formatterTwelveHoursNoSeconds = DateTimeFormatter.ofPattern("K:mm a");
    private DateTimeFormatter formatterTwelveHoursWithSeconds = DateTimeFormatter.ofPattern("K:mm:ss a");
    private DateTimeFormatter formatterTwentyFourHoursNoSeconds = DateTimeFormatter.ofPattern("K:mm");
    private DateTimeFormatter formatterTwentyFourHoursWithSeconds = DateTimeFormatter.ofPattern("K:mm:ss");
    private DateTimeFormatter formatterResultDate = DateTimeFormatter.ofPattern("HH:mm");

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

    private UIElement getHoursMinutes(final String hoursMinutes) {
        if (expander().isExist()) {
            return expandedRoot().find(By.xpath(HOURS_MINUTES_LIST +
                    "//span[text()='" + hoursMinutes + "']"));
        } else {
            return root().find(By.xpath(HOURS_MINUTES_LIST +
                    "//span[text()='" + hoursMinutes + "']"));
        }
    }

    private UIElement titleHours() {
        if (expander().isExist()) {
            return expandedRoot().find(TITLE_HOURS);
        } else {
            return root().find(TITLE_HOURS);
        }
    }

    private UIElement titleMinutes() {
        if (expander().isExist()) {
            return expandedRoot().find(TITLE_MINUTES);
        } else {
            return root().find(TITLE_MINUTES);
        }
    }

    private UIElement titleSeconds() {
        if (expander().isExist()) {
            return expandedRoot().find(TITLE_SECONDS);
        } else {
            return root().find(TITLE_SECONDS);
        }
    }

    private UIElement titleAmPm() {
        if (expander().isExist()) {
            return expandedRoot().find(TITLE_AM_PM_STATUS);
        } else {
            return root().find(TITLE_AM_PM_STATUS);
        }
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

    @JDIAction("Switch time to AM")
    public void switchToAM() {
        if (amTitleSwitcher().isExist()) {
            amTitleSwitcher().click();
        } else {
            amBottomSwitcher().click();
        }
    }

    @JDIAction("Switch time to PM")
    public void switchToPM() {
        if (pmTitleSwitcher().isExist()) {
            pmTitleSwitcher().click();
        } else {
            pmBottomSwitcher().click();
        }
    }

    @JDIAction("Get hours shown in title")
    public String getHours() {
        return titleHours().getText();
    }

    @JDIAction("Get minutes shown in title")
    public String getMinutes() {
        return titleMinutes().getText();
    }

    @JDIAction("Get seconds shown in title")
    public String getSeconds() {
        return titleSeconds().getText();
    }

    @JDIAction("Get time shown in title")
    public String getTime() {
        if (titleSeconds().isExist()) {
            return getTimeWithSeconds();
        } else {
            return getTimeWithoutSeconds();
        }
    }

    @JDIAction("Get time shown in title - with seconds")
    public String getTimeWithSeconds() {
        if (getAmPmTitle().isExist() || titleAmPm().isExist()) {
            return (getHours() + ":" + getMinutes() + ":" + getSeconds() + " " + amPmStatus());
        } else {
            return (getHours() + ":" + getMinutes() + ":" + getSeconds());
        }
    }

    @JDIAction("Get time shown in title - without seconds")
    public String getTimeWithoutSeconds() {
        if (getAmPmTitle().isExist() || titleAmPm().isExist()) {
            return (getHours() + ":" + getMinutes() + " " + amPmStatus());
        } else {
            return (getHours() + ":" + getMinutes());
        }
    }

    @JDIAction("Get time shown in title in localTime format")
    public LocalTime getLocalTime() {
        if (titleSeconds().isExist()) {
            return getLocalTimeWithSeconds();
        } else {
            return getLocalTimeWithoutSeconds();
        }
    }

    @JDIAction("Get time shown in title in localTime format - with seconds")
    public LocalTime getLocalTimeWithSeconds() {
        if (getAmPmTitle().isExist() || titleAmPm().isExist()) {
            return LocalTime.parse(getTime(), formatterTwelveHoursWithSeconds);
        } else {
            return LocalTime.parse(getTime(), formatterTwentyFourHoursWithSeconds);
        }
    }

    @JDIAction("Get time shown in title in localTime format - without seconds")
    public LocalTime getLocalTimeWithoutSeconds() {
        if (getAmPmTitle().isExist() || titleAmPm().isExist()) {
            return LocalTime.parse(getTime(), formatterTwelveHoursNoSeconds);
        } else {
            return LocalTime.parse(getTime(), formatterTwentyFourHoursNoSeconds);
        }
    }

    @JDIAction("Get color from color field")
    public String getColor() {
        return Color.fromString(colorField().css("background-color")).asHex();
    }

    @JDIAction("Get list of disabled hours/minutes")
    public List<String> getDisabledHoursOrMinutes() {
        return disabledHoursOrMinutes().stream().map(elem
                -> elem.getText()).collect(Collectors.toList());
    }

    @JDIAction("Get list of enabled hours/minutes")
    public List<String> getEnabledHoursOrMinutes() {
        return enabledHoursOrMinutes().stream().map(elem
                -> elem.getText()).collect(Collectors.toList());
    }

    @JDIAction("Get list of enabled hours/minutes elements")
    public List<UIElement> getEnabledHoursOrMinutesElements() {
        return enabledHoursOrMinutes();
    }

    @JDIAction("Get list of disabled hours/minutes elements")
    public List<UIElement> getDisabledHoursOrMinutesElements() {
        return disabledHoursOrMinutes();
    }

    @JDIAction("Get list of disabled hours/minutes elements")
    public List<UIElement> getAllHoursElements() {
        return allHours();
    }

    @JDIAction("Get picker elevation attribute")
    public String getElevation() {
        return root().css("box-shadow");
    }

    @JDIAction("Get active hours or minutes")
    public String getActiveHoursMinutes() {
        return activeHoursOrMinutes().getText();
    }

    @JDIAction("Get title element")
    public UIElement getTitleElement() {
        return title();
    }

    @JDIAction("Get element of title with both AM and PM")
    public UIElement getAmPmTitle() {
        return bothAmPmTitle();
    }

    @JDIAction("Get AM/PM status")
    public String amPmStatus() {
        if (getAmPmTitle().isExist()) {
            return activeAmPmInTitle().getText();
        } else {
            return titleAmPm().getText();
        }
    }

    @JDIAction("Select hours")
    public void selectHours(final String hours) {
        if (titleHours().isExist()) {
            titleHours().click();
        }
        getHoursMinutes(hours).click();
    }

    @JDIAction("Select minutes")
    public void selectMinutes(final String minutes) {
        if (titleMinutes().isExist()) {
            titleMinutes().click();
        }
        getHoursMinutes(minutes).click();
    }

    @JDIAction("Select seconds")
    public void selectSeconds(final String seconds) {
        if (titleSeconds().isExist()) {
            titleSeconds().click();
        }
        getHoursMinutes(seconds).click();
    }

    @JDIAction("Select time using ISO format")
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

    @JDIAction("Click hours section in title")
    public void clickTitleHours() {
        titleHours().click();
    }

    @JDIAction("Get width of the whole time picker")
    public int getPickerWidth() {
        return root().getSize().getWidth();
    }

    @JDIAction("Get result time in the field")
    public String getResultTime() {
        return resultTimeField().getText();
    }

    @JDIAction("Get time shown in result time field in localTime format")
    public LocalTime getResultLocalTime() {
        return LocalTime.parse(getResultTime(), formatterResultDate);
    }

    @JDIAction("Click Cancel button")
    public void clickCancel() {
        cancelButton().click();
    }

    @JDIAction("Click OK button")
    public void clickOk() {
        okButton().click();
    }

    @Override
    public TimePickerAssert is() {
        return new TimePickerAssert().set(this);
    }

    @Override
    public TimePickerAssert has() {
        return new TimePickerAssert().set(this);
    }
}
