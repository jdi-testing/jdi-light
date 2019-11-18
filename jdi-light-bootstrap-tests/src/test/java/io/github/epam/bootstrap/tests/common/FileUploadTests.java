package io.github.epam.bootstrap.tests.common;

import io.github.epam.TestsInit;
import io.github.epam.states.States;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.driver.get.DriverData.PROJECT_PATH;
import static com.epam.jdi.tools.PathUtils.mergePath;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.inputFileSection;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

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
        assertThat(inputFileSection.fileInput.getValue(), containsString("general.xml"));
        inputFileSection.fileInput.core().is()
                .attr("value", containsString("general.xml"));
    }

    @Test
    public void fileInputTest() {
        assertThat(inputFileSection.fileInput.getName(), equalTo("File Input"));
        assertThat(inputFileSection.fileInput.labelText(), equalTo("Example file input"));
    }

    @Test
    public void clearInput() {
        inputFileSection.fileInput.core().jsExecute("value=''");
        assertThat(inputFileSection.fileInput.getValue(), equalTo(""));
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
        assertThat(inputFileSection.fileInput.getValue(), containsString("general.xml"));
    }
}
