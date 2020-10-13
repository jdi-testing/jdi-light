package io.github.epam.angular.tests.unit;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.ExpansionPanelSection.accordionExpansionPanel;
import static io.github.com.pages.sections.ExpansionPanelSection.basicExpansionPanel;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ExpansionPanelUnitTests extends TestsInit {
    public static final String FIRST_NAME = "First name";
    public static final String AGE = "Age";
    public static final String COUNTRY = "Country";
    public static final String DATE = "Date";

    @BeforeMethod(alwaysRun = true)
    public void before() {
        shouldBeLoggedIn();
        angularPage.open();
        basicExpansionPanel.show();
    }

    @Test
    public void displayedTest() {
        assertTrue(basicExpansionPanel.isDisplayed() && accordionExpansionPanel.isDisplayed());
    }

    @Test
    public void expandByIndicatorTest() {
        basicExpansionPanel.expand(1);
        assertTrue(basicExpansionPanel.isExpanded(1));
    }

    @Test
    public void expandByIconTest() {
        accordionExpansionPanel.show();
        accordionExpansionPanel.expand(2);
        assertTrue(accordionExpansionPanel.isExpanded(2));
    }

    @Test
    public void collapseByIndicatorTest() {
        basicExpansionPanel.expand(2);
        basicExpansionPanel.collapse(2);
        assertTrue(basicExpansionPanel.isCollapsed(2));
    }

    @Test
    public void collapseByIconTest() {
        accordionExpansionPanel.show();
        accordionExpansionPanel.expand(3);
        accordionExpansionPanel.collapse(3);
        assertTrue(accordionExpansionPanel.isCollapsed(3));
    }

    @Test
    public void expandCollapseByIndicatorTest() {
        basicExpansionPanel.expand(2);
        basicExpansionPanel.expand(1);
        assertTrue(basicExpansionPanel.isExpanded(1) && basicExpansionPanel.isCollapsed(2));
    }

    @Test
    public void expandCollapseByIconTest() {
        accordionExpansionPanel.show();
        accordionExpansionPanel.expand(2);
        accordionExpansionPanel.expand(1);
        accordionExpansionPanel.expand(3);
        assertTrue(accordionExpansionPanel.isExpanded(3) && accordionExpansionPanel.isCollapsed(1)
                           && accordionExpansionPanel.isCollapsed(2));
    }

    @Test
    public void nextTest() {
        accordionExpansionPanel.show();
        accordionExpansionPanel.expand(1);
        accordionExpansionPanel.next("Personal data");
        accordionExpansionPanel.next("Destination");
        assertTrue(accordionExpansionPanel.isExpanded(3) && accordionExpansionPanel.isCollapsed(1)
                           && accordionExpansionPanel.isCollapsed(2));
    }

    @Test
    public void previousTest() {
        accordionExpansionPanel.show();
        accordionExpansionPanel.expand(3);
        accordionExpansionPanel.previous("Day of the trip");
        accordionExpansionPanel.previous("Destination");
        assertTrue(accordionExpansionPanel.isExpanded(1) && accordionExpansionPanel.isCollapsed(2)
                           && accordionExpansionPanel.isCollapsed(3));
    }

    @Test
    public void endTest() {
        accordionExpansionPanel.show();
        accordionExpansionPanel.expand(3);
        accordionExpansionPanel.end("Day of the trip");
        assertTrue(accordionExpansionPanel.isCollapsed(1) && accordionExpansionPanel.isCollapsed(2)
                           && accordionExpansionPanel.isCollapsed(3));
    }

    @Test
    public void inputTest() {
        String expectedName = "Ihar";
        String expectedAge = "45";
        basicExpansionPanel.expand(1);
        basicExpansionPanel.clear(FIRST_NAME);
        basicExpansionPanel.clear(AGE);
        basicExpansionPanel.input(FIRST_NAME, expectedName);
        basicExpansionPanel.input(AGE, expectedAge);
        assertTrue((expectedName.equalsIgnoreCase(basicExpansionPanel.value(FIRST_NAME)) && expectedAge
                .equalsIgnoreCase(basicExpansionPanel.value(AGE))));
    }

    @Test
    public void multiInputTest() {
        String expectedName = "Alexander";
        String expectedAge = "66";
        String expectedDestination = "Netherlands";
        String expectedDate = "9/30/2020";
        accordionExpansionPanel.show();
        accordionExpansionPanel.expand(1);
        accordionExpansionPanel.clear(FIRST_NAME);
        accordionExpansionPanel.clear(AGE);
        accordionExpansionPanel.input(FIRST_NAME, expectedName);
        accordionExpansionPanel.input(AGE, expectedAge);
        accordionExpansionPanel.expand(2);
        accordionExpansionPanel.clear(COUNTRY);
        accordionExpansionPanel.input(COUNTRY, expectedDestination);
        accordionExpansionPanel.expand(3);
        accordionExpansionPanel.input(DATE, expectedDate);
        accordionExpansionPanel.expand(1);
        assertTrue((expectedName.equalsIgnoreCase(accordionExpansionPanel.value(FIRST_NAME)) && expectedAge
                .equalsIgnoreCase(accordionExpansionPanel.value(AGE))));
        accordionExpansionPanel.expand(2);
        assertEquals(accordionExpansionPanel.value(COUNTRY), expectedDestination);
        accordionExpansionPanel.expand(3);
        assertEquals(accordionExpansionPanel.value(DATE), expectedDate);
    }

    @Test
    public void titleTest() {
        assertEquals(basicExpansionPanel.title(1), "Personal data");
        assertEquals(basicExpansionPanel.title(2), "Self aware panel");
    }

    @Test
    public void descriptionTest() {
        assertEquals(basicExpansionPanel.description(1), "Type your name and age");
        assertEquals(basicExpansionPanel.description(2), "Currently I am closed");
    }

    @Test
    public void variableDescriptionTest() {
        basicExpansionPanel.expand(2);
        assertEquals(basicExpansionPanel.description(2), "Currently I am open");
    }

    @Test
    public void contentTest() {
        basicExpansionPanel.expand(2);
        assertEquals(basicExpansionPanel.content(2), "I'm visible because I am open");
    }
}
