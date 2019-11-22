package io.github.epam.bootstrap.tests.composite.section.inputgroup;

import io.github.epam.TestsInit;
import io.github.epam.states.States;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.common.ElementArea.ACTION_CLICK;
import static com.epam.jdi.light.driver.get.DriverData.PROJECT_PATH;
import static com.epam.jdi.light.elements.common.Alerts.validateAlert;
import static com.epam.jdi.light.settings.WebSettings.ANY_ELEMENT;
import static com.epam.jdi.tools.PathUtils.mergePath;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.inputGroupCustomFileInput;
import static io.github.com.pages.BootstrapPage.inputGroupCustomUploadFile;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

public class InputGroupCustomFileInputTests extends TestsInit {

    private String alertMessage = "Button clicked, thank you!";

    @BeforeMethod
    public void before() {
        States.shouldBeLoggedIn();
        bsPage.shouldBeOpened();
        inputGroupCustomFileInput.fileInput.core().setup(jdiB -> jdiB.setSearchRule(ANY_ELEMENT));
        inputGroupCustomFileInput.fileInput.core().setClickArea(ACTION_CLICK);
        inputGroupCustomUploadFile.fileInput.core().setup(jdiB -> jdiB.setSearchRule(ANY_ELEMENT));
        inputGroupCustomUploadFile.fileInput.core().setClickArea(ACTION_CLICK);
    }

    @Test
    public void uploadTest() {
        clearInput();
        inputGroupCustomFileInput.fileInput.uploadFile(mergePath(PROJECT_PATH,
                "/src/test/resources/general.xml"));
        inputGroupCustomFileInput.fileInput.is().text(containsString("general.xml"));
        inputGroupCustomFileInput.fileInput.is().value(containsString("general.xml"));
    }

    @Test
    public void fileInputTest() {
        inputGroupCustomFileInput.fileInput.label().is().text("Choose file");
        inputGroupCustomUploadFile.fileInput.label().is().text("Choose file");
    }

    @Test
    public void clearInput() {
        inputGroupCustomFileInput.fileInput.core().jsExecute("value=''");
        inputGroupCustomFileInput.fileInput.is().value("");
    }

    @Test
    public void baseValidationTest() {
        baseValidation(inputGroupCustomFileInput.fileInput.label());
        baseValidation(inputGroupCustomFileInput);
        baseValidation(inputGroupCustomUploadFile.fileInput.label());
        baseValidation(inputGroupCustomUploadFile.btnSubmit);
        baseValidation(inputGroupCustomUploadFile);
    }

    @Test
    public void uploadRobotTest() {
        clearInput();
        inputGroupCustomFileInput.fileInput.uploadFileRobot(mergePath(PROJECT_PATH,
                "/src/test/resources/general.xml"), 1000L);
        inputGroupCustomFileInput.fileInput.is().text(containsString("general.xml"));
        inputGroupCustomFileInput.fileInput.is().value(containsString("general.xml"));
    }

    @Test
    public void uploadFileWithButtonTest() {
        clearInput();
        inputGroupCustomUploadFile.fileInput.uploadFile(mergePath(PROJECT_PATH,
                "/src/test/resources/general.xml"));
        inputGroupCustomUploadFile.fileInput.is().text(containsString("general.xml"));
        inputGroupCustomUploadFile.fileInput.is().value(containsString("general.xml"));
    }

    @Test
    public void buttonUploadFileTest() {
        inputGroupCustomUploadFile.btnSubmit.is().text("Submit");
        inputGroupCustomUploadFile.clickSubmitButton();
        validateAlert(is(alertMessage));
    }
}
