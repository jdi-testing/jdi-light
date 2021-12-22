package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.vuetify.annotations.JTimePicker;
import com.epam.jdi.light.vuetify.asserts.TimePickersAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;

import java.lang.reflect.Field;

import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * To see examples of TimePickers web elements please visit https://vuetifyjs.com/en/components/time-pickers/
 */

//public class TimePickers extends UIListBase<TimePickersAssert> {
//
//    @Override
//    public TimePickersAssert is() {
//        return new TimePickersAssert().set(this);
//    }
//
//    @JDIAction("Check that {name} is enabled")
//    public boolean enabled() {
//        return list().isNotEmpty() && list().stream().anyMatch(UIElement::isEnabled)
//                && list().stream().anyMatch(UIElement::isClickable);
//    }
//
//    @JDIAction("Check that {name} is disabled")
//    public boolean disabled() {
//        return !enabled();
//    }
//
//    @JDIAction("Check that {name} element {0} is disabled")
//    public boolean elementDisabled(String value) {
//        return list().get(value).hasClass("v-time-picker-clock__item--disabled");
//    }
//
//    @JDIAction("Check that {name} element {0} is disabled")
//    public boolean elementDisabled(int value) {
//        return list().get(value).hasClass("v-time-picker-clock__item--disabled");
//    }
//
//    @JDIAction("Check that {name} element {0} is enabled")
//    public boolean elementEnabled(String value) {
//        return !elementDisabled(value);
//    }
//
//    @JDIAction("Check that {name} element {0} is enabled")
//    public boolean elementEnabled(int value) {
//        return !elementDisabled(value);
//    }
//}


public class TimePickers extends UIBaseElement<TimePickersAssert> implements ISetup {
    private String root;
    private String expandedRoot;
    //private static final String EXPANDER = ".....";
    private static final String TITLE_HOURS = " div.v-time-picker-title__time > div:nth-child(1)";
    private static final String TITLE_MINUTES = " div.v-time-picker-title__time > div:nth-child(3)";
    private static final String TITLE_AM_PM = "div.v-time-picker-title__ampm.v-time-picker-title__ampm--readonly > div";
    private static final String HOURS_MINUTES_LIST = "//span[@class='v-time-picker-clock__item']";
    private static final String AM_BOTTOM_SWITCHER = "//div[@class='v-time-picker-clock__container']//div[text()='AM']";
    private static final String PM_BOTTOM_SWITCHER = "//div[@class='v-time-picker-clock__container']//div[text()='PM']";
    private static final String COLOR_FIELD = "//div[contains(@class, 'v-picker__title')]";
    private static final String AM_TITLE_SWITCHER = "//div[@class='v-time-picker-title']//div[text()='AM']";
    private static final String PM_TITLE_SWITCHER = "//div[@class='v-time-picker-title']//div[text()='PM']";



    @Override
    public void setup(Field field) {
        if (!fieldHasAnnotation(field, JTimePicker.class, TimePickers.class)) {
            return;
        }
        JTimePicker j = field.getAnnotation(JTimePicker.class);
        setup(j.root(), j.expandedRoot());
    }

    public TimePickers setup(String rootLocator, String expandedRootLocator) {
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

    //    protected UIElement getDay(final String day) {
    //        if (expander().isExist()) {
    //            return expandedRoot().find(By.xpath("//button/div[text()='" + day + "']"));
    //        } else {
    //            return root().find(By.xpath(DAY_LIST_WITHOUT_EXPANDER +
    //                    "//button/div[text()[contains(.,'" + day + "')]]"));
    //        }
    //    }

    private UIElement getHoursMinutes(final String hoursMinutes) {
        return root().find(By.xpath(HOURS_MINUTES_LIST +
                "//span[text()[contains(.,'" + hoursMinutes + "')]]"));
    }

    private UIElement titleHours() {
        return root().find(TITLE_HOURS);
    }

    private UIElement titleMinutes() {
        return root().find(TITLE_MINUTES);
    }

    private UIElement titleAmPm() {
        return root().find(TITLE_AM_PM);
    }

    private UIElement amBottomSwitcher() {
        return root().find(AM_BOTTOM_SWITCHER);
    }

    private UIElement pmBottomSwitcher() {
        return root().find(PM_BOTTOM_SWITCHER);
    }

    private UIElement amTitleSwitcher() {
        return root().find(AM_TITLE_SWITCHER);
    }

    private UIElement pmTitleSwitcher() {
        return root().find(PM_TITLE_SWITCHER);
    }

    private UIElement colorField() {
        return root().find(COLOR_FIELD);
    }

    @JDIAction("Switch time to AM")
    public void switchToAM() {
        amBottomSwitcher().click();
    }

    @JDIAction("Switch time to PM")
    public void switchToPM() {
        pmBottomSwitcher().click();
    }

    @JDIAction("Switch time to title AM")
    public void switchToTitleAM() {
        amTitleSwitcher().click();
    }

    @JDIAction("Switch time to title AM")
    public void switchToTitlePM() {
        pmTitleSwitcher().click();
    }

    @JDIAction("Select hours or minutes")
    public void selectHoursOrMinutes(final String hoursMinutes) {
        getHoursMinutes(hoursMinutes).click();
    }


    @JDIAction("Get hours shown in title")
    public String getHours() {
        return titleHours().getText();
    }

    @JDIAction("Get minutes shown in title")
    public String getMinutes() {
        return titleMinutes().getText();
    }

    @JDIAction("Get time shown in title")
    public String getTime() {
        return (titleHours().getText() + ":" + titleMinutes().getText());
    }

    @JDIAction("Get am/pm status shown in title")
    public String getAmPm() {
        return titleAmPm().getText();
    }

    @JDIAction("Get color from color field")
    public String getColor() {
        return Color.fromString(colorField().css("background-color")).asHex();
    }

}

