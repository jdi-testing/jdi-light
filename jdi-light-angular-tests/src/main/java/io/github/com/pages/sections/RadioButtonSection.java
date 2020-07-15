package io.github.com.pages.sections;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;


public class RadioButtonSection {
    @Css("#basic-radio-group")
    public static RadioButtons basicRadioButtons;

    @UI("#radio-option-one")
    public static Button firstBasicRadioButton;

    @UI("#radio-option-two")
    public static Button secondBasicRadioButton;

    @Css("#season-radio-group")
    public static RadioButtons seasonRadioButtons;

    @UI("#favorite-season-winter")
    public static Button winterNGModelRadioButton;

    @UI("#favorite-season-spring")
    public static Button springNGModelRadioButton;

    @UI("#favorite-season-summer")
    public static Button summerNGModelRadioButton;

    @UI("#favorite-season-autumn")
    public static Button autumnNGModelRadioButton;

    @UI("#your-favorite-season-text")
    public static Text favoriteSeason;
}
