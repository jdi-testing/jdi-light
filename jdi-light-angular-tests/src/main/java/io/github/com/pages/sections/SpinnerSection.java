package io.github.com.pages.sections;

import com.epam.jdi.light.angular.elements.common.Spinner;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;

public class SpinnerSection {

    @UI("#basic_progress_spinner")
    public static Spinner basicProgressSpinner;

    @UI("//span[contains(text(), ' Show progress-spinner for 5 seconds')]/..")
    public static Button showSpinner;
}
