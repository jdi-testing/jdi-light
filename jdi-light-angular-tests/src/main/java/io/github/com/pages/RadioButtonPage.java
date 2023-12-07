package io.github.com.pages;

import com.epam.jdi.light.angular.elements.complex.radiobuttons.RadioButton;
import com.epam.jdi.light.angular.elements.complex.radiobuttons.RadioGroup;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class RadioButtonPage extends NewAngularPage {

    @UI("(//*[@id='basic-radio-group'])[1]")
    public static RadioGroup basicRadioGroup;

    @UI("#season-radio-group")
    public static RadioGroup seasonRadioGroup;

    @UI("#radio-buttons_dialog_color_radio")
    public static RadioButton primaryRadioButton;

    @UI("#radio-buttons_first-tabbable_color_radio")
    public static RadioButton accentRadioButton;

    @UI("#radio-buttons_first-heading_color_radio")
    public static RadioButton warnRadioButton;

    @UI("(//*[@id='basic-radio-group'])[2]")
    public static RadioGroup elementPositionRadioGroup;

    @UI("#radio-buttons-color_buttons")
    public static RadioGroup colorRadioGroup;

    @UI("#your-favorite-season-text")
    public static Text yourFavoriteSeasonText;

    @UI("#basic-radio-group-label-position")
    public static RadioGroup beforePositionRadioGroup;

    @UI("#basic-radio-group-label-position")
    public static RadioGroup labelPositionRadioGroup;

    @UI("#basic-radio-group-disabled")
    public static RadioGroup disabledRadioGroup;

    @UI("(//*[@role='radiogroup'])[9]")
    public static RadioGroup requiredRadioGroup;

}
