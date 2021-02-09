package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.ui.html.elements.common.Link;
import io.cucumber.java.en.Then;

import static com.epam.jdi.light.elements.init.entities.collection.EntitiesCollection.getUI;
import static org.hamcrest.Matchers.*;

/**
 * Created by Ekaterina Vasilkova on 19.08.2019
 */
public class LinkSteps {
    public static Link link(String name) {
        return getUI(name, Link.class);
    }

    @Then("the {string} reference equals to {string}")
    public void refEquals(String name, String expectedText) {
        link(name).is().ref(equalTo(expectedText));
    }

    @Then("the {string} reference contains {string}")
    public void refContains(String name, String expectedText) {
        link(name).is().ref(containsString(expectedText));
    }

    @Then("the {string} reference match to {string}")
    public void refMatchRegex(String name, String regex) {
        link(name).is().ref(matchesPattern(regex));
    }

    @Then("the {string} alt text equals to {string}")
    public void altEquals(String name, String expectedText) {
        link(name).is().alt(equalTo(expectedText));
    }

    @Then("the {string} alt text contains {string}")
    public void altContains(String name, String expectedText) {
        link(name).is().alt(containsString(expectedText));
    }

    @Then("the {string} alt text match to {string}")
    public void altMatchRegex(String name, String regex) {
        link(name).is().alt(matchesPattern(regex));
    }
}