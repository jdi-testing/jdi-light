package io.github.com.pages;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.complex.dropdown.DropdownSelect;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.interfaces.complex.IsChecklist;
import com.epam.jdi.light.elements.interfaces.complex.IsCombobox;
import com.epam.jdi.light.elements.interfaces.complex.IsDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.NoWait;
import com.epam.jdi.light.elements.pageobjects.annotations.WaitTimeout;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.*;
import com.epam.jdi.light.ui.html.elements.complex.Checklist;
import com.epam.jdi.light.ui.html.elements.complex.DataListOptions;
import com.epam.jdi.light.ui.html.elements.complex.MultiSelector;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;

public class HtmlElementsPage extends WebPage {
    //region Simple Elements

    public static Label jdiTitle;
    // @UI("[ui=jdi-title]") public static Label jdiTitle;
	public static Text jdiText;
	// @UI("[ui=jdi-text]") public static Text jdiText;

    @UI("[value*='Red Button']") public static Button redButton;
    // @UI("input[type=button].red") public static Button redButton;
    @UI("[value*='Disabled Button']") public static Button disabledButtonInput;
    // @UI("input[type=button][disabled]") public static Button disabledButtonInput;
    public static Button blueButton;
    public static Button dblClickButton;
    public static Button rightClickButton;
    @WaitTimeout(4)
    public static Button ghostButton, suspendButton;
    @NoWait
    public static Button disabledButton;
    // @UI("#blue-button") public static Button blueButton;
    // @UI("#disabled-button") public static Button disabledButton;

    public static Link githubLink;
    // @UI("[ui=github-link]") public static Link gitHubLink;

    public static TextField name;
    @WaitTimeout(2) public static TextField disabledName;
    // @UI("#name") public static TextField name;
    // @UI("#disabled-name") public static TextField disabledName;

    public static TextArea textArea;
    // @UI("#text-area") public static TextArea textArea;
    @UI("textarea[disabled]") public static TextArea disabledTextArea;

    public static FileInput avatar;
    // @UI("#avatar") public static FileInput avatar;
    @UI("input[type=file][disabled]")
    public static FileInput disabledFileInput;
    @UI("[download]") public static Link downloadJdiLogo;

    public static Image jdiLogo;
    // @UI("#jdi-logo") public static Image jdiLogo;

    public static ColorPicker colorPicker;
    @UI("#disabled-picker") public static ColorPicker disabledPicker;

    public static Range volume;
    // @UI("#volume") public static Range volume;
    @UI("[type=range][disabled]") public static Range disabledRange;

    public static ProgressBar progress;
    // @UI("#progress") public static ProgressBar progress;

    public static DateTimeSelector birthDate, monthDate, partyTime, bookingTime, autumnWeek;
    // @UI("#birth-date") public static DateTimeSelector birthDate;
    // @UI("#month-date") public static DateTimeSelector monthDate;
    // @UI("#party-date") public static DateTimeSelector partyTime;
    // @UI("#booking-date") public static DateTimeSelector bookingTime;
    // @UI("#autumn-week") public static DateTimeSelector autumnWeek;

    public static NumberSelector height;
    // @UI("#height") public static NumberSelector height;

    //endregion

    //region Complex Elements
    // TODO add Enum

    public static DropdownSelect dressCode;
    @UI("#dress-code") public static Dropdown dressCode2;
    @UI("#dress-code") public static IsDropdown dressCode3;
    // @UI("#dress-code") public static Dropdown dressCode;
    @UI("#disabled-dropdown") public static DropdownSelect disabledDropdown;

    public static MultiSelector ages;
    //@UI("#ages") public static MultiSelector ages;
    public static MultiSelector multiDropdown;
    // @UI("#multi-dropdown") public static MultiSelector multiDropdown;

    public static DataListOptions iceCream;
    @UI("#ice-cream")
    public static IsCombobox iceCreamIs;

    public static Checkbox acceptConditions;
    // @UI("#accept-conditions") public static Checkbox acceptConditions;

    @UI("[name=checks-group]")
    public static Checklist weather;
    @UI("[name=checks-group]")
    public static IsChecklist isWeather;
    public static Checklist weatherNoLocator;

    @UI("[name=colors]")
    public static RadioButtons colors;
    public static RadioButtons colorsNoLocator;

    //endregion

}