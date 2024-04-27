package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.Input;
import com.epam.jdi.light.vuetify.elements.complex.Dialog;
import com.epam.jdi.light.vuetify.elements.complex.Menu;
import com.epam.jdi.light.vuetify.elements.complex.TimePicker;

public class TimePickersPage extends VuetifyPage {

    @UI("#AllowedTimesTimePicker .v-picker--time")
    public static TimePicker allowedTimesTimePicker;

    @UI("#AMPMInTitleTimePicker .v-picker--time")
    public static TimePicker amPmInTitleTimePicker;

    @UI("#AMPMInTitleTimePicker > div:nth-child(2)")
    public static TimePicker secondAmPmInTitleTimePicker;

    @UI("#ColorsTimePicker .v-picker--time")
    public static TimePicker firstColorTimePicker;

    @UI("#DisabledTimePicker > div:nth-child(1)")
    public static TimePicker disabledTimePicker;

    @UI("#ElevationTimePicker > div:nth-child(2)")
    public static TimePicker elevatedTimePicker;

    @UI("#FormatTimePicker .v-picker--time")
    public static TimePicker formatTimePicker;

    @UI("#NoTitleTimePicker .v-picker--time")
    public static TimePicker noTitleTimePicker;

    @UI("#NoTitleTimePicker > div:nth-child(2)")
    public static TimePicker verticalNoTitleTimePicker;

    @UI("#ScrollableTimePicker > .v-picker--time")
    public static TimePicker scrollableTimePicker;

    @UI("#ReadOnlyTimePicker > .v-picker--time")
    public static TimePicker readOnlyTimePicker;

    @UI("#UseSecondsTimePicker > .v-picker--time")
    public static TimePicker useSecondsTimePicker1;

    @UI("#UseSecondsTimePicker > div:nth-child(2)")
    public static TimePicker useSecondsTimePicker2;

    @UI("#WidthTimePicker > .v-picker--time")
    public static TimePicker firstWidthTimePicker;

    // @todo #5369 Menu with TimePicker should be described as a separate component,
    //  may be input with menu to change data
    @UI("#DialogAndMenuTimePicker .v-input")
    public static Input inputForMenuTimePicker;
    @UI("div[role='menu']")
    public static Menu menuForTimePicker;
    @UI("div.v-menu__content > .v-picker--time")
    public static TimePicker timePickerInMenu;

    // @todo #5369 Dialog with TimePicker should be described as a separate component
    //  may be input with dialog to change data
    @UI("#DialogAndMenuTimePicker > div:nth-child(3)")
    public static Input inputForDialogTimePicker;
    @UI("div[role='dialog']")
    public static Dialog dialogForTimePicker;
    @UI("div.v-dialog__content .v-picker--time")
    public static TimePicker timePickerInDialog;
}
