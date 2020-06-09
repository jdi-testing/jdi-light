package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.ui.html.elements.common.FileInput;
import cucumber.api.java.en.When;

import static com.epam.jdi.light.elements.init.entities.collection.EntitiesCollection.getUI;
import static com.epam.jdi.light.settings.JDISettings.COMMON;
import static com.epam.jdi.tools.PathUtils.mergePath;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class FileInputSteps {
    public static FileInput fileInput(String name) {
        return getUI(name, FileInput.class);
    }

    @When("^I upload file \"([^\"]*)\" by \"([^\"]*)\" file input element$")
    public void iUploadFileByFileInputElement(String pathToFile, String name) {
        fileInput(name).uploadFile(mergePath(COMMON.projectPath, pathToFile));
    }
}
