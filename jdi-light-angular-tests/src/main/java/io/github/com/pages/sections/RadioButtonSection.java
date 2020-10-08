package io.github.com.pages.sections;

import com.epam.jdi.light.angular.elements.complex.RadioButtons;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class RadioButtonSection {

    @UI("#basic-radio-group")
    public static RadioButtons basicRadioGroup;

    @UI("#season-radio-group")
    public static RadioButtons seasonRadioGroup;

    @UI("your-favorite-season-text")
    public static Text yourFavoriteSeasonText;
}
