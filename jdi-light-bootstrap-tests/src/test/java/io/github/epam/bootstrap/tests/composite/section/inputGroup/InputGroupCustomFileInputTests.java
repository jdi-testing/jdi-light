package io.github.epam.bootstrap.tests.composite.section.inputGroup;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.customFileInput1;
import static io.github.com.pages.BootstrapPage.customFileInput2;
import static io.github.epam.states.States.shouldBeLoggedIn;

/**
 * Created by Olga Ivanova on 19.09.2019
 * Email: olga_ivanova@epam.com
 */

public class InputGroupCustomFileInputTests extends TestsInit {
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    public final static String UPLOAD_TEXT = "Upload";
    public final static String INPUT_FIELD = "Browser";
    public final static String LABEL_TEXT = "Choose file";

    //customFileInput1
    //customFileInput12
    @Test
    public void isValidationOptionsSectionTests() {


        customFileInput1.uploadText.is().text(UPLOAD_TEXT);
        customFileInput1.uploadText.is().value(UPLOAD_TEXT);

        customFileInput1.labelText.is().text(LABEL_TEXT);
        customFileInput1.labelText.is().value(LABEL_TEXT);

      //  customFileInput1.inputFiled.is().value(INPUT_FIELD);


        customFileInput2.uploadText.is().text(UPLOAD_TEXT);
        customFileInput2.uploadText.is().value(UPLOAD_TEXT);

        customFileInput2.labelText.is().text(LABEL_TEXT);
        customFileInput2.labelText.is().value(LABEL_TEXT);

/*      customFileInput1.optionText.is().text(optionText);
        customSelect.optionText.is()
                .core()
                .hasClass("input-group-prepend")
                .css("font-size", is("14px"))
                .tag("div");*/
    }
    @Test
    public void uploadTest() {

        String value =  customFileInput1.inputFiled.getValue();

/*        customFileInput1.inputFiled.uploadFile(mergePath(PROJECT_PATH,"/src/test/resources/general.xml"));
        customFileInput1.inputFiled.is().text(containsString("general.xml"));
        assertTrue(customFileInput1.inputFiled.getText().contains("general.xml"));
        assertTrue(customFileInput1.inputFiled.getValue().contains("general.xml"));*/

      /*  customFileInput2.inputFiled.uploadFile(mergePath(PROJECT_PATH,"/src/test/resources/general.xml"));
        customFileInput2.inputFiled.is().text(containsString("general.xml"));
        assertTrue(customFileInput2.inputFiled.getText().contains("general.xml"));
        assertTrue(customFileInput2.inputFiled.getValue().contains("general.xml"));*/
    }

    @Test
    public void disabledUploadTest() {
/*        try {
            disabledFileInput.uploadFile(mergePath(PROJECT_PATH, "/src/test/resources/general.xml"));
        } catch (Exception ignore) {}
        disabledFileInput.is().text(is("C:\\fakepath\\general.xml"));*/
    }
    @Test
    public void labelTest() {
/*        assertEquals(avatar.labelText(), "Profile picture:");
        avatar.label().is().text(containsString("picture"));*/
    }

    @Test
    public void downloadTest() {
      /*  if (isFireFox()) return;
        cleanupDownloads();
        downloadJdiLogo.click();
        assertThatFile("jdi-logo.jpg")
                .isDownloaded()
                .hasSize(is(32225L));
        assertThatFile("jdi-logo.jpg").hasSize(greaterThan(100L));*/
    }
    private void createTextFile(String fileName) throws IOException {
   /*     File txtFile = new File(mergePath(DOWNLOADS_DIR, fileName));
        writeStringToFile(txtFile,
                "Earth provides enough to satisfy every man's needs, but not every man's greed",
                "UTF-8");*/
    }
    @Test
    public void assertFileTest() throws IOException {
    /*    cleanupDownloads();
        String fileName = "gandhi.txt";
        createTextFile(fileName);
        // Validate file in DOWNLOADS_DFIR folder
        assertThatFile(fileName).text(containsString("enough to satisfy"));*/
    }
    @Test
    public void baseValidationTest() {
    //    baseValidation(avatar);
    }
    @Test
    public void selectorByIndexTests() {
/*        customSelect.selector.is().selected(selectChoose);
        customSelect.selector.select(2);
        customSelect.selector.is().selected(selectOne);
        customSelect.selector.select(3);
        customSelect.selector.is().selected(selectTwo);
        customSelect.selector.select(4);
        customSelect.selector.is().selected(selectThree);
        customSelect.selector.select(1);
        customSelect.selector.is().selected(selectChoose);*/
    }

    @Test(priority = 1)
    public void selectorByValueTests() {
/*        customSelect.selector.is().selected(selectChoose);
        customSelect.selector.select(selectOne);
        customSelect.selector.is().selected(selectOne);
        customSelect.selector.select(selectTwo);
        customSelect.selector.is().selected(selectTwo);
        customSelect.selector.select(selectThree);
        customSelect.selector.is().selected(selectThree);*/
    }

    @Test
    public void selectorIsValidationTests() {
/*        customSelect.selector.is().displayed()
                .enabled()
                .core()
                .hasClass("custom-select")
                .css("font-size", is("16px"));;
        customSelect.selector.is().size(4);*/
    }
}
