package io.github.epam.example.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.asserts.core.FileAssert.assertThatFile;
import static com.epam.jdi.light.asserts.core.FileAssert.cleanupDownloads;
import static com.epam.jdi.light.driver.get.DriverData.PROJECT_PATH;
import static com.epam.jdi.tools.PathUtils.mergePath;
import static io.github.com.StaticSite.html5Page;
import static io.github.com.pages.HtmlElementsPage.avatar;
import static io.github.com.pages.HtmlElementsPage.downloadJdiLogo;
import static io.github.epam.html.tests.elements.BaseValidations.baseValidation;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;

public class FileInputExampleTests implements TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
    }

    @Test
    public void uploadTest() {
        avatar.uploadFile(mergePath(PROJECT_PATH, "/src/test/resources/general.xml"));
        avatar.is().text(containsString("general.xml"));
    }

    @Test
    public void labelTest() {
        avatar.label().is().text(containsString("picture:"));
    }

    @Test
    public void downloadTest() {
        cleanupDownloads();
        downloadJdiLogo.click();
        assertThatFile("jdi-logo.jpg")
                .isDownloaded()
                .hasSize(is(32225L));
        assertThatFile("jdi-logo.jpg").hasSize(greaterThan(100L));
    }

    @Test
    public void baseValidationTest() {
        baseValidation(avatar);
    }
}
