package io.github.epam.angular.tests.elements.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

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
        String textForTest = "My App";
        String classForTest = "mat-toolbar";
        toolbarTextArea.is().displayed();
        toolbarTable.is().hasClass(classForTest);
        toolbarTextArea.is().text(containsString(textForTest));
    }

    @Test
    public void multiRowToolbarTest() {
        String classForTest = "mat-toolbar";
        List<String> listForTest = Arrays.asList("Custom Toolbar", "Second Line", "Third Line");
        toolbarTable.is().displayed();
        toolbarTable.is().hasClass(classForTest);
        toolbarRowsElementsWithText.is().values(listForTest);
    }

    @Test
    public void multiRowToolbarColorTest() {
        String colorForTest = "primary";
        toolbarTable.has().attr("color", colorForTest);
    }
}