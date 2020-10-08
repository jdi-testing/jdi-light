package io.github.com.pages.sections;

import com.epam.jdi.light.angular.elements.common.Spinner;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;

public class SpinnerSection {

    @UI("#basic-progress-spinner")
    public static Spinner basicProgressSpinner;

    @UI("#show-spinner")
    public static Button showSpinner;
}
