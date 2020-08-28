package com.epam.jdi.light.angular.entities;

/**
 * Datepicker navigation elements.
 * The order of the first eight fields is important. Do not move them unnecessarily.
 */
public enum DatepickerNavigation {
    DATEPICKER("//*[@id='%s']/ancestor::mat-form-field"),
    SUNDAY("Sunday"),
    MONDAY("Monday"),
    TUESDAY("Tuesday"),
    WEDNESDAY("Wednesday"),
    THURSDAY("Thursday"),
    FRIDAY("Friday"),
    SATURDAY("Saturday"),
    TOGGLE("//*[@id='%s']/ancestor::mat-form-field//mat-datepicker-toggle"),
    PREVIOUS_MONTH("//button[contains(@aria-label,'Previous month')]"),
    NEXT_MONTH("//button[contains(@aria-label,'Next month')]"),
    CHOOSE_MONTH_AND_YEAR("//button[contains(@aria-label,'Choose month and year')]/span"),
    CHOOSE_DATE("//button[contains(@aria-label,'Choose date')]/span"),
    PREVIOUS_TWENTY_YEARS("//button[contains(@aria-label,'Previous 20 years')]"),
    NEXT_TWENTY_YEARS("//button[contains(@aria-label,'Next 20 years')]"),
    VALUE("//td/div[contains(text(), '%s')]"),
    CELL(VALUE.getName() + "/ancestor::td");

    private String name;

    DatepickerNavigation(final String locator) {
        this.name = locator;
    }

    public String getName() {
        return name;
    }
}
