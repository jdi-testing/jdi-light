package io.github.epam.angular.tests.elements.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.ExpansionPanelSection.accordionExpansionPanel;
import static io.github.com.pages.sections.ExpansionPanelSection.basicExpansionPanel;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;

public class ExpansionPanelTests extends TestsInit {
    public static final String FIRST_NAME = "First name";
    public static final String AGE = "Age";
    public static final String COUNTRY = "Country";
    public static final String DATE = "Date";

    @BeforeMethod(alwaysRun = true)
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
        basicExpansionPanel.show();
    }

    @Test
    public void displayedTest() {
        basicExpansionPanel.is().displayed();
    }

    @Test
    public void expandByIndicatorTest() {
        basicExpansionPanel.expand(1);
        basicExpansionPanel.is().expanded(1);
    }

    @Test
    public void expandByIconTest() {
        accordionExpansionPanel.show();
        accordionExpansionPanel.expand(3);
        accordionExpansionPanel.is().expanded(3);
    }

    @Test
    public void collapseByIndicatorTest() {
        basicExpansionPanel.expand(2);
        basicExpansionPanel.collapse(2);
        basicExpansionPanel.is().collapsed(2);
    }

    @Test
    public void collapseByIconTest() {
        accordionExpansionPanel.show();
        accordionExpansionPanel.expand(3);
        accordionExpansionPanel.collapse(3);
        accordionExpansionPanel.is().collapsed(3);
    }

    @Test
    public void expandCollapseByIndicatorTest() {
        basicExpansionPanel.expand(2);
        basicExpansionPanel.expand(1);
        basicExpansionPanel.is().expanded(1).and().collapsed(2);
    }

    @Test
    public void expandCollapseByIconTest() {
        accordionExpansionPanel.show();
        accordionExpansionPanel.expand(2);
        accordionExpansionPanel.expand(1);
        accordionExpansionPanel.expand(3);
        accordionExpansionPanel.is().expanded(3).and().collapsed(1).and().collapsed(2);
    }

    @Test
    public void nextTest() {
        accordionExpansionPanel.show();
        accordionExpansionPanel.expand(1);
        accordionExpansionPanel.next("Personal data");
        accordionExpansionPanel.next("Destination");
        accordionExpansionPanel.is().expanded(3).and().collapsed(1).and().collapsed(2);
    }

    @Test
    public void previousTest() {
        accordionExpansionPanel.show();
        accordionExpansionPanel.expand(3);
        accordionExpansionPanel.previous("Day of the trip");
        accordionExpansionPanel.previous("Destination");
        accordionExpansionPanel.is().expanded(1).and().collapsed(2).and().collapsed(3);
    }

    @Test
    public void endTest() {
        accordionExpansionPanel.show();
        accordionExpansionPanel.expand(3);
        accordionExpansionPanel.end("Day of the trip");
        accordionExpansionPanel.is().collapsed(1).and().collapsed(2).and().collapsed(3);
    }

    @Test
    public void inputTest() {
        String expectedName = "Viktor";
        String expectedAge = "33";
        basicExpansionPanel.expand(1);
        basicExpansionPanel.clear(FIRST_NAME);
        basicExpansionPanel.clear(AGE);
        basicExpansionPanel.input(FIRST_NAME, expectedName);
        basicExpansionPanel.input(AGE, expectedAge);
        basicExpansionPanel.has().value(FIRST_NAME, expectedName).and().value(AGE, expectedAge);
    }

    @Test
    public void multiInputTest() {
        String expectedName = "Alex";
        String expectedAge = "25";
        String expectedDestination = "Spain";
        String expectedDate = "12/1/2019";
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
        accordionExpansionPanel.has().value(FIRST_NAME, expectedName).and().value(AGE, expectedAge);
        accordionExpansionPanel.expand(2);
        accordionExpansionPanel.has().value(COUNTRY, expectedDestination);
        accordionExpansionPanel.expand(3);
        accordionExpansionPanel.has().value(is(expectedDate), DATE);
    }

    @Test
    public void titleTest() {
        basicExpansionPanel.has().title("Personal data", 1);
        basicExpansionPanel.has().title(is("Self aware panel"), 2);
    }

    @Test
    public void descriptionTest() {
        basicExpansionPanel.has().description("Type your name and age", 1);
        basicExpansionPanel.has().description(is("Currently I am closed"), 2);
    }

    @Test
    public void variableDescriptionTest() {
        basicExpansionPanel.expand(2);
        basicExpansionPanel.has().description("Currently I am open", 2);
    }

    @Test
    public void contentTest() {
        basicExpansionPanel.expand(2);
        basicExpansionPanel.has().content("I'm visible because I am open", 2);
    }
}
