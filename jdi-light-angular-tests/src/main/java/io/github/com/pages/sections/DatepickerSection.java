package io.github.com.pages.sections;

import com.epam.jdi.light.angular.elements.complex.Datepicker;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

public class DatepickerSection {
    @UI("#basic-datepicker")
    public static Datepicker basicDatepicker;

    @UI("#start-date-datepicker")
    public static Datepicker startDateDatepicker;

    @UI("#min-max-datepicker")
    public static Datepicker minMaxDatepicker;

    @UI("#filter-datepicker")
    public static Datepicker filterDatepicker;

    @UI("#input-change-events-datepicker")
    public static Datepicker inputChangeEventsDatepicker;

    @UI("#touch-ui-datepicker")
    public static Datepicker touchUiDatepicker;

    @UI("#open-method-datepicker")
    public static Datepicker openMethodDatepicker;

    @UI("#different-locale-datepicker")
    public static Datepicker differentLocaleDatepicker;

    @UI("#moment-js-datepicker")
    public static Datepicker momentJsDatepicker;

    @UI("#custom-formats-datepicker")
    public static Datepicker customFormatsDatepicker;

    @UI("#selected-datepicker")
    public static Datepicker selectedDatepicker;

    @UI("#deserialize-datepicker")
    public static Datepicker deserializeDatepicker;

    @UI("#binding-datepicker")
    public static Datepicker bindingDatepicker;

    @UI("#completely-disabled-datepicker")
    public static Datepicker completelyDisabledDatepicker;

    @UI("#popup-disabled-datepicker")
    public static Datepicker popupDisabledDatepicker;

    @UI("#input-disabled-datepicker")
    public static Datepicker inputDisabledDatepicker;
}
