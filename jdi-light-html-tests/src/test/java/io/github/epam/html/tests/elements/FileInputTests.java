package io.github.epam.html.tests.elements;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.driver.get.DriverData.PROJECT_PATH;
import static com.epam.jdi.tools.PathUtils.mergePath;
import static io.github.com.StaticSite.htmlElementsPage;
import static io.github.com.pages.HtmlElementsPage.avatar;
import static io.github.epam.html.tests.elements.BaseValidations.baseValidation;
import static io.github.epam.html.tests.site.steps.Preconditions.shouldBeLoggedIn;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FileInputTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        htmlElementsPage.shouldBeOpened();
    }

    @Test
    public void uploadTest() {
        avatar.uploadFile(mergePath(PROJECT_PATH,"/src/test/resources/general.xml"));
        avatar.is().text(containsString("general.xml"));
        assertTrue(avatar.getText().contains("general.xml"));
        assertTrue(avatar.getValue().contains("general.xml"));
    }
    @Test
    public void labelTest() {
        assertEquals(avatar.labelText(), "Profile picture:");
        avatar.label().is().text(containsString("picture"));
    }


    @Test
    public void baseValidationTest() {
        baseValidation(avatar);
    }
}
