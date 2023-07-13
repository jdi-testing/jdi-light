package io.github.com;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.jdiai.tools.DataClass;
import io.github.com.pages.AngularPage;
import io.github.com.pages.AutocompletePage;
import io.github.com.pages.BadgePage;
import io.github.com.pages.ButtonTogglePage;
import io.github.com.pages.ButtonsPage;
import io.github.com.pages.ProgressBarPage;
import io.github.com.pages.ProgressSpinnerPage;
import io.github.com.pages.GridListPage;
import io.github.com.pages.ProgressBarPage;

@JSite("https://jdi-testing.github.io/jdi-light/angular-page/#/")
public class StaticSite {

    @Url("/angular.html")
    public static AngularPage angularPage;

    @Url("progress_bar")
    public static ProgressBarPage progressBarPage;

    @Url("progress_spinner")
    public static ProgressSpinnerPage progressSpinnerPage;

    @Url("buttons")
    public static ButtonsPage buttonsPage;

    @Url("badges")
    public static BadgePage badgePage;
    @Url("grid_list")
    public static GridListPage gridListPage;

    @Url("buttons_toggle")
    public  static ButtonTogglePage buttonTogglePage;

    @Url("autocompletes")
    public static AutocompletePage autocompletePage;
}
