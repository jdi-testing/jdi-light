package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.elements.init.entities.collection.EntitiesCollection;
import com.epam.jdi.light.ui.html.elements.common.DateTimeSelector;
import com.epam.jdi.light.ui.html.elements.common.Link;
import cucumber.api.java.en.Then;

import static com.epam.jdi.light.elements.init.entities.collection.EntitiesCollection.getUI;
import static org.hamcrest.Matchers.*;

/**
 * Created by Ekaterina Vasilkova on 19.08.2019
 */

public class LinkSteps {
    private Link link(String name) {
        return getUI(name, Link.class);
    }
    @Then("^\"([^\"]*)\" reference equals to \"([^\"]*)\"$")
    public void refEquals(String name, String expectedText) {
        link(name).is().ref(equalTo(expectedText));
    }
    @Then("^\"([^\"]*)\" reference contains \"([^\"]*)\"$")
    public void refContains(String name, String expectedText) {
        link(name).is().ref(containsString(expectedText));
    }
    @Then("^\"([^\"]*)\" reference match to \"([^\"]*)\"$")
    public void refMatchRegex(String name, String regex) {
        link(name).is().ref(matchesPattern(regex));
    }
    @Then("^\"([^\"]*)\" alt text equals to \"([^\"]*)\"$")
    public void altEquals(String name, String expectedText) {
        link(name).is().alt(equalTo(expectedText));
    }
    @Then("^\"([^\"]*)\" alt text contains \"([^\"]*)\"$")
    public void altContains(String name, String expectedText) {
        link(name).is().alt(containsString(expectedText));
    }
    @Then("^\"([^\"]*)\" alt text match to \"([^\"]*)\"$")
    public void altMatchRegex(String name, String regex) {
        link(name).is().alt(matchesPattern(regex));
    }
}