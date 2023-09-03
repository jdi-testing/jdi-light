package io.github.com;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;;
import io.github.com.pages.*;

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

    @Url("autocompletes")
    public static AutocompletePage autocompletePage;
}
