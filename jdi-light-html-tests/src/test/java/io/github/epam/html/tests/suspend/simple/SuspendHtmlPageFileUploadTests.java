package io.github.epam.html.tests.suspend.simple;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static com.epam.jdi.light.asserts.core.FileAssert.assertThatFile;
import static com.epam.jdi.light.asserts.core.FileAssert.cleanupDownloads;
import static com.epam.jdi.light.driver.get.DriverData.DOWNLOADS_DIR;
import static com.epam.jdi.light.driver.get.DriverData.PROJECT_PATH;
import static com.epam.jdi.light.settings.TimeoutSettings.TIMEOUT;
import static com.epam.jdi.tools.PathUtils.mergePath;
import static io.github.com.StaticSite.suspendHtml5Page;
import static io.github.com.pages.HtmlElementsPage.*;
import static io.github.epam.html.tests.elements.BaseValidations.baseValidation;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.apache.commons.io.FileUtils.writeStringToFile;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SuspendHtmlPageFileUploadTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        suspendHtml5Page.shouldBeOpened();
    }

    @Test
    public void uploadTest() {
        avatar.uploadFile(mergePath(PROJECT_PATH,"/src/test/resources/general.xml"));
        avatar.is().text(containsString("general.xml"));
        assertTrue(avatar.getText().contains("general.xml"));
        assertTrue(avatar.getValue().contains("general.xml"));
    }

    @Test
    public void disabledUploadTest() {
        TIMEOUT.set(2);
        try {
            disabledFileInput.uploadFile(mergePath(PROJECT_PATH, "/src/test/resources/general.xml"));
        } catch (Exception ignore) {}
        TIMEOUT.set(2);
        disabledFileInput.is().text(is(""));
    }
    @Test
    public void labelTest() {
        assertEquals(avatar.labelText(), "Profile picture:");
        avatar.label().is().text(containsString("picture"));
    }

    @Test
    public void downloadTest() {
        if (isFireFox()) return;
        cleanupDownloads();
        downloadJdiLogo.click();
        assertThatFile("jdi-logo.jpg")
            .isDownloaded()
            .hasSize(is(32225L));
        assertThatFile("jdi-logo.jpg").hasSize(greaterThan(100L));
    }
    private void createTextFile(String fileName) throws IOException {
        File txtFile = new File(mergePath(DOWNLOADS_DIR, fileName));
        writeStringToFile(txtFile,
                "Earth provides enough to satisfy every man's needs, but not every man's greed",
                "UTF-8");
    }
    @Test
    public void assertFileTest() throws IOException {
        cleanupDownloads();
        String fileName = "gandhi.txt";
        createTextFile(fileName);
        // Validate file in DOWNLOADS_DIR folder
        assertThatFile(fileName).text(containsString("enough to satisfy"));
    }
    @Test
    public void baseValidationTest() {
        baseValidation(avatar);
    }
}
