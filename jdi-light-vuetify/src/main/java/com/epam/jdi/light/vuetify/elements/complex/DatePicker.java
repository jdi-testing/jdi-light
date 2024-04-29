package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.interfaces.base.HasColor;
import com.epam.jdi.light.vuetify.annotations.JDatePicker;
import com.epam.jdi.light.vuetify.asserts.DatePickerAssert;
import com.epam.jdi.light.vuetify.interfaces.HasElevation;
import com.epam.jdi.light.vuetify.interfaces.HasMeasurement;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * To see an example of Date pickers please visit https://v2.vuetifyjs.com/en/components/date-pickers/
 */
// @todo #5311 Class should be refactored to remove as much as possible get*** methods
public class DatePicker extends UIBaseElement<DatePickerAssert> implements
        ISetup, HasElevation, HasMeasurement, HasTheme, HasColor {
    private String root;
    private String expandedRoot;
    private static final String EXPANDER = "div.v-input__slot div.v-text-field__slot";
    private static final String EXPANDER_MULTIPLE = "div.v-input__control label";
    private static final String NEXT_MONTH = "button[aria-label='Next month']";
    private static final String PREVIOUS_MONTH = "button[aria-label='Previous month']";
    private static final String DAY_LIST_WITHOUT_EXPANDER =
            ".//div[contains(@class, 'v-date-picker-table')]/table";
    private static final String MAIN_FIELD =
            ".//div[contains(@class, 'v-date-picker-title__date')]";
    private static final String MONTH_YEAR_FIELD = "//div[@class='v-date-picker-header__value']//button";
    private static final String ACTIVE_DAY_OF_MONTH = ".//table/tbody//button[contains(@class, 'v-btn--active')]";
    private static final String MONTH_LIST_WITHOUT_EXPANDER =
            ".//div[contains(@class,'v-date-picker-table--month')]/table";
    private static final String YEAR = ".v-date-picker-title__year";
    private static final String YEAR_LIST = "//ul";
    private static final String RESULT_DATE_WITH_EXPANDER = "//input";
    private static final String INPUT_FIELD = "//div[@class='v-input__slot']/div/input";
    private static final String ICON_NEAR_DATE = "//div[contains(@class, 'v-input__prepend-outer')]/div";
    private static final String TITLE_FIELD = ".v-picker__title";
    private static final String BODY_FIELD = ".v-picker__body";
    private static final String DISABLED_DATES = "table > tbody button:disabled";
    private static final String ENABLED_DATES = "table > tbody button:enabled";
    private static final String SHOWN_MULTIPLE_DATES = ".//div[@class='v-select__selections']/span/span";
    private static final String EVENT_COLOR_CIRCLE = ".v-date-picker-table__events > div";
    private static final String CLEAR_BUTTON = ".//button[@aria-label = 'clear icon']";

    @Override
    public void setup(Field field) {
        if (!fieldHasAnnotation(field, JDatePicker.class, DatePicker.class)) {
            return;
        }
        JDatePicker j = field.getAnnotation(JDatePicker.class);
        setup(j.root(), j.expandedRoot());
    }

    public DatePicker setup(String rootLocator, String expandedRootLocator) {
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
        if (root().find(EXPANDER).isExist()) {
            return root().find(EXPANDER);
        } else {
            return root().find(EXPANDER_MULTIPLE);
        }
    }

    protected UIElement getDay(final String day) {
        if (expander().isExist()) {
            return expandedRoot().find(By.xpath("//button/div[text()='" + day + "']"));
        } else {
            return root().find(By.xpath(DAY_LIST_WITHOUT_EXPANDER +
                    "//button/div[text()[contains(.,'" + day + "')]]"));
        }
    }

    private UIElement mainDateField() {
        return getInnerElement(MAIN_FIELD);
    }

    private UIElement monthYearField() {
        return getInnerElement(MONTH_YEAR_FIELD);
    }

    private UIElement activeDayOfMonth() {
        return getInnerElement(ACTIVE_DAY_OF_MONTH);
    }

    @JDIAction("Get access to change month button of {name}")
    public UIElement changeMonthButton() {
        return getInnerElement(MONTH_YEAR_FIELD);
    }

    protected UIElement getMonth(String month) {
        if (expander().isExist()) {
            return expandedRoot().find(By.xpath("//button/div[text()='" + month + "']"));
        }
        return root().find(By.xpath(MONTH_LIST_WITHOUT_EXPANDER + "//button/div[text()='" + month + "']"));
    }

    private UIElement changeYearButton() {
        if (expander().isExist()) {
            return expandedRoot().find(YEAR);
        } else {
            return root().find(YEAR);
        }
    }

    protected UIElement getYear(final String year) {
        if (expander().isExist()) {
            return expandedRoot().find(By.xpath(YEAR_LIST + "/li[text()='" + year + "']"));
        } else {
            return root().find(By.xpath(YEAR_LIST + "/li[text()[contains(.,'" + year + "')]]"));
        }
    }

    private UIElement resultDateField() {
        if (expander().isExist()) {
            return root().find(RESULT_DATE_WITH_EXPANDER);
        } else {
            return null;
        }
    }

    private UIElement inputField() {
        return root().find(INPUT_FIELD);
    }

    private UIElement iconNearDate() {
        return root().find(ICON_NEAR_DATE);
    }

    @JDIAction("Get {name}'s title with year, month and date")
    public UIElement titleField() {
        return root().find(TITLE_FIELD);
    }

    private List<UIElement> disabledDates() {
        return root().finds(DISABLED_DATES);
    }

    private List<UIElement> enabledDates() {
        return root().finds(ENABLED_DATES);
    }

    private List<UIElement> getInnerElements(String locator) {
        if (expander().isExist()) {
            return expandedRoot().finds(locator);
        } else {
            return root().finds(locator);
        }
    }

    private UIElement getInnerElement(String locator) {
        if (expander().isExist()) {
            return expandedRoot().find(locator);
        } else {
            return root().find(locator);
        }
    }

    private List<UIElement> shownMultipleDates() {
        return root().finds(SHOWN_MULTIPLE_DATES);
    }

    private List<UIElement> eventColorCircles() {
        return root().finds(EVENT_COLOR_CIRCLE);
    }

    protected List<UIElement> allMonths() {
        return root().finds(By.xpath(MONTH_LIST_WITHOUT_EXPANDER + "//button/div"));
    }

    private UIElement expandedField() {
        return root().find("div");
    }

    private UIElement clearButton() {
        return root().find(CLEAR_BUTTON);
    }

    @JDIAction("Expand '{name}'")
    public void expand() {
        if (expander().isExist()) {
            expander().click();
        }
    }

    @JDIAction("Click '{name}' next month button")
    public void toNextMonth() {
        getInnerElement(NEXT_MONTH).click();
    }

    @JDIAction("Click '{name}' previous month button")
    public void toPreviousMonth() {
        getInnerElement(PREVIOUS_MONTH).click();
    }

    @JDIAction("Click on '{name}' day of month")
    public void clickDay(final String date) {
        getDay(date).click();
        waitFor(1);
    }

    @JDIAction("Get '{name}' shown month and year")
    public String getMonthAndYear() {
        return monthYearField().getText();
    }

    @JDIAction("Get '{name}' shown date")
    public String getDate() {
        return mainDateField().getText();
    }

    @JDIAction("Get '{name}' active day of month")
    public String getActiveDayOfMonth() {
        return activeDayOfMonth().getText();
    }

    @JDIAction("Click '{name}' change month button")
    public void changeMonth() {
        changeMonthButton().click();
    }

    @JDIAction("Select '{name}' month '{0}'")
    public void selectMonth(String month) {
        getMonth(month).click();
    }

    @JDIAction("Click '{name}' change year button")
    public void changeYear() {
        changeYearButton().click();
    }

    @JDIAction("Select '{name}' year")
    public void selectYear(final String year) {
        getYear(year).click();
    }

    public String year() {
        return getInnerElement(YEAR).text();
    }

    @JDIAction("Get '{name}' result date in the field")
    public String getResultDate() {
        return resultDateField().getText();
    }

    @JDIAction("Get '{name}' clear button")
    public UIElement getClearButton() {
        return clearButton();
    }

    @JDIAction("Clear '{name}' date input field")
    public void clear() {
        if (getClearButton().isExist()) {
            getClearButton().click();
        } else {
            for (int i = 0; i < 11; i++) {
                inputField().sendKeys(Keys.BACK_SPACE);
            }
        }
    }

    @JDIAction("Set '{name}' value '{0}' in date input field")
    public void setDate(final String date) {
        inputField().setValue(date);
        iconNearDate().click();
    }

    @JDIAction("Get '{name}' readonly attribute of date field")
    public String getDateFieldReadonlyAttribute() {
        return inputField().attr("readonly");
    }

    @JDIAction("Get '{name}' small change year button in the upper left corner")
    public UIElement changeYearCornerButton() {
        return getInnerElement(YEAR);
    }

    @Override
    @JDIAction("Get '{name}' color from title")
    public String color() {
        return titleField().css("background-color");
    }

    @Override
    @JDIAction("Get '{name}' color from body")
    public String backgroundColor() {
        return core().find(BODY_FIELD).css("background-color");
    }

    @JDIAction("Get '{name}' list of disabled dates")
    public List<String> getDisabledDates() {
        return disabledDates().stream().map(elem
                -> elem.getText().toLowerCase()).collect(Collectors.toList());
    }

    @JDIAction("Get '{name}' list of enabled dates")
    public List<String> getEnabledDates() {
        return enabledDates().stream().map(elem
                -> elem.getText().toLowerCase()).collect(Collectors.toList());
    }

    @JDIAction("Get '{name}' list of enabled dates elements")
    public List<UIElement> getEnabledDatesElements() {
        return enabledDates();
    }

    @JDIAction("Get '{name}' list of disabled dates elements")
    public List<UIElement> getDisabledDatesElements() {
        return disabledDates();
    }

    @JDIAction("Get all '{name}' active days of month")
    public List<String> getAllActiveDaysOfMonth() {
        return getInnerElements(ACTIVE_DAY_OF_MONTH).stream().map(elem
                -> elem.getText()).collect(Collectors.toList());
    }

    @JDIAction("Get '{name}' shown multiple dates")
    public List<String> getShownMultipleDates() {
        return shownMultipleDates().stream().map(elem
                -> elem.getText().toLowerCase()).collect(Collectors.toList());
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

    @JDIAction("Double click on '{name}' day of month")
    public void doubleClickDay(final String date) {
        getDay(date).doubleClick();
    }

    @JDIAction("Hover '{name}' month")
    public void hoverMonth(final String month) {
        getMonth(month).hover();
    }

    @JDIAction("Right click '{name}' year")
    public void rightClickYear(final String year) {
        getYear(year).rightClick();
    }

    @JDIAction("Get '{name}' list of colors for all event dates")
    public List<String> getEventCirclesColor() {
        return eventColorCircles().stream().map(elem -> elem.css("background-color"))
                .collect(Collectors.toList());
    }

    @JDIAction("Get '{name}' change year button element")
    public UIElement getChangeYearButton() {
        return changeYearButton();
    }

    @JDIAction("Get '{name}' main field element")
    public UIElement getMainField() {
        return mainDateField();
    }

    @JDIAction("Get '{name}' all months")
    public List<String> getAllMonths() {
        return allMonths().stream().map(elem
                -> elem.getText()).collect(Collectors.toList());
    }

    @JDIAction("Get '{name}' expanded element")
    public UIElement getExpandedElement() {
        return expandedField();
    }

    @JDIAction("Get if '{name}' has landscape orientation")
    public boolean isLandscape() {
        return !root().classLike("v-picker--landscape", StringUtils::equals).isEmpty();
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

    @Override
    @JDIAction("Get '{name}' theme")
    public String theme() {
        return root().classLike("theme--");
    }

    public DatePickerAssert is() {
        return new DatePickerAssert().set(this);
    }
}
