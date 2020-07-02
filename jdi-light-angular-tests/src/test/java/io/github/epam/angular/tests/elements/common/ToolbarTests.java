package io.github.epam.angular.tests.elements.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static io.github.com.pages.sections.ToolbarSection.*;
import static org.hamcrest.Matchers.containsString;

public class ToolbarTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void basicToolbarTest() {
        String textForTest= "My App";
        toolbarTextArea.is().displayed();
        toolbarTextArea.is().text(containsString(textForTest));
    }
}
