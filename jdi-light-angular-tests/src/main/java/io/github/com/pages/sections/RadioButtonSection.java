package io.github.com.pages.sections;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;

public class RadioButtonSection {

    @UI("#basic-radio-group")
    public static RadioButtons basicRadioButtons;

    @UI("#season-radio-group")
    public static RadioButtons seasonRadioButtons;

    @UI("#your-favorite-season-text")
    public static Text favoriteSeason;
}
