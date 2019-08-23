package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.ui.html.common.ProgressBar;
import com.epam.jdi.light.ui.html.common.Range;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.epam.jdi.bdd.Utils.getUI;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class RangeSteps {
    @When("^(?:I |)install \"([^\"]*)\" value to (\\d+)$")
    public void installTo(String elementName, int value) {
        Range el = (Range) getUI(elementName);
        el.setVolume(value);
    }
}
