package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.elements.base.BaseElement;
import com.epam.jdi.light.ui.html.common.Image;
import cucumber.api.java.en.Then;

import static com.epam.jdi.bdd.Utils.getImage;

public class BaseValidationSteps {
    @Then("^do \"([^\"]*)\" base validation$")
    public void doBaseValidation(String imageName) {
        BaseElement image = getImage(imageName);
        //baseValidation(image);//TODO how to...
    }
}
