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

public class TimePicker extends UIBaseElement<TimePickerAssert> implements ISetup, HasColor, HasTheme, HasElevation,
        IsReadOnly, HasMeasurement {
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
    private static final String AM_PM_BUTTON = ".v-picker__body .v-picker__title__btn";
    private static final String RESULT_TIME_WITH_EXPANDER = "div.v-text-field__slot > input";
    private static final String ACTIONS = ".v-picker__actions";

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

    private UIElement getCoreElement() {
        UIElement coreElement = root();

        if (expander().isExist()) {
            coreElement = expandedRoot();
        }
        return coreElement;
    }

    @JDIAction("Get '{name}' hours/minutes")
    private UIElement getHoursMinutes(final String hoursMinutes) {
        return getCoreElement().find(By.xpath(HOURS_MINUTES_LIST +
                "//span[text()='" + hoursMinutes + "']"));
    }

    @JDIAction("Get '{name}' title hours")
    public UIElement titleHours() {
        return getCoreElement().find(TITLE_HOURS);
    }

    @JDIAction("Get '{name}' title minutes")
    public UIElement titleMinutes() {
        return getCoreElement().find(TITLE_MINUTES);
    }

    @JDIAction("Get '{name}' title seconds")
    public UIElement titleSeconds() {
        return getCoreElement().find(TITLE_SECONDS);
    }

    @JDIAction("Get '{name}' title AM/PM status")
    private UIElement titleAmPm() {
        return getCoreElement().find(TITLE_AM_PM_STATUS);
    }

    private UIElement amPmBody() {
        return root().find(AM_PM_BUTTON);
    }

    private UIElement amBottomSwitcher() {
        return getCoreElement().find(AM_BOTTOM_SWITCHER);
    }

    private UIElement pmBottomSwitcher() {
        return getCoreElement().find(PM_BOTTOM_SWITCHER);
    }

    private UIElement amTitleSwitcher() {
        return getCoreElement().find(AM_TITLE_SWITCHER);
    }

    private UIElement pmTitleSwitcher() {
        return getCoreElement().find(PM_TITLE_SWITCHER);
    }

    private UIElement colorField() {
        return getCoreElement().find(COLOR_FIELD);
    }

    private List<UIElement> disabledHoursOrMinutes() {
        return getCoreElement().finds(DISABLED_HOURS_MINUTES);
    }

    private List<UIElement> enabledHoursOrMinutes() {
        return getCoreElement().finds(ENABLED_HOURS_MINUTES);
    }

    private List<UIElement> allHours() {
        return getCoreElement().finds(ALL_HOURS);
    }

    private UIElement activeHoursOrMinutes() {
        return getCoreElement().find(ACTIVE_HOURS_MINUTES);
    }

    private UIElement title() {
        return getCoreElement().find(TITLE);
    }

    private UIElement bothAmPmTitle() {
        return getCoreElement().find(BOTH_AM_PM_TITLE);
    }

    private UIElement activeAmPmInTitle() {
        return getCoreElement().find(ACTIVE_AM_PM_IN_TITLE);
    }

    private UIElement resultTimeField() {
        if (expander().isExist()) {
            return root().find(RESULT_TIME_WITH_EXPANDER);
        } else {
            return null;
        }
    }

    public UIElement actions() {
        return expandedRoot().find(ACTIONS);
    }

    public ButtonGroup actionsButtons() {
        return new ButtonGroup().setCore(ButtonGroup.class, expandedRoot().find(ACTIONS));
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
        return disabledHoursOrMinutes().stream().map(elem
                -> elem.getText()).collect(Collectors.toList());
    }

    @JDIAction("Get '{name}' list of enabled hours/minutes")
    public List<String> getEnabledHoursOrMinutes() {
        return enabledHoursOrMinutes().stream().map(elem
                -> elem.getText()).collect(Collectors.toList());
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

    @JDIAction("Get if '{name}' is elevated")
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
        getHoursMinutes(hours).click();
    }

    @JDIAction("Select '{name}' minutes")
    public void selectMinutes(final String minutes) {
        if (titleMinutes().isExist()) {
            titleMinutes().click();
        }
        getHoursMinutes(minutes).click();
    }

    @JDIAction("Select '{name}' seconds")
    public void selectSeconds(final String seconds) {
        if (titleSeconds().isExist()) {
            titleSeconds().click();
        }
        getHoursMinutes(seconds).click();
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
        return resultTimeField().getText();
    }

    @JDIAction("Get '{name}' time shown in result time field in localTime format")
    public LocalTime getResultLocalTime() {
        return LocalTime.parse(getResultTime(), formatterResultDate);
    }

    @Override
    @JDIAction("Get if '{name}' is readonly")
    public boolean isReadOnly() {
        return amPmBody().attr("class").contains("-readonly");
    }

    @JDIAction("Get '{name}' theme")
    public String theme() {
        return root().classLike("theme--");
    }

    @JDIAction("Get if '{name}' is landscape")
    public boolean isLandscape() {
        return root().hasClass("v-picker--landscape");
    }

    @Override
    public TimePickerAssert is() {
        return new TimePickerAssert().set(this);
    }
}
