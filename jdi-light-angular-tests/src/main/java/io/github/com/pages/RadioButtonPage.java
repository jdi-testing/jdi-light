package io.github.com.pages;

import com.epam.jdi.light.angular.elements.common.Button;
import com.epam.jdi.light.angular.elements.complex.RadioButtons;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class RadioButtonPage extends NewAngularPage {

    @UI("(//*[@id='basic-radio-group'])[1]")
    public static RadioButtons basicRadioGroup;

    @UI("#season-radio-group")
    public static RadioButtons seasonRadioGroup;

    @UI("#favorite-season-winter")
    public static Button winterRadioButton;

    @UI("#your-favorite-season-text")
    public static Text yourFavoriteSeasonText;

    @UI("#basic-radio-group-label-position")
    public static RadioButtons labelPositionRadioGroup;

    @UI("#basic-radio-group-disabled")
    public static RadioButtons disabledRadioGroup;

    @UI("(//*[@role='radiogroup'])[8]")
    public static RadioButtons requiredRadioGroup;

    @UI("#basic-radio-group-ripple-disabled")
    public static RadioButtons rippleDisabledRadioGroup;

}
