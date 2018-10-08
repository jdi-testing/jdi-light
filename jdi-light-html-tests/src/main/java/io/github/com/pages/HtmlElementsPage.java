package io.github.com.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.ui.html.common.*;
import com.epam.jdi.light.ui.html.complex.*;

import java.util.List;

public class HtmlElementsPage extends WebPage {
    //region Simple Elements

    public Title jdiTitle;
    // @Css("[ui=jdi-title]") public Title jdiTitle;
	public Text jdiText;
	// @Css("[ui=jdi-text]") public Text jdiText;

    @Css("[value*='Red Button']") public Button redButton;
    // @Css("input[type=button].red") public Button redButton;
    @Css("[value*='Disabled Button']") public Button disabledButtonInput;
    // @Css("input[type=button][disabled]") public Button disabledButtonInput;
    public Button blueButton;
    // @Css("#blue-button") public Button blueButton;
    public Button disabledButton;
    // @Css("#disabled-button") public Button disabledButton;

    public Link githubLink;
    // @Css("[ui=github-link]") public Link gitHubLink;

    public TextField name;
    // @Css("#name") public TextField name;
    public TextField disabledName;
    // @Css("#disabled-name") public TextField disabledName;

    public TextArea textArea;
    // @Css("#text-area") public TextArea textArea;
    @Css("textarea[disabled]") public TextArea disabledTextArea;

    public FileInput avatar;
    // @Css("#avatar") public FileInput avatar;
    @Css("input[type=file][disabled]") public FileInput disabledFileInput;

    public Image jdiLogo;
    // @Css("#jdi-logo") public Image jdiLogo;

    //endregion

    //region Complex Elements
    // TODO add Enum

    public Dropdown dressCode;
    // @Css("#dress-code") public Dropdown dressCode;
    @Css("#disabled-dropdown") public Dropdown disabledDropdown;

    public MultiSelect ages;
    // @Css("#ages") public MultiSelect ages;

    // TODO Multi Dropdown ?
    public MultiSelect multiDropdown;
    // @Css("#multi-dropdown") public MultiSelect multiDropdown;

    public Combobox iceCream;
    // @Css("#ice-cream") public Combobox iceCream;
    @Css("#ice-cream") public DataList iceCreamDataList;

    public Checkbox acceptConditions;
    // @Css("#accept-conditions") public Checkbox acceptConditions;

    // TODO NEED VERIFICATION
    public List<Checkbox> checkboxList;
    public Checklist checklist;

    // TODO NEED VERIFICATION
    public RadioButtons colors;

    public ColorPicker colorPicker;
    @Css("#disabled-picker") public ColorPicker disabledPicker;

    public Range volume;
    // @Css("#volume") public Range volume;
    @Css("[type=range][disabled]") public Range disabledRange;

    public ProgressBar progress;
    // @Css("#progress") public ProgressBar progress;

    public DateTimeSelector birthDate;
    // @Css("#birth-date") public DateTimeSelector birthDate;

    public DateTimeSelector monthDate;
    // @Css("#month-date") public DateTimeSelector monthDate;

    public DateTimeSelector partyTime;
    // @Css("#party-date") public DateTimeSelector partyTime;

    public DateTimeSelector bookingTime;
    // @Css("#booking-date") public DateTimeSelector bookingTime;

    public DateTimeSelector autumnWeek;
    // @Css("#autumn-week") public DateTimeSelector autumnWeek;

    public NumberSelector height;
    // @Css("#height") public NumberSelector height;

    //endregion

}