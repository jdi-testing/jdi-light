package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.ui.html.elements.common.ProgressBar;
import io.cucumber.java.en.Then;

import static com.epam.jdi.light.elements.init.entities.collection.EntitiesCollection.getUI;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class ProgressBarSteps {
    public static ProgressBar progressBar(String name) {
        return getUI(name, ProgressBar.class);
    }

    @Then("the {string} progress value greater or equal to {int}")
    public void valueGreaterOrEqualTo(String name, int value) {
        progressBar(name).is().value(greaterThanOrEqualTo(value));
    }

    @Then("the {string} progress value less or equal to {int}")
    public void valueLessOrEqualTo(String name, int value) {
        progressBar(name).is().value(lessThanOrEqualTo(value));
    }
}
