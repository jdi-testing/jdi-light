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
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
    // @todo #5311 Change locator to do no use any texts, they are depends one locale
    private static final String NEXT_MONTH = "button[aria-label='Next month']";
    private static final String PREVIOUS_MONTH = "button[aria-label='Previous month']";
    private static final String DAY_LIST_WITHOUT_EXPANDER =
            "//div[@class='v-date-picker-table v-date-picker-table--date theme--light']/table";
    private static final String MAIN_FIELD =
            "//div[@class='v-picker__title__btn v-date-picker-title__date v-picker__title__btn--active']/div";
    private static final String MONTH_YEAR_FIELD = "//div[@class='v-date-picker-header__value']//button";
    private static final String ACTIVE_DAY_OF_MONTH = "//table/tbody//button[contains(@class, 'active')]";
    private static final String MONTH_LIST_WITHOUT_EXPANDER =
            "//div[@class='v-date-picker-table v-date-picker-table--month theme--light']/table";
    private static final String YEAR = "//div[@class='v-date-picker-header__value']/div/button";
    private static final String YEAR_LIST = "//ul";
    private static final String YEAR_SMALL = "//div[@class='v-date-picker-title']/div";
    private static final String RESULT_DATE_WITH_EXPANDER = "//input";
    private static final String ACTIVE_PICKER_CODE = "//code";
    private static final String INPUT_FIELD = "//div[@class='v-input__slot']/div/input";
    private static final String ICON_NEAR_DATE = "//div[@class='v-input__prepend-outer']/div";
    private static final String FORMATTED_DATE = "//p/strong";
    private static final String TITLE_FIELD = ".v-picker__title";
    private static final String BODY_FIELD = ".v-picker__body";
    private static final String DISABLED_DATES = "table > tbody button:disabled";
    private static final String ENABLED_DATES = "table > tbody button:enabled";
    private static final String NEXT_MONTH_ICON =
            "//div[@class='v-date-picker-header theme--light']/button[2]/span/*";
    private static final String PREVIOUS_MONTH_ICON =
            "//div[@class='v-date-picker-header theme--light']/button[1]/span/*";
    private static final String ADDITIONAL_YEAR_ICON =
            "div.v-picker__title__btn.v-date-picker-title__year i:only-child";
    private static final String SHOWN_MULTIPLE_DATES = "//div[@class='v-select__selections']/span/span";
    private static final String OUTLINED_DATE = "//button[contains(@class, 'outlined theme')]";
    private static final String EVENT_COLOR_CIRCLE = "table > tbody button > div.v-date-picker-table__events > div";
    private static final String CLEAR_BUTTON = "//button[@aria-label = 'clear icon']";

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

    private UIElement nextMonthButton() {
        if (expander().isExist()) {
            return expandedRoot().find(NEXT_MONTH);
        } else {
            return root().find(NEXT_MONTH);
        }
    }

    private UIElement previousMonthButton() {
        if (expander().isExist()) {
            return expandedRoot().find(PREVIOUS_MONTH);
        } else {
            return root().find(PREVIOUS_MONTH);
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
        if (expander().isExist()) {
            return expandedRoot().find(MAIN_FIELD);
        } else {
            return root().find(MAIN_FIELD);
        }
    }

    private UIElement monthYearField() {
        if (expander().isExist()) {
            return expandedRoot().find(MONTH_YEAR_FIELD);
        } else {
            return root().find(MONTH_YEAR_FIELD);
        }
    }

    private UIElement activeDayOfMonth() {
        if (expander().isExist()) {
            return expandedRoot().find(ACTIVE_DAY_OF_MONTH);
        } else {
            return root().find(ACTIVE_DAY_OF_MONTH);
        }
    }

    @JDIAction("Get access to change month button of {name}")
    public UIElement changeMonthButton() {
        if (expander().isExist()) {
            return expandedRoot().find(MONTH_YEAR_FIELD);
        } else {
            return root().find(MONTH_YEAR_FIELD);
        }
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

    private UIElement activePickerCode() {
        if (expander().isExist()) {
            return root().find(ACTIVE_PICKER_CODE);
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

    private UIElement formattedDate() {
        return root().find(FORMATTED_DATE);
    }

    private UIElement changeYearSmallButton() {
        if (expander().isExist()) {
            return expandedRoot().find(YEAR_SMALL);
        } else {
            return root().find(YEAR_SMALL);
        }
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

    private UIElement nextMonthIcon() {
        return root().find(NEXT_MONTH_ICON);
    }

    private UIElement previousMonthIcon() {
        return root().find(PREVIOUS_MONTH_ICON);
    }

    private UIElement additionalYearIcon() {
        return root().find(ADDITIONAL_YEAR_ICON);
    }

    private List<UIElement> allActiveDates() {
        if (expander().isExist()) {
            return expandedRoot().finds(ACTIVE_DAY_OF_MONTH);
        } else {
            return root().finds(ACTIVE_DAY_OF_MONTH);
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
        nextMonthButton().click();
    }

    @JDIAction("Click '{name}' previous month button")
    public void toPreviousMonth() {
        previousMonthButton().click();
    }

    @JDIAction("Select '{name}' day of month")
    public void selectDay(final String date) {
        getDay(date).click();
    }

    @JDIAction("Get '{name}' shown month and year")
    public String getMonthAndYear() {
        return monthYearField().getText();
    }

    @JDIAction("Get '{name}' shown month")
    public String getMonth() {
        return getMonthAndYear().substring(0, getMonthAndYear().indexOf(" "));
    }

    @JDIAction("Get '{name}' shown month based on locale '{0}'")
    public String getMonth(Locale locale) {
        if (locale.equals(Locale.CHINESE)) {
            Pattern monthPattern = Pattern.compile("([\\d]+)([\\u4E00-\\u9FA5]+)([\\d]+)([\\u4E00-\\u9FA5]+)");
            Matcher matcher = monthPattern.matcher(getMonthAndYear());
            String matcherResult = StringUtils.EMPTY;
            while (matcher.find()) {
                matcherResult = matcher.group(3) + matcher.group(4);
            }
            return matcherResult;
        } else {
            return getMonthAndYear().substring(0, getMonthAndYear().indexOf(" "));
        }
    }

    @JDIAction("Get '{name}' shown year")
    public String getYear() {
        return getMonthAndYear().substring(getMonthAndYear().indexOf(" ") + 1);
    }

    @JDIAction("Get '{name}' shown year based on locale '{0}'")
    public String getYear(Locale locale) {
        if (locale.equals(Locale.CHINESE)) {
            Pattern yearPattern = Pattern.compile("([\\d]{4})[\\u4E00-\\u9FA5]");
            Matcher matcher = yearPattern.matcher(getMonthAndYear());
            String matcherResult = StringUtils.EMPTY;
            while (matcher.find()) {
                matcherResult = matcher.group(0);
            }
            return matcherResult;
        }
        return getMonthAndYear().substring(getMonthAndYear().indexOf(" ") + 1);
    }

    @JDIAction("Get '{name}' shown date")
    public String getDate() {
        return mainDateField().getText();
    }

    @JDIAction("Get '{name}' shown day of month")
    public String getDayOfMonth() {
        Pattern dayPattern = Pattern.compile("\\d+");
        Matcher matcher = dayPattern.matcher(getDate());
        String matcherResult = StringUtils.EMPTY;
        while (matcher.find()) {
            matcherResult = matcher.group();
        }
        return matcherResult;
    }

    @JDIAction("Get '{name}' shown day of month based on locale '{0}'")
    public String getDayOfMonth(Locale locale) {
        if (locale.equals(Locale.CHINESE)) {
            Pattern dayPattern = Pattern.compile("([\\d]+)([\\u4E00-\\u9FA5])(\\d+)([\\u4E00-\\u9FA5])");
            Matcher matcher = dayPattern.matcher(getDate());
            String matcherResult = StringUtils.EMPTY;
            while (matcher.find()) {
                matcherResult = matcher.group(3);
            }
            return matcherResult;
        } else {
            Pattern dayPattern = Pattern.compile("\\d+");
            Matcher matcher = dayPattern.matcher(getDate());
            String matcherResult = StringUtils.EMPTY;
            while (matcher.find()) {
                matcherResult = matcher.group();
            }
            return matcherResult;
        }
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

    @JDIAction("Get '{name}' result date in the field")
    public String getResultDate() {
        return resultDateField().getText();
    }

    @JDIAction("Get '{name}' code for active date picker")
    public String getCode() {
        return activePickerCode().getText();
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

    @JDIAction("Get '{name}' ISO formatted date")
    public String getFormattedDate() {
        return formattedDate().getText();
    }

    @JDIAction("Get '{name}' readonly attribute of date field")
    public String getDateFieldReadonlyAttribute() {
        return inputField().attr("readonly");
    }

    @JDIAction("Click '{name}' small change year button in the upper left corner")
    public void changeYearCornerButton() {
        changeYearSmallButton().click();
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

    @JDIAction("Get '{name}' class of next month icon")
    public String getNextMonthIconClass() {
        return nextMonthIcon().attr("class");
    }

    @JDIAction("Get '{name}' class of previous month icon")
    public String getPreviousMonthIconClass() {
        return previousMonthIcon().attr("class");
    }

    @JDIAction("Get '{name}' additional year icon element")
    public UIElement getAdditionalYearIcon() {
        return additionalYearIcon();
    }

    @JDIAction("Get all '{name}' active days of month")
    public List<String> getAllActiveDaysOfMonth() {
        return allActiveDates().stream().map(elem
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
