package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.vuetify.annotations.JDatePickerMonth;
import com.epam.jdi.light.vuetify.asserts.DatePickerMonthAssert;
import com.epam.jdi.light.elements.interfaces.base.HasColor;
import com.epam.jdi.light.vuetify.interfaces.HasElevation;
import com.epam.jdi.light.vuetify.interfaces.HasMeasurement;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;
import org.openqa.selenium.By;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * To see an example of Date pickers - month please visit https://v2.vuetifyjs.com/en/components/date-pickers-month/
 */
// @todo #5361 expandedRootLocator should be removed from this class,
//  input with date value is a different component, not this one
public class DatePickerMonth extends UIBaseElement<DatePickerMonthAssert> implements ISetup, HasMeasurement, HasColor,
        HasTheme, HasElevation {
    private String root;
    private String expandedRoot;
    private static final String EXPANDER = "div.v-input__slot div.v-text-field__slot";
    private static final String NEXT_YEAR = "//div[@class='v-date-picker-header__value']"
            + "/following-sibling::button";
    private static final String PREVIOUS_YEAR = "//div[@class='v-date-picker-header__value']"
            + "/preceding-sibling::button";
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
    private static final String RESULT_DATE_WITH_EXPANDER = "//input";

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

    protected UIElement getYear(final Integer year) {
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

    private UIElement resultDateField() {
        if (expander().isExist()) {
            return root().find(RESULT_DATE_WITH_EXPANDER);
        } else {
            return null;
        }
    }

    protected List<UIElement> allMonths() {
        return root().finds(By.xpath(MONTH_LIST_WITHOUT_EXPANDER + "//button/div"));
    }

    @JDIAction("Expand '{name}'")
    public void expand() {
        expander().click();
    }

    @JDIAction("Select '{name}' month")
    public void selectMonth(final String month) {
        getMonth(month).click();
    }

    @JDIAction("Click '{name}' next year")
    public void nextYear() {
        nextYearButton().click();
    }

    @JDIAction("Click '{name}' previous year")
    public void previousYear() {
        previousYearButton().click();
    }

    @JDIAction("Click '{name}' change year button")
    public void changeYear() {
        changeYearButton().click();
    }

    @JDIAction("Click '{name}' small change year button in upper left corner")
    public void changeYearCornerButton() {
        changeYearSmallButton().click();
    }

    @JDIAction("Select '{name}' year")
    public void selectYear(final int year) {
        getYear(year).click();
    }

    @JDIAction("Get '{name}' next year icon class")
    public String getNextYearIconClass() {
        return nextYearIcon().attr("class");
    }

    @JDIAction("Get '{name}' previous year icon class")
    public String getPreviousYearIconClass() {
        return previousYearIcon().attr("class");
    }

    @JDIAction("Get '{name}' additional year icon class")
    public UIElement getAdditionalYearIcon() {
        return additionalYearIcon();
    }

    @JDIAction("Get '{name}' additional year icon class")
    public String getAdditionalYearIconClass() {
        return additionalYearIcon().attr("class");
    }

    @Override
    @JDIAction("Get '{name}' color")
    public String color() {
        return root().css("color");
    }

    @Override
    @JDIAction("Get '{name}' color field background color")
    public String backgroundColor() {
        return colorField().css("background-color");
    }

    @JDIAction("Get '{name}' shown year")
    public Integer getYear() {
        return Integer.parseInt(yearField().getText());
    }

    @JDIAction("Get '{name}' shown month")
    public String getMonth() {
        return monthField().getText();
    }

    @JDIAction("Get '{name}' list of disabled months")
    public List<String> getDisabledMonths() {
        return disabledMonths().stream().map(elem
                -> elem.getText().toLowerCase()).collect(Collectors.toList());
    }

    @JDIAction("Get '{name}' list of enabled months")
    public List<String> getEnabledMonths() {
        return enabledMonths().stream().map(elem
                -> elem.getText().toLowerCase()).collect(Collectors.toList());
    }

    @JDIAction("Get '{name}' list of enabled month elements")
    public List<UIElement> getEnabledMonthElements() {
        return enabledMonths();
    }

    @JDIAction("Get '{name}' list of disabled month elements")
    public List<UIElement> getDisabledMonthElements() {
        return disabledMonths();
    }

    @JDIAction("Get '{name}' all active months")
    public List<String> getAllActiveMonths() {
        return allActiveMonths().stream().map(elem -> elem.getText().charAt(0)
                + elem.getText().substring(1).toLowerCase()).collect(Collectors.toList());
    }

    @Override
    @JDIAction("Get '{name}' width")
    public int width() {
        return root().getSize().getWidth();
    }

    @Override
    @JDIAction("Get '{name}' height")
    public int height() {
        return root().getSize().getHeight();
    }

    @JDIAction("Get '{name}' result date from date field")
    public String getResultDate() {
        return resultDateField().getText();
    }

    @JDIAction("Get '{name}' month field element")
    public UIElement getMonthField() {
        return monthField();
    }

    @JDIAction("Get '{name}' color field width")
    public int getColorFieldWidth() {
        return colorField().getSize().getWidth();
    }

    @JDIAction("Get '{name}' color field height")
    public int getColorFieldHeight() {
        return colorField().getSize().getHeight();
    }

    @JDIAction("Get '{name}' all months")
    public List<String> getAllMonths() {
        return allMonths().stream().map(elem
                -> elem.getText().charAt(0) + elem.getText().substring(1).toLowerCase()).collect(Collectors.toList());
    }

    @JDIAction("Hover '{name}' month")
    public void hoverMonth(String month) {
        getMonth(month).hover();
    }

    @Override
    @JDIAction("Get '{name}' theme")
    public String theme() {
        return root().classLike("theme--");
    }

    @Override
    @JDIAction("Get if '{name}' is elevated")
    public boolean isElevated() {
        return root().attr("class").matches(String.format(".*%s.*", ELEVATION_PATTERN));
    }

    @Override
    @JDIAction("Get '{name}' elevation")
    public String elevation() {
        return root().classes().stream()
                .filter(cls -> cls.matches(ELEVATION_PATTERN))
                .map(value -> value.split("-")[1])
                .findFirst()
                .orElse("");
    }

    public DatePickerMonthAssert is() {
        return new DatePickerMonthAssert().set(this);
    }
}
