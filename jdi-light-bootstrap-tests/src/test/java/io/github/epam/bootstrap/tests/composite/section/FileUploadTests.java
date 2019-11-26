package io.github.epam.bootstrap.tests.composite.section;

import io.github.epam.TestsInit;
import io.github.epam.states.States;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.driver.get.DriverData.PROJECT_PATH;
import static com.epam.jdi.tools.PathUtils.mergePath;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.inputFileSection;
import static io.github.epam.bootstrap.tests.BaseValidationsUtils.baseValidation;
import static org.hamcrest.Matchers.containsString;

public class FileUploadTests extends TestsInit {

    @BeforeMethod
    public void before() {
        States.shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void uploadTest() {
        clearInput();
        inputFileSection.fileInput.uploadFile(mergePath(PROJECT_PATH,
                "/src/test/resources/general.xml"));
        inputFileSection.fileInput.is().text(containsString("general.xml"));
        inputFileSection.fileInput.is().value(containsString("general.xml"));
    }

    @Test
    public void fileInputLabelTest() {
        inputFileSection.fileInput.label().is().text("Example file input");
    }

    @Test
    public void clearInput() {
        inputFileSection.fileInput.core().jsExecute("value=''");
        inputFileSection.fileInput.is().value("");
    }

    @Test
    public void baseValidationTest() {
        baseValidation(inputFileSection.labelInputFile);
        baseValidation(inputFileSection.fileInput);
    }

    @Test
    public void uploadRobotTest() {
        clearInput();
        inputFileSection.fileInput.uploadFileRobot(mergePath(PROJECT_PATH,
                "/src/test/resources/general.xml"), 1000L);
        inputFileSection.fileInput.is().text(containsString("general.xml"));
        inputFileSection.fileInput.is().value(containsString("general.xml"));
    }
}
