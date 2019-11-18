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
        inputFileSection.fileInputBs.uploadFile(mergePath(PROJECT_PATH,
                "/src/test/resources/general.xml"));
        inputFileSection.fileInputBs.is().text(containsString("general.xml"));
        assertThat(inputFileSection.fileInputBs.getValue(), containsString("general.xml"));
        inputFileSection.fileInputBs.core().is()
                .attr("value", containsString("general.xml"));
    }

    @Test
    public void fileInputTest() {
        assertThat(inputFileSection.fileInputBs.getName(), equalTo("File Input Bs"));
        assertThat(inputFileSection.fileInputBs.labelText(), equalTo("Example file input"));
    }

    @Test
    public void clearInput() {
        inputFileSection.fileInputBs.core().jsExecute("value=''");
        assertThat(inputFileSection.fileInputBs.getValue(), equalTo(""));
    }

    @Test
    public void baseValidationTest() {
        baseValidation(inputFileSection.labelInputFile);
        baseValidation(inputFileSection.fileInputBs);
    }

    @Test
    public void uploadJRobotTest() {
        clearInput();
        inputFileSection.fileInputBs.uploadFile(mergePath(PROJECT_PATH,
                "/src/test/resources/general.xml"), 1000L);
        inputFileSection.fileInputBs.is().text(containsString("general.xml"));
        assertThat(inputFileSection.fileInputBs.getValue(), containsString("general.xml"));
    }
}
