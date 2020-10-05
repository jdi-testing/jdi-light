package io.github.epam.angular.tests.unit;

import io.github.com.pages.sections.SortingOverviewSection;
import io.github.epam.TestsInit;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;

public class SortingOverviewUnitTests extends TestsInit {

    private static final String DESSERT = "Dessert (100g)";

    @BeforeMethod(alwaysRun = true)
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void verifyTableIsVisible() {
        Assert.assertTrue(SortingOverviewSection.sortingOverview.getTableHeaders().isDisplayed());
    }

    @Test
    public void verifyHeaderButtonIsClicked() {
        SortingOverviewSection.sortingOverview.clickButtonByText(DESSERT);
        SortingOverviewSection.sortingOverview.clickButtonByText(DESSERT);
        Assert.assertTrue(SortingOverviewSection.sortingOverview.headerButtonIsClicked());
    }
}

