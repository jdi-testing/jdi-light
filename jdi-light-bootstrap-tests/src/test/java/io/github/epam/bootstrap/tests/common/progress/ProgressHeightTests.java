package io.github.epam.bootstrap.tests.common.progress;

import io.github.com.sections.ProgressSection;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.progressHeightSections;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.testng.Assert.assertEquals;

public class ProgressHeightTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void baseValidationTest() {
        for (ProgressSection section : progressHeightSections) {
            baseValidation(section);
            section.unhighlight();
        }
    }

    @Test
    public void heightOfSectionShouldBeValid() {
        for (ProgressSection section : progressHeightSections) {
            int actualHeight = section.core().getSize().getHeight();
            int expectedHeight = section.getProgressSectionHeightValueInPx();
            assertEquals(actualHeight, expectedHeight);
        }
    }

    @Test
    public void heightOfBarShouldBeValid() {
        for (ProgressSection section : progressHeightSections) {
            int expectedBarHeight = section.getProgressSectionHeightValueInPx();
            section.progress.is().height(expectedBarHeight);
        }
    }
}
