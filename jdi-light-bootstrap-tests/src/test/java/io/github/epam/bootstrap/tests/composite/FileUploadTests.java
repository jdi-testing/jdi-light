package io.github.epam.bootstrap.tests.composite;

import com.epam.jdi.light.common.ElementArea;
import com.sun.xml.internal.ws.api.ResourceLoader;
import io.github.epam.TestsInit;
import io.github.epam.states.States;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.asserts.core.FileAssert.cleanupDownloads;
import static com.epam.jdi.light.common.ElementArea.ACTION_CLICK;
import static com.epam.jdi.light.driver.get.DriverData.PROJECT_PATH;
import static com.epam.jdi.light.settings.WebSettings.ANY_ELEMENT;
import static com.epam.jdi.tools.PathUtils.mergePath;
import static com.sun.jmx.snmp.ThreadContext.contains;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.inputFileSection;
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
        assertThat(inputFileSection.fileInput.getValue(), equalTo(""));
        inputFileSection.fileInputBootstrap.uploadFile(mergePath(PROJECT_PATH,
                        "/src/test/resources/general.xml"));
        inputFileSection.fileInput.is().text(containsString("general.xml"));
        assertThat(inputFileSection.fileInput.getValue(), containsString("general.xml"));

    }

    @Test
    public void uploadTestAlt() {
        assertThat(inputFileSection.fileInput.getValue(), equalTo(""));
        inputFileSection.fileInput.uploadFile(mergePath(PROJECT_PATH,
                "/src/test/resources/general.xml"));
        inputFileSection.fileInput.is().text(containsString("general.xml"));
        assertThat(inputFileSection.fileInput.getValue(), containsString("general.xml"));
        clearInput();
    }

    @Test
    public void fileInputTest() {
        assertThat(inputFileSection.fileInput.getName(), equalTo("File Input"));
        assertThat(inputFileSection.fileInput.labelText(), equalTo("Example file input"));
    }

    private void clearInput() {
        inputFileSection.fileInput.click(ACTION_CLICK);
        inputFileSection.core().setup(jdiB -> jdiB.setSearchRule(ANY_ELEMENT)).sendKeys(Keys.ESCAPE);
    }


    /*@Test


    inputFileSection.fileInput.core().is()
                                         .attr("value", containsString("general.xml"))
            .displayed();
        inputFileSection.fileInput.labelText();
        document.getElementById("exampleFormControlFile1").type - file*/

/*


    @Test
    public void disabledUploadTest() {
        try {
            disabledFileInput.uploadFile(mergePath(PROJECT_PATH, "/src/test/resources/general.xml"));
        } catch (Exception ignore) {}
        disabledFileInput.is().text(is("C:\\fakepath\\general.xml"));
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
        // Validate file in DOWNLOADS_DFIR folder
        assertThatFile(fileName).text(containsString("enough to satisfy"));
    }
    @Test
    public void baseValidationTest() {
        baseValidation(avatar);
    }*/
}
