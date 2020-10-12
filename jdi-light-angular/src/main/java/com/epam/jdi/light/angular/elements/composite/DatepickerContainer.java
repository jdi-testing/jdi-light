package com.epam.jdi.light.angular.elements.composite;

import com.epam.jdi.light.angular.entities.DatepickerNavigation;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Section;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;

import static com.epam.jdi.light.angular.entities.DatepickerNavigation.*;

public class DatepickerContainer extends Section {
    public static final int YEAR_LENGTH = 4;
    public static final int SPACE_CHARACTER_ASCII_CODE = 32;
    public String value = VALUE.getName();
    public String calendar = "//*[contains(@id,'mat-datepicker')][contains(@class,'mat-calendar')]";
    public String selectedMonthLocator = "//td[contains(@class,'mat-calendar-body-label')]";
    public String todayDayLocator = ".mat-calendar-body-today";
    public String selectedDayLocator = ".mat-calendar-body-selected";
    public String activeDayLocator = ".mat-calendar-body-active";
    public String columnLocator = "//*[@class='cdk-overlay-container']//tr/td[%s][@aria-label][1]";

    /**
     * Collapse calendar date select panel.
     */
    @JDIAction("Collapse element calendar")
    public void collapse() {
        UIElement calendarPanel = getCalendar();
        if (calendarPanel.isDisplayed()) {
            getCalendar().core().click(getOutsidePoint().getX(), getOutsidePoint().getY());
        }
    }

    @JDIAction("Check that element is displayed")
    @Override
    public boolean isDisplayed() {
        return getCalendar().isDisplayed();
    }

    @JDIAction("Check that element is hidden")
    @Override
    public boolean isHidden() {
        return !isDisplayed();
    }

    @JDIAction("Select '{0}' month in '{name}' with '{1}' locale")
    public void selectMonth(final int month, final Locale locale) {
        getMonth(month, locale).click();
    }

    @JDIAction("Select active month in element")
    public void selectActiveMonth() {
        getMonth(startMonth().getValue(), Locale.US).click();
    }

    /**
     * Select the active month.
     *
     * @param locale for month value
     */
    @JDIAction("Select active month in '{name}' with '{0}' locale")
    public void selectActiveMonth(final Locale locale) {
        getMonth(startMonth().getValue(), locale).click();
    }

    @JDIAction("Select element previous month")
    public void selectPreviousMonth() {
        getPreviousMonth().click();
    }

    @JDIAction("Select element next month")
    public void selectNextMonth() {
        getNextMoth().click();
    }

    /**
     * Get start month.
     *
     * @return Month value selected by the 'US' locale
     */
    @JDIAction("Get element selected month value")
    public Month selectedMonth() {
        return getSelectedMonth(Locale.US);
    }

    @JDIAction("Get element selected month value with '{0}' locale")
    public Month selectedMonth(final Locale locale) {
        return getSelectedMonth(locale);
    }

    /**
     * Get start month.
     *
     * @return Month value selected by the 'US' locale
     */
    @JDIAction("Get element start month value")
    public Month startMonth() {
        return getMonth(Locale.US);
    }

    @JDIAction("Get '{name}' start month value")
    public Month startMonth(final Locale locale) {
        return getMonth(locale);
    }

    /**
     * Select the specified day by the value.
     *
     * @param day string value
     */
    @JDIAction("Select {0} for '{name}'")
    public void selectDay(final String day) {
        getDay(day).click();
    }

    /**
     * Select the specified day by the value.
     *
     * @param day integer value
     */
    @JDIAction("Select {0} for '{name}'")
    public void selectDay(final int day) {
        getDay(day).click();
    }

    @JDIAction("Get element value of the selected day")
    public int selectedDay() {
        int selectedDay = Integer.parseInt(getSelectedDay().text().trim());
        collapse();
        return selectedDay;
    }

    @JDIAction("Get element today day value")
    public int todayDay() {
        int todayDay = Integer.parseInt(getTodayDay().text().trim());
        collapse();
        return todayDay;
    }

    @JDIAction("Get element active day value")
    public int activeDay() {
        int todayDay = Integer.parseInt(getActiveDay().text().trim());
        collapse();
        return todayDay;
    }

    @JDIAction("Get element value of the selected year")
    public Year selectedYear() {
        String selectedYear = getChosenMonthAndYear().text().trim().substring(YEAR_LENGTH);
        Year year = Year.parse(selectedYear);
        collapse();
        return year;
    }

    @JDIAction("Get element start year value")
    public Year startYear() {
        String startYear = getChosenDate().text().trim();
        Year year = Year.parse(startYear);
        collapse();
        return year;
    }

    /**
     * Select the specified date with 'US' locale as default.
     *
     * @param date string value in 'M/d/yyyy' format
     */
    @JDIAction("Select {0} for '{name}'")
    public void select(final String date) {
        selectDate(getLocalDate(date, Locale.US), Locale.US);
    }

    /**
     * Select the specified date.
     *
     * @param date   string value in 'M/d/yyyy' format
     * @param locale for selected date
     */
    @JDIAction("Select {0} for '{name}' with '{1}' locale")
    public void select(final String date, final Locale locale) {
        selectDate(getLocalDate(date, locale), locale);
    }

    /**
     * Select the specified date by the LocalDate value with 'US' locale as default.
     *
     * @param date LocalDate value
     */
    @JDIAction("Select '{0}' for '{name}'")
    public void select(final LocalDate date) {
        selectDate(date, Locale.US);
    }

    /**
     * Select the specified date by the LocalDate value.
     *
     * @param date   LocalDate value
     * @param locale for selected date
     */
    @JDIAction("Select '{0}' for '{name}' with '{1}' locale")
    public void select(final LocalDate date, final Locale locale) {
        selectDate(date, locale);
    }

    /**
     * Get selected date as LocalDate value with 'US' locale as default.
     *
     * @return LocalDate value
     */
    @JDIAction("Get '{name}' selected date value")
    public LocalDate selectedDate() {
        return getLocalDate(Locale.US);
    }

    @JDIAction("Get '{name}' selected date value by '{0}' locale")
    public LocalDate selectedDate(final Locale locale) {
        return getLocalDate(locale);
    }

    @JDIAction("Check that '{name}' has disabled elements '{0}'")
    public boolean disabled(final String... navigationElements) {
        int disabledElementsCount = 0;
        for (String element : navigationElements) {
            UIElement uiElement = new UIElement(By.xpath(element));
            if (uiElement.hasAttribute("disabled") || uiElement.attr("aria-disabled").contains("true")) {
                disabledElementsCount++;
            }
        }
        collapse();
        return disabledElementsCount == navigationElements.length;
    }

    @JDIAction("Open '{name}' years view")
    public void openYearsView() {
        getChosenMonthAndYear().click();
    }

    @JDIAction("Get '{name}' '{0}' week day numbers")
    public String[] getWeekDayNumbers(final DatepickerNavigation weekName) {
        WebList webList = getColumn(weekName.ordinal());
        String[] list = new String[webList.size()];
        webList.stream().map(e -> String.format(CELL.getName().replace("%s", " %s "), e.getValue()))
                .collect(Collectors.toList()).toArray(list);
        return list;
    }

    @JDIAction("Check that '{name}' selected locale '{0}'")
    public boolean isSelectedLocale(final Locale locale) {
        String selectedMonth = getSelectedMonth().text().trim().replace(".", "");
        boolean isLocale = !Arrays.stream(Month.values())
                .filter(m -> m.getDisplayName(TextStyle.FULL, locale).toUpperCase().contains(selectedMonth))
                .collect(Collectors.toList()).isEmpty();
        collapse();
        return isLocale;
    }

    protected UIElement getCalendar() {
        return new UIElement(By.xpath(calendar));
    }

    protected UIElement getChosenMonthAndYear() {
        return new UIElement(By.xpath(CHOOSE_MONTH_AND_YEAR.getName()));
    }

    protected UIElement getChosenDate() {
        return new UIElement(By.xpath(CHOOSE_DATE.getName()));
    }

    protected UIElement getSelectedMonth() {
        return new WebList(By.xpath(selectedMonthLocator)).get(1);
    }

    protected UIElement getTodayDay() {
        return new UIElement(By.cssSelector(todayDayLocator));
    }

    protected UIElement getSelectedDay() {
        return new UIElement(By.cssSelector(selectedDayLocator));
    }

    protected UIElement getActiveDay() {
        return new UIElement(By.cssSelector(activeDayLocator));
    }

    protected UIElement getMonth(final String month, final Locale locale) {
        String monthShort = Month.valueOf(month).getDisplayName(TextStyle.SHORT, locale).toUpperCase();
        return new UIElement(By.xpath(String.format(CELL.getName(), monthShort)));
    }

    protected UIElement getMonth(final int month, final Locale locale) {
        String monthShort = Month.of(month).getDisplayName(TextStyle.SHORT, locale).toUpperCase();
        return new UIElement(By.xpath(String.format(value, monthShort)));
    }

    protected UIElement getDay(final String day) {
        return new UIElement(By.xpath(String.format(value.replace("%s", " %s "), day)));
    }

    protected UIElement getDay(final int day) {
        return new UIElement(By.xpath(String.format(value.replace("%s", " %s "), day)));
    }

    protected UIElement getYear(final int year) {
        return new UIElement(By.xpath(String.format(value, year)));
    }

    protected UIElement getPreviousMonth() {
        return new UIElement(By.xpath(PREVIOUS_MONTH.getName()));
    }

    protected UIElement getNextMoth() {
        return new UIElement(By.xpath(NEXT_MONTH.getName()));
    }

    protected UIElement getPreviousTwentyYears() {
        return new UIElement(By.xpath(PREVIOUS_TWENTY_YEARS.getName()));
    }

    protected UIElement getNextTwentyYears() {
        return new UIElement(By.xpath(NEXT_TWENTY_YEARS.getName()));
    }

    protected WebList getColumn(final int columnNumber) {
        return new WebList(By.xpath(String.format(columnLocator, columnNumber)));
    }

    protected Point getOutsidePoint() {
        UIElement uiElement = getCalendar();
        return new Point(uiElement.core().getRect().getWidth() + 2, uiElement.core().getRect().getHeight() + 2);
    }

    private Month getSelectedMonth(final Locale locale) {
        String selectedMonth = getSelectedMonth().text().trim().replace(".", "");
        Month month = Arrays.stream(Month.values())
                .filter(m -> m.getDisplayName(TextStyle.FULL, locale).toUpperCase().contains(selectedMonth))
                .collect(Collectors.toList()).get(0);
        collapse();
        return month;
    }

    private void selectYear(final int year) {
        openYearsView();
        String chosenDate = getChosenDate().text().trim();
        int size = chosenDate.length();
        int minYear = Integer.parseInt(chosenDate.substring(0, YEAR_LENGTH));
        int maxYear = Integer.parseInt(chosenDate.substring(size - YEAR_LENGTH, size));
        if (minYear <= year && maxYear >= year) {
            getYear(year).click();
        } else if (minYear > year) {
            while (minYear > year) {
                getPreviousTwentyYears().click();
                chosenDate = getChosenDate().text().trim();
                minYear = Integer.parseInt(chosenDate.substring(0, YEAR_LENGTH));
            }
            getYear(year).click();
        } else {
            while (maxYear < year) {
                getNextTwentyYears().click();
                chosenDate = getChosenDate().text().trim();
                maxYear = Integer.parseInt(chosenDate.substring(size - YEAR_LENGTH, size));
            }
            getYear(year).click();
        }
    }

    private Month getMonth(final Locale locale) {
        Month startMonth = null;
        for (Month month : Month.values()) {
            if (getMonth(month.name(), locale).attr("class").contains("mat-calendar-body-active")) {
                startMonth = month;
                break;
            }
        }
        if (startMonth == null) {
            throw new IllegalStateException("Calendar has no active Month");
        }
        return startMonth;
    }

    private LocalDate getLocalDate(final String date, final Locale locale) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy", locale);
        LocalDate localDate;
        localDate = LocalDate.parse(date, formatter);
        return localDate;
    }

    private LocalDate getLocalDate(final Locale locale) {
        UIElement monthAndYear = getChosenMonthAndYear();
        String trimMonth = monthAndYear.text().trim();
        String selectedMonth = trimMonth.substring(0, trimMonth.indexOf(SPACE_CHARACTER_ASCII_CODE)).replace(".", "");
        Month month = Arrays.stream(Month.values())
                .filter(m -> m.getDisplayName(TextStyle.FULL, locale).toUpperCase().contains(selectedMonth))
                .collect(Collectors.toList()).get(0);
        LocalDate date = LocalDate
                .of(Integer.valueOf(trimMonth.substring(trimMonth.indexOf(SPACE_CHARACTER_ASCII_CODE) + 1)), month,
                    Integer.valueOf(getSelectedDay().text().trim()));
        collapse();
        return date;
    }

    private void selectDate(final LocalDate date, final Locale locale) {
        int year = date.getYear();
        int day = date.getDayOfMonth();
        int month = date.getMonth().getValue();
        selectYear(year);
        selectMonth(month, locale);
        selectDay(day);
    }
}
