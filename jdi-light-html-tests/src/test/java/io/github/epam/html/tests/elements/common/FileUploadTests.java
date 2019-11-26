package io.github.epam.html.tests.elements.common;

import com.epam.jdi.tools.Timer;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static com.epam.jdi.light.asserts.core.FileAssert.assertThatFile;
import static com.epam.jdi.light.asserts.core.FileAssert.cleanupDownloads;
import static com.epam.jdi.light.driver.get.DriverData.DOWNLOADS_DIR;
import static com.epam.jdi.light.driver.get.DriverData.PROJECT_PATH;
import static com.epam.jdi.tools.PathUtils.mergePath;
import static io.github.com.StaticSite.html5Page;
import static io.github.com.pages.HtmlElementsPage.avatar;
import static io.github.com.pages.HtmlElementsPage.disabledFileInput;
import static io.github.com.pages.HtmlElementsPage.downloadJdiLogo;
import static io.github.epam.html.tests.elements.BaseValidationsUtils.baseValidation;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.apache.commons.io.FileUtils.writeStringToFile;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;

/**
 * Created by Roman Iovlev on 19.08.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public class FileUploadTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
    }

    @Test
    public void uploadTest() {
        avatar.uploadFile(mergePath(PROJECT_PATH, "/src/test/resources/general.xml"));
        avatar.is().text(containsString("general.xml"));
        avatar.is().value(containsString("general.xml"));
    }

    @Test
    public void disabledUploadTest() {
        try {
            disabledFileInput.uploadFile(mergePath(PROJECT_PATH, "/src/test/resources/general.xml"));
        } catch (Exception ignore) {
            disabledFileInput.is().value(is(""));
        }
        disabledFileInput.is().value(is(""));
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
        waitFileDownLoaded("jdi-logo.jpg", 32225L, 5L, 100L);
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
        // Validate file in DOWNLOADS_DFIR folder
        assertThatFile(fileName).text(containsString("enough to satisfy"));
    }

    @Test
    public void baseValidationTest() {
        baseValidation(avatar);
    }

    private void waitFileDownLoaded(String fileName, long fileLength, long secondsToWait, long pollMSec) {
        long i = 0;
        while (!(new File(mergePath(DOWNLOADS_DIR, fileName)).exists() &&
                new File(mergePath(DOWNLOADS_DIR, fileName)).length() >= fileLength)
                || secondsToWait > i) {
            i = i + pollMSec;
            Timer.sleep(pollMSec);
        }
    }
}
