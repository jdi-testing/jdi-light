package com.epam.jdi.bdd;

import com.epam.jdi.light.ui.html.common.FileInput;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.epam.jdi.light.driver.get.DriverData.PROJECT_PATH;
import static com.epam.jdi.light.elements.composite.WebPage.ELEMENTS;
import static com.epam.jdi.tools.PathUtils.mergePath;
import static org.hamcrest.Matchers.containsString;

public class FileInputSteps {
    @Then("^\"([^\"]*)\" file input element label text equals \"([^\"]*)\"$")
    public void fileInputElementHasLabelText(String elementName, String labelText) {
        FileInput fileInput = (FileInput) ELEMENTS.get(elementName).get(0);
        fileInput.label().is().text(labelText);
    }

    @And("^\"([^\"]*)\" file input element label text contains \"([^\"]*)\"$")
    public void fileInputElementLabelTextContains(String elementName, String labelText) {
        FileInput fileInput = (FileInput) ELEMENTS.get(elementName).get(0);
        fileInput.label().is().text(containsString(labelText));
    }

    @When("^I upload file \"([^\"]*)\" by \"([^\"]*)\" file input element$")
    public void iUploadFileByFileInputElement(String pathToFile, String elementName) {
        FileInput fileInput = (FileInput) ELEMENTS.get(elementName).get(0);
        fileInput.uploadFile(mergePath(PROJECT_PATH, pathToFile));
    }

    @Then("^\"([^\"]*)\" file input element text equals \"([^\"]*)\"$")
    public void fileInputElementTextEquals(String elementName, String text) {
        FileInput fileInput = (FileInput) ELEMENTS.get(elementName).get(0);
        fileInput.is().text(containsString(text));
    }}
