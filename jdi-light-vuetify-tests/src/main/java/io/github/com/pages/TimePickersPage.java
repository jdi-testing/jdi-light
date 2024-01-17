package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.Input;
import com.epam.jdi.light.vuetify.elements.complex.Dialog;
import com.epam.jdi.light.vuetify.elements.complex.Menu;
import com.epam.jdi.light.vuetify.elements.complex.TimePicker;

public class TimePickersPage extends VuetifyPage {

    // @todo #5298 Locators should use .v-picker class for TimePickers
    @UI("#AllowedTimesTimePicker > div:nth-child(1)")
    public static TimePicker allowedTimesTimePicker;

    @UI("#AMPMInTitleTimePicker > div:nth-child(1)")
    public static TimePicker amPmInTitleTimePicker;

    @UI("#AMPMInTitleTimePicker > div:nth-child(2)")
    public static TimePicker secondAmPmInTitleTimePicker;

    @UI("#ColorsTimePicker > div:nth-child(1)")
    public static TimePicker firstColorTimePicker;

    @UI("#DisabledTimePicker > div:nth-child(1)")
    public static TimePicker disabledTimePicker;

    @UI("#ElevationTimePicker > div:nth-child(2)")
    public static TimePicker elevatedTimePicker;

    @UI("#FormatTimePicker > div")
    public static TimePicker formatTimePicker;

    @UI("#NoTitleTimePicker > div:nth-child(1)")
    public static TimePicker noTitleTimePicker;

    @UI("#NoTitleTimePicker > div:nth-child(2)")
    public static TimePicker verticalNoTitleTimePicker;

    @UI("#ScrollableTimePicker > .v-picker")
    public static TimePicker scrollableTimePicker;

    @UI("#ReadOnlyTimePicker > div:nth-child(1)")
    public static TimePicker readOnlyTimePicker;

    @UI("#UseSecondsTimePicker > div:nth-child(1)")
    public static TimePicker useSecondsTimePicker1;

    @UI("#UseSecondsTimePicker > div:nth-child(2)")
    public static TimePicker useSecondsTimePicker2;

    @UI("#WidthTimePicker > div:nth-child(1)")
    public static TimePicker firstWidthTimePicker;

    @UI("#DialogAndMenuTimePicker > div:nth-child(1)")
    public static Input inputForMenuTimePicker;
    @UI("div[role='menu']")
    public static Menu menuForTimePicker;
    @UI("div.v-menu__content")
    public static TimePicker timePickerInMenu;

    @UI("#DialogAndMenuTimePicker > div:nth-child(3)")
    public static Input inputForDialogTimePicker;
    @UI("div[role='dialog']")
    public static Dialog dialogForTimePicker;
    @UI("div.v-dialog__content")
    public static TimePicker timePickerInDialog;
}
