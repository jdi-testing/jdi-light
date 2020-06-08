package cucumberTests.stepdefs;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.ui.html.elements.common.FileInput;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import static com.epam.jdi.bdd.stepdefs.CheckListSteps.multiSelect;
import static com.epam.jdi.light.elements.init.entities.collection.EntitiesCollection.getUI;
import static com.epam.jdi.light.settings.JDISettings.COMMON;
import static com.epam.jdi.tools.PathUtils.mergePath;
import static io.github.com.StaticSite.homePage;
import static io.github.com.entities.Users.DEFAULT_USER;
import static io.github.com.pages.Header.*;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class UserStepdefs {

    @Given("^I should be logged in$")
    public void iShouldBeLogin() {
        String url = WebPage.getUrl();
        if (!url.contains("https://jdi-testing.github.io/jdi-light/")
                || url.contains("issue")) {
            homePage.open();
        }
        if (userName.isHidden()) {
            if (loginForm.isHidden()) {
                userIcon.click();
            }
            loginForm.submit(DEFAULT_USER);
        }
    }

    @When("^I try to upload file \"([^\"]*)\" by \"([^\"]*)\" file input element$")
    public void iTryToUploadFileByFileInputElement(String pathToFile, String elementName) {
        FileInput fileInput = getUI(elementName, FileInput.class);
        try {
            fileInput.uploadFile(mergePath(COMMON.projectPath, pathToFile));
            fail("Can't upload file in disabled FileInput");
        } catch (Exception ex) {
            assertTrue(ex.getLocalizedMessage().contains("FileInput 'Disabled File Input' is disabled. Can't upload file"));
        }
    }
    @When("^I select \"([^\"]*)\" disabled option \"([^\"]*)\"")
    public void iSelectDisabled(String name, String option) {
        try {
            multiSelect(name, asList(option));
            fail("Select disabled should throw exception");
        } catch (Exception ignore) {}
    }
}