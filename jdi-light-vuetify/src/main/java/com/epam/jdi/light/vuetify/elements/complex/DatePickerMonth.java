package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.vuetify.annotations.JDatePickerMonth;
import com.epam.jdi.light.vuetify.asserts.DatePickerMonthAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class DatePickerMonth extends UIBaseElement<DatePickerMonthAssert> implements ISetup {
    private String root;
    private String expandedRoot;
    private static final String EXPANDER = "div.v-input__slot div.v-text-field__slot";
    private static final String NEXT_YEAR = "button[aria-label='Next year']";
    private static final String PREVIOUS_YEAR = "button[aria-label='Previous year']";
    private static final String MONTH_LIST_WITHOUT_EXPANDER =
            "//div[@class='v-date-picker-table v-date-picker-table--month theme--light']/table";
    private static final String YEAR = "//div[@class='v-date-picker-header__value']/div/button";
    private static final String YEAR_LIST = "//ul";
    private static final String YEAR_SMALL = "//div[@class='v-date-picker-title']/div";
    private static final String NEXT_YEAR_ICON =
            "//div[@class='v-date-picker-header theme--light']/button[2]/span/*";
    private static final String PREVIOUS_YEAR_ICON =
            "//div[@class='v-date-picker-header theme--light']/button[1]/span/*";
    private static final String ADDITIONAL_YEAR_ICON =
            "div.v-picker__title__btn.v-date-picker-title__year i:only-child";
    private static final String COLOR_FIELD = "//div[contains(@class, 'v-picker__title')]";
    private static final String YEAR_FIELD = "//div[@class='v-date-picker-header__value']//button";
    private static final String MONTH_FIELD =
            "//div[@class='v-picker__title__btn v-date-picker-title__date v-picker__title__btn--active']/div";
    private static final String DISABLED_MONTHS = "table > tbody button:disabled";
    private static final String ENABLED_MONTHS = "table > tbody button:enabled";
    private static final String ACTIVE_MONTH = "//table/tbody//button[contains(@class, 'active')]";
    private static final String OUTLINED_MONTH = "//button[contains(@class, 'outlined theme')]";
    private static final String RESULT_DATE_WITH_EXPANDER = "//input";
    private static final String CANCEL = "//div[@class='v-picker v-card v-picker--date theme--light']" +
            "//span[text()[contains(.,'Cancel')]]";
    private static final String OK = "//div[@class='v-picker v-card v-picker--date theme--light']" +
            "//span[text()[contains(.,'OK')]]";
    private static final String ORIENTATION_SWITCHER =
            "//div[contains(@class, 'v-input--selection-controls__ripple')]";

    /**
     * To see an example of Date pickers - month please visit https://vuetifyjs.com/en/components/date-pickers-month/
     */

    @Override
    public void setup(Field field) {
        if (!fieldHasAnnotation(field, JDatePickerMonth.class, DatePickerMonth.class)) {
            return;
        }
        JDatePickerMonth j = field.getAnnotation(JDatePickerMonth.class);
        setup(j.root(), j.expandedRoot());
    }

    public DatePickerMonth setup(String rootLocator, String expandedRootLocator) {
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

    protected UIElement getMonth(final String month) {
        if (expander().isExist()) {
            return expandedRoot().find(By.xpath("//button/div[text()='" + month + "']"));
        }
        return root().find(By.xpath(MONTH_LIST_WITHOUT_EXPANDER + "//button/div[text()='" + month + "']"));
    }

    private UIElement nextYearButton() {
        if (expander().isExist()) {
            return expandedRoot().find(NEXT_YEAR);
        } else {
            return root().find(NEXT_YEAR);
        }
    }

    private UIElement previousYearButton() {
        if (expander().isExist()) {
            return expandedRoot().find(PREVIOUS_YEAR);
        } else {
            return root().find(PREVIOUS_YEAR);
        }
    }

    private UIElement changeYearButton() {
        if (expander().isExist()) {
            return expandedRoot().find(YEAR);
        } else {
            return root().find(YEAR);
        }
    }

    private UIElement changeYearSmallButton() {
        if (expander().isExist()) {
            return expandedRoot().find(YEAR_SMALL);
        } else {
            return root().find(YEAR_SMALL);
        }
    }

    protected UIElement getYear(final String year) {
        if (expander().isExist()) {
            return expandedRoot().find(By.xpath(YEAR_LIST + "/li[text()='" + year + "']"));
        } else {
            return root().find(By.xpath(YEAR_LIST + "/li[text()[contains(.,'" + year + "')]]"));
        }
    }

    private UIElement nextYearIcon() {
        return root().find(NEXT_YEAR_ICON);
    }

    private UIElement previousYearIcon() {
        return root().find(PREVIOUS_YEAR_ICON);
    }

    private UIElement additionalYearIcon() {
        return root().find(ADDITIONAL_YEAR_ICON);
    }

    private UIElement colorField() {
        return root().find(COLOR_FIELD);
    }

    private UIElement yearField() {
        if (expander().isExist()) {
            return expandedRoot().find(YEAR_FIELD);
        } else {
            return root().find(YEAR_FIELD);
        }
    }

    private UIElement monthField() {
        if (expander().isExist()) {
            return expandedRoot().find(MONTH_FIELD);
        } else {
            return root().find(MONTH_FIELD);
        }
    }

    private List<UIElement> disabledMonths() {
        return root().finds(DISABLED_MONTHS);
    }

    private List<UIElement> enabledMonths() {
        return root().finds(ENABLED_MONTHS);
    }

    private List<UIElement> allActiveMonths() {
        if (expander().isExist()) {
            return expandedRoot().finds(ACTIVE_MONTH);
        } else {
            return root().finds(ACTIVE_MONTH);
        }
    }

    private UIElement outlinedMonth() {
        return root().find(OUTLINED_MONTH);
    }

    private UIElement resultDateField() {
        if (expander().isExist()) {
            return root().find(RESULT_DATE_WITH_EXPANDER);
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

    protected List<UIElement> allMonths() {
        return root().finds(By.xpath(MONTH_LIST_WITHOUT_EXPANDER + "//button/div"));
    }

    private UIElement orientationSwitcher() {
        return root().find(ORIENTATION_SWITCHER);
    }

    @JDIAction("Expand '{name}'")
    public void expand() {
        expander().click();
    }

    @JDIAction("Select month")
    public void selectMonth(final String month) {
        getMonth(month).click();
    }

    @JDIAction("Click next year")
    public void nextYear() {
        nextYearButton().click();
    }

    @JDIAction("Click previous year")
    public void previousYear() {
        previousYearButton().click();
    }

    @JDIAction("Click change year button")
    public void changeYear() {
        changeYearButton().click();
    }

    @JDIAction("Click small change year button in upper left corner")
    public void changeYearCornerButton() {
        changeYearSmallButton().click();
    }

    @JDIAction("Select year")
    public void selectYear(final String year) {
        getYear(year).click();
    }

    @JDIAction("Get class of next year icon")
    public String getNextYearIconClass() {
        return nextYearIcon().attr("class");
    }

    @JDIAction("Get class of previous year icon")
    public String getPreviousYearIconClass() {
        return previousYearIcon().attr("class");
    }

    @JDIAction("Get class of additional year icon")
    public UIElement getAdditionalYearIcon() {
        return additionalYearIcon();
    }

    @JDIAction("Get color from color field of the picker")
    public String getColor() {
        return Color.fromString(colorField().css("background-color")).asHex();
    }

    @JDIAction("Get shown year")
    public String getYear() {
        return yearField().getText();
    }

    @JDIAction("Get shown month")
    public String getMonth() {
        return monthField().getText();
    }

    @JDIAction("Get list of disabled months")
    public List<String> getDisabledMonths() {
        return disabledMonths().stream().map(elem
                -> elem.getText().toLowerCase()).collect(Collectors.toList());
    }

    @JDIAction("Get list of enabled months")
    public List<String> getEnabledMonths() {
        return enabledMonths().stream().map(elem
                -> elem.getText().toLowerCase()).collect(Collectors.toList());
    }

    @JDIAction("Get list of enabled month elements")
    public List<UIElement> getEnabledMonthElements() {
        return enabledMonths();
    }

    @JDIAction("Get list of disabled month elements")
    public List<UIElement> getDisabledMonthElements() {
        return disabledMonths();
    }

    @JDIAction("Get all active months")
    public List<String> getAllActiveMonths() {
        return allActiveMonths().stream().map(elem -> elem.getText().substring(0, 1) +
                elem.getText().substring(1).toLowerCase()).collect(Collectors.toList());
    }

    @JDIAction("Get border of outlined month")
    public String getOutlinedMonthBorder() {
        return outlinedMonth().css("border");
    }

    @JDIAction("Get width of the whole picker")
    public int getPickerWidth() {
        return root().getSize().getWidth();
    }

    @JDIAction("Get result date in the field")
    public String getResultDate() {
        return resultDateField().getText();
    }

    @JDIAction("Click Cancel button")
    public void clickCancel() {
        cancelButton().click();
    }

    @JDIAction("Click OK button")
    public void clickOk() {
        okButton().click();
    }

    @JDIAction("Get month field element")
    public UIElement getMonthField() {
        return monthField();
    }

    @JDIAction("Switch picker orientation using Landscape checkbox")
    public void switchOrientation() {
        orientationSwitcher().click();
    }

    @JDIAction("Get width of color field")
    public int getColorFieldWidth() {
        return colorField().getSize().getWidth();
    }

    @JDIAction("Get height of color field")
    public int getColorFieldHeight() {
        return colorField().getSize().getHeight();
    }

    @JDIAction("Get all months")
    public List<String> getAllMonths() {
        return allMonths().stream().map(elem
                -> elem.getText().substring(0, 1) + elem.getText().substring(1).toLowerCase()).collect(Collectors.toList());
    }

    @JDIAction("Hover month")
    public void hoverMonth(final String month) {
        getMonth(month).hover();
    }

    public DatePickerMonthAssert is() {
        return new DatePickerMonthAssert().set(this);
    }

    public DatePickerMonthAssert has() {
        return this.is();
    }
}
