package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.ui.html.common.ProgressBar;
import cucumber.api.java.en.Then;

import static com.epam.jdi.bdd.Utils.getUI;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class ProgressBarSteps {

    @Then("^the \"([^\"]*)\" progress volume greater or equal to (\\d+)$")
    public void volumeGreaterOrEqualTo(String elementName, int value) {
        ProgressBar el = (ProgressBar) getUI(elementName);
        el.is().volume(greaterThanOrEqualTo(value));
    }

    @Then("^the \"([^\"]*)\" progress volume less or equal to (\\d+)$")
    public void volumeLessOrEqualTo(String elementName, int value) {
        ProgressBar el = (ProgressBar) getUI(elementName);
        el.is().volume(lessThanOrEqualTo(value));
    }
}
