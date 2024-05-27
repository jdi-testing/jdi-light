package io.github.com;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import io.github.com.pages.AngularPage;
import io.github.com.pages.AutocompletePage;
import io.github.com.pages.BadgePage;
import io.github.com.pages.InputPage;
import io.github.com.pages.ButtonTogglePage;
import io.github.com.pages.ButtonsPage;
import io.github.com.pages.CheckBoxPage;
import io.github.com.pages.ChipsPage;
import io.github.com.pages.DividerPage;
import io.github.com.pages.ProgressBarPage;
import io.github.com.pages.ProgressSpinnerPage;
import io.github.com.pages.RadioButtonPage;
import io.github.com.pages.SlideTogglePage;

@JSite("https://jdi-testing.github.io/jdi-light/angular-page/#/")
public class StaticSite {

    @Url("/angular.html")
    public static AngularPage angularPage;

    @Url("progress_bar")
    public static ProgressBarPage progressBarPage;

    @Url("progress_spinner")
    public static ProgressSpinnerPage progressSpinnerPage;

    @Url("input")
    public static InputPage inputPage;

    @Url("buttons")
    public static ButtonsPage buttonsPage;

    @Url("badges")
    public static BadgePage badgePage;

    @Url("buttons_toggle")
    public  static ButtonTogglePage buttonTogglePage;

    @Url("divider")
    public  static DividerPage dividerPage;

    @Url("autocompletes")
    public static AutocompletePage autocompletePage;

    @Url("radio_button")
    public static RadioButtonPage radioButtonPage;

    @Url("checkbox")
    public static CheckBoxPage checkBoxPage;

    @Url("chips")
    public static ChipsPage chipsPage;

    @Url("slide_toggle")
    public static SlideTogglePage slideTogglePage;
}
