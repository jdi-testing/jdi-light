package io.github.com.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.ui.html.base.Combobox;
import com.epam.jdi.light.ui.html.base.MultiDropdown;
import com.epam.jdi.light.ui.html.common.*;
import com.epam.jdi.light.ui.html.complex.*;

public class HtmlElementsPage extends WebPage {
    //region Simple Elements

    public static Title jdiTitle;
    // @Css("[ui=jdi-title]") public static Title jdiTitle;
	public static Text jdiText;
	// @Css("[ui=jdi-text]") public static Text jdiText;

    @Css("[value*='Red Button']") public static Button redButton;
    // @Css("input[type=button].red") public static Button redButton;
    @Css("[value*='Disabled Button']") public static Button disabledButtonInput;
    // @Css("input[type=button][disabled]") public static Button disabledButtonInput;
    public static Button blueButton, disabledButton;
    // @Css("#blue-button") public static Button blueButton;
    // @Css("#disabled-button") public static Button disabledButton;

    public static Link githubLink;
    // @Css("[ui=github-link]") public static Link gitHubLink;

    public static TextField name, disabledName;
    // @Css("#name") public static TextField name;
    // @Css("#disabled-name") public static TextField disabledName;

    public static TextArea textArea;
    // @Css("#text-area") public static TextArea textArea;
    @Css("textarea[disabled]") public static TextArea disabledTextArea;

    public static FileInput avatar;
    // @Css("#avatar") public static FileInput avatar;
    @Css("input[type=file][disabled]") public static FileInput disabledFileInput;
    @Css("[download]") public static Link downloadJdiLogo;

    public static Image jdiLogo;
    // @Css("#jdi-logo") public static Image jdiLogo;

    public static ColorPicker colorPicker;
    @Css("#disabled-picker") public static ColorPicker disabledPicker;

    public static Range volume;
    // @Css("#volume") public static Range volume;
    @Css("[type=range][disabled]") public static Range disabledRange;

    public static ProgressBar progress;
    // @Css("#progress") public static ProgressBar progress;

    public static DateTimeSelector birthDate, monthDate, partyTime, bookingTime, autumnWeek;
    // @Css("#birth-date") public static DateTimeSelector birthDate;
    // @Css("#month-date") public static DateTimeSelector monthDate;
    // @Css("#party-date") public static DateTimeSelector partyTime;
    // @Css("#booking-date") public static DateTimeSelector bookingTime;
    // @Css("#autumn-week") public static DateTimeSelector autumnWeek;

    public static NumberSelector height;
    // @Css("#height") public static NumberSelector height;

    //endregion

    //region Complex Elements
    // TODO add Enum

    public static Dropdown dressCode;
    // @Css("#dress-code") public static Dropdown dressCode;
    @Css("#disabled-dropdown") public static Dropdown disabledDropdown;

    public static MultiSelect ages;
    // @Css("#ages") public static MultiSelect ages;
    @Css("#multi-dropdown")
    public static MultiDropdown multiDropdown;
    // @Css("#multi-dropdown") public static MultiSelect multiDropdown;

    public static Combobox iceCream;
    // @Css("#ice-cream") public static Combobox iceCream;
    @Css("#ice-cream") public static DataList iceCreamDataList;

    public static Checkbox acceptConditions;
    // @Css("#accept-conditions") public static Checkbox acceptConditions;

    // TODO NEED VERIFICATION
    // TODO UNCOMMENT public static List<Checkbox> checkboxList;
    @Css("[name=checks-group]")
    public static Checklist weather;
    public static Checklist weatherNoLocator;

    @Css("[name=colors]")
    public static RadioButtons colors;
    public static RadioButtons colorsNoLocator;

    //endregion

}