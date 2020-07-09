package io.github.epam.angular.tests.unit;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.AngularPage.snackbarSection;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import com.epam.jdi.light.elements.composite.WebPage;

public class SnackbarUnitTests extends TestsInit{

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void visibleTest(){
        assertFalse(snackbarSection.basicSnackbar.isVisible());
        snackbarSection.openButton.click();
        assertTrue(snackbarSection.basicSnackbar.isVisible());
    }

}