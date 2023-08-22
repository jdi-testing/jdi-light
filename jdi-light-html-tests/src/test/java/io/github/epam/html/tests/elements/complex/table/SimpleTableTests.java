package io.github.epam.html.tests.elements.complex.table;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.light.settings.JDISettings.ELEMENT;
import static io.github.com.StaticSite.tablePage;
import static io.github.com.pages.SimpleTablePage.simpleTable;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static java.util.Arrays.asList;
import static org.testng.Assert.assertEquals;

public class SimpleTableTests implements TestsInit {
    @BeforeClass
    public void before() {
        shouldBeLoggedIn();
        tablePage.shouldBeOpened();
        simpleTable.show();
    }

    @Test
    public void simpleTableParamsTest() {
        simpleTable.has().columns(asList("Drivers", "Selenium Custom", "JavaScript, Appium, WinAPI, Sikuli"))
                .and().exact(6);
    }
    @Test
    public void simpleTableInteractTest() {
        assertEquals(simpleTable.cell(ELEMENT.startIndex, ELEMENT.startIndex), "Drivers");
        assertEquals(simpleTable.cell(ELEMENT.startIndex + 2, ELEMENT.startIndex + 5), "Cucumber, Jbehave, Thucydides, SpecFlow");
    }
}
