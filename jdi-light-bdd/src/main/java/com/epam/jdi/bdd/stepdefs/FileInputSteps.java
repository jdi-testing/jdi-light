package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.bdd.Utils;
import com.epam.jdi.light.ui.html.common.FileInput;
import cucumber.api.java.en.When;

import static com.epam.jdi.light.driver.get.DriverData.PROJECT_PATH;
import static com.epam.jdi.tools.PathUtils.mergePath;

public class FileInputSteps {
    @When("^I upload file \"([^\"]*)\" by \"([^\"]*)\" file input element$")
    public void iUploadFileByFileInputElement(String pathToFile, String elementName) {
        FileInput fileInput = Utils.getUI(elementName, FileInput.class);
        fileInput.uploadFile(mergePath(PROJECT_PATH, pathToFile));
    }
}
